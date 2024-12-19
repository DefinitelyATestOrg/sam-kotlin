package me.elborai.api.errors

import me.elborai.api.core.http.Headers

class PermissionDeniedException(
    headers: Headers,
    body: String,
    error: SamError,
) : SamServiceException(403, headers, body, error)
