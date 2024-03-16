package com.example.unittesting

import com.example.unittesting.utils.Helper
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HelperTest {

    private lateinit var helper: Helper

    @Before
    fun setUp() {
        println("Before Every Test Case")

        //Arrange
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }

    @Test
    fun isEven_inputNumber_level_expected_true() {
        //Act
        val result = helper.isEven(10)
        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isEven_inputNumber_level_expected_false() {
        val result = helper.isEven(11)
        assertEquals(false, result)
    }
}