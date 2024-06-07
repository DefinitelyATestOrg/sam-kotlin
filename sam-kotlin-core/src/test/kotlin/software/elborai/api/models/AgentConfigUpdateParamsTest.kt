// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class AgentConfigUpdateParamsTest {

    @Test
    fun createAgentConfigUpdateParams() {
        AgentConfigUpdateParams.builder()
            .agentId("string")
            .integration(AgentConfigUpdateParams.Integration.SALESFORCE)
            .class_("string")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AgentConfigUpdateParams.builder()
                .agentId("string")
                .integration(AgentConfigUpdateParams.Integration.SALESFORCE)
                .class_("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.class_()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AgentConfigUpdateParams.builder()
                .agentId("string")
                .integration(AgentConfigUpdateParams.Integration.SALESFORCE)
                .class_("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.class_()).isEqualTo("string")
    }

    @Test
    fun getPathParam() {
        val params =
            AgentConfigUpdateParams.builder()
                .agentId("string")
                .integration(AgentConfigUpdateParams.Integration.SALESFORCE)
                .class_("string")
                .build()
        assertThat(params).isNotNull
        // path param "agentId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // path param "integration"
        assertThat(params.getPathParam(1))
            .isEqualTo(AgentConfigUpdateParams.Integration.SALESFORCE.toString())
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
