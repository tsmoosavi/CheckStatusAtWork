package com.example.checkstatusatwork.data.network

import com.example.checkstatusatwork.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @POST("users")
    suspend fun register(@Body user: User):Response<User>

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: String
    ):User

    @GET("users")
    suspend fun getUserList():List<User>

    @PUT("users/{id}")
    suspend fun updateUser (@Body user: User, @Path("id") id : String) //:Unit


}

object StatusApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
