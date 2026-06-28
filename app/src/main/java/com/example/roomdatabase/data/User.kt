package com.example.roomdatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val firstname: String,
    val secondName: String,
    val age: Int,
    val mail: String = ""
)
