![641.webp](https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/52d9a52e470c4c35ad02e7358467fc49~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=CFjJ61s064Mw0NUtvnXitD8W8zE%3D)

> 想要翱翔天空，必先丰满自己的羽翼-——插件化  :   你得先从爬开始学习\
> [（一）零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7347994218235363382)\
> [（二）零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7367676494976532490)\
> [（三）零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7368397264026370083)\
> [（四）零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7372393698230550565)
>
> [（五） 大型项目架构：全动态插件化+模块化+Kotlin+协程+Flow+Retrofit+JetPack+MVVM+极限瘦身+极限启动优化+架构示例+全网唯一 ](https://juejin.cn/post/7381787510071934985)
>
> [（六） 大型项目架构：解析全动态插件化框架WXDynamicPlugin是如何做到全动态化的？](https://juejin.cn/post/7388891131037777929)\
> [（七） 还在不断升级发版吗？从0到1带你看懂WXDynamicPlugin全动态插件化框架](https://juejin.cn/post/7412124636239904819)

## 一、 前言

插件化系列文章太难学了，特别是基础不扎实的，本文将从最简单的插件化开始：

**本文学习思路：**

1.  **[Jetpack Compose](https://link.juejin.cn/?target=https%3A%2F%2Fdeveloper.android.com%2Fdevelop%2Fui%2Fcompose "https://developer.android.com/develop/ui/compose")是新一代的声明式的UI开发框架,是未来的一种趋势，介绍最基础用法学习**
2.  **如何通过代码直接链接点过去查看官方案例代码？**
3.  **插件化中最简单的 纯代码是怎么做到插件化的？（用compose 代码布局来示例）**

*   **常用传统XML控件和Compose控件对照表**
    ![https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Sheet1.png](https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/12a2d5e5d21f460eb18cebbce0b03db3~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=PJURAsBivDP0xudg6QbVaq6zOy8%3D)

**用一个Demo 示例工程，带你入门Compose基础开发：**\
**用一个Demo 示例工程，带你入门Compose插件化开发：**

## 二、示例工程项目介绍：

**示例工程不涉及任何架构，最自由式写法，单条目介绍Compose 相关写法**

*   **示例基本布局，横向写法，竖向写法:（`Row`,`Column`,`Box`,`ConstraintLayout`）**
*   **示例竖向滚动写法:（`Column + Modifier.verticalScroll(rememberScrollState())`）**
*   **示例竖向滚动写法:（`Row = Modifier.horizontalScroll(rememberScrollState())`）**
*   **示例复杂列表相关写法:（`LazyRow`，`LazyColumn`，`LazyVerticalGrid +GridItemSpan`，`LazyHorizontalGrid +GridItemSpan`）**
*   **示例横竖翻页相关写法:（`HorizontalPager`，`VerticalPager`）**
*   **示例Tab栏相关写法:（`TabRow`，`ScrollableTabRow`）**
*   **示例底部菜单栏相关写法:（`NavHost`，`NavigationBar`）**
*   **示例侧滑单栏相关写法:（`ModalNavigationDrawer`）**
*   **示例头部栏相关写法:（`TopAppBar`）**
*   **示例下拉刷新相关写法:（`Modifier.pullToRefresh`）**
*   **示例网络图片相关写法:（`AsyncImage + coil-compose库`）**
*   **示例吸顶栏相关写法:（`stickyHeader`）**
*   **示例收缩固定头部栏相关写法:（`me.onebone:toolbar-compose:2.3.5 库`）**
*   **示例WebView相关写法:（`AndroidView + WebView`）**
*   **示例基础控件相关写法:（`Image，Icon`,`Text`,`Checkbox`,`Switch`,`Button`,`TextField`,`RadioButton`,`Slider`,`DropdownMenu`,`ExposedDropdownMenuBox`,`IconButton`,`Slider`,`Slider`）**
*   **示例Compose插件化相关写法:**

**示例部分截图：**

<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122121.png" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/2e04fdcb99314558a0ca96166aa66ff1~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=ytqVBaF%2FUfSjxBAbR%2FPlsgog9kY%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/4de4e13e0db344f9b9c718ee5e77c636~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=7sPvE796uJ5xSUB8TmlGUpMmE6w%3D" width="177" height="338">

<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/a73c4fdaf5294740baea63f6580a0946~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=1b3XBJCpgSaMRfGt5OluROV7D1M%3D" width="177" height="338">

<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/6483705a61944e4badd297c8ca3bf6a5~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=79j0JjwM5jOkeYA7UlYJeDUFDcA%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/72940f63930b4f029ea82e9582ac7549~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=JNSzZLhpoFr5WRAQGyrdJloyyDo%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/eed3ba6ddc584129b2a0978c2b866122~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=MIayURwZWcQ6jOUIkWl18Syktb4%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/eb932fd237a440a6a3126a0164497f07~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=CjakZMGS0YZNkq4T4glqjDrp%2FXs%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/1f7a35a91cd447d89e2cfc1bb3c65c0e~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=8ZJvlTbTIFzJJT5%2FPqgvCB8MoDM%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/b8f62193d5864878938c61b06c7cf714~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=248NB%2FccznrksnpV2FXj1x7i%2FX8%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/03298d2b6d9a4767a4e34bc77984703b~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=ctqZm31DWRqeaH1Y2fCQ0UZDtX8%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/ecb97ad7735048039b72ce49c1cdd211~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=%2FOezdyThfeF222cW%2Bolw1TNOITQ%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/b47769dbb58d422fa8e4cf37856f5427~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=KYrupakGqtH%2BV1BmOXq0lx1HW4g%3D" width="177" height="338">
<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/3ab3480940614aed9e48060e35463fe9~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=HhPuR%2B5JIkkWdUUqHA9I%2BH%2BuwpA%3D" width="177" height="338">

<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/47e36602433f4e8d83f0093f09404cb8~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=cnUtNUAcA2pNmZDjuzki9Eyt7Os%3D" width="177" height="338">

<img src="https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/371f3a8e0c0e4414856b4112a87a0556~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=OfWta%2FLBoYMQ0mswjydWWQrxKzw%3D" width="177" height="338">

**本文涉及到demo示例：大多都是官方代码example,下文中会带大家直接查看官方示例代码**

**[项目地址github](https://github.com/wgllss/WX-Compose-Plugin)**\
**[项目地址gitee](https://gitee.com/wgllss888/WX-Compose-Plugin)**

## 三、项目详情

因为这是最简单的布局使用，只贴几个案例代码就行了：

1.  **类似RecyclerView 网格布局：**

```

@Composable
fun girdLayoutExample(innerPadding: PaddingValues, viewModel: ComposeViewModel) {
    val datas by viewModel.datas.observeAsState(initial = emptyList())
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
//            .verticalScroll(rememberScrollState())
        , columns = GridCells.Fixed(2)
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
            }
        }
    }
}
```

2.  类似RecyclerView 多个Item布局

<!---->

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

3.  **`TabRow` + `HorizontalPager` Tab标签 和 滑动联动翻页：**

```

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
```

4.  **侧滑菜单栏：`ModalNavigationDrawer`**:

```

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawerExample() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // icons to mimic drawer destinations
    val items = listOf(
        Icons.Default.AccountCircle,
        Icons.Default.Email,
        Icons.Default.Favorite,
        Icons.Default.AccountBox,
        Icons.Default.Build,
        Icons.Default.LocationOn,
        Icons.Default.Lock,
        Icons.Default.CheckCircle,
        Icons.Default.AddCircle,
        Icons.Default.MailOutline,
    )
    val selectedItem = remember { mutableStateOf(items[0]) }
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
            IconButton(onClick = {
                scope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }

                }
            }) {
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

    }) { innerPadding ->
        ModalNavigationDrawer(modifier = Modifier.padding(innerPadding), drawerState = drawerState, drawerContent = {
            ModalDrawerSheet(drawerState) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Spacer(Modifier.height(12.dp))
                    items.forEach { item ->
                        NavigationDrawerItem(icon = {
                            Icon(item, contentDescription = null)
                        }, label = {
                            Text(item.name.substringAfterLast("."))
                        }, selected = item == selectedItem.value, onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            selectedItem.value = item
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            }
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { drawerState.open() } }) { Text("Click to open") }
            }
        })
    }
}
```

5.  **底部菜单栏：`NavigationBar`**

```

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
```

6.  **底部菜单栏`NavHost`**

<!---->

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

7.  **谷歌官方下拉刷新**：

```

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshScalingSample(onClick: () -> Unit) {
    var itemCount by remember { mutableStateOf(15) }
    var isRefreshing by remember { mutableStateOf(false) }
    val state = rememberPullToRefreshState()
    val coroutineScope = rememberCoroutineScope()


    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            // fetch something
            delay(1500)
            itemCount += 5
            isRefreshing = false
        }
    }

    val scaleFraction = {
        if (isRefreshing) 1f
        else LinearOutSlowInEasing.transform(state.distanceFraction).coerceIn(0f, 1f)
    }

    Scaffold(modifier = Modifier.pullToRefresh(
        state = state, isRefreshing = isRefreshing, onRefresh = onRefresh
    ), topBar = {
        TopAppBar(title = { Text("TopAppBar") },
            // Provide an accessible alternative to trigger refresh.
            actions = {
                IconButton(onClick = onRefresh) {
                    Icon(Icons.Filled.Refresh, "Trigger Refresh")
                }
            })
    }, floatingActionButton = {
        FloatingActionButton(onClick = onClick) {
            Icon(
                Icons.Default.ArrowBack, contentDescription = "Add", tint = Color.Red
            )
        }
    }) {
        Box(Modifier.padding(it)) {
            LazyColumn(Modifier.fillMaxSize()) {
                if (!isRefreshing) {
                    items(itemCount) { ListItem({ Text(text = "Item ${itemCount - it}") }) }
                }
            }
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .graphicsLayer {
                        scaleX = scaleFraction()
                        scaleY = scaleFraction()
                    }) {
                PullToRefreshDefaults.Indicator(state = state, isRefreshing = isRefreshing)
            }
        }
    }
}
```

8.  **谷歌官方吸顶：`stickyHeader`**：

```

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderSample(paddingValues: PaddingValues) {
    val sections = listOf("A", "B", "C", "D", "E", "F", "G")

    LazyColumn(
        modifier = Modifier.padding(paddingValues), contentPadding = PaddingValues(6.dp)
    ) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    text = "Section $section", color = Color.White, modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.Red)
                        .padding(8.dp)
                )
            }
            items(10) {
                Text("Item $it from the section $section")
            }
        }
    }
}
```

9.  **三方库`Compose 实现 CollapsableTopBarLayout`效果**：

```

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
    }
}
```

## 四、如何直接链接到官方example?

1.  **以`LazyVerticalGrid`为例：**
2.

![img\_v3\_02fl\_70eb77d1-2529-4f7c-8034-60a4df1072eg.jpg](https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/2828bed3635d4bae98f90936e7ffe37c~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=kldomHxuTrIcIlBQOMc%2F3yox3Ng%3D)
3\. 直接点击上图2中 [androidx. compose. foundation. samples. LazyVerticalGridSpanSample]()就可以查看相关example源代码了

## 五、Compose如何实现插件化开发

本文是基础介绍：与其说compose插件化，\
不如说是纯代码打包成jar 怎么实现插件化?

> 本文先介绍如何实现？
>
> 1.  Compose界面是代码写布局，打包成纯代码jar,如果在apk包内是以dex包装形式存在的
>
> 2.  通过ClassLoader加载外部dex文件，android加载外部dex文件涉及到classLoader是`DexClassLoader`
>
> 3.  怎么通过Android Studio 制作成jar ,再制作成可以 dex文件供 `DexClassLoader`加载呢？
>
> 4.  通过`build-tools\33.0.0`下面 `d8`执行ANT命令可以将jar转化成xxx\_dex.jar （早些年只有java写的是用 `dx`）
>
> 5.  通过宿主包含接口，classloader反射加载插件包内接口实现便可以完成
>
> 6.  本文只是简单介绍jar最简单的插件化，更多插件化，全动态插件化请参考：\
>     [大型项目架构：全动态插件化+模块化+Kotlin+协程+Flow+Retrofit+JetPack+MVVM+极限瘦身+极限启动优化+架构示例+全网唯一](https://juejin.cn/post/7381787510071934985)，\
>     以及头部介绍的[WXDynamicPlugin](https://juejin.cn/post/7367676494976532490)系列的7篇文章

1.  **Compose 插件化开搞**： 先建一个依赖库 **`WX-Compose-IPlugin`**，里面只包含了一个接口入下，让宿主app工程依赖它:

<!---->

    interface ICompose {

        fun setComposeContent(activity: ComponentActivity)

    }

2.  宿主里面自定义一个`WXClassLoader`(这里我直接从 我的 WXDynamicPlugin工程copy过来了) :

<!---->

    public class WXClassLoader extends DexClassLoader {
        protected ClassLoader parent;

        public WXClassLoader(String dexPath, String optimizedDirectory, ClassLoader parent) {
            super(dexPath, optimizedDirectory, null, parent);
            this.parent = parent;
        }

        public WXClassLoader(String dexPath, String optimizedDirectory, String librarySearchPath, ClassLoader parent) {
            super(dexPath, optimizedDirectory, librarySearchPath, parent);
            this.parent = parent;
        }

        public <T> T getInterface(Class<T> clazz, String className) {
            try {
                Class<?> interfaceImplementClass = loadClass(className);
                Object interfaceImplement = interfaceImplementClass.newInstance();
                return clazz.cast(interfaceImplement);
            } catch (ClassNotFoundException | InstantiationException
                     | ClassCastException | IllegalAccessException e) {
                return null;
            }
        }
    }

3.  建一个模块工程lib:**`WX-Compose-PluginImpl`** 依赖 **`WX-Compose-IPlugin`** 工程，在其里面实现代码：

<!---->

    class PluginComposeImpl : ICompose {

        override fun setComposeContent(activity: ComponentActivity) {
            activity.setContent {
                WXComposeXXXTheme {
                    //这里面都是  @Composable 的方法，全自己写就行了
                    baseUIXXXX({ paddingvalues ->
                        layoutExamplexxx(paddingvalues) 
                    }, onClick = {
                        Toast.makeText(activity, "我是插件里面的", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }

4.  编译 **`WX-Compose-PluginImpl`** 工程后，找到该工程下 **`build/intermediates/aar_main_jar/release/syncReleaseLibJars/classes.jar`**

5.  拷贝classes.jar到自己电脑 \build-tools\33.0.0\下面（注意一定要33.0.0以下）然后在该环境变量下打开cmd命令执行命令：（即在该文件所在的上面地址栏敲cmd,然后回车）\
    d8 --dex --output=classes\_dex.jar classes.jar\
    注意：等号后面是输出文件名， 后面为输入文件名，早起不是kotlin代码写的，是全java代码写的需要执行命令为：\
    dx --dex --output=classes\_dex.jar classes.jar\
    输出的classes\_dex.jar就是我们classloader 能够加载到android能识别的jar了\
    把 **`classes_dex.jar  重命名成 compose_plugin_lib_dex`**（因为下面宿主代码里面写的文件名是compose\_plugin\_lib\_dex）

6.  宿主app工程代码写法：

```

class ComposePluginActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        getPluginPath()?.let {
            WXClassLoader(it, null, classLoader).getInterface(
                ICompose::class.java, "com.wx.compose.plugin.compose.PluginComposeImpl"
            ).setComposeContent(this@ComposePluginActivity)
        }
    }

    private fun getPluginPath(): String? {
        val sb = StringBuilder(filesDir.absolutePath).append(File.separator).append("d_dex").append(File.separator).append("compose_plugin_lib_dex")
        val file = File(sb.toString())
        if (!file.exists()) {
            val fileDir = File(file.parent)
            if (!fileDir.exists()) {
                fileDir.mkdirs()
            }
            return null
        }
        return sb.toString()
    }
}
```

7.  **本示例我没有把插件放在assets下写copy操作，也没有写下载，`查看效果先运行安装debug包，打开插件页`面然后其在手机的data/data/com.wx.compose.plugin/files/d\_dex/下上传 我们的 compose\_plugin\_lib\_dex插件到手机， 就可以看到效果啦** 如下图：
    ![img\_v3\_02fl\_a5f9ebc8-9e0b-4ed3-a194-c12b3cae9fbg.jpg](https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/015bb5c9314244c7af8d572632c413fc~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=sd9Ou75M4FE%2FYUeLh7fqyQWYhpM%3D)

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ 我是分割线君 \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

8.  **`上面 4 和 5 的步骤太麻烦了，可以一键自动搞定吗？  可以的`**

9.  整个项目中在 **`local.properties`** 里面配置: **`build-tools\33.0.0`** 下面 **`d8`** 执行ANT命令可以将jar转化成xxx\_dex.jar的环境目录,注意此处需要 **`33.0.0或者32.0.0`**,没有的可以自行下载

<!---->

    sdk.dir=D:\android_software\android_sdk\android_sdk
    workingDirPath=D:\android_software\android_sdk\android_sdk\build-tools\33.0.0\

**在主工程下面配置如下：**

    ext {

        def inputSteam = project.rootProject.file('local.properties').newDataInputStream()
        def properties = new Properties()
        properties.load(inputSteam)
        workingDirPath = properties.getProperty('workingDirPath')
    }

10. **`WX-Compose-PluginImpl`** 工程的 `build.gradle`下配置好task

```

def createCopyTask(buildType) {
    def workingDirPath = rootProject.ext.workingDirPath
    def outputFile = file("${workingDirPath}compose_plugin_lib.jar")
    def outputDexFile = file("${workingDirPath}compose_plugin_lib_dex.jar")
    def lastOutputDexFile = file("${rootProject.getBuildDir()}/compose_plugin_lib_dex")
    if (lastOutputDexFile.exists()) {
        lastOutputDexFile.delete()
    }
    if (outputDexFile.exists()) {
        outputDexFile.delete()
    }
    if (outputFile.exists()) {
        outputFile.delete()
    }
    def inputFile = file("${getProject().getBuildDir()}/intermediates/aar_main_jar/${buildType}/sync${buildType}LibJars/classes.jar")
    def copyTask = tasks.create("assembleCopy${buildType.capitalize()}", Copy) {
        group = 'other'
        description = "复制${name}到dx环境中."
        from(inputFile.getParent()) {
            include(inputFile.name)
            rename { outputFile.name }
        }
        into(outputFile.getParent())
    }.dependsOn("assemble${buildType.capitalize()}")

    def assembleDxCommand = tasks.create("assembleDxCommand", Exec) {
        group = 'other'
        description = "${name}到dx执行中..."
        workingDir workingDirPath
        if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {
            it.commandLine 'cmd', '/c', "d8 --output ${outputDexFile.name} ${outputFile.name}"
        } else {
            it.commandLine bash, '-c ', "d8 --output ${outputDexFile.name} ${outputFile.name}"
        }
    }.dependsOn(copyTask.name)
    return tasks.create("assembleDxCommandAndCopy") {
        doLast {
            copy {
                from(outputDexFile.getParent()) {
                    include(outputDexFile.name)
                    rename { lastOutputDexFile.name }
                }
                into(lastOutputDexFile.getParent())
            }
        }
    }.dependsOn(assembleDxCommand.name)
}

tasks.whenTaskAdded { task ->
    if (task.name == "assembleRelease") {
        createCopyTask("Release")
    }
}
```

11. **直接点击Gradle中 `assembleDxCommandAndCopy`**,会自动把 4和5中的步骤 操作完，并把输出的compose\_plugin\_lib\_dex文件放到 整个主工程的build下面：

![img\_v3\_02fl\_2ec33f8f-8fe2-4d14-af38-25fa04a8aeag.jpg](https://p0-xtjj-private.juejin.cn/tos-cn-i-73owjymdk6/048ac34a496b45bea6be6e9ec4157dd0~tplv-73owjymdk6-jj-mark-v1:0:0:0:0:5o6Y6YeR5oqA5pyv56S-5Yy6IEAgV2dsbHNz:q75.awebp?policy=eyJ2bSI6MywidWlkIjoiMzU2NjYxODM1MDgyNTczIn0%3D&rk3s=f64ab15b&x-orig-authkey=f32326d3454f2ac7e96d3d06cdbb035152127018&x-orig-expires=1729497423&x-orig-sign=5QjZuZb6e%2FMa7SRSOgevl3bm47k%3D)

## 六、总结

本文重点用一个Demo示例工程介绍了：

1.  Compose最基础的布局写法，并输出了和传统XML常用控件对照表
2.  如何直接链接到官方example，查看代码
3.  纯代码jar 如何做到插件化的（以compose作为示例）
4.  同时涉及到ANT编程，如何将jar 转化成 android上能识别的dex文件，Gradle相关Task配置用法

#### 感谢阅读：

#### 欢迎    关注，点赞、收藏
