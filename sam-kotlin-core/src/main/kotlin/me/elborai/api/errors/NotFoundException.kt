package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class NotFoundException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(404, headers, body, error)
