package com.example.kotlinmodel.activity

import android.net.Uri
import com.example.kotlinmodel.MainActivity
import com.example.kotlinmodel.R
import com.example.kotlinmodel.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash_layout.*
import org.jetbrains.anko.startActivity


class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_splash_layout
    override fun initView() {
        val mUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.intro)
        vv.setVideoURI(mUri)
        vv.start()

        vv.setOnCompletionListener {
            startActivity<MainActivity>()
            finish()
        }
    }


    override fun initData() {
    }
}