package com.example.validationmvvm.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterUserViewModel : ViewModel() {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var mobile = MutableLiveData<String>()

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    fun acceptForm() {
        if (validteForm()) {
            Log.v("Fragment","acceptForm")
        }
    }

    private fun validteForm(): Boolean {
        if (firstName.value.isNullOrEmpty()) {
            _errorMessage.value = "First name is required"
            return false
        }
        if (lastName.value.isNullOrEmpty()) {
            _errorMessage.value = "Last name is required"
            return false
        }
        if (email.value.isNullOrEmpty()) {
            _errorMessage.value = "Email is required"
            return false
        }
        if (mobile.value.isNullOrEmpty()) {
            _errorMessage.value = "Mobile is required"
            return false
        }
        return true
    }
}