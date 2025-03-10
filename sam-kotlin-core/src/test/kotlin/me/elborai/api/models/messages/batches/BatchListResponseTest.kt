// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchListResponseTest {

    @Test
    fun createBatchListResponse() {
        val batchListResponse =
            BatchListResponse.builder()
                .addData(
                    BatchListResponse.Data.builder()
                        .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                        .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .processingStatus(BatchListResponse.Data.ProcessingStatus.IN_PROGRESS)
                        .requestCounts(
                            BatchListResponse.Data.RequestCounts.builder()
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
                        .type(BatchListResponse.Data.Type.MESSAGE_BATCH)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()
        assertThat(batchListResponse).isNotNull
        assertThat(batchListResponse.data())
            .containsExactly(
                BatchListResponse.Data.builder()
                    .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                    .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .processingStatus(BatchListResponse.Data.ProcessingStatus.IN_PROGRESS)
                    .requestCounts(
                        BatchListResponse.Data.RequestCounts.builder()
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
                    .type(BatchListResponse.Data.Type.MESSAGE_BATCH)
                    .build()
            )
        assertThat(batchListResponse.firstId()).isEqualTo("first_id")
        assertThat(batchListResponse.hasMore()).isEqualTo(true)
        assertThat(batchListResponse.lastId()).isEqualTo("last_id")
    }
}
