// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class CheckTransferCreateParamsTest {

    @Test
    fun createCheckTransferCreateParams() {
        CheckTransferCreateParams.builder()
            .accountId("string")
            .amount(123L)
            .sourceAccountNumberId("string")
            .fulfillmentMethod(CheckTransferCreateParams.FulfillmentMethod.PHYSICAL_CHECK)
            .physicalCheck(
                CheckTransferCreateParams.PhysicalCheck.builder()
                    .mailingAddress(
                        CheckTransferCreateParams.PhysicalCheck.MailingAddress.builder()
                            .city("x")
                            .line1("x")
                            .postalCode("x")
                            .state("x")
                            .line2("x")
                            .name("x")
                            .build()
                    )
                    .memo("x")
                    .recipientName("x")
                    .note("x")
                    .returnAddress(
                        CheckTransferCreateParams.PhysicalCheck.ReturnAddress.builder()
                            .city("x")
                            .line1("x")
                            .name("x")
                            .postalCode("x")
                            .state("x")
                            .line2("x")
                            .build()
                    )
                    .signatureText("x")
                    .build()
            )
            .requireApproval(true)
            .thirdParty(CheckTransferCreateParams.ThirdParty.builder().checkNumber("x").build())
            .build()
    }

    @Test
    fun getBody() {
        val params =
            CheckTransferCreateParams.builder()
                .accountId("string")
                .amount(123L)
                .sourceAccountNumberId("string")
                .fulfillmentMethod(CheckTransferCreateParams.FulfillmentMethod.PHYSICAL_CHECK)
                .physicalCheck(
                    CheckTransferCreateParams.PhysicalCheck.builder()
                        .mailingAddress(
                            CheckTransferCreateParams.PhysicalCheck.MailingAddress.builder()
                                .city("x")
                                .line1("x")
                                .postalCode("x")
                                .state("x")
                                .line2("x")
                                .name("x")
                                .build()
                        )
                        .memo("x")
                        .recipientName("x")
                        .note("x")
                        .returnAddress(
                            CheckTransferCreateParams.PhysicalCheck.ReturnAddress.builder()
                                .city("x")
                                .line1("x")
                                .name("x")
                                .postalCode("x")
                                .state("x")
                                .line2("x")
                                .build()
                        )
                        .signatureText("x")
                        .build()
                )
                .requireApproval(true)
                .thirdParty(CheckTransferCreateParams.ThirdParty.builder().checkNumber("x").build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountId()).isEqualTo("string")
        assertThat(body.amount()).isEqualTo(123L)
        assertThat(body.sourceAccountNumberId()).isEqualTo("string")
        assertThat(body.fulfillmentMethod())
            .isEqualTo(CheckTransferCreateParams.FulfillmentMethod.PHYSICAL_CHECK)
        assertThat(body.physicalCheck())
            .isEqualTo(
                CheckTransferCreateParams.PhysicalCheck.builder()
                    .mailingAddress(
                        CheckTransferCreateParams.PhysicalCheck.MailingAddress.builder()
                            .city("x")
                            .line1("x")
                            .postalCode("x")
                            .state("x")
                            .line2("x")
                            .name("x")
                            .build()
                    )
                    .memo("x")
                    .recipientName("x")
                    .note("x")
                    .returnAddress(
                        CheckTransferCreateParams.PhysicalCheck.ReturnAddress.builder()
                            .city("x")
                            .line1("x")
                            .name("x")
                            .postalCode("x")
                            .state("x")
                            .line2("x")
                            .build()
                    )
                    .signatureText("x")
                    .build()
            )
        assertThat(body.requireApproval()).isEqualTo(true)
        assertThat(body.thirdParty())
            .isEqualTo(CheckTransferCreateParams.ThirdParty.builder().checkNumber("x").build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            CheckTransferCreateParams.builder()
                .accountId("string")
                .amount(123L)
                .sourceAccountNumberId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountId()).isEqualTo("string")
        assertThat(body.amount()).isEqualTo(123L)
        assertThat(body.sourceAccountNumberId()).isEqualTo("string")
    }
}
