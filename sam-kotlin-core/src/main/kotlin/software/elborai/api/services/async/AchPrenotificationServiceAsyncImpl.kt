// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.AchPrenotification
import software.elborai.api.models.AchPrenotificationCreateParams
import software.elborai.api.models.AchPrenotificationListPageAsync
import software.elborai.api.models.AchPrenotificationListParams
import software.elborai.api.models.AchPrenotificationRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class AchPrenotificationServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AchPrenotificationServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<AchPrenotification> =
        jsonHandler<AchPrenotification>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create an ACH Prenotification */
    override suspend fun create(
        params: AchPrenotificationCreateParams,
        requestOptions: RequestOptions
    ): AchPrenotification {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("ach_prenotifications")
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

    private val retrieveHandler: Handler<AchPrenotification> =
        jsonHandler<AchPrenotification>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve an ACH Prenotification */
    override suspend fun retrieve(
        params: AchPrenotificationRetrieveParams,
        requestOptions: RequestOptions
    ): AchPrenotification {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ach_prenotifications", params.getPathParam(0))
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

    private val listHandler: Handler<AchPrenotificationListPageAsync.Response> =
        jsonHandler<AchPrenotificationListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List ACH Prenotifications */
    override suspend fun list(
        params: AchPrenotificationListParams,
        requestOptions: RequestOptions
    ): AchPrenotificationListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("ach_prenotifications")
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
                .let { AchPrenotificationListPageAsync.of(this, params, it) }
        }
    }
}
