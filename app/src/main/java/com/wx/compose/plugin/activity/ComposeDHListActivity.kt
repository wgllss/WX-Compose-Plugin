package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.lifecycleScope
import com.wx.compose.plugin.viewmodel.DhListViewModel
import com.wx.compose1.ui.theme.WXComposePlugin
import com.wx.view.HorizontalScroll
import kotlinx.coroutines.launch

class ComposeDHListActivity : ComponentActivity() {

    val viewModel by viewModels<DhListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    HorizontalScrollView(viewModel = viewModel)
                }
            }
        }
        viewModel.add()
    }
}

@Composable
fun HorizontalScrollView(viewModel: DhListViewModel) {
    val datas by viewModel.datas.observeAsState()
    datas?.let {
        HorizontalScroll(it, it.list)
//        HorizontalScroll(it, it.list, onPlayComplete = {
//            //滚动到右边，背景音乐播放结束
//        }) { data: TopDataSource, index: Int, size: Int ->
//            //真正itemView 布局compose,可自定义
//            RealItemView(data, it.itemWidth, index, size, it)
//        }
    }
}





