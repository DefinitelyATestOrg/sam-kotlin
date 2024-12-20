// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.ClientOptions
import me.elborai.api.services.blocking.store.OrderService
import me.elborai.api.services.blocking.store.OrderServiceImpl

class StoreServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : StoreService {

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun orders(): OrderService = orders
}
