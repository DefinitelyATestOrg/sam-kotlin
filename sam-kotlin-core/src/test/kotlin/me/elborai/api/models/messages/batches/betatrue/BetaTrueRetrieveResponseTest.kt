// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches.betatrue

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaTrueRetrieveResponseTest {

    @Test
    fun create() {
        val betaTrueRetrieveResponse =
            BetaTrueRetrieveResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(BetaTrueRetrieveResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    BetaTrueRetrieveResponse.RequestCounts.builder()
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
                .type(BetaTrueRetrieveResponse.Type.MESSAGE_BATCH)
                .build()

        assertThat(betaTrueRetrieveResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(betaTrueRetrieveResponse.archivedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(betaTrueRetrieveResponse.cancelInitiatedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(betaTrueRetrieveResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(betaTrueRetrieveResponse.endedAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(betaTrueRetrieveResponse.expiresAt())
            .isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
        assertThat(betaTrueRetrieveResponse.processingStatus())
            .isEqualTo(BetaTrueRetrieveResponse.ProcessingStatus.IN_PROGRESS)
        assertThat(betaTrueRetrieveResponse.requestCounts())
            .isEqualTo(
                BetaTrueRetrieveResponse.RequestCounts.builder()
                    .canceled(10L)
                    .errored(30L)
                    .expired(10L)
                    .processing(100L)
                    .succeeded(50L)
                    .build()
            )
        assertThat(betaTrueRetrieveResponse.resultsUrl())
            .isEqualTo(
                "https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results"
            )
        assertThat(betaTrueRetrieveResponse.type())
            .isEqualTo(BetaTrueRetrieveResponse.Type.MESSAGE_BATCH)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaTrueRetrieveResponse =
            BetaTrueRetrieveResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
                .processingStatus(BetaTrueRetrieveResponse.ProcessingStatus.IN_PROGRESS)
                .requestCounts(
                    BetaTrueRetrieveResponse.RequestCounts.builder()
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
                .type(BetaTrueRetrieveResponse.Type.MESSAGE_BATCH)
                .build()

        val roundtrippedBetaTrueRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTrueRetrieveResponse),
                jacksonTypeRef<BetaTrueRetrieveResponse>(),
            )

        assertThat(roundtrippedBetaTrueRetrieveResponse).isEqualTo(betaTrueRetrieveResponse)
    }
}
