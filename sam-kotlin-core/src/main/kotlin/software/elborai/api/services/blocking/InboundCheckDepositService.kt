// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundCheckDeposit
import software.elborai.api.models.InboundCheckDepositDeclineParams
import software.elborai.api.models.InboundCheckDepositListPage
import software.elborai.api.models.InboundCheckDepositListParams
import software.elborai.api.models.InboundCheckDepositRetrieveParams

interface InboundCheckDepositService {

    /** Retrieve an Inbound Check Deposit */
    fun retrieve(
        params: InboundCheckDepositRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDeposit

    /** List Inbound Check Deposits */
    fun list(
        params: InboundCheckDepositListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDepositListPage

    /** Decline an Inbound Check Deposit */
    fun decline(
        params: InboundCheckDepositDeclineParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundCheckDeposit
}
