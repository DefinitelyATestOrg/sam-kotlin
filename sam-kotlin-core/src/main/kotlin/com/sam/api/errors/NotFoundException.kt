package com.sam.api.errors

import com.sam.api.core.http.Headers

class NotFoundException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(404, headers, body, error)
