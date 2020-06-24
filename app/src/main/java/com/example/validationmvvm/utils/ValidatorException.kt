package com.example.validationmvvm.utils

import java.lang.Exception
class ValidatorException constructor(
    val error: Error
): Exception()