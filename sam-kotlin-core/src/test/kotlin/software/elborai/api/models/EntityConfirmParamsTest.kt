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
import software.elborai.api.models.EntityConfirmParams
import software.elborai.api.models.EntityConfirmParams.EntityConfirmBody

class EntityConfirmParamsTest {

    @Test
    fun createEntityConfirmParams() {
      EntityConfirmParams.builder()
          .entityId("entity_id")
          .confirmedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .build()
    }

    @Test
    fun getBody() {
      val params = EntityConfirmParams.builder()
          .entityId("entity_id")
          .confirmedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.confirmedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = EntityConfirmParams.builder()
          .entityId("entity_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = EntityConfirmParams.builder()
          .entityId("entity_id")
          .build()
      assertThat(params).isNotNull
      // path param "entityId"
      assertThat(params.getPathParam(0)).isEqualTo("entity_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
