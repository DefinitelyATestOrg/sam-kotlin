// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.store

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class OrderServiceTest {

    @Test
    fun callRetrieve() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val orderService = client.store().orders()
        val order = orderService.retrieve(StoreOrderRetrieveParams.builder().orderId(123L).build())
        println(order)
        order.validate()
    }

    @Test
    fun callDelete() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val orderService = client.store().orders()
        orderService.delete(StoreOrderDeleteParams.builder().orderId(123L).build())
    }
}
