package com.example.kotlinmodel.activity

import android.content.Context
import android.content.Intent
import com.example.kotlinmodel.R
import com.example.kotlinmodel.base.BaseActivity
import com.example.kotlinmodel.common.Constants
import com.tencent.smtt.sdk.WebSettings
import kotlinx.android.synthetic.main.activity_linkweb_layout.*

class LinkWebActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_linkweb_layout

    companion object {
        fun intentActivity(
            context: Context,
            url: String?,
            title: String?
        ) {
            val intent = Intent(context, LinkWebActivity::class.java)
            intent.putExtra(Constants.HTML_URL, url)
            intent.putExtra(Constants.TITLE, title)
            context.startActivity(intent)
        }
    }


    override fun initView() {
        val html = intent.getStringExtra(Constants.HTML_URL) ?: ""
        val title = intent.getStringExtra(Constants.TITLE) ?: ""
        web_view.loadUrl(html)
        val webSettings: WebSettings = web_view.settings
        webSettings.javaScriptEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口

//        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。 这个取决于setSupportZoom(), 若setSupportZoom(false)，则该WebView不可缩放，这个不管设置什么都不能缩放。
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。 这个取决于setSupportZoom(), 若setSupportZoom(false)，则该WebView不可缩放，这个不管设置什么都不能缩放。
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.loadsImagesAutomatically = true //支持自动加载图片

        webSettings.defaultTextEncodingName = "utf-8" //设置编码格式

    }

    override fun initData() {
    }

}