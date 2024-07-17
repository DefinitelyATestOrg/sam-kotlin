// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.ProofOfAuthorizationRequestListParams

@ExtendWith(TestServerExtension::class)
class ProofOfAuthorizationRequestServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val proofOfAuthorizationRequestService = client.proofOfAuthorizationRequests()
        val proofOfAuthorizationRequest =
            proofOfAuthorizationRequestService.retrieve(
                ProofOfAuthorizationRequestRetrieveParams.builder()
                    .proofOfAuthorizationRequestId("string")
                    .build()
            )
        println(proofOfAuthorizationRequest)
        proofOfAuthorizationRequest.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val proofOfAuthorizationRequestService = client.proofOfAuthorizationRequests()
        val proofOfAuthorizationRequestList =
            proofOfAuthorizationRequestService.list(
                ProofOfAuthorizationRequestListParams.builder().build()
            )
        println(proofOfAuthorizationRequestList)
        proofOfAuthorizationRequestList.data().forEach { it.validate() }
    }
}
