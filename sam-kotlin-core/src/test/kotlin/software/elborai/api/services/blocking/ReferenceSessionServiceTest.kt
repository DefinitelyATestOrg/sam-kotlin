// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
@WireMockTest
class ReferenceSessionServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(get("/api/v1/referencesessions/{id}").willReturn(ok().withBody("abc")))
        val referenceSessionService = client.referenceSessions()
        val response =
            referenceSessionService.retrieve(
                ReferenceSessionRetrieveParams.builder().id("string").build()
            )
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
        stubFor(put("/api/v1/referencesessions/{id}").willReturn(ok().withBody("abc")))
        val referenceSessionService = client.referenceSessions()
        val response =
            referenceSessionService.update(
                ReferenceSessionUpdateParams.builder()
                    .pathId("string")
                    .bodyId("string")
                    .createdBy(
                        ReferenceSessionUpdateParams.CreatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
                    .questions(
                        listOf(
                            ReferenceSessionUpdateParams.Question.builder()
                                .expectedAnswer("string")
                                .question("string")
                                .build()
                        )
                    )
                    .referenceSetId("string")
                    .updatedBy(
                        ReferenceSessionUpdateParams.UpdatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
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
        val referenceSessionService = client.referenceSessions()
        referenceSessionService.delete(ReferenceSessionDeleteParams.builder().id("string").build())
    }
}
