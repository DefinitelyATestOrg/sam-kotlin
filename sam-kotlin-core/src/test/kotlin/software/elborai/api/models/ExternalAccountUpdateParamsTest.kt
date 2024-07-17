// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class ExternalAccountUpdateParamsTest {

    @Test
    fun createExternalAccountUpdateParams() {
        ExternalAccountUpdateParams.builder()
            .externalAccountId("string")
            .accountHolder(ExternalAccountUpdateParams.AccountHolder.BUSINESS)
            .description("x")
            .funding(ExternalAccountUpdateParams.Funding.CHECKING)
            .status(ExternalAccountUpdateParams.Status.ACTIVE)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ExternalAccountUpdateParams.builder()
                .externalAccountId("string")
                .accountHolder(ExternalAccountUpdateParams.AccountHolder.BUSINESS)
                .description("x")
                .funding(ExternalAccountUpdateParams.Funding.CHECKING)
                .status(ExternalAccountUpdateParams.Status.ACTIVE)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountHolder())
            .isEqualTo(ExternalAccountUpdateParams.AccountHolder.BUSINESS)
        assertThat(body.description()).isEqualTo("x")
        assertThat(body.funding()).isEqualTo(ExternalAccountUpdateParams.Funding.CHECKING)
        assertThat(body.status()).isEqualTo(ExternalAccountUpdateParams.Status.ACTIVE)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = ExternalAccountUpdateParams.builder().externalAccountId("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = ExternalAccountUpdateParams.builder().externalAccountId("string").build()
        assertThat(params).isNotNull
        // path param "externalAccountId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
