// File generated from our OpenAPI spec by Stainless.

package com.sam.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserCreateWithListParamsTest {

    @Test
    fun createUserCreateWithListParams() {
        UserCreateWithListParams.builder()
            .body(
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
            .build()
    }

    @Test
    fun getBody() {
        val params =
            UserCreateWithListParams.builder()
                .body(
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
                .build()
        val body = params.getBody()
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
    fun getBodyWithoutOptionalFields() {
        val params = UserCreateWithListParams.builder().body(listOf(User.builder().build())).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body).isEqualTo(listOf(User.builder().build()))
    }
}
