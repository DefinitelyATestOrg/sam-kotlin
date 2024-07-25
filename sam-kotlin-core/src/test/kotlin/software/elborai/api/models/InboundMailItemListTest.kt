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
import software.elborai.api.models.InboundMailItemList

class InboundMailItemListTest {

    @Test
    fun createInboundMailItemList() {
      val inboundMailItemList = InboundMailItemList.builder()
          .data(listOf(InboundMailItem.builder()
              .id("id")
              .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .fileId("file_id")
              .lockboxId("lockbox_id")
              .recipientName("recipient_name")
              .rejectionReason(InboundMailItem.RejectionReason.NO_MATCHING_LOCKBOX)
              .returnAddress(InboundMailItem.ReturnAddress.builder()
                  .city("city")
                  .line1("line1")
                  .line2("line2")
                  .name("name")
                  .postalCode("postal_code")
                  .state("state")
                  .build())
              .status(InboundMailItem.Status.PENDING)
              .type(InboundMailItem.Type.INBOUND_MAIL_ITEM)
              .build()))
          .nextCursor("next_cursor")
          .build()
      assertThat(inboundMailItemList).isNotNull
      assertThat(inboundMailItemList.data()).containsExactly(InboundMailItem.builder()
          .id("id")
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .fileId("file_id")
          .lockboxId("lockbox_id")
          .recipientName("recipient_name")
          .rejectionReason(InboundMailItem.RejectionReason.NO_MATCHING_LOCKBOX)
          .returnAddress(InboundMailItem.ReturnAddress.builder()
              .city("city")
              .line1("line1")
              .line2("line2")
              .name("name")
              .postalCode("postal_code")
              .state("state")
              .build())
          .status(InboundMailItem.Status.PENDING)
          .type(InboundMailItem.Type.INBOUND_MAIL_ITEM)
          .build())
      assertThat(inboundMailItemList.nextCursor()).isEqualTo("next_cursor")
    }
}
