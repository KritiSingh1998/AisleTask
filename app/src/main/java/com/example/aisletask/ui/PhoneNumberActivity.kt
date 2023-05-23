package com.example.aisletask.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.aisletask.databinding.ActivityPhoneNumberBinding
import com.example.aisletask.model.PhoneNumber
import com.example.aisletask.util.AppConstant
import com.example.aisletask.viewmodel.PhoneNumberViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhoneNumberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneNumberBinding
    private val viewModel: PhoneNumberViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContinueButtonClick()
    }

    private fun setContinueButtonClick() {
        binding.continueButton.setOnClickListener {
            verifyPhoneNumber()
        }
    }

    private fun navigateToOtpVerificationActivity() {
        val phoneNumber = binding.phoneNumber.text.toString()
        val intent = Intent(this, VerifyOTPActivity::class.java)
        intent.putExtra(AppConstant.PHONE_NUMBER, phoneNumber)
        startActivity(intent)
    }

    private fun verifyPhoneNumber() {
        val phoneNumber = PhoneNumber("+91${binding.phoneNumber.text.toString()}")
        viewModel.verifyPhoneNumber(phoneNumber)
        viewModel.response.observe(this, Observer {
            if (it.status) {
                navigateToOtpVerificationActivity()
            }
        })
    }
}


