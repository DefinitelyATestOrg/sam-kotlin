// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.blocking

import com.sam.api.core.ClientOptions
import com.sam.api.services.blocking.store.OrderService
import com.sam.api.services.blocking.store.OrderServiceImpl

class StoreServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : StoreService {

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun orders(): OrderService = orders
}
