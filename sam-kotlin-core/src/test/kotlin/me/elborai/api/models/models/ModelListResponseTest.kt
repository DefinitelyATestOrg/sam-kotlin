// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelListResponseTest {

    @Test
    fun create() {
        val modelListResponse =
            ModelListResponse.builder()
                .addData(
                    ModelListResponse.Data.builder()
                        .id("claude-3-7-sonnet-20250219")
                        .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                        .displayName("Claude 3.7 Sonnet")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(modelListResponse.data())
            .containsExactly(
                ModelListResponse.Data.builder()
                    .id("claude-3-7-sonnet-20250219")
                    .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                    .displayName("Claude 3.7 Sonnet")
                    .build()
            )
        assertThat(modelListResponse.firstId()).isEqualTo("first_id")
        assertThat(modelListResponse.hasMore()).isEqualTo(true)
        assertThat(modelListResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val modelListResponse =
            ModelListResponse.builder()
                .addData(
                    ModelListResponse.Data.builder()
                        .id("claude-3-7-sonnet-20250219")
                        .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                        .displayName("Claude 3.7 Sonnet")
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedModelListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(modelListResponse),
                jacksonTypeRef<ModelListResponse>(),
            )

        assertThat(roundtrippedModelListResponse).isEqualTo(modelListResponse)
    }
}
