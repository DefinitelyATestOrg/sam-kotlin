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
import software.elborai.api.models.SimulationAccountStatementCreateParams
import software.elborai.api.models.SimulationAccountStatementCreateParams.SimulationAccountStatementCreateBody

class SimulationAccountStatementCreateParamsTest {

    @Test
    fun createSimulationAccountStatementCreateParams() {
      SimulationAccountStatementCreateParams.builder()
          .accountId("account_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationAccountStatementCreateParams.builder()
          .accountId("account_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationAccountStatementCreateParams.builder()
          .accountId("account_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
    }
}
