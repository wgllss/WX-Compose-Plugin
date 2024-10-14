package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.lifecycleScope
import com.wx.compose.plugin.R
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ExperimentalToolbarApi
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

class CollapsableActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
//                    Surface(color = MaterialTheme.colorScheme.background) {
//                        ParallaxEffect()
//                    }
                    MainScreen()
//                    ParallaxEffect()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val state = rememberCollapsingToolbarScaffoldState()
    CollapsingToolbarScaffold(modifier = Modifier.fillMaxSize(), state = state, scrollStrategy = ScrollStrategy.ExitUntilCollapsed, toolbar = {
        val textSize = (18 + (30 - 18) * state.toolbarState.progress).sp
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .height(150.dp)
                .pin()
        )
        Image(
            modifier = Modifier
                .parallax(0.5f)
                .height(300.dp)
                .fillMaxWidth()
                .pin()
//                .padding(16.dp)
                .graphicsLayer {
                    // change alpha of Image as the toolbar expands
                    alpha = state.toolbarState.progress
                }, contentScale = ContentScale.Crop, painter = painterResource(id = R.drawable.ava2), contentDescription = null
        )
        Text(
            text = "Title", modifier = Modifier
//                .height(81.dp)
                .road(Alignment.CenterStart, Alignment.BottomEnd)
                .padding(60.dp, 36.dp, 16.dp, 16.dp), textAlign = TextAlign.Center, color = Color.White, fontSize = textSize
        )
    }) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(100) {
                Text(
                    text = "Item $it", modifier = Modifier.padding(8.dp)
                )
            }
        }

//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .alpha(0.5f)
////            .background(MaterialTheme.colorScheme.secondary)
//            .graphicsLayer {
//                // change alpha of Image as the toolbar expands
//                alpha = state.toolbarState.progress
//            }
//            .height(40.dp))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ParallaxEffect() {
    val state = rememberCollapsingToolbarScaffoldState()

    var enabled by remember { mutableStateOf(true) }

    Box {
        CollapsingToolbarScaffold(modifier = Modifier.fillMaxSize(), state = state, scrollStrategy = ScrollStrategy.ExitUntilCollapsed, toolbarModifier = Modifier.background(MaterialTheme.colorScheme.primary), enabled = enabled, toolbar = {
            // Collapsing toolbar collapses its size as small as the that of
            // a smallest child. To make the toolbar collapse to 50dp, we create
            // a dummy Spacer composable.
            // You may replace it with TopAppBar or other preferred composable.
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .height(50.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ava2), modifier = Modifier
                    .parallax(0.5f)
                    .height(300.dp)
                    .fillMaxWidth()
                    .graphicsLayer {
                        // change alpha of Image as the toolbar expands
                        alpha = state.toolbarState.progress
                    }, contentScale = ContentScale.Crop, contentDescription = null
            )
        }) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(81.dp)
                            .align(Alignment.Center)
//                            .background(Color.Red)
                        , text = "吸顶标题栏", fontWeight = FontWeight.Bold
                    )
                }
                items(List(100) { "Hello World!! $it" }) {
                    Text(
                        text = it, modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }

            @OptIn(ExperimentalToolbarApi::class) Button(modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd), onClick = { }) {
                Text(text = "Floating Button!")
            }
        }

//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
////            Checkbox(checked = enabled, onCheckedChange = { enabled = !enabled })
//
//            Text(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .align(Alignment.CenterVertically)
////                    .background(Color.Red)
//                , text = "Enable collapse/expand", fontWeight = FontWeight.Bold
//            )
//        }
    }
}











