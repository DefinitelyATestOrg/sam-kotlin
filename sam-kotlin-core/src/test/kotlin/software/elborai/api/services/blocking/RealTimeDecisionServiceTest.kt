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
import software.elborai.api.services.blocking.RealTimeDecisionService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class RealTimeDecisionServiceTest {

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimeDecisionService = client.realTimeDecisions()
      val realTimeDecision = realTimeDecisionService.retrieve(RealTimeDecisionRetrieveParams.builder()
          .realTimeDecisionId("real_time_decision_id")
          .build())
      println(realTimeDecision)
      realTimeDecision.validate()
    }

    @Test
    fun callAction() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimeDecisionService = client.realTimeDecisions()
      val realTimeDecision = realTimeDecisionService.action(RealTimeDecisionActionParams.builder()
          .realTimeDecisionId("real_time_decision_id")
          .cardAuthorization(RealTimeDecisionActionParams.CardAuthorization.builder()
              .decision(RealTimeDecisionActionParams.CardAuthorization.Decision.APPROVE)
              .build())
          .digitalWalletAuthentication(RealTimeDecisionActionParams.DigitalWalletAuthentication.builder()
              .result(RealTimeDecisionActionParams.DigitalWalletAuthentication.Result.SUCCESS)
              .build())
          .digitalWalletToken(RealTimeDecisionActionParams.DigitalWalletToken.builder()
              .approval(RealTimeDecisionActionParams.DigitalWalletToken.Approval.builder()
                  .email("x")
                  .phone("x")
                  .build())
              .decline(RealTimeDecisionActionParams.DigitalWalletToken.Decline.builder()
                  .reason("x")
                  .build())
              .build())
          .build())
      println(realTimeDecision)
      realTimeDecision.validate()
    }
}
