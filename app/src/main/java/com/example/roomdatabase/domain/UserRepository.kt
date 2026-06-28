package com.example.roomdatabase.domain

import com.example.roomdatabase.data.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun insert(user: User)
    suspend fun deleteAllUsers()
    suspend fun deleteUser(user:User)
    suspend fun updateUser(user: User)

}