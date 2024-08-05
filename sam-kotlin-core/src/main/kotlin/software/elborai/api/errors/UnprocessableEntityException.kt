package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class UnprocessableEntityException
constructor(
        headers: ListMultimap<String, String>,
        private val error: SamError,
) : SamServiceException(headers, "${error}") {
    override fun statusCode(): Int = 422
    fun error(): SamError = error
}
