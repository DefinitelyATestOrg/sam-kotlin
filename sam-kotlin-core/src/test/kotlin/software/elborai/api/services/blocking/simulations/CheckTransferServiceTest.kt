// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class CheckTransferServiceTest {

    @Disabled("Prism incorrectly returns an invalid JSON error")
    @Test
    fun callMail() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkTransferService = client.simulations().checkTransfers()
        val checkTransfer =
            checkTransferService.mail(
                SimulationCheckTransferMailParams.builder()
                    .checkTransferId("check_transfer_id")
                    .build()
            )
        println(checkTransfer)
        checkTransfer.validate()
    }
}
