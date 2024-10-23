// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Order
import software.elborai.api.models.StoreCreateOrderParams
import software.elborai.api.models.StoreDeleteParams
import software.elborai.api.models.StoreInventoryParams
import software.elborai.api.models.StoreInventoryResponse
import software.elborai.api.models.StoreRetrieveParams
import software.elborai.api.services.blocking.stores.OrderService

interface StoreService {

    fun orders(): OrderService

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    fun retrieve(
        params: StoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Order

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    fun delete(params: StoreDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Place a new order in the store */
    fun createOrder(
        params: StoreCreateOrderParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Order

    /** Returns a map of status codes to quantities */
    fun inventory(
        params: StoreInventoryParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): StoreInventoryResponse
}
