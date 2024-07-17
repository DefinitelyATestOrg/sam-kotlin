// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.PendingTransaction
import software.elborai.api.models.PendingTransactionListPageAsync
import software.elborai.api.models.PendingTransactionListParams
import software.elborai.api.models.PendingTransactionRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class PendingTransactionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PendingTransactionServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<PendingTransaction> =
        jsonHandler<PendingTransaction>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Pending Transaction */
    override suspend fun retrieve(
        params: PendingTransactionRetrieveParams,
        requestOptions: RequestOptions
    ): PendingTransaction {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("pending_transactions", params.getPathParam(0))
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

    private val listHandler: Handler<PendingTransactionListPageAsync.Response> =
        jsonHandler<PendingTransactionListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Pending Transactions */
    override suspend fun list(
        params: PendingTransactionListParams,
        requestOptions: RequestOptions
    ): PendingTransactionListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("pending_transactions")
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
                .let { PendingTransactionListPageAsync.of(this, params, it) }
        }
    }
}
