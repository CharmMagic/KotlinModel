package com.example.kotlinmodel.fragment

import com.example.kotlinmodel.R
import com.example.kotlinmodel.base.BaseVMFragment
import com.example.kotlinmodel.viewmodel.SchoolViewModel

class NewsFragment : BaseVMFragment<SchoolViewModel>() {
    override fun getLayoutId(): Int= R.layout.fragment_news_layout


    override fun initView() {
    }

    override fun lazyLoad() {
    }

    override fun providerVMClass(): Class<SchoolViewModel>? = SchoolViewModel::class.java

}