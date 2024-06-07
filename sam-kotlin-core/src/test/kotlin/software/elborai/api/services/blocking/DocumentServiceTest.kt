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
import software.elborai.api.client.SamClient
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.services.blocking.DocumentService
import software.elborai.api.models.*
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor

@ExtendWith(TestServerExtension::class)
@WireMockTest
class DocumentServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
      val client = SamOkHttpClient.builder()
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .authToken("My Auth Token")
          .build()
      stubFor(get("/api/v1/document/{doc_id}").willReturn(ok().withBody("abc")))
      val documentService = client.documents()
      val response = documentService.retrieve(DocumentRetrieveParams.builder()
          .docId("string")
          .text(true)
          .build())
      println(response)
      assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
      assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }

    @Test
    fun callUpdate(wmRuntimeInfo: WireMockRuntimeInfo) {
      val client = SamOkHttpClient.builder()
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .authToken("My Auth Token")
          .build()
      stubFor(put("/api/v1/document/{doc_id}").willReturn(ok().withBody("abc")))
      val documentService = client.documents()
      val response = documentService.update(DocumentUpdateParams.builder()
          .docId("string")
          .id("string")
          .corpusPolicy(DocumentUpdateParams.CorpusPolicy.INCLUDE)
          .createdBy(DocumentUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .externalLookupKey("string")
          .languageCode(DocumentUpdateParams.LanguageCode.builder()
              .code("string")
              .detected(true)
              .build())
          .processingVersion(123L)
          .sourceAuthor("string")
          .sourceCreatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .sourceUpdatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .sourceUrl("string")
          .text("string")
          .title("string")
          .updatedBy(DocumentUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .build())
      println(response)
      assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
      assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }

    @Test
    fun callDelete() {
      val client = SamOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .authToken("My Auth Token")
          .build()
      val documentService = client.documents()
      documentService.delete(DocumentDeleteParams.builder()
          .docId("string")
          .build())
    }
}
