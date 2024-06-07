// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.agents

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
import software.elborai.api.services.blocking.agents.ConfigService
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
class ConfigServiceTest {

    @Test
    fun callRetrieve(wmRuntimeInfo: WireMockRuntimeInfo) {
      val client = SamOkHttpClient.builder()
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .authToken("My Auth Token")
          .build()
      stubFor(get("/api/v1/agents/{agentId}/configs/{integration}").willReturn(ok().withBody("abc")))
      val configService = client.agents().configs()
      val response = configService.retrieve(AgentConfigRetrieveParams.builder()
          .agentId("string")
          .integration(AgentConfigRetrieveParams.Integration.SALESFORCE)
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
      stubFor(put("/api/v1/agents/{agentId}/configs/{integration}").willReturn(ok().withBody("abc")))
      val configService = client.agents().configs()
      val response = configService.update(AgentConfigUpdateParams.builder()
          .agentId("string")
          .integration(AgentConfigUpdateParams.Integration.SALESFORCE)
          .class_("string")
          .build())
      println(response)
      assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
      assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }
}
