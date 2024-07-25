// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import software.elborai.api.TestServerExtension
import software.elborai.api.client.IncreaseClient
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.services.blocking.ProofOfAuthorizationRequestService
import software.elborai.api.models.ProofOfAuthorizationRequestListPage
import software.elborai.api.models.ProofOfAuthorizationRequestListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class ProofOfAuthorizationRequestServiceTest {

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val proofOfAuthorizationRequestService = client.proofOfAuthorizationRequests()
      val proofOfAuthorizationRequest = proofOfAuthorizationRequestService.retrieve(ProofOfAuthorizationRequestRetrieveParams.builder()
          .proofOfAuthorizationRequestId("proof_of_authorization_request_id")
          .build())
      println(proofOfAuthorizationRequest)
      proofOfAuthorizationRequest.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val proofOfAuthorizationRequestService = client.proofOfAuthorizationRequests()
      val proofOfAuthorizationRequestList = proofOfAuthorizationRequestService.list(ProofOfAuthorizationRequestListParams.builder().build())
      println(proofOfAuthorizationRequestList)
      proofOfAuthorizationRequestList.data().forEach {
          it.validate()
      }
    }
}
