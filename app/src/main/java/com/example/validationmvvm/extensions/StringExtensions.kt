package com.example.validationmvvm.extensions

import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope

import com.example.validationmvvm.utils.ValidationUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun String.isValidEmail(): Boolean = ValidationUtils.isValidEmail(this)
fun String.isValidMobileNumber(): Boolean = ValidationUtils.isValidMobile(this)

fun View.setOnClickDelay(lifecycleOwner: LifecycleOwner, onClick: () -> Unit) =
    this.setOnClickListener {
        lifecycleOwner.lifecycleScope.launch {
            Log.d("RegisterUserFragment", "START")
            it.isEnabled = false
            delay(4000)
            it.isEnabled = true
            onClick()
        }
    }
