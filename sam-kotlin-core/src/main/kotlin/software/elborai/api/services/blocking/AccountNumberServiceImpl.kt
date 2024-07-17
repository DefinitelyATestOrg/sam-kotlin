// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.AccountNumber
import software.elborai.api.models.AccountNumberCreateParams
import software.elborai.api.models.AccountNumberListPage
import software.elborai.api.models.AccountNumberListParams
import software.elborai.api.models.AccountNumberRetrieveParams
import software.elborai.api.models.AccountNumberUpdateParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class AccountNumberServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountNumberService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<AccountNumber> =
        jsonHandler<AccountNumber>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create an Account Number */
    override fun create(
        params: AccountNumberCreateParams,
        requestOptions: RequestOptions
    ): AccountNumber {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("account_numbers")
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

    private val retrieveHandler: Handler<AccountNumber> =
        jsonHandler<AccountNumber>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve an Account Number */
    override fun retrieve(
        params: AccountNumberRetrieveParams,
        requestOptions: RequestOptions
    ): AccountNumber {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("account_numbers", params.getPathParam(0))
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

    private val updateHandler: Handler<AccountNumber> =
        jsonHandler<AccountNumber>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Update an Account Number */
    override fun update(
        params: AccountNumberUpdateParams,
        requestOptions: RequestOptions
    ): AccountNumber {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("account_numbers", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<AccountNumberListPage.Response> =
        jsonHandler<AccountNumberListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Account Numbers */
    override fun list(
        params: AccountNumberListParams,
        requestOptions: RequestOptions
    ): AccountNumberListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("account_numbers")
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
                .let { AccountNumberListPage.of(this, params, it) }
        }
    }
}
