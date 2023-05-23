package com.example.aisletask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisletask.model.OptVerificationResponse
import com.example.aisletask.model.VerifyOtp
import com.example.aisletask.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class OTPViewModel @Inject constructor(private val myRepository: MyRepository) :
    ViewModel() {
    private var _response: MutableLiveData<OptVerificationResponse> = MutableLiveData()
    var response: LiveData<OptVerificationResponse> = _response

    fun verifyOtp(loginDetails: VerifyOtp) {
        viewModelScope.launch {
            _response.value = myRepository.verifyLoginDetails(loginDetails)
        }
    }
}