package com.example.accessibilitytalkmobileweek

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.unit.dp
import com.google.android.material.composethemeadapter.MdcTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.imageview_logo_holder).setOnClickListener { // open camera
            /*val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivity(takePictureIntent)
            } catch (e: ActivityNotFoundException) {
                // display error state to the user
            }*/
            // Android 12 Toast improvement
            Toast.makeText(this, "Toast from Android 12", Toast.LENGTH_LONG).show()
        }

        val greetingFromCompose = findViewById<ComposeView>(R.id.greeting)

        greetingFromCompose.setContent {
            MdcTheme { // or AppCompatTheme
                Greeting(
                    clicked = {

                        true
                    },
                    isFavorite = true
                )
            }
        }
    }
}

@Composable
private fun Greeting(
    onClick: () -> Unit = {},
    clicked: () -> Boolean,
    isFavorite: Boolean = false
) {
    val actionLabel = stringResource(
        if (isFavorite) R.string.unfavorite else R.string.favorite
    )

    Column(
        Modifier
            // .clickable(onClick = {})
            .fillMaxWidth()
            .semantics(mergeDescendants = false) {
                //  customActions = listOf(CustomAccessibilityAction(actionLabel, clicked))
//                onLongClick("long clicked") { clicked() }
//                onClick("single click") { clicked.invoke() }
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(imageVector = Icons.Filled.ThumbUp, contentDescription = null)
        IconButton(
            onClick = {
            },
            modifier = Modifier
                .semantics(mergeDescendants = true) {
                    contentDescription = "Share your stuff"
                }
                .width(200.dp)
                .height(200.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
//                contentDescription = stringResource(R.string.label_share),
                contentDescription = null,
                // Clear any semantics properties set on this node
                Modifier
                    .clearAndSetSemantics { }
                /*Modifier.semantics {
                    onClick("Click me to share") { clicked.invoke() }
                }*/
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.greeting),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.margin_small))
                .wrapContentWidth(Alignment.CenterHorizontally)
                .semantics {
                    // liveRegion = LiveRegionMode.Assertive
                    heading()
                }
        )
    }
}
