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
import software.elborai.api.models.ReferenceSetUpdateParams
import software.elborai.api.models.ReferenceSetUpdateParams.ReferenceSetUpdateBody

class ReferenceSetUpdateParamsTest {

    @Test
    fun createReferenceSetUpdateParams() {
      ReferenceSetUpdateParams.builder()
          .pathId("string")
          .bodyId("string")
          .agentId("string")
          .createdBy(ReferenceSetUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .name("string")
          .type(ReferenceSetUpdateParams.Type.MANUAL)
          .updatedBy(ReferenceSetUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .build()
    }

    @Test
    fun getBody() {
      val params = ReferenceSetUpdateParams.builder()
          .pathId("string")
          .bodyId("string")
          .agentId("string")
          .createdBy(ReferenceSetUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .name("string")
          .type(ReferenceSetUpdateParams.Type.MANUAL)
          .updatedBy(ReferenceSetUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.bodyId()).isEqualTo("string")
      assertThat(body.agentId()).isEqualTo("string")
      assertThat(body.createdBy()).isEqualTo(ReferenceSetUpdateParams.CreatedBy.builder()
          .id("string")
          .name("string")
          .build())
      assertThat(body.name()).isEqualTo("string")
      assertThat(body.type()).isEqualTo(ReferenceSetUpdateParams.Type.MANUAL)
      assertThat(body.updatedBy()).isEqualTo(ReferenceSetUpdateParams.UpdatedBy.builder()
          .id("string")
          .name("string")
          .build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = ReferenceSetUpdateParams.builder()
          .pathId("string")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = ReferenceSetUpdateParams.builder()
          .pathId("string")
          .build()
      assertThat(params).isNotNull
      // path param "pathId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
