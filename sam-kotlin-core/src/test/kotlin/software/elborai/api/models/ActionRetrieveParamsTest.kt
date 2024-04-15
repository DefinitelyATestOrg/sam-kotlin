// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class ActionRetrieveParamsTest {

    @Test
    fun createActionRetrieveParams() {
        ActionRetrieveParams.builder().actionId("string").build()
    }

    @Test
    fun getPathParam() {
        val params = ActionRetrieveParams.builder().actionId("string").build()
        assertThat(params).isNotNull
        // path param "actionId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
