package com.example.roomdatabase.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database([User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao():UserDao

}