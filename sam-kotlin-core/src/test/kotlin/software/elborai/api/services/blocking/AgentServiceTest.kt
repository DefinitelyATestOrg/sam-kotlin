// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.put
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
class AgentServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(get("/api/v1/agents/{id}").willReturn(ok().withBody("abc")))
        val agentService = client.agents()
        val response = agentService.retrieve(AgentRetrieveParams.builder().id("string").build())
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
        stubFor(put("/api/v1/agents/{id}").willReturn(ok().withBody("abc")))
        val agentService = client.agents()
        val response =
            agentService.update(
                AgentUpdateParams.builder()
                    .id("string")
                    .agent(
                        AgentUpdateParams.Agent.builder()
                            .id("string")
                            .additionalPromptText("string")
                            .bailoutIntegration(
                                AgentUpdateParams.Agent.BailoutIntegration.SALESFORCE
                            )
                            .bailoutText("string")
                            .bailoutType(AgentUpdateParams.Agent.BailoutType.INTEGRATION)
                            .brandColor("string")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .createdBy(
                                AgentUpdateParams.Agent.CreatedBy.builder()
                                    .id("string")
                                    .name("string")
                                    .build()
                            )
                            .hiddenTicketTags(listOf("string"))
                            .internalSalesStatus(AgentUpdateParams.Agent.InternalSalesStatus.LIVE)
                            .name("string")
                            .organizationId("string")
                            .persona(AgentUpdateParams.Agent.Persona.ANY)
                            .popularQuestions(listOf("string"))
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .updatedBy(
                                AgentUpdateParams.Agent.UpdatedBy.builder()
                                    .id("string")
                                    .name("string")
                                    .build()
                            )
                            .build()
                    )
                    .chatIcon("some content")
                    .chatIconDeleted(true)
                    .logo("some content")
                    .logoDeleted(true)
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
        val agentService = client.agents()
        agentService.delete(AgentDeleteParams.builder().id("string").build())
    }
}
