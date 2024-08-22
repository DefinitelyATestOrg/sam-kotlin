// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest {

    @Test
    fun createUser() {
        val user =
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
        assertThat(user).isNotNull
        assertThat(user.id()).isEqualTo(123L)
        assertThat(user.email()).isEqualTo("john@email.com")
        assertThat(user.firstName()).isEqualTo("John")
        assertThat(user.lastName()).isEqualTo("James")
        assertThat(user.password()).isEqualTo("12345")
        assertThat(user.phone()).isEqualTo("12345")
        assertThat(user.username()).isEqualTo("theUser")
        assertThat(user.userStatus()).isEqualTo(123L)
    }
}