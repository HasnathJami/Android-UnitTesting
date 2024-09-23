package com.example.unittesting.utils

import org.junit.Assert
import org.junit.Test

class StringTest {

    @Test
    fun testStringReversal_EmptyString_expectedEmptyString() {
        val sut = Helper()
        val result = sut.reverseString("")
        Assert.assertEquals("", result)
    }

    @Test
    fun testStringReversal_SingleChar_expectedSingleChar() {
        val sut = Helper()
        val result = sut.reverseString("a")
        Assert.assertEquals("a", result)
    }

    @Test
    fun testStringReversal_ValidInput_expectedSameString() {
        val sut = Helper()
        val result = sut.reverseString("Gone")
        Assert.assertEquals("enoG", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullValue_expectedException() {
        val sut = Helper()
        val result = sut.reverseString(null)
    }



}