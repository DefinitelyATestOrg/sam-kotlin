// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.AccountStatementListParams

@ExtendWith(TestServerExtension::class)
class AccountStatementServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountStatementService = client.accountStatements()
        val accountStatement =
            accountStatementService.retrieve(
                AccountStatementRetrieveParams.builder().accountStatementId("string").build()
            )
        println(accountStatement)
        accountStatement.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountStatementService = client.accountStatements()
        val accountStatementList =
            accountStatementService.list(AccountStatementListParams.builder().build())
        println(accountStatementList)
        accountStatementList.data().forEach { it.validate() }
    }
}
