// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.TestServerExtension
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.models.complete.CompleteCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CompleteServiceAsyncTest {

    @Test
    suspend fun create() {
      val client = SamOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val completeServiceAsync = client.complete()

      val complete = completeServiceAsync.create(CompleteCreateParams.builder()
          .anthropicVersion("anthropic-version")
          .xApiKey("x-api-key")
          .maxTokensToSample(256L)
          .model("claude-2.1")
          .prompt("\n\nHuman: Hello, world!\n\nAssistant:")
          .metadata(CompleteCreateParams.Metadata.builder()
              .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
              .build())
          .addStopSequence("string")
          .stream(true)
          .temperature(1.0)
          .topK(5L)
          .topP(0.7)
          .build())

      complete.validate()
    }
}
