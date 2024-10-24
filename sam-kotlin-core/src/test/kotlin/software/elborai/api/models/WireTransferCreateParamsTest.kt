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
import software.elborai.api.models.WireTransferCreateParams
import software.elborai.api.models.WireTransferCreateParams.WireTransferCreateBody

class WireTransferCreateParamsTest {

    @Test
    fun createWireTransferCreateParams() {
      WireTransferCreateParams.builder()
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
          .build()
    }

    @Test
    fun getBody() {
      val params = WireTransferCreateParams.builder()
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
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.beneficiaryName()).isEqualTo("x")
      assertThat(body.messageToRecipient()).isEqualTo("x")
      assertThat(body.accountNumber()).isEqualTo("x")
      assertThat(body.beneficiaryAddressLine1()).isEqualTo("x")
      assertThat(body.beneficiaryAddressLine2()).isEqualTo("x")
      assertThat(body.beneficiaryAddressLine3()).isEqualTo("x")
      assertThat(body.externalAccountId()).isEqualTo("external_account_id")
      assertThat(body.originatorAddressLine1()).isEqualTo("x")
      assertThat(body.originatorAddressLine2()).isEqualTo("x")
      assertThat(body.originatorAddressLine3()).isEqualTo("x")
      assertThat(body.originatorName()).isEqualTo("x")
      assertThat(body.requireApproval()).isEqualTo(true)
      assertThat(body.routingNumber()).isEqualTo("xxxxxxxxx")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = WireTransferCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .beneficiaryName("x")
          .messageToRecipient("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.beneficiaryName()).isEqualTo("x")
      assertThat(body.messageToRecipient()).isEqualTo("x")
    }
}
