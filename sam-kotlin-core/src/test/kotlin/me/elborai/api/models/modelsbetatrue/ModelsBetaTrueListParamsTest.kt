// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.modelsbetatrue

import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelsBetaTrueListParamsTest {

    @Test
    fun create() {
        ModelsBetaTrueListParams.builder()
            .afterId("after_id")
            .beforeId("before_id")
            .limit(1L)
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ModelsBetaTrueListParams.builder()
                .afterId("after_id")
                .beforeId("before_id")
                .limit(1L)
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
        val params = ModelsBetaTrueListParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            ModelsBetaTrueListParams.builder()
                .afterId("after_id")
                .beforeId("before_id")
                .limit(1L)
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after_id", "after_id")
                    .put("before_id", "before_id")
                    .put("limit", "1")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ModelsBetaTrueListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
