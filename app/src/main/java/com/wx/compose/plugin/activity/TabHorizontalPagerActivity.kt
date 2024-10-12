package com.wx.compose.plugin.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import kotlinx.coroutines.launch

class TabHorizontalPagerActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    baseUI(content = { paddingvalues ->
                        tabPage(paddingvalues, viewModel)
                    }, onClick = {
                        finish()
                    })
                }
            }
        }
        viewModel.add()
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun tabPage(innerPadding: PaddingValues, viewModel: ComposeViewModel) {
    var state by remember { mutableStateOf(0) }
    var statePage = rememberPagerState(initialPage = state) { 5 }
    val titles = listOf("Tab 1", "Tab 2", "Tab 3 ", "Tab 4 ", "Tab 5 ")
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .background(Color.Yellow)
//            .verticalScroll(rememberScrollState())
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TabRow(selectedTabIndex = statePage.currentPage) {
            titles.forEachIndexed { index, title ->
                Tab(modifier = Modifier.background(Color.Green), selected = state == index, onClick = {
                    scope.launch {
//                        statePage.scrollToPage(index)
                        statePage.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, color = Color.Magenta)
                })
            }
        }
        HorizontalPager(
            state = statePage, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) { page ->
            when (page) {
                0 -> page1(viewModel)
                else -> Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.Red)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .aspectRatio(1f), contentAlignment = Alignment.Center
                ) {
                    Text(text = page.toString(), fontSize = 32.sp)
                }
            }
        }
    }
}

@Composable
fun page1(viewModel: ComposeViewModel) {
    val datas by viewModel.datas.observeAsState(initial = emptyList())
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Red)
            .fillMaxWidth()
            .fillMaxHeight(),
        state = rememberLazyListState()
    ) {
        items(datas) { data ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .height(80.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = data.resID), contentDescription = "小姐姐", modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp), contentScale = ContentScale.Fit
                )
                AsyncImage(
                    model = data.imgUrl, contentDescription = "", contentScale = ContentScale.Crop
                )
                val modelBuilder = ImageRequest.Builder(LocalContext.current).data(data.imgUrl ?: "").crossfade(false).allowHardware(true).build()
                Image(
                    painter = rememberAsyncImagePainter(model = modelBuilder), contentDescription = "小姐姐", modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp), contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(60.dp)
                        .background(Color.Yellow)
                        .border(2.dp, SolidColor(Color.Green), RoundedCornerShape(20.dp))
                        .padding(0.dp, 5.dp, 0.dp, 0.dp), fontSize = 16.sp, text = data.title, textAlign = TextAlign.Center, color = Color.Magenta
                )
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(60.dp)
                        .background(Color.Yellow)
                        .border(2.dp, SolidColor(Color.Green), RoundedCornerShape(20.dp))
                        .padding(0.dp, 5.dp, 0.dp, 0.dp), fontSize = 16.sp, text = data.title, textAlign = TextAlign.Center, color = Color.Magenta
                )
            }
        }
    }
}


