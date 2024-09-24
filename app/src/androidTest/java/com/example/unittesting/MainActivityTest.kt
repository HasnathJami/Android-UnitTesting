package com.example.unittesting


import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    //common part is rule part where it's applicable for all Test's
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testSendButton_expectedCorrectValues() {
        onView(withId(R.id.et_name)).perform(typeText("Hasnath"), closeSoftKeyboard())

        onView(withId(R.id.btn_send)).perform(click())
        onView(withId(R.id.btn_send)).perform(click())
        onView(withId(R.id.btn_send)).perform(click())

        onView(withId(R.id.tv_name)).check(matches(withText("Hasnath")))
    }

    //It'll Be Failed As We Have Not Applied Implicit Intent on Button Click
    @Test
    fun testShareButton_expectedIntentChooser(){
        Intents.init()

        val expected = allOf(hasAction(Intent.ACTION_SEND))

        onView(withId(R.id.btn_send)).perform(click())
        intended(expected)

        Intents.release()
    }

}