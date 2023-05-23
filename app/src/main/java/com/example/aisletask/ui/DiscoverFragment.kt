package com.example.aisletask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aisletask.R
import com.example.aisletask.databinding.FragmentDiscoverBinding

class DiscoverFragment : Fragment() {
    private lateinit var binding: FragmentDiscoverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoverBinding.inflate(layoutInflater,container,false)
        setupToolbar()
        return binding.root
    }

    private fun setupToolbar(){
        binding.discoverToolbar.toolbarHeading.text = getString(R.string.discover)
        binding.discoverToolbar.toolbarSubheading.visibility = View.GONE
    }
}