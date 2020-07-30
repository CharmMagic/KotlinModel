package com.example.kotlinmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmodel.base.BaseViewModel
import com.example.kotlinmodel.bean.LoginBean
import com.example.kotlinmodel.bean.WordsBean
import com.example.kotlinmodel.common.MainService

class WordsViewModel : BaseViewModel() {
    private val mainService by lazy { MainService() }
    private val userData: MutableLiveData<WordsBean> =
        MutableLiveData()

    fun getWordsData(): LiveData<WordsBean> {
        return userData
    }

    fun getWords() = launchUI {

    }
}