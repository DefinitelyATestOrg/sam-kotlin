// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveBetaResponseTest {

    @Test
    fun createModelRetrieveBetaResponse() {
        val modelRetrieveBetaResponse =
            ModelRetrieveBetaResponse.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .type(ModelRetrieveBetaResponse.Type.MODEL)
                .build()
        assertThat(modelRetrieveBetaResponse).isNotNull
        assertThat(modelRetrieveBetaResponse.id()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(modelRetrieveBetaResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
        assertThat(modelRetrieveBetaResponse.displayName()).isEqualTo("Claude 3.7 Sonnet")
        assertThat(modelRetrieveBetaResponse.type()).isEqualTo(ModelRetrieveBetaResponse.Type.MODEL)
    }
}
