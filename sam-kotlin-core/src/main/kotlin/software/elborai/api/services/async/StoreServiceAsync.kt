// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Order
import software.elborai.api.models.StoreCreateOrderParams
import software.elborai.api.models.StoreDeleteParams
import software.elborai.api.models.StoreInventoryParams
import software.elborai.api.models.StoreInventoryResponse
import software.elborai.api.models.StoreRetrieveParams
import software.elborai.api.services.async.stores.OrderServiceAsync

interface StoreServiceAsync {

    fun orders(): OrderServiceAsync

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    suspend fun retrieve(
        params: StoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Order

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    suspend fun delete(
        params: StoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    /** Place a new order in the store */
    suspend fun createOrder(
        params: StoreCreateOrderParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Order

    /** Returns a map of status codes to quantities */
    suspend fun inventory(
        params: StoreInventoryParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): StoreInventoryResponse
}
