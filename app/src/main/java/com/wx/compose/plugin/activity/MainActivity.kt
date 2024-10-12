package com.wx.compose.plugin.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    baseUI(content = { paddingvalues ->
                        mainUI(paddingvalues, viewModel)
                    }, onClick = {
                        Toast.makeText(this@MainActivity, "点击我干嘛", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
        viewModel.initUIData()
    }
}

@Composable
fun mainUI(innerPadding: PaddingValues, viewModel: ComposeViewModel) {
    val context = LocalContext.current
    val mainItmes by viewModel.mainItmes.observeAsState(initial = emptyList())
    LazyVerticalGrid(
        modifier = Modifier
            .padding(innerPadding)
            .background(Color.Yellow)
//            .verticalScroll(rememberScrollState())
//            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight()
//            verticalArrangement = Arrangement.spacedBy(16.dp),
        , columns = GridCells.Fixed(2)
    ) {
        items(mainItmes) { item ->
            Button(
                onClick = {
                    context.startActivity(Intent(context, item.clazz))
                }, modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp)
            ) {
                Text(item.title)
            }

//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, ComposeListActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose 动态列表")
//            }
//
//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, GirdLayoutActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose girdLayout")
//            }
//
//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, ViewPageLayoutActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose VerticalPager")
//            }
//
//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, HorizontalPagerLayoutActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose HorizontalPager")
//            }
//
//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, TabLayoutActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose TabLayout")
//            }
//
//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, BottomNavigationActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose BottomNavigationView")
//            }
//
//            Button(
//                onClick = {
//                    context.startActivity(Intent(context, BottomNavigationActivity::class.java))
//                }, modifier = Modifier
//                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text("compose BottomNavigationView")
//            }
        }
    }
}
