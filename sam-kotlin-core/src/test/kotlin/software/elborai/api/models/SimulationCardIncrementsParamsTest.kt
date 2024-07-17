// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class SimulationCardIncrementsParamsTest {

    @Test
    fun createSimulationCardIncrementsParams() {
        SimulationCardIncrementsParams.builder()
            .amount(123L)
            .cardPaymentId("string")
            .eventSubscriptionId("string")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            SimulationCardIncrementsParams.builder()
                .amount(123L)
                .cardPaymentId("string")
                .eventSubscriptionId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.amount()).isEqualTo(123L)
        assertThat(body.cardPaymentId()).isEqualTo("string")
        assertThat(body.eventSubscriptionId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            SimulationCardIncrementsParams.builder().amount(123L).cardPaymentId("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.amount()).isEqualTo(123L)
        assertThat(body.cardPaymentId()).isEqualTo("string")
    }
}
