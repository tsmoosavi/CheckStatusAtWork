package com.example.checkstatusatwork.ui.home_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.checkstatusatwork.R
import com.example.checkstatusatwork.databinding.FragmentRegistrationPageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegistrationPageFragment : Fragment() {
    lateinit var binding: FragmentRegistrationPageBinding
    val vModel: RegistrationPageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_registration_page,container,false)
        return inflater.inflate(R.layout.fragment_registration_page, container, false)
    }


}