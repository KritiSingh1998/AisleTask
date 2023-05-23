package com.example.aisletask.network

import com.example.aisletask.model.NotesDetails
import com.example.aisletask.model.OptVerificationResponse
import com.example.aisletask.model.PhoneNumber
import com.example.aisletask.model.PhoneNumberVerificationResponse
import com.example.aisletask.model.VerifyOtp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiClient {

    @POST("users/phone_number_login")
    suspend fun verifyPhoneNumber(@Body number: PhoneNumber): PhoneNumberVerificationResponse

    @POST("users/verify_otp")
    suspend fun verifyOtp(@Body loginDetails: VerifyOtp): OptVerificationResponse

    @GET("users/test_profile_list")
    suspend fun getNotesDetails(@Header("Authorization") token : String) : NotesDetails
}