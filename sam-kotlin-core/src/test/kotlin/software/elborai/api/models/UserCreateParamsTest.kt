// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class UserCreateParamsTest {

    @Test
    fun createUserCreateParams() {
        UserCreateParams.builder()
            .id(123L)
            .email("john@email.com")
            .firstName("John")
            .lastName("James")
            .password("12345")
            .phone("12345")
            .username("theUser")
            .userStatus(123L)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            UserCreateParams.builder()
                .id(123L)
                .email("john@email.com")
                .firstName("John")
                .lastName("James")
                .password("12345")
                .phone("12345")
                .username("theUser")
                .userStatus(123L)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.id()).isEqualTo(123L)
        assertThat(body.email()).isEqualTo("john@email.com")
        assertThat(body.firstName()).isEqualTo("John")
        assertThat(body.lastName()).isEqualTo("James")
        assertThat(body.password()).isEqualTo("12345")
        assertThat(body.phone()).isEqualTo("12345")
        assertThat(body.username()).isEqualTo("theUser")
        assertThat(body.userStatus()).isEqualTo(123L)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = UserCreateParams.builder().build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }
}
