// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.modelsbetatrue

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelsBetaTrueListResponseTest {

    @Test
    fun create() {
        val modelsBetaTrueListResponse =
            ModelsBetaTrueListResponse.builder()
                .addData(
                    ModelsBetaTrueListResponse.Data.builder()
                        .id("claude-3-7-sonnet-20250219")
                        .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                        .displayName("Claude 3.7 Sonnet")
                        .type(ModelsBetaTrueListResponse.Data.Type.MODEL)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(modelsBetaTrueListResponse.data())
            .containsExactly(
                ModelsBetaTrueListResponse.Data.builder()
                    .id("claude-3-7-sonnet-20250219")
                    .createdAt(OffsetDateTime.parse("2025-02-19T00:00:00Z"))
                    .displayName("Claude 3.7 Sonnet")
                    .type(ModelsBetaTrueListResponse.Data.Type.MODEL)
                    .build()
            )
        assertThat(modelsBetaTrueListResponse.firstId()).isEqualTo("first_id")
        assertThat(modelsBetaTrueListResponse.hasMore()).isEqualTo(true)
        assertThat(modelsBetaTrueListResponse.lastId()).isEqualTo("last_id")
    }
}
