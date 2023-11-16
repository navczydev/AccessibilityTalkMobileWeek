package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainComposable(
    onClick: () -> Unit = {},
    clicked: () -> Boolean,
) {
    val (item1, item2) = remember { FocusRequester.createRefs() }

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null,
                modifier = Modifier
                    .focusRequester(item1)
                    .onFocusChanged {
                    }
                    .focusProperties {
                        left = item2
                        up = FocusRequester.Cancel
                    }
                    .focusable()
            )
            Image(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = null,
                modifier = Modifier
                    .focusRequester(item2)
                    .onFocusChanged {
                    }
                    .focusProperties {
                        this.left = item1
                        up = FocusRequester.Cancel
                    }
            )
        }
        MediumSpacer()
        MergeChildernDemo()
        MediumSpacer()
        ColumnSelectableGroupDemo()
        MediumSpacer()
        SingleRadioButtonDemo()
        ToggleableRowDemo()
        MediumSpacer()
        ClickableRowDemo()
        MediumSpacer()
        TraversalGroupDemo()
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMainComposable() {
    MaterialTheme {
        MainComposable {
            true
        }
    }
}