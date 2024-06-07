// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class AgentHiddenTagUpdateParamsTest {

    @Test
    fun createAgentHiddenTagUpdateParams() {
        AgentHiddenTagUpdateParams.builder().id("string").body(listOf("string")).build()
    }

    @Test
    fun getBody() {
        val params =
            AgentHiddenTagUpdateParams.builder().id("string").body(listOf("string")).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body).isEqualTo(listOf("string"))
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AgentHiddenTagUpdateParams.builder().id("string").body(listOf("string")).build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body).isEqualTo(listOf("string"))
    }

    @Test
    fun getPathParam() {
        val params =
            AgentHiddenTagUpdateParams.builder().id("string").body(listOf("string")).build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
