// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class AgentConfigChatUpdateParamsTest {

    @Test
    fun createAgentConfigChatUpdateParams() {
        AgentConfigChatUpdateParams.builder()
            .agentId("string")
            .id("string")
            .welcomeMessage("string")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AgentConfigChatUpdateParams.builder()
                .agentId("string")
                .id("string")
                .welcomeMessage("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.id()).isEqualTo("string")
        assertThat(body.welcomeMessage()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = AgentConfigChatUpdateParams.builder().agentId("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params = AgentConfigChatUpdateParams.builder().agentId("string").build()
        assertThat(params).isNotNull
        // path param "agentId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
