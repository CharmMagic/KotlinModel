package com.example.kotlinmodel

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 *
 *@Date 2019-12-26 16:58
 *
 *@Auther weiwenxiao
 */
class MyApplication : Application() {
    companion object {
        var context: Context by Delegates.notNull()
            private set
    }


    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}