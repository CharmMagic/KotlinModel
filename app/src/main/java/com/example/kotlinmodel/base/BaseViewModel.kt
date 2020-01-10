package com.example.kotlinmodel.base

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.lang.Exception

open class BaseViewModel : ViewModel(), LifecycleObserver {
    private val loadAction by lazy { MutableLiveData<Boolean>() }
    private val toastAction by lazy { MutableLiveData<Boolean>() }
    private val error by lazy { MutableLiveData<Exception>() }
    private val endAction by lazy { MutableLiveData<Int>() }


    fun launchUI(
        isToast: Boolean? = true,
        isLoading: Boolean? = true,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch {
        loadAction.value = isLoading
        toastAction.value = isToast
        try {
            block()
        } catch (e: Exception) {
            error.value = e
        } finally {
            endAction.value = 200
        }
    }


    fun getError(): LiveData<Exception> = error

    fun getLoad(): LiveData<Boolean> = loadAction

    fun getToast(): LiveData<Boolean> = toastAction

    fun getEnd(): LiveData<Int> = endAction

}