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
import software.elborai.api.models.PetCreateParams

class PetCreateParamsTest {

    @Test
    fun createPetCreateParams() {
      PetCreateParams.builder()
          .petId(123L)
          .name("name")
          .status("status")
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = PetCreateParams.builder()
          .petId(123L)
          .name("name")
          .status("status")
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("name", listOf("name"))
      expected.put("status", listOf("status"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = PetCreateParams.builder()
          .petId(123L)
          .build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
      val params = PetCreateParams.builder()
          .petId(123L)
          .build()
      assertThat(params).isNotNull
      // path param "petId"
      assertThat(params.getPathParam(0)).isEqualTo("123")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
