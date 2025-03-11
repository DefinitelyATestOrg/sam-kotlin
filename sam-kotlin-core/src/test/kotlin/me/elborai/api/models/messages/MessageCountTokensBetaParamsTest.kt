// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import kotlin.test.assertNotNull
import me.elborai.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MessageCountTokensBetaParamsTest {

    @Test
    fun create() {
      MessageCountTokensBetaParams.builder()
          .addAnthropicBeta("string")
          .anthropicVersion("anthropic-version")
          .xApiKey("x-api-key")
          .addMessage(MessageCountTokensBetaParams.Message.builder()
              .content("Hello, world")
              .role(MessageCountTokensBetaParams.Message.Role.USER)
              .build())
          .model("claude-3-7-sonnet-20250219")
          .systemOfBetaRequestTextBlocks(listOf(MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
              .text("Today's date is 2024-06-01.")
              .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT)
              .cacheControl(MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl.builder()
                  .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl.Type.EPHEMERAL)
                  .build())
              .addCitation(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.builder()
                  .citedText("cited_text")
                  .documentIndex(0L)
                  .documentTitle("x")
                  .endCharIndex(0L)
                  .startCharIndex(0L)
                  .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.Type.CHAR_LOCATION)
                  .build())
              .build()))
          .betaThinkingConfigEnabledThinking(1024L)
          .toolChoice(MessageCountTokensBetaParams.ToolChoice.BetaToolChoiceAuto.builder()
              .type(MessageCountTokensBetaParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO)
              .disableParallelToolUse(true)
              .build())
          .addTool(MessageCountTokensBetaParams.Tool.BetaTool.builder()
              .inputSchema(MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
                  .type(MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type.OBJECT)
                  .properties(JsonValue.from(mapOf(
                    "location" to mapOf(
                      "description" to "The city and state, e.g. San Francisco, CA", "type" to "string"
                    ), "unit" to mapOf(
                      "description" to "Unit for the output - one of (celsius, fahrenheit)", "type" to "string"
                    )
                  )))
                  .build())
              .name("name")
              .cacheControl(MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
                  .type(MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type.EPHEMERAL)
                  .build())
              .description("Get the current weather in a given location")
              .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
              .build())
          .build()
    }

    @Test
    fun body() {
      val params = MessageCountTokensBetaParams.builder()
          .addAnthropicBeta("string")
          .anthropicVersion("anthropic-version")
          .xApiKey("x-api-key")
          .addMessage(MessageCountTokensBetaParams.Message.builder()
              .content("Hello, world")
              .role(MessageCountTokensBetaParams.Message.Role.USER)
              .build())
          .model("claude-3-7-sonnet-20250219")
          .systemOfBetaRequestTextBlocks(listOf(MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
              .text("Today's date is 2024-06-01.")
              .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT)
              .cacheControl(MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl.builder()
                  .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl.Type.EPHEMERAL)
                  .build())
              .addCitation(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.builder()
                  .citedText("cited_text")
                  .documentIndex(0L)
                  .documentTitle("x")
                  .endCharIndex(0L)
                  .startCharIndex(0L)
                  .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.Type.CHAR_LOCATION)
                  .build())
              .build()))
          .betaThinkingConfigEnabledThinking(1024L)
          .toolChoice(MessageCountTokensBetaParams.ToolChoice.BetaToolChoiceAuto.builder()
              .type(MessageCountTokensBetaParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO)
              .disableParallelToolUse(true)
              .build())
          .addTool(MessageCountTokensBetaParams.Tool.BetaTool.builder()
              .inputSchema(MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
                  .type(MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type.OBJECT)
                  .properties(JsonValue.from(mapOf(
                    "location" to mapOf(
                      "description" to "The city and state, e.g. San Francisco, CA", "type" to "string"
                    ), "unit" to mapOf(
                      "description" to "Unit for the output - one of (celsius, fahrenheit)", "type" to "string"
                    )
                  )))
                  .build())
              .name("name")
              .cacheControl(MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
                  .type(MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type.EPHEMERAL)
                  .build())
              .description("Get the current weather in a given location")
              .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
              .build())
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.messages()).isEqualTo(listOf(MessageCountTokensBetaParams.Message.builder()
          .content("Hello, world")
          .role(MessageCountTokensBetaParams.Message.Role.USER)
          .build()))
      assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
      assertThat(body.system()).isEqualTo(MessageCountTokensBetaParams.System.ofBetaRequestTextBlocks(listOf(MessageCountTokensBetaParams.System.BetaRequestTextBlock.builder()
          .text("Today's date is 2024-06-01.")
          .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Type.TEXT)
          .cacheControl(MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl.builder()
              .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.CacheControl.Type.EPHEMERAL)
              .build())
          .addCitation(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.builder()
              .citedText("cited_text")
              .documentIndex(0L)
              .documentTitle("x")
              .endCharIndex(0L)
              .startCharIndex(0L)
              .type(MessageCountTokensBetaParams.System.BetaRequestTextBlock.Citation.BetaRequestCharLocationCitation.Type.CHAR_LOCATION)
              .build())
          .build())))
      assertThat(body.thinking()).isEqualTo(MessageCountTokensBetaParams.Thinking.ofBetaThinkingConfigEnabled(MessageCountTokensBetaParams.Thinking.BetaThinkingConfigEnabled.builder()
          .budgetTokens(1024L)
          .type(MessageCountTokensBetaParams.Thinking.BetaThinkingConfigEnabled.Type.ENABLED)
          .build()))
      assertThat(body.toolChoice()).isEqualTo(MessageCountTokensBetaParams.ToolChoice.ofBetaToolChoiceAuto(MessageCountTokensBetaParams.ToolChoice.BetaToolChoiceAuto.builder()
          .type(MessageCountTokensBetaParams.ToolChoice.BetaToolChoiceAuto.Type.AUTO)
          .disableParallelToolUse(true)
          .build()))
      assertThat(body.tools()).isEqualTo(listOf(MessageCountTokensBetaParams.Tool.ofBeta(MessageCountTokensBetaParams.Tool.BetaTool.builder()
          .inputSchema(MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.builder()
              .type(MessageCountTokensBetaParams.Tool.BetaTool.InputSchema.Type.OBJECT)
              .properties(JsonValue.from(mapOf(
                "location" to mapOf(
                  "description" to "The city and state, e.g. San Francisco, CA", "type" to "string"
                ), "unit" to mapOf(
                  "description" to "Unit for the output - one of (celsius, fahrenheit)", "type" to "string"
                )
              )))
              .build())
          .name("name")
          .cacheControl(MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.builder()
              .type(MessageCountTokensBetaParams.Tool.BetaTool.CacheControl.Type.EPHEMERAL)
              .build())
          .description("Get the current weather in a given location")
          .type(MessageCountTokensBetaParams.Tool.BetaTool.Type.CUSTOM)
          .build())))
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = MessageCountTokensBetaParams.builder()
          .addMessage(MessageCountTokensBetaParams.Message.builder()
              .content("Hello, world")
              .role(MessageCountTokensBetaParams.Message.Role.USER)
              .build())
          .model("claude-3-7-sonnet-20250219")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.messages()).isEqualTo(listOf(MessageCountTokensBetaParams.Message.builder()
          .content("Hello, world")
          .role(MessageCountTokensBetaParams.Message.Role.USER)
          .build()))
      assertThat(body.model()).isEqualTo("claude-3-7-sonnet-20250219")
    }
}
