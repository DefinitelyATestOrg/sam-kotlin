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
import software.elborai.api.models.PetFindByTagsParams

class PetFindByTagsParamsTest {

    @Test
    fun createPetFindByTagsParams() {
      PetFindByTagsParams.builder()
          .tags(listOf("string"))
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = PetFindByTagsParams.builder()
          .tags(listOf("string"))
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("tags", listOf("string"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = PetFindByTagsParams.builder().build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
