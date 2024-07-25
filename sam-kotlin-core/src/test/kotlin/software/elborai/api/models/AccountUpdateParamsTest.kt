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
import software.elborai.api.models.AccountUpdateParams
import software.elborai.api.models.AccountUpdateParams.AccountUpdateBody

class AccountUpdateParamsTest {

    @Test
    fun createAccountUpdateParams() {
      AccountUpdateParams.builder()
          .accountId("account_id")
          .name("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = AccountUpdateParams.builder()
          .accountId("account_id")
          .name("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = AccountUpdateParams.builder()
          .accountId("account_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = AccountUpdateParams.builder()
          .accountId("account_id")
          .build()
      assertThat(params).isNotNull
      // path param "accountId"
      assertThat(params.getPathParam(0)).isEqualTo("account_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
