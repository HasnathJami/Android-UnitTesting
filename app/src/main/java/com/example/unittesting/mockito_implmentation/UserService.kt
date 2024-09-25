package com.example.unittesting.mockito_implmentation

import com.example.unittesting.mockito_implmentation.LOGIN_STATUS.INVALID_PASSWORD
import com.example.unittesting.mockito_implmentation.LOGIN_STATUS.INVALID_USER
import com.example.unittesting.mockito_implmentation.LOGIN_STATUS.SUCCESS
import com.example.unittesting.mockito_implmentation.LOGIN_STATUS.UNKNOWN_ERROR

class UserService(private val userRepository: UserRepository) {
    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when (status) {
            INVALID_USER -> "User does not exist"
            INVALID_PASSWORD -> "Password is invalid"
            UNKNOWN_ERROR -> "Unknown error occurred"
            SUCCESS -> "Logged in successfully"
        }
    }
}