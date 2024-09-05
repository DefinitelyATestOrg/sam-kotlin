package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class RateLimitException
constructor(
        headers: ListMultimap<String, String>,
        private val error: SamError,
) : SamServiceException(headers, "${error}") {
    override fun statusCode(): Int = 429
    fun error(): SamError = error
}
