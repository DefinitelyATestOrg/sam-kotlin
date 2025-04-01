// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.JsonValue
import me.elborai.api.models.messages.batches.BatchCancelBetaParams
import me.elborai.api.models.messages.batches.BatchCancelParams
import me.elborai.api.models.messages.batches.BatchCreateParams
import me.elborai.api.models.messages.batches.BatchDeleteParams
import me.elborai.api.models.messages.batches.BatchListParams
import me.elborai.api.models.messages.batches.BatchResultsBetaParams
import me.elborai.api.models.messages.batches.BatchResultsParams
import me.elborai.api.models.messages.batches.BatchRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BatchServiceTest {

    @Test
    fun create() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val batch =
            batchService.create(
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
                                            .role(
                                                BatchCreateParams.Request.Params.Message.Role.USER
                                            )
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
                                                        BatchCreateParams.Request.Params.Tool
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
                                                BatchCreateParams.Request.Params.Tool.InnerTool
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        BatchCreateParams.Request.Params.Tool
                                                            .InnerTool
                                                            .CacheControl
                                                            .Type
                                                            .EPHEMERAL
                                                    )
                                                    .build()
                                            )
                                            .description(
                                                "Get the current weather in a given location"
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

        batch.validate()
    }

    @Test
    fun retrieve() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val batch =
            batchService.retrieve(
                BatchRetrieveParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batch.validate()
    }

    @Test
    fun list() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val batches =
            batchService.list(
                BatchListParams.builder()
                    .afterId("after_id")
                    .beforeId("before_id")
                    .limit(1L)
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batches.validate()
    }

    @Test
    fun delete() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val batch =
            batchService.delete(
                BatchDeleteParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batch.validate()
    }

    @Test
    fun cancel() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val response =
            batchService.cancel(
                BatchCancelParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        response.validate()
    }

    @Test
    fun cancelBeta() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val response =
            batchService.cancelBeta(
                BatchCancelBetaParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism doesn't support JSONL responses yet")
    @Test
    fun resultsStreaming() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val responseStreamResponse =
            batchService.resultsStreaming(
                BatchResultsParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        responseStreamResponse.use {
            responseStreamResponse.asSequence().forEach { response -> response.validate() }
        }
    }

    @Disabled("Prism doesn't support JSONL responses yet")
    @Test
    fun resultsBetaStreaming() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchService = client.messages().batches()

        val responseStreamResponse =
            batchService.resultsBetaStreaming(
                BatchResultsBetaParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        responseStreamResponse.use {
            responseStreamResponse.asSequence().forEach { response -> response.validate() }
        }
    }
}
