// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
class UserServiceTest {

    @Test
    fun callCreate() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val userService = client.users()
        userService.create(
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
        )
    }

    @Test
    fun callRetrieve() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val userService = client.users()
        val user = userService.retrieve(UserRetrieveParams.builder().username("username").build())
        println(user)
        user.validate()
    }

    @Test
    fun callUpdate() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val userService = client.users()
        userService.update(
            UserUpdateParams.builder()
                .pathUsername("username")
                .id(123L)
                .email("john@email.com")
                .firstName("John")
                .lastName("James")
                .password("12345")
                .phone("12345")
                .bodyUsername("theUser")
                .userStatus(123L)
                .build()
        )
    }

    @Test
    fun callDelete() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val userService = client.users()
        userService.delete(UserDeleteParams.builder().username("username").build())
    }

    @Test
    fun callCreateWithList() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val userService = client.users()
        val user =
            userService.createWithList(
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
            )
        println(user)
        user.validate()
    }

    @Test
    fun callLogin() {
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
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
        val client = SamOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val userService = client.users()
        userService.logout(UserLogoutParams.builder().build())
    }
}
