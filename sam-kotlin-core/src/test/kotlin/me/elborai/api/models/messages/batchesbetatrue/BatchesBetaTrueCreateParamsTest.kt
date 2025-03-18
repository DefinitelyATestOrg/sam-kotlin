// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batchesbetatrue

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchesBetaTrueCreateParamsTest {

    @Test
    fun create() {
        BatchesBetaTrueCreateParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .addRequest(
                BatchesBetaTrueCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        BatchesBetaTrueCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(
                                        BatchesBetaTrueCreateParams.Request.Params.Message.Role.USER
                                    )
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .metadata(
                                BatchesBetaTrueCreateParams.Request.Params.Metadata.builder()
                                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                    .build()
                            )
                            .addStopSequence("string")
                            .stream(true)
                            .systemOfBetaRequestTextBlocks(
                                listOf(
                                    BatchesBetaTrueCreateParams.Request.Params.System
                                        .BetaRequestTextBlock
                                        .builder()
                                        .text("Today's date is 2024-06-01.")
                                        .type(
                                            BatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .cacheControl(
                                            BatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchesBetaTrueCreateParams.Request.Params
                                                        .System
                                                        .BetaRequestTextBlock
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .addCitation(
                                            BatchesBetaTrueCreateParams.Request.Params.System
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
                                                    BatchesBetaTrueCreateParams.Request.Params
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
                                BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                    .BetaToolChoiceAuto
                                    .builder()
                                    .type(
                                        BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                            .BetaToolChoiceAuto
                                            .Type
                                            .AUTO
                                    )
                                    .disableParallelToolUse(true)
                                    .build()
                            )
                            .addTool(
                                BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool.builder()
                                    .inputSchema(
                                        BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                            .InputSchema
                                            .builder()
                                            .type(
                                                BatchesBetaTrueCreateParams.Request.Params.Tool
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
                                        BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                            .CacheControl
                                            .builder()
                                            .type(
                                                BatchesBetaTrueCreateParams.Request.Params.Tool
                                                    .BetaTool
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .description("Get the current weather in a given location")
                                    .type(
                                        BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
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
    fun headers() {
        val params =
            BatchesBetaTrueCreateParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addRequest(
                    BatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            BatchesBetaTrueCreateParams.Request.Params.Message.Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    BatchesBetaTrueCreateParams.Request.Params.Metadata.builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfBetaRequestTextBlocks(
                                    listOf(
                                        BatchesBetaTrueCreateParams.Request.Params.System
                                            .BetaRequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                BatchesBetaTrueCreateParams.Request.Params.System
                                                    .BetaRequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                BatchesBetaTrueCreateParams.Request.Params.System
                                                    .BetaRequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        BatchesBetaTrueCreateParams.Request.Params
                                                            .System
                                                            .BetaRequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                BatchesBetaTrueCreateParams.Request.Params.System
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
                                                        BatchesBetaTrueCreateParams.Request.Params
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
                                    BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                        .BetaToolChoiceAuto
                                        .builder()
                                        .type(
                                            BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                                .BetaToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                        .builder()
                                        .inputSchema(
                                            BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    BatchesBetaTrueCreateParams.Request.Params.Tool
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
                                            BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchesBetaTrueCreateParams.Request.Params.Tool
                                                        .BetaTool
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .description("Get the current weather in a given location")
                                        .type(
                                            BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
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
            BatchesBetaTrueCreateParams.builder()
                .addRequest(
                    BatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            BatchesBetaTrueCreateParams.Request.Params.Message.Role
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

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            BatchesBetaTrueCreateParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addRequest(
                    BatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            BatchesBetaTrueCreateParams.Request.Params.Message.Role
                                                .USER
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    BatchesBetaTrueCreateParams.Request.Params.Metadata.builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfBetaRequestTextBlocks(
                                    listOf(
                                        BatchesBetaTrueCreateParams.Request.Params.System
                                            .BetaRequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                BatchesBetaTrueCreateParams.Request.Params.System
                                                    .BetaRequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                BatchesBetaTrueCreateParams.Request.Params.System
                                                    .BetaRequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        BatchesBetaTrueCreateParams.Request.Params
                                                            .System
                                                            .BetaRequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                BatchesBetaTrueCreateParams.Request.Params.System
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
                                                        BatchesBetaTrueCreateParams.Request.Params
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
                                    BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                        .BetaToolChoiceAuto
                                        .builder()
                                        .type(
                                            BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                                .BetaToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                        .builder()
                                        .inputSchema(
                                            BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    BatchesBetaTrueCreateParams.Request.Params.Tool
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
                                            BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchesBetaTrueCreateParams.Request.Params.Tool
                                                        .BetaTool
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .description("Get the current weather in a given location")
                                        .type(
                                            BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
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
            .containsExactly(
                BatchesBetaTrueCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        BatchesBetaTrueCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(
                                        BatchesBetaTrueCreateParams.Request.Params.Message.Role.USER
                                    )
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .metadata(
                                BatchesBetaTrueCreateParams.Request.Params.Metadata.builder()
                                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                    .build()
                            )
                            .addStopSequence("string")
                            .stream(true)
                            .systemOfBetaRequestTextBlocks(
                                listOf(
                                    BatchesBetaTrueCreateParams.Request.Params.System
                                        .BetaRequestTextBlock
                                        .builder()
                                        .text("Today's date is 2024-06-01.")
                                        .type(
                                            BatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .cacheControl(
                                            BatchesBetaTrueCreateParams.Request.Params.System
                                                .BetaRequestTextBlock
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchesBetaTrueCreateParams.Request.Params
                                                        .System
                                                        .BetaRequestTextBlock
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .addCitation(
                                            BatchesBetaTrueCreateParams.Request.Params.System
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
                                                    BatchesBetaTrueCreateParams.Request.Params
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
                                BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                    .BetaToolChoiceAuto
                                    .builder()
                                    .type(
                                        BatchesBetaTrueCreateParams.Request.Params.ToolChoice
                                            .BetaToolChoiceAuto
                                            .Type
                                            .AUTO
                                    )
                                    .disableParallelToolUse(true)
                                    .build()
                            )
                            .addTool(
                                BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool.builder()
                                    .inputSchema(
                                        BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                            .InputSchema
                                            .builder()
                                            .type(
                                                BatchesBetaTrueCreateParams.Request.Params.Tool
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
                                        BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
                                            .CacheControl
                                            .builder()
                                            .type(
                                                BatchesBetaTrueCreateParams.Request.Params.Tool
                                                    .BetaTool
                                                    .CacheControl
                                                    .Type
                                                    .EPHEMERAL
                                            )
                                            .build()
                                    )
                                    .description("Get the current weather in a given location")
                                    .type(
                                        BatchesBetaTrueCreateParams.Request.Params.Tool.BetaTool
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BatchesBetaTrueCreateParams.builder()
                .addRequest(
                    BatchesBetaTrueCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchesBetaTrueCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(
                                            BatchesBetaTrueCreateParams.Request.Params.Message.Role
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
            .containsExactly(
                BatchesBetaTrueCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        BatchesBetaTrueCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                BatchesBetaTrueCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(
                                        BatchesBetaTrueCreateParams.Request.Params.Message.Role.USER
                                    )
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .build()
                    )
                    .build()
            )
    }
}
