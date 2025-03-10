// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.MessageBatchesBetaTrueCreateParams
import me.elborai.api.models.MessageBatchesBetaTrueListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BatchesBetaTrueServiceTest {

    @Test
    fun create() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchesBetaTrueService = client.messages().batchesBetaTrue()

        val batchesBetaTrue =
            batchesBetaTrueService.create(
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
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .System
                                                        .BetaRequestTextBlock
                                                        .Type
                                                        .TEXT
                                                )
                                                .cacheControl(
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
                                                        .System
                                                        .BetaRequestTextBlock
                                                        .CacheControl
                                                        .builder()
                                                        .type(
                                                            MessageBatchesBetaTrueCreateParams
                                                                .Request
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
                                                    MessageBatchesBetaTrueCreateParams.Request
                                                        .Params
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
                                                            MessageBatchesBetaTrueCreateParams
                                                                .Request
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
                                        MessageBatchesBetaTrueCreateParams.Request.Params.Tool
                                            .BetaTool
                                            .builder()
                                            .inputSchema(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .Tool
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
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .Tool
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
                                            .description(
                                                "Get the current weather in a given location"
                                            )
                                            .type(
                                                MessageBatchesBetaTrueCreateParams.Request.Params
                                                    .Tool
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
            )

        batchesBetaTrue.validate()
    }

    @Test
    fun list() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchesBetaTrueService = client.messages().batchesBetaTrue()

        val batchesBetaTrue =
            batchesBetaTrueService.list(
                MessageBatchesBetaTrueListParams.builder()
                    .afterId("after_id")
                    .beforeId("before_id")
                    .limit(1L)
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batchesBetaTrue.validate()
    }
}
