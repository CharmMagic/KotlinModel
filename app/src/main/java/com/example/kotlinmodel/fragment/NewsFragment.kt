package com.example.kotlinmodel.fragment

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.kotlinmodel.R
import com.example.kotlinmodel.adapter.NewsAdapter
import com.example.kotlinmodel.base.BaseVMFragment
import com.example.kotlinmodel.utils.HttpSha1
import com.example.kotlinmodel.viewmodel.MainViewModel
import com.example.kotlinmodel.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news_layout.*

class NewsFragment : BaseVMFragment<NewsViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_news_layout
    private val mAdapter by lazy { NewsAdapter(mContext) }
    override fun initView() {
        rv_list.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(mContext)

        }


        viewModel.userData.observe(this, Observer {
            mAdapter.setDataList(it.result.data)
        })


    }

    override fun lazyLoad() {
        viewModel.getNewsData()
    }

    override fun providerVMClass(): Class<NewsViewModel>? = NewsViewModel::class.java

}