// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchesBetaTrueCreateParamsTest {

    @Test
    fun create() {
        MessageBatchesBetaTrueCreateParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .addRequest(
                MessageBatchesBetaTrueCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        MessageBatchesBetaTrueCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                MessageBatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(
                                        MessageBatchesBetaTrueCreateParams.Request.Params.Message
                                            .Role
                                            .USER
                                    )
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .metadata(
                                MessageBatchesBetaTrueCreateParams.Request.Params.Metadata.builder()
                                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                    .build()
                            )
                            .addStopSequence("string")
                            .stream(true)
                            .systemOfBetaRequestTextBlocks(
                                listOf(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.System
                                        .BetaRequestTextBlock
                                        .builder()
                                        .text("Today's date is 2024-06-01.")
                                        .type(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .cacheControl(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .System
                                                        .BetaRequestTextBlock
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .addCitation(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .Citation
                                                .BetaRequestCharLocationCitation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("x")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .type(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .System
                                                        .BetaRequestTextBlock
                                                        .Citation
                                                        .BetaRequestCharLocationCitation
                                                        .Type
                                                        .CHAR_LOCATION
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                            )
                            .temperature(1.0)
                            .betaThinkingConfigEnabledThinking(1024L)
                            .toolChoice(
                                MessageBatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                    .BetaToolChoiceAuto
                                    .builder()
                                    .type(
                                        MessageBatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                            .BetaToolChoiceAuto
                                            .Type
                                            .AUTO
                                    )
                                    .disableParallelToolUse(true)
                                    .build()
                            )
                            .addTool(
                                MessageBatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                    .builder()
                                    .inputSchema(
                                        MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                            .BetaTool
                                            .InputSchema
                                            .builder()
                                            .type(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .Tool
                                                    .BetaTool
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
                                        MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                            .BetaTool
                                            .CacheControl
                                            .builder()
                                            .type(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .Tool
                                                    .BetaTool
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .description("Get the current weather in a given location")
                                    .type(
                                        MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                            .BetaTool
                                            .Type
                                            .CUSTOM
                                    )
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
            MessageBatchesBetaTrueCreateParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addRequest(
                    MessageBatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Message
                                        .builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchesBetaTrueCreateParams.Request.Params
                                                .Message
                                                .Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Metadata
                                        .builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfBetaRequestTextBlocks(
                                    listOf(
                                        MessageBatchesBetaTrueCreateParams.Request.Params.System
                                            .BetaRequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .System
                                                    .BetaRequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .System
                                                    .BetaRequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        MessageBatchesBetaTrueCreateParams.Request
                                                            .Params
                                                            .System
                                                            .BetaRequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .System
                                                    .BetaRequestTextBlock
                                                    .Citation
                                                    .BetaRequestCharLocationCitation
                                                    .builder()
                                                    .citedText("cited_text")
                                                    .documentIndex(0L)
                                                    .documentTitle("x")
                                                    .endCharIndex(0L)
                                                    .startCharIndex(0L)
                                                    .type(
                                                        MessageBatchesBetaTrueCreateParams.Request
                                                            .Params
                                                            .System
                                                            .BetaRequestTextBlock
                                                            .Citation
                                                            .BetaRequestCharLocationCitation
                                                            .Type
                                                            .CHAR_LOCATION
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                )
                                .temperature(1.0)
                                .betaThinkingConfigEnabledThinking(1024L)
                                .toolChoice(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                        .BetaToolChoiceAuto
                                        .builder()
                                        .type(
                                            MessageBatchesBetaTrueCreateParams.Request.Params
                                                .ToolChoice
                                                .BetaToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                        .builder()
                                        .inputSchema(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                                .BetaTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .Tool
                                                        .BetaTool
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
                                            MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                                .BetaTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .Tool
                                                        .BetaTool
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .description("Get the current weather in a given location")
                                        .type(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                                .BetaTool
                                                .Type
                                                .CUSTOM
                                        )
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
                    MessageBatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Message
                                        .builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchesBetaTrueCreateParams.Request.Params
                                                .Message
                                                .Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Metadata
                                        .builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfBetaRequestTextBlocks(
                                    listOf(
                                        MessageBatchesBetaTrueCreateParams.Request.Params.System
                                            .BetaRequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .System
                                                    .BetaRequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .System
                                                    .BetaRequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        MessageBatchesBetaTrueCreateParams.Request
                                                            .Params
                                                            .System
                                                            .BetaRequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .System
                                                    .BetaRequestTextBlock
                                                    .Citation
                                                    .BetaRequestCharLocationCitation
                                                    .builder()
                                                    .citedText("cited_text")
                                                    .documentIndex(0L)
                                                    .documentTitle("x")
                                                    .endCharIndex(0L)
                                                    .startCharIndex(0L)
                                                    .type(
                                                        MessageBatchesBetaTrueCreateParams.Request
                                                            .Params
                                                            .System
                                                            .BetaRequestTextBlock
                                                            .Citation
                                                            .BetaRequestCharLocationCitation
                                                            .Type
                                                            .CHAR_LOCATION
                                                    )
                                                    .build()
                                            )
                                            .build()
                                    )
                                )
                                .temperature(1.0)
                                .betaThinkingConfigEnabledThinking(1024L)
                                .toolChoice(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                        .BetaToolChoiceAuto
                                        .builder()
                                        .type(
                                            MessageBatchesBetaTrueCreateParams.Request.Params
                                                .ToolChoice
                                                .BetaToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                        .builder()
                                        .inputSchema(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                                .BetaTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .Tool
                                                        .BetaTool
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
                                            MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                                .BetaTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .Tool
                                                        .BetaTool
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .description("Get the current weather in a given location")
                                        .type(
                                            MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                                .BetaTool
                                                .Type
                                                .CUSTOM
                                        )
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
            MessageBatchesBetaTrueCreateParams.builder()
                .addRequest(
                    MessageBatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Message
                                        .builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchesBetaTrueCreateParams.Request.Params
                                                .Message
                                                .Role
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
                    MessageBatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            MessageBatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    MessageBatchesBetaTrueCreateParams.Request.Params.Message
                                        .builder()
                                        .content("Hello, world")
                                        .role(
                                            MessageBatchesBetaTrueCreateParams.Request.Params
                                                .Message
                                                .Role
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
