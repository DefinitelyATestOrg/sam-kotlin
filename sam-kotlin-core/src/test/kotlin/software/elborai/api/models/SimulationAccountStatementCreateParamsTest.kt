// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class SimulationAccountStatementCreateParamsTest {

    @Test
    fun createSimulationAccountStatementCreateParams() {
        SimulationAccountStatementCreateParams.builder().accountId("account_id").build()
    }

    @Test
    fun getBody() {
        val params =
            SimulationAccountStatementCreateParams.builder().accountId("account_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountId()).isEqualTo("account_id")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            SimulationAccountStatementCreateParams.builder().accountId("account_id").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.accountId()).isEqualTo("account_id")
    }
}
