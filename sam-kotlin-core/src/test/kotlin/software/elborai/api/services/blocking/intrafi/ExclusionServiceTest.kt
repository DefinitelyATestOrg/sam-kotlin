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
import software.elborai.api.services.blocking.intrafi.ExclusionService
import software.elborai.api.models.IntrafiExclusionListPage
import software.elborai.api.models.IntrafiExclusionListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class ExclusionServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val exclusionService = client.intrafi().exclusions()
      val intrafiExclusion = exclusionService.create(IntrafiExclusionCreateParams.builder()
          .bankName("x")
          .entityId("entity_id")
          .build())
      println(intrafiExclusion)
      intrafiExclusion.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val exclusionService = client.intrafi().exclusions()
      val intrafiExclusion = exclusionService.retrieve(IntrafiExclusionRetrieveParams.builder()
          .intrafiExclusionId("intrafi_exclusion_id")
          .build())
      println(intrafiExclusion)
      intrafiExclusion.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val exclusionService = client.intrafi().exclusions()
      val intrafiExclusionList = exclusionService.list(IntrafiExclusionListParams.builder().build())
      println(intrafiExclusionList)
      intrafiExclusionList.data().forEach {
          it.validate()
      }
    }

    @Test
    fun callArchive() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val exclusionService = client.intrafi().exclusions()
      val intrafiExclusion = exclusionService.archive(IntrafiExclusionArchiveParams.builder()
          .intrafiExclusionId("intrafi_exclusion_id")
          .build())
      println(intrafiExclusion)
      intrafiExclusion.validate()
    }
}
