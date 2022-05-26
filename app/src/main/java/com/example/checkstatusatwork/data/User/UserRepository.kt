package com.example.checkstatusatwork.data.User

import com.example.checkstatusatwork.model.User

class UserRepository(
    val userRemoteDataSource: UserRemoteDataSource,
    val userLocalDataSource: UserLocalDataSource) {

    lateinit var userInfo:User
    suspend fun addUser(user:User):User{
        userInfo = userRemoteDataSource.addUser(user)
        return userInfo
    }
}