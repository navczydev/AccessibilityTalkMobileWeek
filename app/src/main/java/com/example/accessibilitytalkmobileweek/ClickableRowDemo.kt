package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, fontScale = 2.0f)
@PreviewFontSize
@Composable
fun ClickableRowDemo() {
    MaterialTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                // Automatically merges the children
                .clickable(
                    role = Role.Button,
                    onClickLabel = "modify account settings"
                ) {},
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Account settings")
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = null
            )
        }
    }
}