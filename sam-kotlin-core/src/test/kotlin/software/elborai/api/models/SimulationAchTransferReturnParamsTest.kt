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
import software.elborai.api.models.SimulationAchTransferReturnParams
import software.elborai.api.models.SimulationAchTransferReturnParams.SimulationAchTransferReturnBody

class SimulationAchTransferReturnParamsTest {

    @Test
    fun createSimulationAchTransferReturnParams() {
      SimulationAchTransferReturnParams.builder()
          .achTransferId("ach_transfer_id")
          .reason(SimulationAchTransferReturnParams.Reason.INSUFFICIENT_FUND)
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationAchTransferReturnParams.builder()
          .achTransferId("ach_transfer_id")
          .reason(SimulationAchTransferReturnParams.Reason.INSUFFICIENT_FUND)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.reason()).isEqualTo(SimulationAchTransferReturnParams.Reason.INSUFFICIENT_FUND)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationAchTransferReturnParams.builder()
          .achTransferId("ach_transfer_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = SimulationAchTransferReturnParams.builder()
          .achTransferId("ach_transfer_id")
          .build()
      assertThat(params).isNotNull
      // path param "achTransferId"
      assertThat(params.getPathParam(0)).isEqualTo("ach_transfer_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
