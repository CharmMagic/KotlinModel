package com.example.kotlinmodel.base

import com.example.kotlinmodel.net.ApiException
import com.example.kotlinmodel.net.ResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 *@Date 2020-01-02 19:31
 *
 *@Auther weiwenxiao
 */
open class BaseService {
    suspend fun <T : Any> request(call: suspend () -> ResponseData<T>): ResponseData<T> {
        return withContext(Dispatchers.IO) { call.invoke() }.apply {
            when {
                code != 0 -> throw ApiException(Throwable(error_msg), code)
            }
        }
    }
    suspend fun <T : Any> requestT(call: suspend () -> T): T {
        return withContext(Dispatchers.IO) { call.invoke() }
    }
}