package com.example.kotlinmodel.utils

import java.security.MessageDigest
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 *@Date 2019-12-26 20:24
 *
 *@Auther weiwenxiao
 */
object HttpSha1 {

    fun getHttpSigString(
        paramsKey: Map<String, String>,
        token: String,
        baseUrl: String,
        jsonBody: String
    ): String {
        var params: List<String> = ArrayList(paramsKey.keys)
        Collections.sort(params)
        var returnString = StringBuilder()
        params.forEach {
            returnString.append(it).append("=").append(paramsKey[it])
            returnString.append("&")
        }

        var sigStr = "$baseUrl?$returnString"
        if (!jsonBody.isNullOrBlank()) {
            sigStr += "$jsonBody&"
        }
        sigStr += token
        return sigStr
    }

    fun getSha1(str: String): String {
        val digest = MessageDigest.getInstance("SHA-1")
        val result = digest.digest(str.toByteArray())
        return toHex(result)

    }


    private fun toHex(byteArray: ByteArray): String {
        //转成16进制后是32字节
        return with(StringBuilder()) {
            byteArray.forEach {
                val hex = it.toInt() and (0xFF)
                val hexStr = Integer.toHexString(hex)
                if (hexStr.length == 1) {
                    append("0").append(hexStr)
                } else {
                    append(hexStr)
                }
            }
            toString()
        }
    }

}