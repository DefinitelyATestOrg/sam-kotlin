// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.agents

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
class ConfigServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(
            get("/api/v1/agents/{agentId}/configs/{integration}").willReturn(ok().withBody("abc"))
        )
        val configService = client.agents().configs()
        val response =
            configService.retrieve(
                AgentConfigRetrieveParams.builder()
                    .agentId("string")
                    .integration(AgentConfigRetrieveParams.Integration.SALESFORCE)
                    .build()
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
        stubFor(
            put("/api/v1/agents/{agentId}/configs/{integration}").willReturn(ok().withBody("abc"))
        )
        val configService = client.agents().configs()
        val response =
            configService.update(
                AgentConfigUpdateParams.builder()
                    .agentId("string")
                    .integration(AgentConfigUpdateParams.Integration.SALESFORCE)
                    .class_("string")
                    .build()
            )
        println(response)
        assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
        assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }
}
