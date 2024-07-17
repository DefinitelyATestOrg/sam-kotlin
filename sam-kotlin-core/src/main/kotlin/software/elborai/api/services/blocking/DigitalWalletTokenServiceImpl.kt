// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.DigitalWalletToken
import software.elborai.api.models.DigitalWalletTokenListPage
import software.elborai.api.models.DigitalWalletTokenListParams
import software.elborai.api.models.DigitalWalletTokenRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class DigitalWalletTokenServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : DigitalWalletTokenService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<DigitalWalletToken> =
        jsonHandler<DigitalWalletToken>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Digital Wallet Token */
    override fun retrieve(
        params: DigitalWalletTokenRetrieveParams,
        requestOptions: RequestOptions
    ): DigitalWalletToken {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("digital_wallet_tokens", params.getPathParam(0))
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

    private val listHandler: Handler<DigitalWalletTokenListPage.Response> =
        jsonHandler<DigitalWalletTokenListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Digital Wallet Tokens */
    override fun list(
        params: DigitalWalletTokenListParams,
        requestOptions: RequestOptions
    ): DigitalWalletTokenListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("digital_wallet_tokens")
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
                .let { DigitalWalletTokenListPage.of(this, params, it) }
        }
    }
}
