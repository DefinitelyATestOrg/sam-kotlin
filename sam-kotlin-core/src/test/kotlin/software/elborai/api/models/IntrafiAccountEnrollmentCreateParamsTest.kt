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
import software.elborai.api.models.IntrafiAccountEnrollmentCreateParams
import software.elborai.api.models.IntrafiAccountEnrollmentCreateParams.IntrafiAccountEnrollmentCreateBody

class IntrafiAccountEnrollmentCreateParamsTest {

    @Test
    fun createIntrafiAccountEnrollmentCreateParams() {
      IntrafiAccountEnrollmentCreateParams.builder()
          .accountId("account_id")
          .emailAddress("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = IntrafiAccountEnrollmentCreateParams.builder()
          .accountId("account_id")
          .emailAddress("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.emailAddress()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = IntrafiAccountEnrollmentCreateParams.builder()
          .accountId("account_id")
          .emailAddress("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.emailAddress()).isEqualTo("x")
    }
}
