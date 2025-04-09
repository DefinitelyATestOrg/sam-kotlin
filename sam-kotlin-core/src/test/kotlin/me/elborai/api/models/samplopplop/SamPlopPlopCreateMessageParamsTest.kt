// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.samplopplop

import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SamPlopPlopCreateMessageParamsTest {

    @Test
    fun create() {
        SamPlopPlopCreateMessageParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .maxTokens(1024L)
            .addMessage(
                SamPlopPlopCreateMessageParams.Message.builder()
                    .content("Hello, world")
                    .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
                    .build()
            )
            .model("claude-3-7-sonnet-20250219")
            .metadata(
                SamPlopPlopCreateMessageParams.Metadata.builder()
                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                    .build()
            )
            .addStopSequence("string")
            .stream(true)
            .systemOfRequestTextBlocks(
                listOf(
                    SamPlopPlopCreateMessageParams.System.RequestTextBlock.builder()
                        .text("Today's date is 2024-06-01.")
                        .type(SamPlopPlopCreateMessageParams.System.RequestTextBlock.Type.TEXT)
                        .cacheControl(
                            SamPlopPlopCreateMessageParams.System.RequestTextBlock.CacheControl
                                .builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                        .CacheControl
                                        .Type
                                        .EPHEMERAL
                                )
                                .build()
                        )
                        .addCitation(
                            SamPlopPlopCreateMessageParams.System.RequestTextBlock.Citation
                                .RequestCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("x")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    SamPlopPlopCreateMessageParams.System.RequestTextBlock.Citation
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
                SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.builder()
                    .type(SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                    .disableParallelToolUse(true)
                    .build()
            )
            .addTool(
                SamPlopPlopCreateMessageParams.Tool.InnerTool.builder()
                    .inputSchema(
                        SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.builder()
                            .type(
                                SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.Type
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
                        SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.builder()
                            .type(
                                SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.Type
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
    }

    @Test
    fun headers() {
        val params =
            SamPlopPlopCreateMessageParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .maxTokens(1024L)
                .addMessage(
                    SamPlopPlopCreateMessageParams.Message.builder()
                        .content("Hello, world")
                        .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .metadata(
                    SamPlopPlopCreateMessageParams.Metadata.builder()
                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                        .build()
                )
                .addStopSequence("string")
                .stream(true)
                .systemOfRequestTextBlocks(
                    listOf(
                        SamPlopPlopCreateMessageParams.System.RequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(SamPlopPlopCreateMessageParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                SamPlopPlopCreateMessageParams.System.RequestTextBlock.CacheControl
                                    .builder()
                                    .type(
                                        SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                SamPlopPlopCreateMessageParams.System.RequestTextBlock.Citation
                                    .RequestCharLocationCitation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                            .Citation
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
                    SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
                .addTool(
                    SamPlopPlopCreateMessageParams.Tool.InnerTool.builder()
                        .inputSchema(
                            SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.Type
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
                            SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.Type
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
            SamPlopPlopCreateMessageParams.builder()
                .maxTokens(1024L)
                .addMessage(
                    SamPlopPlopCreateMessageParams.Message.builder()
                        .content("Hello, world")
                        .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
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
            SamPlopPlopCreateMessageParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .maxTokens(1024L)
                .addMessage(
                    SamPlopPlopCreateMessageParams.Message.builder()
                        .content("Hello, world")
                        .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .metadata(
                    SamPlopPlopCreateMessageParams.Metadata.builder()
                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                        .build()
                )
                .addStopSequence("string")
                .stream(true)
                .systemOfRequestTextBlocks(
                    listOf(
                        SamPlopPlopCreateMessageParams.System.RequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(SamPlopPlopCreateMessageParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                SamPlopPlopCreateMessageParams.System.RequestTextBlock.CacheControl
                                    .builder()
                                    .type(
                                        SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                SamPlopPlopCreateMessageParams.System.RequestTextBlock.Citation
                                    .RequestCharLocationCitation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                            .Citation
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
                    SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
                .addTool(
                    SamPlopPlopCreateMessageParams.Tool.InnerTool.builder()
                        .inputSchema(
                            SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.Type
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
                            SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.Type
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

        val body = params._body()

        assertThat(body.maxTokens()).isEqualTo(1024L)
        assertThat(body.messages())
            .containsExactly(
                SamPlopPlopCreateMessageParams.Message.builder()
                    .content("Hello, world")
                    .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(body.metadata())
            .isEqualTo(
                SamPlopPlopCreateMessageParams.Metadata.builder()
                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                    .build()
            )
        assertThat(body.stopSequences()).containsExactly("string")
        assertThat(body.stream()).isEqualTo(true)
        assertThat(body.system())
            .isEqualTo(
                SamPlopPlopCreateMessageParams.System.ofRequestTextBlocks(
                    listOf(
                        SamPlopPlopCreateMessageParams.System.RequestTextBlock.builder()
                            .text("Today's date is 2024-06-01.")
                            .type(SamPlopPlopCreateMessageParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                SamPlopPlopCreateMessageParams.System.RequestTextBlock.CacheControl
                                    .builder()
                                    .type(
                                        SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                            .CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                SamPlopPlopCreateMessageParams.System.RequestTextBlock.Citation
                                    .RequestCharLocationCitation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                            .Citation
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
                SamPlopPlopCreateMessageParams.Thinking.ofConfigEnabled(
                    SamPlopPlopCreateMessageParams.Thinking.ThinkingConfigEnabled.builder()
                        .budgetTokens(1024L)
                        .type(
                            SamPlopPlopCreateMessageParams.Thinking.ThinkingConfigEnabled.Type
                                .ENABLED
                        )
                        .build()
                )
            )
        assertThat(body.toolChoice())
            .isEqualTo(
                SamPlopPlopCreateMessageParams.ToolChoice.ofAuto(
                    SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
            )
        assertThat(body.tools())
            .containsExactly(
                SamPlopPlopCreateMessageParams.Tool.ofTool(
                    SamPlopPlopCreateMessageParams.Tool.InnerTool.builder()
                        .inputSchema(
                            SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.Type
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
                            SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.builder()
                                .type(
                                    SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.Type
                                        .EPHEMERAL
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
            SamPlopPlopCreateMessageParams.builder()
                .maxTokens(1024L)
                .addMessage(
                    SamPlopPlopCreateMessageParams.Message.builder()
                        .content("Hello, world")
                        .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .build()

        val body = params._body()

        assertThat(body.maxTokens()).isEqualTo(1024L)
        assertThat(body.messages())
            .containsExactly(
                SamPlopPlopCreateMessageParams.Message.builder()
                    .content("Hello, world")
                    .role(SamPlopPlopCreateMessageParams.Message.Role.USER)
                    .build()
            )
        assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
    }
}
