package com.example.kotlinmodel.base

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmodel.R
import com.example.kotlinmodel.net.ApiException
import com.example.kotlinmodel.utils.BarUtils
import com.example.kotlinmodel.widget.LoadingDialog
import com.example.kotlinmodel.widget.showToast
import retrofit2.HttpException


abstract class BaseVMActivity<VM : BaseViewModel> : AppCompatActivity() {
     lateinit var viewModel: VM
    private var isLoading = true
    private var isToast = true
    private val loadingDialog by lazy { LoadingDialog(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        initVM()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT)
        BarUtils.setStatusBarLightMode(this, true)
        initView()
        initData()
        startObserve()

    }


    private fun initVM() {
        providerVMClass()?.let {
            viewModel = ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(it)
            lifecycle.addObserver(viewModel)
        }
    }

    private fun startObserve() {
        viewModel.run {
            //加载
            getLoad().observe(this@BaseVMActivity, Observer {
                this@BaseVMActivity.isLoading = it
                loadingDialog.show()
            })

            //Toast
            getToast().observe(this@BaseVMActivity, Observer { this@BaseVMActivity.isToast = it })

            //Net error
            getError().observe(this@BaseVMActivity, Observer {
                when (it) {
                    is ApiException -> {
                        if (isToast) showToast(it.cause?.message.toString())
                    }
                    is HttpException -> {
                        showToast(getString(R.string.service_error))
                    }
                    else -> {
                        println(it.printStackTrace())
                    }
                }
            })

            getEnd().observe(this@BaseVMActivity, Observer {

            })

        }
    }

    abstract fun providerVMClass(): Class<VM>?


    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(viewModel)
    }


}