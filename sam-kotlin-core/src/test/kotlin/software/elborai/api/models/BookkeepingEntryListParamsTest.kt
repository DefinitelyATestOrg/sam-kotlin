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
import software.elborai.api.models.BookkeepingEntryListParams

class BookkeepingEntryListParamsTest {

    @Test
    fun createBookkeepingEntryListParams() {
      BookkeepingEntryListParams.builder()
          .cursor("cursor")
          .limit(123L)
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = BookkeepingEntryListParams.builder()
          .cursor("cursor")
          .limit(123L)
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("cursor", listOf("cursor"))
      expected.put("limit", listOf("123"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = BookkeepingEntryListParams.builder().build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
