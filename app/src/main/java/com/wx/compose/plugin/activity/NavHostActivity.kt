package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wx.compose1.ui.theme.WXComposePlugin
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import kotlinx.coroutines.launch

class NavHostActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    BottomNavigationHostExample(onClick = {
                        finish()
                    })
                }
            }
        }
    }
}

@Composable
fun navHost(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), start: String = "first_screen", state: ScrollState = rememberScrollState()
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = start
    ) {
        composable("first_screen") {
            FirstScreen(navController = navController, state)
        }
        composable("second_screen") {
            SecondScreen(navController = navController)
        }
        composable("third_screen") {
            ThirdScreen(navController = navController)
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController, state: ScrollState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
//                .padding(paddingvalues)
                .verticalScroll(state)
                .background(Color.Blue)
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Tab FirstScreen Content")
            BottomNavigationContent()
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")
            Text(text = "Tab FirstScreen Content")

        }

//        Button(onClick = {
//            navController.navigate("second_screen")
//        }) {
//            Text(text = "I am First 点击我去Second")
//        }
    }
}

@Composable
fun SecondScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Button(onClick = {
//            navController.navigate("third_screen")
//        }) {
        Text(text = "I am Second ")
//        }
    }
}

@Composable
fun ThirdScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Button(onClick = {
//            navController.navigate("first_screen")
//        }) {
        Text(text = "I am Third ")
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationHostExample(onClick: () -> Unit) {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) }
    var map by remember { mutableStateOf(mapOf(0 to "first_screen", 1 to "second_screen", 2 to "third_screen")) }
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
                NavigationBarItem(icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                }, label = {
                    Text(text = item.title)
                }, selected = selectedIndex == index, onClick = {
                    selectedIndex = index
                    map[index]?.let {
                        navController.navigate(it) {
                            popUpTo(
                                0
                            ) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                })
            }
        }
    }) { innerPadding ->
        // 根据选中的索引显示不同的页面内容
        navHost(
            navController = navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(innerPadding)
        )
    }
}









