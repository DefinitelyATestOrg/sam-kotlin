// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.WireTransfer
import software.elborai.api.models.WireTransferApproveParams
import software.elborai.api.models.WireTransferCancelParams
import software.elborai.api.models.WireTransferCreateParams
import software.elborai.api.models.WireTransferListPage
import software.elborai.api.models.WireTransferListParams
import software.elborai.api.models.WireTransferRetrieveParams
import software.elborai.api.models.WireTransferReverseParams
import software.elborai.api.models.WireTransferSubmitParams

interface WireTransferService {

    /** Create a Wire Transfer */
    fun create(
        params: WireTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransfer

    /** Retrieve a Wire Transfer */
    fun retrieve(
        params: WireTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransfer

    /** List Wire Transfers */
    fun list(
        params: WireTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransferListPage

    /** Approve a Wire Transfer */
    fun approve(
        params: WireTransferApproveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransfer

    /** Cancel a pending Wire Transfer */
    fun cancel(
        params: WireTransferCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransfer

    /**
     * Simulates the reversal of a [Wire Transfer](#wire-transfers) by the Federal Reserve due to
     * error conditions. This will also create a [Transaction](#transaction) to account for the
     * returned funds. This Wire Transfer must first have a `status` of `complete`.
     */
    fun reverse(
        params: WireTransferReverseParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransfer

    /**
     * Simulates the submission of a [Wire Transfer](#wire-transfers) to the Federal Reserve. This
     * transfer must first have a `status` of `pending_approval` or `pending_creating`.
     */
    fun submit(
        params: WireTransferSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): WireTransfer
}