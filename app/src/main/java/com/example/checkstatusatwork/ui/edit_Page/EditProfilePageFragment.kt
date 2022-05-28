package com.example.checkstatusatwork.ui.edit_Page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.checkstatusatwork.R
import com.example.checkstatusatwork.databinding.FragmentEditProfilePageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class EditProfilePageFragment : Fragment() {
     lateinit var binding: FragmentEditProfilePageBinding
     val vm: EditProfileViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_profile_page,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.user = vm.user
        binding.editBtn.setOnClickListener {
            vm.updateUser(binding.editName.text.toString(),binding.editAvatarUrl.text.toString())
            Toast.makeText(context, "user edited", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editProfilePageFragment_to_homeFragment2)
        }

    }
}