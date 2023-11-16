package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SingleRadioButtonDemo() {
    Column {
        var checked by remember { mutableStateOf(false) }
        Text(text = "RadioButton with its own click listener")
        MediumSpacer()
        Row(
            modifier = Modifier
                // .sizeIn(minHeight = 48.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = checked, onClick = { checked = checked.not() })
            MediumSpacer()
            Text(text = "Item1")
        }
    }
}