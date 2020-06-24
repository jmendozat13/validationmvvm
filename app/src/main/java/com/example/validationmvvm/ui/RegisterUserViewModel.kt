package com.example.validationmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.validationmvvm.extensions.addSources

class RegisterUserViewModel : ViewModel() {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var mobile = MutableLiveData<String>()

    var isValidFirstName = MutableLiveData<Boolean>()
    var isValidLastName= MutableLiveData<Boolean>()
    var isValidEmail = MutableLiveData<Boolean>()
    var isValidMobile = MutableLiveData<Boolean>()

    val isValidForm = MediatorLiveData<Boolean>().apply {
        addSources(Observer<Boolean> {
            value = validateForm()
        }, isValidFirstName, isValidLastName, isValidEmail, isValidMobile)
    }

    private val _alertMessage = MutableLiveData<String>()
    val alertMessage: LiveData<String>
        get() = _alertMessage


    fun acceptForm() {
        if (validateForm()) {
            _alertMessage.value = "WOW!!, this form is valid."
        }
    }

    private fun validateForm(): Boolean {
        return isValidFirstName.value ?: false
                && isValidLastName.value ?: false
                && isValidEmail.value ?: false
                && isValidMobile.value ?: false
    }
}
