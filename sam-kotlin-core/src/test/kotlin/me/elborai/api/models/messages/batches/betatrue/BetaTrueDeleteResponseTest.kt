// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches.betatrue

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import me.elborai.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaTrueDeleteResponseTest {

    @Test
    fun create() {
        val betaTrueDeleteResponse =
            BetaTrueDeleteResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .type(BetaTrueDeleteResponse.Type.MESSAGE_BATCH_DELETED)
                .build()

        assertThat(betaTrueDeleteResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
        assertThat(betaTrueDeleteResponse.type())
            .isEqualTo(BetaTrueDeleteResponse.Type.MESSAGE_BATCH_DELETED)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaTrueDeleteResponse =
            BetaTrueDeleteResponse.builder()
                .id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
                .type(BetaTrueDeleteResponse.Type.MESSAGE_BATCH_DELETED)
                .build()

        val roundtrippedBetaTrueDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTrueDeleteResponse),
                jacksonTypeRef<BetaTrueDeleteResponse>(),
            )

        assertThat(roundtrippedBetaTrueDeleteResponse).isEqualTo(betaTrueDeleteResponse)
    }
}
