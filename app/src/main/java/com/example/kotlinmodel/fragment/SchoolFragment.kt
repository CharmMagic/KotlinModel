package com.example.kotlinmodel.fragment

import com.example.kotlinmodel.R
import com.example.kotlinmodel.base.BaseVMFragment
import com.example.kotlinmodel.viewmodel.SchoolViewModel

class SchoolFragment : BaseVMFragment<SchoolViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_school_layout


    override fun providerVMClass(): Class<SchoolViewModel>? = SchoolViewModel::class.java
    override fun initView() {

    }

    override fun lazyLoad() {
    }

}