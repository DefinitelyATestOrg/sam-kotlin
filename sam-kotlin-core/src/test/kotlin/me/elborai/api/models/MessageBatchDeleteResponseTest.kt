// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchDeleteResponseTest {

    @Test
    fun createMessageBatchDeleteResponse() {
        val messageBatchDeleteResponse =
            MessageBatchDeleteResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .type(MessageBatchDeleteResponse.Type.MESSAGE_BATCH_DELETED)
                .build()
        assertThat(messageBatchDeleteResponse).isNotNull
        assertThat(messageBatchDeleteResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messageBatchDeleteResponse.type())
            .isEqualTo(MessageBatchDeleteResponse.Type.MESSAGE_BATCH_DELETED)
    }
}
