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
import software.elborai.api.models.SupplementalDocument

class SupplementalDocumentTest {

    @Test
    fun createSupplementalDocument() {
      val supplementalDocument = SupplementalDocument.builder()
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .fileId("file_id")
          .idempotencyKey("idempotency_key")
          .type(SupplementalDocument.Type.ENTITY_SUPPLEMENTAL_DOCUMENT)
          .build()
      assertThat(supplementalDocument).isNotNull
      assertThat(supplementalDocument.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(supplementalDocument.fileId()).isEqualTo("file_id")
      assertThat(supplementalDocument.idempotencyKey()).isEqualTo("idempotency_key")
      assertThat(supplementalDocument.type()).isEqualTo(SupplementalDocument.Type.ENTITY_SUPPLEMENTAL_DOCUMENT)
    }
}
