package com.example.unittesting.retrofit_with_mock_web_server

import com.example.unittesting.non_ui_instrumental_test.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}