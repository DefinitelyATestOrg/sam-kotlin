package software.elborai.api.errors

import com.google.common.collect.ListMultimap

abstract class SamServiceException(
    private val statusCode: Int,
    private val headers: ListMultimap<String, String>,
    private val body: String,
    private val error: SamError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null
) : SamException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): ListMultimap<String, String> = headers

    fun body(): String = body

    fun error(): SamError = error
}
