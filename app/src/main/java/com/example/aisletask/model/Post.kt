package com.example.aisletask.model

data class PhoneNumber(
    val number: String
)

data class PhoneNumberVerificationResponse(val status: Boolean)

data class VerifyOtp(val number : String,val otp : String)

data class OptVerificationResponse(val token : String)