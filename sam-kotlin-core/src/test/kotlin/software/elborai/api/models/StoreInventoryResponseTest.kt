// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StoreInventoryResponseTest {

    @Test
    fun createStoreInventoryResponse() {
        val storeInventoryResponse = StoreInventoryResponse.builder().build()
        assertThat(storeInventoryResponse).isNotNull
    }
}
