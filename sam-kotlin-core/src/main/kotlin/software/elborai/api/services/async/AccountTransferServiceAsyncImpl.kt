// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.AccountTransfer
import software.elborai.api.models.AccountTransferApproveParams
import software.elborai.api.models.AccountTransferCancelParams
import software.elborai.api.models.AccountTransferCreateParams
import software.elborai.api.models.AccountTransferListPageAsync
import software.elborai.api.models.AccountTransferListParams
import software.elborai.api.models.AccountTransferRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class AccountTransferServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountTransferServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<AccountTransfer> =
        jsonHandler<AccountTransfer>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create an Account Transfer */
    override suspend fun create(
        params: AccountTransferCreateParams,
        requestOptions: RequestOptions
    ): AccountTransfer {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("account_transfers")
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

    private val retrieveHandler: Handler<AccountTransfer> =
        jsonHandler<AccountTransfer>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve an Account Transfer */
    override suspend fun retrieve(
        params: AccountTransferRetrieveParams,
        requestOptions: RequestOptions
    ): AccountTransfer {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("account_transfers", params.getPathParam(0))
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

    private val listHandler: Handler<AccountTransferListPageAsync.Response> =
        jsonHandler<AccountTransferListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Account Transfers */
    override suspend fun list(
        params: AccountTransferListParams,
        requestOptions: RequestOptions
    ): AccountTransferListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("account_transfers")
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
                .let { AccountTransferListPageAsync.of(this, params, it) }
        }
    }

    private val approveHandler: Handler<AccountTransfer> =
        jsonHandler<AccountTransfer>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Approve an Account Transfer */
    override suspend fun approve(
        params: AccountTransferApproveParams,
        requestOptions: RequestOptions
    ): AccountTransfer {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("account_transfers", params.getPathParam(0), "approve")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { approveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val cancelHandler: Handler<AccountTransfer> =
        jsonHandler<AccountTransfer>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Cancel an Account Transfer */
    override suspend fun cancel(
        params: AccountTransferCancelParams,
        requestOptions: RequestOptions
    ): AccountTransfer {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("account_transfers", params.getPathParam(0), "cancel")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { cancelHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}