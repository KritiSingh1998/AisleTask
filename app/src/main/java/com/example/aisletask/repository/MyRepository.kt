package com.example.aisletask.repository

import com.example.aisletask.model.NotesDetails
import com.example.aisletask.model.OptVerificationResponse
import com.example.aisletask.model.PhoneNumber
import com.example.aisletask.model.PhoneNumberVerificationResponse
import com.example.aisletask.model.VerifyOtp
import com.example.aisletask.network.ApiClient
import retrofit2.Response

class MyRepository constructor(private val apiClient: ApiClient) {
    suspend fun verifyPhoneNumber(number: PhoneNumber): PhoneNumberVerificationResponse {
        return apiClient.verifyPhoneNumber(number)
    }

    suspend fun verifyLoginDetails(loginDetails: VerifyOtp): OptVerificationResponse {
        return apiClient.verifyOtp(loginDetails)
    }

    suspend fun getNotesDetails(token :String) : NotesDetails {
        return apiClient.getNotesDetails(token)
    }
}