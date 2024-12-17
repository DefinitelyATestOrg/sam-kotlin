// File generated from our OpenAPI spec by Stainless.

package com.sam.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StoreOrderDeleteParamsTest {

    @Test
    fun createStoreOrderDeleteParams() {
        StoreOrderDeleteParams.builder().orderId(0L).build()
    }

    @Test
    fun getPathParam() {
        val params = StoreOrderDeleteParams.builder().orderId(0L).build()
        assertThat(params).isNotNull
        // path param "orderId"
        assertThat(params.getPathParam(0)).isEqualTo("0")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
