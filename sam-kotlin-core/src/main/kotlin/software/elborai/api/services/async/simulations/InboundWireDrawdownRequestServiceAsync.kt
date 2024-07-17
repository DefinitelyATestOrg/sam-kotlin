// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundWireDrawdownRequest
import software.elborai.api.models.SimulationInboundWireDrawdownRequestCreateParams

interface InboundWireDrawdownRequestServiceAsync {

    /** Simulates receiving an [Inbound Wire Drawdown Request](#inbound-wire-drawdown-requests). */
    suspend fun create(
        params: SimulationInboundWireDrawdownRequestCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireDrawdownRequest
}
