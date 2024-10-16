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
import software.elborai.api.models.SimulationWireTransferCreateInboundParams
import software.elborai.api.models.SimulationWireTransferCreateInboundParams.SimulationWireTransferCreateInboundBody

class SimulationWireTransferCreateInboundParamsTest {

    @Test
    fun createSimulationWireTransferCreateInboundParams() {
      SimulationWireTransferCreateInboundParams.builder()
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
          .build()
    }

    @Test
    fun getBody() {
      val params = SimulationWireTransferCreateInboundParams.builder()
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
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountNumberId()).isEqualTo("account_number_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.beneficiaryAddressLine1()).isEqualTo("x")
      assertThat(body.beneficiaryAddressLine2()).isEqualTo("x")
      assertThat(body.beneficiaryAddressLine3()).isEqualTo("x")
      assertThat(body.beneficiaryName()).isEqualTo("x")
      assertThat(body.beneficiaryReference()).isEqualTo("x")
      assertThat(body.originatorAddressLine1()).isEqualTo("x")
      assertThat(body.originatorAddressLine2()).isEqualTo("x")
      assertThat(body.originatorAddressLine3()).isEqualTo("x")
      assertThat(body.originatorName()).isEqualTo("x")
      assertThat(body.originatorRoutingNumber()).isEqualTo("x")
      assertThat(body.originatorToBeneficiaryInformationLine1()).isEqualTo("x")
      assertThat(body.originatorToBeneficiaryInformationLine2()).isEqualTo("x")
      assertThat(body.originatorToBeneficiaryInformationLine3()).isEqualTo("x")
      assertThat(body.originatorToBeneficiaryInformationLine4()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = SimulationWireTransferCreateInboundParams.builder()
          .accountNumberId("account_number_id")
          .amount(123L)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountNumberId()).isEqualTo("account_number_id")
      assertThat(body.amount()).isEqualTo(123L)
    }
}
