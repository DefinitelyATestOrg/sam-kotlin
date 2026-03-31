// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.store

import me.elborai.api.core.ClientOptions

class OrderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): OrderService =
        OrderServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderService.WithRawResponse {

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): OrderService.WithRawResponse =
            OrderServiceImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())
    }
}
