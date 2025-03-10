// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelRetrieveResponseTest {

    @Test
    fun createModelRetrieveResponse() {
        val modelRetrieveResponse =
            ModelRetrieveResponse.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .type(ModelRetrieveResponse.Type.MODEL)
                .build()
        assertThat(modelRetrieveResponse).isNotNull
        assertThat(modelRetrieveResponse.id()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(modelRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
        assertThat(modelRetrieveResponse.displayName()).isEqualTo("Claude 3.7 Sonnet")
        assertThat(modelRetrieveResponse.type()).isEqualTo(ModelRetrieveResponse.Type.MODEL)
    }
}
