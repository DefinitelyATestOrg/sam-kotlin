// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.MessagesBetaTrueCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessagesBetaTrueServiceTest {

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
                                .type(
                                    MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Type
                                        .TEXT
                                )
                                .cacheControl(
                                    MessagesBetaTrueCreateParams.System.BetaRequestTextBlock
                                        .CacheControl
                                        .builder()
                                        .type(
                                            MessagesBetaTrueCreateParams.System.BetaRequestTextBlock
                                                .CacheControl
                                                .Type
                                                .EPHEMERAL
                                        )
                                        .build()
                                )
                                .addCitation(
                                    MessagesBetaTrueCreateParams.System.BetaRequestTextBlock
                                        .Citation
                                        .BetaRequestCharLocationCitation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("x")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(
                                            MessagesBetaTrueCreateParams.System.BetaRequestTextBlock
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
                        MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.builder()
                            .type(
                                MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO
                            )
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        MessagesBetaTrueCreateParams.Tool.BetaTool.builder()
                            .inputSchema(
                                MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.builder()
                                    .type(
                                        MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.Type
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
                                MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.builder()
                                    .type(
                                        MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.Type
                                            .EPHEMERAL
                                    )
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
