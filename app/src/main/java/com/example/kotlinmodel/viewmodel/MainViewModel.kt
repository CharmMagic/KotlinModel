package com.example.kotlinmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmodel.base.BaseViewModel
import com.example.kotlinmodel.bean.LoginBean
import com.example.kotlinmodel.common.MainService

class MainViewModel : BaseViewModel() {
    private val userData: MutableLiveData<LoginBean> =
        MutableLiveData<LoginBean>().also { getdata() }
    var postData: MutableLiveData<Array<String>> = MutableLiveData()
    private val mainService by lazy { MainService() }
    fun getLoginData(): LiveData<LoginBean> {
        return userData
    }

    private fun getdata() = launchUI(isLoading = true) {
        print("开始了啊")
        val result = mainService.postLogin(postData.value?.get(0)!!, postData.value?.get(1)!!)
        userData.value = result.data

    }


}