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
import software.elborai.api.models.ExternalAccountUpdateParams
import software.elborai.api.models.ExternalAccountUpdateParams.ExternalAccountUpdateBody

class ExternalAccountUpdateParamsTest {

    @Test
    fun createExternalAccountUpdateParams() {
      ExternalAccountUpdateParams.builder()
          .externalAccountId("external_account_id")
          .accountHolder(ExternalAccountUpdateParams.AccountHolder.BUSINESS)
          .description("x")
          .funding(ExternalAccountUpdateParams.Funding.CHECKING)
          .status(ExternalAccountUpdateParams.Status.ACTIVE)
          .build()
    }

    @Test
    fun getBody() {
      val params = ExternalAccountUpdateParams.builder()
          .externalAccountId("external_account_id")
          .accountHolder(ExternalAccountUpdateParams.AccountHolder.BUSINESS)
          .description("x")
          .funding(ExternalAccountUpdateParams.Funding.CHECKING)
          .status(ExternalAccountUpdateParams.Status.ACTIVE)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountHolder()).isEqualTo(ExternalAccountUpdateParams.AccountHolder.BUSINESS)
      assertThat(body.description()).isEqualTo("x")
      assertThat(body.funding()).isEqualTo(ExternalAccountUpdateParams.Funding.CHECKING)
      assertThat(body.status()).isEqualTo(ExternalAccountUpdateParams.Status.ACTIVE)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = ExternalAccountUpdateParams.builder()
          .externalAccountId("external_account_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = ExternalAccountUpdateParams.builder()
          .externalAccountId("external_account_id")
          .build()
      assertThat(params).isNotNull
      // path param "externalAccountId"
      assertThat(params.getPathParam(0)).isEqualTo("external_account_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
