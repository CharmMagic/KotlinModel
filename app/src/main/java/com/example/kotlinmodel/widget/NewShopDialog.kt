package com.example.kotlinmodel.widget

import android.app.Dialog
import android.content.Context
import com.example.kotlinmodel.common.MainService
import com.example.kotlinmodel.utils.HttpSha1

/**
 *
 *@Date 2020-01-28 17:35
 *
 *@Auther weiwenxiao
 */
class NewShopDialog(context: Context) : Dialog(context) {
    private val mainService by lazy { MainService() }
    init {
       lauch {
          val result =  mainService.postLogin("lbdfws", HttpSha1.getSha1("123456"))

       }
    }


}