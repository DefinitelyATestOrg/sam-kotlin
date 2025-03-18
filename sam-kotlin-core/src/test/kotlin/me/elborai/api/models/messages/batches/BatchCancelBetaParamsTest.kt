// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCancelBetaParamsTest {

    @Test
    fun create() {
        BatchCancelBetaParams.builder()
            .messageBatchId("message_batch_id")
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun pathParams() {
        val params = BatchCancelBetaParams.builder().messageBatchId("message_batch_id").build()

        assertThat(params._pathParam(0)).isEqualTo("message_batch_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
