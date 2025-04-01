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
                .betaSucceededResult(
                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message.builder()
                        .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                        .addContent(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Content
                                .BetaResponseTextBlock
                                .builder()
                                .addCitation(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Content
                                        .BetaResponseTextBlock
                                        .Citation
                                        .BetaResponseCharLocationCitation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("document_title")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(
                                            BatchResultsBetaResponse.Result.BetaSucceededResult
                                                .Message
                                                .Content
                                                .BetaResponseTextBlock
                                                .Citation
                                                .BetaResponseCharLocationCitation
                                                .Type
                                                .CHAR_LOCATION
                                        )
                                        .build()
                                )
                                .text("Hi! My name is Claude.")
                                .type(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Content
                                        .BetaResponseTextBlock
                                        .Type
                                        .TEXT
                                )
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .role(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Role
                                .ASSISTANT
                        )
                        .stopReason(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.StopReason
                                .END_TURN
                        )
                        .stopSequence(null)
                        .type(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Type.MESSAGE
                        )
                        .usage(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Usage
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

        assertThat(batchResultsBetaResponse.customId()).isEqualTo("my-custom-id-1")
        assertThat(batchResultsBetaResponse.result())
            .isEqualTo(
                BatchResultsBetaResponse.Result.ofBetaSucceeded(
                    BatchResultsBetaResponse.Result.BetaSucceededResult.builder()
                        .message(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.builder()
                                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                                .addContent(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Content
                                        .BetaResponseTextBlock
                                        .builder()
                                        .addCitation(
                                            BatchResultsBetaResponse.Result.BetaSucceededResult
                                                .Message
                                                .Content
                                                .BetaResponseTextBlock
                                                .Citation
                                                .BetaResponseCharLocationCitation
                                                .builder()
                                                .citedText("cited_text")
                                                .documentIndex(0L)
                                                .documentTitle("document_title")
                                                .endCharIndex(0L)
                                                .startCharIndex(0L)
                                                .type(
                                                    BatchResultsBetaResponse.Result
                                                        .BetaSucceededResult
                                                        .Message
                                                        .Content
                                                        .BetaResponseTextBlock
                                                        .Citation
                                                        .BetaResponseCharLocationCitation
                                                        .Type
                                                        .CHAR_LOCATION
                                                )
                                                .build()
                                        )
                                        .text("Hi! My name is Claude.")
                                        .type(
                                            BatchResultsBetaResponse.Result.BetaSucceededResult
                                                .Message
                                                .Content
                                                .BetaResponseTextBlock
                                                .Type
                                                .TEXT
                                        )
                                        .build()
                                )
                                .model("claude-3-7-sonnet-20250219")
                                .role(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Role
                                        .ASSISTANT
                                )
                                .stopReason(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .StopReason
                                        .END_TURN
                                )
                                .stopSequence(null)
                                .type(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Type
                                        .MESSAGE
                                )
                                .usage(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Usage
                                        .builder()
                                        .cacheCreationInputTokens(2051L)
                                        .cacheReadInputTokens(2051L)
                                        .inputTokens(2095L)
                                        .outputTokens(503L)
                                        .build()
                                )
                                .build()
                        )
                        .type(BatchResultsBetaResponse.Result.BetaSucceededResult.Type.SUCCEEDED)
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
                .betaSucceededResult(
                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message.builder()
                        .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                        .addContent(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Content
                                .BetaResponseTextBlock
                                .builder()
                                .addCitation(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Content
                                        .BetaResponseTextBlock
                                        .Citation
                                        .BetaResponseCharLocationCitation
                                        .builder()
                                        .citedText("cited_text")
                                        .documentIndex(0L)
                                        .documentTitle("document_title")
                                        .endCharIndex(0L)
                                        .startCharIndex(0L)
                                        .type(
                                            BatchResultsBetaResponse.Result.BetaSucceededResult
                                                .Message
                                                .Content
                                                .BetaResponseTextBlock
                                                .Citation
                                                .BetaResponseCharLocationCitation
                                                .Type
                                                .CHAR_LOCATION
                                        )
                                        .build()
                                )
                                .text("Hi! My name is Claude.")
                                .type(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Content
                                        .BetaResponseTextBlock
                                        .Type
                                        .TEXT
                                )
                                .build()
                        )
                        .model("claude-3-7-sonnet-20250219")
                        .role(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Role
                                .ASSISTANT
                        )
                        .stopReason(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.StopReason
                                .END_TURN
                        )
                        .stopSequence(null)
                        .type(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Type.MESSAGE
                        )
                        .usage(
                            BatchResultsBetaResponse.Result.BetaSucceededResult.Message.Usage
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

        val roundtrippedBatchResultsBetaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchResultsBetaResponse),
                jacksonTypeRef<BatchResultsBetaResponse>(),
            )

        assertThat(roundtrippedBatchResultsBetaResponse).isEqualTo(batchResultsBetaResponse)
    }
}
