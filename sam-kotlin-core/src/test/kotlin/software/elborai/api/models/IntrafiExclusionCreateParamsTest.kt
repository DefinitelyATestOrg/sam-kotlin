// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class IntrafiExclusionCreateParamsTest {

    @Test
    fun createIntrafiExclusionCreateParams() {
        IntrafiExclusionCreateParams.builder().bankName("x").entityId("string").build()
    }

    @Test
    fun getBody() {
        val params = IntrafiExclusionCreateParams.builder().bankName("x").entityId("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.bankName()).isEqualTo("x")
        assertThat(body.entityId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = IntrafiExclusionCreateParams.builder().bankName("x").entityId("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.bankName()).isEqualTo("x")
        assertThat(body.entityId()).isEqualTo("string")
    }
}
