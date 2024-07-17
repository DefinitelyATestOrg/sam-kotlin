// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class EventSubscriptionUpdateParamsTest {

    @Test
    fun createEventSubscriptionUpdateParams() {
        EventSubscriptionUpdateParams.builder()
            .eventSubscriptionId("string")
            .status(EventSubscriptionUpdateParams.Status.ACTIVE)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            EventSubscriptionUpdateParams.builder()
                .eventSubscriptionId("string")
                .status(EventSubscriptionUpdateParams.Status.ACTIVE)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.status()).isEqualTo(EventSubscriptionUpdateParams.Status.ACTIVE)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = EventSubscriptionUpdateParams.builder().eventSubscriptionId("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = EventSubscriptionUpdateParams.builder().eventSubscriptionId("string").build()
        assertThat(params).isNotNull
        // path param "eventSubscriptionId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
