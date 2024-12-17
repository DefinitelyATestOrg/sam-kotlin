package com.sam.api.errors

import com.sam.api.core.http.Headers

class InternalServerException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(statusCode, headers, body, error)
