package com.sam.api.errors

class SamIoException(message: String? = null, cause: Throwable? = null) :
    SamException(message, cause)
