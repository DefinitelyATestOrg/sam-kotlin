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
import software.elborai.api.models.ApiResponse

class ApiResponseTest {

    @Test
    fun createApiResponse() {
      val apiResponse = ApiResponse.builder()
          .code(123L)
          .message("message")
          .type("type")
          .build()
      assertThat(apiResponse).isNotNull
      assertThat(apiResponse.code()).isEqualTo(123L)
      assertThat(apiResponse.message()).isEqualTo("message")
      assertThat(apiResponse.type()).isEqualTo("type")
    }
}
