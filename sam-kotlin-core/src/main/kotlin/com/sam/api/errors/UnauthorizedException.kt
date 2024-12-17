package com.sam.api.errors

import com.sam.api.core.http.Headers

class UnauthorizedException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(401, headers, body, error)
