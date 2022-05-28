package com.example.checkstatusatwork.data.User

import androidx.lifecycle.MutableLiveData
import com.example.checkstatusatwork.model.User

class UserRepository(
    val userRemoteDataSource: UserRemoteDataSource,
    val userLocalDataSource: UserLocalDataSource) {

//     var userInfo:User? = null
       lateinit var userInfo:User
//    var userInfo = MutableLiveData<User>()
    //TODO check null
    suspend fun addUser(user:User):User?{
       return userRemoteDataSource.register(user).data!!
//        return userInfo
//        return userRemoteDataSource.register(user).data
    }

    suspend fun getUser(id:String):User{
      userInfo =   userRemoteDataSource.getUser(id)
        return userInfo
    }

    suspend fun getUserList():List<User>{
        return userRemoteDataSource.getUserList()
    }
}