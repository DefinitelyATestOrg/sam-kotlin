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
import software.elborai.api.services.blocking.AccountService
import software.elborai.api.models.AccountListPage
import software.elborai.api.models.AccountListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class AccountServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountService = client.accounts()
      val account = accountService.create(AccountCreateParams.builder()
          .name("x")
          .entityId("entity_id")
          .informationalEntityId("informational_entity_id")
          .programId("program_id")
          .build())
      println(account)
      account.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountService = client.accounts()
      val account = accountService.retrieve(AccountRetrieveParams.builder()
          .accountId("account_id")
          .build())
      println(account)
      account.validate()
    }

    @Test
    fun callUpdate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountService = client.accounts()
      val account = accountService.update(AccountUpdateParams.builder()
          .accountId("account_id")
          .name("x")
          .build())
      println(account)
      account.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountService = client.accounts()
      val accountList = accountService.list(AccountListParams.builder().build())
      println(accountList)
      accountList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callBalance() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountService = client.accounts()
      val balanceLookup = accountService.balance(AccountBalanceParams.builder()
          .accountId("account_id")
          .atTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .build())
      println(balanceLookup)
      balanceLookup.validate()
    }

    @Disabled("Prism tests are broken")
    @Test
    fun callClose() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountService = client.accounts()
      val account = accountService.close(AccountCloseParams.builder()
          .accountId("account_id")
          .build())
      println(account)
      account.validate()
    }
}
