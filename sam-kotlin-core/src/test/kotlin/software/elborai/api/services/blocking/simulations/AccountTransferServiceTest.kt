// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class AccountTransferServiceTest {

    @Disabled("Prism tests are broken")
    @Test
    fun callComplete() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountTransferService = client.simulations().accountTransfers()
        val accountTransfer =
            accountTransferService.complete(
                SimulationAccountTransferCompleteParams.builder()
                    .accountTransferId("string")
                    .build()
            )
        println(accountTransfer)
        accountTransfer.validate()
    }
}
