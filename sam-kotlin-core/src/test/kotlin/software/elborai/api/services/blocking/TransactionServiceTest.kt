// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.TransactionListParams

@ExtendWith(TestServerExtension::class)
class TransactionServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transactionService = client.transactions()
        val transaction =
            transactionService.retrieve(
                TransactionRetrieveParams.builder().transactionId("transaction_id").build()
            )
        println(transaction)
        transaction.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val transactionService = client.transactions()
        val transactionList = transactionService.list(TransactionListParams.builder().build())
        println(transactionList)
        transactionList.data().forEach { it.validate() }
    }
}
