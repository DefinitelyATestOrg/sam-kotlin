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
import software.elborai.api.models.IntrafiAccountEnrollmentListParams

class IntrafiAccountEnrollmentListParamsTest {

    @Test
    fun createIntrafiAccountEnrollmentListParams() {
      IntrafiAccountEnrollmentListParams.builder()
          .accountId("account_id")
          .cursor("cursor")
          .idempotencyKey("x")
          .limit(123L)
          .status(IntrafiAccountEnrollmentListParams.Status.builder()
              .in_(listOf(IntrafiAccountEnrollmentListParams.Status.In.PENDING_ENROLLING))
              .build())
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = IntrafiAccountEnrollmentListParams.builder()
          .accountId("account_id")
          .cursor("cursor")
          .idempotencyKey("x")
          .limit(123L)
          .status(IntrafiAccountEnrollmentListParams.Status.builder()
              .in_(listOf(IntrafiAccountEnrollmentListParams.Status.In.PENDING_ENROLLING))
              .build())
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("account_id", listOf("account_id"))
      expected.put("cursor", listOf("cursor"))
      expected.put("idempotency_key", listOf("x"))
      expected.put("limit", listOf("123"))
      IntrafiAccountEnrollmentListParams.Status.builder()
          .in_(listOf(IntrafiAccountEnrollmentListParams.Status.In.PENDING_ENROLLING))
          .build().forEachQueryParam { key, values -> 
          expected.put("status.$key", values)
      }
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = IntrafiAccountEnrollmentListParams.builder().build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
