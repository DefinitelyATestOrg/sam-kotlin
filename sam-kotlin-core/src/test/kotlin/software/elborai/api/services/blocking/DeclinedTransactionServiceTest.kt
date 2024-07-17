// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.DeclinedTransactionListParams

@ExtendWith(TestServerExtension::class)
class DeclinedTransactionServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val declinedTransactionService = client.declinedTransactions()
        val declinedTransaction =
            declinedTransactionService.retrieve(
                DeclinedTransactionRetrieveParams.builder().declinedTransactionId("string").build()
            )
        println(declinedTransaction)
        declinedTransaction.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val declinedTransactionService = client.declinedTransactions()
        val declinedTransactionList =
            declinedTransactionService.list(DeclinedTransactionListParams.builder().build())
        println(declinedTransactionList)
        declinedTransactionList.data().forEach { it.validate() }
    }
}
