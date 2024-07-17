// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.InboundInternationalAchTransfer
import software.elborai.api.models.SimulationInboundInternationalAchTransferCreateParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class InboundInternationalAchTransferServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : InboundInternationalAchTransferService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<InboundInternationalAchTransfer> =
        jsonHandler<InboundInternationalAchTransfer>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Simulates an inbound international ACH transfer to your account. This imitates initiating a
     * transfer to an Increase account from a different financial institution. The transfer may be
     * either a credit or a debit depending on if the `amount` is positive or negative. The result
     * of calling this API will contain the created transfer. .
     */
    override fun create(
        params: SimulationInboundInternationalAchTransferCreateParams,
        requestOptions: RequestOptions
    ): InboundInternationalAchTransfer {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("simulations", "inbound_international_ach_transfers")
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
