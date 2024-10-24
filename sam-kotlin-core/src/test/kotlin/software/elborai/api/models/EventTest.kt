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
import software.elborai.api.models.Event

class EventTest {

    @Test
    fun createEvent() {
      val event = Event.builder()
          .id("id")
          .associatedObjectId("associated_object_id")
          .associatedObjectType("associated_object_type")
          .category(Event.Category.ACCOUNT_CREATED)
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .type(Event.Type.EVENT)
          .build()
      assertThat(event).isNotNull
      assertThat(event.id()).isEqualTo("id")
      assertThat(event.associatedObjectId()).isEqualTo("associated_object_id")
      assertThat(event.associatedObjectType()).isEqualTo("associated_object_type")
      assertThat(event.category()).isEqualTo(Event.Category.ACCOUNT_CREATED)
      assertThat(event.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(event.type()).isEqualTo(Event.Type.EVENT)
    }
}
