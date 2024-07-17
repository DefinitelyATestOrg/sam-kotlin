// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class EventSubscriptionRetrieveParamsTest {

    @Test
    fun createEventSubscriptionRetrieveParams() {
        EventSubscriptionRetrieveParams.builder().eventSubscriptionId("string").build()
    }

    @Test
    fun getPathParam() {
        val params = EventSubscriptionRetrieveParams.builder().eventSubscriptionId("string").build()
        assertThat(params).isNotNull
        // path param "eventSubscriptionId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
