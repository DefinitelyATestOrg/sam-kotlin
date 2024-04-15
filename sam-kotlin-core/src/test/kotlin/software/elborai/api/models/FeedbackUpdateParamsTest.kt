// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.elborai.api.models.*

class FeedbackUpdateParamsTest {

    @Test
    fun createFeedbackUpdateParams() {
        FeedbackUpdateParams.builder()
            .feedbackId("string")
            .agentId("string")
            .ticketMessageId("string")
            .id("string")
            .createdBy(FeedbackUpdateParams.CreatedBy.builder().id("string").name("string").build())
            .text("string")
            .type(FeedbackUpdateParams.Type.THUMBS_UP)
            .updatedBy(FeedbackUpdateParams.UpdatedBy.builder().id("string").name("string").build())
            .build()
    }

    @Test
    fun getBody() {
        val params =
            FeedbackUpdateParams.builder()
                .feedbackId("string")
                .agentId("string")
                .ticketMessageId("string")
                .id("string")
                .createdBy(
                    FeedbackUpdateParams.CreatedBy.builder().id("string").name("string").build()
                )
                .text("string")
                .type(FeedbackUpdateParams.Type.THUMBS_UP)
                .updatedBy(
                    FeedbackUpdateParams.UpdatedBy.builder().id("string").name("string").build()
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.agentId()).isEqualTo("string")
        assertThat(body.ticketMessageId()).isEqualTo("string")
        assertThat(body.id()).isEqualTo("string")
        assertThat(body.createdBy())
            .isEqualTo(FeedbackUpdateParams.CreatedBy.builder().id("string").name("string").build())
        assertThat(body.text()).isEqualTo("string")
        assertThat(body.type()).isEqualTo(FeedbackUpdateParams.Type.THUMBS_UP)
        assertThat(body.updatedBy())
            .isEqualTo(FeedbackUpdateParams.UpdatedBy.builder().id("string").name("string").build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            FeedbackUpdateParams.builder()
                .feedbackId("string")
                .agentId("string")
                .ticketMessageId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.agentId()).isEqualTo("string")
        assertThat(body.ticketMessageId()).isEqualTo("string")
    }

    @Test
    fun getPathParam() {
        val params =
            FeedbackUpdateParams.builder()
                .feedbackId("string")
                .agentId("string")
                .ticketMessageId("string")
                .build()
        assertThat(params).isNotNull
        // path param "feedbackId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
