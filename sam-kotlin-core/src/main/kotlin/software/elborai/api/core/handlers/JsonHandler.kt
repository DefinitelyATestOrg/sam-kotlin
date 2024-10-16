@file:JvmName("JsonHandler")

package software.elborai.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import software.elborai.api.core.http.HttpResponse
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamException

internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw SamException("Error reading response", e)
            }
        }
    }
