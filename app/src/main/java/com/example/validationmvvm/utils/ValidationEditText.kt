package com.example.validationmvvm.utils

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class ValidateEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatEditText(context, attrs) {
    val validateHandler: Handler? = Handler()
    var isValid: Boolean? = null
}