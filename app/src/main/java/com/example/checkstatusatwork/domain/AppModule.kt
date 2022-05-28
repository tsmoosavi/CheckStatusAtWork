package com.example.checkstatusatwork.domain

import com.example.checkstatusatwork.data.User.UserLocalDataSource
import com.example.checkstatusatwork.data.User.UserRemoteDataSource
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.data.network.ApiService
import com.example.checkstatusatwork.ui.home_page.HomeViewModel
import com.example.checkstatusatwork.ui.register_page.RegistrationPageViewModel
import com.example.checkstatusatwork.ui.login_page.LoginViewModel
import com.example.checkstatusatwork.ui.profile.ProfileViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single { UserRepository(get(),get()) }
    single { UserLocalDataSource() }
    single { UserRemoteDataSource(get()) }
    single {
        val retrofit = get() as Retrofit
        val apiService = retrofit.create(ApiService::class.java)

        apiService
    }

    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
        val client = OkHttpClient.Builder().addInterceptor(logger).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
        retrofit
    }

    viewModel { RegistrationPageViewModel(get()) }
    viewModel{ LoginViewModel(get())}
    viewModel{HomeViewModel(get())}
    viewModel { ProfileViewModel(get()) }
}