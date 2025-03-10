// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchesBetaTrueListResponseTest {

    @Test
    fun createMessageBatchesBetaTrueListResponse() {
        val messageBatchesBetaTrueListResponse =
            MessageBatchesBetaTrueListResponse.builder()
                .addData(
                    MessageBatchesBetaTrueListResponse.Data.builder()
                        .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                        .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                        .processingStatus(
                            MessageBatchesBetaTrueListResponse.Data.ProcessingStatus.IN_PROGRESS
                        )
                        .requestCounts(
                            MessageBatchesBetaTrueListResponse.Data.RequestCounts.builder()
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
                        .type(MessageBatchesBetaTrueListResponse.Data.Type.MESSAGE_BATCH)
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()
        assertThat(messageBatchesBetaTrueListResponse).isNotNull
        assertThat(messageBatchesBetaTrueListResponse.data())
            .containsExactly(
                MessageBatchesBetaTrueListResponse.Data.builder()
                    .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                    .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                    .processingStatus(
                        MessageBatchesBetaTrueListResponse.Data.ProcessingStatus.IN_PROGRESS
                    )
                    .requestCounts(
                        MessageBatchesBetaTrueListResponse.Data.RequestCounts.builder()
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
                    .type(MessageBatchesBetaTrueListResponse.Data.Type.MESSAGE_BATCH)
                    .build()
            )
        assertThat(messageBatchesBetaTrueListResponse.firstId()).isEqualTo("first_id")
        assertThat(messageBatchesBetaTrueListResponse.hasMore()).isEqualTo(true)
        assertThat(messageBatchesBetaTrueListResponse.lastId()).isEqualTo("last_id")
    }
}
