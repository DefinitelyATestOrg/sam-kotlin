// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.samplopplop

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SamPlopPlopCreateMessageResponseTest {

    @Test
    fun create() {
        val samPlopPlopCreateMessageResponse =
            SamPlopPlopCreateMessageResponse.builder()
                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                .addContent(
                    SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.builder()
                        .addCitation(
                            SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.Citation
                                .ResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock
                                        .Citation
                                        .ResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.Type.TEXT)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .role(SamPlopPlopCreateMessageResponse.Role.ASSISTANT)
                .stopReason(SamPlopPlopCreateMessageResponse.StopReason.END_TURN)
                .stopSequence(null)
                .type(SamPlopPlopCreateMessageResponse.Type.MESSAGE)
                .usage(
                    SamPlopPlopCreateMessageResponse.Usage.builder()
                        .cacheCreationInputTokens(2051L)
                        .cacheReadInputTokens(2051L)
                        .inputTokens(2095L)
                        .outputTokens(503L)
                        .build()
                )
                .build()

        assertThat(samPlopPlopCreateMessageResponse.id()).isEqualTo("msg_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(samPlopPlopCreateMessageResponse.content())
            .containsExactly(
                SamPlopPlopCreateMessageResponse.Content.ofResponseTextBlock(
                    SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.builder()
                        .addCitation(
                            SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.Citation
                                .ResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock
                                        .Citation
                                        .ResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.Type.TEXT)
                        .build()
                )
            )
        assertThat(samPlopPlopCreateMessageResponse.model()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(samPlopPlopCreateMessageResponse.role())
            .isEqualTo(SamPlopPlopCreateMessageResponse.Role.ASSISTANT)
        assertThat(samPlopPlopCreateMessageResponse.stopReason())
            .isEqualTo(SamPlopPlopCreateMessageResponse.StopReason.END_TURN)
        assertThat(samPlopPlopCreateMessageResponse.stopSequence()).isNull()
        assertThat(samPlopPlopCreateMessageResponse.type())
            .isEqualTo(SamPlopPlopCreateMessageResponse.Type.MESSAGE)
        assertThat(samPlopPlopCreateMessageResponse.usage())
            .isEqualTo(
                SamPlopPlopCreateMessageResponse.Usage.builder()
                    .cacheCreationInputTokens(2051L)
                    .cacheReadInputTokens(2051L)
                    .inputTokens(2095L)
                    .outputTokens(503L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val samPlopPlopCreateMessageResponse =
            SamPlopPlopCreateMessageResponse.builder()
                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                .addContent(
                    SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.builder()
                        .addCitation(
                            SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.Citation
                                .ResponseCharLocationCitation
                                .builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .type(
                                    SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock
                                        .Citation
                                        .ResponseCharLocationCitation
                                        .Type
                                        .CHAR_LOCATION
                                )
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .type(SamPlopPlopCreateMessageResponse.Content.ResponseTextBlock.Type.TEXT)
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .role(SamPlopPlopCreateMessageResponse.Role.ASSISTANT)
                .stopReason(SamPlopPlopCreateMessageResponse.StopReason.END_TURN)
                .stopSequence(null)
                .type(SamPlopPlopCreateMessageResponse.Type.MESSAGE)
                .usage(
                    SamPlopPlopCreateMessageResponse.Usage.builder()
                        .cacheCreationInputTokens(2051L)
                        .cacheReadInputTokens(2051L)
                        .inputTokens(2095L)
                        .outputTokens(503L)
                        .build()
                )
                .build()

        val roundtrippedSamPlopPlopCreateMessageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(samPlopPlopCreateMessageResponse),
                jacksonTypeRef<SamPlopPlopCreateMessageResponse>(),
            )

        assertThat(roundtrippedSamPlopPlopCreateMessageResponse)
            .isEqualTo(samPlopPlopCreateMessageResponse)
    }
}
