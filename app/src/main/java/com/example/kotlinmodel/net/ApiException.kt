package com.example.kotlinmodel.net

import java.lang.Exception

/**
 *
 *@Date 2019-12-26 13:59
 *
 *@Auther weiwenxiao
 */
class ApiException : Exception {
     var code: Int? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(msg: String) : super(Throwable(msg))
}