// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.MessageCreateParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
internal class ServiceParamsTest {

    private lateinit var client: SamClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun create() {
        val messageService = client.messages()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                            .type(MessageCreateParams.System.RequestTextBlock.Type.TEXT)
                            .cacheControl(
                                MessageCreateParams.System.RequestTextBlock.CacheControl.builder()
                                    .type(
                                        MessageCreateParams.System.RequestTextBlock.CacheControl
                                            .Type
                                            .EPHEMERAL
                                    )
                                    .build()
                            )
                            .addCitation(
                                MessageCreateParams.System.RequestTextBlock.Citation
                                    .RequestCharLocationCitation
                                    .builder()
                                    .citedText("cited_text")
                                    .documentIndex(0L)
                                    .documentTitle("x")
                                    .endCharIndex(0L)
                                    .startCharIndex(0L)
                                    .type(
                                        MessageCreateParams.System.RequestTextBlock.Citation
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
                    MessageCreateParams.ToolChoice.ToolChoiceAuto.builder()
                        .type(MessageCreateParams.ToolChoice.ToolChoiceAuto.Type.AUTO)
                        .disableParallelToolUse(true)
                        .build()
                )
                .addTool(
                    MessageCreateParams.Tool.InnerTool.builder()
                        .inputSchema(
                            MessageCreateParams.Tool.InnerTool.InputSchema.builder()
                                .type(MessageCreateParams.Tool.InnerTool.InputSchema.Type.OBJECT)
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
                            MessageCreateParams.Tool.InnerTool.CacheControl.builder()
                                .type(
                                    MessageCreateParams.Tool.InnerTool.CacheControl.Type.EPHEMERAL
                                )
                                .build()
                        )
                        .description("Get the current weather in a given location")
                        .build()
                )
                .topK(5L)
                .topP(0.7)
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
