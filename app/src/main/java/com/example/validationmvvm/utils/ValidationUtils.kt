package com.example.validationmvvm.utils

object ValidationUtils {
    fun isValidEmail(email: String?): Boolean {
        email?.let {
            return it.matches(("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").toRegex())
        }
        return false
    }
}