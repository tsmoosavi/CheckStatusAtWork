package com.example.checkstatusatwork.data.User

class UserRepository(
    val userRemoteDataSource: UserRemoteDataSource,
    val userLocalDataSource: UserLocalDataSource) {
}