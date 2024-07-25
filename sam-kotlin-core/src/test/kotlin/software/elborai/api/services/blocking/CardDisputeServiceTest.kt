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
import software.elborai.api.services.blocking.CardDisputeService
import software.elborai.api.models.CardDisputeListPage
import software.elborai.api.models.CardDisputeListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class CardDisputeServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardDisputeService = client.cardDisputes()
      val cardDispute = cardDisputeService.create(CardDisputeCreateParams.builder()
          .disputedTransactionId("disputed_transaction_id")
          .explanation("x")
          .build())
      println(cardDispute)
      cardDispute.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardDisputeService = client.cardDisputes()
      val cardDispute = cardDisputeService.retrieve(CardDisputeRetrieveParams.builder()
          .cardDisputeId("card_dispute_id")
          .build())
      println(cardDispute)
      cardDispute.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardDisputeService = client.cardDisputes()
      val cardDisputeList = cardDisputeService.list(CardDisputeListParams.builder().build())
      println(cardDisputeList)
      cardDisputeList.data().forEach {
          it.validate()
      }
    }
}
