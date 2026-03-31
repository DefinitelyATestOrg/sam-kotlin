// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.errors

import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers

abstract class SamServiceException
protected constructor(message: String, cause: Throwable? = null) : SamException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
