package com.example.kotlinmodel.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.example.kotlinmodel.R
import com.example.kotlinmodel.adapter.rv.CommonAdapter
import com.example.kotlinmodel.adapter.rv.ViewHolder
import com.example.kotlinmodel.bean.Data
import com.example.kotlinmodel.bean.NewsBean

class NewsAdapter(context: Context?) : CommonAdapter<Data>(context) {
    override fun itemLayoutId(): Int = R.layout.item_school_layout

    override fun convert(holder: ViewHolder?, t: Data?, position: Int) {
        holder?.run {
            t?.run {
                setText(R.id.tv_content, title)
                Glide.with(mContext).load(thumbnail_pic_s).into(getView(R.id.iv_img))
                setVisible(R.id.tv_time, true)
                setText(R.id.tv_time, date)
            }
        }
    }
}