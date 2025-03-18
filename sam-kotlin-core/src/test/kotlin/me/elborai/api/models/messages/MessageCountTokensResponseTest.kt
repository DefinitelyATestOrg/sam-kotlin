// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCountTokensResponseTest {

    @Test
    fun create() {
        val messageCountTokensResponse =
            MessageCountTokensResponse.builder().inputTokens(2095L).build()

        assertThat(messageCountTokensResponse.inputTokens()).isEqualTo(2095L)
    }
}
