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
import software.elborai.api.models.BookkeepingAccount

class BookkeepingAccountTest {

    @Test
    fun createBookkeepingAccount() {
      val bookkeepingAccount = BookkeepingAccount.builder()
          .id("id")
          .accountId("account_id")
          .complianceCategory(BookkeepingAccount.ComplianceCategory.COMMINGLED_CASH)
          .entityId("entity_id")
          .idempotencyKey("idempotency_key")
          .name("name")
          .type(BookkeepingAccount.Type.BOOKKEEPING_ACCOUNT)
          .build()
      assertThat(bookkeepingAccount).isNotNull
      assertThat(bookkeepingAccount.id()).isEqualTo("id")
      assertThat(bookkeepingAccount.accountId()).isEqualTo("account_id")
      assertThat(bookkeepingAccount.complianceCategory()).isEqualTo(BookkeepingAccount.ComplianceCategory.COMMINGLED_CASH)
      assertThat(bookkeepingAccount.entityId()).isEqualTo("entity_id")
      assertThat(bookkeepingAccount.idempotencyKey()).isEqualTo("idempotency_key")
      assertThat(bookkeepingAccount.name()).isEqualTo("name")
      assertThat(bookkeepingAccount.type()).isEqualTo(BookkeepingAccount.Type.BOOKKEEPING_ACCOUNT)
    }
}
