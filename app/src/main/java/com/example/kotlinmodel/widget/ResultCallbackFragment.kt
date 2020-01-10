package com.example.kotlinmodel.widget

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class ResultCallbackFragment : Fragment() {
    var mCallback: ((Intent?) -> Unit)? = null
    var intent: Intent? = null
    var result_ok = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true//当设备旋转时，fragment会随托管activity一起销毁并重建。为true可保留fragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        startActivityForResult(intent, ContextConstant.START_ACTIVITY_FOR_RESULT_REQUEST_CODE)
        intent = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.remove(this)
            ?.commitAllowingStateLoss()
        if (resultCode == Activity.RESULT_OK && requestCode == ContextConstant.START_ACTIVITY_FOR_RESULT_REQUEST_CODE)
            mCallback?.invoke(data)
        else if (!result_ok && requestCode == ContextConstant.START_ACTIVITY_FOR_RESULT_REQUEST_CODE)
            mCallback?.invoke(data)
        mCallback = null
    }

    fun setCallbackAndIntent(
        callback: (Intent?) -> Unit,
        intent: Intent,
        result_ok: Boolean
    ): ResultCallbackFragment {
        mCallback = callback
        this.intent = intent
        this.result_ok = result_ok
        return this
    }
}

object ContextConstant {
    const val START_ACTIVITY_FOR_RESULT_REQUEST_CODE = 965//startActivityForResult方法所使用到的requestCode
    const val TAG = "ResultCallbackFragment"//startActivityForResult方法所使用到的查找fragment用的tag
}

/**
 * 使用callback的方式来执行startActivityForResult方法,就不用来回查找代码了,提高了可读性
 * 注意事项:会额外耗费一些资源(相当于new一个View)
 *
 * @param intent 跳转的intent
 * @param result_ok 是否去判断result_ok,如果是false,就不判断
 * @param callback 成功的回调
 */
fun FragmentActivity.startActivityForResult(
    intent: Intent,
    result_ok: Boolean = true,
    callback: (Intent?) -> Unit
) = supportFragmentManager
    .beginTransaction()
    .add(
        ResultCallbackFragment().setCallbackAndIntent(callback, intent, result_ok),
        ContextConstant.TAG
    )
    .commitAllowingStateLoss()//commit()和该方法的区别就是,这个方法不会去可以检查状态,而commit会检查状态(mStateSaved状态),如果状态不对则会抛异常

fun Fragment.startActivityForResult(
    intent: Intent,
    result_ok: Boolean = true,
    callback: (Intent?) -> Unit
) = activity!!.startActivityForResult(intent, result_ok, callback)

inline fun <reified A : Activity> FragmentActivity.startActivityForResult(
    initIntent: (intent: Intent) -> Unit = {},
    result_ok: Boolean = true,
    noinline callback: (Intent?) -> Unit
) = startActivityForResult(Intent(this, A::class.java).apply(initIntent), result_ok, callback)

inline fun <reified A : Activity> Fragment.startActivityForResult(
    initIntent: (intent: Intent) -> Unit = {},
    result_ok: Boolean = true,
    noinline callback: (Intent?) -> Unit
) = activity!!.startActivityForResult<A>(initIntent, result_ok, callback)
