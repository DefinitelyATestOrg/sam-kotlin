// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCreateParamsTest {

    @Test
    fun create() {
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
                            MessageCreateParams.System.RequestTextBlock.CacheControl.builder()
                                .type(
                                    MessageCreateParams.System.RequestTextBlock.CacheControl.Type
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
                            .type(MessageCreateParams.Tool.InnerTool.InputSchema.Type.OBJECT)
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
                            .type(MessageCreateParams.Tool.InnerTool.CacheControl.Type.EPHEMERAL)
                            .build()
                    )
                    .description("Get the current weather in a given location")
                    .build()
            )
            .topK(5L)
            .topP(0.7)
            .build()
    }

    @Test
    fun headers() {
        val params =
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
                                MessageCreateParams.System.RequestTextBlock.CacheControl.builder()
                                    .type(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
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
                                .type(MessageCreateParams.Tool.InnerTool.InputSchema.Type.OBJECT)
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
                                    MessageCreateParams.Tool.InnerTool.CacheControl.Type.EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .build()
                )
                .topK(5L)
                .topP(0.7)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("anthropic-beta", "string")
                    .put("anthropic-version", "anthropic-version")
                    .put("x-api-key", "x-api-key")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            MessageCreateParams.builder()
                .maxTokens(1024L)
                .addMessage(
                    MessageCreateParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCreateParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                                MessageCreateParams.System.RequestTextBlock.CacheControl.builder()
                                    .type(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
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
                                .type(MessageCreateParams.Tool.InnerTool.InputSchema.Type.OBJECT)
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
                                    MessageCreateParams.Tool.InnerTool.CacheControl.Type.EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .build()
                )
                .topK(5L)
                .topP(0.7)
                .build()

        val body = params._body()

        assertThat(body.maxTokens()).isEqualTo(1024L)
        assertThat(body.messages())
            .containsExactly(
                MessageCreateParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCreateParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(body.metadata())
            .isEqualTo(
                MessageCreateParams.Metadata.builder()
                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                    .build()
            )
        assertThat(body.stopSequences()).containsExactly("string")
        assertThat(body.stream()).isEqualTo(true)
        assertThat(body.system())
            .isEqualTo(
                MessageCreateParams.System.ofRequestTextBlocks(
                    listOf(
                        MessageCreateParams.System.RequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                MessageCreateParams.System.RequestTextBlock.CacheControl.builder()
                                    .type(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
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
            )
        assertThat(body.temperature()).isEqualTo(1.0)
        assertThat(body.thinking())
            .isEqualTo(
                MessageCreateParams.Thinking.ofConfigEnabled(
                    MessageCreateParams.Thinking.ThinkingConfigEnabled.builder()
                        .budgetTokens(1024L)
                        .type(MessageCreateParams.Thinking.ThinkingConfigEnabled.Type.ENABLED)
                        .build()
                )
            )
        assertThat(body.toolChoice())
            .isEqualTo(
                MessageCreateParams.ToolChoice.ofAuto(
                    MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
            )
        assertThat(body.tools())
            .containsExactly(
                MessageCreateParams.Tool.ofTool(
                    MessageCreateParams.Tool.InnerTool.builder()
                        .inputSchema(
                            MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                .type(MessageCreateParams.Tool.InnerTool.InputSchema.Type.OBJECT)
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
                                    MessageCreateParams.Tool.InnerTool.CacheControl.Type.EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .build()
                )
            )
        assertThat(body.topK()).isEqualTo(5L)
        assertThat(body.topP()).isEqualTo(0.7)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageCreateParams.builder()
                .maxTokens(1024L)
                .addMessage(
                    MessageCreateParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCreateParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .build()

        val body = params._body()

        assertThat(body.maxTokens()).isEqualTo(1024L)
        assertThat(body.messages())
            .containsExactly(
                MessageCreateParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCreateParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
    }
}
