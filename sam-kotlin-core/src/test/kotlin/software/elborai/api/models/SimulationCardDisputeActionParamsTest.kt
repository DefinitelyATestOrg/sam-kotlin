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
import software.elborai.api.models.SimulationCardDisputeActionParams
import software.elborai.api.models.SimulationCardDisputeActionParams.SimulationCardDisputeActionBody

class SimulationCardDisputeActionParamsTest {

    @Test
    fun createSimulationCardDisputeActionParams() {
      SimulationCardDisputeActionParams.builder()
          .cardDisputeId("card_dispute_id")
          .status(SimulationCardDisputeActionParams.Status.ACCEPTED)
          .explanation("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationCardDisputeActionParams.builder()
          .cardDisputeId("card_dispute_id")
          .status(SimulationCardDisputeActionParams.Status.ACCEPTED)
          .explanation("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.status()).isEqualTo(SimulationCardDisputeActionParams.Status.ACCEPTED)
      assertThat(body.explanation()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationCardDisputeActionParams.builder()
          .cardDisputeId("card_dispute_id")
          .status(SimulationCardDisputeActionParams.Status.ACCEPTED)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.status()).isEqualTo(SimulationCardDisputeActionParams.Status.ACCEPTED)
    }

    @Test
    fun getPathParam() {
      val params = SimulationCardDisputeActionParams.builder()
          .cardDisputeId("card_dispute_id")
          .status(SimulationCardDisputeActionParams.Status.ACCEPTED)
          .build()
      assertThat(params).isNotNull
      // path param "cardDisputeId"
      assertThat(params.getPathParam(0)).isEqualTo("card_dispute_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
