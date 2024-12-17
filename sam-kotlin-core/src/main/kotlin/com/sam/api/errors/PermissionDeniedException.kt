package com.sam.api.errors

import com.sam.api.core.http.Headers

class PermissionDeniedException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(403, headers, body, error)
