package com.example.kotlinmodel.common

import com.example.kotlinmodel.bean.LoginBean
import com.example.kotlinmodel.net.ResponseData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

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
}