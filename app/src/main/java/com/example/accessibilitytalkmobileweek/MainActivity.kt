package com.example.accessibilitytalkmobileweek

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.google.android.material.composethemeadapter.MdcTheme
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var action: (() -> Boolean) = {
        Random.nextInt(8000) % 2 == 0
    }

    @ExperimentalUnitApi
    @ExperimentalComposeUiApi
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
                    clicked = action,
                    isFavorite = true
                )
            }
        }
    }
}

@ExperimentalUnitApi
@ExperimentalComposeUiApi
@Composable
private fun Greeting(
    onClick: () -> Unit = {},
    clicked: (() -> Boolean)?,
    isFavorite: Boolean = false
) {
    val actionLabel = stringResource(
        if (isFavorite) R.string.unfavorite else R.string.favorite
    )
// First, get a reference to two focus requesters
    val (first, second) = FocusRequester.createRefs()
    val second1 = FocusRequester.createRefs()

    Column(
        Modifier
            // .clickable(onClick = {})
            .fillMaxWidth(),
        /*.semantics(mergeDescendants = false) {
            //  customActions = listOf(CustomAccessibilityAction(actionLabel, clicked))
            onLongClick("Long click", null)
            onClick("single click") { clicked?.invoke() ?: false }
        }*/
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        val focusManager = LocalFocusManager.current
        Image(
            imageVector = Icons.Filled.ThumbUp,
            contentDescription = null,
            modifier = Modifier
                .focusOrder(first) {
                    this.down = second

                }
                .focusable(true)
                .focusTarget()

        )

        // Jetpack Compose live templates
        Text(
            text = "Hello World",
            modifier = Modifier
                .focusTarget()
                .focusOrder(first) {
                    down = second
                    // this.
                }
        )

        IconButton(
            onClick = {
                // second.requestFocus()
            },
            modifier = Modifier
                .semantics(mergeDescendants = false) {
                    contentDescription = "Share your stuff"
                }
                .fillMaxWidth()
            // .width(200.dp)
//                .wrapContentSize()
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.CenterHorizontally, unbounded = true)
            ) {
//                Text(text = "Share your stuff")
                Icon(
                    imageVector = Icons.Filled.Share,
//                contentDescription = stringResource(R.string.label_share),
                    contentDescription = "Share me property ",
                    // Clear any semantics properties set on this node
                    //   Modifier.clearAndSetSemantics { }
                    Modifier
                        .semantics {
                            // TODO check which works
                            contentDescription = "Share me modifier"

                            //onClick("Click me to share", clicked)
                        }
                     .clearAndSetSemantics {

                     }
                )
            }
        }
        /* + buildAnnotatedString {
                //  append("Hello")
                pushStyle(
                    SpanStyle(Color.Red, 48.sp, FontWeight.Bold, FontStyle.Italic),
                )
                append("Jetpack compose")
                addStyle(SpanStyle(Color.Red, 48.sp, FontWeight.Bold, FontStyle.Italic),0,this.length)
                //pop()
                // addStyle(SpanStyle(Color.Green, 32.sp), 5, length)
                // append("link: Jetpack Compose")
                // attach a string annotation that stores a URL to the text "Jetpack Compose".
                *//*addStringAnnotation(
                    tag = "URL",
                    annotation = "https://developer.android.com/jetpack/compose",
                    start = 6,
                    end = 21
                )*//*
            }.text*/
        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold, fontSize = 48.sp
                )
            ) {
                append("Click ")
            }

            // We attach this *URL* annotation to the following content
            // until `pop()` is called
            pushStringAnnotation(
                tag = "URL",
                annotation = "https://developer.android.com"
            )
            /*pushStyle(
                SpanStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold, fontSize = 48.sp
                )
            )*/
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold, fontSize = 48.sp
                )
            ) {
                append("here")
            }
            // append("test pop")
            pop()
            // append("after pop")
        }

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                // We check if there is an *URL* annotation attached to the text
                // at the clicked position
                annotatedText.getStringAnnotations(
                    tag = "URL", start = offset,
                    end = offset
                )
                    .firstOrNull()?.let { annotation ->
                        // If yes, we log its value
                        Log.d("Clicked URL", annotation.item)
                    }
            }
        )
        Text(
            text = buildAnnotatedString {
                pushStyle(style = SpanStyle(color = Color.Blue))
                append("H")
                pop()
                append("ello")
                pushStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red))
                append("C")
                pop()
                append("ompose")
            },
//            text = stringResource(R.string.greeting),
            style = MaterialTheme.typography.h5.copy(fontSize = TextUnit(32.0F, TextUnitType.Sp)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.margin_small))
                .wrapContentWidth(Alignment.CenterHorizontally)
                .semantics {
                    liveRegion = LiveRegionMode.Polite
                    heading()
                    onClick {
                        clicked?.invoke() ?: false
                    }
                }
                .focusOrder(second) {
                    this.down = second
                }
                .onFocusChanged { focusState ->
                    with(focusState) {
                        when {
                            hasFocus -> {
                                println("A child of mine has focus!")
                            }
                            isFocused -> {
                                println("I'm focused!")
                            }
                        }
                    }
                }
                .focusRequester(second)
//
            /* .focusOrder(second) {
                 next = first
             }
             .onFocusChanged {
             }*/
        )

        /*Text(
            text = "FocusRequester",
            modifier = Modifier
                .focusRequester(second)
        )*/

        Text(
            text = "Live templates Jetpack Compose",
        )
    }
}

@ExperimentalComposeUiApi
@ExperimentalUnitApi
@Preview(showBackground = true, backgroundColor = 0X33d40b)
@Composable
fun PreviewGreeting() {
    Greeting(
        clicked = null,
        isFavorite = true
    )
}
