package com.example.accessibilitytalkmobileweek

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    /* @get:Rule
     var activityRule: ActivityScenarioRule<MainActivity> =
         ActivityScenarioRule(MainActivity::class.java)
 */
    @Rule
    @JvmField
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    init {
        AccessibilityChecks.enable()
            .setRunChecksFromRootView(true)
    }

    @Test
    fun testText1() {
        onView(withId(R.id.textview_1)).check(matches(isDisplayed()))
        onView(withId(R.id.imageview_logo_holder)).perform(click())
    }

    @Test
    fun testGreeting() {
        val greeting = InstrumentationRegistry.getInstrumentation()
            .targetContext.resources.getString(R.string.greeting)

        composeTestRule.onNodeWithText(greeting).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Share your stuff").performClick()
    }

    /*   companion object {
           @BeforeClass
           @JvmStatic
           fun enableAccessibilityChecks() {
               AccessibilityChecks.enable().setRunChecksFromRootView(true)
           }
       }*/
}
