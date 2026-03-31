// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages.batches

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class BetaTrueServiceTest {

    @Test
    fun retrieve() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val betaTrueService = client.messages().batches().betaTrue()

        val betaTrue =
            betaTrueService.retrieve(
                BetaTrueRetrieveParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        betaTrue.validate()
    }

    @Test
    fun delete() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val betaTrueService = client.messages().batches().betaTrue()

        val betaTrue =
            betaTrueService.delete(
                BetaTrueDeleteParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        betaTrue.validate()
    }
}
