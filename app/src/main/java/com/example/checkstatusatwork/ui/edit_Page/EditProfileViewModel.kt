package com.example.checkstatusatwork.ui.edit_Page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkstatusatwork.data.User.UserRepository
import com.example.checkstatusatwork.model.User
import kotlinx.coroutines.launch

class EditProfileViewModel(val repository: UserRepository): ViewModel()  {
    var user = repository.userInfo

    fun updateUser(name:String,avatar: String){
        viewModelScope.launch {
            repository.updateUser(User(name = name,avatar = avatar,password = user.password,status = user.status),user.id)
        }
    }
}