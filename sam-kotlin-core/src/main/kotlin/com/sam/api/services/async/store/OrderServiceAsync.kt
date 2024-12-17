// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.async.store

import com.sam.api.core.RequestOptions
import com.sam.api.models.Order
import com.sam.api.models.StoreOrderDeleteParams
import com.sam.api.models.StoreOrderRetrieveParams

interface OrderServiceAsync {

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    suspend fun retrieve(
        params: StoreOrderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Order

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    suspend fun delete(
        params: StoreOrderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}
