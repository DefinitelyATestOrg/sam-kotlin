// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.PendingTransactionListParams

@ExtendWith(TestServerExtension::class)
class PendingTransactionServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val pendingTransactionService = client.pendingTransactions()
        val pendingTransaction =
            pendingTransactionService.retrieve(
                PendingTransactionRetrieveParams.builder().pendingTransactionId("string").build()
            )
        println(pendingTransaction)
        pendingTransaction.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val pendingTransactionService = client.pendingTransactions()
        val pendingTransactionList =
            pendingTransactionService.list(PendingTransactionListParams.builder().build())
        println(pendingTransactionList)
        pendingTransactionList.data().forEach { it.validate() }
    }
}
