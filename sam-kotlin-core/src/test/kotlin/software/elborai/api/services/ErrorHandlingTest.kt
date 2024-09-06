// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.assertj.guava.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import software.elborai.api.client.SamClient
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.JsonString
import software.elborai.api.core.jsonMapper
import software.elborai.api.errors.BadRequestException
import software.elborai.api.errors.InternalServerException
import software.elborai.api.errors.NotFoundException
import software.elborai.api.errors.PermissionDeniedException
import software.elborai.api.errors.RateLimitException
import software.elborai.api.errors.SamError
import software.elborai.api.errors.SamException
import software.elborai.api.errors.UnauthorizedException
import software.elborai.api.errors.UnexpectedStatusCodeException
import software.elborai.api.errors.UnprocessableEntityException
import software.elborai.api.models.*

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val SAM_ERROR: SamError =
        SamError.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: SamClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client = SamOkHttpClient.builder().baseUrl(wmRuntimeInfo.getHttpBaseUrl()).build()
    }

    @Test
    fun storesCreateOrder200() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        val expected =
            Order.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Order.Status.PLACED)
                .build()

        stubFor(post(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.stores().createOrder(params)).isEqualTo(expected)
    }

    @Test
    fun storesCreateOrder400() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun storesCreateOrder401() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertUnauthorized(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun storesCreateOrder403() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertPermissionDenied(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun storesCreateOrder404() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertNotFound(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun storesCreateOrder422() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun storesCreateOrder429() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertRateLimit(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun storesCreateOrder500() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertInternalServer(e, ImmutableListMultimap.of("Foo", "Bar"), SAM_ERROR)
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(SAM_ERROR)))
        )

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    toJson(SAM_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(post(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(SamException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()

        stubFor(post(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.stores().createOrder(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of(), SamError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: ListMultimap<String, String>,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertBadRequest(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnauthorized(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertNotFound(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertRateLimit(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertInternalServer(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: SamError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }
}
