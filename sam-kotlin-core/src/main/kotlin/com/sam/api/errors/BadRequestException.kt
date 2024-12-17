package com.sam.api.errors

import com.sam.api.core.http.Headers

class BadRequestException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(400, headers, body, error)
