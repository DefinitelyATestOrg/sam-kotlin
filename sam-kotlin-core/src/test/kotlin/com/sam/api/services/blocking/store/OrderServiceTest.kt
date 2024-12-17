// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.blocking.store

import com.sam.api.TestServerExtension
import com.sam.api.client.okhttp.SamOkHttpClient
import com.sam.api.models.StoreOrderDeleteParams
import com.sam.api.models.StoreOrderRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class OrderServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderService = client.store().orders()
        val order = orderService.retrieve(StoreOrderRetrieveParams.builder().orderId(0L).build())
        println(order)
        order.validate()
    }

    @Test
    fun callDelete() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val orderService = client.store().orders()
        orderService.delete(StoreOrderDeleteParams.builder().orderId(0L).build())
    }
}
