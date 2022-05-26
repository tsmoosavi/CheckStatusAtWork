package com.example.checkstatusatwork.data.User

import com.example.checkstatusatwork.data.network.ApiService
import com.example.checkstatusatwork.data.network.StatusApi
import com.example.checkstatusatwork.model.User

class UserRemoteDataSource(val apiService: ApiService) {
//id: String,name:String,password: Int, avatarUrl: String
    suspend fun addUser(user:User):User{
       return StatusApi.retrofitService.register(user)
    }

}