package com.example.validationmvvm.ui

import androidx.annotation.StringRes
import com.example.validationmvvm.R
import com.example.validationmvvm.utils.Error

enum class ValidateRegisterError(
    override val code: Int,
    @StringRes override val messageRes: Int?,
    override val defaultMessage: String
) : Error {
    INVALID_EMAIL(5000, R.string.error_email_invalid, "Email is invalid."),
    INVALID_MOBILE_NO(5000, R.string.error_mobile_no_invalid, "Mobile is invalid."),

    EMPTY_FIRST_NAME(5100, R.string.error_first_name_empty, "First name is required."),
    EMPTY_LAST_NAME(5100, R.string.error_last_name_empty, "Last name is required."),
    EMPTY_EMAIL(5100, R.string.error_email_empty, "Email is required."),
    EMPTY_MOBILE_NO(5100, R.string.error_mobile_no_empty, "Mobile is required.")
}
