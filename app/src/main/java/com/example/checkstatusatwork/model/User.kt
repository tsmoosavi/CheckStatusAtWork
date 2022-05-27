package com.example.checkstatusatwork.model

data class User(
    val avatar: String,
    val id: String = "0",
    val name: String,
    val password: String,
    val status: String,
    //val updatedAt: String,
//    val userName: String
)