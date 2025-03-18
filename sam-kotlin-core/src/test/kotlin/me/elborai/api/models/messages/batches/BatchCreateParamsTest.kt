// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCreateParamsTest {

    @Test
    fun create() {
        BatchCreateParams.builder()
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .addRequest(
                BatchCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        BatchCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                BatchCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(BatchCreateParams.Request.Params.Message.Role.USER)
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .metadata(
                                BatchCreateParams.Request.Params.Metadata.builder()
                                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                    .build()
                            )
                            .addStopSequence("string")
                            .stream(true)
                            .systemOfRequestTextBlocks(
                                listOf(
                                    BatchCreateParams.Request.Params.System.RequestTextBlock
                                        .builder()
                                        .text("Today's date is 2024-06-01.")
                                        .type(
                                            BatchCreateParams.Request.Params.System.RequestTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .cacheControl(
                                            BatchCreateParams.Request.Params.System.RequestTextBlock
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchCreateParams.Request.Params.System
                                                        .RequestTextBlock
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .addCitation(
                                            BatchCreateParams.Request.Params.System.RequestTextBlock
                                                .Citation
                                                .RequestCharLocationCitation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("x")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .type(
                                                    BatchCreateParams.Request.Params.System
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
                                BatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto.builder()
                                    .type(
                                        BatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto
                                            .Type
                                            .AUTO
                                    )
                                    .disableParallelToolUse(true)
                                    .build()
                            )
                            .addTool(
                                BatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                    .inputSchema(
                                        BatchCreateParams.Request.Params.Tool.InnerTool.InputSchema
                                            .builder()
                                            .type(
                                                BatchCreateParams.Request.Params.Tool.InnerTool
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
                                        BatchCreateParams.Request.Params.Tool.InnerTool.CacheControl
                                            .builder()
                                            .type(
                                                BatchCreateParams.Request.Params.Tool.InnerTool
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
    fun headers() {
        val params =
            BatchCreateParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addRequest(
                    BatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(BatchCreateParams.Request.Params.Message.Role.USER)
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    BatchCreateParams.Request.Params.Metadata.builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfRequestTextBlocks(
                                    listOf(
                                        BatchCreateParams.Request.Params.System.RequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                BatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                BatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        BatchCreateParams.Request.Params.System
                                                            .RequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                BatchCreateParams.Request.Params.System
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
                                                        BatchCreateParams.Request.Params.System
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
                                    BatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto
                                        .builder()
                                        .type(
                                            BatchCreateParams.Request.Params.ToolChoice
                                                .ToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    BatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                        .inputSchema(
                                            BatchCreateParams.Request.Params.Tool.InnerTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    BatchCreateParams.Request.Params.Tool.InnerTool
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
                                            BatchCreateParams.Request.Params.Tool.InnerTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchCreateParams.Request.Params.Tool.InnerTool
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
            BatchCreateParams.builder()
                .addRequest(
                    BatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(BatchCreateParams.Request.Params.Message.Role.USER)
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
            BatchCreateParams.builder()
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .addRequest(
                    BatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(BatchCreateParams.Request.Params.Message.Role.USER)
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .metadata(
                                    BatchCreateParams.Request.Params.Metadata.builder()
                                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                        .build()
                                )
                                .addStopSequence("string")
                                .stream(true)
                                .systemOfRequestTextBlocks(
                                    listOf(
                                        BatchCreateParams.Request.Params.System.RequestTextBlock
                                            .builder()
                                            .text("Today's date is 2024-06-01.")
                                            .type(
                                                BatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .Type
                                                    .TEXT
                                            )
                                            .cacheControl(
                                                BatchCreateParams.Request.Params.System
                                                    .RequestTextBlock
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        BatchCreateParams.Request.Params.System
                                                            .RequestTextBlock
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .addCitation(
                                                BatchCreateParams.Request.Params.System
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
                                                        BatchCreateParams.Request.Params.System
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
                                    BatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto
                                        .builder()
                                        .type(
                                            BatchCreateParams.Request.Params.ToolChoice
                                                .ToolChoiceAuto
                                                .Type
                                                .AUTO
                                        )
                                        .disableParallelToolUse(true)
                                        .build()
                                )
                                .addTool(
                                    BatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                        .inputSchema(
                                            BatchCreateParams.Request.Params.Tool.InnerTool
                                                .InputSchema
                                                .builder()
                                                .type(
                                                    BatchCreateParams.Request.Params.Tool.InnerTool
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
                                            BatchCreateParams.Request.Params.Tool.InnerTool
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchCreateParams.Request.Params.Tool.InnerTool
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
            .containsExactly(
                BatchCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        BatchCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                BatchCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(BatchCreateParams.Request.Params.Message.Role.USER)
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .metadata(
                                BatchCreateParams.Request.Params.Metadata.builder()
                                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                    .build()
                            )
                            .addStopSequence("string")
                            .stream(true)
                            .systemOfRequestTextBlocks(
                                listOf(
                                    BatchCreateParams.Request.Params.System.RequestTextBlock
                                        .builder()
                                        .text("Today's date is 2024-06-01.")
                                        .type(
                                            BatchCreateParams.Request.Params.System.RequestTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .cacheControl(
                                            BatchCreateParams.Request.Params.System.RequestTextBlock
                                                .CacheControl
                                                .builder()
                                                .type(
                                                    BatchCreateParams.Request.Params.System
                                                        .RequestTextBlock
                                                        .CacheControl
                                                        .Type
                                                        .EPHEMERAL
                                                )
                                                .build()
                                        )
                                        .addCitation(
                                            BatchCreateParams.Request.Params.System.RequestTextBlock
                                                .Citation
                                                .RequestCharLocationCitation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("x")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .type(
                                                    BatchCreateParams.Request.Params.System
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
                                BatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto.builder()
                                    .type(
                                        BatchCreateParams.Request.Params.ToolChoice.ToolChoiceAuto
                                            .Type
                                            .AUTO
                                    )
                                    .disableParallelToolUse(true)
                                    .build()
                            )
                            .addTool(
                                BatchCreateParams.Request.Params.Tool.InnerTool.builder()
                                    .inputSchema(
                                        BatchCreateParams.Request.Params.Tool.InnerTool.InputSchema
                                            .builder()
                                            .type(
                                                BatchCreateParams.Request.Params.Tool.InnerTool
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
                                        BatchCreateParams.Request.Params.Tool.InnerTool.CacheControl
                                            .builder()
                                            .type(
                                                BatchCreateParams.Request.Params.Tool.InnerTool
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BatchCreateParams.builder()
                .addRequest(
                    BatchCreateParams.Request.builder()
                        .customId("my-custom-id-1")
                        .params(
                            BatchCreateParams.Request.Params.builder()
                                .maxTokens(1024L)
                                .addMessage(
                                    BatchCreateParams.Request.Params.Message.builder()
                                        .content("Hello, world")
                                        .role(BatchCreateParams.Request.Params.Message.Role.USER)
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
                BatchCreateParams.Request.builder()
                    .customId("my-custom-id-1")
                    .params(
                        BatchCreateParams.Request.Params.builder()
                            .maxTokens(1024L)
                            .addMessage(
                                BatchCreateParams.Request.Params.Message.builder()
                                    .content("Hello, world")
                                    .role(BatchCreateParams.Request.Params.Message.Role.USER)
                                    .build()
                            )
                            .model("claude-3-7-sonnet-20250219")
                            .build()
                    )
                    .build()
            )
    }
}
