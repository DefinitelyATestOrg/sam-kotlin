// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

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
import software.elborai.api.services.blocking.InboundAchTransferService
import software.elborai.api.models.InboundAchTransferListPage
import software.elborai.api.models.InboundAchTransferListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class InboundAchTransferServiceTest {

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val inboundAchTransferService = client.inboundAchTransfers()
      val inboundAchTransfer = inboundAchTransferService.retrieve(InboundAchTransferRetrieveParams.builder()
          .inboundAchTransferId("inbound_ach_transfer_id")
          .build())
      println(inboundAchTransfer)
      inboundAchTransfer.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val inboundAchTransferService = client.inboundAchTransfers()
      val inboundAchTransferList = inboundAchTransferService.list(InboundAchTransferListParams.builder().build())
      println(inboundAchTransferList)
      inboundAchTransferList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callDecline() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val inboundAchTransferService = client.inboundAchTransfers()
      val inboundAchTransfer = inboundAchTransferService.decline(InboundAchTransferDeclineParams.builder()
          .inboundAchTransferId("inbound_ach_transfer_id")
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
      val inboundAchTransferService = client.inboundAchTransfers()
      val inboundAchTransfer = inboundAchTransferService.notificationOfChange(InboundAchTransferNotificationOfChangeParams.builder()
          .inboundAchTransferId("inbound_ach_transfer_id")
          .updatedAccountNumber("x")
          .updatedRoutingNumber("x")
          .build())
      println(inboundAchTransfer)
      inboundAchTransfer.validate()
    }

    @Test
    fun callTransferReturn() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val inboundAchTransferService = client.inboundAchTransfers()
      val inboundAchTransfer = inboundAchTransferService.transferReturn(InboundAchTransferTransferReturnParams.builder()
          .inboundAchTransferId("inbound_ach_transfer_id")
          .reason(InboundAchTransferTransferReturnParams.Reason.INSUFFICIENT_FUNDS)
          .build())
      println(inboundAchTransfer)
      inboundAchTransfer.validate()
    }
}
