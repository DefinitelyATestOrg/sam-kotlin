// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchRetrieveParamsTest {

    @Test
    fun create() {
        MessageBatchRetrieveParams.builder()
            .messageBatchId("message_batch_id")
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun getPathParam() {
        val params = MessageBatchRetrieveParams.builder().messageBatchId("message_batch_id").build()
        assertThat(params).isNotNull
        // path param "messageBatchId"
        assertThat(params.getPathParam(0)).isEqualTo("message_batch_id")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
