// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.InboundRealTimePaymentsTransferSimulationResult
import software.elborai.api.models.RealTimePaymentsTransfer
import software.elborai.api.models.SimulationRealTimePaymentsTransferCompleteParams
import software.elborai.api.models.SimulationRealTimePaymentsTransferCreateInboundParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class RealTimePaymentsTransferServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : RealTimePaymentsTransferService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val completeHandler: Handler<RealTimePaymentsTransfer> =
        jsonHandler<RealTimePaymentsTransfer>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Simulates submission of a Real-Time Payments transfer and handling the response from the
     * destination financial institution. This transfer must first have a `status` of
     * `pending_submission`.
     */
    override fun complete(
        params: SimulationRealTimePaymentsTransferCompleteParams,
        requestOptions: RequestOptions
    ): RealTimePaymentsTransfer {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments(
                    "simulations",
                    "real_time_payments_transfers",
                    params.getPathParam(0),
                    "complete"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { completeHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val createInboundHandler: Handler<InboundRealTimePaymentsTransferSimulationResult> =
        jsonHandler<InboundRealTimePaymentsTransferSimulationResult>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Simulates an inbound Real-Time Payments transfer to your account. Real-Time Payments are a
     * beta feature.
     */
    override fun createInbound(
        params: SimulationRealTimePaymentsTransferCreateInboundParams,
        requestOptions: RequestOptions
    ): InboundRealTimePaymentsTransferSimulationResult {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("simulations", "inbound_real_time_payments_transfers")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createInboundHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
