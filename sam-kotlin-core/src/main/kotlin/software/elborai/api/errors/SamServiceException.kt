package software.elborai.api.errors

import com.google.common.collect.ListMultimap

abstract class SamServiceException
constructor(
        private val headers: ListMultimap<String, String>,
        message: String? = null,
        cause: Throwable? = null
) : SamException(message, cause) {
    abstract fun statusCode(): Int
    fun headers(): ListMultimap<String, String> = headers
}
