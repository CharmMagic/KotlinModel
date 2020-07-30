package com.example.kotlinmodel.common

import com.example.kotlinmodel.base.BaseService
import com.example.kotlinmodel.bean.LoginBean
import com.example.kotlinmodel.bean.NewsBean
import com.example.kotlinmodel.bean.WordsBean
import com.example.kotlinmodel.net.ResponseData
import com.example.kotlinmodel.net.RetrofitManager

/**
 *
 *@Date 2020-01-02 19:36
 *
 *@Auther weiwenxiao
 */
class MainService : BaseService() {

    suspend fun postLogin(account: String, password: String): ResponseData<LoginBean> = request {
        RetrofitManager.service.login("APP", "100", account, password)
    }

    suspend fun getNews(): NewsBean = requestT {
        RetrofitManager.service.news("10da3bffd098433cf23d1090304499b8")
    }


}