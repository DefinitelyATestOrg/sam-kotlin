package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class UnauthorizedException(
    headers: ListMultimap<String, String>,
    body: String,
    error: SamError,
) : SamServiceException(401, headers, body, error)
