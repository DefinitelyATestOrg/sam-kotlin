// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.core.ClientOptions
import me.elborai.api.services.async.store.OrderServiceAsync
import me.elborai.api.services.async.store.OrderServiceAsyncImpl

class StoreServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : StoreServiceAsync {

    private val withRawResponse: StoreServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val orders: OrderServiceAsync by lazy { OrderServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): StoreServiceAsync.WithRawResponse = withRawResponse

    override fun orders(): OrderServiceAsync = orders

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : StoreServiceAsync.WithRawResponse {

        private val orders: OrderServiceAsync.WithRawResponse by lazy { OrderServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun orders(): OrderServiceAsync.WithRawResponse = orders
    }
}
