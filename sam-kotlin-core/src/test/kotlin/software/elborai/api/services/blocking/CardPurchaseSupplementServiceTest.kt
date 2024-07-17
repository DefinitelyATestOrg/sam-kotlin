// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.CardPurchaseSupplementListParams

@ExtendWith(TestServerExtension::class)
class CardPurchaseSupplementServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardPurchaseSupplementService = client.cardPurchaseSupplements()
        val cardPurchaseSupplement =
            cardPurchaseSupplementService.retrieve(
                CardPurchaseSupplementRetrieveParams.builder()
                    .cardPurchaseSupplementId("card_purchase_supplement_id")
                    .build()
            )
        println(cardPurchaseSupplement)
        cardPurchaseSupplement.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val cardPurchaseSupplementService = client.cardPurchaseSupplements()
        val cardPurchaseSupplementList =
            cardPurchaseSupplementService.list(CardPurchaseSupplementListParams.builder().build())
        println(cardPurchaseSupplementList)
        cardPurchaseSupplementList.data().forEach { it.validate() }
    }
}
