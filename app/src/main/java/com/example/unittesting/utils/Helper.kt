package com.example.unittesting.utils

import java.io.InputStreamReader


class Helper {

    fun isEven(number: Int): Boolean {
        return (number % 2 == 0)
    }

    fun readFileResource(fileName:String) :String {
        val inputStream = Helper::class.java.getResourceAsStream(fileName)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream, "UTF-8")
        reader.readLines().forEach {
            builder.append(it)
        }
        return builder.toString()
    }

}