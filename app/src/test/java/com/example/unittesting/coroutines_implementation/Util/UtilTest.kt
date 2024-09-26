package com.example.unittesting.coroutines_implementation.Util

import com.example.unittesting.coroutines_implementation.Util
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilTest {
    // private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        //Dispatchers.setMain(testDispatcher)
    }

//    @Test
//    fun testGetUser() {
//        val sut = Util(mainCoroutineRule.testDispatcher)
////        runBlocking {
////            sut.getUserName()
////        }
//        runTest {
//            sut.getUser()
//        }
//
//    }

    @Test
    fun testGetAddressDetail() {
        val sut = Util(mainCoroutineRule.testDispatcher)
//        runBlocking {
//            sut.getUserName()
//        }
        runTest {
            sut.getAddressDetail()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true, sut.globalArg)
        }

    }

    @After
    fun tearDown() {
        //  Dispatchers.resetMain()

    }
}