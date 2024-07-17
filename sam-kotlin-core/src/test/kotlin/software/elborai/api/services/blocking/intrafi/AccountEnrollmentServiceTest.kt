// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.intrafi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.IntrafiAccountEnrollmentListParams

@ExtendWith(TestServerExtension::class)
class AccountEnrollmentServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountEnrollmentService = client.intrafi().accountEnrollments()
        val intrafiAccountEnrollment =
            accountEnrollmentService.create(
                IntrafiAccountEnrollmentCreateParams.builder()
                    .accountId("string")
                    .emailAddress("x")
                    .build()
            )
        println(intrafiAccountEnrollment)
        intrafiAccountEnrollment.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountEnrollmentService = client.intrafi().accountEnrollments()
        val intrafiAccountEnrollment =
            accountEnrollmentService.retrieve(
                IntrafiAccountEnrollmentRetrieveParams.builder()
                    .intrafiAccountEnrollmentId("string")
                    .build()
            )
        println(intrafiAccountEnrollment)
        intrafiAccountEnrollment.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountEnrollmentService = client.intrafi().accountEnrollments()
        val intrafiAccountEnrollmentList =
            accountEnrollmentService.list(IntrafiAccountEnrollmentListParams.builder().build())
        println(intrafiAccountEnrollmentList)
        intrafiAccountEnrollmentList.data().forEach { it.validate() }
    }

    @Test
    fun callUnenroll() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accountEnrollmentService = client.intrafi().accountEnrollments()
        val intrafiAccountEnrollment =
            accountEnrollmentService.unenroll(
                IntrafiAccountEnrollmentUnenrollParams.builder()
                    .intrafiAccountEnrollmentId("string")
                    .build()
            )
        println(intrafiAccountEnrollment)
        intrafiAccountEnrollment.validate()
    }
}
