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
import software.elborai.api.models.DeclinedTransaction

class DeclinedTransactionTest {

    @Test
    fun createDeclinedTransaction() {
      val declinedTransaction = DeclinedTransaction.builder()
          .id("id")
          .accountId("account_id")
          .amount(123L)
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .currency(DeclinedTransaction.Currency.CAD)
          .description("description")
          .routeId("route_id")
          .routeType(DeclinedTransaction.RouteType.ACCOUNT_NUMBER)
          .source(DeclinedTransaction.Source.builder()
              .achDecline(DeclinedTransaction.Source.AchDecline.builder()
                  .id("id")
                  .amount(123L)
                  .inboundAchTransferId("inbound_ach_transfer_id")
                  .originatorCompanyDescriptiveDate("originator_company_descriptive_date")
                  .originatorCompanyDiscretionaryData("originator_company_discretionary_data")
                  .originatorCompanyId("originator_company_id")
                  .originatorCompanyName("originator_company_name")
                  .reason(DeclinedTransaction.Source.AchDecline.Reason.ACH_ROUTE_CANCELED)
                  .receiverIdNumber("receiver_id_number")
                  .receiverName("receiver_name")
                  .traceNumber("trace_number")
                  .type(DeclinedTransaction.Source.AchDecline.Type.ACH_DECLINE)
                  .build())
              .cardDecline(DeclinedTransaction.Source.CardDecline.builder()
                  .id("id")
                  .actioner(DeclinedTransaction.Source.CardDecline.Actioner.USER)
                  .amount(123L)
                  .cardPaymentId("card_payment_id")
                  .currency(DeclinedTransaction.Source.CardDecline.Currency.CAD)
                  .declinedTransactionId("declined_transaction_id")
                  .digitalWalletTokenId("digital_wallet_token_id")
                  .merchantAcceptorId("merchant_acceptor_id")
                  .merchantCategoryCode("merchant_category_code")
                  .merchantCity("merchant_city")
                  .merchantCountry("merchant_country")
                  .merchantDescriptor("merchant_descriptor")
                  .merchantState("merchant_state")
                  .networkDetails(DeclinedTransaction.Source.CardDecline.NetworkDetails.builder()
                      .category(DeclinedTransaction.Source.CardDecline.NetworkDetails.Category.VISA)
                      .visa(DeclinedTransaction.Source.CardDecline.NetworkDetails.Visa.builder()
                          .electronicCommerceIndicator(DeclinedTransaction.Source.CardDecline.NetworkDetails.Visa.ElectronicCommerceIndicator.MAIL_PHONE_ORDER)
                          .pointOfServiceEntryMode(DeclinedTransaction.Source.CardDecline.NetworkDetails.Visa.PointOfServiceEntryMode.UNKNOWN)
                          .build())
                      .build())
                  .networkIdentifiers(DeclinedTransaction.Source.CardDecline.NetworkIdentifiers.builder()
                      .retrievalReferenceNumber("retrieval_reference_number")
                      .traceNumber("trace_number")
                      .transactionId("transaction_id")
                      .build())
                  .networkRiskScore(123L)
                  .physicalCardId("physical_card_id")
                  .presentmentAmount(123L)
                  .presentmentCurrency("presentment_currency")
                  .processingCategory(DeclinedTransaction.Source.CardDecline.ProcessingCategory.ACCOUNT_FUNDING)
                  .realTimeDecisionId("real_time_decision_id")
                  .reason(DeclinedTransaction.Source.CardDecline.Reason.CARD_NOT_ACTIVE)
                  .verification(DeclinedTransaction.Source.CardDecline.Verification.builder()
                      .cardVerificationCode(DeclinedTransaction.Source.CardDecline.Verification.CardVerificationCode.builder()
                          .result(DeclinedTransaction.Source.CardDecline.Verification.CardVerificationCode.Result.NOT_CHECKED)
                          .build())
                      .cardholderAddress(DeclinedTransaction.Source.CardDecline.Verification.CardholderAddress.builder()
                          .actualLine1("actual_line1")
                          .actualPostalCode("actual_postal_code")
                          .providedLine1("provided_line1")
                          .providedPostalCode("provided_postal_code")
                          .result(DeclinedTransaction.Source.CardDecline.Verification.CardholderAddress.Result.NOT_CHECKED)
                          .build())
                      .build())
                  .build())
              .category(DeclinedTransaction.Source.Category.ACH_DECLINE)
              .checkDecline(DeclinedTransaction.Source.CheckDecline.builder()
                  .amount(123L)
                  .auxiliaryOnUs("auxiliary_on_us")
                  .backImageFileId("back_image_file_id")
                  .checkTransferId("check_transfer_id")
                  .frontImageFileId("front_image_file_id")
                  .inboundCheckDepositId("inbound_check_deposit_id")
                  .reason(DeclinedTransaction.Source.CheckDecline.Reason.ACH_ROUTE_DISABLED)
                  .build())
              .checkDepositRejection(DeclinedTransaction.Source.CheckDepositRejection.builder()
                  .amount(123L)
                  .checkDepositId("check_deposit_id")
                  .currency(DeclinedTransaction.Source.CheckDepositRejection.Currency.CAD)
                  .reason(DeclinedTransaction.Source.CheckDepositRejection.Reason.INCOMPLETE_IMAGE)
                  .rejectedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                  .build())
              .inboundRealTimePaymentsTransferDecline(DeclinedTransaction.Source.InboundRealTimePaymentsTransferDecline.builder()
                  .amount(123L)
                  .creditorName("creditor_name")
                  .currency(DeclinedTransaction.Source.InboundRealTimePaymentsTransferDecline.Currency.CAD)
                  .debtorAccountNumber("debtor_account_number")
                  .debtorName("debtor_name")
                  .debtorRoutingNumber("debtor_routing_number")
                  .reason(DeclinedTransaction.Source.InboundRealTimePaymentsTransferDecline.Reason.ACCOUNT_NUMBER_CANCELED)
                  .remittanceInformation("remittance_information")
                  .transactionIdentification("transaction_identification")
                  .build())
              .internationalAchDecline(DeclinedTransaction.Source.InternationalAchDecline.builder()
                  .amount(123L)
                  .destinationCountryCode("destination_country_code")
                  .destinationCurrencyCode("destination_currency_code")
                  .foreignExchangeIndicator(DeclinedTransaction.Source.InternationalAchDecline.ForeignExchangeIndicator.FIXED_TO_VARIABLE)
                  .foreignExchangeReference("foreign_exchange_reference")
                  .foreignExchangeReferenceIndicator(DeclinedTransaction.Source.InternationalAchDecline.ForeignExchangeReferenceIndicator.FOREIGN_EXCHANGE_RATE)
                  .foreignPaymentAmount(123L)
                  .foreignTraceNumber("foreign_trace_number")
                  .internationalTransactionTypeCode(DeclinedTransaction.Source.InternationalAchDecline.InternationalTransactionTypeCode.ANNUITY)
                  .originatingCurrencyCode("originating_currency_code")
                  .originatingDepositoryFinancialInstitutionBranchCountry("originating_depository_financial_institution_branch_country")
                  .originatingDepositoryFinancialInstitutionId("originating_depository_financial_institution_id")
                  .originatingDepositoryFinancialInstitutionIdQualifier(DeclinedTransaction.Source.InternationalAchDecline.OriginatingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
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
                  .receivingDepositoryFinancialInstitutionIdQualifier(DeclinedTransaction.Source.InternationalAchDecline.ReceivingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
                  .receivingDepositoryFinancialInstitutionName("receiving_depository_financial_institution_name")
                  .traceNumber("trace_number")
                  .build())
              .wireDecline(DeclinedTransaction.Source.WireDecline.builder()
                  .inboundWireTransferId("inbound_wire_transfer_id")
                  .reason(DeclinedTransaction.Source.WireDecline.Reason.ACCOUNT_NUMBER_CANCELED)
                  .build())
              .build())
          .type(DeclinedTransaction.Type.DECLINED_TRANSACTION)
          .build()
      assertThat(declinedTransaction).isNotNull
      assertThat(declinedTransaction.id()).isEqualTo("id")
      assertThat(declinedTransaction.accountId()).isEqualTo("account_id")
      assertThat(declinedTransaction.amount()).isEqualTo(123L)
      assertThat(declinedTransaction.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(declinedTransaction.currency()).isEqualTo(DeclinedTransaction.Currency.CAD)
      assertThat(declinedTransaction.description()).isEqualTo("description")
      assertThat(declinedTransaction.routeId()).isEqualTo("route_id")
      assertThat(declinedTransaction.routeType()).isEqualTo(DeclinedTransaction.RouteType.ACCOUNT_NUMBER)
      assertThat(declinedTransaction.source()).isEqualTo(DeclinedTransaction.Source.builder()
          .achDecline(DeclinedTransaction.Source.AchDecline.builder()
              .id("id")
              .amount(123L)
              .inboundAchTransferId("inbound_ach_transfer_id")
              .originatorCompanyDescriptiveDate("originator_company_descriptive_date")
              .originatorCompanyDiscretionaryData("originator_company_discretionary_data")
              .originatorCompanyId("originator_company_id")
              .originatorCompanyName("originator_company_name")
              .reason(DeclinedTransaction.Source.AchDecline.Reason.ACH_ROUTE_CANCELED)
              .receiverIdNumber("receiver_id_number")
              .receiverName("receiver_name")
              .traceNumber("trace_number")
              .type(DeclinedTransaction.Source.AchDecline.Type.ACH_DECLINE)
              .build())
          .cardDecline(DeclinedTransaction.Source.CardDecline.builder()
              .id("id")
              .actioner(DeclinedTransaction.Source.CardDecline.Actioner.USER)
              .amount(123L)
              .cardPaymentId("card_payment_id")
              .currency(DeclinedTransaction.Source.CardDecline.Currency.CAD)
              .declinedTransactionId("declined_transaction_id")
              .digitalWalletTokenId("digital_wallet_token_id")
              .merchantAcceptorId("merchant_acceptor_id")
              .merchantCategoryCode("merchant_category_code")
              .merchantCity("merchant_city")
              .merchantCountry("merchant_country")
              .merchantDescriptor("merchant_descriptor")
              .merchantState("merchant_state")
              .networkDetails(DeclinedTransaction.Source.CardDecline.NetworkDetails.builder()
                  .category(DeclinedTransaction.Source.CardDecline.NetworkDetails.Category.VISA)
                  .visa(DeclinedTransaction.Source.CardDecline.NetworkDetails.Visa.builder()
                      .electronicCommerceIndicator(DeclinedTransaction.Source.CardDecline.NetworkDetails.Visa.ElectronicCommerceIndicator.MAIL_PHONE_ORDER)
                      .pointOfServiceEntryMode(DeclinedTransaction.Source.CardDecline.NetworkDetails.Visa.PointOfServiceEntryMode.UNKNOWN)
                      .build())
                  .build())
              .networkIdentifiers(DeclinedTransaction.Source.CardDecline.NetworkIdentifiers.builder()
                  .retrievalReferenceNumber("retrieval_reference_number")
                  .traceNumber("trace_number")
                  .transactionId("transaction_id")
                  .build())
              .networkRiskScore(123L)
              .physicalCardId("physical_card_id")
              .presentmentAmount(123L)
              .presentmentCurrency("presentment_currency")
              .processingCategory(DeclinedTransaction.Source.CardDecline.ProcessingCategory.ACCOUNT_FUNDING)
              .realTimeDecisionId("real_time_decision_id")
              .reason(DeclinedTransaction.Source.CardDecline.Reason.CARD_NOT_ACTIVE)
              .verification(DeclinedTransaction.Source.CardDecline.Verification.builder()
                  .cardVerificationCode(DeclinedTransaction.Source.CardDecline.Verification.CardVerificationCode.builder()
                      .result(DeclinedTransaction.Source.CardDecline.Verification.CardVerificationCode.Result.NOT_CHECKED)
                      .build())
                  .cardholderAddress(DeclinedTransaction.Source.CardDecline.Verification.CardholderAddress.builder()
                      .actualLine1("actual_line1")
                      .actualPostalCode("actual_postal_code")
                      .providedLine1("provided_line1")
                      .providedPostalCode("provided_postal_code")
                      .result(DeclinedTransaction.Source.CardDecline.Verification.CardholderAddress.Result.NOT_CHECKED)
                      .build())
                  .build())
              .build())
          .category(DeclinedTransaction.Source.Category.ACH_DECLINE)
          .checkDecline(DeclinedTransaction.Source.CheckDecline.builder()
              .amount(123L)
              .auxiliaryOnUs("auxiliary_on_us")
              .backImageFileId("back_image_file_id")
              .checkTransferId("check_transfer_id")
              .frontImageFileId("front_image_file_id")
              .inboundCheckDepositId("inbound_check_deposit_id")
              .reason(DeclinedTransaction.Source.CheckDecline.Reason.ACH_ROUTE_DISABLED)
              .build())
          .checkDepositRejection(DeclinedTransaction.Source.CheckDepositRejection.builder()
              .amount(123L)
              .checkDepositId("check_deposit_id")
              .currency(DeclinedTransaction.Source.CheckDepositRejection.Currency.CAD)
              .reason(DeclinedTransaction.Source.CheckDepositRejection.Reason.INCOMPLETE_IMAGE)
              .rejectedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .build())
          .inboundRealTimePaymentsTransferDecline(DeclinedTransaction.Source.InboundRealTimePaymentsTransferDecline.builder()
              .amount(123L)
              .creditorName("creditor_name")
              .currency(DeclinedTransaction.Source.InboundRealTimePaymentsTransferDecline.Currency.CAD)
              .debtorAccountNumber("debtor_account_number")
              .debtorName("debtor_name")
              .debtorRoutingNumber("debtor_routing_number")
              .reason(DeclinedTransaction.Source.InboundRealTimePaymentsTransferDecline.Reason.ACCOUNT_NUMBER_CANCELED)
              .remittanceInformation("remittance_information")
              .transactionIdentification("transaction_identification")
              .build())
          .internationalAchDecline(DeclinedTransaction.Source.InternationalAchDecline.builder()
              .amount(123L)
              .destinationCountryCode("destination_country_code")
              .destinationCurrencyCode("destination_currency_code")
              .foreignExchangeIndicator(DeclinedTransaction.Source.InternationalAchDecline.ForeignExchangeIndicator.FIXED_TO_VARIABLE)
              .foreignExchangeReference("foreign_exchange_reference")
              .foreignExchangeReferenceIndicator(DeclinedTransaction.Source.InternationalAchDecline.ForeignExchangeReferenceIndicator.FOREIGN_EXCHANGE_RATE)
              .foreignPaymentAmount(123L)
              .foreignTraceNumber("foreign_trace_number")
              .internationalTransactionTypeCode(DeclinedTransaction.Source.InternationalAchDecline.InternationalTransactionTypeCode.ANNUITY)
              .originatingCurrencyCode("originating_currency_code")
              .originatingDepositoryFinancialInstitutionBranchCountry("originating_depository_financial_institution_branch_country")
              .originatingDepositoryFinancialInstitutionId("originating_depository_financial_institution_id")
              .originatingDepositoryFinancialInstitutionIdQualifier(DeclinedTransaction.Source.InternationalAchDecline.OriginatingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
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
              .receivingDepositoryFinancialInstitutionIdQualifier(DeclinedTransaction.Source.InternationalAchDecline.ReceivingDepositoryFinancialInstitutionIdQualifier.NATIONAL_CLEARING_SYSTEM_NUMBER)
              .receivingDepositoryFinancialInstitutionName("receiving_depository_financial_institution_name")
              .traceNumber("trace_number")
              .build())
          .wireDecline(DeclinedTransaction.Source.WireDecline.builder()
              .inboundWireTransferId("inbound_wire_transfer_id")
              .reason(DeclinedTransaction.Source.WireDecline.Reason.ACCOUNT_NUMBER_CANCELED)
              .build())
          .build())
      assertThat(declinedTransaction.type()).isEqualTo(DeclinedTransaction.Type.DECLINED_TRANSACTION)
    }
}
