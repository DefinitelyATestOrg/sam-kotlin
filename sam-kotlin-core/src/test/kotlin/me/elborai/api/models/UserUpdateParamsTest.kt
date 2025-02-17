// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserUpdateParamsTest {

    @Test
    fun create() {
        UserUpdateParams.builder()
            .username("username")
            .user(
                User.builder()
                    .id(10L)
                    .email("john@email.com")
                    .firstName("John")
                    .lastName("James")
                    .password("12345")
                    .phone("12345")
                    .username("theUser")
                    .userStatus(1L)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            UserUpdateParams.builder()
                .username("username")
                .user(
                    User.builder()
                        .id(10L)
                        .email("john@email.com")
                        .firstName("John")
                        .lastName("James")
                        .password("12345")
                        .phone("12345")
                        .username("theUser")
                        .userStatus(1L)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body)
            .isEqualTo(
                User.builder()
                    .id(10L)
                    .email("john@email.com")
                    .firstName("John")
                    .lastName("James")
                    .password("12345")
                    .phone("12345")
                    .username("theUser")
                    .userStatus(1L)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserUpdateParams.builder().username("username").user(User.builder().build()).build()

        val body = params._body()

        assertThat(body).isNotNull
        assertThat(body).isEqualTo(User.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            UserUpdateParams.builder().username("username").user(User.builder().build()).build()
        assertThat(params).isNotNull
        // path param "username"
        assertThat(params.getPathParam(0)).isEqualTo("username")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
