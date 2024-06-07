// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import software.elborai.api.core.ContentTypes
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.MultipartFormValue
import software.elborai.api.models.*
import software.elborai.api.models.DocumentUpdateParams
import software.elborai.api.models.DocumentUpdateParams.DocumentUpdateBody

class DocumentUpdateParamsTest {

    @Test
    fun createDocumentUpdateParams() {
      DocumentUpdateParams.builder()
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
          .build()
    }

    @Test
    fun getBody() {
      val params = DocumentUpdateParams.builder()
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
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.id()).isEqualTo("string")
      assertThat(body.corpusPolicy()).isEqualTo(DocumentUpdateParams.CorpusPolicy.INCLUDE)
      assertThat(body.createdBy()).isEqualTo(DocumentUpdateParams.CreatedBy.builder()
          .id("string")
          .name("string")
          .build())
      assertThat(body.externalLookupKey()).isEqualTo("string")
      assertThat(body.languageCode()).isEqualTo(DocumentUpdateParams.LanguageCode.builder()
          .code("string")
          .detected(true)
          .build())
      assertThat(body.processingVersion()).isEqualTo(123L)
      assertThat(body.sourceAuthor()).isEqualTo("string")
      assertThat(body.sourceCreatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(body.sourceUpdatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(body.sourceUrl()).isEqualTo("string")
      assertThat(body.text()).isEqualTo("string")
      assertThat(body.title()).isEqualTo("string")
      assertThat(body.updatedBy()).isEqualTo(DocumentUpdateParams.UpdatedBy.builder()
          .id("string")
          .name("string")
          .build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = DocumentUpdateParams.builder()
          .docId("string")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = DocumentUpdateParams.builder()
          .docId("string")
          .build()
      assertThat(params).isNotNull
      // path param "docId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
