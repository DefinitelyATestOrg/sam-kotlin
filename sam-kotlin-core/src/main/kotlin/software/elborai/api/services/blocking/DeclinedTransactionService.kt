// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.DeclinedTransaction
import software.elborai.api.models.DeclinedTransactionListPage
import software.elborai.api.models.DeclinedTransactionListParams
import software.elborai.api.models.DeclinedTransactionRetrieveParams

interface DeclinedTransactionService {

    /** Retrieve a Declined Transaction */
    fun retrieve(
        params: DeclinedTransactionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DeclinedTransaction

    /** List Declined Transactions */
    fun list(
        params: DeclinedTransactionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DeclinedTransactionListPage
}
