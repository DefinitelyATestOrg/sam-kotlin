// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.PendingTransaction
import software.elborai.api.models.PendingTransactionListPage
import software.elborai.api.models.PendingTransactionListParams
import software.elborai.api.models.PendingTransactionRetrieveParams

interface PendingTransactionService {

    /** Retrieve a Pending Transaction */
    fun retrieve(
        params: PendingTransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PendingTransaction

    /** List Pending Transactions */
    fun list(
        params: PendingTransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PendingTransactionListPage
}
