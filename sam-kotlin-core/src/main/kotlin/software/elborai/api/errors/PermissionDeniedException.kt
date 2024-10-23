package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class PermissionDeniedException(
    headers: ListMultimap<String, String>,
    body: String,
    error: SamError,
) : SamServiceException(403, headers, body, error)
