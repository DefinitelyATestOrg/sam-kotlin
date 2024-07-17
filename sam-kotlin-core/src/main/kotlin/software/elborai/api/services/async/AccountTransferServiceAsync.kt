// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.AccountTransfer
import software.elborai.api.models.AccountTransferApproveParams
import software.elborai.api.models.AccountTransferCancelParams
import software.elborai.api.models.AccountTransferCreateParams
import software.elborai.api.models.AccountTransferListPageAsync
import software.elborai.api.models.AccountTransferListParams
import software.elborai.api.models.AccountTransferRetrieveParams

interface AccountTransferServiceAsync {

    /** Create an Account Transfer */
    suspend fun create(
        params: AccountTransferCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountTransfer

    /** Retrieve an Account Transfer */
    suspend fun retrieve(
        params: AccountTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountTransfer

    /** List Account Transfers */
    suspend fun list(
        params: AccountTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountTransferListPageAsync

    /** Approve an Account Transfer */
    suspend fun approve(
        params: AccountTransferApproveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountTransfer

    /** Cancel an Account Transfer */
    suspend fun cancel(
        params: AccountTransferCancelParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountTransfer
}
