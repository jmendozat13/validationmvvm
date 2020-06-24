package com.example.validationmvvm

import com.example.validationmvvm.ui.RegisterValidator
import com.example.validationmvvm.ui.ValidateRegisterError
import com.example.validationmvvm.utils.ValidatorException
import org.junit.Assert.*

import org.junit.Test

class RegisterValidatorTest {

    @Test
    fun `validate Email with Invalid Email expect Failure`() {
        val email = "aaa@aaa"
        var exception: ValidatorException? = null
        try {
            RegisterValidator.validateEmail(email)
        } catch (ve: ValidatorException) {
            exception = ve
        }
        assertNotNull(exception)
        assertEquals(ValidateRegisterError.INVALID_EMAIL, exception?.error)
    }

    @Test
    fun `validate Email with Valid Email expect Successful`() {
        val email = "aaa@aaa.com"
        var exception: ValidatorException? = null
        var result: Boolean? = null
        try {
            result = RegisterValidator.validateEmail(email)
        } catch (ve: ValidatorException) {
            exception = ve
        }

        assertNull(exception)
        assertNotNull(result)
        assertTrue(result!!)
    }

}