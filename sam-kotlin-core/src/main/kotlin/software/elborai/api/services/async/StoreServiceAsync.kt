// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Order
import software.elborai.api.models.StoreCreateOrderParams
import software.elborai.api.models.StoreInventoryParams
import software.elborai.api.models.StoreInventoryResponse
import software.elborai.api.services.async.stores.OrderServiceAsync

interface StoreServiceAsync {

    fun orders(): OrderServiceAsync

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
