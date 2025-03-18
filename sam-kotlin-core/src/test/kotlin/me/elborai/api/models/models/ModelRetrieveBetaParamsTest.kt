// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveBetaParamsTest {

    @Test
    fun create() {
        ModelRetrieveBetaParams.builder()
            .modelId("model_id")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ModelRetrieveBetaParams.builder().modelId("model_id").build()

        assertThat(params._pathParam(0)).isEqualTo("model_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
