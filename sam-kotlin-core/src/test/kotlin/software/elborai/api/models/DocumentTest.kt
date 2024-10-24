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
import software.elborai.api.models.Document

class DocumentTest {

    @Test
    fun createDocument() {
      val document = Document.builder()
          .id("id")
          .category(Document.Category.FORM_1099_INT)
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .entityId("entity_id")
          .fileId("file_id")
          .type(Document.Type.DOCUMENT)
          .build()
      assertThat(document).isNotNull
      assertThat(document.id()).isEqualTo("id")
      assertThat(document.category()).isEqualTo(Document.Category.FORM_1099_INT)
      assertThat(document.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(document.entityId()).isEqualTo("entity_id")
      assertThat(document.fileId()).isEqualTo("file_id")
      assertThat(document.type()).isEqualTo(Document.Type.DOCUMENT)
    }
}
