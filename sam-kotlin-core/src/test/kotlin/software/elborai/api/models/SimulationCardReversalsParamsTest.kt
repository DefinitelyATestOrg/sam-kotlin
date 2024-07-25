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
import software.elborai.api.models.SimulationCardReversalsParams
import software.elborai.api.models.SimulationCardReversalsParams.SimulationCardReversalsBody

class SimulationCardReversalsParamsTest {

    @Test
    fun createSimulationCardReversalsParams() {
      SimulationCardReversalsParams.builder()
          .cardPaymentId("card_payment_id")
          .amount(123L)
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationCardReversalsParams.builder()
          .cardPaymentId("card_payment_id")
          .amount(123L)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardPaymentId()).isEqualTo("card_payment_id")
      assertThat(body.amount()).isEqualTo(123L)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationCardReversalsParams.builder()
          .cardPaymentId("card_payment_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardPaymentId()).isEqualTo("card_payment_id")
    }
}
