// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import java.util.UUID
import software.elborai.api.core.BaseDeserializer
import software.elborai.api.core.BaseSerializer
import software.elborai.api.core.getOrThrow
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.JsonNull
import software.elborai.api.core.JsonField
import software.elborai.api.core.Enum
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.errors.IncreaseInvalidDataException

/** A list of Inbound Mail Item objects. */
@JsonDeserialize(builder = InboundMailItemList.Builder::class)
@NoAutoDetect
class InboundMailItemList private constructor(private val data: JsonField<List<InboundMailItem>>, private val nextCursor: JsonField<String>, private val additionalProperties: Map<String, JsonValue>, ) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The contents of the list. */
    fun data(): List<InboundMailItem> = data.getRequired("data")

    /** A pointer to a place in the list. */
    fun nextCursor(): String? = nextCursor.getNullable("next_cursor")

    /** The contents of the list. */
    @JsonProperty("data")
    @ExcludeMissing
    fun _data() = data

    /** A pointer to a place in the list. */
    @JsonProperty("next_cursor")
    @ExcludeMissing
    fun _nextCursor() = nextCursor

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): InboundMailItemList = apply {
        if (!validated) {
          data().forEach { it.validate() }
          nextCursor()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is InboundMailItemList &&
          this.data == other.data &&
          this.nextCursor == other.nextCursor &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            data,
            nextCursor,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "InboundMailItemList{data=$data, nextCursor=$nextCursor, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var data: JsonField<List<InboundMailItem>> = JsonMissing.of()
        private var nextCursor: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(inboundMailItemList: InboundMailItemList) = apply {
            this.data = inboundMailItemList.data
            this.nextCursor = inboundMailItemList.nextCursor
            additionalProperties(inboundMailItemList.additionalProperties)
        }

        /** The contents of the list. */
        fun data(data: List<InboundMailItem>) = data(JsonField.of(data))

        /** The contents of the list. */
        @JsonProperty("data")
        @ExcludeMissing
        fun data(data: JsonField<List<InboundMailItem>>) = apply {
            this.data = data
        }

        /** A pointer to a place in the list. */
        fun nextCursor(nextCursor: String) = nextCursor(JsonField.of(nextCursor))

        /** A pointer to a place in the list. */
        @JsonProperty("next_cursor")
        @ExcludeMissing
        fun nextCursor(nextCursor: JsonField<String>) = apply {
            this.nextCursor = nextCursor
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

        fun build(): InboundMailItemList = InboundMailItemList(
            data.map { it.toUnmodifiable() },
            nextCursor,
            additionalProperties.toUnmodifiable(),
        )
    }
}
