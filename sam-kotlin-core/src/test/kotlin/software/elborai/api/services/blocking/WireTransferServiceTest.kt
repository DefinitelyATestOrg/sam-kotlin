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
import software.elborai.api.services.blocking.WireTransferService
import software.elborai.api.models.WireTransferListPage
import software.elborai.api.models.WireTransferListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class WireTransferServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransfer = wireTransferService.create(WireTransferCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .beneficiaryName("x")
          .messageToRecipient("x")
          .accountNumber("x")
          .beneficiaryAddressLine1("x")
          .beneficiaryAddressLine2("x")
          .beneficiaryAddressLine3("x")
          .externalAccountId("external_account_id")
          .originatorAddressLine1("x")
          .originatorAddressLine2("x")
          .originatorAddressLine3("x")
          .originatorName("x")
          .requireApproval(true)
          .routingNumber("xxxxxxxxx")
          .build())
      println(wireTransfer)
      wireTransfer.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransfer = wireTransferService.retrieve(WireTransferRetrieveParams.builder()
          .wireTransferId("wire_transfer_id")
          .build())
      println(wireTransfer)
      wireTransfer.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransferList = wireTransferService.list(WireTransferListParams.builder().build())
      println(wireTransferList)
      wireTransferList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callApprove() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransfer = wireTransferService.approve(WireTransferApproveParams.builder()
          .wireTransferId("wire_transfer_id")
          .build())
      println(wireTransfer)
      wireTransfer.validate()
    }

    @Test
    fun callCancel() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransfer = wireTransferService.cancel(WireTransferCancelParams.builder()
          .wireTransferId("wire_transfer_id")
          .build())
      println(wireTransfer)
      wireTransfer.validate()
    }

    @Disabled("Prism tests are broken")
    @Test
    fun callReverse() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransfer = wireTransferService.reverse(WireTransferReverseParams.builder()
          .wireTransferId("wire_transfer_id")
          .build())
      println(wireTransfer)
      wireTransfer.validate()
    }

    @Disabled("Prism tests are broken")
    @Test
    fun callSubmit() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.wireTransfers()
      val wireTransfer = wireTransferService.submit(WireTransferSubmitParams.builder()
          .wireTransferId("wire_transfer_id")
          .build())
      println(wireTransfer)
      wireTransfer.validate()
    }
}
