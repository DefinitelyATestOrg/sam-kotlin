package com.sam.api.errors

import com.sam.api.core.http.Headers

abstract class SamServiceException(
    private val statusCode: Int,
    private val headers: Headers,
    private val body: String,
    private val error: SamError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null
) : SamException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): SamError = error
}
