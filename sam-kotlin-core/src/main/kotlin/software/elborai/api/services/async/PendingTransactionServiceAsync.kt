// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.PendingTransaction
import software.elborai.api.models.PendingTransactionListPageAsync
import software.elborai.api.models.PendingTransactionListParams
import software.elborai.api.models.PendingTransactionRetrieveParams

interface PendingTransactionServiceAsync {

    /** Retrieve a Pending Transaction */
    suspend fun retrieve(
        params: PendingTransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PendingTransaction

    /** List Pending Transactions */
    suspend fun list(
        params: PendingTransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PendingTransactionListPageAsync
}
