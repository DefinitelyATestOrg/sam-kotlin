// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class UserCreateWithListParamsTest {

    @Test
    fun createUserCreateWithListParams() {
        UserCreateWithListParams.builder()
            .body(
                listOf(
                    User.builder()
                        .id(123L)
                        .email("john@email.com")
                        .firstName("John")
                        .lastName("James")
                        .password("12345")
                        .phone("12345")
                        .username("theUser")
                        .userStatus(123L)
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
                            .id(123L)
                            .email("john@email.com")
                            .firstName("John")
                            .lastName("James")
                            .password("12345")
                            .phone("12345")
                            .username("theUser")
                            .userStatus(123L)
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
                        .id(123L)
                        .email("john@email.com")
                        .firstName("John")
                        .lastName("James")
                        .password("12345")
                        .phone("12345")
                        .username("theUser")
                        .userStatus(123L)
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
