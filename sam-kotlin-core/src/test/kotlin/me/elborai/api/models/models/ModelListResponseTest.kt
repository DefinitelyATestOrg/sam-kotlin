// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ModelListResponseTest {

    @Test
    fun createModelListResponse() {
        val modelListResponse =
            ModelListResponse.builder()
                .addData(
                    ModelListResponse.Data.builder()
                        .id("claude-3-7-sonnet-20250219")
                        .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                        .displayName("Claude 3.7 Sonnet")
                        .type(ModelListResponse.Data.Type.MODEL)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()
        assertThat(modelListResponse).isNotNull
        assertThat(modelListResponse.data())
            .containsExactly(
                ModelListResponse.Data.builder()
                    .id("claude-3-7-sonnet-20250219")
                    .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                    .displayName("Claude 3.7 Sonnet")
                    .type(ModelListResponse.Data.Type.MODEL)
                    .build()
            )
        assertThat(modelListResponse.firstId()).isEqualTo("first_id")
        assertThat(modelListResponse.hasMore()).isEqualTo(true)
        assertThat(modelListResponse.lastId()).isEqualTo("last_id")
    }
}
