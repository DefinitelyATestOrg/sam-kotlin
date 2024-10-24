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
import software.elborai.api.models.AccountCreateParams
import software.elborai.api.models.AccountCreateParams.AccountCreateBody

class AccountCreateParamsTest {

    @Test
    fun createAccountCreateParams() {
      AccountCreateParams.builder()
          .name("x")
          .entityId("entity_id")
          .informationalEntityId("informational_entity_id")
          .programId("program_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = AccountCreateParams.builder()
          .name("x")
          .entityId("entity_id")
          .informationalEntityId("informational_entity_id")
          .programId("program_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("x")
      assertThat(body.entityId()).isEqualTo("entity_id")
      assertThat(body.informationalEntityId()).isEqualTo("informational_entity_id")
      assertThat(body.programId()).isEqualTo("program_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = AccountCreateParams.builder()
          .name("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("x")
    }
}
