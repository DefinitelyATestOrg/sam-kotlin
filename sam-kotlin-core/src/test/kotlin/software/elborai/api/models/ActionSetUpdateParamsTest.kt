// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class ActionSetUpdateParamsTest {

    @Test
    fun createActionSetUpdateParams() {
        ActionSetUpdateParams.builder()
            .pathId("string")
            .name("string")
            .bodyId("string")
            .agentId("string")
            .createdBy(
                ActionSetUpdateParams.CreatedBy.builder().id("string").name("string").build()
            )
            .openAPIUrl("string")
            .serverUrl("string")
            .type(ActionSetUpdateParams.Type.OPENAPI)
            .updatedBy(
                ActionSetUpdateParams.UpdatedBy.builder().id("string").name("string").build()
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ActionSetUpdateParams.builder()
                .pathId("string")
                .name("string")
                .bodyId("string")
                .agentId("string")
                .createdBy(
                    ActionSetUpdateParams.CreatedBy.builder().id("string").name("string").build()
                )
                .openAPIUrl("string")
                .serverUrl("string")
                .type(ActionSetUpdateParams.Type.OPENAPI)
                .updatedBy(
                    ActionSetUpdateParams.UpdatedBy.builder().id("string").name("string").build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("string")
        assertThat(body.bodyId()).isEqualTo("string")
        assertThat(body.agentId()).isEqualTo("string")
        assertThat(body.createdBy())
            .isEqualTo(
                ActionSetUpdateParams.CreatedBy.builder().id("string").name("string").build()
            )
        assertThat(body.openAPIUrl()).isEqualTo("string")
        assertThat(body.serverUrl()).isEqualTo("string")
        assertThat(body.type()).isEqualTo(ActionSetUpdateParams.Type.OPENAPI)
        assertThat(body.updatedBy())
            .isEqualTo(
                ActionSetUpdateParams.UpdatedBy.builder().id("string").name("string").build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = ActionSetUpdateParams.builder().pathId("string").name("string").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("string")
    }

    @Test
    fun getPathParam() {
        val params = ActionSetUpdateParams.builder().pathId("string").name("string").build()
        assertThat(params).isNotNull
        // path param "pathId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
