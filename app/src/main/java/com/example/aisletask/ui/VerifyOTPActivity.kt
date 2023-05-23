package com.example.aisletask.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.aisletask.databinding.ActivityVerifyOtpBinding
import com.example.aisletask.model.VerifyOtp
import com.example.aisletask.util.AppConstant
import com.example.aisletask.viewmodel.OTPViewModel
import com.example.aisletask.viewmodel.PhoneNumberViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyOTPActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerifyOtpBinding
    private val viewModel: OTPViewModel by viewModels()
    private var phoneNumber = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerifyOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        phoneNumber = intent.getStringExtra(AppConstant.PHONE_NUMBER).toString()
        binding.phoneNumberText.text = "+91 $phoneNumber"
        setCountDownTimer()
        setContinueButtonClick()
    }

    private fun setCountDownTimer() {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minute = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                binding.timer.text = "$minute:$seconds"
            }

            override fun onFinish() {
            }

        }.start()
    }

    private fun setContinueButtonClick() {
        binding.continueButton.setOnClickListener {
            verifyOtp()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun verifyOtp() {
        val otp = binding.otp.text.toString()
        val loginDetails = VerifyOtp("+91$phoneNumber", otp)
        viewModel.verifyOtp(loginDetails)
        viewModel.response.observe(this, Observer {
            if (!it.token.isNullOrEmpty()) {
                navigateToMainActivity()
            }
        })
    }
}