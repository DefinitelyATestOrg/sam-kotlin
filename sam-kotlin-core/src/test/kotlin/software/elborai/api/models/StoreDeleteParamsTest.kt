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
import software.elborai.api.models.StoreDeleteParams

class StoreDeleteParamsTest {

    @Test
    fun createStoreDeleteParams() {
      StoreDeleteParams.builder()
          .orderId(123L)
          .build()
    }

    @Test
    fun getPathParam() {
      val params = StoreDeleteParams.builder()
          .orderId(123L)
          .build()
      assertThat(params).isNotNull
      // path param "orderId"
      assertThat(params.getPathParam(0)).isEqualTo("123")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
