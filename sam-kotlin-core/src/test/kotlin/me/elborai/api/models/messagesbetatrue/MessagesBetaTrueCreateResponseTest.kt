// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messagesbetatrue

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessagesBetaTrueCreateResponseTest {

    @Test
    fun createMessagesBetaTrueCreateResponse() {
        val messagesBetaTrueCreateResponse =
            MessagesBetaTrueCreateResponse.builder()
                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                .addContent(
                    MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock.builder()
                        .addCitation(
                            MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock.Citation
                                .BetaResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock
                                        .Citation
                                        .BetaResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(
                            MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock.Type.TEXT
                        )
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .role(MessagesBetaTrueCreateResponse.Role.ASSISTANT)
                .stopReason(MessagesBetaTrueCreateResponse.StopReason.END_TURN)
                .stopSequence(null)
                .type(MessagesBetaTrueCreateResponse.Type.MESSAGE)
                .usage(
                    MessagesBetaTrueCreateResponse.Usage.builder()
                        .cacheCreationInputTokens(2051L)
                        .cacheReadInputTokens(2051L)
                        .inputTokens(2095L)
                        .outputTokens(503L)
                        .build()
                )
                .build()
        assertThat(messagesBetaTrueCreateResponse).isNotNull
        assertThat(messagesBetaTrueCreateResponse.id()).isEqualTo("msg_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messagesBetaTrueCreateResponse.content())
            .containsExactly(
                MessagesBetaTrueCreateResponse.Content.ofBetaResponseTextBlock(
                    MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock.builder()
                        .addCitation(
                            MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock.Citation
                                .BetaResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock
                                        .Citation
                                        .BetaResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(
                            MessagesBetaTrueCreateResponse.Content.BetaResponseTextBlock.Type.TEXT
                        )
                        .build()
                )
            )
        assertThat(messagesBetaTrueCreateResponse.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(messagesBetaTrueCreateResponse.role())
            .isEqualTo(MessagesBetaTrueCreateResponse.Role.ASSISTANT)
        assertThat(messagesBetaTrueCreateResponse.stopReason())
            .isEqualTo(MessagesBetaTrueCreateResponse.StopReason.END_TURN)
        assertThat(messagesBetaTrueCreateResponse.stopSequence()).isNull()
        assertThat(messagesBetaTrueCreateResponse.type())
            .isEqualTo(MessagesBetaTrueCreateResponse.Type.MESSAGE)
        assertThat(messagesBetaTrueCreateResponse.usage())
            .isEqualTo(
                MessagesBetaTrueCreateResponse.Usage.builder()
                    .cacheCreationInputTokens(2051L)
                    .cacheReadInputTokens(2051L)
                    .inputTokens(2095L)
                    .outputTokens(503L)
                    .build()
            )
    }
}
