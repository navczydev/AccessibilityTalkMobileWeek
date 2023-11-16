package com.example.accessibilitytalkmobileweek

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LiveChatFab(
    modifier: Modifier = Modifier,
    isShrink: Boolean,
    onClose: () -> Unit,
    onLiveChatClick: () -> Unit
) {

    val tintColor = Color(0xFFD0BCFF)

    ElevatedCard(
        shape = RoundedCornerShape(Dimens.shapeRadius16dp),
        modifier = modifier
            .padding(Dimens.paddingMedium)
            .height(56.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color(0xFF2B2930))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = Dimens.paddingMedium,
                top = Dimens.paddingMedium,
                end = if (isShrink) Dimens.paddingMedium else 0.dp,
                bottom = Dimens.paddingMedium
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .sizeIn(minHeight = 48.dp)
                    .clickable(role = Role.Button) {
                        onLiveChatClick()
                    }
            ) {
                // Icon - chat
                Icon(
                    painterResource(id = R.drawable.ic_chat),
                    contentDescription = null,
                    tint = tintColor
                )
                // Text - LiveChat
                AnimatedVisibility(visible = !isShrink) {
                    Text(
                        text = stringResource(id = R.string.live_chat),
                        modifier = Modifier.padding(start = Dimens.paddingWedge),
                        style = MaterialTheme.typography.bodyMedium.copy(color = tintColor)
                    )
                }
            }
            // Action - close
            AnimatedVisibility(visible = !isShrink) {
                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.btn_close_content_description),
                        tint = tintColor
                    )
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PrevLiveChatFab() {
    MaterialTheme {
        LiveChatFab(isShrink = false, onClose = {}, onLiveChatClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PrevLiveChatFabShrink() {
    MaterialTheme {
        LiveChatFab(isShrink = true, onClose = {}, onLiveChatClick = {})
    }
}