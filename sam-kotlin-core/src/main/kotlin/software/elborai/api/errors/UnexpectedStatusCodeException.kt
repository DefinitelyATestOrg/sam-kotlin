package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: ListMultimap<String, String>,
    body: String,
    error: SamError,
) : SamServiceException(statusCode, headers, body, error)
