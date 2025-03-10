// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchBetaTrueRetrieveResponseTest {

    @Test
    fun createMessageBatchBetaTrueRetrieveResponse() {
        val messageBatchBetaTrueRetrieveResponse =
            MessageBatchBetaTrueRetrieveResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(MessageBatchBetaTrueRetrieveResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    MessageBatchBetaTrueRetrieveResponse.RequestCounts.builder()
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
                .type(MessageBatchBetaTrueRetrieveResponse.Type.MESSAGE_BATCH)
                .build()
        assertThat(messageBatchBetaTrueRetrieveResponse).isNotNull
        assertThat(messageBatchBetaTrueRetrieveResponse.id())
            .isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messageBatchBetaTrueRetrieveResponse.archivedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchBetaTrueRetrieveResponse.cancelInitiatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchBetaTrueRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchBetaTrueRetrieveResponse.endedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchBetaTrueRetrieveResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchBetaTrueRetrieveResponse.processingStatus())
            .isEqualTo(MessageBatchBetaTrueRetrieveResponse.ProcessingStatus.IN_PROGRESS)
        assertThat(messageBatchBetaTrueRetrieveResponse.requestCounts())
            .isEqualTo(
                MessageBatchBetaTrueRetrieveResponse.RequestCounts.builder()
                    .canceled(10L)
                    .errored(30L)
                    .expired(10L)
                    .processing(100L)
                    .succeeded(50L)
                    .build()
            )
        assertThat(messageBatchBetaTrueRetrieveResponse.resultsUrl())
            .isEqualTo(
                "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
            )
        assertThat(messageBatchBetaTrueRetrieveResponse.type())
            .isEqualTo(MessageBatchBetaTrueRetrieveResponse.Type.MESSAGE_BATCH)
    }
}
