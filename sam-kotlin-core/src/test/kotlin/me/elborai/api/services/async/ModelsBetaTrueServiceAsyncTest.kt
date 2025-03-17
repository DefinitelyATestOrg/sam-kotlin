// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.models.modelsbetatrue.ModelsBetaTrueListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelsBetaTrueServiceAsyncTest {

    @Test
    suspend fun list() {
        val client =
            SamOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelsBetaTrueServiceAsync = client.modelsBetaTrue()

        val modelsBetaTrue =
            modelsBetaTrueServiceAsync.list(
                ModelsBetaTrueListParams.builder()
                    .afterId("after_id")
                    .beforeId("before_id")
                    .limit(1L)
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        modelsBetaTrue.validate()
    }
}
