package com.example.kotlinmodel.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmodel.R
import com.example.kotlinmodel.adapter.SchoolListAdapter
import com.example.kotlinmodel.base.BaseActivity
import com.example.kotlinmodel.bean.SchoolBean
import kotlinx.android.synthetic.main.activity_school_list_layout.*

class SchoolListActivity : BaseActivity() {
    private val mAdapter by lazy { SchoolListAdapter(this) }
    override fun getLayoutId(): Int = R.layout.activity_school_list_layout

    override fun initView() {
        rv_list.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@SchoolListActivity)
        }

    }

    override fun initData() {
        val type = intent.getIntExtra("type", 0)
        var data = arrayListOf<SchoolBean>().apply {
            when (type) {
                0 -> {
                    tv_top_title.text = "俯卧撑"
                    add(
                        SchoolBean(
                            "",
                            "点击破千万的\u0005健身\u0006长这样！我现在就想练一练",
                            "https://puui.qpic.cn/qqvideo_ori/0/o05344npsem_496_280/0",
                            "http://v.qq.com/x/page/o05344npsem.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "超燃\u0005健身\u0006励志短片：路遥马亡，追梦赤子心！",
                            "https://puui.qpic.cn/qqvideo_ori/0/z06182n25z4_496_280/0",
                            "http://v.qq.com/x/page/z06182n25z4.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "世界最强壮的三个小孩 不到十岁练就8块腹肌",
                            "https://puui.qpic.cn/qqvideo_ori/0/m0529g4h2bu_496_280/0",
                            "http://v.qq.com/x/page/m0529g4h2bu.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "地球最强“\u0005健身\u0006神童”，6岁的年龄每天要做600个俯卧撑！",
                            "https://puui.qpic.cn/qqvideo_ori/0/g0543ft3ib9_496_280/0",
                            "http://v.qq.com/x/page/g0543ft3ib9.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "男生每天至少做多少个俯卧撑，才会对胸肌起作用？难怪之前没效果",
                            "https://puui.qpic.cn/qqvideo_ori/0/h0869uo99n1_496_280/0",
                            "http://v.qq.com/x/page/h0869uo99n1.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "\u0005健身\u0006房女神训练组合，丰胸塑臀瘦腰，练出傲人三围",
                            "https://puui.qpic.cn/qqvideo_ori/0/c09141zsqq8_496_280/0",
                            "http://v.qq.com/x/page/c09141zsqq8.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "一口气做 50 个俯卧撑！3 招就搞定",
                            "https://puui.qpic.cn/qqvideo_ori/0/p0864pc5evk_496_280/0",
                            "http://v.qq.com/x/page/p0864pc5evk.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "年仅15岁的华裔小伙，他的腹肌是怎么练成的？",
                            "https://puui.qpic.cn/qqvideo_ori/0/p0529c7jjmy_496_280/0",
                            "http://v.qq.com/x/page/p0529c7jjmy.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "4岁练出6块腹肌是什么样？这让多少成年人自愧不如！",
                            "https://puui.qpic.cn/qqvideo_ori/0/k0962maw7lm_496_280/0",
                            "http://v.qq.com/x/page/k0962maw7lm.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "坚持做俯卧撑的男人更“厉害”？这几个好处要知道，现在知道不算晚",
                            "https://puui.qpic.cn/qqvideo_ori/0/s0844zvmg2u_496_280/0",
                            "http://v.qq.com/x/page/s0844zvmg2u.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "10分钟的上肢自重训练，夏天之前打造完美身材！",
                            "https://puui.qpic.cn/qqvideo_ori/0/t09675acjq7_496_280/0",
                            "http://v.qq.com/x/page/t09675acjq7.html"
                        )
                    )

                }
                1 -> {
                    tv_top_title.text = "深蹲"
                    add(
                        SchoolBean(
                            "",
                            "每日二十个深蹲，花几分钟时间，就能大大的提高心理的满足感",
                            "https://puui.qpic.cn/qqvideo_ori/0/x086598rhsm_496_280/0",
                            "http://v.qq.com/x/page/x086598rhsm.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "外国小伙每天100个深蹲，坚持了5年之久，如今的膝盖看懵众人",
                            "https://puui.qpic.cn/qqvideo_ori/0/e3057phcaa1_496_280/0",
                            "http://v.qq.com/x/page/e3057phcaa1.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "【中字】高效燃脂！帕梅拉最新15分钟快乐有氧舞蹈操！",
                            "https://puui.qpic.cn/qqvideo_ori/0/f0980dqxyp3_496_280/0",
                            "http://v.qq.com/x/page/f0980dqxyp3.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "西班牙小伙每天100个深蹲，坚持整整五年后，如今身体变成了这样",
                            "https://puui.qpic.cn/qqvideo_ori/0/c30255stj06_496_280/0",
                            "http://v.qq.com/x/page/c30255stj06.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "深蹲的两个好处，也许你该坚持每天深蹲了！",
                            "https://puui.qpic.cn/qqvideo_ori/0/l0903ukiiof_496_280/0",
                            "http://v.qq.com/x/page/l0903ukiiof.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "减肥瘦身：早晚减肥瘦身操，三天暴瘦全身，比深蹲减肥都有效",
                            "https://puui.qpic.cn/qqvideo_ori/0/r3114piwsyf_496_280/0",
                            "http://v.qq.com/x/page/r3114piwsyf.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "痴迷深蹲10年，练成无敌牛蛙腿，力量爆棚420斤杠铃深蹲不是事儿",
                            "https://puui.qpic.cn/qqvideo_ori/0/c08452sef5c_496_280/0",
                            "http://v.qq.com/x/page/c08452sef5c.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "年仅15岁的华裔小伙，他的腹肌是怎么练成的？",
                            "https://puui.qpic.cn/qqvideo_ori/0/p0529c7jjmy_496_280/0",
                            "http://v.qq.com/x/page/p0529c7jjmy.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "科学\u0005健身\u0006：身边的无氧训练之深蹲",
                            "https://puui.qpic.cn/qqvideo_ori/0/q3115wlilw2_496_280/0",
                            "http://v.qq.com/x/page/q3115wlilw2.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "脸蛋清纯身材狂野，深蹲多少次，才能练出她这样的翘臀！",
                            "https://puui.qpic.cn/qqvideo_ori/0/k3035vbse4g_496_280/0",
                            "http://v.qq.com/x/page/k3035vbse4g.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "挑战30天10000个深蹲 示范完一遍已经大汗淋漓",
                            "https://puui.qpic.cn/qqvideo_ori/0/d0552hxtxw6_496_280/0",
                            "http://v.qq.com/x/page/d0552hxtxw6.html"
                        )
                    )

                }
                2 -> {
                    tv_top_title.text = "引体向上"
                    add(
                        SchoolBean(
                            "",
                            "\u0005健身\u000630天：连续一个月每天100个引体向上，看身体变化！",
                            "https://puui.qpic.cn/qqvideo_ori/0/d06573u95yy_496_280/0",
                            "http://v.qq.com/x/page/d06573u95yy.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "街头\u0005健身\u0006之王汉尼拔！不用器械不用药，20年练成黑金刚！",
                            "https://puui.qpic.cn/qqvideo_ori/0/u0619h1fi3s_496_280/0",
                            "http://v.qq.com/x/page/u0619h1fi3s.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "最硬核虐腹训练！腰挂30斤圆盘还要接受拳打",
                            "https://puui.qpic.cn/qqvideo_ori/0/q0880r4fwgk_496_280/0",
                            "http://v.qq.com/x/page/q0880r4fwgk.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "街头\u0005健身\u0006各大神技世界纪录保持者 开挂了一般",
                            "https://puui.qpic.cn/qqvideo_ori/0/k06142f6jtw_496_280/0",
                            "http://v.qq.com/x/page/k06142f6jtw.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "引体向上吉尼斯世界纪录！能做一个，你都是大神！",
                            "https://puui.qpic.cn/qqvideo_ori/0/u0944evv9ir_496_280/0",
                            "http://v.qq.com/x/page/u0944evv9ir.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "\u0005健身\u0006教练牟丛现场教学背部训练",
                            "https://puui.qpic.cn/qqvideo_ori/0/s0554jnrqzv_496_280/0",
                            "http://v.qq.com/x/page/s0554jnrqzv.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "小鲜肉这是“疯”了腹肌居然这么“虐”，看着都疼！",
                            "https://puui.qpic.cn/qqvideo_ori/0/d0851wigkq2_496_280/0",
                            "http://v.qq.com/x/page/d0851wigkq2.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "男男女女在\u0005健身\u0006房，就为练肌肉！在一起就是动力十足！",
                            "https://puui.qpic.cn/qqvideo_ori/0/s0864yrrtwi_496_280/0",
                            "http://v.qq.com/x/page/s0864yrrtwi.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "地球最强儿童，2岁开始\u0005健身\u0006，5岁创造吉尼斯世界纪录！",
                            "https://puui.qpic.cn/qqvideo_ori/0/e0538swxqvg_496_280/0",
                            "http://v.qq.com/x/page/e0538swxqvg.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "国内第一\u0005健身\u0006教练刘锐训练的时候竟然睡着了",
                            "https://puui.qpic.cn/qqvideo_ori/0/p3011j76p0u_496_280/0",
                            "http://v.qq.com/x/page/p3011j76p0u.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "引体向上背没感觉？手臂开始受不了，是你的肩胛骨没收紧",
                            "https://puui.qpic.cn/qqvideo_ori/0/h09228u4rok_496_280/0",
                            "http://v.qq.com/x/page/h09228u4rok.html"
                        )
                    )

                }
                3 -> {
                    tv_top_title.text = "倒立"
                    add(
                        SchoolBean(
                            "",
                            "惊人！那个全身肌肉的小孩现在怎么样了知道吗",
                            "https://puui.qpic.cn/qqvideo_ori/0/x0874fdg8jw_496_280/0",
                            "http://v.qq.com/x/page/x0874fdg8jw.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "最高难度亲吻动作，有这样的女朋友我也做的来",
                            "https://puui.qpic.cn/qqvideo_ori/0/i054691m9jg_496_280/0",
                            "http://v.qq.com/x/page/i054691m9jg.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "44岁大叔，我是这样练成的“倒立”，算不算野路子？",
                            "https://puui.qpic.cn/qqvideo_ori/0/d31027dun3k_496_280/0",
                            "http://v.qq.com/x/page/d31027dun3k.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "女子倒立，把脚吊起来练习体力",
                            "https://puui.qpic.cn/qqvideo_ori/0/w0851pazk17_496_280/0",
                            "http://v.qq.com/x/page/w0851pazk17.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "1分钟让你学会“后空翻”！看外国\u0005健身\u0006教练亲身示范",
                            "https://puui.qpic.cn/qqvideo_ori/0/p3011mhg44l_496_280/0",
                            "http://v.qq.com/x/page/p3011mhg44l.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "两个手指就能做倒立！大神连\u0005健身\u0006都这么精彩刺激",
                            "https://puui.qpic.cn/qqvideo_ori/0/n0868za0tzx_496_280/0",
                            "http://v.qq.com/x/page/n0868za0tzx.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "兽人\u0005健身\u0006教学系列：《囚徒\u0005健身\u0006》标准倒立撑",
                            "https://puui.qpic.cn/qqvideo_ori/0/s0398t8t1r6_496_280/0",
                            "http://v.qq.com/x/page/s0398t8t1r6.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "那些逆袭的国外小孩，这一身肌肉看着都羡慕，太震撼了",
                            "https://puui.qpic.cn/qqvideo_ori/0/w0809aiifyt_496_280/0",
                            "http://v.qq.com/x/page/w0809aiifyt.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "适合初学者的倒立，打好根基很重要，注意不要推动肋骨",
                            "https://puui.qpic.cn/qqvideo_ori/0/l0898v971ev_496_280/0",
                            "http://v.qq.com/x/page/l0898v971ev.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "从零开始学手倒立，6分钟视频为你展示所有细节！",
                            "https://puui.qpic.cn/qqvideo_ori/0/o0346higec4_496_280/0",
                            "http://v.qq.com/x/page/o0346higec4.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "每天10分钟，防衰效果堪比倒立，刺激雌性激素分泌，越练越年轻",
                            "https://puui.qpic.cn/qqvideo_ori/0/y09250a6h8r_496_280/0",
                            "http://v.qq.com/x/page/y09250a6h8r.html"
                        )
                    )

                }
                4 -> {
                    tv_top_title.text = "平板支撑"
                    add(
                        SchoolBean(
                            "",
                            "5 分钟腹肌速成，跟着练就对了",
                            "https://puui.qpic.cn/qqvideo_ori/0/p0832c1sjt4_496_280/0",
                            "http://v.qq.com/x/page/p0832c1sjt4.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "15分钟居家\u0005健身\u0006，超模日常\u0005健身\u0006打卡，腿真长，屏幕几乎放不下！",
                            "https://puui.qpic.cn/qqvideo_ori/0/g0945br7vjc_496_280/0",
                            "http://v.qq.com/x/page/g0945br7vjc.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "6分钟、6个动作的高强度间歇性训练。简单高效，甩掉大肚腩！",
                            "https://puui.qpic.cn/qqvideo_ori/0/z0552nis92n_496_280/0",
                            "http://v.qq.com/x/page/z0552nis92n.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "有腹肌的前提！先做这3个动作把腰腹赘肉消了",
                            "https://puui.qpic.cn/qqvideo_ori/0/z0890dj5si4_496_280/0",
                            "http://v.qq.com/x/page/z0890dj5si4.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "Tabata-燃脂集中营",
                            "https://puui.qpic.cn/qqvideo_ori/0/t0304w74nwq_496_280/0",
                            "http://v.qq.com/x/page/t0304w74nwq.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "肚子上的肥肉减掉，全靠这5个动作！",
                            "https://puui.qpic.cn/qqvideo_ori/0/x0503wclxxb_496_280/0",
                            "http://v.qq.com/x/page/x0503wclxxb.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "美女\u0005健身\u0006之徒手腹肌",
                            "https://puui.qpic.cn/qqvideo_ori/0/x30031ddub2_496_280/0",
                            "http://v.qq.com/x/page/x30031ddub2.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "女学员偷吃被教练惩罚10分钟平板支撑，脸上的汗都流了一地",
                            "https://puui.qpic.cn/qqvideo_ori/0/w0809aiifyt_496_280/0",
                            "http://v.qq.com/x/page/w0809aiifyt.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "那么多人做平板支撑标准是什么？你做对了吗",
                            "https://puui.qpic.cn/qqvideo_ori/0/s08856lz0uw_496_280/0",
                            "http://v.qq.com/x/page/s08856lz0uw.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "130斤女生做什么运动体脂降得快,3个方法,脂肪蹭蹭掉,瘦35斤",
                            "https://puui.qpic.cn/qqvideo_ori/0/v3025f8edhm_496_280/0",
                            "http://v.qq.com/x/page/v3025f8edhm.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "48岁平板支撑4小时20分钟，创下非官方世界纪录，坚持的回报",
                            "https://puui.qpic.cn/qqvideo_ori/0/j09168ad2bp_496_280/0",
                            "http://v.qq.com/x/page/j09168ad2bp.html"
                        )
                    )

                }
                5 -> {
                    tv_top_title.text = "卷腹"
                    add(
                        SchoolBean(
                            "",
                            "七天八个动作，在家就能减肥，赶紧动起来吧",
                            "https://puui.qpic.cn/qqvideo_ori/0/j30621kly57_496_280/0",
                            "http://v.qq.com/x/page/j30621kly57.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "荷兰第一美女超模Sanne Vloet推荐的10分钟腹部训练",
                            "https://puui.qpic.cn/qqvideo_ori/0/m0663f1j2dd_496_280/0",
                            "http://v.qq.com/x/page/m0663f1j2dd.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "卷腹瘦腰\u0005健身\u0006操《百花香》5分钟让你大汗淋淋，快速减掉肚子赘肉",
                            "https://puui.qpic.cn/qqvideo_ori/0/u30777oze1e_496_280/0",
                            "http://v.qq.com/x/page/u30777oze1e.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "《强力专业卷腹\u0005健身\u0006操》高效燃脂瘦身，瘦出小蛮腰，附教学",
                            "https://puui.qpic.cn/qqvideo_ori/0/s0903jyxpsy_496_280/0",
                            "http://v.qq.com/x/page/s0903jyxpsy.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "\u0005健身\u0006操《拍手卷腹》燃烧肚子脂肪，练出美好气质",
                            "https://puui.qpic.cn/qqvideo_ori/0/i09760cxl01_496_280/0",
                            "http://v.qq.com/x/page/i09760cxl01.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "全国公认的最强练腰健肾运动",
                            "https://puui.qpic.cn/qqvideo_ori/0/k0845n5bejl_496_280/0",
                            "http://v.qq.com/x/page/k0845n5bejl.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "高效腹肌锻炼方法，4个动作，30天练出钢铁腹肌",
                            "https://puui.qpic.cn/qqvideo_ori/0/k0928znj89a_496_280/0",
                            "http://v.qq.com/x/page/k0928znj89a.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "没事在家躺着“反向卷腹”，瘦得都是内脏脂肪，肚子不知不觉小了",
                            "https://puui.qpic.cn/qqvideo_ori/0/t09737b3o4f_496_280/0",
                            "http://v.qq.com/x/page/t09737b3o4f.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "坚持了一个月的“侧卧卷腹”，我的大肚腩水桶腰真的瘦了一大圈",
                            "https://puui.qpic.cn/qqvideo_ori/0/i097900jwln_496_280/0",
                            "http://v.qq.com/x/page/i097900jwln.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "火爆卷腹减肥\u0005健身\u0006操《火辣辣的情歌》越练越上瘾，越练越年轻",
                            "https://puui.qpic.cn/qqvideo_ori/0/e09514ad2t0_496_280/0",
                            "http://v.qq.com/x/page/e09514ad2t0.html"
                        )
                    )
                    add(
                        SchoolBean(
                            "",
                            "赛普教学视频第16期 腹肌训练之卷腹动作",
                            "https://puui.qpic.cn/qqvideo_ori/0/k0161a5phd5_496_280/0",
                            "http://v.qq.com/x/page/k0161a5phd5.html"
                        )
                    )

                }
            }
        }

        mAdapter.setDataList(data)
    }
}