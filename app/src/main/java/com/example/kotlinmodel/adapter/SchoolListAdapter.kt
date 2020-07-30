package com.example.kotlinmodel.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.example.kotlinmodel.R
import com.example.kotlinmodel.adapter.rv.CommonAdapter
import com.example.kotlinmodel.adapter.rv.ViewHolder
import com.example.kotlinmodel.bean.SchoolBean

class SchoolListAdapter(context: Context?) : CommonAdapter<SchoolBean>(context) {
    override fun itemLayoutId(): Int = R.layout.item_school_layout

    override fun convert(holder: ViewHolder?, t: SchoolBean?, position: Int) {
        holder?.run {
            t?.run {
                setText(R.id.tv_content, content)
                Glide.with(mContext).load(imgUrl).into(getView(R.id.iv_img))
            }
        }

    }
}