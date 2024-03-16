package com.example.unittesting


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testSendButton_expectedCorrectValues() {
        onView(withId(R.id.et_name)).perform(typeText("Hasnath"), closeSoftKeyboard())
        onView(withId(R.id.btn_send)).perform(click())

        onView(withId(R.id.tv_name)).check(matches(withText("Hasnath")))
    }

}