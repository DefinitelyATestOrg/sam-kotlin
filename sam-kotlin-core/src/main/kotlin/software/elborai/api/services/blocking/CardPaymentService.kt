// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CardPayment
import software.elborai.api.models.CardPaymentListPage
import software.elborai.api.models.CardPaymentListParams
import software.elborai.api.models.CardPaymentRetrieveParams

interface CardPaymentService {

    /** Retrieve a Card Payment */
    fun retrieve(
        params: CardPaymentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /** List Card Payments */
    fun list(
        params: CardPaymentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPaymentListPage
}
