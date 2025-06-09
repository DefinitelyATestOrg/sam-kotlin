// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCountTokensBetaParamsTest {

    @Test
    fun create() {
        MessageCountTokensBetaParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .addMessage(
                MessageCountTokensBetaParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCountTokensBetaParams.Message.Role.USER)
                    .build()
            )
            .model("claude-3-7-sonnet-20250219")
            .systemOfBetaRequestTextBlocks(
                listOf(
                    MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
                        .text("Today's date is 2024-06-01.")
                        .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT)
                        .cacheControl(
                            MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl
                                .builder()
                                .type(
                                    MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                        .CacheControl
                                        .Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .addCitation(
                            MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation
                                .CharLocation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("x")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                        .Citation
                                        .CharLocation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .build()
                )
            )
            .enabledThinking(1024L)
            .toolChoice(
                MessageCountTokensBetaParams.ToolChoice.Auto.builder()
                    .type(MessageCountTokensBetaParams.ToolChoice.Auto.Type.AUTO)
                    .disableParallelToolUse(true)
                    .build()
            )
            .addTool(
                MessageCountTokensBetaParams.Tool.BetaTool.builder()
                    .inputSchema(
                        MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
                            .type(
                                MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type.OBJECT
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
                        MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
                            .type(
                                MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type
                                    .EPHEMERAL
                            )
                            .build()
                    )
                    .description("Get the current weather in a given location")
                    .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
                    .build()
            )
            .build()
    }

    @Test
    fun headers() {
        val params =
            MessageCountTokensBetaParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addMessage(
                    MessageCountTokensBetaParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCountTokensBetaParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .systemOfBetaRequestTextBlocks(
                    listOf(
                        MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT
                            )
                            .cacheControl(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                    .CacheControl
                                    .builder()
                                    .type(
                                        MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation
                                    .CharLocation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                            .Citation
                                            .CharLocation
                                            .Type
                                            .CHAR_LOCATION
                                    )
                                    .build()
                            )
                            .build()
                    )
                )
                .enabledThinking(1024L)
                .toolChoice(
                    MessageCountTokensBetaParams.ToolChoice.Auto.builder()
                        .type(MessageCountTokensBetaParams.ToolChoice.Auto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
                .addTool(
                    MessageCountTokensBetaParams.Tool.BetaTool.builder()
                        .inputSchema(
                            MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
                                .type(
                                    MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type
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
                            MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
                                .type(
                                    MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
                        .build()
                )
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
            MessageCountTokensBetaParams.builder()
                .addMessage(
                    MessageCountTokensBetaParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCountTokensBetaParams.Message.Role.USER)
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
            MessageCountTokensBetaParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addMessage(
                    MessageCountTokensBetaParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCountTokensBetaParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .systemOfBetaRequestTextBlocks(
                    listOf(
                        MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT
                            )
                            .cacheControl(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                    .CacheControl
                                    .builder()
                                    .type(
                                        MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation
                                    .CharLocation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                            .Citation
                                            .CharLocation
                                            .Type
                                            .CHAR_LOCATION
                                    )
                                    .build()
                            )
                            .build()
                    )
                )
                .enabledThinking(1024L)
                .toolChoice(
                    MessageCountTokensBetaParams.ToolChoice.Auto.builder()
                        .type(MessageCountTokensBetaParams.ToolChoice.Auto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
                .addTool(
                    MessageCountTokensBetaParams.Tool.BetaTool.builder()
                        .inputSchema(
                            MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
                                .type(
                                    MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type
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
                            MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
                                .type(
                                    MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.messages())
            .containsExactly(
                MessageCountTokensBetaParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCountTokensBetaParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(body.system())
            .isEqualTo(
                MessageCountTokensBetaParams.System.ofBetaRequestTextBlocks(
                    listOf(
                        MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT
                            )
                            .cacheControl(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                    .CacheControl
                                    .builder()
                                    .type(
                                        MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation
                                    .CharLocation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                            .Citation
                                            .CharLocation
                                            .Type
                                            .CHAR_LOCATION
                                    )
                                    .build()
                            )
                            .build()
                    )
                )
            )
        assertThat(body.thinking())
            .isEqualTo(
                MessageCountTokensBetaParams.Thinking.ofEnabled(
                    MessageCountTokensBetaParams.Thinking.Enabled.builder()
                        .budgetTokens(1024L)
                        .type(MessageCountTokensBetaParams.Thinking.Enabled.Type.ENABLED)
                        .build()
                )
            )
        assertThat(body.toolChoice())
            .isEqualTo(
                MessageCountTokensBetaParams.ToolChoice.ofAuto(
                    MessageCountTokensBetaParams.ToolChoice.Auto.builder()
                        .type(MessageCountTokensBetaParams.ToolChoice.Auto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
            )
        assertThat(body.tools())
            .containsExactly(
                MessageCountTokensBetaParams.Tool.ofBeta(
                    MessageCountTokensBetaParams.Tool.BetaTool.builder()
                        .inputSchema(
                            MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
                                .type(
                                    MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type
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
                            MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
                                .type(
                                    MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageCountTokensBetaParams.builder()
                .addMessage(
                    MessageCountTokensBetaParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCountTokensBetaParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .build()

        val body = params._body()

        assertThat(body.messages())
            .containsExactly(
                MessageCountTokensBetaParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCountTokensBetaParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
    }
}
