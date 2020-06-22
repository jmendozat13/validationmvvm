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

    private val _firstNameErrorMessage = MutableLiveData<String>()
    val firstNameErrorMessage: LiveData<String>
        get() = _firstNameErrorMessage

    private val _lastNameErrorMessage = MutableLiveData<String>()
    val lastNameErrorMessage: LiveData<String>
        get() = _lastNameErrorMessage

    private val _emailErrorMessage = MutableLiveData<String>()
    val emailErrorMessage: LiveData<String>
        get() = _emailErrorMessage

    private val _mobileErrorMessage = MutableLiveData<String>()
    val mobileErrorMessage: LiveData<String>
        get() = _mobileErrorMessage

    fun acceptForm() {
        if (validteForm()) {
            Log.v("Fragment", "acceptForm")
        }
    }

    private fun validteForm(): Boolean {
        if (firstName.value.isNullOrEmpty()) {
            _firstNameErrorMessage.value = "First name is required"
            return false
        }
        if (lastName.value.isNullOrEmpty()) {
            _lastNameErrorMessage.value = "Last name is required"
            return false
        }
        if (email.value.isNullOrEmpty()) {
            _emailErrorMessage.value = "Email is required"
            return false
        }
        if (mobile.value.isNullOrEmpty()) {
            _mobileErrorMessage.value = "Mobile is required"
            return false
        }
        return true
    }
}