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
import software.elborai.api.models.InboundAchTransfer

class InboundAchTransferTest {

    @Test
    fun createInboundAchTransfer() {
      val inboundAchTransfer = InboundAchTransfer.builder()
          .id("id")
          .acceptance(InboundAchTransfer.Acceptance.builder()
              .acceptedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .transactionId("transaction_id")
              .build())
          .accountId("account_id")
          .accountNumberId("account_number_id")
          .addenda(InboundAchTransfer.Addenda.builder()
              .category(InboundAchTransfer.Addenda.Category.FREEFORM)
              .freeform(InboundAchTransfer.Addenda.Freeform.builder()
                  .entries(listOf(InboundAchTransfer.Addenda.Freeform.Entry.builder()
                      .paymentRelatedInformation("payment_related_information")
                      .build()))
                  .build())
              .build())
          .amount(123L)
          .automaticallyResolvesAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .decline(InboundAchTransfer.Decline.builder()
              .declinedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .declinedTransactionId("declined_transaction_id")
              .reason(InboundAchTransfer.Decline.Reason.ACH_ROUTE_CANCELED)
              .build())
          .direction(InboundAchTransfer.Direction.CREDIT)
          .notificationOfChange(InboundAchTransfer.NotificationOfChange.builder()
              .updatedAccountNumber("updated_account_number")
              .updatedRoutingNumber("updated_routing_number")
              .build())
          .originatorCompanyDescriptiveDate("originator_company_descriptive_date")
          .originatorCompanyDiscretionaryData("originator_company_discretionary_data")
          .originatorCompanyEntryDescription("originator_company_entry_description")
          .originatorCompanyId("originator_company_id")
          .originatorCompanyName("originator_company_name")
          .originatorRoutingNumber("originator_routing_number")
          .receiverIdNumber("receiver_id_number")
          .receiverName("receiver_name")
          .standardEntryClassCode(InboundAchTransfer.StandardEntryClassCode.CORPORATE_CREDIT_OR_DEBIT)
          .status(InboundAchTransfer.Status.PENDING)
          .traceNumber("trace_number")
          .transferReturn(InboundAchTransfer.TransferReturn.builder()
              .reason(InboundAchTransfer.TransferReturn.Reason.INSUFFICIENT_FUNDS)
              .returnedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .transactionId("transaction_id")
              .build())
          .type(InboundAchTransfer.Type.INBOUND_ACH_TRANSFER)
          .build()
      assertThat(inboundAchTransfer).isNotNull
      assertThat(inboundAchTransfer.id()).isEqualTo("id")
      assertThat(inboundAchTransfer.acceptance()).isEqualTo(InboundAchTransfer.Acceptance.builder()
          .acceptedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .transactionId("transaction_id")
          .build())
      assertThat(inboundAchTransfer.accountId()).isEqualTo("account_id")
      assertThat(inboundAchTransfer.accountNumberId()).isEqualTo("account_number_id")
      assertThat(inboundAchTransfer.addenda()).isEqualTo(InboundAchTransfer.Addenda.builder()
          .category(InboundAchTransfer.Addenda.Category.FREEFORM)
          .freeform(InboundAchTransfer.Addenda.Freeform.builder()
              .entries(listOf(InboundAchTransfer.Addenda.Freeform.Entry.builder()
                  .paymentRelatedInformation("payment_related_information")
                  .build()))
              .build())
          .build())
      assertThat(inboundAchTransfer.amount()).isEqualTo(123L)
      assertThat(inboundAchTransfer.automaticallyResolvesAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(inboundAchTransfer.decline()).isEqualTo(InboundAchTransfer.Decline.builder()
          .declinedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .declinedTransactionId("declined_transaction_id")
          .reason(InboundAchTransfer.Decline.Reason.ACH_ROUTE_CANCELED)
          .build())
      assertThat(inboundAchTransfer.direction()).isEqualTo(InboundAchTransfer.Direction.CREDIT)
      assertThat(inboundAchTransfer.notificationOfChange()).isEqualTo(InboundAchTransfer.NotificationOfChange.builder()
          .updatedAccountNumber("updated_account_number")
          .updatedRoutingNumber("updated_routing_number")
          .build())
      assertThat(inboundAchTransfer.originatorCompanyDescriptiveDate()).isEqualTo("originator_company_descriptive_date")
      assertThat(inboundAchTransfer.originatorCompanyDiscretionaryData()).isEqualTo("originator_company_discretionary_data")
      assertThat(inboundAchTransfer.originatorCompanyEntryDescription()).isEqualTo("originator_company_entry_description")
      assertThat(inboundAchTransfer.originatorCompanyId()).isEqualTo("originator_company_id")
      assertThat(inboundAchTransfer.originatorCompanyName()).isEqualTo("originator_company_name")
      assertThat(inboundAchTransfer.originatorRoutingNumber()).isEqualTo("originator_routing_number")
      assertThat(inboundAchTransfer.receiverIdNumber()).isEqualTo("receiver_id_number")
      assertThat(inboundAchTransfer.receiverName()).isEqualTo("receiver_name")
      assertThat(inboundAchTransfer.standardEntryClassCode()).isEqualTo(InboundAchTransfer.StandardEntryClassCode.CORPORATE_CREDIT_OR_DEBIT)
      assertThat(inboundAchTransfer.status()).isEqualTo(InboundAchTransfer.Status.PENDING)
      assertThat(inboundAchTransfer.traceNumber()).isEqualTo("trace_number")
      assertThat(inboundAchTransfer.transferReturn()).isEqualTo(InboundAchTransfer.TransferReturn.builder()
          .reason(InboundAchTransfer.TransferReturn.Reason.INSUFFICIENT_FUNDS)
          .returnedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .transactionId("transaction_id")
          .build())
      assertThat(inboundAchTransfer.type()).isEqualTo(InboundAchTransfer.Type.INBOUND_ACH_TRANSFER)
    }
}
