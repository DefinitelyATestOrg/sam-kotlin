// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages.batches

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.models.MessageBatchBetaTrueDeleteParams
import me.elborai.api.models.MessageBatchBetaTrueRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BetaTrueServiceAsyncTest {

    @Test
    suspend fun retrieve() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val betaTrueServiceAsync = client.messages().batches().betaTrue()

        val betaTrue =
            betaTrueServiceAsync.retrieve(
                MessageBatchBetaTrueRetrieveParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        betaTrue.validate()
    }

    @Test
    suspend fun delete() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val betaTrueServiceAsync = client.messages().batches().betaTrue()

        val betaTrue =
            betaTrueServiceAsync.delete(
                MessageBatchBetaTrueDeleteParams.builder()
                    .messageBatchId("message_batch_id")
                    .addAnthropicBeta("string")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        betaTrue.validate()
    }
}
