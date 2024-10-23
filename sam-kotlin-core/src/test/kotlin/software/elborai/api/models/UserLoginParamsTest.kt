// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class UserLoginParamsTest {

    @Test
    fun createUserLoginParams() {
        UserLoginParams.builder().password("password").username("username").build()
    }

    @Test
    fun getQueryParams() {
        val params = UserLoginParams.builder().password("password").username("username").build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("password", listOf("password"))
        expected.put("username", listOf("username"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = UserLoginParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
