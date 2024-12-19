// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StoreOrderRetrieveParamsTest {

    @Test
    fun createStoreOrderRetrieveParams() {
        StoreOrderRetrieveParams.builder().orderId(0L).build()
    }

    @Test
    fun getPathParam() {
        val params = StoreOrderRetrieveParams.builder().orderId(0L).build()
        assertThat(params).isNotNull
        // path param "orderId"
        assertThat(params.getPathParam(0)).isEqualTo("0")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
