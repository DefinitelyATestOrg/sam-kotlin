// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchResultsBetaResponseTest {

    @Test
    fun create() {
        val batchResultsBetaResponse =
            BatchResultsBetaResponse.builder()
                .customId("my-custom-id-1")
                .succeededResult(
                    BatchResultsBetaResponse.Result.Succeeded.Message.builder()
                        .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                        .addContent(
                            BatchResultsBetaResponse.Result.Succeeded.Message.Content.Text.builder()
                                .addCitation(
                                    BatchResultsBetaResponse.Result.Succeeded.Message.Content.Text
                                        .Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("document_title")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .build()
                                )
                                .text("Hi! My name is Claude.")
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .stopReason(
                            BatchResultsBetaResponse.Result.Succeeded.Message.StopReason.END_TURN
                        )
                        .stopSequence(null)
                        .usage(
                            BatchResultsBetaResponse.Result.Succeeded.Message.Usage.builder()
                                .cacheCreationInputTokens(2051L)
                                .cacheReadInputTokens(2051L)
                                .inputTokens(2095L)
                                .outputTokens(503L)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(batchResultsBetaResponse.customId()).isEqualTo("my-custom-id-1")
        assertThat(batchResultsBetaResponse.result())
            .isEqualTo(
                BatchResultsBetaResponse.Result.ofSucceeded(
                    BatchResultsBetaResponse.Result.Succeeded.builder()
                        .message(
                            BatchResultsBetaResponse.Result.Succeeded.Message.builder()
                                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                                .addContent(
                                    BatchResultsBetaResponse.Result.Succeeded.Message.Content.Text
                                        .builder()
                                        .addCitation(
                                            BatchResultsBetaResponse.Result.Succeeded.Message
                                                .Content
                                                .Text
                                                .Citation
                                                .CharLocation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("document_title")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .build()
                                        )
                                        .text("Hi! My name is Claude.")
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .stopReason(
                                    BatchResultsBetaResponse.Result.Succeeded.Message.StopReason
                                        .END_TURN
                                )
                                .stopSequence(null)
                                .usage(
                                    BatchResultsBetaResponse.Result.Succeeded.Message.Usage
                                        .builder()
                                        .cacheCreationInputTokens(2051L)
                                        .cacheReadInputTokens(2051L)
                                        .inputTokens(2095L)
                                        .outputTokens(503L)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchResultsBetaResponse =
            BatchResultsBetaResponse.builder()
                .customId("my-custom-id-1")
                .succeededResult(
                    BatchResultsBetaResponse.Result.Succeeded.Message.builder()
                        .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                        .addContent(
                            BatchResultsBetaResponse.Result.Succeeded.Message.Content.Text.builder()
                                .addCitation(
                                    BatchResultsBetaResponse.Result.Succeeded.Message.Content.Text
                                        .Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("document_title")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .build()
                                )
                                .text("Hi! My name is Claude.")
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .stopReason(
                            BatchResultsBetaResponse.Result.Succeeded.Message.StopReason.END_TURN
                        )
                        .stopSequence(null)
                        .usage(
                            BatchResultsBetaResponse.Result.Succeeded.Message.Usage.builder()
                                .cacheCreationInputTokens(2051L)
                                .cacheReadInputTokens(2051L)
                                .inputTokens(2095L)
                                .outputTokens(503L)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedBatchResultsBetaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchResultsBetaResponse),
                jacksonTypeRef<BatchResultsBetaResponse>(),
            )

        assertThat(roundtrippedBatchResultsBetaResponse).isEqualTo(batchResultsBetaResponse)
    }
}
