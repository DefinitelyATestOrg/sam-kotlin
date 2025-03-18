// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveParamsTest {

    @Test
    fun create() {
        ModelRetrieveParams.builder()
            .modelId("model_id")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ModelRetrieveParams.builder().modelId("model_id").build()

        assertThat(params._pathParam(0)).isEqualTo("model_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ModelRetrieveParams.builder()
                .modelId("model_id")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("anthropic-version", "anthropic-version")
                    .put("x-api-key", "x-api-key")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = ModelRetrieveParams.builder().modelId("model_id").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
