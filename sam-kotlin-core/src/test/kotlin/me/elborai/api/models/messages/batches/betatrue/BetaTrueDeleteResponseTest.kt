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
            BetaTrueDeleteResponse.builder().id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF").build()

        assertThat(betaTrueDeleteResponse.id()).isEqualTo("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaTrueDeleteResponse =
            BetaTrueDeleteResponse.builder().id("msgbatch_013Zva2CMHLNnXjNJJKqJ2EF").build()

        val roundtrippedBetaTrueDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaTrueDeleteResponse),
                jacksonTypeRef<BetaTrueDeleteResponse>(),
            )

        assertThat(roundtrippedBetaTrueDeleteResponse).isEqualTo(betaTrueDeleteResponse)
    }
}
