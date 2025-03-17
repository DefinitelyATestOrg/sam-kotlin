// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.models.models.ModelListParams
import me.elborai.api.models.models.ModelRetrieveBetaParams
import me.elborai.api.models.models.ModelRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelServiceAsyncTest {

    @Test
    suspend fun retrieve() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelServiceAsync = client.models()

        val model =
            modelServiceAsync.retrieve(
                ModelRetrieveParams.builder()
                    .modelId("model_id")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        model.validate()
    }

    @Test
    suspend fun list() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelServiceAsync = client.models()

        val model =
            modelServiceAsync.list(
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
    suspend fun retrieveBeta() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelServiceAsync = client.models()

        val response =
            modelServiceAsync.retrieveBeta(
                ModelRetrieveBetaParams.builder()
                    .modelId("model_id")
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        response.validate()
    }
}
