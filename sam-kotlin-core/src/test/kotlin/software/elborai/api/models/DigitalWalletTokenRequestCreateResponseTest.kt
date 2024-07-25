// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.models.DigitalWalletTokenRequestCreateResponse

class DigitalWalletTokenRequestCreateResponseTest {

    @Test
    fun createDigitalWalletTokenRequestCreateResponse() {
      val digitalWalletTokenRequestCreateResponse = DigitalWalletTokenRequestCreateResponse.builder()
          .declineReason(DigitalWalletTokenRequestCreateResponse.DeclineReason.CARD_NOT_ACTIVE)
          .digitalWalletTokenId("digital_wallet_token_id")
          .type(DigitalWalletTokenRequestCreateResponse.Type.INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT)
          .build()
      assertThat(digitalWalletTokenRequestCreateResponse).isNotNull
      assertThat(digitalWalletTokenRequestCreateResponse.declineReason()).isEqualTo(DigitalWalletTokenRequestCreateResponse.DeclineReason.CARD_NOT_ACTIVE)
      assertThat(digitalWalletTokenRequestCreateResponse.digitalWalletTokenId()).isEqualTo("digital_wallet_token_id")
      assertThat(digitalWalletTokenRequestCreateResponse.type()).isEqualTo(DigitalWalletTokenRequestCreateResponse.Type.INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT)
    }
}
