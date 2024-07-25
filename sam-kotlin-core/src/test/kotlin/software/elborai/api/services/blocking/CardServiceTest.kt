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
import software.elborai.api.services.blocking.CardService
import software.elborai.api.models.CardListPage
import software.elborai.api.models.CardListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class CardServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardService = client.cards()
      val card = cardService.create(CardCreateParams.builder()
          .accountId("account_id")
          .billingAddress(CardCreateParams.BillingAddress.builder()
              .city("x")
              .line1("x")
              .postalCode("x")
              .state("x")
              .line2("x")
              .build())
          .description("x")
          .digitalWallet(CardCreateParams.DigitalWallet.builder()
              .digitalCardProfileId("digital_card_profile_id")
              .email("x")
              .phone("x")
              .build())
          .entityId("entity_id")
          .build())
      println(card)
      card.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardService = client.cards()
      val card = cardService.retrieve(CardRetrieveParams.builder()
          .cardId("card_id")
          .build())
      println(card)
      card.validate()
    }

    @Test
    fun callUpdate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardService = client.cards()
      val card = cardService.update(CardUpdateParams.builder()
          .cardId("card_id")
          .billingAddress(CardUpdateParams.BillingAddress.builder()
              .city("x")
              .line1("x")
              .postalCode("x")
              .state("x")
              .line2("x")
              .build())
          .description("x")
          .digitalWallet(CardUpdateParams.DigitalWallet.builder()
              .digitalCardProfileId("digital_card_profile_id")
              .email("x")
              .phone("x")
              .build())
          .entityId("entity_id")
          .status(CardUpdateParams.Status.ACTIVE)
          .build())
      println(card)
      card.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardService = client.cards()
      val cardList = cardService.list(CardListParams.builder().build())
      println(cardList)
      cardList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callRetrieveSensitiveDetails() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val cardService = client.cards()
      val cardDetails = cardService.retrieveSensitiveDetails(CardRetrieveSensitiveDetailsParams.builder()
          .cardId("card_id")
          .build())
      println(cardDetails)
      cardDetails.validate()
    }
}
