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
class ActionSetServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(get("/api/v1/actionsets/{id}").willReturn(ok().withBody("abc")))
        val actionSetService = client.actionSets()
        val response =
            actionSetService.retrieve(ActionSetRetrieveParams.builder().id("string").build())
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
        stubFor(put("/api/v1/actionsets/{id}").willReturn(ok().withBody("abc")))
        val actionSetService = client.actionSets()
        val response =
            actionSetService.update(
                ActionSetUpdateParams.builder()
                    .pathId("string")
                    .name("string")
                    .bodyId("string")
                    .agentId("string")
                    .createdBy(
                        ActionSetUpdateParams.CreatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
                    .openAPIUrl("string")
                    .serverUrl("string")
                    .type(ActionSetUpdateParams.Type.OPENAPI)
                    .updatedBy(
                        ActionSetUpdateParams.UpdatedBy.builder()
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
        val actionSetService = client.actionSets()
        actionSetService.delete(ActionSetDeleteParams.builder().id("string").build())
    }
}
