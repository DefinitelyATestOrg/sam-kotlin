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
import org.apache.hc.core5.http.ContentType
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
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.MultipartFormValue
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.Enum
import software.elborai.api.core.ContentTypes
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*

class FeedbackUpdateParams constructor(
  private val feedbackId: String,
  private val agentId: String,
  private val ticketMessageId: String,
  private val id: String?,
  private val createdBy: CreatedBy?,
  private val text: String?,
  private val type: Type?,
  private val updatedBy: UpdatedBy?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun feedbackId(): String = feedbackId

    fun agentId(): String = agentId

    fun ticketMessageId(): String = ticketMessageId

    fun id(): String? = id

    fun createdBy(): CreatedBy? = createdBy

    fun text(): String? = text

    fun type(): Type? = type

    fun updatedBy(): UpdatedBy? = updatedBy

    internal fun getBody(): FeedbackUpdateBody {
      return FeedbackUpdateBody(
          agentId,
          ticketMessageId,
          id,
          createdBy,
          text,
          type,
          updatedBy,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> feedbackId
          else -> ""
      }
    }

    @JsonDeserialize(builder = FeedbackUpdateBody.Builder::class)
    @NoAutoDetect
    class FeedbackUpdateBody internal constructor(
      private val agentId: String?,
      private val ticketMessageId: String?,
      private val id: String?,
      private val createdBy: CreatedBy?,
      private val text: String?,
      private val type: Type?,
      private val updatedBy: UpdatedBy?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("agentId")
        fun agentId(): String? = agentId

        @JsonProperty("ticketMessageId")
        fun ticketMessageId(): String? = ticketMessageId

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("createdBy")
        fun createdBy(): CreatedBy? = createdBy

        @JsonProperty("text")
        fun text(): String? = text

        @JsonProperty("type")
        fun type(): Type? = type

        @JsonProperty("updatedBy")
        fun updatedBy(): UpdatedBy? = updatedBy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is FeedbackUpdateBody &&
              this.agentId == other.agentId &&
              this.ticketMessageId == other.ticketMessageId &&
              this.id == other.id &&
              this.createdBy == other.createdBy &&
              this.text == other.text &&
              this.type == other.type &&
              this.updatedBy == other.updatedBy &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                agentId,
                ticketMessageId,
                id,
                createdBy,
                text,
                type,
                updatedBy,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "FeedbackUpdateBody{agentId=$agentId, ticketMessageId=$ticketMessageId, id=$id, createdBy=$createdBy, text=$text, type=$type, updatedBy=$updatedBy, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var agentId: String? = null
            private var ticketMessageId: String? = null
            private var id: String? = null
            private var createdBy: CreatedBy? = null
            private var text: String? = null
            private var type: Type? = null
            private var updatedBy: UpdatedBy? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(feedbackUpdateBody: FeedbackUpdateBody) = apply {
                this.agentId = feedbackUpdateBody.agentId
                this.ticketMessageId = feedbackUpdateBody.ticketMessageId
                this.id = feedbackUpdateBody.id
                this.createdBy = feedbackUpdateBody.createdBy
                this.text = feedbackUpdateBody.text
                this.type = feedbackUpdateBody.type
                this.updatedBy = feedbackUpdateBody.updatedBy
                additionalProperties(feedbackUpdateBody.additionalProperties)
            }

            @JsonProperty("agentId")
            fun agentId(agentId: String) = apply {
                this.agentId = agentId
            }

            @JsonProperty("ticketMessageId")
            fun ticketMessageId(ticketMessageId: String) = apply {
                this.ticketMessageId = ticketMessageId
            }

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply {
                this.createdBy = createdBy
            }

            @JsonProperty("text")
            fun text(text: String) = apply {
                this.text = text
            }

            @JsonProperty("type")
            fun type(type: Type) = apply {
                this.type = type
            }

            @JsonProperty("updatedBy")
            fun updatedBy(updatedBy: UpdatedBy) = apply {
                this.updatedBy = updatedBy
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

            fun build(): FeedbackUpdateBody = FeedbackUpdateBody(
                checkNotNull(agentId) {
                    "`agentId` is required but was not set"
                },
                checkNotNull(ticketMessageId) {
                    "`ticketMessageId` is required but was not set"
                },
                id,
                createdBy,
                text,
                type,
                updatedBy,
                additionalProperties.toUnmodifiable(),
            )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is FeedbackUpdateParams &&
          this.feedbackId == other.feedbackId &&
          this.agentId == other.agentId &&
          this.ticketMessageId == other.ticketMessageId &&
          this.id == other.id &&
          this.createdBy == other.createdBy &&
          this.text == other.text &&
          this.type == other.type &&
          this.updatedBy == other.updatedBy &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          feedbackId,
          agentId,
          ticketMessageId,
          id,
          createdBy,
          text,
          type,
          updatedBy,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "FeedbackUpdateParams{feedbackId=$feedbackId, agentId=$agentId, ticketMessageId=$ticketMessageId, id=$id, createdBy=$createdBy, text=$text, type=$type, updatedBy=$updatedBy, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var feedbackId: String? = null
        private var agentId: String? = null
        private var ticketMessageId: String? = null
        private var id: String? = null
        private var createdBy: CreatedBy? = null
        private var text: String? = null
        private var type: Type? = null
        private var updatedBy: UpdatedBy? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(feedbackUpdateParams: FeedbackUpdateParams) = apply {
            this.feedbackId = feedbackUpdateParams.feedbackId
            this.agentId = feedbackUpdateParams.agentId
            this.ticketMessageId = feedbackUpdateParams.ticketMessageId
            this.id = feedbackUpdateParams.id
            this.createdBy = feedbackUpdateParams.createdBy
            this.text = feedbackUpdateParams.text
            this.type = feedbackUpdateParams.type
            this.updatedBy = feedbackUpdateParams.updatedBy
            additionalQueryParams(feedbackUpdateParams.additionalQueryParams)
            additionalHeaders(feedbackUpdateParams.additionalHeaders)
            additionalBodyProperties(feedbackUpdateParams.additionalBodyProperties)
        }

        fun feedbackId(feedbackId: String) = apply {
            this.feedbackId = feedbackId
        }

        fun agentId(agentId: String) = apply {
            this.agentId = agentId
        }

        fun ticketMessageId(ticketMessageId: String) = apply {
            this.ticketMessageId = ticketMessageId
        }

        fun id(id: String) = apply {
            this.id = id
        }

        fun createdBy(createdBy: CreatedBy) = apply {
            this.createdBy = createdBy
        }

        fun text(text: String) = apply {
            this.text = text
        }

        fun type(type: Type) = apply {
            this.type = type
        }

        fun updatedBy(updatedBy: UpdatedBy) = apply {
            this.updatedBy = updatedBy
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply {
            this.additionalHeaders.put(name, mutableListOf())
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun build(): FeedbackUpdateParams = FeedbackUpdateParams(
            checkNotNull(feedbackId) {
                "`feedbackId` is required but was not set"
            },
            checkNotNull(agentId) {
                "`agentId` is required but was not set"
            },
            checkNotNull(ticketMessageId) {
                "`ticketMessageId` is required but was not set"
            },
            id,
            createdBy,
            text,
            type,
            updatedBy,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    @JsonDeserialize(builder = CreatedBy.Builder::class)
    @NoAutoDetect
    class CreatedBy private constructor(private val id: String?, private val name: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("name")
        fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is CreatedBy &&
              this.id == other.id &&
              this.name == other.name &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                id,
                name,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "CreatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createdBy: CreatedBy) = apply {
                this.id = createdBy.id
                this.name = createdBy.name
                additionalProperties(createdBy.additionalProperties)
            }

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
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

            fun build(): CreatedBy = CreatedBy(
                id,
                name,
                additionalProperties.toUnmodifiable(),
            )
        }
    }

    class Type @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Type &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val THUMBS_UP = Type(JsonField.of("THUMBS_UP"))

            val THUMBS_DOWN = Type(JsonField.of("THUMBS_DOWN"))

            val INSERT = Type(JsonField.of("INSERT"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            THUMBS_UP,
            THUMBS_DOWN,
            INSERT,
        }

        enum class Value {
            THUMBS_UP,
            THUMBS_DOWN,
            INSERT,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            THUMBS_UP -> Value.THUMBS_UP
            THUMBS_DOWN -> Value.THUMBS_DOWN
            INSERT -> Value.INSERT
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            THUMBS_UP -> Known.THUMBS_UP
            THUMBS_DOWN -> Known.THUMBS_DOWN
            INSERT -> Known.INSERT
            else -> throw SamInvalidDataException("Unknown Type: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = UpdatedBy.Builder::class)
    @NoAutoDetect
    class UpdatedBy private constructor(private val id: String?, private val name: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("name")
        fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is UpdatedBy &&
              this.id == other.id &&
              this.name == other.name &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                id,
                name,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "UpdatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(updatedBy: UpdatedBy) = apply {
                this.id = updatedBy.id
                this.name = updatedBy.name
                additionalProperties(updatedBy.additionalProperties)
            }

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
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

            fun build(): UpdatedBy = UpdatedBy(
                id,
                name,
                additionalProperties.toUnmodifiable(),
            )
        }
    }
}
