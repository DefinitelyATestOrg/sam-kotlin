// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.BookkeepingAccountListParams

@ExtendWith(TestServerExtension::class)
class BookkeepingAccountServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingAccountService = client.bookkeepingAccounts()
        val bookkeepingAccount =
            bookkeepingAccountService.create(
                BookkeepingAccountCreateParams.builder()
                    .name("x")
                    .accountId("string")
                    .complianceCategory(
                        BookkeepingAccountCreateParams.ComplianceCategory.COMMINGLED_CASH
                    )
                    .entityId("string")
                    .build()
            )
        println(bookkeepingAccount)
        bookkeepingAccount.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingAccountService = client.bookkeepingAccounts()
        val bookkeepingAccount =
            bookkeepingAccountService.update(
                BookkeepingAccountUpdateParams.builder()
                    .bookkeepingAccountId("string")
                    .name("x")
                    .build()
            )
        println(bookkeepingAccount)
        bookkeepingAccount.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingAccountService = client.bookkeepingAccounts()
        val bookkeepingAccountList =
            bookkeepingAccountService.list(BookkeepingAccountListParams.builder().build())
        println(bookkeepingAccountList)
        bookkeepingAccountList.data().forEach { it.validate() }
    }

    @Test
    fun callBalance() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingAccountService = client.bookkeepingAccounts()
        val bookkeepingBalanceLookup =
            bookkeepingAccountService.balance(
                BookkeepingAccountBalanceParams.builder()
                    .bookkeepingAccountId("string")
                    .atTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        println(bookkeepingBalanceLookup)
        bookkeepingBalanceLookup.validate()
    }
}
