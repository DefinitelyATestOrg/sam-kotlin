// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Transaction
import software.elborai.api.models.TransactionListPageAsync
import software.elborai.api.models.TransactionListParams
import software.elborai.api.models.TransactionRetrieveParams

interface TransactionServiceAsync {

    /** Retrieve a Transaction */
    suspend fun retrieve(
        params: TransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Transaction

    /** List Transactions */
    suspend fun list(
        params: TransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): TransactionListPageAsync
}
