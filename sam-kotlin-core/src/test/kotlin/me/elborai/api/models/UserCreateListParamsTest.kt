// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserCreateListParamsTest {

    @Test
    fun create() {
        UserCreateListParams.builder()
            .addBody(
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
            UserCreateListParams.builder()
                .addBody(
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
                listOf(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserCreateListParams.builder().addBody(User.builder().build()).build()
        val body = params._body()
        assertThat(body).isNotNull
        assertThat(body).isEqualTo(listOf(User.builder().build()))
    }
}
