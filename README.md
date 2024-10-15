![641.webp](https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/641.webp)

> 想要翱翔天空，必先丰满自己的羽翼-——插件化:你得先从爬开始学习\
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

1. **[Jetpack Compose](https://link.juejin.cn/?target=https%3A%2F%2Fdeveloper.android.com%2Fdevelop%2Fui%2Fcompose "https://developer.android.com/develop/ui/compose")是新一代的声明式的UI开发框架,是未来的一种趋势，介绍最基础用法学习**
2. **如何通过代码直接链接点过去查看官方案例代码？**
3. **插件化中最简单的 纯代码是怎么做到插件化的？（用compose 代码布局来示例）**

* **常用传统XML控件和Compose控件对照表**
  ![https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Sheet1.png](https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Sheet1.png)

**用一个Demo 示例工程，带你入门Compose基础开发：**\
**用一个Demo 示例工程，带你入门Compose插件化开发：**

## 二、示例工程项目介绍：

**示例工程不涉及任何架构，最自由式写法，单条目介绍Compose 相关写法**

* **示例基本布局，横向写法，竖向写法:（`Row`,`Column`,`Box`,`ConstraintLayout`）**
* **示例竖向滚动写法:（`Column + Modifier.verticalScroll(rememberScrollState())`）**
* **示例竖向滚动写法:（`Row = Modifier.horizontalScroll(rememberScrollState())`）**
* **示例复杂列表相关写法:（`LazyRow`，`LazyColumn`，`LazyVerticalGrid +GridItemSpan`，`LazyHorizontalGrid +GridItemSpan`）**
* **示例横竖翻页相关写法:（`HorizontalPager`，`VerticalPager`）**
* **示例Tab栏相关写法:（`TabRow`，`ScrollableTabRow`）**
* **示例底部菜单栏相关写法:（`NavHost`，`NavigationBar`）**
* **示例侧滑单栏相关写法:（`ModalNavigationDrawer`）**
* **示例头部栏相关写法:（`TopAppBar`）**
* **示例下拉刷新相关写法:（`Modifier.pullToRefresh`）**
* **示例网络图片相关写法:（`AsyncImage + coil-compose库`）**
* **示例吸顶栏相关写法:（`stickyHeader`）**
* **示例收缩固定头部栏相关写法:（`me.onebone:toolbar-compose:2.3.5 库`）**
* **示例WebView相关写法:（`AndroidView + WebView`）**
* **示例基础控件相关写法:（`Image，Icon`,`Text`,`Checkbox`,`Switch`,`Button`,`TextField`,`RadioButton`,`Slider`,`DropdownMenu`,`ExposedDropdownMenuBox`,`IconButton`,`Slider`,`Slider`）**
* **示例Compose插件化相关写法:**

**示例部分截图：**

<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122121.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122227.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122254.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122629.png" width="177" height="338">

<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122408.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122311.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122702.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122332.png" width="177" height="338">

<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122639.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122546.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122608.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122505.png" width="177" height="338">

<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122254.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122452.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_122347.png" width="177" height="338">
<img src="https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/Screenshot_20241014_125657.png" width="177" height="338">

**本文涉及到demo示例：大多都是官方代码example,下文中会带大家直接查看官方示例代码**

## 三、项目详情

因为这是最简单的布局使用，只贴几个案例代码就行了,参考上面表格，和项目代码：

## 四、如何直接链接到官方example?

1. **以`LazyVerticalGrid`为例：**
2.

![img_v3_02fl_70eb77d1-2529-4f7c-8034-60a4df1072eg.png](https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/img_v3_02fl_70eb77d1-2529-4f7c-8034-60a4df1072eg.jpg)
3\. 直接点击上图2中 [androidx. compose. foundation. samples. LazyVerticalGridSpanSample]()就可以查看相关example源代码了

## 五、Compose如何实现插件化开发

本文是基础介绍：与其说compose插件化，\
不如说是纯代码打包成jar 怎么实现插件化?

> 本文先介绍如何实现？
>
> 1. Compose界面是代码写布局，打包成纯代码jar,如果在apk包内是以dex包装形式存在的
>
> 2. 通过ClassLoader加载外部dex文件，android加载外部dex文件涉及到classLoader是`DexClassLoader`
>
> 3. 怎么通过Android Studio 制作成jar ,再制作成可以 dex文件供 `DexClassLoader`加载呢？
>
> 4. 通过`build-tools\33.0.0`下面 `d8`执行ANT命令可以将jar转化成xxx\_dex.jar （早些年只有java写的是用 `dx`）
>
> 5. 通过宿主包含接口，classloader反射加载插件包内接口实现便可以完成
>
> 6. 本文只是简单介绍jar最简单的插件化，更多插件化，全动态插件化请参考：\
     > [大型项目架构：全动态插件化+模块化+Kotlin+协程+Flow+Retrofit+JetPack+MVVM+极限瘦身+极限启动优化+架构示例+全网唯一](https://juejin.cn/post/7381787510071934985)，\
     > 以及头部介绍的[WXDynamicPlugin](https://juejin.cn/post/7367676494976532490)系列的7篇文章

1. **Compose 插件化开搞**： 先建一个依赖库 **`WX-Compose-IPlugin`**，里面只包含了一个接口入下，让宿主app工程依赖它:

<!---->

    interface ICompose {

        fun setComposeContent(activity: ComponentActivity)

    }

2. 宿主里面自定义一个`WXClassLoader`(这里我直接从 我的 WXDynamicPlugin工程copy过来了) :

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

3. 建一个模块工程lib:**`WX-Compose-PluginImpl`** 依赖 **`WX-Compose-IPlugin`** 工程，在其里面实现代码：

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

4. 编译 **`WX-Compose-PluginImpl`** 工程后，找到该工程下 **`build/intermediates/aar_main_jar/release/syncReleaseLibJars/classes.jar`**

5. 拷贝classes.jar到自己电脑 \build-tools\33.0.0\下面（注意一定要33.0.0以下）然后在该环境变量下打开cmd命令执行命令：（即在该文件所在的上面地址栏敲cmd,然后回车）\
   d8 --dex --output=classes\_dex.jar classes.jar\
   注意：等号后面是输出文件名， 后面为输入文件名，早起不是kotlin代码写的，是全java代码写的需要执行命令为：\
   dx --dex --output=classes\_dex.jar classes.jar\
   输出的classes\_dex.jar就是我们classloader 能够加载到android能识别的jar了\
   把 **`classes_dex.jar  重命名成 compose_plugin_lib_dex`**（因为下面宿主代码里面写的文件名是compose\_plugin\_lib\_dex）

6. 宿主app工程代码写法：

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

7. **本示例我没有把插件放在assets下写copy操作，也没有写下载，`查看效果先运行安装debug包，打开插件页`面然后其在手机的data/data/com.wx.compose.plugin/files/d\_dex/下上传 我们的 compose\_plugin\_lib\_dex插件到手机， 就可以看到效果啦** 如下图：
   ![img_v3_02fl_a5f9ebc8-9e0b-4ed3-a194-c12b3cae9fbg.jpg](https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/img_v3_02fl_a5f9ebc8-9e0b-4ed3-a194-c12b3cae9fbg.jpg)

  \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ 我是分割线君 \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

8. **`上面 4 和 5 的步骤太麻烦了，可以一键自动搞定吗？ 可以的`**

9. 整个项目中在 **`local.properties`** 里面配置: **`build-tools\33.0.0`** 下面**`d8`** 执行ANT命令可以将jar转化成xxx\_dex.jar的环境目录,注意此处需要 **`33.0.0或者32.0.0`**,没有的可以自行下载

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

![img_v3_02fl_39e304ea-9574-4555-91b6-c67fa63c47bg.jpg](https://raw.githubusercontent.com/wgllss/WX-Compose-Plugin/master/pic/img_v3_02fl_39e304ea-9574-4555-91b6-c67fa63c47bg.jpg)


## 六、总结

本文重点用一个Demo示例工程介绍了：

1. Compose最基础的布局写法，并输出了和传统XML常用控件对照表
2. 如何直接链接到官方example，查看代码
3. 纯代码jar 如何做到插件化的（以compose作为示例）
4. 同时涉及到ANT编程，如何将jar 转化成 android上能识别的dex文件，Gradle相关Task配置用法

#### 感谢阅读：

#### 欢迎    关注，点赞、收藏

## 全动态插件化框架WXDynamicPlugin介绍文章：

#### [(一) 插件化框架开发背景：零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7347994218235363382)

#### [(二）插件化框架主要介绍：零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7367676494976532490)

#### [(三）插件化框架内部详细介绍: 零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7368397264026370083)

#### [(四）插件化框架接入详细指南：零反射，零HooK,全动态化，插件化框架，全网唯一结合启动优化的插件化架构](https://juejin.cn/post/7372393698230550565)

#### [(五) 大型项目架构：全动态插件化+模块化+Kotlin+协程+Flow+Retrofit+JetPack+MVVM+极限瘦身+极限启动优化+架构示例+全网唯一](https://juejin.cn/post/7381787510071934985)

#### [(六) 大型项目架构：解析全动态插件化框架WXDynamicPlugin是如何做到全动态化的？](https://juejin.cn/post/7388891131037777929)

#### [(七) 还在不断升级发版吗？从0到1带你看懂WXDynamicPlugin全动态插件化框架？](https://juejin.cn/post/7412124636239904819)

#### [(八) Compose插件化：一个Demo带你入门Compose，同时带你入门插件化开发](https://juejin.cn/post/7425434773026537483)

## 本人其他开源：

#### [Kotlin+协程+Flow+Retrofit+OkHttp这么好用，不运行安装到手机可以调试接口吗?可以自己搭建一套网络请求工具](https://juejin.cn/post/7406675078810910761)

#### [花式封装：Kotlin+协程+Flow+Retrofit+OkHttp +Repository，倾囊相授,彻底减少模版代码进阶之路](https://juejin.cn/post/7417847546323042345)

#### [注解处理器在架构，框架中实战应用：MVVM中数据源提供Repository类的自动生成](https://juejin.cn/post/7392258195089162290)

#### 感谢阅读，欢迎给给个星，你们的支持是我开源的动力

## 欢迎光临：

#### **[我的掘金地址](https://juejin.cn/user/356661835082573)**

#### 关于我

**VX号：wgllss**  ,如果想更多交流请加我VX
