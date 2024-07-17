// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.InboundWireTransferListParams

@ExtendWith(TestServerExtension::class)
class InboundWireTransferServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundWireTransferService = client.inboundWireTransfers()
        val inboundWireTransfer =
            inboundWireTransferService.retrieve(
                InboundWireTransferRetrieveParams.builder().inboundWireTransferId("string").build()
            )
        println(inboundWireTransfer)
        inboundWireTransfer.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundWireTransferService = client.inboundWireTransfers()
        val inboundWireTransferList =
            inboundWireTransferService.list(InboundWireTransferListParams.builder().build())
        println(inboundWireTransferList)
        inboundWireTransferList.data().forEach { it.validate() }
    }
}
