// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class StoreServiceTest {

    @Test
    fun callCreateOrder() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val storeService = client.stores()
        val order =
            storeService.createOrder(
                StoreCreateOrderParams.builder()
                    .id(123L)
                    .complete(true)
                    .petId(123L)
                    .quantity(123L)
                    .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status(StoreCreateOrderParams.Status.PLACED)
                    .build()
            )
        println(order)
        order.validate()
    }

    @Test
    fun callInventory() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val storeService = client.stores()
        val storeInventoryResponse = storeService.inventory(StoreInventoryParams.builder().build())
        println(storeInventoryResponse)
        storeInventoryResponse.validate()
    }
}
