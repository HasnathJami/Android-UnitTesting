package com.example.unittesting.mockito_implmentation

class UserRepository {

    val users = listOf<User>(
        User(1, "Jami", "j@gmail.com", "123456"),
        User(2, "Hasnath", "h@gmail.com", "456789"),
        User(3, "Chowdhury", "c@gmail.com", "234567")
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        //Fetch User from DB

        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}