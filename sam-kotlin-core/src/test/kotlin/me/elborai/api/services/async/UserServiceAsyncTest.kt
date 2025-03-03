// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.models.User
import me.elborai.api.models.UserCreateListParams
import me.elborai.api.models.UserCreateParams
import me.elborai.api.models.UserDeleteParams
import me.elborai.api.models.UserLoginParams
import me.elborai.api.models.UserRetrieveParams
import me.elborai.api.models.UserUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class UserServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val user =
            userServiceAsync.create(
                UserCreateParams.builder()
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
            )

        user.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val user =
            userServiceAsync.retrieve(UserRetrieveParams.builder().username("username").build())

        user.validate()
    }

    @Test
    suspend fun update() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        userServiceAsync.update(
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
        )
    }

    @Test
    suspend fun delete() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        userServiceAsync.delete(UserDeleteParams.builder().username("username").build())
    }

    @Test
    suspend fun createList() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val user =
            userServiceAsync.createList(
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
            )

        user.validate()
    }

    @Test
    suspend fun login() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        userServiceAsync.login(
            UserLoginParams.builder().password("password").username("username").build()
        )
    }

    @Test
    suspend fun logout() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        userServiceAsync.logout()
    }
}
