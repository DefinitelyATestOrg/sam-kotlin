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
import software.elborai.api.services.blocking.simulations.WireTransferService
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class WireTransferServiceTest {

    @Test
    fun callCreateInbound() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val wireTransferService = client.simulations().wireTransfers()
      val inboundWireTransfer = wireTransferService.createInbound(SimulationWireTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .beneficiaryAddressLine1("x")
          .beneficiaryAddressLine2("x")
          .beneficiaryAddressLine3("x")
          .beneficiaryName("x")
          .beneficiaryReference("x")
          .originatorAddressLine1("x")
          .originatorAddressLine2("x")
          .originatorAddressLine3("x")
          .originatorName("x")
          .originatorRoutingNumber("x")
          .originatorToBeneficiaryInformationLine1("x")
          .originatorToBeneficiaryInformationLine2("x")
          .originatorToBeneficiaryInformationLine3("x")
          .originatorToBeneficiaryInformationLine4("x")
          .build())
      println(inboundWireTransfer)
      inboundWireTransfer.validate()
    }
}
