// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.core.jsonMapper
import me.elborai.api.models.messages.MessageCreateResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/sam-kotlin-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = SamOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.store()).isNotNull()
        assertThat(client.user()).isNotNull()
        assertThat(client.messages()).isNotNull()
        assertThat(client.complete()).isNotNull()
        assertThat(client.models()).isNotNull()
        assertThat(client.messagesBetaTrue()).isNotNull()
        assertThat(client.modelsBetaTrue()).isNotNull()
        assertThat(client.samPlopPlop()).isNotNull()
    }

    @Test
    fun messageCreateResponseRoundtrip() {
        val jsonMapper = jsonMapper()
        val messageCreateResponse =
            MessageCreateResponse.builder()
                .id("msg_013Zva2CMHLNnXjNJJKqJ2EF")
                .addContent(
                    MessageCreateResponse.Content.Text.builder()
                        .addCitation(
                            MessageCreateResponse.Content.Text.Citation.CharLocation.builder()
                                .citedText("cited_text")
                                .documentIndex(0L)
                                .documentTitle("document_title")
                                .endCharIndex(0L)
                                .startCharIndex(0L)
                                .build()
                        )
                        .text("Hi! My name is Claude.")
                        .build()
                )
                .model("claude-3-7-sonnet-20250219")
                .stopReason(MessageCreateResponse.StopReason.END_TURN)
                .stopSequence(null)
                .usage(
                    MessageCreateResponse.Usage.builder()
                        .cacheCreationInputTokens(2051L)
                        .cacheReadInputTokens(2051L)
                        .inputTokens(2095L)
                        .outputTokens(503L)
                        .build()
                )
                .build()

        val roundtrippedMessageCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageCreateResponse),
                jacksonTypeRef<MessageCreateResponse>(),
            )

        assertThat(roundtrippedMessageCreateResponse).isEqualTo(messageCreateResponse)
    }
}
