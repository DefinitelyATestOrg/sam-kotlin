package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class NotFoundException(
    headers: ListMultimap<String, String>,
    body: String,
    error: SamError,
) : SamServiceException(404, headers, body, error)
