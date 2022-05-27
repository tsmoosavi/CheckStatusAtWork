package com.example.checkstatusatwork.model

data class Resource<T>(var status: Status, var data: T?, var massage:String? = null)

enum class Status{
    LOADING,
    SUCCESS,
    ERROR
}