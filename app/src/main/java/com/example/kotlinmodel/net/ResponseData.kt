package com.example.kotlinmodel.net

/**
 *
 *@Date 2019-12-26 14:07
 *
 *@Auther weiwenxiao
 */
data class ResponseData<out T>(val code: Int, val error_msg: String, val data: T)