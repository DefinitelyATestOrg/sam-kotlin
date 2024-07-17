// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.SimulationCardRefundCreateParams
import software.elborai.api.models.Transaction

interface CardRefundServiceAsync {

    /**
     * Simulates refunding a card transaction. The full value of the original sandbox transaction is
     * refunded.
     */
    suspend fun create(
        params: SimulationCardRefundCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Transaction
}
