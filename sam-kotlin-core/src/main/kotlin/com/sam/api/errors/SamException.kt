package com.sam.api.errors

open class SamException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
