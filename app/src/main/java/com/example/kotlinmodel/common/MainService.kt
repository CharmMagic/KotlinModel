package com.example.kotlinmodel.common

import com.example.kotlinmodel.base.BaseService
import com.example.kotlinmodel.bean.LoginBean
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
        //换肤大师发挥地方叫啥了
    }
}