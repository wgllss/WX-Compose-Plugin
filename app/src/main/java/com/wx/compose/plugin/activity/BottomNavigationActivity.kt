package com.wx.compose.plugin.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin
import kotlinx.coroutines.launch

class BottomNavigationActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    BottomNavigationExample(onClick = {
                        finish()
                    })
//                    baseUI(bottomLayout = { BottomNavigationExample(viewModel) }, content = { paddingvalues ->
//                        BottomNavigationContent(viewModel)
//                    }, onClick = {
//                        finish()
//                    })
                }
            }
        }
//        viewModel.add()
    }
}

@Composable
fun myTabContent(position: Int, state: ScrollState, paddingvalues: PaddingValues) {
    val color = when (position) {
        0 -> Color.Red
        1 -> Color.Magenta
        2 -> Color.Green
        else -> Color.White
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(paddingvalues)
            .verticalScroll(state)
            .background(color)
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tab $position Content")
        BottomNavigationContent()
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
        Text(text = "Tab $position Content")
    }
}

@Composable
fun BottomNavigationContent() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("首页", "视频", "购物", "设置")

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Green)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(0.dp)
                .background(Color.Yellow)
                .padding(0.dp), icon = {
                Icon(Icons.Filled.Favorite, contentDescription = item)
            }, label = { Text(item) }, selected = selectedItem == index, onClick = { selectedItem = index })
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationExample(onClick: () -> Unit) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val state1 = rememberScrollState()
    val state2 = rememberScrollState()
    val state3 = rememberScrollState()
    val mapStatus by remember { mutableStateOf(mapOf(0 to state1, 1 to state2, 2 to state3)) }
    val items = listOf(
        NavItem.Home, NavItem.Profile, NavItem.Settings
    )
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(topBar = {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .height(81.dp), colors = mediumTopAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ), title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "compose navigation题栏", fontSize = 18.sp, color = Color.Red, style = TextStyle.Default)
            }
        }, navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu, contentDescription = "Localized description"
                )
            }
        }, actions = {
            IconButton(onClick = {
                /* doSomething() */
            }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Localized description")
            }
        }, scrollBehavior = scrollBehavior
        )

    }, floatingActionButton = {
        FloatingActionButton(onClick = onClick) {
            Icon(
                Icons.Default.ArrowBack, contentDescription = "Add", tint = Color.Red
            )
        }
    }, bottomBar = {
        NavigationBar() {
            items.forEachIndexed { index, item ->
                NavigationBarItem(icon = { Icon(imageVector = item.icon, contentDescription = null) }, label = { Text(text = item.title) }, selected = selectedIndex == index, onClick = { selectedIndex = index })
            }
        }

    }) { innerPadding ->
        // 根据选中的索引显示不同的页面内容
        mapStatus[selectedIndex]?.let { myTabContent(selectedIndex, it, innerPadding) }
    }
}

sealed class NavItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavItem("home", Icons.Rounded.Home, "Home")
    object Profile : NavItem("profile", Icons.Rounded.Person, "Profile")
    object Settings : NavItem("settings", Icons.Rounded.Settings, "Settings")
}



