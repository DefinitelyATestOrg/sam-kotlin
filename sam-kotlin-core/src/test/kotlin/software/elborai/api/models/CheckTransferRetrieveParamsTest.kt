// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class CheckTransferRetrieveParamsTest {

    @Test
    fun createCheckTransferRetrieveParams() {
        CheckTransferRetrieveParams.builder().checkTransferId("string").build()
    }

    @Test
    fun getPathParam() {
        val params = CheckTransferRetrieveParams.builder().checkTransferId("string").build()
        assertThat(params).isNotNull
        // path param "checkTransferId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
