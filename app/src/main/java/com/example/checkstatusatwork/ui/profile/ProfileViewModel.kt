package com.example.checkstatusatwork.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.model.User
import kotlinx.coroutines.launch

class ProfileViewModel(val repository: UserRepository): ViewModel() {

    var user = repository.userInfo
//        MutableLiveData<User> ()
//    init {
//        user.value = repository.userInfo
//    }


    fun updateUser(status: String){
        viewModelScope.launch {
            repository.updateUser(User(status = status,name = user.name,avatar = user.avatar,password = user.password),user.id)
        }
    }

}