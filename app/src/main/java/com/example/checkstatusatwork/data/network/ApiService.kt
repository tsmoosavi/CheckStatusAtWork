package com.example.checkstatusatwork.data.network

import com.example.checkstatusatwork.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
    suspend fun register(@Body user: User):User

//    @GET("movie/popular")
//    suspend fun getMovies(
////        @Query("page")page :Int = 1,
//        @Query("api_key") apiKey :String = api_key
//    ): MovieListApiResult
//
//    @GET("search/movie")
//    suspend fun searchMovie(
////        @Query("page")page :Int,
//        @Query("api_key") apiKey :String = api_key,
//        @Query("query") query: String
//    ):SearchMovie
//
//    @GET("movie/{movie_id}")
//    suspend fun MovieDetail(
//        @Path(value = "movie_id") movieId: Int,
//        @Query("api_key") apiKey :String = api_key
//    ): MovieDetail
//
//    @GET("movie/upcoming")
//    suspend fun upComingMovies(
//        @Query("page")page :Int = 1,
//        @Query("api_key") apiKey :String = api_key
//    ): UpComingMovieList
//
//    @GET("movie/{movie_id}/videos")
//    suspend fun  videoOfMovie(
//        @Path(value = "movie_id") movieId: Int,
//        @Query("api_key") apiKey :String = api_key
//    ): VideoOfMovie


}

object StatusApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
