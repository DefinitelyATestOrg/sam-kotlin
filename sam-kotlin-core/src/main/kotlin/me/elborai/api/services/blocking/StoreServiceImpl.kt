// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.ClientOptions
import me.elborai.api.services.blocking.store.OrderService
import me.elborai.api.services.blocking.store.OrderServiceImpl

class StoreServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StoreService {

    private val withRawResponse: StoreService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun withRawResponse(): StoreService.WithRawResponse = withRawResponse

    override fun orders(): OrderService = orders

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StoreService.WithRawResponse {

        private val orders: OrderService.WithRawResponse by lazy {
            OrderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun orders(): OrderService.WithRawResponse = orders
    }
}
