package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class InternalServerException
constructor(
    private val statusCode: Int,
    headers: ListMultimap<String, String>,
    private val error: SamError,
) : SamServiceException(headers, "${error}") {
    override fun statusCode(): Int = statusCode

    fun error(): SamError = error
}
