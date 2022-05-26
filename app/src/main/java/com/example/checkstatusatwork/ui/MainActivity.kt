package com.example.checkstatusatwork.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.checkstatusatwork.R
import com.example.checkstatusatwork.ui.home_page.RegistrationPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val viewModel: RegistrationPageViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}