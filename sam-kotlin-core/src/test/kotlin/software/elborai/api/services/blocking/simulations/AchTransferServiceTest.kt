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
import software.elborai.api.services.blocking.simulations.AchTransferService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class AchTransferServiceTest {

    @Test
    fun callCreateInbound() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val achTransferService = client.simulations().achTransfers()
      val inboundAchTransfer = achTransferService.createInbound(SimulationAchTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .companyDescriptiveDate("x")
          .companyDiscretionaryData("x")
          .companyEntryDescription("x")
          .companyId("x")
          .companyName("x")
          .receiverIdNumber("x")
          .receiverName("x")
          .resolveAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .build())
      println(inboundAchTransfer)
      inboundAchTransfer.validate()
    }

    @Test
    fun callNotificationOfChange() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val achTransferService = client.simulations().achTransfers()
      val achTransfer = achTransferService.notificationOfChange(SimulationAchTransferNotificationOfChangeParams.builder()
          .achTransferId("ach_transfer_id")
          .changeCode(SimulationAchTransferNotificationOfChangeParams.ChangeCode.INCORRECT_ACCOUNT_NUMBER)
          .correctedData("x")
          .build())
      println(achTransfer)
      achTransfer.validate()
    }

    @Disabled("Prism incorrectly returns an invalid JSON error")
    @Test
    fun callReturn() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val achTransferService = client.simulations().achTransfers()
      val achTransfer = achTransferService.return_(SimulationAchTransferReturnParams.builder()
          .achTransferId("ach_transfer_id")
          .reason(SimulationAchTransferReturnParams.Reason.INSUFFICIENT_FUND)
          .build())
      println(achTransfer)
      achTransfer.validate()
    }

    @Disabled("Prism incorrectly returns an invalid JSON error")
    @Test
    fun callSubmit() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val achTransferService = client.simulations().achTransfers()
      val achTransfer = achTransferService.submit(SimulationAchTransferSubmitParams.builder()
          .achTransferId("ach_transfer_id")
          .build())
      println(achTransfer)
      achTransfer.validate()
    }
}
