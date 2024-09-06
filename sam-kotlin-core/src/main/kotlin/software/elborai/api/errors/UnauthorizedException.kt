package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class UnauthorizedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: SamError,
) : SamServiceException(headers, "${error}") {
    override fun statusCode(): Int = 401

    fun error(): SamError = error
}
