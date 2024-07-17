// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundCheckDeposit
import software.elborai.api.models.InboundCheckDepositDeclineParams
import software.elborai.api.models.InboundCheckDepositListPageAsync
import software.elborai.api.models.InboundCheckDepositListParams
import software.elborai.api.models.InboundCheckDepositRetrieveParams

interface InboundCheckDepositServiceAsync {

    /** Retrieve an Inbound Check Deposit */
    suspend fun retrieve(
        params: InboundCheckDepositRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDeposit

    /** List Inbound Check Deposits */
    suspend fun list(
        params: InboundCheckDepositListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDepositListPageAsync

    /** Decline an Inbound Check Deposit */
    suspend fun decline(
        params: InboundCheckDepositDeclineParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDeposit
}
