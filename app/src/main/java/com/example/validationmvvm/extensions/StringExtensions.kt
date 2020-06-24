package com.example.validationmvvm.extensions

import com.example.validationmvvm.utils.ValidationUtils

fun String.isValidEmail(): Boolean = ValidationUtils.isValidEmail(this)
fun String.isValidMobileNumber(): Boolean = ValidationUtils.isValidMobile(this)