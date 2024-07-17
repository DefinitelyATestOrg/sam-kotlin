// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CardPurchaseSupplement
import software.elborai.api.models.CardPurchaseSupplementListPageAsync
import software.elborai.api.models.CardPurchaseSupplementListParams
import software.elborai.api.models.CardPurchaseSupplementRetrieveParams

interface CardPurchaseSupplementServiceAsync {

    /** Retrieve a Card Purchase Supplement */
    suspend fun retrieve(
        params: CardPurchaseSupplementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPurchaseSupplement

    /** List Card Purchase Supplements */
    suspend fun list(
        params: CardPurchaseSupplementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPurchaseSupplementListPageAsync
}