// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import software.elborai.api.TestServerExtension
import software.elborai.api.client.IncreaseClient
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.services.blocking.CardPurchaseSupplementService
import software.elborai.api.models.CardPurchaseSupplementListPage
import software.elborai.api.models.CardPurchaseSupplementListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class CardPurchaseSupplementServiceTest {

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardPurchaseSupplementService = client.cardPurchaseSupplements()
      val cardPurchaseSupplement = cardPurchaseSupplementService.retrieve(CardPurchaseSupplementRetrieveParams.builder()
          .cardPurchaseSupplementId("card_purchase_supplement_id")
          .build())
      println(cardPurchaseSupplement)
      cardPurchaseSupplement.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardPurchaseSupplementService = client.cardPurchaseSupplements()
      val cardPurchaseSupplementList = cardPurchaseSupplementService.list(CardPurchaseSupplementListParams.builder().build())
      println(cardPurchaseSupplementList)
      cardPurchaseSupplementList.data().forEach {
          it.validate()
      }
    }
}
