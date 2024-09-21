package com.example.unittesting.utils

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PalindromeHelperTest {

    lateinit var helper: PalindromeHelper

    @Before
    fun setUp() {
        println("Before Every Test Case")

        //Arrange
        helper = PalindromeHelper()
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun isPalindrome() {

        //Act
        val result = helper.isPalindrome("hello")

        //Assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Arrange
        val helper = PalindromeHelper()

        //Act
        val result = helper.isPalindrome("level")

        //Assert
        assertEquals(true, result)
    }
}