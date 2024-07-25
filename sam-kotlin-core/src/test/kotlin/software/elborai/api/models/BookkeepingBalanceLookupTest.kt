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
import software.elborai.api.models.BookkeepingBalanceLookup

class BookkeepingBalanceLookupTest {

    @Test
    fun createBookkeepingBalanceLookup() {
      val bookkeepingBalanceLookup = BookkeepingBalanceLookup.builder()
          .balance(123L)
          .bookkeepingAccountId("bookkeeping_account_id")
          .type(BookkeepingBalanceLookup.Type.BOOKKEEPING_BALANCE_LOOKUP)
          .build()
      assertThat(bookkeepingBalanceLookup).isNotNull
      assertThat(bookkeepingBalanceLookup.balance()).isEqualTo(123L)
      assertThat(bookkeepingBalanceLookup.bookkeepingAccountId()).isEqualTo("bookkeeping_account_id")
      assertThat(bookkeepingBalanceLookup.type()).isEqualTo(BookkeepingBalanceLookup.Type.BOOKKEEPING_BALANCE_LOOKUP)
    }
}
