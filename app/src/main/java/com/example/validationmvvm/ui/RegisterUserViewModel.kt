package com.example.validationmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterUserViewModel : ViewModel() {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var mobile = MutableLiveData<String>()

    var isValidFirstName = MutableLiveData<Boolean>()
    var isValidLastName= MutableLiveData<Boolean>()
    var isValidEmail = MutableLiveData<Boolean>()
    var isValidMobile = MutableLiveData<Boolean>()


    private val _alertMessage = MutableLiveData<String>()
    val alertMessage: LiveData<String>
        get() = _alertMessage


    fun acceptForm() {
        if (validteForm()) {
            _alertMessage.value = "WOW!!, this form is valid."
        }
    }

    private fun validteForm() = isValidFirstName.value ?: false
            && isValidLastName.value ?: false
            && isValidEmail.value?: false
            && isValidMobile.value?: false
}
