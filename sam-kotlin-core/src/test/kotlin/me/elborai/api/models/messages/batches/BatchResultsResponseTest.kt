// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchResultsResponseTest {

    @Test
    fun create() {
        val batchResultsResponse =
            BatchResultsResponse.builder()
                .customId("my-custom-id-1")
                .succeededResult(
                    BatchResultsResponse.Result.Succeeded.Message.builder()
                        .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                        .addContent(
                            BatchResultsResponse.Result.Succeeded.Message.Content.Text.builder()
                                .addCitation(
                                    BatchResultsResponse.Result.Succeeded.Message.Content.Text
                                        .Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("document_title")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(
                                            BatchResultsResponse.Result.Succeeded.Message.Content
                                                .Text
                                                .Citation
                                                .CharLocation
                                                .Type
                                                .CHAR_LOCATION
                                        )
                                        .build()
                                )
                                .text("Hi! My name is Claude.")
                                .type(
                                    BatchResultsResponse.Result.Succeeded.Message.Content.Text.Type
                                        .TEXT
                                )
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .role(BatchResultsResponse.Result.Succeeded.Message.Role.ASSISTANT)
                        .stopReason(
                            BatchResultsResponse.Result.Succeeded.Message.StopReason.END_TURN
                        )
                        .stopSequence(null)
                        .type(BatchResultsResponse.Result.Succeeded.Message.Type.MESSAGE)
                        .usage(
                            BatchResultsResponse.Result.Succeeded.Message.Usage.builder()
                                .cacheCreationInputTokens(2051L)
                                .cacheReadInputTokens(2051L)
                                .inputTokens(2095L)
                                .outputTokens(503L)
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(batchResultsResponse.customId()).isEqualTo("my-custom-id-1")
        assertThat(batchResultsResponse.result())
            .isEqualTo(
                BatchResultsResponse.Result.ofSucceeded(
                    BatchResultsResponse.Result.Succeeded.builder()
                        .message(
                            BatchResultsResponse.Result.Succeeded.Message.builder()
                                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                                .addContent(
                                    BatchResultsResponse.Result.Succeeded.Message.Content.Text
                                        .builder()
                                        .addCitation(
                                            BatchResultsResponse.Result.Succeeded.Message.Content
                                                .Text
                                                .Citation
                                                .CharLocation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("document_title")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .type(
                                                    BatchResultsResponse.Result.Succeeded.Message
                                                        .Content
                                                        .Text
                                                        .Citation
                                                        .CharLocation
                                                        .Type
                                                        .CHAR_LOCATION
                                                )
                                                .build()
                                        )
                                        .text("Hi! My name is Claude.")
                                        .type(
                                            BatchResultsResponse.Result.Succeeded.Message.Content
                                                .Text
                                                .Type
                                                .TEXT
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .role(BatchResultsResponse.Result.Succeeded.Message.Role.ASSISTANT)
                                .stopReason(
                                    BatchResultsResponse.Result.Succeeded.Message.StopReason
                                        .END_TURN
                                )
                                .stopSequence(null)
                                .type(BatchResultsResponse.Result.Succeeded.Message.Type.MESSAGE)
                                .usage(
                                    BatchResultsResponse.Result.Succeeded.Message.Usage.builder()
                                        .cacheCreationInputTokens(2051L)
                                        .cacheReadInputTokens(2051L)
                                        .inputTokens(2095L)
                                        .outputTokens(503L)
                                        .build()
                                )
                                .build()
                        )
                        .type(BatchResultsResponse.Result.Succeeded.Type.SUCCEEDED)
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchResultsResponse =
            BatchResultsResponse.builder()
                .customId("my-custom-id-1")
                .succeededResult(
                    BatchResultsResponse.Result.Succeeded.Message.builder()
                        .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                        .addContent(
                            BatchResultsResponse.Result.Succeeded.Message.Content.Text.builder()
                                .addCitation(
                                    BatchResultsResponse.Result.Succeeded.Message.Content.Text
                                        .Citation
                                        .CharLocation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("document_title")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(
                                            BatchResultsResponse.Result.Succeeded.Message.Content
                                                .Text
                                                .Citation
                                                .CharLocation
                                                .Type
                                                .CHAR_LOCATION
                                        )
                                        .build()
                                )
                                .text("Hi! My name is Claude.")
                                .type(
                                    BatchResultsResponse.Result.Succeeded.Message.Content.Text.Type
                                        .TEXT
                                )
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .role(BatchResultsResponse.Result.Succeeded.Message.Role.ASSISTANT)
                        .stopReason(
                            BatchResultsResponse.Result.Succeeded.Message.StopReason.END_TURN
                        )
                        .stopSequence(null)
                        .type(BatchResultsResponse.Result.Succeeded.Message.Type.MESSAGE)
                        .usage(
                            BatchResultsResponse.Result.Succeeded.Message.Usage.builder()
                                .cacheCreationInputTokens(2051L)
                                .cacheReadInputTokens(2051L)
                                .inputTokens(2095L)
                                .outputTokens(503L)
                                .build()
                        )
                        .build()
                )
                .build()

        val roundtrippedBatchResultsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchResultsResponse),
                jacksonTypeRef<BatchResultsResponse>(),
            )

        assertThat(roundtrippedBatchResultsResponse).isEqualTo(batchResultsResponse)
    }
}
