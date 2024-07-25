// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class StoreCreateOrderParamsTest {

    @Test
    fun createStoreCreateOrderParams() {
        StoreCreateOrderParams.builder()
            .id(123L)
            .complete(true)
            .petId(123L)
            .quantity(123L)
            .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .status(StoreCreateOrderParams.Status.PLACED)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            StoreCreateOrderParams.builder()
                .id(123L)
                .complete(true)
                .petId(123L)
                .quantity(123L)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(StoreCreateOrderParams.Status.PLACED)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.id()).isEqualTo(123L)
        assertThat(body.complete()).isEqualTo(true)
        assertThat(body.petId()).isEqualTo(123L)
        assertThat(body.quantity()).isEqualTo(123L)
        assertThat(body.shipDate()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(body.status()).isEqualTo(StoreCreateOrderParams.Status.PLACED)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = StoreCreateOrderParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
