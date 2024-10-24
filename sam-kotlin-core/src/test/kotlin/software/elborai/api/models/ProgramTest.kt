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
import software.elborai.api.models.Program

class ProgramTest {

    @Test
    fun createProgram() {
      val program = Program.builder()
          .id("id")
          .billingAccountId("billing_account_id")
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .defaultDigitalCardProfileId("default_digital_card_profile_id")
          .interestRate("interest_rate")
          .name("name")
          .type(Program.Type.PROGRAM)
          .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .build()
      assertThat(program).isNotNull
      assertThat(program.id()).isEqualTo("id")
      assertThat(program.billingAccountId()).isEqualTo("billing_account_id")
      assertThat(program.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(program.defaultDigitalCardProfileId()).isEqualTo("default_digital_card_profile_id")
      assertThat(program.interestRate()).isEqualTo("interest_rate")
      assertThat(program.name()).isEqualTo("name")
      assertThat(program.type()).isEqualTo(Program.Type.PROGRAM)
      assertThat(program.updatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }
}
