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
import software.elborai.api.models.EventSubscriptionUpdateParams
import software.elborai.api.models.EventSubscriptionUpdateParams.EventSubscriptionUpdateBody

class EventSubscriptionUpdateParamsTest {

    @Test
    fun createEventSubscriptionUpdateParams() {
      EventSubscriptionUpdateParams.builder()
          .eventSubscriptionId("event_subscription_id")
          .status(EventSubscriptionUpdateParams.Status.ACTIVE)
          .build()
    }

    @Test
    fun getBody() {
      val params = EventSubscriptionUpdateParams.builder()
          .eventSubscriptionId("event_subscription_id")
          .status(EventSubscriptionUpdateParams.Status.ACTIVE)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.status()).isEqualTo(EventSubscriptionUpdateParams.Status.ACTIVE)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = EventSubscriptionUpdateParams.builder()
          .eventSubscriptionId("event_subscription_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = EventSubscriptionUpdateParams.builder()
          .eventSubscriptionId("event_subscription_id")
          .build()
      assertThat(params).isNotNull
      // path param "eventSubscriptionId"
      assertThat(params.getPathParam(0)).isEqualTo("event_subscription_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
