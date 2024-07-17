// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.BookkeepingEntrySetListParams

@ExtendWith(TestServerExtension::class)
class BookkeepingEntrySetServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingEntrySetService = client.bookkeepingEntrySets()
        val bookkeepingEntrySet =
            bookkeepingEntrySetService.create(
                BookkeepingEntrySetCreateParams.builder()
                    .entries(
                        listOf(
                            BookkeepingEntrySetCreateParams.Entry.builder()
                                .accountId("string")
                                .amount(123L)
                                .build()
                        )
                    )
                    .date(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .transactionId("string")
                    .build()
            )
        println(bookkeepingEntrySet)
        bookkeepingEntrySet.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingEntrySetService = client.bookkeepingEntrySets()
        val bookkeepingEntrySet =
            bookkeepingEntrySetService.retrieve(
                BookkeepingEntrySetRetrieveParams.builder().bookkeepingEntrySetId("string").build()
            )
        println(bookkeepingEntrySet)
        bookkeepingEntrySet.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val bookkeepingEntrySetService = client.bookkeepingEntrySets()
        val bookkeepingEntrySetList =
            bookkeepingEntrySetService.list(BookkeepingEntrySetListParams.builder().build())
        println(bookkeepingEntrySetList)
        bookkeepingEntrySetList.data().forEach { it.validate() }
    }
}
