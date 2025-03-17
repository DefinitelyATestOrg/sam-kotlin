// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.models.models.ModelListParams
import me.elborai.api.models.models.ModelRetrieveBetaParams
import me.elborai.api.models.models.ModelRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelServiceTest {

    @Test
    fun retrieve() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelService = client.models()

        val model =
            modelService.retrieve(
                ModelRetrieveParams.builder()
                    .modelId("model_id")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        model.validate()
    }

    @Test
    fun list() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelService = client.models()

        val model =
            modelService.list(
                ModelListParams.builder()
                    .afterId("after_id")
                    .beforeId("before_id")
                    .limit(1L)
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        model.validate()
    }

    @Test
    fun retrieveBeta() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelService = client.models()

        val response =
            modelService.retrieveBeta(
                ModelRetrieveBetaParams.builder()
                    .modelId("model_id")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        response.validate()
    }
}
