// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.Program
import software.elborai.api.models.ProgramListPageAsync
import software.elborai.api.models.ProgramListParams
import software.elborai.api.models.ProgramRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class ProgramServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ProgramServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<Program> =
        jsonHandler<Program>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Program */
    override suspend fun retrieve(
        params: ProgramRetrieveParams,
        requestOptions: RequestOptions
    ): Program {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("programs", params.getPathParam(0))
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

    private val listHandler: Handler<ProgramListPageAsync.Response> =
        jsonHandler<ProgramListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Programs */
    override suspend fun list(
        params: ProgramListParams,
        requestOptions: RequestOptions
    ): ProgramListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("programs")
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
                .let { ProgramListPageAsync.of(this, params, it) }
        }
    }
}
