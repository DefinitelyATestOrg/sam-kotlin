// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCountTokensResponseTest {

    @Test
    fun create() {
        val messageCountTokensResponse =
            MessageCountTokensResponse.builder().inputTokens(2095L).build()

        assertThat(messageCountTokensResponse.inputTokens()).isEqualTo(2095L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageCountTokensResponse =
            MessageCountTokensResponse.builder().inputTokens(2095L).build()

        val roundtrippedMessageCountTokensResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageCountTokensResponse),
                jacksonTypeRef<MessageCountTokensResponse>(),
            )

        assertThat(roundtrippedMessageCountTokensResponse).isEqualTo(messageCountTokensResponse)
    }
}
