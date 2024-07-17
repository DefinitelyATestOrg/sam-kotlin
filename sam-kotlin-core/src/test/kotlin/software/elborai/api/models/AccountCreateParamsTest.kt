// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class AccountCreateParamsTest {

    @Test
    fun createAccountCreateParams() {
        AccountCreateParams.builder()
            .name("x")
            .entityId("string")
            .informationalEntityId("string")
            .programId("string")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AccountCreateParams.builder()
                .name("x")
                .entityId("string")
                .informationalEntityId("string")
                .programId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("x")
        assertThat(body.entityId()).isEqualTo("string")
        assertThat(body.informationalEntityId()).isEqualTo("string")
        assertThat(body.programId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = AccountCreateParams.builder().name("x").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("x")
    }
}
