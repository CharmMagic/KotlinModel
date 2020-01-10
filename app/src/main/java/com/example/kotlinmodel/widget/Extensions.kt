package com.example.kotlinmodel.widget

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 *
 *@Date 2019-12-26 13:26
 *
 *@Auther weiwenxiao
 */


fun Context.showToast(txt: String, duration: Int? = Toast.LENGTH_SHORT): Toast {
    var toast = Toast.makeText(this, txt, duration!!)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
    return toast
}


fun View.dip2px(dipValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

fun View.px2dip(pxValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()

}

fun CoroutineScope.lauch(context: CoroutineContext) {
    launch(context) {

    }
}

