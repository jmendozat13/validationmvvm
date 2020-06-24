package com.example.validationmvvm.utils

import android.content.Context

interface Error {
    val code: Int
    val messageRes: Int?
    val defaultMessage: String

    fun getAlertMessage(context: Context?): String {
        this.messageRes?.let {
            return context?.getString(it) ?: this.defaultMessage
        } ?: return this.defaultMessage
    }
}