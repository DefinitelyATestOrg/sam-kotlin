// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.async

import com.sam.api.core.ClientOptions
import com.sam.api.services.async.store.OrderServiceAsync
import com.sam.api.services.async.store.OrderServiceAsyncImpl

class StoreServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : StoreServiceAsync {

    private val orders: OrderServiceAsync by lazy { OrderServiceAsyncImpl(clientOptions) }

    override fun orders(): OrderServiceAsync = orders
}
