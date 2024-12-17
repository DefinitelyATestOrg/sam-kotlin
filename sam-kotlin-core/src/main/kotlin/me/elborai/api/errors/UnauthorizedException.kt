package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class UnauthorizedException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(401, headers, body, error)
