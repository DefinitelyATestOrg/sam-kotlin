package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(statusCode, headers, body, error)
