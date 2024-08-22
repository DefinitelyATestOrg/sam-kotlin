package software.elborai.api.errors

import com.google.common.collect.ListMultimap

class PermissionDeniedException
constructor(
    headers: ListMultimap<String, String>,
    private val error: SamError,
) : SamServiceException(headers, "${error}") {
    override fun statusCode(): Int = 403

    fun error(): SamError = error
}