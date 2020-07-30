package com.example.kotlinmodel.fragment

import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.example.kotlinmodel.R
import com.example.kotlinmodel.activity.LinkWebActivity
import com.example.kotlinmodel.adapter.SchoolAdapter
import com.example.kotlinmodel.base.BaseVMFragment
import com.example.kotlinmodel.bean.SchoolBean
import com.example.kotlinmodel.viewmodel.SchoolViewModel
import kotlinx.android.synthetic.main.fragment_school_layout.*

class SchoolFragment : BaseVMFragment<SchoolViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_school_layout
    private val mAdapter by lazy { SchoolAdapter(mContext) }
    override fun providerVMClass(): Class<SchoolViewModel>? = SchoolViewModel::class.java
    override fun initView() {
        var bannerData = arrayListOf<SchoolBean>().apply {
            add(
                SchoolBean(
                    "俯卧撑",
                    "拥有超强臂力",
                    "https://puui.qpic.cn/qqvideo_ori/0/z06182n25z4_496_280/0",
                    "https://v.qq.com/x/cover/6vhe8qoxiodn3gz/z06182n25z4.html"
                )
            )
            add(
                SchoolBean(
                    "深蹲",
                    "痴迷深蹲十年",
                    "https://puui.qpic.cn/qqvideo_ori/0/x086598rhsm_496_280/0",
                    "https://v.qq.com/x/cover/6vhe8qoxiodn3gz/z06182n25z4.html"
                )
            )
            add(
                SchoolBean(
                    "引体向上",
                    "无借力向上",
                    "https://puui.qpic.cn/qqvideo_ori/0/k06142f6jtw_496_280/0",
                    "https://v.qq.com/x/cover/6vhe8qoxiodn3gz/z06182n25z4.html"
                )
            )
            add(
                SchoolBean(
                    "倒立",
                    "倒立的终极境界",
                    "https://puui.qpic.cn/qqvideo_ori/0/d0601axdb0z_496_280/0",
                    "https://v.qq.com/x/cover/6vhe8qoxiodn3gz/z06182n25z4.html"
                )
            )
            add(
                SchoolBean(
                    "平板支撑",
                    "打造完美腹部",
                    "https://puui.qpic.cn/qqvideo_ori/0/t0304w74nwq_496_280/0",
                    "https://v.qq.com/x/cover/6vhe8qoxiodn3gz/z06182n25z4.html"
                )
            )
            add(
                SchoolBean(
                    "卷腹",
                    "高效腹肌锻炼",
                    "https://puui.qpic.cn/qqvideo_ori/0/p0934zxwq5f_496_280/0",
                    "https://v.qq.com/x/cover/6vhe8qoxiodn3gz/z06182n25z4.html"
                )
            )
        }
        //轮播banners
        var bannerAdapter =
            BGABanner.Adapter<ImageView, SchoolBean> { banner, itemView, model, position ->
                itemView.scaleType = ImageView.ScaleType.FIT_XY
                Glide.with(mContext).load(model?.imgUrl).into(itemView!!)
            }
        bga.setDelegate { banner, itemView, model, position ->
            itemView.setOnClickListener {
                val data = (model as SchoolBean)
                LinkWebActivity.intentActivity(mContext, data.videoUrl, data.title)
            }
        }
        bga.setAdapter(bannerAdapter)
        bga.setData(bannerData, null)

        rv_list.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(mContext, 2)
        }
        mAdapter.setDataList(bannerData)

    }

    override fun lazyLoad() {
    }

}