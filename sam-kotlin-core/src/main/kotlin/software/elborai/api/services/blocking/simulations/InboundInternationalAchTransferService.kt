// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundInternationalAchTransfer
import software.elborai.api.models.SimulationInboundInternationalAchTransferCreateParams

interface InboundInternationalAchTransferService {

    /**
     * Simulates an inbound international ACH transfer to your account. This imitates initiating a
     * transfer to an Increase account from a different financial institution. The transfer may be
     * either a credit or a debit depending on if the `amount` is positive or negative. The result
     * of calling this API will contain the created transfer. .
     */
    fun create(
        params: SimulationInboundInternationalAchTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundInternationalAchTransfer
}
