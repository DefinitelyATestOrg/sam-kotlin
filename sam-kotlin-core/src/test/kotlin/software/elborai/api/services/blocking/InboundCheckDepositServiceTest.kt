// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.InboundCheckDepositListParams

@ExtendWith(TestServerExtension::class)
class InboundCheckDepositServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundCheckDepositService = client.inboundCheckDeposits()
        val inboundCheckDeposit =
            inboundCheckDepositService.retrieve(
                InboundCheckDepositRetrieveParams.builder()
                    .inboundCheckDepositId("inbound_check_deposit_id")
                    .build()
            )
        println(inboundCheckDeposit)
        inboundCheckDeposit.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundCheckDepositService = client.inboundCheckDeposits()
        val inboundCheckDepositList =
            inboundCheckDepositService.list(InboundCheckDepositListParams.builder().build())
        println(inboundCheckDepositList)
        inboundCheckDepositList.data().forEach { it.validate() }
    }

    @Test
    fun callDecline() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundCheckDepositService = client.inboundCheckDeposits()
        val inboundCheckDeposit =
            inboundCheckDepositService.decline(
                InboundCheckDepositDeclineParams.builder()
                    .inboundCheckDepositId("inbound_check_deposit_id")
                    .build()
            )
        println(inboundCheckDeposit)
        inboundCheckDeposit.validate()
    }
}
