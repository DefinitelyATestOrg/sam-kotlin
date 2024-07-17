// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class DigitalWalletTokenRequestServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalWalletTokenRequestService = client.simulations().digitalWalletTokenRequests()
        val digitalWalletTokenRequestCreateResponse =
            digitalWalletTokenRequestService.create(
                SimulationDigitalWalletTokenRequestCreateParams.builder().cardId("string").build()
            )
        println(digitalWalletTokenRequestCreateResponse)
        digitalWalletTokenRequestCreateResponse.validate()
    }
}
