// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.async.store

import com.sam.api.core.ClientOptions
import com.sam.api.core.RequestOptions
import com.sam.api.core.handlers.emptyHandler
import com.sam.api.core.handlers.errorHandler
import com.sam.api.core.handlers.jsonHandler
import com.sam.api.core.handlers.withErrorHandler
import com.sam.api.core.http.HttpMethod
import com.sam.api.core.http.HttpRequest
import com.sam.api.core.http.HttpResponse.Handler
import com.sam.api.core.json
import com.sam.api.errors.SamError
import com.sam.api.models.Order
import com.sam.api.models.StoreOrderDeleteParams
import com.sam.api.models.StoreOrderRetrieveParams

class OrderServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OrderServiceAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Order> =
        jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    override suspend fun retrieve(
        params: StoreOrderRetrieveParams,
        requestOptions: RequestOptions
    ): Order {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("store", "order", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
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

    private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    override suspend fun delete(params: StoreOrderDeleteParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("store", "order", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { deleteHandler.handle(it) }
        }
    }
}
