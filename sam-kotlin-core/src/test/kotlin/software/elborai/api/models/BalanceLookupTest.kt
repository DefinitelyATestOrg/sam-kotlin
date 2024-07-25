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
import software.elborai.api.models.BalanceLookup

class BalanceLookupTest {

    @Test
    fun createBalanceLookup() {
      val balanceLookup = BalanceLookup.builder()
          .accountId("account_id")
          .availableBalance(123L)
          .currentBalance(123L)
          .type(BalanceLookup.Type.BALANCE_LOOKUP)
          .build()
      assertThat(balanceLookup).isNotNull
      assertThat(balanceLookup.accountId()).isEqualTo("account_id")
      assertThat(balanceLookup.availableBalance()).isEqualTo(123L)
      assertThat(balanceLookup.currentBalance()).isEqualTo(123L)
      assertThat(balanceLookup.type()).isEqualTo(BalanceLookup.Type.BALANCE_LOOKUP)
    }
}
