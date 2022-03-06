package net.jahez.jahezchallenge.presentation.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jahez.jahezchallenge.R

@Composable
fun SpinnerView(onSelect:(Int) -> Unit) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    val menuArray = context.resources.getStringArray(R.array.menu_item)



        Row(
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
                        text = stringResource(id = R.string.menu),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Spinner",
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        menuArray.forEachIndexed { index, s ->
                            DropdownMenuItem(
                                onClick = {
                                    expanded = false
//                                    sampleName = s
                                    onSelect(index)
                                }
                            ) {
                                Text(text = s)
                            }
                        }
                    }
                }
        }

}