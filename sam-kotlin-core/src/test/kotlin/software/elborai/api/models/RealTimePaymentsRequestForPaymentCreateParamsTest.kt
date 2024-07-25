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
import software.elborai.api.models.RealTimePaymentsRequestForPaymentCreateParams
import software.elborai.api.models.RealTimePaymentsRequestForPaymentCreateParams.RealTimePaymentsRequestForPaymentCreateBody

class RealTimePaymentsRequestForPaymentCreateParamsTest {

    @Test
    fun createRealTimePaymentsRequestForPaymentCreateParams() {
      RealTimePaymentsRequestForPaymentCreateParams.builder()
          .amount(123L)
          .debtor(RealTimePaymentsRequestForPaymentCreateParams.Debtor.builder()
              .address(RealTimePaymentsRequestForPaymentCreateParams.Debtor.Address.builder()
                  .country("x")
                  .city("x")
                  .postCode("x")
                  .streetName("x")
                  .build())
              .name("x")
              .build())
          .destinationAccountNumberId("destination_account_number_id")
          .expiresAt(LocalDate.parse("2019-12-27"))
          .remittanceInformation("x")
          .sourceAccountNumber("x")
          .sourceRoutingNumber("xxxxxxxxx")
          .build()
    }

    @Test
    fun getBody() {
      val params = RealTimePaymentsRequestForPaymentCreateParams.builder()
          .amount(123L)
          .debtor(RealTimePaymentsRequestForPaymentCreateParams.Debtor.builder()
              .address(RealTimePaymentsRequestForPaymentCreateParams.Debtor.Address.builder()
                  .country("x")
                  .city("x")
                  .postCode("x")
                  .streetName("x")
                  .build())
              .name("x")
              .build())
          .destinationAccountNumberId("destination_account_number_id")
          .expiresAt(LocalDate.parse("2019-12-27"))
          .remittanceInformation("x")
          .sourceAccountNumber("x")
          .sourceRoutingNumber("xxxxxxxxx")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.debtor()).isEqualTo(RealTimePaymentsRequestForPaymentCreateParams.Debtor.builder()
          .address(RealTimePaymentsRequestForPaymentCreateParams.Debtor.Address.builder()
              .country("x")
              .city("x")
              .postCode("x")
              .streetName("x")
              .build())
          .name("x")
          .build())
      assertThat(body.destinationAccountNumberId()).isEqualTo("destination_account_number_id")
      assertThat(body.expiresAt()).isEqualTo(LocalDate.parse("2019-12-27"))
      assertThat(body.remittanceInformation()).isEqualTo("x")
      assertThat(body.sourceAccountNumber()).isEqualTo("x")
      assertThat(body.sourceRoutingNumber()).isEqualTo("xxxxxxxxx")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = RealTimePaymentsRequestForPaymentCreateParams.builder()
          .amount(123L)
          .debtor(RealTimePaymentsRequestForPaymentCreateParams.Debtor.builder()
              .address(RealTimePaymentsRequestForPaymentCreateParams.Debtor.Address.builder()
                  .country("x")
                  .build())
              .name("x")
              .build())
          .destinationAccountNumberId("destination_account_number_id")
          .expiresAt(LocalDate.parse("2019-12-27"))
          .remittanceInformation("x")
          .sourceAccountNumber("x")
          .sourceRoutingNumber("xxxxxxxxx")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.debtor()).isEqualTo(RealTimePaymentsRequestForPaymentCreateParams.Debtor.builder()
          .address(RealTimePaymentsRequestForPaymentCreateParams.Debtor.Address.builder()
              .country("x")
              .build())
          .name("x")
          .build())
      assertThat(body.destinationAccountNumberId()).isEqualTo("destination_account_number_id")
      assertThat(body.expiresAt()).isEqualTo(LocalDate.parse("2019-12-27"))
      assertThat(body.remittanceInformation()).isEqualTo("x")
      assertThat(body.sourceAccountNumber()).isEqualTo("x")
      assertThat(body.sourceRoutingNumber()).isEqualTo("xxxxxxxxx")
    }
}
