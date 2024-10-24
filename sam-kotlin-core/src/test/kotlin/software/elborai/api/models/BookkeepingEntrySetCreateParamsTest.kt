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
import software.elborai.api.models.BookkeepingEntrySetCreateParams
import software.elborai.api.models.BookkeepingEntrySetCreateParams.BookkeepingEntrySetCreateBody

class BookkeepingEntrySetCreateParamsTest {

    @Test
    fun createBookkeepingEntrySetCreateParams() {
      BookkeepingEntrySetCreateParams.builder()
          .entries(listOf(BookkeepingEntrySetCreateParams.Entry.builder()
              .accountId("account_id")
              .amount(123L)
              .build()))
          .date(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .transactionId("transaction_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = BookkeepingEntrySetCreateParams.builder()
          .entries(listOf(BookkeepingEntrySetCreateParams.Entry.builder()
              .accountId("account_id")
              .amount(123L)
              .build()))
          .date(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .transactionId("transaction_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.entries()).isEqualTo(listOf(BookkeepingEntrySetCreateParams.Entry.builder()
          .accountId("account_id")
          .amount(123L)
          .build()))
      assertThat(body.date()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(body.transactionId()).isEqualTo("transaction_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = BookkeepingEntrySetCreateParams.builder()
          .entries(listOf(BookkeepingEntrySetCreateParams.Entry.builder()
              .accountId("account_id")
              .amount(123L)
              .build()))
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.entries()).isEqualTo(listOf(BookkeepingEntrySetCreateParams.Entry.builder()
          .accountId("account_id")
          .amount(123L)
          .build()))
    }
}
