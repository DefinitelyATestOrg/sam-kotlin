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
import software.elborai.api.models.CardDisputeCreateParams
import software.elborai.api.models.CardDisputeCreateParams.CardDisputeCreateBody

class CardDisputeCreateParamsTest {

    @Test
    fun createCardDisputeCreateParams() {
      CardDisputeCreateParams.builder()
          .disputedTransactionId("disputed_transaction_id")
          .explanation("x")
          .build()
    }

    @Test
    fun getBody() {
      val params = CardDisputeCreateParams.builder()
          .disputedTransactionId("disputed_transaction_id")
          .explanation("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.disputedTransactionId()).isEqualTo("disputed_transaction_id")
      assertThat(body.explanation()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = CardDisputeCreateParams.builder()
          .disputedTransactionId("disputed_transaction_id")
          .explanation("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.disputedTransactionId()).isEqualTo("disputed_transaction_id")
      assertThat(body.explanation()).isEqualTo("x")
    }
}
