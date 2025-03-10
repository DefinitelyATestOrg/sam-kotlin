// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import me.elborai.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchesBetaTrueListParamsTest {

    @Test
    fun create() {
        MessageBatchesBetaTrueListParams.builder()
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
            MessageBatchesBetaTrueListParams.builder()
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
        val params = MessageBatchesBetaTrueListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params._queryParams()).isEqualTo(expected.build())
    }
}
