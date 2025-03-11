// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelRetrieveBetaParamsTest {

    @Test
    fun create() {
      ModelRetrieveBetaParams.builder()
          .modelId("model_id")
          .anthropicVersion("anthropic-version")
          .xApiKey("x-api-key")
          .build()
    }

    @Test
    fun getPathParam() {
      val params = ModelRetrieveBetaParams.builder()
          .modelId("model_id")
          .build()
      assertThat(params).isNotNull
      // path param "modelId"
      assertThat(params.getPathParam(0)).isEqualTo("model_id")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
