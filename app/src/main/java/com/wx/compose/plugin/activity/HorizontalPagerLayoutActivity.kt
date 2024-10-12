package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import kotlinx.coroutines.launch

class HorizontalPagerLayoutActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    baseUI(  content = { paddingvalues ->
                        ViewPageLayout2Example(paddingvalues, viewModel)
                    }, onClick = {
                        viewModel.add()
                    })
                }
            }
        }
        viewModel.add()
    }
}


@Composable
fun ViewPageLayout2Example(innerPadding: PaddingValues, viewModel: ComposeViewModel) {
    val state = rememberPagerState(initialPage = 1) { 5 }
    HorizontalPager(
        state = state, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) { page ->
        Box(
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

//@Preview
//@Composable
//fun girdLayoutPreview(innerPadding: PaddingValues = PaddingValues(0.dp)) {
//    WXComposePlugin {
//        girdLayoutExample(innerPadding)
//    }
//}