// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class InboundFundsHoldServiceTest {

    @Test
    fun callRelease() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundFundsHoldService = client.simulations().inboundFundsHolds()
        val inboundFundsHoldReleaseResponse =
            inboundFundsHoldService.release(
                SimulationInboundFundsHoldReleaseParams.builder()
                    .inboundFundsHoldId("inbound_funds_hold_id")
                    .build()
            )
        println(inboundFundsHoldReleaseResponse)
        inboundFundsHoldReleaseResponse.validate()
    }
}
