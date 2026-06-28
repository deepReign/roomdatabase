package com.example.roomdatabase.data

import com.example.roomdatabase.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao
) : UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return dao.getAllUsers()
    }

    override suspend fun insert(user: User) {
        dao.insert(user)
    }

    override suspend fun deleteAllUsers() {
        dao.deleteAllUsers()
    }

    override suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    override suspend fun updateUser(user: User) {
        dao.update(user)
    }
}