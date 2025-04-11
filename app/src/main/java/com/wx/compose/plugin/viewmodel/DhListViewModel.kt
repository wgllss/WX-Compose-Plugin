package com.wx.compose.plugin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wx.compose.plugin.MyApp
import com.wx.compose.plugin.data.TopDataSource
import com.wx.view.data.dynamic.ScrollViewModel
import com.wx.view.utils.DisplayUtil
import kotlinx.coroutines.launch

class DhListViewModel : ViewModel() {

    private val _datas = MutableLiveData<ScrollViewModel>()
    val datas: LiveData<ScrollViewModel> = _datas

    fun add() {
        viewModelScope.launch {
            val list = mutableListOf<com.wx.view.data.dynamic.TopDataSource>()
            list.add(com.wx.view.data.dynamic.TopDataSource("阿凡达", "https://bkimg.cdn.bcebos.com/smart/6f061d950a7b02087bf48857e581e5d3572c11df6276-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 212.0f))
            list.add(com.wx.view.data.dynamic.TopDataSource("复仇者联盟4：终局之战", "https://bkimg.cdn.bcebos.com/smart/2cf5e0fe9925bc31a5ffa7e950df8db1cb137025-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 202.99f))
            list.add(com.wx.view.data.dynamic.TopDataSource("阿凡达：水之道", "https://bkimg.cdn.bcebos.com/smart/e7cd7b899e510fb30f24192fab6bdf95d143ad4ba649-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 168.25f))
            list.add(com.wx.view.data.dynamic.TopDataSource("泰坦尼克号", "https://bkimg.cdn.bcebos.com/smart/f3d3572c11dfa9ec8a132753ae86e003918fa0ec6b62-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 164.23f))
            list.add(com.wx.view.data.dynamic.TopDataSource("哪吒之魔童闹海", "https://bkimg.cdn.bcebos.com/smart/09fa513d269759ee3d6ddbeb3ea254166d224f4a71c3-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 155.05f))
            list.add(com.wx.view.data.dynamic.TopDataSource("星球大战：原力觉醒", "https://bkimg.cdn.bcebos.com/smart/6c224f4a20a4462389da25bc9e22720e0df3d7d8-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 150.19f))
            list.add(com.wx.view.data.dynamic.TopDataSource("复仇者联盟3：无限战争", "https://bkimg.cdn.bcebos.com/smart/d31b0ef41bd5ad6eddc41b61f2932edbb6fd536696ba-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 148.82f))
            list.add(com.wx.view.data.dynamic.TopDataSource("蜘蛛侠：英雄无归", "https://bkimg.cdn.bcebos.com/smart/f3d3572c11dfa9ec8a13ddc33088e003918fa1ec6b94-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 141.6f))
            list.add(com.wx.view.data.dynamic.TopDataSource("头脑特工队2", "https://bkimg.cdn.bcebos.com/smart/b3fb43166d224f4a20a4c53494af87529822720e7bd9-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 123.19f))
            list.add(com.wx.view.data.dynamic.TopDataSource("侏罗纪世界", "https://bkimg.cdn.bcebos.com/smart/d62a6059252dd42a2834f25c70634cb5c9ea14ce1289-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 121.2f))
            list.add(com.wx.view.data.dynamic.TopDataSource("狮子王", "https://bkimg.cdn.bcebos.com/smart/aa18972bd40735fae6cde368af0118b30f2443a7a298-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 120.51f))
            list.add(com.wx.view.data.dynamic.TopDataSource("复仇者联盟", "https://bkimg.cdn.bcebos.com/smart/caef76094b36acaf24a1fd5772d98d1000e99cd3-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 110.26f))
            list.add(com.wx.view.data.dynamic.TopDataSource("速度与激情7", "https://bkimg.cdn.bcebos.com/smart/5d6034a85edf8db1cb135ac97b7bca54564e9258de5c-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 109.88f))
            list.add(com.wx.view.data.dynamic.TopDataSource("壮志凌云2：独行侠", "https://bkimg.cdn.bcebos.com/smart/9213b07eca8065380cd78040a988b644ad3459822411-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 108.45f))
            list.add(com.wx.view.data.dynamic.TopDataSource("冰雪奇缘2", "https://bkimg.cdn.bcebos.com/smart/2e2eb9389b504fc2a7b68177eadde71191ef6dd2-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 105.41f))
            list.add(com.wx.view.data.dynamic.TopDataSource("芭比", "https://bkimg.cdn.bcebos.com/smart/0e2442a7d933c895d143dc1db14464f082025aafaa04-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 104.93f))
            list.add(com.wx.view.data.dynamic.TopDataSource("复仇者联盟2：奥创纪元", "https://bkimg.cdn.bcebos.com/smart/0df3d7ca7bcb0a469f9d6c986f63f6246a60afd0-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 101.88f))
            list.add(com.wx.view.data.dynamic.TopDataSource("超级马力欧兄弟大电影", "https://bkimg.cdn.bcebos.com/smart/500fd9f9d72a6059252d735bb862239b033b5bb50c61-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 98.68f))
            list.add(com.wx.view.data.dynamic.TopDataSource("黑豹", "https://bkimg.cdn.bcebos.com/smart/86d6277f9e2f0708283863716a7caf99a9014c085433-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 97.88f))
            list.add(com.wx.view.data.dynamic.TopDataSource("哈利·波特与死亡圣器（下）", "https://bkimg.cdn.bcebos.com/smart/d0c8a786c9177f3ed1aacd6372cf3bc79e3d56c5-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 97.35f))
            list.add(com.wx.view.data.dynamic.TopDataSource("死侍与金刚狼", "https://bkimg.cdn.bcebos.com/smart/0b46f21fbe096b63f624ec34aa6b9044ebf81a4c0604-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 97.02f))
            list.add(com.wx.view.data.dynamic.TopDataSource("星球大战：最后的绝地武士", "https://bkimg.cdn.bcebos.com/smart/14ce36d3d539b6003af39b474806222ac65c113819be-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 96.76f))
            list.add(com.wx.view.data.dynamic.TopDataSource("侏罗纪世界2", "https://bkimg.cdn.bcebos.com/smart/e824b899a9014c08ae6e4c53077b02087af4f4eb-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 95.02f))
            list.add(com.wx.view.data.dynamic.TopDataSource("冰雪奇缘", "https://bkimg.cdn.bcebos.com/smart/a6efce1b9d16fdfaaf51f747c6d79b5494eef01fcd58-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 94.73f))
            list.add(com.wx.view.data.dynamic.TopDataSource("钢铁侠3", "https://bkimg.cdn.bcebos.com/smart/b3fb43166d224f4a5bf0fa380bf790529822d1b4-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 91.81f))
            list.add(com.wx.view.data.dynamic.TopDataSource("美女与野兽", "https://bkimg.cdn.bcebos.com/smart/3ac79f3df8dcd10043450c6f7b8b4710b8122fa7-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 91.81f))
            list.add(com.wx.view.data.dynamic.TopDataSource("超人总动员2", "https://bkimg.cdn.bcebos.com/smart/e1fe9925bc315c6034a8bff32ce7dc1349540923d92a-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 90.15f))
            list.add(com.wx.view.data.dynamic.TopDataSource("速度与激情8", "https://bkimg.cdn.bcebos.com/smart/203fb80e7bec54e736d1daa6cb608c504fc2d5623c48-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 89.62f))
            list.add(com.wx.view.data.dynamic.TopDataSource("小黄人大眼萌", "https://bkimg.cdn.bcebos.com/smart/c2cec3fdfc03924562bbc7148194a4c27d1e259a-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 84.07f))
            list.add(com.wx.view.data.dynamic.TopDataSource("美国队长3：内战", "https://bkimg.cdn.bcebos.com/smart/cc11728b4710b912bb7f8d69c4fdfc03934522ee-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 83.75f))
            list.add(com.wx.view.data.dynamic.TopDataSource("海王", "https://bkimg.cdn.bcebos.com/smart/f7246b600c338744b135f9ce5c0fd9f9d62aa094-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 83.53f))
            list.add(com.wx.view.data.dynamic.TopDataSource("指环王：王者无敌", "https://bkimg.cdn.bcebos.com/smart/503d269759ee3d6d55fbfbd691477a224f4a20a470d6-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 82.54f))
            list.add(com.wx.view.data.dynamic.TopDataSource("蜘蛛侠：英雄远征", "https://bkimg.cdn.bcebos.com/smart/9922720e0cf3d7ca6fe915d9fc1fbe096b63a905-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 82.13f))
            list.add(com.wx.view.data.dynamic.TopDataSource("惊奇队长", "https://bkimg.cdn.bcebos.com/smart/71cf3bc79f3df8dc9670d47ac011728b4610288f-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 82.04f))
            list.add(com.wx.view.data.dynamic.TopDataSource("变形金刚3", "https://bkimg.cdn.bcebos.com/smart/dc54564e9258d109b3de7eaa7b11dbbf6c81800ae7db-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 81.49f))
            list.add(com.wx.view.data.dynamic.TopDataSource("蝙蝠侠：黑暗骑士崛起", "https://bkimg.cdn.bcebos.com/smart/d0c8a786c9177f3e4f3b5b0f72cf3bc79f3d56a0-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 80.38f))
            list.add(com.wx.view.data.dynamic.TopDataSource("007：大破天幕杀机", "https://bkimg.cdn.bcebos.com/smart/d6ca7bcb0a46f21fbe098d1eb3737c600c338744007c-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 80.38f))
            list.add(com.wx.view.data.dynamic.TopDataSource("变形金刚4：绝迹重生", "https://bkimg.cdn.bcebos.com/smart/2e2eb9389b504fc28c79a73fefdde71190ef6de1-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 80.14f))
            list.add(com.wx.view.data.dynamic.TopDataSource("侏罗纪公园", "https://bkimg.cdn.bcebos.com/smart/7acb0a46f21fbe098007a2fe6d600c338644adfb-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 80.08f))
            list.add(com.wx.view.data.dynamic.TopDataSource("小丑", "https://bkimg.cdn.bcebos.com/smart/9d82d158ccbf6c81800ad21d7a77a63533fa838beaa6-bkimg-process,v_1,rw_1,rh_1,maxl_216,pad_1,color_ffffff?x-bce-process=image/format,f_auto", 78.23f))
//            list.sortByDescending { it.value }
            list.sortBy { it.value }
            val showCount = 5
            val model = ScrollViewModel(
                "全球影史票房榜TOP40", showCount, list, "https://img1.baidu.com/it/u=452832960,881910017&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=281",//背景图片
                musicUrl = "asset:///vv.mp3" //背景音乐，可配置网络链接
            ).apply {
                itemWidth = DisplayUtil.getSreenWidth(MyApp.application) / showCount
                formatString = "%.2f亿" //数字格式化设置
                multiplier = 1f //数据显示格式所用的乘数
            }
            _datas.value = model
        }
    }
}