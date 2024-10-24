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
import software.elborai.api.models.InboundInternationalAchTransfer

class InboundInternationalAchTransferTest {

    @Test
    fun createInboundInternationalAchTransfer() {
      val inboundInternationalAchTransfer = InboundInternationalAchTransfer.builder()
          .amount(123L)
          .destinationCountryCode("destination_country_code")
          .destinationCurrencyCode("destination_currency_code")
          .foreignExchangeIndicator(InboundInternationalAchTransfer.ForeignExchangeIndicator.FIXED_TO_VARIABLE)
          .foreignExchangeReference("foreign_exchange_reference")
          .foreignExchangeReferenceIndicator(InboundInternationalAchTransfer.ForeignExchangeReferenceIndicator.FOREIGN_EXCHANGE_RATE)
          .foreignPaymentAmount(123L)
          .foreignTraceNumber("foreign_trace_number")
          .internationalTransactionTypeCode(InboundInternationalAchTransfer.InternationalTransactionTypeCode.ANNUITY)
          .originatingCurrencyCode("originating_currency_code")
          .originatingDepositoryFinancialInstitutionBranchCountry("originating_depository_financial_institution_branch_country")
          .originatingDepositoryFinancialInstitutionId("originating_depository_financial_institution_id")
          .originatingDepositoryFinancialInstitutionIdQualifier(InboundInternationalAchTransfer.OriginatingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
          .originatingDepositoryFinancialInstitutionName("originating_depository_financial_institution_name")
          .originatorCity("originator_city")
          .originatorCompanyEntryDescription("originator_company_entry_description")
          .originatorCountry("originator_country")
          .originatorIdentification("originator_identification")
          .originatorName("originator_name")
          .originatorPostalCode("originator_postal_code")
          .originatorStateOrProvince("originator_state_or_province")
          .originatorStreetAddress("originator_street_address")
          .paymentRelatedInformation("payment_related_information")
          .paymentRelatedInformation2("payment_related_information2")
          .receiverCity("receiver_city")
          .receiverCountry("receiver_country")
          .receiverIdentificationNumber("receiver_identification_number")
          .receiverPostalCode("receiver_postal_code")
          .receiverStateOrProvince("receiver_state_or_province")
          .receiverStreetAddress("receiver_street_address")
          .receivingCompanyOrIndividualName("receiving_company_or_individual_name")
          .receivingDepositoryFinancialInstitutionCountry("receiving_depository_financial_institution_country")
          .receivingDepositoryFinancialInstitutionId("receiving_depository_financial_institution_id")
          .receivingDepositoryFinancialInstitutionIdQualifier(InboundInternationalAchTransfer.ReceivingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
          .receivingDepositoryFinancialInstitutionName("receiving_depository_financial_institution_name")
          .traceNumber("trace_number")
          .type(InboundInternationalAchTransfer.Type.INBOUND_INTERNATIONAL_ACH_TRANSFER)
          .build()
      assertThat(inboundInternationalAchTransfer).isNotNull
      assertThat(inboundInternationalAchTransfer.amount()).isEqualTo(123L)
      assertThat(inboundInternationalAchTransfer.destinationCountryCode()).isEqualTo("destination_country_code")
      assertThat(inboundInternationalAchTransfer.destinationCurrencyCode()).isEqualTo("destination_currency_code")
      assertThat(inboundInternationalAchTransfer.foreignExchangeIndicator()).isEqualTo(InboundInternationalAchTransfer.ForeignExchangeIndicator.FIXED_TO_VARIABLE)
      assertThat(inboundInternationalAchTransfer.foreignExchangeReference()).isEqualTo("foreign_exchange_reference")
      assertThat(inboundInternationalAchTransfer.foreignExchangeReferenceIndicator()).isEqualTo(InboundInternationalAchTransfer.ForeignExchangeReferenceIndicator.FOREIGN_EXCHANGE_RATE)
      assertThat(inboundInternationalAchTransfer.foreignPaymentAmount()).isEqualTo(123L)
      assertThat(inboundInternationalAchTransfer.foreignTraceNumber()).isEqualTo("foreign_trace_number")
      assertThat(inboundInternationalAchTransfer.internationalTransactionTypeCode()).isEqualTo(InboundInternationalAchTransfer.InternationalTransactionTypeCode.ANNUITY)
      assertThat(inboundInternationalAchTransfer.originatingCurrencyCode()).isEqualTo("originating_currency_code")
      assertThat(inboundInternationalAchTransfer.originatingDepositoryFinancialInstitutionBranchCountry()).isEqualTo("originating_depository_financial_institution_branch_country")
      assertThat(inboundInternationalAchTransfer.originatingDepositoryFinancialInstitutionId()).isEqualTo("originating_depository_financial_institution_id")
      assertThat(inboundInternationalAchTransfer.originatingDepositoryFinancialInstitutionIdQualifier()).isEqualTo(InboundInternationalAchTransfer.OriginatingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
      assertThat(inboundInternationalAchTransfer.originatingDepositoryFinancialInstitutionName()).isEqualTo("originating_depository_financial_institution_name")
      assertThat(inboundInternationalAchTransfer.originatorCity()).isEqualTo("originator_city")
      assertThat(inboundInternationalAchTransfer.originatorCompanyEntryDescription()).isEqualTo("originator_company_entry_description")
      assertThat(inboundInternationalAchTransfer.originatorCountry()).isEqualTo("originator_country")
      assertThat(inboundInternationalAchTransfer.originatorIdentification()).isEqualTo("originator_identification")
      assertThat(inboundInternationalAchTransfer.originatorName()).isEqualTo("originator_name")
      assertThat(inboundInternationalAchTransfer.originatorPostalCode()).isEqualTo("originator_postal_code")
      assertThat(inboundInternationalAchTransfer.originatorStateOrProvince()).isEqualTo("originator_state_or_province")
      assertThat(inboundInternationalAchTransfer.originatorStreetAddress()).isEqualTo("originator_street_address")
      assertThat(inboundInternationalAchTransfer.paymentRelatedInformation()).isEqualTo("payment_related_information")
      assertThat(inboundInternationalAchTransfer.paymentRelatedInformation2()).isEqualTo("payment_related_information2")
      assertThat(inboundInternationalAchTransfer.receiverCity()).isEqualTo("receiver_city")
      assertThat(inboundInternationalAchTransfer.receiverCountry()).isEqualTo("receiver_country")
      assertThat(inboundInternationalAchTransfer.receiverIdentificationNumber()).isEqualTo("receiver_identification_number")
      assertThat(inboundInternationalAchTransfer.receiverPostalCode()).isEqualTo("receiver_postal_code")
      assertThat(inboundInternationalAchTransfer.receiverStateOrProvince()).isEqualTo("receiver_state_or_province")
      assertThat(inboundInternationalAchTransfer.receiverStreetAddress()).isEqualTo("receiver_street_address")
      assertThat(inboundInternationalAchTransfer.receivingCompanyOrIndividualName()).isEqualTo("receiving_company_or_individual_name")
      assertThat(inboundInternationalAchTransfer.receivingDepositoryFinancialInstitutionCountry()).isEqualTo("receiving_depository_financial_institution_country")
      assertThat(inboundInternationalAchTransfer.receivingDepositoryFinancialInstitutionId()).isEqualTo("receiving_depository_financial_institution_id")
      assertThat(inboundInternationalAchTransfer.receivingDepositoryFinancialInstitutionIdQualifier()).isEqualTo(InboundInternationalAchTransfer.ReceivingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
      assertThat(inboundInternationalAchTransfer.receivingDepositoryFinancialInstitutionName()).isEqualTo("receiving_depository_financial_institution_name")
      assertThat(inboundInternationalAchTransfer.traceNumber()).isEqualTo("trace_number")
      assertThat(inboundInternationalAchTransfer.type()).isEqualTo(InboundInternationalAchTransfer.Type.INBOUND_INTERNATIONAL_ACH_TRANSFER)
    }
}
