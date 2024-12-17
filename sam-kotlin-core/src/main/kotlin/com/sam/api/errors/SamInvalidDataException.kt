package com.sam.api.errors

class SamInvalidDataException(message: String? = null, cause: Throwable? = null) :
    SamException(message, cause)
