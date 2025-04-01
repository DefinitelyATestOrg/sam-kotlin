// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batchesbetatrue

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchesBetaTrueListResponseTest {

    @Test
    fun create() {
        val batchesBetaTrueListResponse =
            BatchesBetaTrueListResponse.builder()
                .addData(
                    BatchesBetaTrueListResponse.Data.builder()
                        .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                        .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .processingStatus(
                            BatchesBetaTrueListResponse.Data.ProcessingStatus.IN_PROGRESS
                        )
                        .requestCounts(
                            BatchesBetaTrueListResponse.Data.RequestCounts.builder()
                                .canceled(10L)
                                .errored(30L)
                                .expired(10L)
                                .processing(100L)
                                .succeeded(50L)
                                .build()
                        )
                        .resultsUrl(
                            "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
                        )
                        .type(BatchesBetaTrueListResponse.Data.Type.MESSAGE_BATCH)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(batchesBetaTrueListResponse.data())
            .containsExactly(
                BatchesBetaTrueListResponse.Data.builder()
                    .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                    .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .processingStatus(BatchesBetaTrueListResponse.Data.ProcessingStatus.IN_PROGRESS)
                    .requestCounts(
                        BatchesBetaTrueListResponse.Data.RequestCounts.builder()
                            .canceled(10L)
                            .errored(30L)
                            .expired(10L)
                            .processing(100L)
                            .succeeded(50L)
                            .build()
                    )
                    .resultsUrl(
                        "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
                    )
                    .type(BatchesBetaTrueListResponse.Data.Type.MESSAGE_BATCH)
                    .build()
            )
        assertThat(batchesBetaTrueListResponse.firstId()).isEqualTo("first_id")
        assertThat(batchesBetaTrueListResponse.hasMore()).isEqualTo(true)
        assertThat(batchesBetaTrueListResponse.lastId()).isEqualTo("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchesBetaTrueListResponse =
            BatchesBetaTrueListResponse.builder()
                .addData(
                    BatchesBetaTrueListResponse.Data.builder()
                        .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                        .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .processingStatus(
                            BatchesBetaTrueListResponse.Data.ProcessingStatus.IN_PROGRESS
                        )
                        .requestCounts(
                            BatchesBetaTrueListResponse.Data.RequestCounts.builder()
                                .canceled(10L)
                                .errored(30L)
                                .expired(10L)
                                .processing(100L)
                                .succeeded(50L)
                                .build()
                        )
                        .resultsUrl(
                            "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
                        )
                        .type(BatchesBetaTrueListResponse.Data.Type.MESSAGE_BATCH)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedBatchesBetaTrueListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchesBetaTrueListResponse),
                jacksonTypeRef<BatchesBetaTrueListResponse>(),
            )

        assertThat(roundtrippedBatchesBetaTrueListResponse).isEqualTo(batchesBetaTrueListResponse)
    }
}
