package com.example.unittesting.room_testing

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 2)
abstract class QuotesDatabase: RoomDatabase() {
    abstract fun quoteDao(): QuotesDao
}