package com.wx.compose.plugin.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.wx.compose1.ui.theme.WXComposePlugin
import com.wx.compose.plugin.viewmodel.ComposeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SubCActivity : ComponentActivity() {

    val viewModel by viewModels<ComposeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            setContent {
                WXComposePlugin {
                    PullToRefreshScalingSample7(onClick = {
                        finish()
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshScalingSample7(onClick: () -> Unit) {
    var itemCount by remember { mutableIntStateOf(15) }
    var isRefreshing by remember { mutableStateOf(false) }
    val state = rememberPullToRefreshState()
    val coroutineScope = rememberCoroutineScope()

    var checked by remember { mutableStateOf(true) }

    val openDialog = remember { mutableStateOf(false) }
    val openDialog2 = remember { mutableStateOf(false) }

    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            delay(1500)
            itemCount += 5
            isRefreshing = false
        }
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("Title") },
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
        PullToRefreshBox(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            state = state,
            isRefreshing = isRefreshing,
            onRefresh = onRefresh,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clickable {
                        openDialog.value = true
                    }
                    .align(Alignment.CenterHorizontally)
                    .background(Color.Green),// 一定要加这句，
                    text = "点击我弹窗", color = Color.White, textAlign = TextAlign.Center)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                ) {

                    Switch(modifier = Modifier
                        .width(150.dp)
                        .semantics {
                            contentDescription = "Demo"
                        }, checked = checked, onCheckedChange = { checked = it })

                    RadioButtonSample()


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                ) {

                    CheckboxWithTextSample(openDialog2)

                    MenuSample()
                }



                SwipeToDismissListItems()

                SliderSample()



                ExposedDropdownMenuSample()

                SimpleTextFieldSample()

                AlertDialogSample(openDialog)



                DatePickerDialogSample(openDialog2)

//                Snackbar()
            }
        }
    }
}

@Composable
fun SwipeToDismissListItems() {
    val dismissState = rememberSwipeToDismissBoxState()
    SwipeToDismissBox(state = dismissState, backgroundContent = {
        val color by animateColorAsState(
            when (dismissState.targetValue) {
                SwipeToDismissBoxValue.Settled -> Color.LightGray
                SwipeToDismissBoxValue.StartToEnd -> Color.Green
                SwipeToDismissBoxValue.EndToStart -> Color.Red
            }
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(color)
        )
    }) {
        OutlinedCard(shape = RectangleShape) {
            ListItem(headlineContent = { Text("Cupcake") }, supportingContent = { Text("Swipe me left or right!") })
        }
    }
}

@Preview
@Composable
fun SliderSample() {
    var sliderPosition by remember { mutableStateOf(0.5f) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "%.2f".format(sliderPosition))
        Slider(modifier = Modifier.semantics { contentDescription = "Localized Description" }, value = sliderPosition, onValueChange = { sliderPosition = it })
    }
}

@Preview
@Composable
fun RadioButtonSample() {
    // We have two radio buttons and only one can be selected
    var state by remember { mutableStateOf(true) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior.
    // We also set a content description for this sample, but note that a RadioButton would usually
    // be part of a higher level component, such as a raw with text, and that component would need
    // to provide an appropriate content description. See RadioGroupSample.
    Row(Modifier.selectableGroup()) {
        RadioButton(selected = state, onClick = { state = true }, modifier = Modifier.semantics { contentDescription = "Localized Description" })
        RadioButton(selected = !state, onClick = { state = false }, modifier = Modifier.semantics { contentDescription = "Localized Description" })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuSample() {
    val options = listOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread")
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field to handle
            // expanding/collapsing the menu on click. A read-only text field has
            // the anchor type `PrimaryNotEditable`.
            modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable),
            value = text,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            label = { Text("Label") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option, style = MaterialTheme.typography.bodyLarge) },
                    onClick = {
                        text = option
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Preview
@Composable
fun SimpleTextFieldSample() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(modifier = Modifier
        .padding(5.dp)
        .background(Color.Transparent), value = text, onValueChange = { text = it }, label = { Text("请输入") }, singleLine = true
    )
}

@Composable
fun AlertDialogSample(openDialog: MutableState<Boolean>) {
//

    if (openDialog.value) {
        AlertDialog(onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog.value = false
        }, icon = { Icon(Icons.Filled.Favorite, contentDescription = null) }, title = { Text(text = "Title") }, text = {
            Text(
                "This area typically contains the supportive text " + "which presents the details regarding the Dialog's purpose."
            )
        }, confirmButton = {
            TextButton(onClick = { openDialog.value = false }) { Text("Confirm") }
        }, dismissButton = {
            TextButton(onClick = { openDialog.value = false }) { Text("Dismiss") }
        })
    }
}

@Composable
fun CheckboxWithTextSample(openDialog2: MutableState<Boolean>) {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .wrapContentWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState, onValueChange = {
                    onStateChange(!checkedState)
                    openDialog2.value = !checkedState
                }, role = Role.Checkbox
            )
            .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState, onCheckedChange = null // null recommended for accessibility with screenreaders
        )
        Text(
            text = "Option selection", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogSample(openDialog2: MutableState<Boolean>) {
    // Decoupled snackbar host state from scaffold state for demo purposes.
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier)
    // TODO demo how to read the selected date from the state.
    if (openDialog2.value) {
        val datePickerState = rememberDatePickerState()
        val confirmEnabled = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog2.value = false
        }, confirmButton = {
            TextButton(
                onClick = {
                    openDialog2.value = false
                    snackScope.launch {
                        snackState.showSnackbar(
                            "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                        )
                    }
                }, enabled = confirmEnabled.value
            ) {
                Text("OK")
            }
        }, dismissButton = {
            TextButton(onClick = { openDialog2.value = false }) { Text("Cancel") }
        }) {
            DatePicker(state = datePickerState)
        }
    }
}

@Preview
@Composable
fun MenuSample() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Edit") }, onClick = { /* Handle edit! */ }, leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) })
            DropdownMenuItem(text = { Text("Settings") }, onClick = { /* Handle settings! */ }, leadingIcon = { Icon(Icons.Outlined.Settings, contentDescription = null) })
            HorizontalDivider()
            DropdownMenuItem(text = { Text("Send Feedback") }, onClick = { /* Handle send feedback! */ }, leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) }, trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
        }
    }
}








