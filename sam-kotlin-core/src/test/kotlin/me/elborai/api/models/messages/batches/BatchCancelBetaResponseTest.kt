// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCancelBetaResponseTest {

    @Test
    fun create() {
        val batchCancelBetaResponse =
            BatchCancelBetaResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(BatchCancelBetaResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    BatchCancelBetaResponse.RequestCounts.builder()
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
                .type(BatchCancelBetaResponse.Type.MESSAGE_BATCH)
                .build()

        assertThat(batchCancelBetaResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(batchCancelBetaResponse.archivedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchCancelBetaResponse.cancelInitiatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchCancelBetaResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchCancelBetaResponse.endedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchCancelBetaResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchCancelBetaResponse.processingStatus())
            .isEqualTo(BatchCancelBetaResponse.ProcessingStatus.IN_PROGRESS)
        assertThat(batchCancelBetaResponse.requestCounts())
            .isEqualTo(
                BatchCancelBetaResponse.RequestCounts.builder()
                    .canceled(10L)
                    .errored(30L)
                    .expired(10L)
                    .processing(100L)
                    .succeeded(50L)
                    .build()
            )
        assertThat(batchCancelBetaResponse.resultsUrl())
            .isEqualTo(
                "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
            )
        assertThat(batchCancelBetaResponse.type())
            .isEqualTo(BatchCancelBetaResponse.Type.MESSAGE_BATCH)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchCancelBetaResponse =
            BatchCancelBetaResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(BatchCancelBetaResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    BatchCancelBetaResponse.RequestCounts.builder()
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
                .type(BatchCancelBetaResponse.Type.MESSAGE_BATCH)
                .build()

        val roundtrippedBatchCancelBetaResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCancelBetaResponse),
                jacksonTypeRef<BatchCancelBetaResponse>(),
            )

        assertThat(roundtrippedBatchCancelBetaResponse).isEqualTo(batchCancelBetaResponse)
    }
}
