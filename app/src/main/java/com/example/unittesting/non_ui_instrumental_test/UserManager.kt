package com.example.unittesting.non_ui_instrumental_test


import android.content.Context
import com.google.gson.Gson

class UserManager {

     var userList = emptyArray<User>()
     var currentUserIndex = 0

    fun populateUserFromAssets(context: Context, fileName: String){
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        userList = gson.fromJson(json, Array<User>::class.java)
    }

    fun populateUsers(user: Array<User>){
        userList = user
    }

    fun getCurrentUser(): User {
        return userList[currentUserIndex]
    }

    fun getNextUser(): User {
        if (currentUserIndex == userList.size - 1) return userList[currentUserIndex]
        return userList[++currentUserIndex]
    }

    fun getPreviousUser(): User {
        if (currentUserIndex == 0) return userList[currentUserIndex]
        return userList[--currentUserIndex]
    }

}