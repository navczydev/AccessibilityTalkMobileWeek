package com.example.accessibilitytalkmobileweek

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MergeChildernDemo() {
    var isFavorite: Boolean by remember {
        mutableStateOf(false)
    }
    val clickLabel =
        if (isFavorite) stringResource(id = R.string.unfavorite) else stringResource(id = R.string.favorite)
    val actionLabel = stringResource(if (isFavorite) R.string.favorite else R.string.unfavorite)

    Box(contentAlignment = Alignment.TopEnd) {
        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = {
                isFavorite = isFavorite.not()
            },
            modifier = Modifier
                .semantics {
                    onClick(label = clickLabel) {
                        isFavorite = isFavorite.not()
                        true
                    }
                    this.stateDescription = actionLabel
                }
            //.focusRequester(item2)
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = null,
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(
                    border = BorderStroke(2.dp, color = Color.Green),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(Dimens.paddingMedium)
                .semantics(mergeDescendants = true) {}

        ) {
            Image(
                painter = painterResource(id = R.drawable.img_2033_gde_badge),
                contentDescription = "Profile image",
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )
            Text(text = "Nav Singh")
            Text(text = "Android Engineer")
            /*Text(
                text = "$45/day",
                modifier = Modifier.semantics {
                    text = AnnotatedString("45 dollars per day")
                    //                contentDescription = "$45 dollars per day"
                })*/
        }
    }

}