// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CheckTransfer
import software.elborai.api.models.CheckTransferApproveParams
import software.elborai.api.models.CheckTransferCancelParams
import software.elborai.api.models.CheckTransferCreateParams
import software.elborai.api.models.CheckTransferListPage
import software.elborai.api.models.CheckTransferListParams
import software.elborai.api.models.CheckTransferRetrieveParams
import software.elborai.api.models.CheckTransferStopPaymentParams

interface CheckTransferService {

    /** Create a Check Transfer */
    fun create(
        params: CheckTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransfer

    /** Retrieve a Check Transfer */
    fun retrieve(
        params: CheckTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransfer

    /** List Check Transfers */
    fun list(
        params: CheckTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransferListPage

    /** Approve a Check Transfer */
    fun approve(
        params: CheckTransferApproveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransfer

    /** Cancel a pending Check Transfer */
    fun cancel(
        params: CheckTransferCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransfer

    /** Request a stop payment on a Check Transfer */
    fun stopPayment(
        params: CheckTransferStopPaymentParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransfer
}
