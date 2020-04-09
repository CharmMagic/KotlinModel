package com.example.kotlinmodel.widget

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.kotlinmodel.R
import kotlinx.android.synthetic.main.dialog_loading_layout.*

/**
 *
 *@Date 2020-01-15 19:04
 *
 *@Auther weiwenxiao
 */
class LoadingDialog(context: Context): Dialog(context,R.style.TransparentDialog) {
    private var tvMsg: TextView
    private var progressBar: ProgressBar

    init {
        val mView = LayoutInflater.from(context).inflate(R.layout.dialog_loading_layout, null)
        setContentView(mView)
        tvMsg = mView.findViewById(R.id.tv_msg)
        progressBar = mView.findViewById(R.id.progress_bar)
    }

    fun setLoadingMsg(msg: String) {
        tvMsg.text = msg
    }
}