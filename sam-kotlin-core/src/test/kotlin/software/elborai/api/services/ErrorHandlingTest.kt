// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.github.tomakehurst.wiremock.client.WireMock.binaryEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.guava.api.Assertions.assertThat
import com.google.common.collect.ListMultimap
import com.google.common.collect.ImmutableListMultimap
import com.fasterxml.jackson.databind.json.JsonMapper
import java.io.IOException
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.InputStream
import java.io.ByteArrayOutputStream
import software.elborai.api.client.SamClient
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonString
import software.elborai.api.core.JsonValue
import software.elborai.api.core.jsonMapper
import software.elborai.api.errors.BadRequestException
import software.elborai.api.errors.InternalServerException
import software.elborai.api.errors.NotFoundException
import software.elborai.api.errors.PermissionDeniedException
import software.elborai.api.errors.RateLimitException
import software.elborai.api.errors.SamError
import software.elborai.api.errors.SamException
import software.elborai.api.errors.SamServiceException
import software.elborai.api.errors.UnauthorizedException
import software.elborai.api.errors.UnexpectedStatusCodeException
import software.elborai.api.errors.UnprocessableEntityException
import software.elborai.api.models.*

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val SAM_ERROR: SamError = SamError.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: SamClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
      client = SamOkHttpClient.builder()
          .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
          .authToken("My Auth Token")
          .build()
    }

    // Note: readAllBytes is only available in Java 9+
    private fun InputStream.readBytesFully(): ByteArray {
      val buffer = ByteArrayOutputStream()
      val data = ByteArray(1024)

      var nRead: Int
      while (this.read(data, 0, data.size).also { nRead = it } != -1) {
          buffer.write(data, 0, nRead)
      }

      buffer.flush()
      return buffer.toByteArray()
    }

    @Test
    fun agentsRetrieve200() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      val expected = "abc".encodeToByteArray()

      stubFor(get(anyUrl())
          .willReturn(ok().withBody(expected)))

      assertThat(client.agents().retrieve(params).body().use { it.readBytesFully() }).isEqualTo(expected)
    }

    @Test
    fun agentsRetrieve400() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertBadRequest(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun agentsRetrieve401() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertUnauthorized(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun agentsRetrieve403() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertPermissionDenied(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun agentsRetrieve404() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertNotFound(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun agentsRetrieve422() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertUnprocessableEntity(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun agentsRetrieve429() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertRateLimit(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun agentsRetrieve500() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) })
          .satisfies({ e -> assertInternalServer(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR) })
    }

    @Test
    fun unexpectedStatusCode() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR))))

      assertThatThrownBy({ client.agents().retrieve(params) }).satisfies({ e -> assertUnexpectedStatusCodeException(e, 999, ImmutableListMultimap.of("Foo", "Bar"), toJson(SAM_ERROR)) })
    }

    @Test
    fun invalidErrorBody() {
      val params = AgentRetrieveParams.builder()
          .id("string")
          .build()

      stubFor(get(anyUrl())
          .willReturn(status(400).withBody("Not JSON")))

      assertThatThrownBy({ client.agents().retrieve(params) }).satisfies({ e -> assertBadRequest(e, ImmutableListMultimap.of(), SamError.builder().build()) })
    }

    private fun <T> toJson(body: T): ByteArray {
      return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(throwable: Throwable, statusCode: Int, headers: ListMultimap<String, String>, responseBody: ByteArray) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(statusCode)
          assertThat(e.body()).isEqualTo(String(responseBody))
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertBadRequest(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(400)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertUnauthorized(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(401)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertPermissionDenied(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(403)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertNotFound(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(404)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertUnprocessableEntity(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(422)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertRateLimit(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(429)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }

    private fun assertInternalServer(throwable: Throwable, headers: ListMultimap<String, String>, error: SamError) {
      assertThat(throwable)
          .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
          .satisfies({ e -> assertThat(e.statusCode()).isEqualTo(500)
          assertThat(e.error()).isEqualTo(error)
          assertThat(e.headers()).containsAllEntriesOf(headers) })
    }
}
