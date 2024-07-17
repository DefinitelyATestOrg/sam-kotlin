// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.intrafi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class BalanceServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val balanceService = client.intrafi().balances()
        val intrafiBalance =
            balanceService.retrieve(
                IntrafiBalanceRetrieveParams.builder().accountId("string").build()
            )
        println(intrafiBalance)
        intrafiBalance.validate()
    }
}
