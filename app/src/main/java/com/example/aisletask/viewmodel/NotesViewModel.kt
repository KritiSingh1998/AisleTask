package com.example.aisletask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisletask.model.NotesDetails
import com.example.aisletask.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val myRepository: MyRepository) :
    ViewModel() {
    private var _response: MutableLiveData<NotesDetails> = MutableLiveData()
    var response: LiveData<NotesDetails> = _response

    private var _progress: MutableLiveData<Boolean> = MutableLiveData(false)
    var progress: LiveData<Boolean> = _progress

    fun getNotesDetails(token: String) {
        viewModelScope.launch {
            _progress.value = true
            _response.value = myRepository.getNotesDetails(token)
            _progress.value = false
        }
    }
}