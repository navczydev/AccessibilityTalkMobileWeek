package com.example.accessibilitytalkmobileweek

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.accessibilitytalkmobileweek.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
            .also { setContentView(it.root) }


        activityMainBinding.cvHolder.setContent {
            MaterialTheme { // or AppCompatTheme
                MainComposable(
                    clicked = {
                        true
                    },
                )
            }
        }



        activityMainBinding.imgvLogoHolder.contentDescription = "ContentDescriptions goes here..."

        activityMainBinding.tvTimer.accessibilityDelegate = object : View.AccessibilityDelegate() {
            override fun onInitializeAccessibilityNodeInfo(
                host: View,
                info: AccessibilityNodeInfo
            ) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                // Android14 - Frequency of announcements - When to use - Timer, Progress, video, seek info etc.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    info.minDurationBetweenContentChanges = Duration.ofSeconds(10L)
                }
            }
        }

        showTimer()

        // Add custom actions
        ViewCompat.addAccessibilityAction(
            // View to add accessibility action
            /* view = */ activityMainBinding.imgvLogoHolder,
            // Label surfaced to user by an accessibility service
            /* label = */ getText(R.string.favorite)
        )
        /* command = */ { view, commandArguments ->
            // Same method executed when swiping on itemView
            Toast.makeText(view.context, "Toast from custom action", Toast.LENGTH_SHORT).show()
            true
        }


        ViewCompat.replaceAccessibilityAction(
            // View that contains touch & hold action
            activityMainBinding.btnOpenDetails,
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK,
            // Announcement read by TalkBack to surface this action
            getText(R.string.see_more_account_options),
            null
        )

        ViewCompat.setAccessibilityDelegate(
            activityMainBinding.btnOpenDetails,
            BalanceDetailsAccessibilityDelegate()
        )

        lifecycleScope.launch {
            delay(10000)
            activityMainBinding.tvError.isVisible = true
        }

        activityMainBinding.btnOpenDetails.setOnLongClickListener {
            Toast.makeText(it.context, "Toast from long click event", Toast.LENGTH_SHORT).show()
            true
        }

        activityMainBinding.btnHeading.setOnClickListener {
            val intent = Intent(this, HeadingDemoActivity::class.java)
            startActivity(intent)
        }


    }

    private fun showTimer() {

        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                activityMainBinding.tvTimer.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                activityMainBinding.tvTimer.text = getString(R.string.done)
            }
        }.start()
    }
}


