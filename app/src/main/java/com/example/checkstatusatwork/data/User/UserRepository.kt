package com.example.checkstatusatwork.data.User

import com.example.checkstatusatwork.model.User

class UserRepository(
    val userRemoteDataSource: UserRemoteDataSource,
    val userLocalDataSource: UserLocalDataSource) {

//     var userInfo:User? = null
    //TODO check null
    suspend fun addUser(user:User):User?{
//        userInfo = userRemoteDataSource.register(user).data
//        return userInfo
        return userRemoteDataSource.register(user).data
    }

    suspend fun getUser(id:String):User{
        return userRemoteDataSource.getUser(id)
    }

    suspend fun getUserList():List<User>{
        return userRemoteDataSource.getUserList()
    }
}