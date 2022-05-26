package com.example.checkstatusatwork.model

data class Resource<T>(val status: Status , val data: T?, val massage:String?)

enum class Status{
    LOADING,
    SUCCESS,
    ERROR
}