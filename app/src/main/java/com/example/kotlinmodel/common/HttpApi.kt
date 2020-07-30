package com.example.kotlinmodel.common

/**
 *
 *@Date 2019-12-26 14:17
 *
 *@Auther weiwenxiao
 */
class HttpApi private constructor() {
    companion object {
        const val URL_BASE_TEST_IP = "https://saas-test1.banmacang.com/bmc_chain/1.0/"//测试环境
        const val URL_BASE_PREFIX = "/bmc_chain/1.0/"
        const val UPDOWNLOAD_KEY = "UPDOWNLOAD_KEY"
        const val APPUP_IP = "http://api.banmacang.com/api/" //线上环境
        const val LOGIN = "account/login" //登录

    }
}
