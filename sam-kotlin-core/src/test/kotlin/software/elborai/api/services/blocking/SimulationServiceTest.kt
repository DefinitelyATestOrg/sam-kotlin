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
import software.elborai.api.services.blocking.SimulationService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class SimulationServiceTest {

    @Test
    fun callCardAuthorizationExpirations() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val simulationService = client.simulations()
      val cardPayment = simulationService.cardAuthorizationExpirations(SimulationCardAuthorizationExpirationsParams.builder()
          .cardPaymentId("card_payment_id")
          .build())
      println(cardPayment)
      cardPayment.validate()
    }

    @Test
    fun callCardFuelConfirmations() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val simulationService = client.simulations()
      val cardPayment = simulationService.cardFuelConfirmations(SimulationCardFuelConfirmationsParams.builder()
          .amount(123L)
          .cardPaymentId("card_payment_id")
          .build())
      println(cardPayment)
      cardPayment.validate()
    }

    @Test
    fun callCardIncrements() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val simulationService = client.simulations()
      val cardPayment = simulationService.cardIncrements(SimulationCardIncrementsParams.builder()
          .amount(123L)
          .cardPaymentId("card_payment_id")
          .eventSubscriptionId("event_subscription_id")
          .build())
      println(cardPayment)
      cardPayment.validate()
    }

    @Test
    fun callCardReversals() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val simulationService = client.simulations()
      val cardPayment = simulationService.cardReversals(SimulationCardReversalsParams.builder()
          .cardPaymentId("card_payment_id")
          .amount(123L)
          .build())
      println(cardPayment)
      cardPayment.validate()
    }
}
