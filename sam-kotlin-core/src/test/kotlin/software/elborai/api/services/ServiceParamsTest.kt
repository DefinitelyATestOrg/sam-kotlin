// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import java.io.IOException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import software.elborai.api.client.SamClient
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.jsonMapper
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.errors.SamError
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.errors.SamServiceException
import software.elborai.api.errors.UnexpectedStatusCodeException
import software.elborai.api.models.*

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private lateinit var client: SamClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
      client = SamOkHttpClient.builder()
          .authToken("My Auth Token")
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .build()
    }

    @Test
    fun agentsRetrieveWithAdditionalParams() {
      val additionalHeaders = mutableMapOf<String, List<String>>()

      additionalHeaders.put("x-test-header", listOf("abc1234"))

      val additionalQueryParams = mutableMapOf<String, List<String>>()

      additionalQueryParams.put("test_query_param", listOf("def567"))

      val params = AgentRetrieveParams.builder()
          .id("string")
          .additionalHeaders(additionalHeaders)
          .additionalQueryParams(additionalQueryParams)
          .build()

      val apiResponse = "abc".encodeToByteArray()

      stubFor(get(anyUrl())
          .withHeader("x-test-header", equalTo("abc1234"))
          .withQueryParam("test_query_param", equalTo("def567"))
          .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse))))

      client.agents().retrieve(params)

      verify(getRequestedFor(anyUrl()))
    }

    @Test
    fun actionSetsRetrieveWithAdditionalParams() {
      val additionalHeaders = mutableMapOf<String, List<String>>()

      additionalHeaders.put("x-test-header", listOf("abc1234"))

      val additionalQueryParams = mutableMapOf<String, List<String>>()

      additionalQueryParams.put("test_query_param", listOf("def567"))

      val params = ActionSetRetrieveParams.builder()
          .id("string")
          .additionalHeaders(additionalHeaders)
          .additionalQueryParams(additionalQueryParams)
          .build()

      val apiResponse = "abc".encodeToByteArray()

      stubFor(get(anyUrl())
          .withHeader("x-test-header", equalTo("abc1234"))
          .withQueryParam("test_query_param", equalTo("def567"))
          .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse))))

      client.actionSets().retrieve(params)

      verify(getRequestedFor(anyUrl()))
    }
}
