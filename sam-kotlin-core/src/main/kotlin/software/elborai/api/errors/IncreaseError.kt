// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.errors

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.Objects
import java.util.UUID
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect

@JsonDeserialize(builder = IncreaseError.Builder::class)
@NoAutoDetect
class IncreaseError constructor(private val additionalProperties: Map<String, JsonValue>, ) {

    @JsonAnyGetter
    fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder()

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is IncreaseError &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(additionalProperties)
    }

    override fun toString() = "IncreaseError{additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic
        fun builder() = Builder()
    }

    class Builder {

        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        fun from(error: IncreaseError) = apply {
            additionalProperties(error.additionalProperties)
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): IncreaseError = IncreaseError(additionalProperties.toUnmodifiable())
    }
}
