package com.example.kotlinmodel.net

import android.util.Log
import com.example.kotlinmodel.common.ApiService
import com.example.kotlinmodel.common.Constants
import com.example.kotlinmodel.common.HttpApi
import com.example.kotlinmodel.utils.HttpSha1
import com.example.kotlinmodel.utils.Preference
import com.example.kotlinmodel.utils.TimeUtils
import com.example.kotlinmodel.widget.ContextConstant.TAG
import com.google.gson.GsonBuilder
import okhttp3.*
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/**
 *
 *@Date 2019-12-26 14:12
 *
 *@Auther weiwenxiao
 */
object RetrofitManager {
    private val UTF8 = Charset.forName("UTF-8")
    val service: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(HttpApi.URL_BASE_TEST_IP)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        //设置 请求的缓存的大小跟位置
//        val cacheFile = File(MyApplication.context.cacheDir, "cache")
//        val cache = Cache(cacheFile, 1024 * 1024 * 50) //50Mb 缓存的大小
        return OkHttpClient.Builder()
            .addInterceptor(mutiBaseUrlInterceptor())
            .addInterceptor(addQueryParameterInterceptor())
            .addInterceptor(baseRequestHeaderInterceptor())
            .addInterceptor(logInterceptor()) //日志,所有的请求响应度看到
            .retryOnConnectionFailure(false)
            .cookieJar(object : CookieJar {
                var cookMap = HashMap<String, MutableList<Cookie>>()
                override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
                    cookMap[url.host()] = cookies
                }

                override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
                    var cookies = cookMap[url.host()]
                    return if (cookies.isNullOrEmpty()) arrayListOf() else cookies
                }

            }).build()
    }


    /**
     * 设置公共参数
     *
     */

    private fun baseRequestHeaderInterceptor(): Interceptor {

        return Interceptor { chain ->
            var newBuilder = chain.request().newBuilder()

            val token by Preference(Constants.USER_TOKEN, "")
            newBuilder.addHeader("token", token)
            newBuilder.addHeader("Connection", "close")
            var proceed = chain.proceed(newBuilder.build())
            println("TOKEN====$token")
            proceed
        }
    }


    /**
     * 设置BaseUrl
     *
     */

    private fun mutiBaseUrlInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()
            var newBuilder = request.newBuilder()
            var headers = request.headers("url_name")
            if (!headers.isNullOrEmpty()) {
                newBuilder.removeHeader("url_name")
                var headValue = headers[0]
                var newBaseUrl: HttpUrl
                newBaseUrl = when (headValue) {
                    HttpApi.UPDOWNLOAD_KEY -> HttpUrl.parse(HttpApi.APPUP_IP)!!
                    else -> HttpUrl.parse(HttpApi.URL_BASE_TEST_IP)!!
                }

                var oldHttpUrl = request.url()
                var newFullUrl = oldHttpUrl
                    .newBuilder()
                    .scheme(newBaseUrl.scheme())
                    .host(newBaseUrl.host())
                    .port(newBaseUrl.port())
                    .build()
                var splitUrl = newFullUrl.toString().split(HttpApi.URL_BASE_TEST_IP)
                chain.proceed(newBuilder.url(splitUrl[0] + "/api/" + splitUrl[1]).build())

            } else {
                chain.proceed(request)
            }


        }
    }


    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request = chain.request()
            var httpUrl = request.url()
            var headers = request.headers("sigUrl")
            if (!headers.isNullOrEmpty()) {
                var baseUrl = "${HttpApi.URL_BASE_PREFIX}${headers[0]}"
                request.newBuilder().removeHeader("sigUrl")
                var nonce = Random(Int.MAX_VALUE).nextInt().toString()
                var ts =
                    TimeUtils.milliseconds2Unit(System.currentTimeMillis(), TimeUtils.TimeUnit.SEC)
                        .toString()
                val token by Preference(Constants.USER_TOKEN, "")
                val userId by Preference(Constants.USER_USER_ID, "")
                val serviceId by Preference(Constants.USER_SERVICE_ID, "")
                val userRole by Preference(Constants.USER_ROLE, "")
                val groupType by Preference(Constants.USER_GROUP_TYPE, "")

                var jsonBody = ""
                val paramsMap = HashMap<String, String>()
                if (!userId.isNullOrBlank()) {
                    paramsMap["user_id"] = userId
                }

                if (!serviceId.isNullOrBlank()) {
                    paramsMap["service_id"] = serviceId
                    paramsMap["belong_to"] = serviceId
                }
                if (!userRole.isNullOrBlank()) {
                    paramsMap["role"] = userRole
                }

                if (!groupType.isNullOrBlank()) {
                    paramsMap["group_type"] = groupType
                }
                paramsMap["endpoint_type"] = "APP"
                paramsMap["sys_source"] = "ANDROID"
                paramsMap["sys_version"] = Constants.SYS_VERSION
                paramsMap["ts"] = ts
                paramsMap["nonce"] = nonce
                var newBuilder = httpUrl.newBuilder()
                for ((key, value) in paramsMap) {
                    newBuilder.addEncodedQueryParameter(key, value)
                }

                when (request.method()) {
                    "GET" -> {
                        var queryParameterNames = httpUrl.queryParameterNames()
                        for (key in queryParameterNames) {
                            paramsMap[key] = httpUrl.queryParameter(key) ?: ""
                        }
                    }

                    "POST" -> {
                        var body = request.body()
                        body?.let {
                            if (body is FormBody) {
                                repeat(body.size()) {
                                    paramsMap[body.encodedName(it)] = body.encodedValue(it)
                                }
                            } else {
                                var buffer = Buffer()
                                body.writeTo(buffer)
                                var charset: Charset = UTF8
                                var contentType = body.contentType()
                                contentType?.let {
                                    charset = contentType.charset(UTF8)!!
                                }

                                charset?.let {
                                    jsonBody = buffer.readString(charset)
                                }

                            }
                        }
                    }
                }

                //2ae849ff090b7205566e268123473e700d6957ce
                //7c4a8d09ca3762af61e59520943dc26494f8941b
                newBuilder.addEncodedQueryParameter(
                    "sig",
                    HttpSha1.getSha1(HttpSha1.getHttpSigString(paramsMap, token, baseUrl, jsonBody))
                )
                request = request.newBuilder().url(newBuilder.build()).build()
                println("sig测试${HttpSha1.getHttpSigString(paramsMap, token, baseUrl, jsonBody)}")
                println(
                    "sig校验${HttpSha1.getSha1(
                        HttpSha1.getHttpSigString(
                            paramsMap,
                            token,
                            baseUrl,
                            jsonBody
                        )
                    )}"
                )


            }

            chain.proceed(request)
        }
    }

    fun logInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val requestBody = request.body()
            var body: String? = null
            requestBody?.let {
                val buffer = Buffer()
                requestBody.writeTo(buffer)
                var charset: Charset? = UTF8
                val contentType = requestBody.contentType()
                contentType?.let {
                    charset = contentType.charset(UTF8)
                }
                body = buffer.readString(charset!!)
            }

            println(
                "发送请求: method：" + request.method()
                        + "\nurl：" + request.url()
                        + "\n请求头：" + request.headers()
                        + "\n请求参数: " + body)

            val startNs = System.nanoTime()
            val response = chain.proceed(request)
            val tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs)

            val responseBody = response.body()
            val rBody: String

            val source = responseBody!!.source()
            source.request(java.lang.Long.MAX_VALUE)
            val buffer = source.buffer()

            var charset: Charset? = UTF8
            val contentType = responseBody.contentType()
            contentType?.let {
                try {
                    charset = contentType.charset(UTF8)
                } catch (e: UnsupportedCharsetException) {
                    println(e.message)
                }
            }
            rBody = buffer.clone().readString(charset!!)

            println("收到响应: code:" + response.code()
                        + "\n请求url：" + response.request().url()
                        + "\n请求body：" + body
                        + "\nResponse: " + rBody)

            response
        }
    }

}