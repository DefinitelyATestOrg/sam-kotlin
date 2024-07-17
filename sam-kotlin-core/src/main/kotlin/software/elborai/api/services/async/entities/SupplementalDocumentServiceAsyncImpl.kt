// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async.entities

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.Entity
import software.elborai.api.models.EntitySupplementalDocumentCreateParams
import software.elborai.api.models.EntitySupplementalDocumentListPageAsync
import software.elborai.api.models.EntitySupplementalDocumentListParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class SupplementalDocumentServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SupplementalDocumentServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Entity> =
        jsonHandler<Entity>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a supplemental document for an Entity */
    override suspend fun create(
        params: EntitySupplementalDocumentCreateParams,
        requestOptions: RequestOptions
    ): Entity {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("entities", params.getPathParam(0), "supplemental_documents")
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

    private val listHandler: Handler<EntitySupplementalDocumentListPageAsync.Response> =
        jsonHandler<EntitySupplementalDocumentListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Entity Supplemental Document Submissions */
    override suspend fun list(
        params: EntitySupplementalDocumentListParams,
        requestOptions: RequestOptions
    ): EntitySupplementalDocumentListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("entity_supplemental_documents")
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
                .let { EntitySupplementalDocumentListPageAsync.of(this, params, it) }
        }
    }
}
