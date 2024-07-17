// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.AchTransfer
import software.elborai.api.models.AchTransferApproveParams
import software.elborai.api.models.AchTransferCancelParams
import software.elborai.api.models.AchTransferCreateParams
import software.elborai.api.models.AchTransferListPageAsync
import software.elborai.api.models.AchTransferListParams
import software.elborai.api.models.AchTransferRetrieveParams

interface AchTransferServiceAsync {

    /** Create an ACH Transfer */
    suspend fun create(
        params: AchTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer

    /** Retrieve an ACH Transfer */
    suspend fun retrieve(
        params: AchTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer

    /** List ACH Transfers */
    suspend fun list(
        params: AchTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransferListPageAsync

    /** Approves an ACH Transfer in a pending_approval state. */
    suspend fun approve(
        params: AchTransferApproveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer

    /** Cancels an ACH Transfer in a pending_approval state. */
    suspend fun cancel(
        params: AchTransferCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer
}
