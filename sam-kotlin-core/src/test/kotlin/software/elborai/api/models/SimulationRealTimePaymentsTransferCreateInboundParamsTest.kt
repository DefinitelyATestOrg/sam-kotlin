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
import software.elborai.api.models.SimulationRealTimePaymentsTransferCreateInboundParams
import software.elborai.api.models.SimulationRealTimePaymentsTransferCreateInboundParams.SimulationRealTimePaymentsTransferCreateInboundBody

class SimulationRealTimePaymentsTransferCreateInboundParamsTest {

    @Test
    fun createSimulationRealTimePaymentsTransferCreateInboundParams() {
      SimulationRealTimePaymentsTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .debtorAccountNumber("x")
          .debtorName("x")
          .debtorRoutingNumber("xxxxxxxxx")
          .remittanceInformation("x")
          .requestForPaymentId("request_for_payment_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationRealTimePaymentsTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .debtorAccountNumber("x")
          .debtorName("x")
          .debtorRoutingNumber("xxxxxxxxx")
          .remittanceInformation("x")
          .requestForPaymentId("request_for_payment_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountNumberId()).isEqualTo("account_number_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.debtorAccountNumber()).isEqualTo("x")
      assertThat(body.debtorName()).isEqualTo("x")
      assertThat(body.debtorRoutingNumber()).isEqualTo("xxxxxxxxx")
      assertThat(body.remittanceInformation()).isEqualTo("x")
      assertThat(body.requestForPaymentId()).isEqualTo("request_for_payment_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationRealTimePaymentsTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountNumberId()).isEqualTo("account_number_id")
      assertThat(body.amount()).isEqualTo(123L)
    }
}
