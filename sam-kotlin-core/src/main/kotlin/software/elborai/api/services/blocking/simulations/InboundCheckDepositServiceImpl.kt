// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.InboundCheckDeposit
import software.elborai.api.models.SimulationInboundCheckDepositCreateParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class InboundCheckDepositServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : InboundCheckDepositService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<InboundCheckDeposit> =
        jsonHandler<InboundCheckDeposit>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Simulates an Inbound Check Deposit against your account. This imitates someone depositing a
     * check at their bank that was issued from your account. It may or may not be associated with a
     * Check Transfer. Increase will evaluate the Check Deposit as we would in production and either
     * create a Transaction or a Declined Transaction as a result. You can inspect the resulting
     * Inbound Check Deposit object to see the result.
     */
    override fun create(
        params: SimulationInboundCheckDepositCreateParams,
        requestOptions: RequestOptions
    ): InboundCheckDeposit {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("simulations", "inbound_check_deposits")
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
