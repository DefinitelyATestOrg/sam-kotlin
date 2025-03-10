// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageCreateResponseTest {

    @Test
    fun createMessageCreateResponse() {
        val messageCreateResponse =
            MessageCreateResponse.builder()
                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                .addContent(
                    MessageCreateResponse.Content.ResponseTextBlock.builder()
                        .addCitation(
                            MessageCreateResponse.Content.ResponseTextBlock.Citation
                                .ResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    MessageCreateResponse.Content.ResponseTextBlock.Citation
                                        .ResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(MessageCreateResponse.Content.ResponseTextBlock.Type.TEXT)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .role(MessageCreateResponse.Role.ASSISTANT)
                .stopReason(MessageCreateResponse.StopReason.END_TURN)
                .stopSequence(null)
                .type(MessageCreateResponse.Type.MESSAGE)
                .usage(
                    MessageCreateResponse.Usage.builder()
                        .cacheCreationInputTokens(2051L)
                        .cacheReadInputTokens(2051L)
                        .inputTokens(2095L)
                        .outputTokens(503L)
                        .build()
                )
                .build()
        assertThat(messageCreateResponse).isNotNull
        assertThat(messageCreateResponse.id()).isEqualTo("msg_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messageCreateResponse.content())
            .containsExactly(
                MessageCreateResponse.Content.ofResponseTextBlock(
                    MessageCreateResponse.Content.ResponseTextBlock.builder()
                        .addCitation(
                            MessageCreateResponse.Content.ResponseTextBlock.Citation
                                .ResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    MessageCreateResponse.Content.ResponseTextBlock.Citation
                                        .ResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(MessageCreateResponse.Content.ResponseTextBlock.Type.TEXT)
                        .build()
                )
            )
        assertThat(messageCreateResponse.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(messageCreateResponse.role()).isEqualTo(MessageCreateResponse.Role.ASSISTANT)
        assertThat(messageCreateResponse.stopReason())
            .isEqualTo(MessageCreateResponse.StopReason.END_TURN)
        assertThat(messageCreateResponse.stopSequence()).isNull()
        assertThat(messageCreateResponse.type()).isEqualTo(MessageCreateResponse.Type.MESSAGE)
        assertThat(messageCreateResponse.usage())
            .isEqualTo(
                MessageCreateResponse.Usage.builder()
                    .cacheCreationInputTokens(2051L)
                    .cacheReadInputTokens(2051L)
                    .inputTokens(2095L)
                    .outputTokens(503L)
                    .build()
            )
    }
}
