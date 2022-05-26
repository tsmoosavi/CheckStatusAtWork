package com.example.checkstatusatwork.domain

import com.example.checkstatusatwork.data.User.UserRemoteDataSource
import com.example.checkstatusatwork.data.User.UserRepository

class Container {
    val remoteDataSource = UserRemoteDataSource()
    val repository = UserRepository(remoteDataSource)
}