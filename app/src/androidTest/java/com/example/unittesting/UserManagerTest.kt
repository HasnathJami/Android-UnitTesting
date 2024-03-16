package com.example.unittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.unittesting.non_ui_instrumental_test.User
import com.example.unittesting.non_ui_instrumental_test.UserManager
import com.google.gson.JsonSyntaxException
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class UserManagerTest {

    private lateinit var context: Context
    private lateinit var userManager: UserManager

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        userManager = UserManager()
    }

    @Test(expected = FileNotFoundException::class)
    fun populateUsersFromAssets() {

        userManager.populateUserFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateUsersFromAssets_InvalidJSON_expected_Exception() {
        userManager.populateUserFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateUsersFromAssets_ValidJSON_expected_Count() {
        userManager.populateUserFromAssets(context, "users.json")
        Assert.assertEquals(2, userManager.userList.size)
    }

    @Test
    fun testPreviousUser_expected_CorrectUser() {
        userManager.populateUsers(
              arrayOf(
                  User("Jishan", "j@gmail.com"),
                  User("Jami", "jami@gmail.com")
              )
          )
        val user = userManager.getPreviousUser()
        Assert.assertEquals("j@gmail.com", user.email)
    }

    @Test
    fun testNextUser_expected_CorrectUser() {
        userManager.populateUsers(
            arrayOf(
                User("Jishan", "j@gmail.com"),
                User("Jami", "jami@gmail.com")
            )
        )
        val user = userManager.getNextUser()
        Assert.assertEquals("jami@gmail.com", user.email)
    }
}