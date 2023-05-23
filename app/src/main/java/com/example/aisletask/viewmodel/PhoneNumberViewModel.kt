package com.example.aisletask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisletask.model.PhoneNumber
import com.example.aisletask.model.PhoneNumberVerificationResponse
import com.example.aisletask.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PhoneNumberViewModel @Inject constructor(private val myRepository: MyRepository) :
    ViewModel() {
    private var _response: MutableLiveData<PhoneNumberVerificationResponse> = MutableLiveData()
    var response: LiveData<PhoneNumberVerificationResponse> = _response
    fun verifyPhoneNumber(number: PhoneNumber) {
        viewModelScope.launch {
            _response.value = myRepository.verifyPhoneNumber(number)
        }
    }
}