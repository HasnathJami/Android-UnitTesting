package com.example.unittesting.mockito_implementation

import android.content.Context
import android.content.res.AssetManager
import com.example.unittesting.non_ui_instrumental_test.UserManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserManagerTest {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun test() {
        val testStream = UserManagerTest::class.java.getResourceAsStream("/users.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val sut = UserManager()
        sut.populateUserFromAssets(context,"")
        val user = sut.getCurrentUser()
        Assert.assertEquals("Hasnath Jami", user.name)

    }
}