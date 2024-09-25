package com.example.unittesting.mockito_implementation

import com.example.unittesting.mockito_implmentation.LOGIN_STATUS
import com.example.unittesting.mockito_implmentation.UserRepository
import com.example.unittesting.mockito_implmentation.UserService
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService() {
        val sut = UserService(userRepository)
        val status = sut.loginUser("j@gmail.com", "123456")
        Assert.assertEquals("Password is invalid", status)
    }

    @After
    fun tearDown() {

    }
}
