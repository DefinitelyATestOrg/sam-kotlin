// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CoolOrderTest {

    @Test
    fun createCoolOrder() {
        val coolOrder =
            CoolOrder.builder()
                .id(10L)
                .complete(true)
                .petId(198772L)
                .quantity(7L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(CoolOrder.Status.PLACED)
                .build()
        assertThat(coolOrder).isNotNull
        assertThat(coolOrder.id()).isEqualTo(10L)
        assertThat(coolOrder.complete()).isEqualTo(true)
        assertThat(coolOrder.petId()).isEqualTo(198772L)
        assertThat(coolOrder.quantity()).isEqualTo(7L)
        assertThat(coolOrder.shipDate()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(coolOrder.status()).isEqualTo(CoolOrder.Status.PLACED)
    }
}
