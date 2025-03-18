// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches.betatrue

import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaTrueRetrieveParamsTest {

    @Test
    fun create() {
        BetaTrueRetrieveParams.builder()
            .messageBatchId("message_batch_id")
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun pathParams() {
        val params = BetaTrueRetrieveParams.builder().messageBatchId("message_batch_id").build()

        assertThat(params._pathParam(0)).isEqualTo("message_batch_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            BetaTrueRetrieveParams.builder()
                .messageBatchId("message_batch_id")
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("anthropic-beta", "string")
                    .put("anthropic-version", "anthropic-version")
                    .put("x-api-key", "x-api-key")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = BetaTrueRetrieveParams.builder().messageBatchId("message_batch_id").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
