// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches.betatrue

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
}
