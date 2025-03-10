// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchCreateResponseTest {

    @Test
    fun createMessageBatchCreateResponse() {
        val messageBatchCreateResponse =
            MessageBatchCreateResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(MessageBatchCreateResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    MessageBatchCreateResponse.RequestCounts.builder()
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
                .type(MessageBatchCreateResponse.Type.MESSAGE_BATCH)
                .build()
        assertThat(messageBatchCreateResponse).isNotNull
        assertThat(messageBatchCreateResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messageBatchCreateResponse.archivedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchCreateResponse.cancelInitiatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchCreateResponse.endedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchCreateResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchCreateResponse.processingStatus())
            .isEqualTo(MessageBatchCreateResponse.ProcessingStatus.IN_PROGRESS)
        assertThat(messageBatchCreateResponse.requestCounts())
            .isEqualTo(
                MessageBatchCreateResponse.RequestCounts.builder()
                    .canceled(10L)
                    .errored(30L)
                    .expired(10L)
                    .processing(100L)
                    .succeeded(50L)
                    .build()
            )
        assertThat(messageBatchCreateResponse.resultsUrl())
            .isEqualTo(
                "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
            )
        assertThat(messageBatchCreateResponse.type())
            .isEqualTo(MessageBatchCreateResponse.Type.MESSAGE_BATCH)
    }
}
