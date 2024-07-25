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
import software.elborai.api.services.blocking.LockboxService
import software.elborai.api.models.LockboxListPage
import software.elborai.api.models.LockboxListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class LockboxServiceTest {

    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val lockboxService = client.lockboxes()
      val lockbox = lockboxService.create(LockboxCreateParams.builder()
          .accountId("account_id")
          .description("x")
          .build())
      println(lockbox)
      lockbox.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val lockboxService = client.lockboxes()
      val lockbox = lockboxService.retrieve(LockboxRetrieveParams.builder()
          .lockboxId("lockbox_id")
          .build())
      println(lockbox)
      lockbox.validate()
    }

    @Test
    fun callUpdate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val lockboxService = client.lockboxes()
      val lockbox = lockboxService.update(LockboxUpdateParams.builder()
          .lockboxId("lockbox_id")
          .description("x")
          .status(LockboxUpdateParams.Status.ACTIVE)
          .build())
      println(lockbox)
      lockbox.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val lockboxService = client.lockboxes()
      val lockboxList = lockboxService.list(LockboxListParams.builder().build())
      println(lockboxList)
      lockboxList.data().forEach {
          it.validate()
      }
    }
}
