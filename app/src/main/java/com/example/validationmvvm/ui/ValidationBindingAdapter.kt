package com.example.validationmvvm.ui

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.example.validationmvvm.utils.ValidateEditText
import com.example.validationmvvm.utils.ValidatorException

@BindingAdapter(value = ["validateFirstName", "validateStatusAttrChanged"], requireAll = false)
fun validateFirstName(
    editText: ValidateEditText,
    firstName: String?,
    attrChange: InverseBindingListener?) {
    editText.doValidation(firstName, attrChange, 1000) {
        RegisterValidator.validateFirstName(it)
    }
}

@BindingAdapter(value = ["validateLastName", "validateStatusAttrChanged"], requireAll = false)
fun validateLastName(
    editText: ValidateEditText,
    lastName: String?,
    attrChange: InverseBindingListener?) {
    editText.doValidation(lastName, attrChange, 1000) {
        RegisterValidator.validateLastName(it)
    }
}

@BindingAdapter(value = ["validateEmail", "validateStatusAttrChanged"], requireAll = false)
fun validateEmail(
    editText: ValidateEditText,
    email: String?,
    attrChange: InverseBindingListener?
) {
    editText.doValidation(email, attrChange, 1000) {
        RegisterValidator.validateEmail(it)
    }
}

@BindingAdapter(value = ["validateMobile", "validateStatusAttrChanged"], requireAll = false)
fun validateMobile(
    editText: ValidateEditText,
    mobile: String?,
    attrChange: InverseBindingListener?) {
    editText.doValidation(mobile, attrChange, 1000) {
        RegisterValidator.validateMobileNo(it)
    }
}


@InverseBindingAdapter(attribute = "validateStatus")
fun getValidateStatus(view: ValidateEditText): Boolean = view.isValid ?: false

@BindingAdapter("validateStatus")
fun setValidateStatus(view: ValidateEditText, value: Boolean) {}


private fun <T> ValidateEditText.doValidation(
    value: T?,
    attrChange: InverseBindingListener?,
    delay: Long,
    validation: (T) -> Boolean?
) {
    // set a result to invalid when an input is changing
    isValid = false
    attrChange?.onChange()

    value?.let {
        validateHandler?.apply {
            removeCallbacksAndMessages(null)
        }?.postDelayed({
            try {
                validation(it)?.let { result -> // throw ValidatorException if result is invalid
                    isValid = result
                }
            } catch (ve: ValidatorException) {
                error = ve.error.getAlertMessage(context)
                isValid = false
            } finally {
                attrChange?.onChange()
            }
        }, delay)
    }
}