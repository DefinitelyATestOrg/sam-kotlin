// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.complete

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompleteCreateResponseTest {

    @Test
    fun create() {
        val completeCreateResponse =
            CompleteCreateResponse.builder()
                .id("compl_018CKm6gsux7P8yMcwZbeCPw")
                .completion(" Hello! My name is Claude.")
                .model("claude-2.1")
                .stopReason("stop_sequence")
                .build()

        assertThat(completeCreateResponse.id()).isEqualTo("compl_018CKm6gsux7P8yMcwZbeCPw")
        assertThat(completeCreateResponse.completion()).isEqualTo(" Hello! My name is Claude.")
        assertThat(completeCreateResponse.model()).isEqualTo("claude-2.1")
        assertThat(completeCreateResponse.stopReason()).isEqualTo("stop_sequence")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completeCreateResponse =
            CompleteCreateResponse.builder()
                .id("compl_018CKm6gsux7P8yMcwZbeCPw")
                .completion(" Hello! My name is Claude.")
                .model("claude-2.1")
                .stopReason("stop_sequence")
                .build()

        val roundtrippedCompleteCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completeCreateResponse),
                jacksonTypeRef<CompleteCreateResponse>(),
            )

        assertThat(roundtrippedCompleteCreateResponse).isEqualTo(completeCreateResponse)
    }
}
