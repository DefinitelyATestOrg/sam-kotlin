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
import software.elborai.api.models.Group

class GroupTest {

    @Test
    fun createGroup() {
      val group = Group.builder()
          .id("id")
          .achDebitStatus(Group.AchDebitStatus.DISABLED)
          .activationStatus(Group.ActivationStatus.UNACTIVATED)
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .type(Group.Type.GROUP)
          .build()
      assertThat(group).isNotNull
      assertThat(group.id()).isEqualTo("id")
      assertThat(group.achDebitStatus()).isEqualTo(Group.AchDebitStatus.DISABLED)
      assertThat(group.activationStatus()).isEqualTo(Group.ActivationStatus.UNACTIVATED)
      assertThat(group.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(group.type()).isEqualTo(Group.Type.GROUP)
    }
}
