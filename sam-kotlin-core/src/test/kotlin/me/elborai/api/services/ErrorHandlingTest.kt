// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers
import me.elborai.api.core.jsonMapper
import me.elborai.api.errors.BadRequestException
import me.elborai.api.errors.InternalServerException
import me.elborai.api.errors.NotFoundException
import me.elborai.api.errors.PermissionDeniedException
import me.elborai.api.errors.RateLimitException
import me.elborai.api.errors.SamException
import me.elborai.api.errors.UnauthorizedException
import me.elborai.api.errors.UnexpectedStatusCodeException
import me.elborai.api.errors.UnprocessableEntityException
import me.elborai.api.models.messages.MessageCreateParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: SamClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun messagesCreate400() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate400WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate401() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate401WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate403() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate403WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate404() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate404WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate422() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate422WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate429() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate429WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate500() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate500WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate999() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreate999WithRawResponse() {
        val messageService = client.messages().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun messagesCreateInvalidJsonBody() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<SamException> {
                messageService.create(
                    MessageCreateParams.builder()
                        .addAnthropicBeta("string")
                        .anthropicVersion("anthropic-version")
                        .xApiKey("x-api-key")
                        .maxTokens(1024L)
                        .addMessage(
                            MessageCreateParams.Message.builder()
                                .content("Hello, world")
                                .role(MessageCreateParams.Message.Role.USER)
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .metadata(
                            MessageCreateParams.Metadata.builder()
                                .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                .build()
                        )
                        .addStopSequence("string")
                        .stream(true)
                        .systemOfRequestTextBlocks(
                            listOf(
                                MessageCreateParams.System.RequestTextBlock.builder()
                                    .text("Today's date is 2024-06-01.")
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .CharLocation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .enabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.Auto.builder()
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .properties(
                                            JsonValue.from(
                                                mapOf(
                                                    "location" to
                                                        mapOf(
                                                            "description" to
                                                                "The city and state, e.g. San Francisco, CA",
                                                            "type" to "string",
                                                        ),
                                                    "unit" to
                                                        mapOf(
                                                            "description" to
                                                                "Unit for the output - one of (celsius, fahrenheit)",
                                                            "type" to "string",
                                                        ),
                                                )
                                            )
                                        )
                                        .build()
                                )
                                .name("name")
                                .cacheControl(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                        .build()
                                )
                                .description("Get the current weather in a given location")
                                .build()
                        )
                        .topK(5L)
                        .topP(0.7)
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
