package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SelectableRowDemo(itemLabel: String) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            // .sizeIn(minHeight = 48.dp)
            .selectable(
                selected = false,
                role = Role.RadioButton
            ) {
                checked = checked.not()
            }
            .fillMaxWidth()
            .padding(Dimens.paddingMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = checked, onClick = null)
        MediumSpacer()
        Text(text = itemLabel)
    }
}

@Preview(showBackground = true)
@Composable
fun PrevSelectableRow() {
    MaterialTheme {
        SelectableRowDemo("Item label")
    }
}