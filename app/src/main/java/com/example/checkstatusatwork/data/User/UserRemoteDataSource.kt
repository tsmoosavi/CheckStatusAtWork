package com.example.checkstatusatwork.data.User

import com.example.checkstatusatwork.data.network.ApiService
import com.example.checkstatusatwork.data.network.StatusApi
import com.example.checkstatusatwork.model.Resource
import com.example.checkstatusatwork.model.Status
import com.example.checkstatusatwork.model.User
import java.lang.Exception

class UserRemoteDataSource(val apiService: ApiService) {

//    suspend fun register(user:User):User{
//       return StatusApi.retrofitService.register(user)
//    }
    suspend fun register(user:User):Resource<User>{
         var result = Resource<User>(Status.LOADING, null)
        try {
            var response = apiService.register(user)
            if (response.isSuccessful){
                //TODO
                result.data = response.body() as User
                result.status = Status.SUCCESS

            }else
                return Resource(Status.ERROR, null, response.message())
        }
        catch (ex: Exception){
            return Resource(Status.ERROR, null, ex.message)
        }
    return result
    }


    suspend fun getUser(id:String):User{
        return apiService.getUser(id)
    }

    suspend fun getUserList():List<User>{
        return apiService.getUserList()
    }


}