@file:JvmName("ErrorHandler")

package software.elborai.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.google.common.collect.ListMultimap
import java.io.ByteArrayInputStream
import java.io.InputStream
import software.elborai.api.core.http.HttpResponse
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.BadRequestException
import software.elborai.api.errors.InternalServerException
import software.elborai.api.errors.NotFoundException
import software.elborai.api.errors.PermissionDeniedException
import software.elborai.api.errors.RateLimitException
import software.elborai.api.errors.SamError
import software.elborai.api.errors.UnauthorizedException
import software.elborai.api.errors.UnexpectedStatusCodeException
import software.elborai.api.errors.UnprocessableEntityException

internal fun errorHandler(jsonMapper: JsonMapper): Handler<SamError> {
    val handler = jsonHandler<SamError>(jsonMapper)

    return object : Handler<SamError> {
        override fun handle(response: HttpResponse): SamError =
            try {
                handler.handle(response)
            } catch (e: Exception) {
                SamError.builder().build()
            }
    }
}

internal fun <T> Handler<T>.withErrorHandler(errorHandler: Handler<SamError>): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            when (val statusCode = response.statusCode()) {
                in 200..299 -> {
                    return this@withErrorHandler.handle(response)
                }
                400 -> {
                    val buffered = response.buffered()
                    throw BadRequestException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                401 -> {
                    val buffered = response.buffered()
                    throw UnauthorizedException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                403 -> {
                    val buffered = response.buffered()
                    throw PermissionDeniedException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                404 -> {
                    val buffered = response.buffered()
                    throw NotFoundException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                422 -> {
                    val buffered = response.buffered()
                    throw UnprocessableEntityException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                429 -> {
                    val buffered = response.buffered()
                    throw RateLimitException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                in 500..599 -> {
                    val buffered = response.buffered()
                    throw InternalServerException(
                        statusCode,
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                else -> {
                    val buffered = response.buffered()
                    throw UnexpectedStatusCodeException(
                        statusCode,
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
            }
        }
    }

private fun HttpResponse.buffered(): HttpResponse {
    val body = body().readBytes()

    return object : HttpResponse {
        override fun statusCode(): Int = this@buffered.statusCode()

        override fun headers(): ListMultimap<String, String> = this@buffered.headers()

        override fun body(): InputStream = ByteArrayInputStream(body)

        override fun close() = this@buffered.close()
    }
}
