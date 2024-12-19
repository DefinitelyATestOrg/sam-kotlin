// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.core.ClientOptions
import me.elborai.api.services.async.store.OrderServiceAsync
import me.elborai.api.services.async.store.OrderServiceAsyncImpl

class StoreServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : StoreServiceAsync {

    private val orders: OrderServiceAsync by lazy { OrderServiceAsyncImpl(clientOptions) }

    override fun orders(): OrderServiceAsync = orders
}
