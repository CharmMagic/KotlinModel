package com.example.kotlinmodel.base

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinmodel.utils.BarUtils

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)
        BarUtils.setStatusBarLightMode(this, true)
        setContentView(getLayoutId())
        initView()
        initData()
    }


    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun initData()


}