// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.BookkeepingEntrySet
import software.elborai.api.models.BookkeepingEntrySetCreateParams
import software.elborai.api.models.BookkeepingEntrySetListPage
import software.elborai.api.models.BookkeepingEntrySetListParams
import software.elborai.api.models.BookkeepingEntrySetRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class BookkeepingEntrySetServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : BookkeepingEntrySetService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<BookkeepingEntrySet> =
        jsonHandler<BookkeepingEntrySet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a Bookkeeping Entry Set */
    override fun create(
        params: BookkeepingEntrySetCreateParams,
        requestOptions: RequestOptions
    ): BookkeepingEntrySet {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("bookkeeping_entry_sets")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<BookkeepingEntrySet> =
        jsonHandler<BookkeepingEntrySet>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Bookkeeping Entry Set */
    override fun retrieve(
        params: BookkeepingEntrySetRetrieveParams,
        requestOptions: RequestOptions
    ): BookkeepingEntrySet {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("bookkeeping_entry_sets", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<BookkeepingEntrySetListPage.Response> =
        jsonHandler<BookkeepingEntrySetListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Bookkeeping Entry Sets */
    override fun list(
        params: BookkeepingEntrySetListParams,
        requestOptions: RequestOptions
    ): BookkeepingEntrySetListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("bookkeeping_entry_sets")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { BookkeepingEntrySetListPage.of(this, params, it) }
        }
    }
}
