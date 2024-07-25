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
import software.elborai.api.client.IncreaseClient
import software.elborai.api.client.okhttp.IncreaseOkHttpClient
import software.elborai.api.core.jsonMapper
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.errors.IncreaseError
import software.elborai.api.errors.IncreaseInvalidDataException
import software.elborai.api.errors.IncreaseServiceException
import software.elborai.api.errors.UnexpectedStatusCodeException
import software.elborai.api.models.AccountListPage
import software.elborai.api.models.AccountListParams
import software.elborai.api.models.*

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private lateinit var client: IncreaseClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
      client = IncreaseOkHttpClient.builder()
          .apiKey("My API Key")
          .webhookSecret("My Webhook Secret")
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .build()
    }

    @Test
    fun accountsCreateWithAdditionalParams() {
      val additionalHeaders = mutableMapOf<String, List<String>>()

      additionalHeaders.put("x-test-header", listOf("abc1234"))

      val additionalQueryParams = mutableMapOf<String, List<String>>()

      additionalQueryParams.put("test_query_param", listOf("def567"))

      val additionalBodyProperties = mutableMapOf<String, JsonValue>()

      additionalBodyProperties.put("testBodyProperty", JsonString.of("ghi890"))

      val params = AccountCreateParams.builder()
          .name("x")
          .entityId("entity_id")
          .informationalEntityId("informational_entity_id")
          .programId("program_id")
          .additionalHeaders(additionalHeaders)
          .additionalBodyProperties(additionalBodyProperties)
          .additionalQueryParams(additionalQueryParams)
          .build()

      val apiResponse = Account.builder()
          .id("id")
          .bank(Account.Bank.BLUE_RIDGE_BANK)
          .closedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .currency(Account.Currency.CAD)
          .entityId("entity_id")
          .idempotencyKey("idempotency_key")
          .informationalEntityId("informational_entity_id")
          .interestAccrued("interest_accrued")
          .interestAccruedAt(LocalDate.parse("2019-12-27"))
          .interestRate("interest_rate")
          .name("name")
          .programId("program_id")
          .status(Account.Status.OPEN)
          .type(Account.Type.ACCOUNT)
          .build()

      stubFor(post(anyUrl())
          .withHeader("x-test-header", equalTo("abc1234"))
          .withQueryParam("test_query_param", equalTo("def567"))
          .withRequestBody(matchingJsonPath("$.testBodyProperty", equalTo("ghi890")))
          .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse))))

      client.accounts().create(params)

      verify(postRequestedFor(anyUrl()))
    }
}
