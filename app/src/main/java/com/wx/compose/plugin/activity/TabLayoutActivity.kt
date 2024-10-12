package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import kotlinx.coroutines.launch

class TabLayoutActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    baseUI(content = { paddingvalues ->
                        TabLayoutExample(paddingvalues, viewModel)
                    }, onClick = {
                        viewModel.add()
                    })
                }
            }
        }
        viewModel.add()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabLayoutExample(innerPadding: PaddingValues, viewModel: ComposeViewModel) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Tab 1", "Tab 2", "Tab 3 ")

    var state2 by remember { mutableStateOf(0) }
    val titles2 = listOf("Tab 1", "Tab 2", "Tab 3 ", "Tab 4 ", "Tab 5 ", "Tab 6 ", "Tab 7 ", "Tab 8 ", "Tab 9 ", "Tab 10 ", "Tab 11 ")


    Column(
        modifier = Modifier
            .padding(innerPadding)
            .background(Color.Yellow)
//            .verticalScroll(rememberScrollState())
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(modifier = Modifier.background(Color.Green), selected = state == index, onClick = {
                    state = index
                }, text = {
                    Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, color = Color.Magenta)
                })
            }
        }
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally), text = "Text tab ${state + 1} selected", style = MaterialTheme.typography.bodyLarge, color = Color.Red, fontSize = 36.sp
        )

        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(modifier = Modifier.background(Color.Green), selected = state == index, onClick = {
                    state = index
                }, text = {
                    Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, color = Color.Magenta)
                })
            }
        }

        SecondaryTabRow(selectedTabIndex = state, containerColor = Color.Cyan) {
            titles.forEachIndexed { index, title ->
                FancyTab(title = title, onClick = { state = index }, selected = (index == state))
            }
        }
        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = "Fancy tab ${state + 1} selected", style = MaterialTheme.typography.bodyLarge)

        ScrollableTabRow(selectedTabIndex = state2, containerColor = Color.Red) {
            titles2.forEachIndexed { index, title ->
                FancyTab(title = title, onClick = { state2 = index }, selected = (index == state2))
            }
        }
    }
}

@Composable
fun FancyTab(title: String, onClick: () -> Unit, selected: Boolean) {
    Tab(selected, onClick) {
        Column(
            Modifier
                .padding(10.dp)
                .height(50.dp)
                .fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .size(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(
                        color = if (selected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.background
                    )
            )
            Text(
                text = title, color = Color.White, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
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