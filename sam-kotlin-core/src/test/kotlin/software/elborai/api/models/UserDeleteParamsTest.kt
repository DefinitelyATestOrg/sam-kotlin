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
import software.elborai.api.models.UserDeleteParams

class UserDeleteParamsTest {

    @Test
    fun createUserDeleteParams() {
      UserDeleteParams.builder()
          .username("username")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = UserDeleteParams.builder()
          .username("username")
          .build()
      assertThat(params).isNotNull
      // path param "username"
      assertThat(params.getPathParam(0)).isEqualTo("username")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
