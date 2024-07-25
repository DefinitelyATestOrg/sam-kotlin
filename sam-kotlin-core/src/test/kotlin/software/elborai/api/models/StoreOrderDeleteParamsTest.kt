// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class StoreOrderDeleteParamsTest {

    @Test
    fun createStoreOrderDeleteParams() {
        StoreOrderDeleteParams.builder().orderId(123L).build()
    }

    @Test
    fun getPathParam() {
        val params = StoreOrderDeleteParams.builder().orderId(123L).build()
        assertThat(params).isNotNull
        // path param "orderId"
        assertThat(params.getPathParam(0)).isEqualTo("123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
