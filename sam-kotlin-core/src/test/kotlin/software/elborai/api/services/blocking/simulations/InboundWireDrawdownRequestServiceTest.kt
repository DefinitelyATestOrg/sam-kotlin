// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class InboundWireDrawdownRequestServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboundWireDrawdownRequestService = client.simulations().inboundWireDrawdownRequests()
        val inboundWireDrawdownRequest =
            inboundWireDrawdownRequestService.create(
                SimulationInboundWireDrawdownRequestCreateParams.builder()
                    .amount(123L)
                    .beneficiaryAccountNumber("x")
                    .beneficiaryRoutingNumber("x")
                    .currency("x")
                    .messageToRecipient("x")
                    .originatorAccountNumber("x")
                    .originatorRoutingNumber("x")
                    .recipientAccountNumberId("recipient_account_number_id")
                    .beneficiaryAddressLine1("x")
                    .beneficiaryAddressLine2("x")
                    .beneficiaryAddressLine3("x")
                    .beneficiaryName("x")
                    .originatorAddressLine1("x")
                    .originatorAddressLine2("x")
                    .originatorAddressLine3("x")
                    .originatorName("x")
                    .originatorToBeneficiaryInformationLine1("x")
                    .originatorToBeneficiaryInformationLine2("x")
                    .originatorToBeneficiaryInformationLine3("x")
                    .originatorToBeneficiaryInformationLine4("x")
                    .build()
            )
        println(inboundWireDrawdownRequest)
        inboundWireDrawdownRequest.validate()
    }
}
