package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ColumnSelectableGroupDemo() {
    Column(
        modifier = Modifier
            .selectableGroup()
            .fillMaxWidth()
    ) {
        SelectableRowDemo("Item1")
        MediumSpacer()
        SelectableRowDemo("Item2")
        MediumSpacer()
        SelectableRowDemo("Item3")
    }
}