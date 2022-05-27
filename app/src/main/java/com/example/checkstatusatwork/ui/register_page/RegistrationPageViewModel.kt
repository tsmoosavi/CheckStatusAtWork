package com.example.checkstatusatwork.ui.register_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.model.Status
import com.example.checkstatusatwork.model.User
import kotlinx.coroutines.launch

class RegistrationPageViewModel(val repository: UserRepository): ViewModel() {
    val user = MutableLiveData<User>()
    fun addUser(name:String, password:String,status:String,avatar: String):LiveData<User>{
        viewModelScope.launch {
            user.value =  repository.addUser(User(name = name,password = password,avatar = avatar,status = status))
        }
        return user
    }
}