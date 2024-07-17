// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.OAuthToken
import software.elborai.api.models.OAuthTokenCreateParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class OAuthTokenServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : OAuthTokenService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<OAuthToken> =
        jsonHandler<OAuthToken>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create an OAuth Token */
    override fun create(
        params: OAuthTokenCreateParams,
        requestOptions: RequestOptions
    ): OAuthToken {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("oauth", "tokens")
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
}
