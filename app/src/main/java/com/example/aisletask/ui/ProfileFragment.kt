package com.example.aisletask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aisletask.R
import com.example.aisletask.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        setupToolbar()
        return binding.root
    }

    private fun setupToolbar() {
        binding.profileToolbar.toolbarHeading.text = getString(R.string.profile)
        binding.profileToolbar.toolbarSubheading.visibility = View.GONE
    }
}