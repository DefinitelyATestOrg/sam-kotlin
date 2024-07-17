// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.models.*
import software.elborai.api.models.DigitalCardProfileListParams

@ExtendWith(TestServerExtension::class)
class DigitalCardProfileServiceTest {

    @Test
    fun callCreate() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalCardProfileService = client.digitalCardProfiles()
        val digitalCardProfile =
            digitalCardProfileService.create(
                DigitalCardProfileCreateParams.builder()
                    .appIconFileId("string")
                    .backgroundImageFileId("string")
                    .cardDescription("x")
                    .description("x")
                    .issuerName("x")
                    .contactEmail("x")
                    .contactPhone("x")
                    .contactWebsite("string")
                    .textColor(
                        DigitalCardProfileCreateParams.TextColor.builder()
                            .blue(123L)
                            .green(123L)
                            .red(123L)
                            .build()
                    )
                    .build()
            )
        println(digitalCardProfile)
        digitalCardProfile.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalCardProfileService = client.digitalCardProfiles()
        val digitalCardProfile =
            digitalCardProfileService.retrieve(
                DigitalCardProfileRetrieveParams.builder().digitalCardProfileId("string").build()
            )
        println(digitalCardProfile)
        digitalCardProfile.validate()
    }

    @Test
    fun callList() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalCardProfileService = client.digitalCardProfiles()
        val digitalCardProfileList =
            digitalCardProfileService.list(DigitalCardProfileListParams.builder().build())
        println(digitalCardProfileList)
        digitalCardProfileList.data().forEach { it.validate() }
    }

    @Test
    fun callArchive() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalCardProfileService = client.digitalCardProfiles()
        val digitalCardProfile =
            digitalCardProfileService.archive(
                DigitalCardProfileArchiveParams.builder().digitalCardProfileId("string").build()
            )
        println(digitalCardProfile)
        digitalCardProfile.validate()
    }

    @Test
    fun callClone() {
        val client =
            IncreaseOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val digitalCardProfileService = client.digitalCardProfiles()
        val digitalCardProfile =
            digitalCardProfileService.clone(
                DigitalCardProfileCloneParams.builder()
                    .digitalCardProfileId("string")
                    .appIconFileId("string")
                    .backgroundImageFileId("string")
                    .cardDescription("x")
                    .contactEmail("x")
                    .contactPhone("x")
                    .contactWebsite("string")
                    .description("x")
                    .issuerName("x")
                    .textColor(
                        DigitalCardProfileCloneParams.TextColor.builder()
                            .blue(123L)
                            .green(123L)
                            .red(123L)
                            .build()
                    )
                    .build()
            )
        println(digitalCardProfile)
        digitalCardProfile.validate()
    }
}
