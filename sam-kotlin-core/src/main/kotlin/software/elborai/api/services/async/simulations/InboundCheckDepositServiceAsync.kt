// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundCheckDeposit
import software.elborai.api.models.SimulationInboundCheckDepositCreateParams

interface InboundCheckDepositServiceAsync {

    /**
     * Simulates an Inbound Check Deposit against your account. This imitates someone depositing a
     * check at their bank that was issued from your account. It may or may not be associated with a
     * Check Transfer. Increase will evaluate the Check Deposit as we would in production and either
     * create a Transaction or a Declined Transaction as a result. You can inspect the resulting
     * Inbound Check Deposit object to see the result.
     */
    suspend fun create(
        params: SimulationInboundCheckDepositCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDeposit
}
