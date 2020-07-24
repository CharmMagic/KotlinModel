package com.example.kotlinmodel


import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.kotlinmodel.base.BaseVMActivity
import com.example.kotlinmodel.bean.Tab
import com.example.kotlinmodel.fragment.NewsFragment
import com.example.kotlinmodel.fragment.SchoolFragment
import com.example.kotlinmodel.viewmodel.MainViewModel
import com.example.kotlinmodel.widget.FragmentTabHost
import java.util.ArrayList
import kotlin.system.exitProcess


class MainActivity : BaseVMActivity<MainViewModel>() {
    override fun providerVMClass(): Class<MainViewModel>? = MainViewModel::class.java
    private lateinit var mTabHost: FragmentTabHost
    override fun getLayoutId(): Int = R.layout.activity_main
    private val mTabs = ArrayList<Tab>(4)
    private lateinit var tabSpec: TabHost.TabSpec
    private lateinit var mInflater: LayoutInflater
    override fun initView() {
        initTab()
    }

    override fun initData() {
    }

    //初始化Tab栏
    private fun initTab() {
        val tabHome = Tab(R.drawable.app_tab_1, R.string.tab_one, SchoolFragment::class.java)
        val tabLocal = Tab(R.drawable.app_tab_2, R.string.tab_two, NewsFragment::class.java)
        mTabs.add(tabHome)
        mTabs.add(tabLocal)
        mTabHost = findViewById<View>(R.id.tabhost) as FragmentTabHost
        mTabHost.setup(this, supportFragmentManager, R.id.fl_main_content)
        mInflater = LayoutInflater.from(this)
        for (i in mTabs.indices) {
            tabSpec = mTabHost.newTabSpec(mTabs[i].text.toString())
            val viewTab: View = buildView(mTabs[i])
            tabSpec.setIndicator(viewTab)
            mTabHost.addTab(tabSpec, mTabs[i].fragment, null)
        }
        //通过这行代码可以去除掉底部菜单5个图表之间的分割线
        mTabHost.tabWidget.showDividers = LinearLayout.SHOW_DIVIDER_NONE
    }

    //设置Indicator中的View
    private fun buildView(tab: Tab): View {
        val view = mInflater.inflate(R.layout.app_tab_indicator, null)
        val tabImg = view.findViewById<View>(R.id.tab_img) as ImageView
        val tabTxt = view.findViewById<View>(R.id.tab_text) as TextView
        tabImg.setBackgroundResource(tab.image)
        tabTxt.setText(tab.text)
        return view
    }

    private var preTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (System.currentTimeMillis() - preTime > 2000) {
                Toast.makeText(this@MainActivity, getString(R.string.once_again_exit_app), Toast.LENGTH_SHORT).show()
                preTime = System.currentTimeMillis()
            } else {
                finish()
                exitProcess(0)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}
