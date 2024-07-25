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
import software.elborai.api.models.SimulationCardSettlementParams
import software.elborai.api.models.SimulationCardSettlementParams.SimulationCardSettlementBody

class SimulationCardSettlementParamsTest {

    @Test
    fun createSimulationCardSettlementParams() {
      SimulationCardSettlementParams.builder()
          .cardId("card_id")
          .pendingTransactionId("pending_transaction_id")
          .amount(123L)
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationCardSettlementParams.builder()
          .cardId("card_id")
          .pendingTransactionId("pending_transaction_id")
          .amount(123L)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardId()).isEqualTo("card_id")
      assertThat(body.pendingTransactionId()).isEqualTo("pending_transaction_id")
      assertThat(body.amount()).isEqualTo(123L)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationCardSettlementParams.builder()
          .cardId("card_id")
          .pendingTransactionId("pending_transaction_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.cardId()).isEqualTo("card_id")
      assertThat(body.pendingTransactionId()).isEqualTo("pending_transaction_id")
    }
}
