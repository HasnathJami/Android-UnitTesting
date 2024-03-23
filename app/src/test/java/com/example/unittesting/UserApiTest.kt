package com.example.unittesting

import com.example.unittesting.retrofit_with_mock_web_server.ApiInterface
import com.example.unittesting.utils.Helper
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var apiInterface: ApiInterface

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        apiInterface = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testGetUsers() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)


        val response = apiInterface.getUsers()
        mockWebServer.takeRequest()

        Assert.assertEquals(true, response.body()!!.isEmpty())
    }

    @Test
    fun testGetUsers_return_response() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)


        //mockResponse.setBody("[]")
         val content = Helper().readFileResource("/users.json")
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)


        val response = apiInterface.getUsers()
        println(response.toString())
        mockWebServer.takeRequest()

        Assert.assertEquals(false, response.body()!!.isEmpty())
        Assert.assertEquals(2, response.body()!!.size)
    }
}