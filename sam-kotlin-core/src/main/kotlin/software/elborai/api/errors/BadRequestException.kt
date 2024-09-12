package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class BadRequestException(
    headers: ListMultimap<String, String>,
    body: String,
    error: SamError,
) : SamServiceException(400, headers, body, error)
