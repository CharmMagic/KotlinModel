package com.example.kotlinmodel.widget

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.kotlinmodel.MyApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

fun lauch(block: suspend CoroutineScope.() -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        block()
    }
}

internal fun Context.getResourceId(@AttrRes attribute: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attribute, typedValue, true)
    return typedValue.resourceId
}

@ColorInt
internal fun View.color(@ColorRes attribute: Int): Int = ContextCompat.getColor(context, attribute)

internal inline fun <reified T : Activity> showActivity(block: Intent.() -> Unit = {}) {
    val context = MyApplication.context
    val intent = Intent(context, T::class.java).apply(block)
    context.startActivity(intent)
}




