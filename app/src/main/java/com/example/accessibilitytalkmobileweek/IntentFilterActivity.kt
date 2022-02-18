package com.example.accessibilitytalkmobileweek

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntentFilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_filter)

        findViewById<TextView>(R.id.from_intent).text = intent?.getStringExtra("data") ?: "sd"
    }
}
