package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class UnprocessableEntityException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(422, headers, body, error)
