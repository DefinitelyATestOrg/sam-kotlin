// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.Lockbox
import software.elborai.api.models.LockboxCreateParams
import software.elborai.api.models.LockboxListPageAsync
import software.elborai.api.models.LockboxListParams
import software.elborai.api.models.LockboxRetrieveParams
import software.elborai.api.models.LockboxUpdateParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class LockboxServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : LockboxServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Lockbox> =
        jsonHandler<Lockbox>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a Lockbox */
    override suspend fun create(
        params: LockboxCreateParams,
        requestOptions: RequestOptions
    ): Lockbox {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("lockboxes")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<Lockbox> =
        jsonHandler<Lockbox>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Lockbox */
    override suspend fun retrieve(
        params: LockboxRetrieveParams,
        requestOptions: RequestOptions
    ): Lockbox {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("lockboxes", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val updateHandler: Handler<Lockbox> =
        jsonHandler<Lockbox>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Update a Lockbox */
    override suspend fun update(
        params: LockboxUpdateParams,
        requestOptions: RequestOptions
    ): Lockbox {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("lockboxes", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<LockboxListPageAsync.Response> =
        jsonHandler<LockboxListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Lockboxes */
    override suspend fun list(
        params: LockboxListParams,
        requestOptions: RequestOptions
    ): LockboxListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("lockboxes")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { LockboxListPageAsync.of(this, params, it) }
        }
    }
}
