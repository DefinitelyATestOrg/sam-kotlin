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
import software.elborai.api.models.BookkeepingAccountCreateParams
import software.elborai.api.models.BookkeepingAccountCreateParams.BookkeepingAccountCreateBody

class BookkeepingAccountCreateParamsTest {

    @Test
    fun createBookkeepingAccountCreateParams() {
      BookkeepingAccountCreateParams.builder()
          .name("x")
          .accountId("account_id")
          .complianceCategory(BookkeepingAccountCreateParams.ComplianceCategory.COMMINGLED_CASH)
          .entityId("entity_id")
          .build()
    }

    @Test
    fun getBody() {
      val params = BookkeepingAccountCreateParams.builder()
          .name("x")
          .accountId("account_id")
          .complianceCategory(BookkeepingAccountCreateParams.ComplianceCategory.COMMINGLED_CASH)
          .entityId("entity_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("x")
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.complianceCategory()).isEqualTo(BookkeepingAccountCreateParams.ComplianceCategory.COMMINGLED_CASH)
      assertThat(body.entityId()).isEqualTo("entity_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = BookkeepingAccountCreateParams.builder()
          .name("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("x")
    }
}
