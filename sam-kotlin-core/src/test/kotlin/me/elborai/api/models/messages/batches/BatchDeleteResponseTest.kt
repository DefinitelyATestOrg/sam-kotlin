// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BatchDeleteResponseTest {

    @Test
    fun createBatchDeleteResponse() {
      val batchDeleteResponse = BatchDeleteResponse.builder()
          .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
          .type(BatchDeleteResponse.Type.MESSAGE_BATCH_DELETED)
          .build()
      assertThat(batchDeleteResponse).isNotNull
      assertThat(batchDeleteResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
      assertThat(batchDeleteResponse.type()).isEqualTo(BatchDeleteResponse.Type.MESSAGE_BATCH_DELETED)
    }
}
