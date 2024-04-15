// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
@WireMockTest
class CorporaServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(get("/api/v1/corpora/{corpus_id}").willReturn(ok().withBody("abc")))
        val corporaService = client.corpora()
        val response =
            corporaService.retrieve(CorporaRetrieveParams.builder().corpusId("string").build())
        println(response)
        assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
        assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }

    @Test
    fun callUpdate(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(put("/api/v1/corpora/{corpus_id}").willReturn(ok().withBody("abc")))
        val corporaService = client.corpora()
        val response =
            corporaService.update(
                CorporaUpdateParams.builder()
                    .corpusId("string")
                    .agentId("string")
                    .name("string")
                    .active(true)
                    .crawlSpec(
                        CorporaUpdateParams.CrawlSpec.builder()
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
                            .build()
                    )
                    .createdBy(
                        CorporaUpdateParams.CreatedBy.builder().id("string").name("string").build()
                    )
                    .excludeLastUpdatedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .htmlTransformer(CorporaUpdateParams.HtmlTransformer.NONE)
                    .includedKbArticleIds(listOf("string"))
                    .integration(CorporaUpdateParams.Integration.SALESFORCE)
                    .integrationCategoryId("string")
                    .sourceUrl("string")
                    .status(CorporaUpdateParams.Status.PROCESSING)
                    .tags(listOf("string"))
                    .type(CorporaUpdateParams.Type.URL)
                    .updatedBy(
                        CorporaUpdateParams.UpdatedBy.builder().id("string").name("string").build()
                    )
                    .urlExclusionPatterns(listOf("string"))
                    .build()
            )
        println(response)
        assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
        assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }

    @Test
    fun callDelete() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .authToken("My Auth Token")
                .build()
        val corporaService = client.corpora()
        corporaService.delete(CorporaDeleteParams.builder().corpusId("string").build())
    }
}
