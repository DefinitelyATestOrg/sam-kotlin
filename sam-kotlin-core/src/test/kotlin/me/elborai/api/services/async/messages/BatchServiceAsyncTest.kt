// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.core.JsonValue
import me.elborai.api.models.MessageBatchCancelBetaParams
import me.elborai.api.models.MessageBatchCancelParams
import me.elborai.api.models.MessageBatchCreateParams
import me.elborai.api.models.MessageBatchDeleteParams
import me.elborai.api.models.MessageBatchListParams
import me.elborai.api.models.MessageBatchResultsBetaParams
import me.elborai.api.models.MessageBatchResultsParams
import me.elborai.api.models.MessageBatchRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BatchServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val batch =
            batchServiceAsync.create(
                MessageBatchCreateParams.builder()
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .addRequest(
                        MessageBatchCreateParams.Request.builder()
                            .customId("my-custom-id-1")
                            .params(
                                MessageBatchCreateParams.Request.Params.builder()
                                    .maxTokens(1024L)
                                    .addMessage(
                                        MessageBatchCreateParams.Request.Params.Message.builder()
                                            .content("Hello, world")
                                            .role(
                                                MessageBatchCreateParams.Request.Params.Message.Role
                                                    .USER
                                            )
                                            .build()
                                    )
                                    .model("claude-3-7-sonnet-20250219")
                                    .metadata(
                                        MessageBatchCreateParams.Request.Params.Metadata.builder()
                                            .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                                            .build()
                                    )
                                    .addStopSequence("string")
                                    .stream(true)
                                    .systemOfRequestTextBlocks(
                                        listOf(
                                            MessageBatchCreateParams.Request.Params.System
                                                .RequestTextBlock
                                                .builder()
                                                .text("Today's date is 2024-06-01.")
                                                .type(
                                                    MessageBatchCreateParams.Request.Params.System
                                                        .RequestTextBlock
                                                        .Type
                                                        .TEXT
                                                )
                                                .cacheControl(
                                                    MessageBatchCreateParams.Request.Params.System
                                                        .RequestTextBlock
                                                        .CacheControl
                                                        .builder()
                                                        .type(
                                                            MessageBatchCreateParams.Request.Params
                                                                .System
                                                                .RequestTextBlock
                                                                .CacheControl
                                                                .Type
                                                                .EPHEMERAL
                                                        )
                                                        .build()
                                                )
                                                .addCitation(
                                                    MessageBatchCreateParams.Request.Params.System
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
                                                            MessageBatchCreateParams.Request.Params
                                                                .System
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
                                        MessageBatchCreateParams.Request.Params.ToolChoice
                                            .ToolChoiceAuto
                                            .builder()
                                            .type(
                                                MessageBatchCreateParams.Request.Params.ToolChoice
                                                    .ToolChoiceAuto
                                                    .Type
                                                    .AUTO
                                            )
                                            .disableParallelToolUse(true)
                                            .build()
                                    )
                                    .addTool(
                                        MessageBatchCreateParams.Request.Params.Tool.InnerTool
                                            .builder()
                                            .inputSchema(
                                                MessageBatchCreateParams.Request.Params.Tool
                                                    .InnerTool
                                                    .InputSchema
                                                    .builder()
                                                    .type(
                                                        MessageBatchCreateParams.Request.Params.Tool
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
                                                MessageBatchCreateParams.Request.Params.Tool
                                                    .InnerTool
                                                    .CacheControl
                                                    .builder()
                                                    .type(
                                                        MessageBatchCreateParams.Request.Params.Tool
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
    suspend fun retrieve() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val batch =
            batchServiceAsync.retrieve(
                MessageBatchRetrieveParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batch.validate()
    }

    @Test
    suspend fun list() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val batch =
            batchServiceAsync.list(
                MessageBatchListParams.builder()
                    .afterId("after_id")
                    .beforeId("before_id")
                    .limit(1L)
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batch.validate()
    }

    @Test
    suspend fun delete() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val batch =
            batchServiceAsync.delete(
                MessageBatchDeleteParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        batch.validate()
    }

    @Test
    suspend fun cancel() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val response =
            batchServiceAsync.cancel(
                MessageBatchCancelParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        response.validate()
    }

    @Test
    suspend fun cancelBeta() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val response =
            batchServiceAsync.cancelBeta(
                MessageBatchCancelBetaParams.builder()
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
    suspend fun results() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val response =
            batchServiceAsync.results(
                MessageBatchResultsParams.builder()
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
    suspend fun resultsBeta() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val batchServiceAsync = client.messages().batches()

        val response =
            batchServiceAsync.resultsBeta(
                MessageBatchResultsBetaParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        response.validate()
    }
}
