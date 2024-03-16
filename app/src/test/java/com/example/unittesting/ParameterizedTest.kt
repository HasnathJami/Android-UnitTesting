package com.example.unittesting

import com.example.unittesting.utils.Helper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedTest(private val input: Int, private val expectedValue: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isEven(input)
        Assert.assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is even number - {1} ")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf(10, true),
                arrayOf(11, false)
            )
        }
    }
}