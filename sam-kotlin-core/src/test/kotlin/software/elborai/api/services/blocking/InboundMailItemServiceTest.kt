// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.InboundMailItemListParams

@ExtendWith(TestServerExtension::class)
class InboundMailItemServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundMailItemService = client.inboundMailItems()
        val inboundMailItem =
            inboundMailItemService.retrieve(
                InboundMailItemRetrieveParams.builder().inboundMailItemId("string").build()
            )
        println(inboundMailItem)
        inboundMailItem.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundMailItemService = client.inboundMailItems()
        val inboundMailItemList =
            inboundMailItemService.list(InboundMailItemListParams.builder().build())
        println(inboundMailItemList)
        inboundMailItemList.data().forEach { it.validate() }
    }
}
