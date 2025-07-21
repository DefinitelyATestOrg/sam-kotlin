// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchDeleteResponseTest {

    @Test
    fun create() {
        val batchDeleteResponse =
            BatchDeleteResponse.builder().id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF").build()

        assertThat(batchDeleteResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchDeleteResponse =
            BatchDeleteResponse.builder().id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF").build()

        val roundtrippedBatchDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchDeleteResponse),
                jacksonTypeRef<BatchDeleteResponse>(),
            )

        assertThat(roundtrippedBatchDeleteResponse).isEqualTo(batchDeleteResponse)
    }
}
