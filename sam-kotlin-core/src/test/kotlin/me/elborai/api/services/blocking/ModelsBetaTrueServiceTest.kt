// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.models.modelsbetatrue.ModelsBetaTrueListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelsBetaTrueServiceTest {

    @Test
    fun list() {
        val client =
            SamOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val modelsBetaTrueService = client.modelsBetaTrue()

        val modelsBetaTrues =
            modelsBetaTrueService.list(
                ModelsBetaTrueListParams.builder()
                    .afterId("after_id")
                    .beforeId("before_id")
                    .limit(1L)
                    .anthropicVersion("anthropic-version")
                    .xApiKey("x-api-key")
                    .build()
            )

        modelsBetaTrues.validate()
    }
}
