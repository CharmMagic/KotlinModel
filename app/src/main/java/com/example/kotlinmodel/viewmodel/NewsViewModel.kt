package com.example.kotlinmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmodel.base.BaseViewModel
import com.example.kotlinmodel.bean.NewsBean
import com.example.kotlinmodel.common.MainService

class NewsViewModel : BaseViewModel() {
    var userData = MutableLiveData<NewsBean>()
    private val mainService by lazy { MainService() }

    fun getNewsData() = launchUI {
        val result = mainService.getNews()
        userData.value = result
    }

}