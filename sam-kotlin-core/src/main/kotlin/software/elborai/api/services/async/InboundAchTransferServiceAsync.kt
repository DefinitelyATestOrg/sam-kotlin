// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundAchTransfer
import software.elborai.api.models.InboundAchTransferDeclineParams
import software.elborai.api.models.InboundAchTransferListPageAsync
import software.elborai.api.models.InboundAchTransferListParams
import software.elborai.api.models.InboundAchTransferNotificationOfChangeParams
import software.elborai.api.models.InboundAchTransferRetrieveParams
import software.elborai.api.models.InboundAchTransferTransferReturnParams

interface InboundAchTransferServiceAsync {

    /** Retrieve an Inbound ACH Transfer */
    suspend fun retrieve(
        params: InboundAchTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundAchTransfer

    /** List Inbound ACH Transfers */
    suspend fun list(
        params: InboundAchTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundAchTransferListPageAsync

    /** Decline an Inbound ACH Transfer */
    suspend fun decline(
        params: InboundAchTransferDeclineParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundAchTransfer

    /** Create a notification of change for an Inbound ACH Transfer */
    suspend fun notificationOfChange(
        params: InboundAchTransferNotificationOfChangeParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundAchTransfer

    /** Return an Inbound ACH Transfer */
    suspend fun transferReturn(
        params: InboundAchTransferTransferReturnParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundAchTransfer
}
