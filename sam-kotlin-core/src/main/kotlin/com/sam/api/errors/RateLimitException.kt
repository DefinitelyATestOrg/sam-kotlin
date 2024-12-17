package com.sam.api.errors

import com.sam.api.core.http.Headers

class RateLimitException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(429, headers, body, error)
