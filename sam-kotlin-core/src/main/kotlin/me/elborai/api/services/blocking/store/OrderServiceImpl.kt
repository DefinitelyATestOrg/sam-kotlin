// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.store

import me.elborai.api.core.ClientOptions

class OrderServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : OrderService.WithRawResponse
}
