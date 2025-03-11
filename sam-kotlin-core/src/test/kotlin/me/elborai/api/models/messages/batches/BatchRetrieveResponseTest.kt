// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchRetrieveResponseTest {

    @Test
    fun createBatchRetrieveResponse() {
      val batchRetrieveResponse = BatchRetrieveResponse.builder()
          .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
          .archivedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
          .cancelInitiatedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
          .createdAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
          .endedAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
          .expiresAt(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
          .processingStatus(BatchRetrieveResponse.ProcessingStatus.IN_PROGRESS)
          .requestCounts(BatchRetrieveResponse.RequestCounts.builder()
              .canceled(10L)
              .errored(30L)
              .expired(10L)
              .processing(100L)
              .succeeded(50L)
              .build())
          .resultsUrl("https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results")
          .type(BatchRetrieveResponse.Type.MESSAGE_BATCH)
          .build()
      assertThat(batchRetrieveResponse).isNotNull
      assertThat(batchRetrieveResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
      assertThat(batchRetrieveResponse.archivedAt()).isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
      assertThat(batchRetrieveResponse.cancelInitiatedAt()).isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
      assertThat(batchRetrieveResponse.createdAt()).isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
      assertThat(batchRetrieveResponse.endedAt()).isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
      assertThat(batchRetrieveResponse.expiresAt()).isEqualTo(OffsetDateTime.parse("2024-08-20T18:37:24.100435Z"))
      assertThat(batchRetrieveResponse.processingStatus()).isEqualTo(BatchRetrieveResponse.ProcessingStatus.IN_PROGRESS)
      assertThat(batchRetrieveResponse.requestCounts()).isEqualTo(BatchRetrieveResponse.RequestCounts.builder()
          .canceled(10L)
          .errored(30L)
          .expired(10L)
          .processing(100L)
          .succeeded(50L)
          .build())
      assertThat(batchRetrieveResponse.resultsUrl()).isEqualTo("https://api.anthropic.com/v1/messages/batches/msgbatch_013Zva2CMHLNnXjNJJKqJ2EF/results")
      assertThat(batchRetrieveResponse.type()).isEqualTo(BatchRetrieveResponse.Type.MESSAGE_BATCH)
    }
}
