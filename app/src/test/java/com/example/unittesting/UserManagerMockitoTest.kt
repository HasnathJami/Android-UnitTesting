package com.example.unittesting

import android.content.Context
import android.content.res.AssetManager
import com.example.unittesting.non_ui_instrumental_test.UserManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.io.InputStream

class UserManagerMockitoTest {

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var assetManager:AssetManager

    @Before
    fun setup() {
      MockitoAnnotations.openMocks(this)
    }

    @Test
    fun test() {
        val testStream: InputStream = UserManagerMockitoTest::class.java.getResourceAsStream("/mocks.json")
        //val context = Mockito.mock(Context::class.java) //if we don't want to use the above @Mock annotations
        //val assetManager = Mockito.mock(AssetManager::class.java)
        Mockito.`when`(context.assets).thenReturn(assetManager)
        //doReturn(assetManager).`when`(context).assets //same like above line as it return AssetManager object
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val obj = UserManager()
        obj.populateUserFromAssets(context, "")
        val user = obj.getCurrentUser()
        Assert.assertEquals("mock1@gmail.com",user.email)
    }

}