// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.blocking

import com.sam.api.TestServerExtension
import com.sam.api.client.okhttp.SamOkHttpClient
import com.sam.api.models.User
import com.sam.api.models.UserCreateParams
import com.sam.api.models.UserCreateWithListParams
import com.sam.api.models.UserDeleteParams
import com.sam.api.models.UserLoginParams
import com.sam.api.models.UserLogoutParams
import com.sam.api.models.UserRetrieveParams
import com.sam.api.models.UserUpdateParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class UserServiceTest {

    @Test
    fun callCreate() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        val user =
            userService.create(
                UserCreateParams.builder()
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
        println(user)
        user.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        val user = userService.retrieve(UserRetrieveParams.builder().username("username").build())
        println(user)
        user.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        userService.update(
            UserUpdateParams.builder()
                .pathUsername("username")
                .id(10L)
                .email("john@email.com")
                .firstName("John")
                .lastName("James")
                .password("12345")
                .phone("12345")
                .bodyUsername("theUser")
                .userStatus(1L)
                .build()
        )
    }

    @Test
    fun callDelete() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        userService.delete(UserDeleteParams.builder().username("username").build())
    }

    @Test
    fun callCreateWithList() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        val user =
            userService.createWithList(
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
            )
        println(user)
        user.validate()
    }

    @Test
    fun callLogin() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        val userLoginResponse =
            userService.login(
                UserLoginParams.builder().password("password").username("username").build()
            )
        println(userLoginResponse)
        assertThat(userLoginResponse).isNotBlank()
    }

    @Test
    fun callLogout() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.users()
        userService.logout(UserLogoutParams.builder().build())
    }
}
