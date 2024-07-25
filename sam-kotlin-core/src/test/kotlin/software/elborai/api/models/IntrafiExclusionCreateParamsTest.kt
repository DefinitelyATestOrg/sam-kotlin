// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import software.elborai.api.core.ContentTypes
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.MultipartFormValue
import software.elborai.api.models.*
import software.elborai.api.models.IntrafiExclusionCreateParams
import software.elborai.api.models.IntrafiExclusionCreateParams.IntrafiExclusionCreateBody

class IntrafiExclusionCreateParamsTest {

    @Test
    fun createIntrafiExclusionCreateParams() {
      IntrafiExclusionCreateParams.builder()
          .bankName("x")
          .entityId("entity_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = IntrafiExclusionCreateParams.builder()
          .bankName("x")
          .entityId("entity_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.bankName()).isEqualTo("x")
      assertThat(body.entityId()).isEqualTo("entity_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = IntrafiExclusionCreateParams.builder()
          .bankName("x")
          .entityId("entity_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.bankName()).isEqualTo("x")
      assertThat(body.entityId()).isEqualTo("entity_id")
    }
}
