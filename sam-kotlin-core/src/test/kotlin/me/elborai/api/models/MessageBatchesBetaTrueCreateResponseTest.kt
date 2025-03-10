// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageBatchesBetaTrueCreateResponseTest {

    @Test
    fun createMessageBatchesBetaTrueCreateResponse() {
        val messageBatchesBetaTrueCreateResponse =
            MessageBatchesBetaTrueCreateResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(MessageBatchesBetaTrueCreateResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    MessageBatchesBetaTrueCreateResponse.RequestCounts.builder()
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
                .type(MessageBatchesBetaTrueCreateResponse.Type.MESSAGE_BATCH)
                .build()
        assertThat(messageBatchesBetaTrueCreateResponse).isNotNull
        assertThat(messageBatchesBetaTrueCreateResponse.id())
            .isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(messageBatchesBetaTrueCreateResponse.archivedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchesBetaTrueCreateResponse.cancelInitiatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchesBetaTrueCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchesBetaTrueCreateResponse.endedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchesBetaTrueCreateResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(messageBatchesBetaTrueCreateResponse.processingStatus())
            .isEqualTo(MessageBatchesBetaTrueCreateResponse.ProcessingStatus.IN_PROGRESS)
        assertThat(messageBatchesBetaTrueCreateResponse.requestCounts())
            .isEqualTo(
                MessageBatchesBetaTrueCreateResponse.RequestCounts.builder()
                    .canceled(10L)
                    .errored(30L)
                    .expired(10L)
                    .processing(100L)
                    .succeeded(50L)
                    .build()
            )
        assertThat(messageBatchesBetaTrueCreateResponse.resultsUrl())
            .isEqualTo(
                "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
            )
        assertThat(messageBatchesBetaTrueCreateResponse.type())
            .isEqualTo(MessageBatchesBetaTrueCreateResponse.Type.MESSAGE_BATCH)
    }
}
