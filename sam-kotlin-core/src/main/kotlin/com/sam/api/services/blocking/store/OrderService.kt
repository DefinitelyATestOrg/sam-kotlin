// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.blocking.store

import com.sam.api.core.RequestOptions
import com.sam.api.models.Order
import com.sam.api.models.StoreOrderDeleteParams
import com.sam.api.models.StoreOrderRetrieveParams

interface OrderService {

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    fun retrieve(
        params: StoreOrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Order

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    fun delete(
        params: StoreOrderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}
