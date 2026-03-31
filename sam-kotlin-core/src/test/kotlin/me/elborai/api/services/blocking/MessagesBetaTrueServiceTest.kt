// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.messagesbetatrue.MessagesBetaTrueCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessagesBetaTrueServiceTest {

    @Test
    fun create() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messagesBetaTrueService = client.messagesBetaTrue()

        val messagesBetaTrue =
            messagesBetaTrueService.create(
                MessagesBetaTrueCreateParams.builder()
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .maxTokens(1024L)
                    .addMessage(
                        MessagesBetaTrueCreateParams.Message.builder()
                            .content("Hello, world")
                            .role(MessagesBetaTrueCreateParams.Message.Role.USER)
                            .build()
                    )
                    .model("claude-3-7-sonnet-20250219")
                    .metadata(
                        MessagesBetaTrueCreateParams.Metadata.builder()
                            .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                            .build()
                    )
                    .addStopSequence("string")
                    .stream(true)
                    .systemOfBetaRequestTextBlocks(
                        listOf(
                            MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.builder()
                                .text("Today's date is 2024-06-01.")
                                .cacheControl(
                                    MessagesBetaTrueCreateParams.System.BetaRequestTextBlock
                                        .CacheControl
                                        .builder()
                                        .build()
                                )
                                .addCitation(
                                    MessagesBetaTrueCreateParams.System.BetaRequestTextBlock
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
                    .temperature(1.0)
                    .enabledThinking(1024L)
                    .toolChoice(
                        MessagesBetaTrueCreateParams.ToolChoice.Auto.builder()
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        MessagesBetaTrueCreateParams.Tool.BetaTool.builder()
                            .inputSchema(
                                MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.builder()
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
                                MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.builder()
                                    .build()
                            )
                            .description("Get the current weather in a given location")
                            .type(MessagesBetaTrueCreateParams.Tool.BetaTool.Type.CUSTOM)
                            .build()
                    )
                    .topK(5L)
                    .topP(0.7)
                    .build()
            )

        messagesBetaTrue.validate()
    }
}
