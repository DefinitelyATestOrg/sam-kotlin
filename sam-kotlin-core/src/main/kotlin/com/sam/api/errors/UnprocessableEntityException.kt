package com.sam.api.errors

import com.sam.api.core.http.Headers

class UnprocessableEntityException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(422, headers, body, error)
