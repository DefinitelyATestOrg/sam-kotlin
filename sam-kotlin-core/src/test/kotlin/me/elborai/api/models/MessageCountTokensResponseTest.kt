// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageCountTokensResponseTest {

    @Test
    fun createMessageCountTokensResponse() {
        val messageCountTokensResponse =
            MessageCountTokensResponse.builder().inputTokens(2095L).build()
        assertThat(messageCountTokensResponse).isNotNull
        assertThat(messageCountTokensResponse.inputTokens()).isEqualTo(2095L)
    }
}
