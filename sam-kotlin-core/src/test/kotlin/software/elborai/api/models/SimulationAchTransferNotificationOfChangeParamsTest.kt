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
import software.elborai.api.models.SimulationAchTransferNotificationOfChangeParams
import software.elborai.api.models.SimulationAchTransferNotificationOfChangeParams.SimulationAchTransferNotificationOfChangeBody

class SimulationAchTransferNotificationOfChangeParamsTest {

    @Test
    fun createSimulationAchTransferNotificationOfChangeParams() {
      SimulationAchTransferNotificationOfChangeParams.builder()
          .achTransferId("ach_transfer_id")
          .changeCode(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
          .correctedData("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationAchTransferNotificationOfChangeParams.builder()
          .achTransferId("ach_transfer_id")
          .changeCode(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
          .correctedData("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.changeCode()).isEqualTo(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
      assertThat(body.correctedData()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationAchTransferNotificationOfChangeParams.builder()
          .achTransferId("ach_transfer_id")
          .changeCode(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
          .correctedData("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.changeCode()).isEqualTo(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
      assertThat(body.correctedData()).isEqualTo("x")
    }

    @Test
    fun getPathParam() {
      val params = SimulationAchTransferNotificationOfChangeParams.builder()
          .achTransferId("ach_transfer_id")
          .changeCode(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
          .correctedData("x")
          .build()
      assertThat(params).isNotNull
      // path param "achTransferId"
      assertThat(params.getPathParam(0)).isEqualTo("ach_transfer_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
