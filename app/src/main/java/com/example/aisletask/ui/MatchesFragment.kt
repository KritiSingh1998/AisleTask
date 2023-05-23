package com.example.aisletask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aisletask.R
import com.example.aisletask.databinding.FragmentMatchesBinding

class MatchesFragment : Fragment() {
    private lateinit var binding: FragmentMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(layoutInflater,container,false)
        setupToolbar()
        return binding.root
    }

    private fun setupToolbar(){
        binding.matchesToolbar.toolbarHeading.text = getString(R.string.matches)
        binding.matchesToolbar.toolbarSubheading.visibility = View.GONE
    }
}