// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.messages.MessageCountTokensBetaParams
import me.elborai.api.models.messages.MessageCountTokensParams
import me.elborai.api.models.messages.MessageCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceTest {

    @Test
    fun create() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val message =
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
                                .cacheControl(
                                    MessageCreateParams.System.RequestTextBlock.CacheControl
                                        .builder()
                                        .build()
                                )
                                .addCitation(
                                    MessageCreateParams.System.RequestTextBlock.Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .temperature(1.0)
                    .enabledThinking(1024L)
                    .toolChoice(
                        MessageCreateParams.ToolChoice.Auto.builder()
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        MessageCreateParams.Tool.InnerTool.builder()
                            .inputSchema(
                                MessageCreateParams.Tool.InnerTool.InputSchema.builder()
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
                                MessageCreateParams.Tool.InnerTool.CacheControl.builder().build()
                            )
                            .description("Get the current weather in a given location")
                            .build()
                    )
                    .topK(5L)
                    .topP(0.7)
                    .build()
            )

        message.validate()
    }

    @Test
    fun countTokens() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response =
            messageService.countTokens(
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
                                .cacheControl(
                                    MessageCountTokensParams.System.RequestTextBlock.CacheControl
                                        .builder()
                                        .build()
                                )
                                .addCitation(
                                    MessageCountTokensParams.System.RequestTextBlock.Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .enabledThinking(1024L)
                    .toolChoice(
                        MessageCountTokensParams.ToolChoice.Auto.builder()
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        MessageCountTokensParams.Tool.InnerTool.builder()
                            .inputSchema(
                                MessageCountTokensParams.Tool.InnerTool.InputSchema.builder()
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
                                    .build()
                            )
                            .description("Get the current weather in a given location")
                            .build()
                    )
                    .build()
            )

        response.validate()
    }

    @Test
    fun countTokensBeta() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.messages()

        val response =
            messageService.countTokensBeta(
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
                                .cacheControl(
                                    MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                        .CacheControl
                                        .builder()
                                        .build()
                                )
                                .addCitation(
                                    MessageCountTokensBetaParams.System.BetaRequestTextBlock
                                        .Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .build()
                                )
                                .build()
                        )
                    )
                    .enabledThinking(1024L)
                    .toolChoice(
                        MessageCountTokensBetaParams.ToolChoice.Auto.builder()
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        MessageCountTokensBetaParams.Tool.BetaTool.builder()
                            .inputSchema(
                                MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
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
                                    .build()
                            )
                            .description("Get the current weather in a given location")
                            .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
                            .build()
                    )
                    .build()
            )

        response.validate()
    }
}
