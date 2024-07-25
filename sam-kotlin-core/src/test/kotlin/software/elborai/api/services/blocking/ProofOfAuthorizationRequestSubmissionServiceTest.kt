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
import software.elborai.api.services.blocking.ProofOfAuthorizationRequestSubmissionService
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionListPage
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class ProofOfAuthorizationRequestSubmissionServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val proofOfAuthorizationRequestSubmissionService = client.proofOfAuthorizationRequestSubmissions()
      val proofOfAuthorizationRequestSubmission = proofOfAuthorizationRequestSubmissionService.create(ProofOfAuthorizationRequestSubmissionCreateParams.builder()
          .authorizationTerms("x")
          .authorizedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .authorizerEmail("x")
          .authorizerName("x")
          .customerHasBeenOffboarded(true)
          .proofOfAuthorizationRequestId("proof_of_authorization_request_id")
          .validatedAccountOwnershipViaCredential(true)
          .validatedAccountOwnershipWithAccountStatement(true)
          .validatedAccountOwnershipWithMicrodeposit(true)
          .authorizerCompany("x")
          .authorizerIpAddress("x")
          .build())
      println(proofOfAuthorizationRequestSubmission)
      proofOfAuthorizationRequestSubmission.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val proofOfAuthorizationRequestSubmissionService = client.proofOfAuthorizationRequestSubmissions()
      val proofOfAuthorizationRequestSubmission = proofOfAuthorizationRequestSubmissionService.retrieve(ProofOfAuthorizationRequestSubmissionRetrieveParams.builder()
          .proofOfAuthorizationRequestSubmissionId("proof_of_authorization_request_submission_id")
          .build())
      println(proofOfAuthorizationRequestSubmission)
      proofOfAuthorizationRequestSubmission.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val proofOfAuthorizationRequestSubmissionService = client.proofOfAuthorizationRequestSubmissions()
      val proofOfAuthorizationRequestSubmissionList = proofOfAuthorizationRequestSubmissionService.list(ProofOfAuthorizationRequestSubmissionListParams.builder().build())
      println(proofOfAuthorizationRequestSubmissionList)
      proofOfAuthorizationRequestSubmissionList.data().forEach {
          it.validate()
      }
    }
}
