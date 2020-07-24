package com.example.kotlinmodel.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    var isFragmentPager = false
    private var isLoadView = false
    var rootView: View? = null
    var mContext: Context? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (isFragmentPager) {
            init(inflater, container)
        } else {
            isLoadView = false
            if (rootView == null) {
                isLoadView = true
                init(inflater, container)
            }

            // 解决fragment UI重复加载

            // 解决fragment UI重复加载
            val parent = rootView!!.parent as ViewGroup
            parent?.removeView(rootView)
        }
        return rootView

    }

    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        initRootView(inflater, container)
    }

    private fun initRootView(inflater: LayoutInflater, container: ViewGroup?) {
        rootView = inflater.inflate(getLayoutId(), container, false)
        mContext = activity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //是否重新加载视图
        //初始化为什么要放在OnActivityCreated
        //该生命周期回调时，View才算加载完毕
        //否则使用懒加载会报NULL
        //是否重新加载视图
        //初始化为什么要放在OnActivityCreated
        //该生命周期回调时，View才算加载完毕
        //否则使用懒加载会报NULL
        if (isLoadView) {
            initView(rootView)
            initData()
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initView(view: View?)

    abstract fun initData()
}