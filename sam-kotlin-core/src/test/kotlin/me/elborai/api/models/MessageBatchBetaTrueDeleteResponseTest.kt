// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchBetaTrueDeleteResponseTest {

    @Test
    fun createMessageBatchBetaTrueDeleteResponse() {
        val messageBatchBetaTrueDeleteResponse =
            MessageBatchBetaTrueDeleteResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .type(MessageBatchBetaTrueDeleteResponse.Type.MESSAGE_BATCH_DELETED)
                .build()
        assertThat(messageBatchBetaTrueDeleteResponse).isNotNull
        assertThat(messageBatchBetaTrueDeleteResponse.id())
            .isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messageBatchBetaTrueDeleteResponse.type())
            .isEqualTo(MessageBatchBetaTrueDeleteResponse.Type.MESSAGE_BATCH_DELETED)
    }
}
