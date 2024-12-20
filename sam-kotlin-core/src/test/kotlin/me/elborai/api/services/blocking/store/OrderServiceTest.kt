// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.store

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.models.StoreOrderDeleteParams
import me.elborai.api.models.StoreOrderRetrieveParams
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
        val coolOrder =
            orderService.retrieve(StoreOrderRetrieveParams.builder().orderId(0L).build())
        println(coolOrder)
        coolOrder.validate()
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
