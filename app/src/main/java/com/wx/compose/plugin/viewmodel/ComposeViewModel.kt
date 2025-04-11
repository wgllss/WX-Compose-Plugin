package com.wx.compose.plugin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wx.compose.plugin.R
import com.wx.compose.plugin.activity.BottomNavigationActivity
import com.wx.compose.plugin.activity.CollapsableActivity
import com.wx.compose.plugin.activity.ComposeDHListActivity
import com.wx.compose.plugin.activity.ComposeHListActivity
import com.wx.compose.plugin.activity.ComposeLayoutActivity
import com.wx.compose.plugin.activity.ComposeListActivity
import com.wx.compose.plugin.activity.ComposePluginActivity
import com.wx.compose.plugin.activity.GirdLayoutActivity
import com.wx.compose.plugin.activity.HorizontalPagerLayoutActivity
import com.wx.compose.plugin.activity.ModalDrawerActivity
import com.wx.compose.plugin.activity.MutilGirdLayoutActivity
import com.wx.compose.plugin.activity.MutilHGirdLayoutActivity
import com.wx.compose.plugin.activity.NavHostActivity
import com.wx.compose.plugin.activity.PullToRefreshActivity
import com.wx.compose.plugin.activity.PullToRefreshActivity2
import com.wx.compose.plugin.activity.PullToRefreshActivity3
import com.wx.compose.plugin.activity.PullToRefreshActivity4
import com.wx.compose.plugin.activity.PullToRefreshActivity5
import com.wx.compose.plugin.activity.PullToRefreshActivity6
import com.wx.compose.plugin.activity.SnckbarActivity
import com.wx.compose.plugin.activity.StickListActivity
import com.wx.compose.plugin.activity.SubCActivity
import com.wx.compose.plugin.activity.TabHorizontalPagerActivity
import com.wx.compose.plugin.activity.TabLayoutActivity
import com.wx.compose.plugin.activity.ViewPageLayoutActivity
import com.wx.compose.plugin.activity.WebViewActivity
import com.wx.compose1.ui.data.DataBean
import com.wx.compose1.ui.data.MainUIItem
import kotlinx.coroutines.launch

class ComposeViewModel : ViewModel() {

    private val _datas = MutableLiveData<List<DataBean>>(listOf())
    val datas: LiveData<List<DataBean>> = _datas

    private val _mainItems = MutableLiveData<List<MainUIItem>>(listOf())
    val mainItmes: LiveData<List<MainUIItem>> = _mainItems

    fun deleteData(data: DataBean) {
        _datas.value = _datas.value?.filter { it != data }
    }


    fun add() {
        viewModelScope.launch {
            val list = listOf(
                DataBean(
                    1,
                    "小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的；啊京东方",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0531%2Fd025f80dj00sech66005hd000zk01bfc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava1
                ),
                DataBean(
                    1,
                    "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0617%2F1185bdb9j00sf7ugv01gkd000p4013tp.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava2
                ),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(
                    1,
                    "小代发费大小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的小代发费大小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0531%2Fd025f80dj00sech66005hd000zk01bfc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava1
                ),
                DataBean(
                    1,
                    "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0617%2F1185bdb9j00sf7ugv01gkd000p4013tp.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava2
                ),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(
                    1,
                    "小代发费大小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0531%2Fd025f80dj00sech66005hd000zk01bfc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava1
                ),
                DataBean(
                    1,
                    "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0617%2F1185bdb9j00sf7ugv01gkd000p4013tp.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava2
                ),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(
                    1,
                    "小代发费大小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0531%2Fd025f80dj00sech66005hd000zk01bfc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava1
                ),
                DataBean(
                    1,
                    "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0617%2F1185bdb9j00sf7ugv01gkd000p4013tp.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava2
                ),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(
                    1,
                    "小代发费大小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0531%2Fd025f80dj00sech66005hd000zk01bfc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava1
                ),
                DataBean(
                    1,
                    "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0617%2F1185bdb9j00sf7ugv01gkd000p4013tp.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava2
                ),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(
                    1,
                    "小代发费大小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0531%2Fd025f80dj00sech66005hd000zk01bfc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava1
                ),
                DataBean(
                    1,
                    "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的",
                    "https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0617%2F1185bdb9j00sf7ugv01gkd000p4013tp.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
                    R.drawable.ava2
                ),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
                DataBean(1, "发达啊小代发费大卡吗代付款啦法兰对接就垃圾发来的李经理久啊了解了解打翻了来了京东方啦吉利丁粉阿拉基啦防静电垃圾啊来访登记的", "https://img1.baidu.com/it/u=2624835088,988907460&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500", R.drawable.ava3),
            )
            _datas.value = list
        }
    }

    fun initUIData() {
        viewModelScope.launch {
            val list = listOf(
                MainUIItem("基础布局", ComposeLayoutActivity::class.java),
                MainUIItem("动态列表竖", ComposeListActivity::class.java),
                MainUIItem("动态列表横", ComposeHListActivity::class.java),
                MainUIItem("网红广告滚动轮播特效", ComposeDHListActivity::class.java),
                MainUIItem("GirdLayout", GirdLayoutActivity::class.java),
                MainUIItem("GirdLayout(横向)", MutilHGirdLayoutActivity::class.java),
                MainUIItem("MutilGirdLayout", MutilGirdLayoutActivity::class.java),
                MainUIItem("VerticalPager", ViewPageLayoutActivity::class.java),
                MainUIItem("HorizontalPager", HorizontalPagerLayoutActivity::class.java),
                MainUIItem("TabLayout", TabLayoutActivity::class.java),
                MainUIItem("BottomNavigation", BottomNavigationActivity::class.java),
                MainUIItem("DrawerLayout", ModalDrawerActivity::class.java),
                MainUIItem("TabHorizontalPager", TabHorizontalPagerActivity::class.java),
                MainUIItem("Refresh", PullToRefreshActivity::class.java),
                MainUIItem("Refresh2", PullToRefreshActivity2::class.java),
                MainUIItem("Refresh3", PullToRefreshActivity3::class.java),
                MainUIItem("Refresh4", PullToRefreshActivity4::class.java),
                MainUIItem("Refresh5", PullToRefreshActivity5::class.java),
                MainUIItem("Refresh6", PullToRefreshActivity6::class.java),
                MainUIItem("小组件", SubCActivity::class.java),
                MainUIItem("SnckBar", SnckbarActivity::class.java),
                MainUIItem("webview", WebViewActivity::class.java),
                MainUIItem("Sticky", StickListActivity::class.java),
                MainUIItem("CollapsingToolbar", CollapsableActivity::class.java),
                MainUIItem("NavHost", NavHostActivity::class.java),
                MainUIItem("插件化", ComposePluginActivity::class.java)
            )
            _mainItems.value = list
        }
    }
}