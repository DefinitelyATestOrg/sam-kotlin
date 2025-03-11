// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.NoAutoDetect
import me.elborai.api.core.checkRequired
import me.elborai.api.core.immutableEmptyMap
import me.elborai.api.core.toImmutable

@NoAutoDetect
class MessageCountTokensBetaResponse @JsonCreator private constructor(
    @JsonProperty("input_tokens") @ExcludeMissing private val inputTokens: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    /**
     * The total number of tokens across the provided list of messages, system prompt,
     * and tools.
     */
    fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

    /**
     * The total number of tokens across the provided list of messages, system prompt,
     * and tools.
     */
    @JsonProperty("input_tokens")
    @ExcludeMissing
    fun _inputTokens(): JsonField<Long> = inputTokens

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageCountTokensBetaResponse =
        apply {
            if (validated) {
              return@apply
            }

            inputTokens()
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [MessageCountTokensBetaResponse].
         *
         * The following fields are required:
         *
         * ```kotlin
         * .inputTokens()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [MessageCountTokensBetaResponse]. */
    class Builder internal constructor() {

        private var inputTokens: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(messageCountTokensBetaResponse: MessageCountTokensBetaResponse) =
            apply {
                inputTokens = messageCountTokensBetaResponse.inputTokens
                additionalProperties = messageCountTokensBetaResponse.additionalProperties.toMutableMap()
            }

        /**
         * The total number of tokens across the provided list of messages, system prompt,
         * and tools.
         */
        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

        /**
         * The total number of tokens across the provided list of messages, system prompt,
         * and tools.
         */
        fun inputTokens(inputTokens: JsonField<Long>) =
            apply {
                this.inputTokens = inputTokens
            }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

        fun putAdditionalProperty(key: String, value: JsonValue) =
            apply {
                additionalProperties.put(key, value)
            }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.putAll(additionalProperties)
            }

        fun removeAdditionalProperty(key: String) =
            apply {
                additionalProperties.remove(key)
            }

        fun removeAllAdditionalProperties(keys: Set<String>) =
            apply {
                keys.forEach(::removeAdditionalProperty)
            }

        fun build(): MessageCountTokensBetaResponse =
            MessageCountTokensBetaResponse(
              checkRequired(
                "inputTokens", inputTokens
              ), additionalProperties.toImmutable()
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is MessageCountTokensBetaResponse && inputTokens == other.inputTokens && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(inputTokens, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "MessageCountTokensBetaResponse{inputTokens=$inputTokens, additionalProperties=$additionalProperties}"
}
