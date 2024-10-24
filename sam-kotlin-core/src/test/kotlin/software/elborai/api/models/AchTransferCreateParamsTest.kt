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
import software.elborai.api.models.AchTransferCreateParams
import software.elborai.api.models.AchTransferCreateParams.AchTransferCreateBody

class AchTransferCreateParamsTest {

    @Test
    fun createAchTransferCreateParams() {
      AchTransferCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .statementDescriptor("x")
          .accountNumber("x")
          .addenda(AchTransferCreateParams.Addenda.builder()
              .category(AchTransferCreateParams.Addenda.Category.FREEFORM)
              .freeform(AchTransferCreateParams.Addenda.Freeform.builder()
                  .entries(listOf(AchTransferCreateParams.Addenda.Freeform.Entry.builder()
                      .paymentRelatedInformation("x")
                      .build()))
                  .build())
              .paymentOrderRemittanceAdvice(AchTransferCreateParams.Addenda.PaymentOrderRemittanceAdvice.builder()
                  .invoices(listOf(AchTransferCreateParams.Addenda.PaymentOrderRemittanceAdvice.Invoice.builder()
                      .invoiceNumber("x")
                      .paidAmount(123L)
                      .build()))
                  .build())
              .build())
          .companyDescriptiveDate("x")
          .companyDiscretionaryData("x")
          .companyEntryDescription("x")
          .companyName("x")
          .destinationAccountHolder(AchTransferCreateParams.DestinationAccountHolder.BUSINESS)
          .effectiveDate(LocalDate.parse("2019-12-27"))
          .externalAccountId("external_account_id")
          .funding(AchTransferCreateParams.Funding.CHECKING)
          .individualId("x")
          .individualName("x")
          .preferredEffectiveDate(AchTransferCreateParams.PreferredEffectiveDate.builder()
              .date(LocalDate.parse("2019-12-27"))
              .settlementSchedule(AchTransferCreateParams.PreferredEffectiveDate.SettlementSchedule.SAME_DAY)
              .build())
          .requireApproval(true)
          .routingNumber("xxxxxxxxx")
          .standardEntryClassCode(AchTransferCreateParams.StandardEntryClassCode.CORPORATE_CREDIT_OR_DEBIT)
          .build()
    }

    @Test
    fun getBody() {
      val params = AchTransferCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .statementDescriptor("x")
          .accountNumber("x")
          .addenda(AchTransferCreateParams.Addenda.builder()
              .category(AchTransferCreateParams.Addenda.Category.FREEFORM)
              .freeform(AchTransferCreateParams.Addenda.Freeform.builder()
                  .entries(listOf(AchTransferCreateParams.Addenda.Freeform.Entry.builder()
                      .paymentRelatedInformation("x")
                      .build()))
                  .build())
              .paymentOrderRemittanceAdvice(AchTransferCreateParams.Addenda.PaymentOrderRemittanceAdvice.builder()
                  .invoices(listOf(AchTransferCreateParams.Addenda.PaymentOrderRemittanceAdvice.Invoice.builder()
                      .invoiceNumber("x")
                      .paidAmount(123L)
                      .build()))
                  .build())
              .build())
          .companyDescriptiveDate("x")
          .companyDiscretionaryData("x")
          .companyEntryDescription("x")
          .companyName("x")
          .destinationAccountHolder(AchTransferCreateParams.DestinationAccountHolder.BUSINESS)
          .effectiveDate(LocalDate.parse("2019-12-27"))
          .externalAccountId("external_account_id")
          .funding(AchTransferCreateParams.Funding.CHECKING)
          .individualId("x")
          .individualName("x")
          .preferredEffectiveDate(AchTransferCreateParams.PreferredEffectiveDate.builder()
              .date(LocalDate.parse("2019-12-27"))
              .settlementSchedule(AchTransferCreateParams.PreferredEffectiveDate.SettlementSchedule.SAME_DAY)
              .build())
          .requireApproval(true)
          .routingNumber("xxxxxxxxx")
          .standardEntryClassCode(AchTransferCreateParams.StandardEntryClassCode.CORPORATE_CREDIT_OR_DEBIT)
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.statementDescriptor()).isEqualTo("x")
      assertThat(body.accountNumber()).isEqualTo("x")
      assertThat(body.addenda()).isEqualTo(AchTransferCreateParams.Addenda.builder()
          .category(AchTransferCreateParams.Addenda.Category.FREEFORM)
          .freeform(AchTransferCreateParams.Addenda.Freeform.builder()
              .entries(listOf(AchTransferCreateParams.Addenda.Freeform.Entry.builder()
                  .paymentRelatedInformation("x")
                  .build()))
              .build())
          .paymentOrderRemittanceAdvice(AchTransferCreateParams.Addenda.PaymentOrderRemittanceAdvice.builder()
              .invoices(listOf(AchTransferCreateParams.Addenda.PaymentOrderRemittanceAdvice.Invoice.builder()
                  .invoiceNumber("x")
                  .paidAmount(123L)
                  .build()))
              .build())
          .build())
      assertThat(body.companyDescriptiveDate()).isEqualTo("x")
      assertThat(body.companyDiscretionaryData()).isEqualTo("x")
      assertThat(body.companyEntryDescription()).isEqualTo("x")
      assertThat(body.companyName()).isEqualTo("x")
      assertThat(body.destinationAccountHolder()).isEqualTo(AchTransferCreateParams.DestinationAccountHolder.BUSINESS)
      assertThat(body.effectiveDate()).isEqualTo(LocalDate.parse("2019-12-27"))
      assertThat(body.externalAccountId()).isEqualTo("external_account_id")
      assertThat(body.funding()).isEqualTo(AchTransferCreateParams.Funding.CHECKING)
      assertThat(body.individualId()).isEqualTo("x")
      assertThat(body.individualName()).isEqualTo("x")
      assertThat(body.preferredEffectiveDate()).isEqualTo(AchTransferCreateParams.PreferredEffectiveDate.builder()
          .date(LocalDate.parse("2019-12-27"))
          .settlementSchedule(AchTransferCreateParams.PreferredEffectiveDate.SettlementSchedule.SAME_DAY)
          .build())
      assertThat(body.requireApproval()).isEqualTo(true)
      assertThat(body.routingNumber()).isEqualTo("xxxxxxxxx")
      assertThat(body.standardEntryClassCode()).isEqualTo(AchTransferCreateParams.StandardEntryClassCode.CORPORATE_CREDIT_OR_DEBIT)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = AchTransferCreateParams.builder()
          .accountId("account_id")
          .amount(123L)
          .statementDescriptor("x")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.accountId()).isEqualTo("account_id")
      assertThat(body.amount()).isEqualTo(123L)
      assertThat(body.statementDescriptor()).isEqualTo("x")
    }
}
