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
import software.elborai.api.services.blocking.DigitalCardProfileService
import software.elborai.api.models.DigitalCardProfileListPage
import software.elborai.api.models.DigitalCardProfileListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class DigitalCardProfileServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val digitalCardProfileService = client.digitalCardProfiles()
      val digitalCardProfile = digitalCardProfileService.create(DigitalCardProfileCreateParams.builder()
          .appIconFileId("app_icon_file_id")
          .backgroundImageFileId("background_image_file_id")
          .cardDescription("x")
          .description("x")
          .issuerName("x")
          .contactEmail("x")
          .contactPhone("x")
          .contactWebsite("contact_website")
          .textColor(DigitalCardProfileCreateParams.TextColor.builder()
              .blue(123L)
              .green(123L)
              .red(123L)
              .build())
          .build())
      println(digitalCardProfile)
      digitalCardProfile.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val digitalCardProfileService = client.digitalCardProfiles()
      val digitalCardProfile = digitalCardProfileService.retrieve(DigitalCardProfileRetrieveParams.builder()
          .digitalCardProfileId("digital_card_profile_id")
          .build())
      println(digitalCardProfile)
      digitalCardProfile.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val digitalCardProfileService = client.digitalCardProfiles()
      val digitalCardProfileList = digitalCardProfileService.list(DigitalCardProfileListParams.builder().build())
      println(digitalCardProfileList)
      digitalCardProfileList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callArchive() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val digitalCardProfileService = client.digitalCardProfiles()
      val digitalCardProfile = digitalCardProfileService.archive(DigitalCardProfileArchiveParams.builder()
          .digitalCardProfileId("digital_card_profile_id")
          .build())
      println(digitalCardProfile)
      digitalCardProfile.validate()
    }

    @Test
    fun callClone() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val digitalCardProfileService = client.digitalCardProfiles()
      val digitalCardProfile = digitalCardProfileService.clone(DigitalCardProfileCloneParams.builder()
          .digitalCardProfileId("digital_card_profile_id")
          .appIconFileId("app_icon_file_id")
          .backgroundImageFileId("background_image_file_id")
          .cardDescription("x")
          .contactEmail("x")
          .contactPhone("x")
          .contactWebsite("contact_website")
          .description("x")
          .issuerName("x")
          .textColor(DigitalCardProfileCloneParams.TextColor.builder()
              .blue(123L)
              .green(123L)
              .red(123L)
              .build())
          .build())
      println(digitalCardProfile)
      digitalCardProfile.validate()
    }
}
