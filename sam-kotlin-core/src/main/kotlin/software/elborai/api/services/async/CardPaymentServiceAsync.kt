// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CardPayment
import software.elborai.api.models.CardPaymentListPageAsync
import software.elborai.api.models.CardPaymentListParams
import software.elborai.api.models.CardPaymentRetrieveParams

interface CardPaymentServiceAsync {

    /** Retrieve a Card Payment */
    suspend fun retrieve(
        params: CardPaymentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /** List Card Payments */
    suspend fun list(
        params: CardPaymentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPaymentListPageAsync
}
