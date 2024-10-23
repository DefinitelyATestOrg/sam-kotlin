package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class RateLimitException(
    headers: ListMultimap<String, String>,
    body: String,
    error: SamError,
) : SamServiceException(429, headers, body, error)
