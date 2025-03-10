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
import me.elborai.api.errors.SamError
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

@WireMockTest
class ErrorHandlingTest {

    companion object {

        private val ERROR: SamError =
            SamError.builder().putAdditionalProperty("errorProperty", JsonValue.from("42")).build()

        private val ERROR_JSON: ByteArray = jsonMapper().writeValueAsBytes(ERROR)

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
                .willReturn(status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate401() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate403() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate404() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate422() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate429() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate500() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Test
    fun messagesCreate999() {
        val messageService = client.messages()
        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
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
                                    .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                                    .cacheControl(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .builder()
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .addCitation(
                                        MessageCreateParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .builder()
                                            .citedText("cited_text")
                                            .documentIndex(0L)
                                            .documentTitle("x")
                                            .endCharIndex(0L)
                                            .startCharIndex(0L)
                                            .type(
                                                MessageCreateParams.System.RequestTextBlock.Citation
                                                    .RequestCharLocationCitation
                                                    .Type
                                                    .CHAR_LOCATION
                                            )
                                            .build()
                                    )
                                    .build()
                            )
                        )
                        .temperature(1.0)
                        .configEnabledThinking(1024L)
                        .toolChoice(
                            MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                                .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                                .disableParallelToolUse(true)
                                .build()
                        )
                        .addTool(
                            MessageCreateParams.Tool.InnerTool.builder()
                                .inputSchema(
                                    MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.InputSchema.Type
                                                .OBJECT
                                        )
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
                                        .type(
                                            MessageCreateParams.Tool.InnerTool.CacheControl.Type
                                                .EPHEMERAL
                                        )
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
