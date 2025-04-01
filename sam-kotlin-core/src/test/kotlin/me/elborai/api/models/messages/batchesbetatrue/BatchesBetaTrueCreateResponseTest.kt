// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batchesbetatrue

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchesBetaTrueCreateResponseTest {

    @Test
    fun create() {
        val batchesBetaTrueCreateResponse =
            BatchesBetaTrueCreateResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(BatchesBetaTrueCreateResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    BatchesBetaTrueCreateResponse.RequestCounts.builder()
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
                .type(BatchesBetaTrueCreateResponse.Type.MESSAGE_BATCH)
                .build()

        assertThat(batchesBetaTrueCreateResponse.id())
            .isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(batchesBetaTrueCreateResponse.archivedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchesBetaTrueCreateResponse.cancelInitiatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchesBetaTrueCreateResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchesBetaTrueCreateResponse.endedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchesBetaTrueCreateResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(batchesBetaTrueCreateResponse.processingStatus())
            .isEqualTo(BatchesBetaTrueCreateResponse.ProcessingStatus.IN_PROGRESS)
        assertThat(batchesBetaTrueCreateResponse.requestCounts())
            .isEqualTo(
                BatchesBetaTrueCreateResponse.RequestCounts.builder()
                    .canceled(10L)
                    .errored(30L)
                    .expired(10L)
                    .processing(100L)
                    .succeeded(50L)
                    .build()
            )
        assertThat(batchesBetaTrueCreateResponse.resultsUrl())
            .isEqualTo(
                "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
            )
        assertThat(batchesBetaTrueCreateResponse.type())
            .isEqualTo(BatchesBetaTrueCreateResponse.Type.MESSAGE_BATCH)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchesBetaTrueCreateResponse =
            BatchesBetaTrueCreateResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(BatchesBetaTrueCreateResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    BatchesBetaTrueCreateResponse.RequestCounts.builder()
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
                .type(BatchesBetaTrueCreateResponse.Type.MESSAGE_BATCH)
                .build()

        val roundtrippedBatchesBetaTrueCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchesBetaTrueCreateResponse),
                jacksonTypeRef<BatchesBetaTrueCreateResponse>(),
            )

        assertThat(roundtrippedBatchesBetaTrueCreateResponse)
            .isEqualTo(batchesBetaTrueCreateResponse)
    }
}
