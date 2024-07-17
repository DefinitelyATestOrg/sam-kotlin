// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.InboundAchTransferListParams

@ExtendWith(TestServerExtension::class)
class InboundAchTransferServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundAchTransferService = client.inboundAchTransfers()
        val inboundAchTransfer =
            inboundAchTransferService.retrieve(
                InboundAchTransferRetrieveParams.builder().inboundAchTransferId("string").build()
            )
        println(inboundAchTransfer)
        inboundAchTransfer.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundAchTransferService = client.inboundAchTransfers()
        val inboundAchTransferList =
            inboundAchTransferService.list(InboundAchTransferListParams.builder().build())
        println(inboundAchTransferList)
        inboundAchTransferList.data().forEach { it.validate() }
    }

    @Test
    fun callDecline() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundAchTransferService = client.inboundAchTransfers()
        val inboundAchTransfer =
            inboundAchTransferService.decline(
                InboundAchTransferDeclineParams.builder().inboundAchTransferId("string").build()
            )
        println(inboundAchTransfer)
        inboundAchTransfer.validate()
    }

    @Test
    fun callNotificationOfChange() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundAchTransferService = client.inboundAchTransfers()
        val inboundAchTransfer =
            inboundAchTransferService.notificationOfChange(
                InboundAchTransferNotificationOfChangeParams.builder()
                    .inboundAchTransferId("string")
                    .updatedAccountNumber("x")
                    .updatedRoutingNumber("x")
                    .build()
            )
        println(inboundAchTransfer)
        inboundAchTransfer.validate()
    }

    @Test
    fun callTransferReturn() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundAchTransferService = client.inboundAchTransfers()
        val inboundAchTransfer =
            inboundAchTransferService.transferReturn(
                InboundAchTransferTransferReturnParams.builder()
                    .inboundAchTransferId("string")
                    .reason(InboundAchTransferTransferReturnParams.Reason.INSUFFICIENT_FUNDS)
                    .build()
            )
        println(inboundAchTransfer)
        inboundAchTransfer.validate()
    }
}
