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
import software.elborai.api.models.LockboxList

class LockboxListTest {

    @Test
    fun createLockboxList() {
      val lockboxList = LockboxList.builder()
          .data(listOf(Lockbox.builder()
              .id("id")
              .accountId("account_id")
              .address(Lockbox.Address.builder()
                  .city("city")
                  .line1("line1")
                  .line2("line2")
                  .postalCode("postal_code")
                  .state("state")
                  .build())
              .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .description("description")
              .idempotencyKey("idempotency_key")
              .status(Lockbox.Status.ACTIVE)
              .type(Lockbox.Type.LOCKBOX)
              .build()))
          .nextCursor("next_cursor")
          .build()
      assertThat(lockboxList).isNotNull
      assertThat(lockboxList.data()).containsExactly(Lockbox.builder()
          .id("id")
          .accountId("account_id")
          .address(Lockbox.Address.builder()
              .city("city")
              .line1("line1")
              .line2("line2")
              .postalCode("postal_code")
              .state("state")
              .build())
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .description("description")
          .idempotencyKey("idempotency_key")
          .status(Lockbox.Status.ACTIVE)
          .type(Lockbox.Type.LOCKBOX)
          .build())
      assertThat(lockboxList.nextCursor()).isEqualTo("next_cursor")
    }
}
