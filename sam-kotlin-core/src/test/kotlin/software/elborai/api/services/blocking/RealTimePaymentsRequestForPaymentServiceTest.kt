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
import software.elborai.api.services.blocking.RealTimePaymentsRequestForPaymentService
import software.elborai.api.models.RealTimePaymentsRequestForPaymentListPage
import software.elborai.api.models.RealTimePaymentsRequestForPaymentListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class RealTimePaymentsRequestForPaymentServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsRequestForPaymentService = client.realTimePaymentsRequestForPayments()
      val realTimePaymentsRequestForPayment = realTimePaymentsRequestForPaymentService.create(RealTimePaymentsRequestForPaymentCreateParams.builder()
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
          .build())
      println(realTimePaymentsRequestForPayment)
      realTimePaymentsRequestForPayment.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsRequestForPaymentService = client.realTimePaymentsRequestForPayments()
      val realTimePaymentsRequestForPayment = realTimePaymentsRequestForPaymentService.retrieve(RealTimePaymentsRequestForPaymentRetrieveParams.builder()
          .requestForPaymentId("request_for_payment_id")
          .build())
      println(realTimePaymentsRequestForPayment)
      realTimePaymentsRequestForPayment.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val realTimePaymentsRequestForPaymentService = client.realTimePaymentsRequestForPayments()
      val realTimePaymentsRequestForPaymentList = realTimePaymentsRequestForPaymentService.list(RealTimePaymentsRequestForPaymentListParams.builder().build())
      println(realTimePaymentsRequestForPaymentList)
      realTimePaymentsRequestForPaymentList.data().forEach {
          it.validate()
      }
    }
}
