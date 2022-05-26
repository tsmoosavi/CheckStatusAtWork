package com.example.checkstatusatwork.ui.login_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.checkstatusatwork.R
import com.example.checkstatusatwork.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
  lateinit var binding: FragmentLoginBinding
  val vm:LoginViewModel by  viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            vm.login(binding.id.text.toString(),binding.password.text.toString().toInt())
        }

        vm.loginSuccess.observe(viewLifecycleOwner){
            if (it)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
            else
                Toast.makeText(context, "not valid", Toast.LENGTH_SHORT).show()
        }
    }
}