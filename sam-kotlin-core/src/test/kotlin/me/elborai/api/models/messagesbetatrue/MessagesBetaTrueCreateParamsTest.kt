// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messagesbetatrue

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessagesBetaTrueCreateParamsTest {

    @Test
    fun create() {
      MessagesBetaTrueCreateParams.builder()
          .addAnthropicBeta("string")
          .anthropicVersion("anthropic-version")
          .xApiKey("x-api-key")
          .maxTokens(1024L)
          .addMessage(MessagesBetaTrueCreateParams.Message.builder()
              .content("Hello, world")
              .role(MessagesBetaTrueCreateParams.Message.Role.USER)
              .build())
          .model("claude-3-7-sonnet-20250219")
          .metadata(MessagesBetaTrueCreateParams.Metadata.builder()
              .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
              .build())
          .addStopSequence("string")
          .stream(true)
          .systemOfBetaRequestTextBlocks(listOf(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.builder()
              .text("Today's date is 2024-06-01.")
              .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Type.TEXT)
              .cacheControl(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.CacheControl.builder()
                  .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.CacheControl.Type.EPHEMERAL)
                  .build())
              .addCitation(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.builder()
                  .citedText("cited_text")
                  .documentIndex(0L)
                  .documentTitle("x")
                  .endCharIndex(0L)
                  .startCharIndex(0L)
                  .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.Type.CHAR_LOCATION)
                  .build())
              .build()))
          .temperature(1.0)
          .betaThinkingConfigEnabledThinking(1024L)
          .toolChoice(MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.builder()
              .type(MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO)
              .disableParallelToolUse(true)
              .build())
          .addTool(MessagesBetaTrueCreateParams.Tool.BetaTool.builder()
              .inputSchema(MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.builder()
                  .type(MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.Type.OBJECT)
                  .properties(JsonValue.from(mapOf(
                    "location" to mapOf(
                      "description" to "The city and state, e.g. San Francisco, CA", "type" to "string"
                    ), "unit" to mapOf(
                      "description" to "Unit for the output - one of (celsius, fahrenheit)", "type" to "string"
                    )
                  )))
                  .build())
              .name("name")
              .cacheControl(MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.builder()
                  .type(MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.Type.EPHEMERAL)
                  .build())
              .description("Get the current weather in a given location")
              .type(MessagesBetaTrueCreateParams.Tool.BetaTool.Type.CUSTOM)
              .build())
          .topK(5L)
          .topP(0.7)
          .build()
    }

    @Test
    fun body() {
      val params = MessagesBetaTrueCreateParams.builder()
          .addAnthropicBeta("string")
          .anthropicVersion("anthropic-version")
          .xApiKey("x-api-key")
          .maxTokens(1024L)
          .addMessage(MessagesBetaTrueCreateParams.Message.builder()
              .content("Hello, world")
              .role(MessagesBetaTrueCreateParams.Message.Role.USER)
              .build())
          .model("claude-3-7-sonnet-20250219")
          .metadata(MessagesBetaTrueCreateParams.Metadata.builder()
              .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
              .build())
          .addStopSequence("string")
          .stream(true)
          .systemOfBetaRequestTextBlocks(listOf(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.builder()
              .text("Today's date is 2024-06-01.")
              .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Type.TEXT)
              .cacheControl(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.CacheControl.builder()
                  .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.CacheControl.Type.EPHEMERAL)
                  .build())
              .addCitation(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.builder()
                  .citedText("cited_text")
                  .documentIndex(0L)
                  .documentTitle("x")
                  .endCharIndex(0L)
                  .startCharIndex(0L)
                  .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.Type.CHAR_LOCATION)
                  .build())
              .build()))
          .temperature(1.0)
          .betaThinkingConfigEnabledThinking(1024L)
          .toolChoice(MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.builder()
              .type(MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO)
              .disableParallelToolUse(true)
              .build())
          .addTool(MessagesBetaTrueCreateParams.Tool.BetaTool.builder()
              .inputSchema(MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.builder()
                  .type(MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.Type.OBJECT)
                  .properties(JsonValue.from(mapOf(
                    "location" to mapOf(
                      "description" to "The city and state, e.g. San Francisco, CA", "type" to "string"
                    ), "unit" to mapOf(
                      "description" to "Unit for the output - one of (celsius, fahrenheit)", "type" to "string"
                    )
                  )))
                  .build())
              .name("name")
              .cacheControl(MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.builder()
                  .type(MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.Type.EPHEMERAL)
                  .build())
              .description("Get the current weather in a given location")
              .type(MessagesBetaTrueCreateParams.Tool.BetaTool.Type.CUSTOM)
              .build())
          .topK(5L)
          .topP(0.7)
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.maxTokens()).isEqualTo(1024L)
      assertThat(body.messages()).isEqualTo(listOf(MessagesBetaTrueCreateParams.Message.builder()
          .content("Hello, world")
          .role(MessagesBetaTrueCreateParams.Message.Role.USER)
          .build()))
      assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
      assertThat(body.metadata()).isEqualTo(MessagesBetaTrueCreateParams.Metadata.builder()
          .userId("13803d75-b4b5-4c3e-b2a2-6f21399b021b")
          .build())
      assertThat(body.stopSequences()).isEqualTo(listOf("string"))
      assertThat(body.stream()).isEqualTo(true)
      assertThat(body.system()).isEqualTo(MessagesBetaTrueCreateParams.System.ofBetaRequestTextBlocks(listOf(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.builder()
          .text("Today's date is 2024-06-01.")
          .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Type.TEXT)
          .cacheControl(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.CacheControl.builder()
              .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.CacheControl.Type.EPHEMERAL)
              .build())
          .addCitation(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.builder()
              .citedText("cited_text")
              .documentIndex(0L)
              .documentTitle("x")
              .endCharIndex(0L)
              .startCharIndex(0L)
              .type(MessagesBetaTrueCreateParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.Type.CHAR_LOCATION)
              .build())
          .build())))
      assertThat(body.temperature()).isEqualTo(1.0)
      assertThat(body.thinking()).isEqualTo(MessagesBetaTrueCreateParams.Thinking.ofBetaThinkingConfigEnabled(MessagesBetaTrueCreateParams.Thinking.BetaThinkingConfigEnabled.builder()
          .budgetTokens(1024L)
          .type(MessagesBetaTrueCreateParams.Thinking.BetaThinkingConfigEnabled.Type.ENABLED)
          .build()))
      assertThat(body.toolChoice()).isEqualTo(MessagesBetaTrueCreateParams.ToolChoice.ofBetaToolChoiceAuto(MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.builder()
          .type(MessagesBetaTrueCreateParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO)
          .disableParallelToolUse(true)
          .build()))
      assertThat(body.tools()).isEqualTo(listOf(MessagesBetaTrueCreateParams.Tool.ofBeta(MessagesBetaTrueCreateParams.Tool.BetaTool.builder()
          .inputSchema(MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.builder()
              .type(MessagesBetaTrueCreateParams.Tool.BetaTool.InputSchema.Type.OBJECT)
              .properties(JsonValue.from(mapOf(
                "location" to mapOf(
                  "description" to "The city and state, e.g. San Francisco, CA", "type" to "string"
                ), "unit" to mapOf(
                  "description" to "Unit for the output - one of (celsius, fahrenheit)", "type" to "string"
                )
              )))
              .build())
          .name("name")
          .cacheControl(MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.builder()
              .type(MessagesBetaTrueCreateParams.Tool.BetaTool.CacheControl.Type.EPHEMERAL)
              .build())
          .description("Get the current weather in a given location")
          .type(MessagesBetaTrueCreateParams.Tool.BetaTool.Type.CUSTOM)
          .build())))
      assertThat(body.topK()).isEqualTo(5L)
      assertThat(body.topP()).isEqualTo(0.7)
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = MessagesBetaTrueCreateParams.builder()
          .maxTokens(1024L)
          .addMessage(MessagesBetaTrueCreateParams.Message.builder()
              .content("Hello, world")
              .role(MessagesBetaTrueCreateParams.Message.Role.USER)
              .build())
          .model("claude-3-7-sonnet-20250219")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.maxTokens()).isEqualTo(1024L)
      assertThat(body.messages()).isEqualTo(listOf(MessagesBetaTrueCreateParams.Message.builder()
          .content("Hello, world")
          .role(MessagesBetaTrueCreateParams.Message.Role.USER)
          .build()))
      assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
    }
}
