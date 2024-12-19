package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class BadRequestException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(400, headers, body, error)
