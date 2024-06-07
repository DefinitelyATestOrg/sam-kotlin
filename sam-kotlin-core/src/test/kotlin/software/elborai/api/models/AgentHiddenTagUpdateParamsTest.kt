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
import software.elborai.api.models.AgentHiddenTagUpdateParams
import software.elborai.api.models.AgentHiddenTagUpdateParams.AgentHiddenTagUpdateBody

class AgentHiddenTagUpdateParamsTest {

    @Test
    fun createAgentHiddenTagUpdateParams() {
      AgentHiddenTagUpdateParams.builder()
          .id("string")
          .body(listOf("string"))
          .build()
    }

    @Test
    fun getBody() {
      val params = AgentHiddenTagUpdateParams.builder()
          .id("string")
          .body(listOf("string"))
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body).isEqualTo(listOf("string"))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = AgentHiddenTagUpdateParams.builder()
          .id("string")
          .body(listOf("string"))
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body).isEqualTo(listOf("string"))
    }

    @Test
    fun getPathParam() {
      val params = AgentHiddenTagUpdateParams.builder()
          .id("string")
          .body(listOf("string"))
          .build()
      assertThat(params).isNotNull
      // path param "id"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
