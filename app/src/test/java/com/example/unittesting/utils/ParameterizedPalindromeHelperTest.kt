package com.example.unittesting.utils

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(value = Parameterized::class)
class ParameterizedPalindromeHelperTest(
    private val input: String,
    private val expectedValue: Boolean
) {

    private lateinit var helper: PalindromeHelper

    @Before
    fun setUp() {
//        println("Before Every Test Case")

        //Arrange
        helper = PalindromeHelper()
    }

    @After
    fun tearDown() {
//        println("After Every Test Case")
    }

    @Test
    fun isPalindrome() {

        //Act
        val result = helper.isPalindrome(input)

        //Assert
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} is palindrome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", true),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}