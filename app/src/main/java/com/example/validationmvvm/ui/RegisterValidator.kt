package com.example.validationmvvm.ui

import com.example.validationmvvm.extensions.isValidEmail
import com.example.validationmvvm.extensions.isValidMobileNumber
import com.example.validationmvvm.utils.Validator
import com.example.validationmvvm.utils.ValidatorException

object RegisterValidator : Validator {
    fun validateFirstName(firstName: String?): Boolean? {
        val fname = firstName?.trim()?:""
        if (fname.isNullOrEmpty()) throw ValidatorException(ValidateRegisterError.EMPTY_FIRST_NAME)

        return true
    }

    fun validateLastName(lastName: String?): Boolean? {
        val lname = lastName?.trim()?:""
        if (lname.isNullOrEmpty()) throw ValidatorException(ValidateRegisterError.EMPTY_LAST_NAME)
        return true
    }

    fun validateEmail(email: String?): Boolean? {
        when {
            email.isNullOrEmpty() -> {
                throw ValidatorException(ValidateRegisterError.EMPTY_EMAIL)
            }
            !email.isValidEmail() -> {
                throw ValidatorException(ValidateRegisterError.INVALID_EMAIL)
            }
        }
        return true
    }

    fun validateMobileNo(mobileNo: String?): Boolean? {
        when {
            mobileNo.isNullOrEmpty() -> {
                throw ValidatorException(ValidateRegisterError.EMPTY_MOBILE_NO)
            }
            !mobileNo.isValidMobileNumber() -> {
                throw ValidatorException(ValidateRegisterError.INVALID_MOBILE_NO)
            }
        }
        return true
    }
}