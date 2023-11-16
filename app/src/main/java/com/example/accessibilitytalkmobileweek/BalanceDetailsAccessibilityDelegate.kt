package com.example.accessibilitytalkmobileweek

import android.view.View
import android.view.accessibility.AccessibilityNodeInfo
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat

class BalanceDetailsAccessibilityDelegate : AccessibilityDelegateCompat() {

    override fun onInitializeAccessibilityNodeInfo(host: View, info: AccessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(host, info)

        val click = AccessibilityNodeInfoCompat.AccessibilityActionCompat(
            AccessibilityNodeInfo.ACTION_CLICK,
            // “Open bal”ance details
            host.context.getString(R.string.check_balance_details)
        )
        info.addAction(click)
    }
}