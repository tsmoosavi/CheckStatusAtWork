package com.example.checkstatusatwork.ui.home_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.model.User
import kotlinx.coroutines.launch

class HomeViewModel (val repository: UserRepository): ViewModel(){

    var userList = MutableLiveData<List<User>>()

    init {
        getListOfUsers()
    }

    fun getListOfUsers():LiveData<List<User>>{
        viewModelScope.launch {
            userList.value = repository.getUserList()
        }
        return userList
    }
}