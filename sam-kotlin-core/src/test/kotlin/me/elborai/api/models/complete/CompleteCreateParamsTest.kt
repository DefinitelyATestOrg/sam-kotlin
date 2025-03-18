// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.complete

import kotlin.test.assertNotNull
import me.elborai.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompleteCreateParamsTest {

    @Test
    fun create() {
        CompleteCreateParams.builder()
            .anthropicVersion("anthropic-version")
            .xApiKey("x-api-key")
            .maxTokensToSample(256L)
            .model("claude-2.1")
            .prompt("\n\nHuman: Hello, world!\n\nAssistant:")
            .metadata(
                CompleteCreateParams.Metadata.builder()
                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                    .build()
            )
            .addStopSequence("string")
            .stream(true)
            .temperature(1.0)
            .topK(5L)
            .topP(0.7)
            .build()
    }

    @Test
    fun headers() {
        val params =
            CompleteCreateParams.builder()
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .maxTokensToSample(256L)
                .model("claude-2.1")
                .prompt("\n\nHuman: Hello, world!\n\nAssistant:")
                .metadata(
                    CompleteCreateParams.Metadata.builder()
                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                        .build()
                )
                .addStopSequence("string")
                .stream(true)
                .temperature(1.0)
                .topK(5L)
                .topP(0.7)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("anthropic-version", "anthropic-version")
                    .put("x-api-key", "x-api-key")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            CompleteCreateParams.builder()
                .maxTokensToSample(256L)
                .model("claude-2.1")
                .prompt("\n\nHuman: Hello, world!\n\nAssistant:")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            CompleteCreateParams.builder()
                .anthropicVersion("anthropic-version")
                .xApiKey("x-api-key")
                .maxTokensToSample(256L)
                .model("claude-2.1")
                .prompt("\n\nHuman: Hello, world!\n\nAssistant:")
                .metadata(
                    CompleteCreateParams.Metadata.builder()
                        .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                        .build()
                )
                .addStopSequence("string")
                .stream(true)
                .temperature(1.0)
                .topK(5L)
                .topP(0.7)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.maxTokensToSample()).isEqualTo(256L)
        assertThat(body.model()).isEqualTo("claude-2.1")
        assertThat(body.prompt()).isEqualTo("\n\nHuman: Hello, world!\n\nAssistant:")
        assertThat(body.metadata())
            .isEqualTo(
                CompleteCreateParams.Metadata.builder()
                    .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
                    .build()
            )
        assertThat(body.stopSequences()).containsExactly("string")
        assertThat(body.stream()).isEqualTo(true)
        assertThat(body.temperature()).isEqualTo(1.0)
        assertThat(body.topK()).isEqualTo(5L)
        assertThat(body.topP()).isEqualTo(0.7)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CompleteCreateParams.builder()
                .maxTokensToSample(256L)
                .model("claude-2.1")
                .prompt("\n\nHuman: Hello, world!\n\nAssistant:")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.maxTokensToSample()).isEqualTo(256L)
        assertThat(body.model()).isEqualTo("claude-2.1")
        assertThat(body.prompt()).isEqualTo("\n\nHuman: Hello, world!\n\nAssistant:")
    }
}
