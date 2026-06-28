package com.example.roomdatabase.di

import com.example.roomdatabase.data.UserRepositoryImpl
import com.example.roomdatabase.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        repositoryImpl: UserRepositoryImpl
    ): UserRepository
}