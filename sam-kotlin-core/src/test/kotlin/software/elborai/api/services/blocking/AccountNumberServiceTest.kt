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
import software.elborai.api.services.blocking.AccountNumberService
import software.elborai.api.models.AccountNumberListPage
import software.elborai.api.models.AccountNumberListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class AccountNumberServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountNumberService = client.accountNumbers()
      val accountNumber = accountNumberService.create(AccountNumberCreateParams.builder()
          .accountId("account_id")
          .name("x")
          .inboundAch(AccountNumberCreateParams.InboundAch.builder()
              .debitStatus(AccountNumberCreateParams.InboundAch.DebitStatus.ALLOWED)
              .build())
          .inboundChecks(AccountNumberCreateParams.InboundChecks.builder()
              .status(AccountNumberCreateParams.InboundChecks.Status.ALLOWED)
              .build())
          .build())
      println(accountNumber)
      accountNumber.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountNumberService = client.accountNumbers()
      val accountNumber = accountNumberService.retrieve(AccountNumberRetrieveParams.builder()
          .accountNumberId("account_number_id")
          .build())
      println(accountNumber)
      accountNumber.validate()
    }

    @Test
    fun callUpdate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountNumberService = client.accountNumbers()
      val accountNumber = accountNumberService.update(AccountNumberUpdateParams.builder()
          .accountNumberId("account_number_id")
          .inboundAch(AccountNumberUpdateParams.InboundAch.builder()
              .debitStatus(AccountNumberUpdateParams.InboundAch.DebitStatus.ALLOWED)
              .build())
          .inboundChecks(AccountNumberUpdateParams.InboundChecks.builder()
              .status(AccountNumberUpdateParams.InboundChecks.Status.ALLOWED)
              .build())
          .name("x")
          .status(AccountNumberUpdateParams.Status.ACTIVE)
          .build())
      println(accountNumber)
      accountNumber.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountNumberService = client.accountNumbers()
      val accountNumberList = accountNumberService.list(AccountNumberListParams.builder().build())
      println(accountNumberList)
      accountNumberList.data().forEach {
          it.validate()
      }
    }
}
