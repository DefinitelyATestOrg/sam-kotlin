// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.RoutingNumberListPage
import software.elborai.api.models.RoutingNumberListParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class RoutingNumberServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : RoutingNumberService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val listHandler: Handler<RoutingNumberListPage.Response> =
        jsonHandler<RoutingNumberListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * You can use this API to confirm if a routing number is valid, such as when a user is
     * providing you with bank account details. Since routing numbers uniquely identify a bank, this
     * will always return 0 or 1 entry. In Sandbox, the only valid routing number for this method
     * is 110000000.
     */
    override fun list(
        params: RoutingNumberListParams,
        requestOptions: RequestOptions
    ): RoutingNumberListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("routing_numbers")
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
                .let { RoutingNumberListPage.of(this, params, it) }
        }
    }
}
