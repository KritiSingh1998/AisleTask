package com.example.aisletask.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aisletask.R
import com.example.aisletask.databinding.FragmentNotesBinding
import com.example.aisletask.model.Profiles
import com.example.aisletask.ui.adapter.LikesCardAdapter
import com.example.aisletask.util.GridItemDecorator
import com.example.aisletask.util.loadImage
import com.example.aisletask.viewmodel.NotesViewModel
import com.example.aisletask.viewmodel.OTPViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private val viewModel: NotesViewModel by viewModels()
    private lateinit var likesCardAdapter: LikesCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        setupToolbar()
        viewModel.getNotesDetails("32c7794d2e6a1f7316ef35aa1eb34541")
        setAdapter()
        subscribeObserver()
        return binding.root
    }

    private fun setupToolbar() {
        binding.notesToolbar.toolbarHeading.text = getString(R.string.notes)
        binding.notesToolbar.toolbarSubheading.text = getString(R.string.notes_subheading)
    }

    private fun subscribeObserver() {
        viewModel.progress.observe(viewLifecycleOwner, Observer {
            if (it)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE
        })
        viewModel.response.observe(viewLifecycleOwner, Observer {
            setupInviteProfileCard(it.invites.profiles[0])
            likesCardAdapter.updateList(it.likes.profiles)
            Log.e("Details", it.toString())
        })
    }

    private fun setupInviteProfileCard(profile: Profiles) {
        binding.cardInvites.nameAge.text =
            "${profile.general_information.first_name}, ${profile.general_information.age}"
        binding.cardInvites.reviewText.text = getString(R.string.tap_to_review_50_notes)
        binding.cardInvites.image.loadImage(profile.photos[0].photo)
    }

    private fun setAdapter() {
        val recyclerView = binding.recyclerView
        likesCardAdapter =
            LikesCardAdapter(listOf())
        recyclerView.adapter = likesCardAdapter
        recyclerView.layoutManager =
            GridLayoutManager(activity, 2)
        recyclerView.addItemDecoration(GridItemDecorator(32, 2))
        recyclerView.itemAnimator = null
        subscribeObserver()
    }
}