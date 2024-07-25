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
import software.elborai.api.services.blocking.FileService
import software.elborai.api.models.FileListPage
import software.elborai.api.models.FileListParams
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class FileServiceTest {

    @Disabled("multipart/form-data not yet supported")
    @Test
    fun callCreate() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val fileService = client.files()
      val file = fileService.create(FileCreateParams.builder()
          .file("some content".toByteArray())
          .purpose(FileCreateParams.Purpose.CHECK_IMAGE_FRONT)
          .description("x")
          .build())
      println(file)
      file.validate()
    }

    @Test
    fun callRetrieve() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val fileService = client.files()
      val file = fileService.retrieve(FileRetrieveParams.builder()
          .fileId("file_id")
          .build())
      println(file)
      file.validate()
    }

    @Test
    fun callList() {
      val client = IncreaseOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val fileService = client.files()
      val fileList = fileService.list(FileListParams.builder().build())
      println(fileList)
      fileList.data().forEach {
          it.validate()
      }
    }
}
