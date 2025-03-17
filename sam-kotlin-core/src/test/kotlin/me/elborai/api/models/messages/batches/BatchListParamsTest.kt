// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import me.elborai.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchListParamsTest {

    @Test
    fun create() {
        BatchListParams.builder()
            .afterId("after_id")
            .beforeId("before_id")
            .limit(1L)
            .addAnthropicBeta("string")
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            BatchListParams.builder()
                .afterId("after_id")
                .beforeId("before_id")
                .limit(1L)
                .addAnthropicBeta("string")
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .build()
        val expected = QueryParams.builder()
        expected.put("after_id", "after_id")
        expected.put("before_id", "before_id")
        expected.put("limit", "1")
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = BatchListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
