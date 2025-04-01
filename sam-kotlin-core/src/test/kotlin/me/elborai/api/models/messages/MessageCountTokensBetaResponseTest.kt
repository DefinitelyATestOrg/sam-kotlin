// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCountTokensBetaResponseTest {

    @Test
    fun create() {
        val messageCountTokensBetaResponse =
            MessageCountTokensBetaResponse.builder().inputTokens(2095L).build()

        assertThat(messageCountTokensBetaResponse.inputTokens()).isEqualTo(2095L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageCountTokensBetaResponse =
            MessageCountTokensBetaResponse.builder().inputTokens(2095L).build()

        val roundtrippedMessageCountTokensBetaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageCountTokensBetaResponse),
                jacksonTypeRef<MessageCountTokensBetaResponse>(),
            )

        assertThat(roundtrippedMessageCountTokensBetaResponse)
            .isEqualTo(messageCountTokensBetaResponse)
    }
}
