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
import software.elborai.api.models.PetFindByStatusParams

class PetFindByStatusParamsTest {

    @Test
    fun createPetFindByStatusParams() {
      PetFindByStatusParams.builder()
          .status(PetFindByStatusParams.Status.AVAILABLE)
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = PetFindByStatusParams.builder()
          .status(PetFindByStatusParams.Status.AVAILABLE)
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("status", listOf(PetFindByStatusParams.Status.AVAILABLE.toString()))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = PetFindByStatusParams.builder().build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
