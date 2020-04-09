package com.example.kotlinmodel

import android.app.Dialog
import android.media.Image
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.example.kotlinmodel.base.BaseActivity
import com.example.kotlinmodel.net.ApiException
import com.example.kotlinmodel.utils.HttpSha1.getSha1
import com.example.kotlinmodel.viewmodel.MainViewModel
import com.example.kotlinmodel.widget.LoadingDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {
    override fun providerVMClass(): Class<MainViewModel>? = MainViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main
    private val loadingDialog by lazy { LoadingDialog(this) }
    override fun initView() {
        tv.setOnClickListener { viewModel.getdata() }
    }

    override fun initData() {
        loadingDialog.show()
        viewModel.postData.value = arrayOf("lbdfws", getSha1("123456"))



        viewModel.run {
            getLoginData().observe(this@MainActivity, Observer {

            })

            getError().observe(this@MainActivity, Observer {
                println("哈哈哈我报错了${(it as ApiException).code}")
            })
        }


    }

    private fun getData() {

    }


}
