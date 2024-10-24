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
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionListParams

class ProofOfAuthorizationRequestSubmissionListParamsTest {

    @Test
    fun createProofOfAuthorizationRequestSubmissionListParams() {
      ProofOfAuthorizationRequestSubmissionListParams.builder()
          .cursor("cursor")
          .idempotencyKey("x")
          .limit(123L)
          .proofOfAuthorizationRequestId("proof_of_authorization_request_id")
          .build()
    }

    @Test
    fun getQueryParams() {
      val params = ProofOfAuthorizationRequestSubmissionListParams.builder()
          .cursor("cursor")
          .idempotencyKey("x")
          .limit(123L)
          .proofOfAuthorizationRequestId("proof_of_authorization_request_id")
          .build()
      val expected = mutableMapOf<String, List<String>>()
      expected.put("cursor", listOf("cursor"))
      expected.put("idempotency_key", listOf("x"))
      expected.put("limit", listOf("123"))
      expected.put("proof_of_authorization_request_id", listOf("proof_of_authorization_request_id"))
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
      val params = ProofOfAuthorizationRequestSubmissionListParams.builder().build()
      val expected = mutableMapOf<String, List<String>>()
      assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
