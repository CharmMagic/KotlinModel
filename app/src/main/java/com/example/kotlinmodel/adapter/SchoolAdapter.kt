package com.example.kotlinmodel.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.example.kotlinmodel.R
import com.example.kotlinmodel.activity.SchoolListActivity
import com.example.kotlinmodel.adapter.rv.CommonAdapter
import com.example.kotlinmodel.adapter.rv.ViewHolder
import com.example.kotlinmodel.bean.SchoolBean
import org.jetbrains.anko.startActivity

class SchoolAdapter(context: Context?) : CommonAdapter<SchoolBean>(context) {
    override fun itemLayoutId(): Int = R.layout.item_school_list_layout
     private var itemClick:((position:Int)->Unit)?=null
    fun itemCallBack( itemClick:((position:Int)->Unit)?=null){
        this.itemClick= itemClick
    }
    override fun convert(holder: ViewHolder?, t: SchoolBean?, position: Int) {
        holder?.run {
            t?.run {
                setText(R.id.tv_title, title)
                setText(R.id.tv_content, content)
                Glide.with(mContext).load(imgUrl).into(getView(R.id.iv_img))
                itemView.setOnClickListener {
                    mContext.startActivity<SchoolListActivity>("type" to position)
                }
            }
        }
    }
}