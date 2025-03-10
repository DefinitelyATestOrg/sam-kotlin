// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchCreateParamsTest {

    @Test
    fun create() {
        MessageBatchCreateParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .addRequest(
                MessageBatchCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        MessageBatchCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                MessageBatchCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(MessageBatchCreateParams.Request.Params.Message.Role.USER)
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .metadata(
                                MessageBatchCreateParams.Request.Params.Metadata.builder()
                                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                    .build()
                            )
                            .addStopSequence("string")
                            .stream(true)
                            .systemOfRequestTextBlocks(
                                listOf(
                                    MessageBatchCreateParams.Request.Params.System.RequestTextBlock
                                        .builder()
                                        .text("Today's date is 2024-06-01.")
                                        .type(
                                            MessageBatchCreateParams.Request.Params.System
                                                .RequestTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .cacheControl(
                                            MessageBatchCreateParams.Request.Params.System
                                                .RequestTextBlock
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.System
                                                        .RequestTextBlock
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .addCitation(
                                            MessageBatchCreateParams.Request.Params.System
                                                .RequestTextBlock
                                                .Citation
                                                .RequestCharLocationCitation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("x")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.System
                                                        .RequestTextBlock
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
                                MessageBatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto
                                    .builder()
                                    .type(
                                        MessageBatchCreateParams.Request.Params.ToolChoice
                                            .ToolChoiceAuto
                                            .Type
                                            .AUTO
                                    )
                                    .disableParallelToolUse(true)
                                    .build()
                            )
                            .addTool(
                                MessageBatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                    .inputSchema(
                                        MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                            .InputSchema
                                            .builder()
                                            .type(
                                                MessageBatchCreateParams.Request.Params.Tool
                                                    .InnerTool
                                                    .InputSchema
                                                    .Type
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
                                        MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                            .CacheControl
                                            .builder()
                                            .type(
                                                MessageBatchCreateParams.Request.Params.Tool
                                                    .InnerTool
                                                    .CacheControl
                                                    .Type
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
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            MessageBatchCreateParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addRequest(
                    MessageBatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchCreateParams.Request.Params.Message.Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    MessageBatchCreateParams.Request.Params.Metadata.builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfRequestTextBlocks(
                                    listOf(
                                        MessageBatchCreateParams.Request.Params.System
                                            .RequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                MessageBatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                MessageBatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        MessageBatchCreateParams.Request.Params
                                                            .System
                                                            .RequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                MessageBatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .Citation
                                                    .RequestCharLocationCitation
                                                    .builder()
                                                    .citedText("cited_text")
                                                    .documentIndex(0L)
                                                    .documentTitle("x")
                                                    .endCharIndex(0L)
                                                    .startCharIndex(0L)
                                                    .type(
                                                        MessageBatchCreateParams.Request.Params
                                                            .System
                                                            .RequestTextBlock
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
                                    MessageBatchCreateParams.Request.Params.ToolChoice
                                        .ToolChoiceAuto
                                        .builder()
                                        .type(
                                            MessageBatchCreateParams.Request.Params.ToolChoice
                                                .ToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    MessageBatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                        .inputSchema(
                                            MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.Tool
                                                        .InnerTool
                                                        .InputSchema
                                                        .Type
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
                                            MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.Tool
                                                        .InnerTool
                                                        .CacheControl
                                                        .Type
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
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.requests())
            .isEqualTo(
                listOf(
                    MessageBatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchCreateParams.Request.Params.Message.Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    MessageBatchCreateParams.Request.Params.Metadata.builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfRequestTextBlocks(
                                    listOf(
                                        MessageBatchCreateParams.Request.Params.System
                                            .RequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                MessageBatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                MessageBatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        MessageBatchCreateParams.Request.Params
                                                            .System
                                                            .RequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                MessageBatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .Citation
                                                    .RequestCharLocationCitation
                                                    .builder()
                                                    .citedText("cited_text")
                                                    .documentIndex(0L)
                                                    .documentTitle("x")
                                                    .endCharIndex(0L)
                                                    .startCharIndex(0L)
                                                    .type(
                                                        MessageBatchCreateParams.Request.Params
                                                            .System
                                                            .RequestTextBlock
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
                                    MessageBatchCreateParams.Request.Params.ToolChoice
                                        .ToolChoiceAuto
                                        .builder()
                                        .type(
                                            MessageBatchCreateParams.Request.Params.ToolChoice
                                                .ToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    MessageBatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                        .inputSchema(
                                            MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.Tool
                                                        .InnerTool
                                                        .InputSchema
                                                        .Type
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
                                            MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.Tool
                                                        .InnerTool
                                                        .CacheControl
                                                        .Type
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
                        .build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MessageBatchCreateParams.builder()
                .addRequest(
                    MessageBatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchCreateParams.Request.Params.Message.Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.requests())
            .isEqualTo(
                listOf(
                    MessageBatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchCreateParams.Request.Params.Message.Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .build()
                        )
                        .build()
                )
            )
    }
}
