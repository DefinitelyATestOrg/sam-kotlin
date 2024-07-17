// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.WireDrawdownRequest
import software.elborai.api.models.WireDrawdownRequestCreateParams
import software.elborai.api.models.WireDrawdownRequestListPageAsync
import software.elborai.api.models.WireDrawdownRequestListParams
import software.elborai.api.models.WireDrawdownRequestRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class WireDrawdownRequestServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : WireDrawdownRequestServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<WireDrawdownRequest> =
        jsonHandler<WireDrawdownRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a Wire Drawdown Request */
    override suspend fun create(
        params: WireDrawdownRequestCreateParams,
        requestOptions: RequestOptions
    ): WireDrawdownRequest {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("wire_drawdown_requests")
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

    private val retrieveHandler: Handler<WireDrawdownRequest> =
        jsonHandler<WireDrawdownRequest>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Wire Drawdown Request */
    override suspend fun retrieve(
        params: WireDrawdownRequestRetrieveParams,
        requestOptions: RequestOptions
    ): WireDrawdownRequest {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("wire_drawdown_requests", params.getPathParam(0))
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

    private val listHandler: Handler<WireDrawdownRequestListPageAsync.Response> =
        jsonHandler<WireDrawdownRequestListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Wire Drawdown Requests */
    override suspend fun list(
        params: WireDrawdownRequestListParams,
        requestOptions: RequestOptions
    ): WireDrawdownRequestListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("wire_drawdown_requests")
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
                .let { WireDrawdownRequestListPageAsync.of(this, params, it) }
        }
    }
}
