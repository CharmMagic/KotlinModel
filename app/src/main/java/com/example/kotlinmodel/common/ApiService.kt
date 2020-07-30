package com.example.kotlinmodel.common

import com.example.kotlinmodel.bean.LoginBean
import com.example.kotlinmodel.bean.NewsBean
import com.example.kotlinmodel.bean.WordsBean
import com.example.kotlinmodel.net.ResponseData
import retrofit2.http.*

interface ApiService {
    @POST(HttpApi.LOGIN)
    @FormUrlEncoded
    suspend fun login(
        @Field("endpoint_type") endpoint_type: String, @Field("login_type") login_type: String, @Field(
            "account"
        ) account: String, @Field(
            "password"
        ) password: String
    ): ResponseData<LoginBean>

    @GET("http://v.juhe.cn/toutiao/index")
    suspend fun news(@Query("key") key:String): NewsBean
}