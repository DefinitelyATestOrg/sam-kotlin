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
import software.elborai.api.models.OAuthTokenCreateParams
import software.elborai.api.models.OAuthTokenCreateParams.OAuthTokenCreateBody

class OAuthTokenCreateParamsTest {

    @Test
    fun createOAuthTokenCreateParams() {
      OAuthTokenCreateParams.builder()
          .grantType(OAuthTokenCreateParams.GrantType.AUTHORIZATION_CODE)
          .clientId("x")
          .clientSecret("x")
          .code("x")
          .productionToken("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = OAuthTokenCreateParams.builder()
          .grantType(OAuthTokenCreateParams.GrantType.AUTHORIZATION_CODE)
          .clientId("x")
          .clientSecret("x")
          .code("x")
          .productionToken("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.grantType()).isEqualTo(OAuthTokenCreateParams.GrantType.AUTHORIZATION_CODE)
      assertThat(body.clientId()).isEqualTo("x")
      assertThat(body.clientSecret()).isEqualTo("x")
      assertThat(body.code()).isEqualTo("x")
      assertThat(body.productionToken()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = OAuthTokenCreateParams.builder()
          .grantType(OAuthTokenCreateParams.GrantType.AUTHORIZATION_CODE)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.grantType()).isEqualTo(OAuthTokenCreateParams.GrantType.AUTHORIZATION_CODE)
    }
}
