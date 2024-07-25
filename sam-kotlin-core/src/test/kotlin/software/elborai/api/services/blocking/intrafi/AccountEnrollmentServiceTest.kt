// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.intrafi

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
import software.elborai.api.services.blocking.intrafi.AccountEnrollmentService
import software.elborai.api.models.IntrafiAccountEnrollmentListPage
import software.elborai.api.models.IntrafiAccountEnrollmentListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class AccountEnrollmentServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountEnrollmentService = client.intrafi().accountEnrollments()
      val intrafiAccountEnrollment = accountEnrollmentService.create(IntrafiAccountEnrollmentCreateParams.builder()
          .accountId("account_id")
          .emailAddress("x")
          .build())
      println(intrafiAccountEnrollment)
      intrafiAccountEnrollment.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountEnrollmentService = client.intrafi().accountEnrollments()
      val intrafiAccountEnrollment = accountEnrollmentService.retrieve(IntrafiAccountEnrollmentRetrieveParams.builder()
          .intrafiAccountEnrollmentId("intrafi_account_enrollment_id")
          .build())
      println(intrafiAccountEnrollment)
      intrafiAccountEnrollment.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountEnrollmentService = client.intrafi().accountEnrollments()
      val intrafiAccountEnrollmentList = accountEnrollmentService.list(IntrafiAccountEnrollmentListParams.builder().build())
      println(intrafiAccountEnrollmentList)
      intrafiAccountEnrollmentList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callUnenroll() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val accountEnrollmentService = client.intrafi().accountEnrollments()
      val intrafiAccountEnrollment = accountEnrollmentService.unenroll(IntrafiAccountEnrollmentUnenrollParams.builder()
          .intrafiAccountEnrollmentId("intrafi_account_enrollment_id")
          .build())
      println(intrafiAccountEnrollment)
      intrafiAccountEnrollment.validate()
    }
}
