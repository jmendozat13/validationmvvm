package com.example.validationmvvm.utils

object ValidationUtils {

    fun isValidEmail(email: String?): Boolean {
        email?.let {
            return it.matches(("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").toRegex())
        }
        return false
    }

    fun isValidMobile(mobile: String?): Boolean {
        mobile?.let {
            val patterns =
                ("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                        + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                        + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$")
            return it.matches(patterns.toRegex())
        }
        return false
    }
}