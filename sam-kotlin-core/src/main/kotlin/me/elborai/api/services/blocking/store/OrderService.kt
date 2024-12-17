// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.store

import me.elborai.api.core.RequestOptions
import me.elborai.api.models.CoolOrder
import me.elborai.api.models.StoreOrderDeleteParams
import me.elborai.api.models.StoreOrderRetrieveParams

interface OrderService {

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    fun retrieve(
        params: StoreOrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CoolOrder

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    fun delete(
        params: StoreOrderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}
