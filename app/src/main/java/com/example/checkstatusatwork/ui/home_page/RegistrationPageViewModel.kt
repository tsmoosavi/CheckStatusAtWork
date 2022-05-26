package com.example.checkstatusatwork.ui.home_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.model.User
import kotlinx.coroutines.launch

class RegistrationPageViewModel(val repository: UserRepository): ViewModel() {
    val user = MutableLiveData<User>()
    fun addUser(name:String, password:Int):LiveData<User>{
        viewModelScope.launch {
            user.value =  repository.addUser(User(name = name,password = password))
        }
        return user
    }
}