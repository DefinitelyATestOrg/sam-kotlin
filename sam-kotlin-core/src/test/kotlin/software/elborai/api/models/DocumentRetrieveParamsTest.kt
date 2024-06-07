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
import software.elborai.api.models.DocumentRetrieveParams

class DocumentRetrieveParamsTest {

    @Test
    fun createDocumentRetrieveParams() {
      DocumentRetrieveParams.builder()
          .docId("string")
          .text(true)
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = DocumentRetrieveParams.builder()
          .docId("string")
          .text(true)
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("text", listOf("true"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = DocumentRetrieveParams.builder()
          .docId("string")
          .build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
      val params = DocumentRetrieveParams.builder()
          .docId("string")
          .build()
      assertThat(params).isNotNull
      // path param "docId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
