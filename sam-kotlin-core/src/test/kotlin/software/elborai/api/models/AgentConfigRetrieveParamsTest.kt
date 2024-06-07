// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class AgentConfigRetrieveParamsTest {

    @Test
    fun createAgentConfigRetrieveParams() {
        AgentConfigRetrieveParams.builder()
            .agentId("string")
            .integration(AgentConfigRetrieveParams.Integration.SALESFORCE)
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            AgentConfigRetrieveParams.builder()
                .agentId("string")
                .integration(AgentConfigRetrieveParams.Integration.SALESFORCE)
                .build()
        assertThat(params).isNotNull
        // path param "agentId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // path param "integration"
        assertThat(params.getPathParam(1))
            .isEqualTo(AgentConfigRetrieveParams.Integration.SALESFORCE.toString())
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
