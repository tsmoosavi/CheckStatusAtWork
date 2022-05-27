package com.example.checkstatusatwork.ui.register_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
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
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_registrationPageFragment_to_loginFragment)
        }
        binding.register.setOnClickListener {
            vModel.addUser(binding.name.text.toString(),binding.password.text.toString(),binding.avatarUrl.text.toString(),binding.status.text.toString()).observe(viewLifecycleOwner){
//                Toast.makeText(context, it.id, Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_registrationPageFragment_to_homeFragment2)
            }

        }

    }
}