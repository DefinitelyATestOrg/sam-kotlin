// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

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
import software.elborai.api.services.blocking.simulations.RealTimePaymentsTransferService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class RealTimePaymentsTransferServiceTest {

    @Test
    fun callComplete() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsTransferService = client.simulations().realTimePaymentsTransfers()
      val realTimePaymentsTransfer = realTimePaymentsTransferService.complete(SimulationRealTimePaymentsTransferCompleteParams.builder()
          .realTimePaymentsTransferId("real_time_payments_transfer_id")
          .rejection(SimulationRealTimePaymentsTransferCompleteParams.Rejection.builder()
              .rejectReasonCode(SimulationRealTimePaymentsTransferCompleteParams.Rejection.RejectReasonCode.ACCOUNT_CLOSED)
              .build())
          .build())
      println(realTimePaymentsTransfer)
      realTimePaymentsTransfer.validate()
    }

    @Test
    fun callCreateInbound() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsTransferService = client.simulations().realTimePaymentsTransfers()
      val inboundRealTimePaymentsTransferSimulationResult = realTimePaymentsTransferService.createInbound(SimulationRealTimePaymentsTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .debtorAccountNumber("x")
          .debtorName("x")
          .debtorRoutingNumber("xxxxxxxxx")
          .remittanceInformation("x")
          .requestForPaymentId("request_for_payment_id")
          .build())
      println(inboundRealTimePaymentsTransferSimulationResult)
      inboundRealTimePaymentsTransferSimulationResult.validate()
    }
}
