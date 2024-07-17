// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.DeclinedTransaction
import software.elborai.api.models.DeclinedTransactionListPageAsync
import software.elborai.api.models.DeclinedTransactionListParams
import software.elborai.api.models.DeclinedTransactionRetrieveParams

interface DeclinedTransactionServiceAsync {

    /** Retrieve a Declined Transaction */
    suspend fun retrieve(
        params: DeclinedTransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DeclinedTransaction

    /** List Declined Transactions */
    suspend fun list(
        params: DeclinedTransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DeclinedTransactionListPageAsync
}
