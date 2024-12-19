// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import me.elborai.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserLoginParamsTest {

    @Test
    fun createUserLoginParams() {
        UserLoginParams.builder().password("password").username("username").build()
    }

    @Test
    fun getQueryParams() {
        val params = UserLoginParams.builder().password("password").username("username").build()
        val expected = QueryParams.builder()
        expected.put("password", "password")
        expected.put("username", "username")
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = UserLoginParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }
}
