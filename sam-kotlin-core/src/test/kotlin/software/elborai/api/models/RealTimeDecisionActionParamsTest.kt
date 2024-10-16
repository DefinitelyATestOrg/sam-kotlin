// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import software.elborai.api.core.ContentTypes
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.MultipartFormValue
import software.elborai.api.models.*
import software.elborai.api.models.RealTimeDecisionActionParams
import software.elborai.api.models.RealTimeDecisionActionParams.RealTimeDecisionActionBody

class RealTimeDecisionActionParamsTest {

    @Test
    fun createRealTimeDecisionActionParams() {
      RealTimeDecisionActionParams.builder()
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
          .build()
    }

    @Test
    fun getBody() {
      val params = RealTimeDecisionActionParams.builder()
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
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardAuthorization()).isEqualTo(RealTimeDecisionActionParams.CardAuthorization.builder()
          .decision(RealTimeDecisionActionParams.CardAuthorization.Decision.APPROVE)
          .build())
      assertThat(body.digitalWalletAuthentication()).isEqualTo(RealTimeDecisionActionParams.DigitalWalletAuthentication.builder()
          .result(RealTimeDecisionActionParams.DigitalWalletAuthentication.Result.SUCCESS)
          .build())
      assertThat(body.digitalWalletToken()).isEqualTo(RealTimeDecisionActionParams.DigitalWalletToken.builder()
          .approval(RealTimeDecisionActionParams.DigitalWalletToken.Approval.builder()
              .email("x")
              .phone("x")
              .build())
          .decline(RealTimeDecisionActionParams.DigitalWalletToken.Decline.builder()
              .reason("x")
              .build())
          .build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = RealTimeDecisionActionParams.builder()
          .realTimeDecisionId("real_time_decision_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = RealTimeDecisionActionParams.builder()
          .realTimeDecisionId("real_time_decision_id")
          .build()
      assertThat(params).isNotNull
      // path param "realTimeDecisionId"
      assertThat(params.getPathParam(0)).isEqualTo("real_time_decision_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
