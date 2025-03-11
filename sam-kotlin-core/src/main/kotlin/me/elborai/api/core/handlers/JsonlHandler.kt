@file:JvmName("JsonlHandler")

package me.elborai.api.core.handlers

import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.http.StreamResponse
import me.elborai.api.errors.SamException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

internal inline fun <reified T> jsonlHandler(jsonMapper: JsonMapper): Handler<StreamResponse<T>> =
    streamHandler { lines ->
        for (line in lines) {
            val value =
                try {
                    jsonMapper.readValue(line, jacksonTypeRef<T>())
                } catch (e: Exception) {
                    throw SamException("Error reading response", e)
                }
            yield(value)
        }
    }
