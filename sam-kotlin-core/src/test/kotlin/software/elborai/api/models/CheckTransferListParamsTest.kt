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
import software.elborai.api.models.CheckTransferListParams

class CheckTransferListParamsTest {

    @Test
    fun createCheckTransferListParams() {
      CheckTransferListParams.builder()
          .accountId("account_id")
          .createdAt(CheckTransferListParams.CreatedAt.builder()
              .after(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .before(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .onOrAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .onOrBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .build())
          .cursor("cursor")
          .idempotencyKey("x")
          .limit(123L)
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = CheckTransferListParams.builder()
          .accountId("account_id")
          .createdAt(CheckTransferListParams.CreatedAt.builder()
              .after(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .before(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .onOrAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .onOrBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .build())
          .cursor("cursor")
          .idempotencyKey("x")
          .limit(123L)
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("account_id", listOf("account_id"))
      CheckTransferListParams.CreatedAt.builder()
          .after(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .before(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .onOrAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .onOrBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .build().forEachQueryParam { key, values -> 
          expected.put("created_at.$key", values)
      }
      expected.put("cursor", listOf("cursor"))
      expected.put("idempotency_key", listOf("x"))
      expected.put("limit", listOf("123"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = CheckTransferListParams.builder().build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
