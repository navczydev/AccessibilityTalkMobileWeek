package com.example.accessibilitytalkmobileweek

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ToggleableRowDemo() {
    val context = LocalContext.current

    var checked by remember {
        mutableStateOf(false)
    }

    MaterialTheme {
        Column {

            Row(
                modifier = Modifier
                    .toggleable(
                        value = checked,
                        role = Role.Switch,
                        onValueChange = { checked = checked.not() },
                    )
                    .fillMaxWidth()
                    .semantics(mergeDescendants = false) {
                        customActions = listOf(
                            CustomAccessibilityAction(
                                label = "Add to account",
                                action = {
                                    Toast
                                        .makeText(context, "Details...", Toast.LENGTH_SHORT)
                                        .show()
                                    true
                                }
                            ),
                            CustomAccessibilityAction(
                                label = "Update information",
                                action = {
                                    Toast
                                        .makeText(context, "Details...", Toast.LENGTH_SHORT)
                                        .show()
                                    true
                                }
                            )
                        )
//                onLongClick("long clicked") { clicked() }
//                onClick("single click") { clicked.invoke() }
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "In app notifications")
                Switch(
                    checked = checked,
                    onCheckedChange = null,
                )
            }
            MediumSpacer()
            var checked1 by remember {
                mutableStateOf(false)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "In app notifications")
                Switch(
                    checked = checked1,
                    onCheckedChange = { checked1 = checked1.not() },
                )
            }
        }
    }
}

