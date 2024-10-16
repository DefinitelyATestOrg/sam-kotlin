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
import software.elborai.api.models.CardUpdateParams
import software.elborai.api.models.CardUpdateParams.CardUpdateBody

class CardUpdateParamsTest {

    @Test
    fun createCardUpdateParams() {
      CardUpdateParams.builder()
          .cardId("card_id")
          .billingAddress(CardUpdateParams.BillingAddress.builder()
              .city("x")
              .line1("x")
              .postalCode("x")
              .state("x")
              .line2("x")
              .build())
          .description("x")
          .digitalWallet(CardUpdateParams.DigitalWallet.builder()
              .digitalCardProfileId("digital_card_profile_id")
              .email("x")
              .phone("x")
              .build())
          .entityId("entity_id")
          .status(CardUpdateParams.Status.ACTIVE)
          .build()
    }

    @Test
    fun getBody() {
      val params = CardUpdateParams.builder()
          .cardId("card_id")
          .billingAddress(CardUpdateParams.BillingAddress.builder()
              .city("x")
              .line1("x")
              .postalCode("x")
              .state("x")
              .line2("x")
              .build())
          .description("x")
          .digitalWallet(CardUpdateParams.DigitalWallet.builder()
              .digitalCardProfileId("digital_card_profile_id")
              .email("x")
              .phone("x")
              .build())
          .entityId("entity_id")
          .status(CardUpdateParams.Status.ACTIVE)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.billingAddress()).isEqualTo(CardUpdateParams.BillingAddress.builder()
          .city("x")
          .line1("x")
          .postalCode("x")
          .state("x")
          .line2("x")
          .build())
      assertThat(body.description()).isEqualTo("x")
      assertThat(body.digitalWallet()).isEqualTo(CardUpdateParams.DigitalWallet.builder()
          .digitalCardProfileId("digital_card_profile_id")
          .email("x")
          .phone("x")
          .build())
      assertThat(body.entityId()).isEqualTo("entity_id")
      assertThat(body.status()).isEqualTo(CardUpdateParams.Status.ACTIVE)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = CardUpdateParams.builder()
          .cardId("card_id")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = CardUpdateParams.builder()
          .cardId("card_id")
          .build()
      assertThat(params).isNotNull
      // path param "cardId"
      assertThat(params.getPathParam(0)).isEqualTo("card_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
