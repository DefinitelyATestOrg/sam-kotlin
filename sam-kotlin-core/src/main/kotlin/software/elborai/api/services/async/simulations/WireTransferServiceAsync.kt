// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundWireTransfer
import software.elborai.api.models.SimulationWireTransferCreateInboundParams

interface WireTransferServiceAsync {

    /** Simulates an inbound Wire Transfer to your account. */
    suspend fun createInbound(
        params: SimulationWireTransferCreateInboundParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireTransfer
}
