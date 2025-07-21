// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveBetaResponseTest {

    @Test
    fun create() {
        val modelRetrieveBetaResponse =
            ModelRetrieveBetaResponse.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .build()

        assertThat(modelRetrieveBetaResponse.id()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(modelRetrieveBetaResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
        assertThat(modelRetrieveBetaResponse.displayName()).isEqualTo("Claude 3.7 Sonnet")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val modelRetrieveBetaResponse =
            ModelRetrieveBetaResponse.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .build()

        val roundtrippedModelRetrieveBetaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(modelRetrieveBetaResponse),
                jacksonTypeRef<ModelRetrieveBetaResponse>(),
            )

        assertThat(roundtrippedModelRetrieveBetaResponse).isEqualTo(modelRetrieveBetaResponse)
    }
}
