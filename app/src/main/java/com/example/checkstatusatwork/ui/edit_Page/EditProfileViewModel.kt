package com.example.checkstatusatwork.ui.edit_Page

import androidx.lifecycle.ViewModel
import com.example.checkstatusatwork.data.User.UserRepository

class EditProfileViewModel(val repository: UserRepository): ViewModel()  {
    var user = repository.userInfo
}