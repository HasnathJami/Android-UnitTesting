package com.example.unittesting.utils

import org.junit.Assert
import org.junit.Test

class PasswordTest {

    @Test
    fun validatePassword_blankInput_expectedRequiredField() {
        //Arrange
        val sut = Helper()
        //Act
        val result = sut.validatePassword("     ")
        //Assert
        Assert.assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2CharInput_expectedValidationMsg() {
        val sut = Helper()
        val result = sut.validatePassword("ab")
        Assert.assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun validatePassword_CorrectInput_expectedValidPassword() {
        val sut = Helper()
        val result = sut.validatePassword("Test12345")
        Assert.assertEquals("Valid", result)
    }

}