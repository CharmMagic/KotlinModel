package com.example.kotlinmodel

import androidx.lifecycle.Observer
import com.example.kotlinmodel.base.BaseActivity
import com.example.kotlinmodel.net.ApiException
import com.example.kotlinmodel.utils.HttpSha1
import com.example.kotlinmodel.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override fun providerVMClass(): Class<MainViewModel>? = MainViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
    }

    override fun initData() {

        viewModel.postData.value = arrayOf("lbdfws", HttpSha1.getSha1(  "123456"))

       viewModel.run {
           getLoginData().observe(this@MainActivity, Observer {

           })

           getError().observe(this@MainActivity, Observer {
             println("哈哈哈我报错了${(it as ApiException).code}")
           })
       }

    }


}
