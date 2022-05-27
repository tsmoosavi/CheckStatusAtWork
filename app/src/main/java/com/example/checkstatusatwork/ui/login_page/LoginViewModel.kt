package com.example.checkstatusatwork.ui.login_page

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkstatusatwork.data.User.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(val repository: UserRepository): ViewModel() {
     var loginSuccess = MutableLiveData<Boolean>()

    fun login(id:String, password: String){
        viewModelScope.launch {
            var user = repository.getUser(id)
            loginSuccess.value = user.password == password
        }
    }
}