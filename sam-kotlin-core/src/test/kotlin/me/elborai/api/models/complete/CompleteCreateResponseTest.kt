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
                .type(CompleteCreateResponse.Type.COMPLETION)
                .build()

        assertThat(completeCreateResponse.id()).isEqualTo("compl_018CKm6gsux7P8yMcwZbeCPw")
        assertThat(completeCreateResponse.completion()).isEqualTo(" Hello! My name is Claude.")
        assertThat(completeCreateResponse.model()).isEqualTo("claude-2.1")
        assertThat(completeCreateResponse.stopReason()).isEqualTo("stop_sequence")
        assertThat(completeCreateResponse.type()).isEqualTo(CompleteCreateResponse.Type.COMPLETION)
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
                .type(CompleteCreateResponse.Type.COMPLETION)
                .build()

        val roundtrippedCompleteCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completeCreateResponse),
                jacksonTypeRef<CompleteCreateResponse>(),
            )

        assertThat(roundtrippedCompleteCreateResponse).isEqualTo(completeCreateResponse)
    }
}
