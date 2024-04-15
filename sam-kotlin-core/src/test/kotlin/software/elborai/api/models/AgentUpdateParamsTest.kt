// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class AgentUpdateParamsTest {

    @Test
    fun createAgentUpdateParams() {
        AgentUpdateParams.builder()
            .id("string")
            .agent(
                AgentUpdateParams.Agent.builder()
                    .id("string")
                    .additionalPromptText("string")
                    .bailoutIntegration(AgentUpdateParams.Agent.BailoutIntegration.SALESFORCE)
                    .bailoutText("string")
                    .bailoutType(AgentUpdateParams.Agent.BailoutType.INTEGRATION)
                    .brandColor("string")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .createdBy(
                        AgentUpdateParams.Agent.CreatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
                    .hiddenTicketTags(listOf("string"))
                    .internalSalesStatus(AgentUpdateParams.Agent.InternalSalesStatus.LIVE)
                    .name("string")
                    .organizationId("string")
                    .persona(AgentUpdateParams.Agent.Persona.ANY)
                    .popularQuestions(listOf("string"))
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .updatedBy(
                        AgentUpdateParams.Agent.UpdatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
                    .build()
            )
            .chatIcon("some content")
            .chatIconDeleted(true)
            .logo("some content")
            .logoDeleted(true)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            AgentUpdateParams.builder()
                .id("string")
                .agent(
                    AgentUpdateParams.Agent.builder()
                        .id("string")
                        .additionalPromptText("string")
                        .bailoutIntegration(AgentUpdateParams.Agent.BailoutIntegration.SALESFORCE)
                        .bailoutText("string")
                        .bailoutType(AgentUpdateParams.Agent.BailoutType.INTEGRATION)
                        .brandColor("string")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .createdBy(
                            AgentUpdateParams.Agent.CreatedBy.builder()
                                .id("string")
                                .name("string")
                                .build()
                        )
                        .hiddenTicketTags(listOf("string"))
                        .internalSalesStatus(AgentUpdateParams.Agent.InternalSalesStatus.LIVE)
                        .name("string")
                        .organizationId("string")
                        .persona(AgentUpdateParams.Agent.Persona.ANY)
                        .popularQuestions(listOf("string"))
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .updatedBy(
                            AgentUpdateParams.Agent.UpdatedBy.builder()
                                .id("string")
                                .name("string")
                                .build()
                        )
                        .build()
                )
                .chatIcon("some content")
                .chatIconDeleted(true)
                .logo("some content")
                .logoDeleted(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.agent())
            .isEqualTo(
                AgentUpdateParams.Agent.builder()
                    .id("string")
                    .additionalPromptText("string")
                    .bailoutIntegration(AgentUpdateParams.Agent.BailoutIntegration.SALESFORCE)
                    .bailoutText("string")
                    .bailoutType(AgentUpdateParams.Agent.BailoutType.INTEGRATION)
                    .brandColor("string")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .createdBy(
                        AgentUpdateParams.Agent.CreatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
                    .hiddenTicketTags(listOf("string"))
                    .internalSalesStatus(AgentUpdateParams.Agent.InternalSalesStatus.LIVE)
                    .name("string")
                    .organizationId("string")
                    .persona(AgentUpdateParams.Agent.Persona.ANY)
                    .popularQuestions(listOf("string"))
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .updatedBy(
                        AgentUpdateParams.Agent.UpdatedBy.builder()
                            .id("string")
                            .name("string")
                            .build()
                    )
                    .build()
            )
        assertThat(body.chatIcon()).isEqualTo("some content")
        assertThat(body.chatIconDeleted()).isEqualTo(true)
        assertThat(body.logo()).isEqualTo("some content")
        assertThat(body.logoDeleted()).isEqualTo(true)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AgentUpdateParams.builder()
                .id("string")
                .agent(AgentUpdateParams.Agent.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.agent()).isEqualTo(AgentUpdateParams.Agent.builder().build())
    }

    @Test
    fun getPathParam() {
        val params =
            AgentUpdateParams.builder()
                .id("string")
                .agent(AgentUpdateParams.Agent.builder().build())
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
