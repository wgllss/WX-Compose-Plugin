package com.wx.compose.plugin.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wx.compose.plugin.R
import com.wx.compose1.ui.composable.baseUI
import com.wx.compose1.ui.theme.WXComposePlugin

class ComposeLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WXComposePlugin {
                baseUI(content = { paddingvalues ->
                    layoutExample(paddingvalues)
                }, onClick = {
                    Toast.makeText(this, "点击我干嘛", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun layoutExample(innerPadding: PaddingValues) {
    var offset by remember { mutableStateOf(0) }

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .background(Color.Yellow)
            .verticalScroll(rememberScrollState())
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .offset(offset.dp, offset.dp)
                .border(2.dp, SolidColor(Color.Green), RoundedCornerShape(20.dp))
                .background(Color.Cyan)
                .padding(5.dp),
            text = "compose 内容1:文字控件".trimIndent(),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(116.dp)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Text(
                text = "compose 内容2:文字控件 A", modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
//                        .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .background(Color.Red)
                    .align(Alignment.TopStart), textAlign = TextAlign.Center, style = TextStyle(fontSize = 18.sp), color = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(8.dp, 58.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
                    .height(50.dp)
//                        .size(1000.dp, 50.dp)
                    .background(Color.Green), textAlign = TextAlign.Center, style = TextStyle(fontSize = 18.sp), color = Color.Yellow, text = "compose 内容3:文字控件 B"

            )
        }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp)
                .background(Color.Magenta)
                .padding(5.dp)
        ) {
            val (buttonID, textID) = createRefs()
            Button(onClick = {
                Toast.makeText(context, "点击我干嘛？", Toast.LENGTH_LONG).show()
            }, modifier = Modifier.constrainAs(buttonID) {
                top.linkTo(parent.top, margin = 16.dp)
            }) {
                Text("compose 内容4 button 控件")
            }
            // Assign reference "text" to the Text composable
            // and constrain it to the bottom of the Button composable
            Text("compose 内容5 text 控件",
                Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .background(Color.Red)
                    .constrainAs(textID) {
                        top.linkTo(buttonID.bottom, margin = 16.dp)
                    })
        }

        FlowColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp)
                .background(Color.White)
                .padding(5.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.LightGray), text = "compose 内容列表:文字控件", textAlign = TextAlign.Center, color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.people_4), contentDescription = "小姐姐", modifier = Modifier
                    .size(80.dp)
                    .padding(5.dp)
                    .weight(1.0f)
                    .clickable {
                        Toast
                            .makeText(context, "Image 点击事件", Toast.LENGTH_SHORT)
                            .show()
                    })
                Image(painter = painterResource(id = R.drawable.ava3), contentDescription = "小姐姐", modifier = Modifier
                    .size(80.dp)
                    .padding(5.dp)
                    .weight(1.0f)
                    .clickable {
                        Toast
                            .makeText(context, "Image 点击事件", Toast.LENGTH_SHORT)
                            .show()
                    })
                Image(painter = painterResource(id = R.drawable.ava1), contentDescription = "小姐姐", modifier = Modifier
                    .size(80.dp)
                    .padding(5.dp)
                    .weight(1.0f)
                    .clickable {
                        Toast
                            .makeText(context, "Image 点击事件", Toast.LENGTH_SHORT)
                            .show()
                    })
                Image(painter = painterResource(id = R.drawable.ava2), contentDescription = "小姐姐", contentScale = ContentScale.Crop, modifier = Modifier
                    .size(80.dp)
                    .padding(5.dp)
                    .weight(1.0f)
                    .clickable {
                        Toast
                            .makeText(context, "Image 点击事件", Toast.LENGTH_SHORT)
                            .show()
                    })

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home_black_24dp), contentDescription = "A", modifier = Modifier.size(100.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_dashboard_black_24dp), contentDescription = "A", modifier = Modifier.size(100.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifications_black_24dp), contentDescription = "A", modifier = Modifier.size(100.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_dashboard_black_24dp), contentDescription = "A", modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview(innerPadding: PaddingValues = PaddingValues(0.dp)) {
    WXComposePlugin {
        layoutExample(innerPadding)
    }
}