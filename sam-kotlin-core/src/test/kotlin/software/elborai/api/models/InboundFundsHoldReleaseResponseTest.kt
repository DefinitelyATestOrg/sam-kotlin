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
import software.elborai.api.models.InboundFundsHoldReleaseResponse

class InboundFundsHoldReleaseResponseTest {

    @Test
    fun createInboundFundsHoldReleaseResponse() {
      val inboundFundsHoldReleaseResponse = InboundFundsHoldReleaseResponse.builder()
          .id("id")
          .amount(123L)
          .automaticallyReleasesAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .currency(InboundFundsHoldReleaseResponse.Currency.CAD)
          .heldTransactionId("held_transaction_id")
          .pendingTransactionId("pending_transaction_id")
          .releasedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .status(InboundFundsHoldReleaseResponse.Status.HELD)
          .type(InboundFundsHoldReleaseResponse.Type.INBOUND_FUNDS_HOLD)
          .build()
      assertThat(inboundFundsHoldReleaseResponse).isNotNull
      assertThat(inboundFundsHoldReleaseResponse.id()).isEqualTo("id")
      assertThat(inboundFundsHoldReleaseResponse.amount()).isEqualTo(123L)
      assertThat(inboundFundsHoldReleaseResponse.automaticallyReleasesAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(inboundFundsHoldReleaseResponse.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(inboundFundsHoldReleaseResponse.currency()).isEqualTo(InboundFundsHoldReleaseResponse.Currency.CAD)
      assertThat(inboundFundsHoldReleaseResponse.heldTransactionId()).isEqualTo("held_transaction_id")
      assertThat(inboundFundsHoldReleaseResponse.pendingTransactionId()).isEqualTo("pending_transaction_id")
      assertThat(inboundFundsHoldReleaseResponse.releasedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(inboundFundsHoldReleaseResponse.status()).isEqualTo(InboundFundsHoldReleaseResponse.Status.HELD)
      assertThat(inboundFundsHoldReleaseResponse.type()).isEqualTo(InboundFundsHoldReleaseResponse.Type.INBOUND_FUNDS_HOLD)
    }
}
