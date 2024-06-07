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
import software.elborai.api.models.CorporaUpdateParams
import software.elborai.api.models.CorporaUpdateParams.CorporaUpdateBody

class CorporaUpdateParamsTest {

    @Test
    fun createCorporaUpdateParams() {
      CorporaUpdateParams.builder()
          .corpusId("string")
          .agentId("string")
          .name("string")
          .active(true)
          .crawlSpec(CorporaUpdateParams.CrawlSpec.builder()
              .exclusionPatterns(listOf("string"))
              .htmlTransformer(CorporaUpdateParams.CrawlSpec.HtmlTransformer.NONE)
              .ingestionWorkflowId("string")
              .initialConcurrency(123L)
              .maxConcurrency(123L)
              .maxCrawlDepth(123L)
              .maxCrawlPages(123L)
              .removeElementsCssSelector("string")
              .saveHtml(true)
              .saveMarkdown(true)
              .startUrls(listOf("string"))
              .timeoutSeconds(123L)
              .useSitemaps(true)
              .build())
          .createdBy(CorporaUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .excludeLastUpdatedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .htmlTransformer(CorporaUpdateParams.HtmlTransformer.NONE)
          .includedKbArticleIds(listOf("string"))
          .integration(CorporaUpdateParams.Integration.SALESFORCE)
          .integrationCategoryId("string")
          .sourceUrl("string")
          .status(CorporaUpdateParams.Status.PROCESSING)
          .tags(listOf("string"))
          .type(CorporaUpdateParams.Type.URL)
          .updatedBy(CorporaUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .urlExclusionPatterns(listOf("string"))
          .build()
    }

    @Test
    fun getBody() {
      val params = CorporaUpdateParams.builder()
          .corpusId("string")
          .agentId("string")
          .name("string")
          .active(true)
          .crawlSpec(CorporaUpdateParams.CrawlSpec.builder()
              .exclusionPatterns(listOf("string"))
              .htmlTransformer(CorporaUpdateParams.CrawlSpec.HtmlTransformer.NONE)
              .ingestionWorkflowId("string")
              .initialConcurrency(123L)
              .maxConcurrency(123L)
              .maxCrawlDepth(123L)
              .maxCrawlPages(123L)
              .removeElementsCssSelector("string")
              .saveHtml(true)
              .saveMarkdown(true)
              .startUrls(listOf("string"))
              .timeoutSeconds(123L)
              .useSitemaps(true)
              .build())
          .createdBy(CorporaUpdateParams.CreatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .excludeLastUpdatedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .htmlTransformer(CorporaUpdateParams.HtmlTransformer.NONE)
          .includedKbArticleIds(listOf("string"))
          .integration(CorporaUpdateParams.Integration.SALESFORCE)
          .integrationCategoryId("string")
          .sourceUrl("string")
          .status(CorporaUpdateParams.Status.PROCESSING)
          .tags(listOf("string"))
          .type(CorporaUpdateParams.Type.URL)
          .updatedBy(CorporaUpdateParams.UpdatedBy.builder()
              .id("string")
              .name("string")
              .build())
          .urlExclusionPatterns(listOf("string"))
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.agentId()).isEqualTo("string")
      assertThat(body.name()).isEqualTo("string")
      assertThat(body.active()).isEqualTo(true)
      assertThat(body.crawlSpec()).isEqualTo(CorporaUpdateParams.CrawlSpec.builder()
          .exclusionPatterns(listOf("string"))
          .htmlTransformer(CorporaUpdateParams.CrawlSpec.HtmlTransformer.NONE)
          .ingestionWorkflowId("string")
          .initialConcurrency(123L)
          .maxConcurrency(123L)
          .maxCrawlDepth(123L)
          .maxCrawlPages(123L)
          .removeElementsCssSelector("string")
          .saveHtml(true)
          .saveMarkdown(true)
          .startUrls(listOf("string"))
          .timeoutSeconds(123L)
          .useSitemaps(true)
          .build())
      assertThat(body.createdBy()).isEqualTo(CorporaUpdateParams.CreatedBy.builder()
          .id("string")
          .name("string")
          .build())
      assertThat(body.excludeLastUpdatedBefore()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(body.htmlTransformer()).isEqualTo(CorporaUpdateParams.HtmlTransformer.NONE)
      assertThat(body.includedKbArticleIds()).isEqualTo(listOf("string"))
      assertThat(body.integration()).isEqualTo(CorporaUpdateParams.Integration.SALESFORCE)
      assertThat(body.integrationCategoryId()).isEqualTo("string")
      assertThat(body.sourceUrl()).isEqualTo("string")
      assertThat(body.status()).isEqualTo(CorporaUpdateParams.Status.PROCESSING)
      assertThat(body.tags()).isEqualTo(listOf("string"))
      assertThat(body.type()).isEqualTo(CorporaUpdateParams.Type.URL)
      assertThat(body.updatedBy()).isEqualTo(CorporaUpdateParams.UpdatedBy.builder()
          .id("string")
          .name("string")
          .build())
      assertThat(body.urlExclusionPatterns()).isEqualTo(listOf("string"))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = CorporaUpdateParams.builder()
          .corpusId("string")
          .agentId("string")
          .name("string")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.agentId()).isEqualTo("string")
      assertThat(body.name()).isEqualTo("string")
    }

    @Test
    fun getPathParam() {
      val params = CorporaUpdateParams.builder()
          .corpusId("string")
          .agentId("string")
          .name("string")
          .build()
      assertThat(params).isNotNull
      // path param "corpusId"
      assertThat(params.getPathParam(0)).isEqualTo("string")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
