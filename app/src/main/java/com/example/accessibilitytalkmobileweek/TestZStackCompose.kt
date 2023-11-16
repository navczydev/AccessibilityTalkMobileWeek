package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(/*showBackground = true*/)
@Composable
fun ZStackCompose() {
    // ZStack
    Box(
        modifier = Modifier
            .requiredWidth(600.dp)
            .requiredHeight(intrinsicSize = IntrinsicSize.Min)
            .background(Color.Green),
        propagateMinConstraints = true
    ) {
        // 200 X 80 but its 200 X 200
        Box(
            contentAlignment = Alignment.Center,
          //  modifier = Modifier.background(Color.Red)
        ) {
            Image(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier
                    .background(Color.Blue)
                    .width(80.dp)
                    .aspectRatio(ratio = 1f)
            )
        }

    }
}