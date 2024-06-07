// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.put
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import software.elborai.api.TestServerExtension
import software.elborai.api.client.okhttp.SamOkHttpClient
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.*

@ExtendWith(TestServerExtension::class)
@WireMockTest
class FeedbackServiceTest {

    @Test
    fun callUpdate(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .authToken("My Auth Token")
                .build()
        stubFor(put("/api/v1/feedbacks/{feedback_id}").willReturn(ok().withBody("abc")))
        val feedbackService = client.feedbacks()
        val response =
            feedbackService.update(
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
            )
        println(response)
        assertThat(response).isInstanceOf(BinaryResponseContent::class.java)
        assertThat(response.body()).hasBinaryContent("abc".toByteArray())
    }
}
