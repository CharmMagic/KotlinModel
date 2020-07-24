package com.example.kotlinmodel.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmodel.R
import com.example.kotlinmodel.net.ApiException
import com.example.kotlinmodel.widget.showToast
import retrofit2.HttpException


abstract class BaseVMFragment<VM : BaseViewModel> : Fragment() {
    private lateinit var viewModel: VM
    private var isLoading = true
    private var isToast = true
    private var isViewPrepare = false //视图是否加载完毕
    private var hasLoadData = false//数据是否加载过了
    private lateinit var mContext: Context
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(getLayoutId(), null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVM()
        super.onViewCreated(view, savedInstanceState)
        mContext = activity!!
        isViewPrepare = true
        initView()
        lazyLoadDataIfPrepared()
    }



    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }

    private fun startObserve() {
        viewModel.run {
            //加载
            getLoad().observe(this@BaseVMFragment, Observer {
                this@BaseVMFragment.isLoading = it
//                loadingDialog.show()
            })

            //Toast
            getToast().observe(this@BaseVMFragment, Observer { this@BaseVMFragment.isToast = it })

            //Net error
            getError().observe(this@BaseVMFragment, Observer {
                when (it) {
                    is ApiException -> {
                        if (isToast) mContext.showToast(it.cause?.message.toString())
                    }
                    is HttpException -> {
                        mContext.showToast(getString(R.string.service_error))
                    }
                    else -> {
                        println(it.printStackTrace())
                    }
                }
            })

            getEnd().observe(this@BaseVMFragment, Observer {

            })

        }
    }


    private fun initVM() {
        providerVMClass()?.let {
            viewModel = ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)
            ).get(it)
            lifecycle.addObserver(viewModel)
        }
    }

    private fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }


    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 初始化 ViewI
     */
    abstract fun initView()

    /**
     * 懒加载
     */
    abstract fun lazyLoad()

    abstract fun providerVMClass(): Class<VM>?

}