package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class RateLimitException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(429, headers, body, error)
