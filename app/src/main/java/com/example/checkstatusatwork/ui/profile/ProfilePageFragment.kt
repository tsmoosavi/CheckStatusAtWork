package com.example.checkstatusatwork.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.checkstatusatwork.R
import com.example.checkstatusatwork.databinding.FragmentProfilePageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfilePageFragment : Fragment() {
    lateinit var binding: FragmentProfilePageBinding
    val vm: ProfileViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile_page, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.user.observe(viewLifecycleOwner) {
            binding.user = it
            Glide.with(this)
                .load(it.avatar)
                .placeholder(R.drawable.load)
                .into(binding.imageProfile)
        }

    }
}
