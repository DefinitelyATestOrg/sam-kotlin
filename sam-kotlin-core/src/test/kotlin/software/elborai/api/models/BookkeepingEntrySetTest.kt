// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.models.BookkeepingEntrySet

class BookkeepingEntrySetTest {

    @Test
    fun createBookkeepingEntrySet() {
      val bookkeepingEntrySet = BookkeepingEntrySet.builder()
          .id("id")
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .date(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .entries(listOf(BookkeepingEntrySet.Entry.builder()
              .id("id")
              .accountId("account_id")
              .amount(123L)
              .build()))
          .idempotencyKey("idempotency_key")
          .transactionId("transaction_id")
          .type(BookkeepingEntrySet.Type.BOOKKEEPING_ENTRY_SET)
          .build()
      assertThat(bookkeepingEntrySet).isNotNull
      assertThat(bookkeepingEntrySet.id()).isEqualTo("id")
      assertThat(bookkeepingEntrySet.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(bookkeepingEntrySet.date()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(bookkeepingEntrySet.entries()).containsExactly(BookkeepingEntrySet.Entry.builder()
          .id("id")
          .accountId("account_id")
          .amount(123L)
          .build())
      assertThat(bookkeepingEntrySet.idempotencyKey()).isEqualTo("idempotency_key")
      assertThat(bookkeepingEntrySet.transactionId()).isEqualTo("transaction_id")
      assertThat(bookkeepingEntrySet.type()).isEqualTo(BookkeepingEntrySet.Type.BOOKKEEPING_ENTRY_SET)
    }
}
