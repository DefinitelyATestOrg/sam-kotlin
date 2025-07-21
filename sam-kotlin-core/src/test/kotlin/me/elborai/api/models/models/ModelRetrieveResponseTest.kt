// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelRetrieveResponseTest {

    @Test
    fun create() {
        val modelRetrieveResponse =
            ModelRetrieveResponse.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .build()

        assertThat(modelRetrieveResponse.id()).isEqualTo("claude-3-7-sonnet-20250219")
        assertThat(modelRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
        assertThat(modelRetrieveResponse.displayName()).isEqualTo("Claude 3.7 Sonnet")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val modelRetrieveResponse =
            ModelRetrieveResponse.builder()
                .id("claude-3-7-sonnet-20250219")
                .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                .displayName("Claude 3.7 Sonnet")
                .build()

        val roundtrippedModelRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(modelRetrieveResponse),
                jacksonTypeRef<ModelRetrieveResponse>(),
            )

        assertThat(roundtrippedModelRetrieveResponse).isEqualTo(modelRetrieveResponse)
    }
}
