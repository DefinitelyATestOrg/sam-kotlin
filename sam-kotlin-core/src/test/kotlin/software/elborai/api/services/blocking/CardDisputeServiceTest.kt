// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.CardDisputeListParams

@ExtendWith(TestServerExtension::class)
class CardDisputeServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardDisputeService = client.cardDisputes()
        val cardDispute =
            cardDisputeService.create(
                CardDisputeCreateParams.builder()
                    .disputedTransactionId("string")
                    .explanation("x")
                    .build()
            )
        println(cardDispute)
        cardDispute.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardDisputeService = client.cardDisputes()
        val cardDispute =
            cardDisputeService.retrieve(
                CardDisputeRetrieveParams.builder().cardDisputeId("string").build()
            )
        println(cardDispute)
        cardDispute.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardDisputeService = client.cardDisputes()
        val cardDisputeList = cardDisputeService.list(CardDisputeListParams.builder().build())
        println(cardDisputeList)
        cardDisputeList.data().forEach { it.validate() }
    }
}
