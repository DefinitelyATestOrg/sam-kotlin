// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class IntrafiAccountEnrollmentCreateParamsTest {

    @Test
    fun createIntrafiAccountEnrollmentCreateParams() {
        IntrafiAccountEnrollmentCreateParams.builder().accountId("string").emailAddress("x").build()
    }

    @Test
    fun getBody() {
        val params =
            IntrafiAccountEnrollmentCreateParams.builder()
                .accountId("string")
                .emailAddress("x")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountId()).isEqualTo("string")
        assertThat(body.emailAddress()).isEqualTo("x")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            IntrafiAccountEnrollmentCreateParams.builder()
                .accountId("string")
                .emailAddress("x")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountId()).isEqualTo("string")
        assertThat(body.emailAddress()).isEqualTo("x")
    }
}
