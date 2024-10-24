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
import software.elborai.api.services.blocking.RealTimePaymentsTransferService
import software.elborai.api.models.RealTimePaymentsTransferListPage
import software.elborai.api.models.RealTimePaymentsTransferListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class RealTimePaymentsTransferServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsTransferService = client.realTimePaymentsTransfers()
      val realTimePaymentsTransfer = realTimePaymentsTransferService.create(RealTimePaymentsTransferCreateParams.builder()
          .amount(123L)
          .creditorName("x")
          .remittanceInformation("x")
          .sourceAccountNumberId("source_account_number_id")
          .debtorName("x")
          .destinationAccountNumber("x")
          .destinationRoutingNumber("xxxxxxxxx")
          .externalAccountId("external_account_id")
          .requireApproval(true)
          .ultimateCreditorName("x")
          .ultimateDebtorName("x")
          .build())
      println(realTimePaymentsTransfer)
      realTimePaymentsTransfer.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsTransferService = client.realTimePaymentsTransfers()
      val realTimePaymentsTransfer = realTimePaymentsTransferService.retrieve(RealTimePaymentsTransferRetrieveParams.builder()
          .realTimePaymentsTransferId("real_time_payments_transfer_id")
          .build())
      println(realTimePaymentsTransfer)
      realTimePaymentsTransfer.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsTransferService = client.realTimePaymentsTransfers()
      val realTimePaymentsTransferList = realTimePaymentsTransferService.list(RealTimePaymentsTransferListParams.builder().build())
      println(realTimePaymentsTransferList)
      realTimePaymentsTransferList.data().forEach {
          it.validate()
      }
    }
}
