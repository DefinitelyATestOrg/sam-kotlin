// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCountTokensParamsTest {

    @Test
    fun create() {
        MessageCountTokensParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .addMessage(
                MessageCountTokensParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCountTokensParams.Message.Role.USER)
                    .build()
            )
            .model("claude-3-7-sonnet-20250219")
            .systemOfRequestTextBlocks(
                listOf(
                    MessageCountTokensParams.System.RequestTextBlock.builder()
                        .text("Today's date is 2024-06-01.")
                        .type(MessageCountTokensParams.System.RequestTextBlock.Type.TEXT)
                        .cacheControl(
                            MessageCountTokensParams.System.RequestTextBlock.CacheControl.builder()
                                .type(
                                    MessageCountTokensParams.System.RequestTextBlock.CacheControl
                                        .Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .addCitation(
                            MessageCountTokensParams.System.RequestTextBlock.Citation
                                .RequestCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("x")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    MessageCountTokensParams.System.RequestTextBlock.Citation
                                        .RequestCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .build()
                )
            )
            .configEnabledThinking(1024L)
            .toolChoice(
                MessageCountTokensParams.ToolChoice.ToolChoiceAuto.builder()
                    .type(MessageCountTokensParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                    .disableParallelToolUse(true)
                    .build()
            )
            .addTool(
                MessageCountTokensParams.Tool.InnerTool.builder()
                    .inputSchema(
                        MessageCountTokensParams.Tool.InnerTool.InputSchema.builder()
                            .type(MessageCountTokensParams.Tool.InnerTool.InputSchema.Type.OBJECT)
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
                        MessageCountTokensParams.Tool.InnerTool.CacheControl.builder()
                            .type(
                                MessageCountTokensParams.Tool.InnerTool.CacheControl.Type.EPHEMERAL
                            )
                            .build()
                    )
                    .description("Get the current weather in a given location")
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MessageCountTokensParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addMessage(
                    MessageCountTokensParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCountTokensParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .systemOfRequestTextBlocks(
                    listOf(
                        MessageCountTokensParams.System.RequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(MessageCountTokensParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                MessageCountTokensParams.System.RequestTextBlock.CacheControl
                                    .builder()
                                    .type(
                                        MessageCountTokensParams.System.RequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                MessageCountTokensParams.System.RequestTextBlock.Citation
                                    .RequestCharLocationCitation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        MessageCountTokensParams.System.RequestTextBlock.Citation
                                            .RequestCharLocationCitation
                                            .Type
                                            .CHAR_LOCATION
                                    )
                                    .build()
                            )
                            .build()
                    )
                )
                .configEnabledThinking(1024L)
                .toolChoice(
                    MessageCountTokensParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(MessageCountTokensParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
                .addTool(
                    MessageCountTokensParams.Tool.InnerTool.builder()
                        .inputSchema(
                            MessageCountTokensParams.Tool.InnerTool.InputSchema.builder()
                                .type(
                                    MessageCountTokensParams.Tool.InnerTool.InputSchema.Type.OBJECT
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
                            MessageCountTokensParams.Tool.InnerTool.CacheControl.builder()
                                .type(
                                    MessageCountTokensParams.Tool.InnerTool.CacheControl.Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.messages())
            .containsExactly(
                MessageCountTokensParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCountTokensParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(body.system())
            .isEqualTo(
                MessageCountTokensParams.System.ofRequestTextBlocks(
                    listOf(
                        MessageCountTokensParams.System.RequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(MessageCountTokensParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                MessageCountTokensParams.System.RequestTextBlock.CacheControl
                                    .builder()
                                    .type(
                                        MessageCountTokensParams.System.RequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                MessageCountTokensParams.System.RequestTextBlock.Citation
                                    .RequestCharLocationCitation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        MessageCountTokensParams.System.RequestTextBlock.Citation
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
        assertThat(body.thinking())
            .isEqualTo(
                MessageCountTokensParams.Thinking.ofConfigEnabled(
                    MessageCountTokensParams.Thinking.ThinkingConfigEnabled.builder()
                        .budgetTokens(1024L)
                        .type(MessageCountTokensParams.Thinking.ThinkingConfigEnabled.Type.ENABLED)
                        .build()
                )
            )
        assertThat(body.toolChoice())
            .isEqualTo(
                MessageCountTokensParams.ToolChoice.ofAuto(
                    MessageCountTokensParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(MessageCountTokensParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
            )
        assertThat(body.tools())
            .containsExactly(
                MessageCountTokensParams.Tool.ofTool(
                    MessageCountTokensParams.Tool.InnerTool.builder()
                        .inputSchema(
                            MessageCountTokensParams.Tool.InnerTool.InputSchema.builder()
                                .type(
                                    MessageCountTokensParams.Tool.InnerTool.InputSchema.Type.OBJECT
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
                            MessageCountTokensParams.Tool.InnerTool.CacheControl.builder()
                                .type(
                                    MessageCountTokensParams.Tool.InnerTool.CacheControl.Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageCountTokensParams.builder()
                .addMessage(
                    MessageCountTokensParams.Message.builder()
                        .content("Hello, world")
                        .role(MessageCountTokensParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.messages())
            .containsExactly(
                MessageCountTokensParams.Message.builder()
                    .content("Hello, world")
                    .role(MessageCountTokensParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
    }
}
