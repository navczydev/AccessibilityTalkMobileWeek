package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview

// CardBox() function takes in top and bottom sample text.
@Composable
fun CardBox(
    topSampleText: String,
    bottomSampleText: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.semantics { isTraversalGroup = true }
    ) {
        Text(
            text = topSampleText,
            modifier = Modifier.semantics {
                traversalIndex = 0.2f
            })
        Text(
            text = bottomSampleText,
            modifier = Modifier.semantics {
                traversalIndex = 0.2f
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TraversalGroupDemo() {
    val text1 = "One"
    val text2 = "Two"
    val text3 = "Three"
    val text4 = "Four"
    MaterialTheme {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardBox(
                    text1,
                    text2,
                    /*Modifier.semantics { isTraversalGroup = true }*/
                )
                CardBox(
                    text3,
                    text4,
                    /*Modifier.semantics { isTraversalGroup = true }*/
                )
            }
            Text(
                text = "Custom traversal Order",
                style = MaterialTheme.typography.headlineMedium
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardBox(
                    text1,
                    text2,
                    Modifier.semantics { isTraversalGroup = true }
                )
                CardBox(
                    text3,
                    text4,
                    Modifier.semantics { isTraversalGroup = true }
                )
            }
        }
    }
}