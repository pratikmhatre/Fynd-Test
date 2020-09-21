package com.example.cavista_test.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FeedsTable::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getFeedsDao(): FeedsTableDao
}