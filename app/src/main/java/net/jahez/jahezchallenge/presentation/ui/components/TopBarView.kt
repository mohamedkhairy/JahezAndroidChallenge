package net.jahez.jahezchallenge.presentation.ui.components

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jahez.jahezchallenge.R

@Composable
fun SpinnerView(onSelect:(Int) -> Unit) {
    val sampleList = mutableListOf("Sample 1", "Sample 2", "Sample 3", "Sample 4", "Sample 5")
    var sampleName: String by remember { mutableStateOf(sampleList[0]) }
    var expanded by remember { mutableStateOf(false) }
//    val transitionState = remember {
//        MutableTransitionState(expanded).apply {
//            targetState = !expanded
//        }
//    }

//    val transition = updateTransition(targetState = transitionState, label = "transition")
//    val arrowRotationDegree by transition.animateFloat({
//        tween(durationMillis = 300)
//    }, label = "rotationDegree") {
//        if (expanded) 180f else 0f
//    }

    val context = LocalContext.current
//    val dateTime = viewModel.time.observeAsState()

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Red),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
        Row(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))

//        Column {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Spinner",
//                    fontSize = 20.sp,
//                    color = Color.Black,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .clickable {
                            expanded = !expanded
                        }
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Menu",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Spinner",
//                        modifier = Modifier.rotate(arrowRotationDegree)
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        sampleList.forEachIndexed { index, s ->
                            DropdownMenuItem(
                                onClick = {
                                    expanded = false
                                    sampleName = s
                                    onSelect(index)
                                }
                            ) {
                                Text(text = s)
                            }
                        }
                    }
                }
//            }
        }
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(0.5f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Calender Date & Time Picker",
//                    fontSize = 20.sp,
//                    color = Color.Black,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                TextButton(
//                    onClick = {
//                        viewModel.selectDateTime(context)
//                    },
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(10.dp))
//                        .background(Color.Blue)
//                        .padding(5.dp)
//                ) {
//                    Text(text = "Select Date", color = Color.White)
//                }
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                Text(text = dateTime.value ?: "No Time Set")
//            }
//        }
//    }
}