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
import software.elborai.api.models.EventSubscriptionCreateParams
import software.elborai.api.models.EventSubscriptionCreateParams.EventSubscriptionCreateBody

class EventSubscriptionCreateParamsTest {

    @Test
    fun createEventSubscriptionCreateParams() {
      EventSubscriptionCreateParams.builder()
          .url("url")
          .oauthConnectionId("oauth_connection_id")
          .selectedEventCategory(EventSubscriptionCreateParams.SelectedEventCategory.ACCOUNT_CREATED)
          .sharedSecret("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = EventSubscriptionCreateParams.builder()
          .url("url")
          .oauthConnectionId("oauth_connection_id")
          .selectedEventCategory(EventSubscriptionCreateParams.SelectedEventCategory.ACCOUNT_CREATED)
          .sharedSecret("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.url()).isEqualTo("url")
      assertThat(body.oauthConnectionId()).isEqualTo("oauth_connection_id")
      assertThat(body.selectedEventCategory()).isEqualTo(EventSubscriptionCreateParams.SelectedEventCategory.ACCOUNT_CREATED)
      assertThat(body.sharedSecret()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = EventSubscriptionCreateParams.builder()
          .url("url")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.url()).isEqualTo("url")
    }
}
