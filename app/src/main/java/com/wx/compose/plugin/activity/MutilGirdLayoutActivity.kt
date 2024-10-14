package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import kotlinx.coroutines.launch

class MutilGirdLayoutActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    baseUI(content = { paddingvalues ->
                        LazyVerticalGridSpanSample(paddingvalues)
                    }, onClick = {
                        finish()
                    })
                }
            }
        }
        viewModel.add()
    }
}

@Composable
fun LazyVerticalGridSpanSample(paddingValues: PaddingValues) {
    val sections = (0 until 25).toList().chunked(6)
    val items22 = remember { listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6") }

    LazyVerticalGrid(
        modifier = Modifier.padding(paddingValues), columns = GridCells.Fixed(3), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        sections.forEachIndexed { index, items ->
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    "This is section $index",
                    Modifier
                        .border(1.dp, Color.Gray)
                        .height(80.dp)
                        .wrapContentSize()
                )
            }
            items(items, span = { GridItemSpan(1) }) {
                Text(
                    "Item $it",
                    Modifier
                        .border(1.dp, Color.Blue)
                        .height(80.dp)
                        .wrapContentSize()
                )
            }

            item(span = { GridItemSpan(3) }) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)
                ) {
                    items(items22) { item ->
                        Box(
                            modifier = Modifier
                                .background(Color.Green)
                                .padding(16.dp)
                                .width(120.dp)
                                .height(120.dp), contentAlignment = Alignment.Center
                        ) {
                            Text(text = "AAA $item", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

