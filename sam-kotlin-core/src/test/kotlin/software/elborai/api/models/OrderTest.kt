// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun createOrder() {
        val order =
            Order.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Order.Status.PLACED)
                .build()
        assertThat(order).isNotNull
        assertThat(order.id()).isEqualTo(123L)
        assertThat(order.complete()).isEqualTo(true)
        assertThat(order.petId()).isEqualTo(123L)
        assertThat(order.quantity()).isEqualTo(123L)
        assertThat(order.shipDate()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(order.status()).isEqualTo(Order.Status.PLACED)
    }
}
