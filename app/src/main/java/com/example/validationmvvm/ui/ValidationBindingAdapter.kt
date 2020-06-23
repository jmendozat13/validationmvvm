package com.example.validationmvvm.ui

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.example.validationmvvm.extensions.isValidEmail

@BindingAdapter(value = ["validateFirstName", "validateStatusAttrChanged"], requireAll = false)
fun validateFirstName(editText: EditText, firstName: String?, attrChange: InverseBindingListener?) {
    if(firstName.isNullOrEmpty()) {
        editText.error = "FirstName is required"
    }else {
        editText.error = null
    }
    attrChange?.onChange()
}

@BindingAdapter(value = ["validateLastName", "validateStatusAttrChanged"], requireAll = false)
fun validateLastName(editText: EditText, lastName: String?, attrChange: InverseBindingListener?) {
    if(lastName.isNullOrEmpty()) {
        editText.error = "LastName is required"
    }else {
        editText.error = null
    }
    attrChange?.onChange()
}

@BindingAdapter(value = ["validateEmail", "validateStatusAttrChanged"], requireAll = false)
fun validateEmail(editText: EditText, email: String?, attrChange: InverseBindingListener?) {
    when {
        email.isNullOrEmpty() -> {
            editText.error = "Email is required."
        }
        !email.isValidEmail() -> {
            editText.error = "Email is invalid."
        }
        else -> {
            editText.error = null
        }
    }
    attrChange?.onChange()
}

@BindingAdapter(value = ["validateMobile", "validateStatusAttrChanged"], requireAll = false)
fun validateMobile(editText: EditText, mobile: String?, attrChange: InverseBindingListener?) {
    if(mobile.isNullOrEmpty()) {
        editText.error = "Mobile number is required"
    }else {
        editText.error = null
    }
    attrChange?.onChange()
}


@InverseBindingAdapter(attribute = "validateStatus")
fun getValidateStatus(view: EditText): Boolean = view.error?.isEmpty() ?: true

@BindingAdapter("validateStatus")
fun setValidateStatus(view: EditText, value: Boolean) {}