// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.samplopplop.SamPlopPlopCreateMessageParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SamPlopPlopServiceTest {

    @Test
    fun createMessage() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val samPlopPlopService = client.samPlopPlop()

        val response =
            samPlopPlopService.createMessage(
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
                                .type(
                                    SamPlopPlopCreateMessageParams.System.RequestTextBlock.Type.TEXT
                                )
                                .cacheControl(
                                    SamPlopPlopCreateMessageParams.System.RequestTextBlock
                                        .CacheControl
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
                            .type(
                                SamPlopPlopCreateMessageParams.ToolChoice.ToolChoiceAuto.Type.AUTO
                            )
                            .disableParallelToolUse(true)
                            .build()
                    )
                    .addTool(
                        SamPlopPlopCreateMessageParams.Tool.InnerTool.builder()
                            .inputSchema(
                                SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema.builder()
                                    .type(
                                        SamPlopPlopCreateMessageParams.Tool.InnerTool.InputSchema
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
                                SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl.builder()
                                    .type(
                                        SamPlopPlopCreateMessageParams.Tool.InnerTool.CacheControl
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

        response.validate()
    }
}
