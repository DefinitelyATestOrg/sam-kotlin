// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class UserDeleteParamsTest {

    @Test
    fun createUserDeleteParams() {
        UserDeleteParams.builder().username("username").build()
    }

    @Test
    fun getPathParam() {
        val params = UserDeleteParams.builder().username("username").build()
        assertThat(params).isNotNull
        // path param "username"
        assertThat(params.getPathParam(0)).isEqualTo("username")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
