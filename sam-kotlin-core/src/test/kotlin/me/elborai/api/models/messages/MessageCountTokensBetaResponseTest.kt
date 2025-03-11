// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageCountTokensBetaResponseTest {

    @Test
    fun createMessageCountTokensBetaResponse() {
      val messageCountTokensBetaResponse = MessageCountTokensBetaResponse.builder()
          .inputTokens(2095L)
          .build()
      assertThat(messageCountTokensBetaResponse).isNotNull
      assertThat(messageCountTokensBetaResponse.inputTokens()).isEqualTo(2095L)
    }
}
