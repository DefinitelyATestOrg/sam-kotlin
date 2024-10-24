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
import software.elborai.api.errors.IncreaseInvalidDataException
import software.elborai.api.models.*

class LockboxUpdateParams constructor(
  private val lockboxId: String,
  private val description: String?,
  private val status: Status?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun lockboxId(): String = lockboxId

    fun description(): String? = description

    fun status(): Status? = status

    internal fun getBody(): LockboxUpdateBody {
      return LockboxUpdateBody(
          description,
          status,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> lockboxId
          else -> ""
      }
    }

    @JsonDeserialize(builder = LockboxUpdateBody.Builder::class)
    @NoAutoDetect
    class LockboxUpdateBody internal constructor(private val description: String?, private val status: Status?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        /** The description you choose for the Lockbox. */
        @JsonProperty("description")
        fun description(): String? = description

        /** This indicates if checks can be sent to the Lockbox. */
        @JsonProperty("status")
        fun status(): Status? = status

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is LockboxUpdateBody &&
              this.description == other.description &&
              this.status == other.status &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                description,
                status,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "LockboxUpdateBody{description=$description, status=$status, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var description: String? = null
            private var status: Status? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(lockboxUpdateBody: LockboxUpdateBody) = apply {
                this.description = lockboxUpdateBody.description
                this.status = lockboxUpdateBody.status
                additionalProperties(lockboxUpdateBody.additionalProperties)
            }

            /** The description you choose for the Lockbox. */
            @JsonProperty("description")
            fun description(description: String) = apply {
                this.description = description
            }

            /** This indicates if checks can be sent to the Lockbox. */
            @JsonProperty("status")
            fun status(status: Status) = apply {
                this.status = status
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

            fun build(): LockboxUpdateBody = LockboxUpdateBody(
                description,
                status,
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

      return other is LockboxUpdateParams &&
          this.lockboxId == other.lockboxId &&
          this.description == other.description &&
          this.status == other.status &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          lockboxId,
          description,
          status,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "LockboxUpdateParams{lockboxId=$lockboxId, description=$description, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var lockboxId: String? = null
        private var description: String? = null
        private var status: Status? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(lockboxUpdateParams: LockboxUpdateParams) = apply {
            this.lockboxId = lockboxUpdateParams.lockboxId
            this.description = lockboxUpdateParams.description
            this.status = lockboxUpdateParams.status
            additionalQueryParams(lockboxUpdateParams.additionalQueryParams)
            additionalHeaders(lockboxUpdateParams.additionalHeaders)
            additionalBodyProperties(lockboxUpdateParams.additionalBodyProperties)
        }

        /** The identifier of the Lockbox. */
        fun lockboxId(lockboxId: String) = apply {
            this.lockboxId = lockboxId
        }

        /** The description you choose for the Lockbox. */
        fun description(description: String) = apply {
            this.description = description
        }

        /** This indicates if checks can be sent to the Lockbox. */
        fun status(status: Status) = apply {
            this.status = status
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

        fun build(): LockboxUpdateParams = LockboxUpdateParams(
            checkNotNull(lockboxId) {
                "`lockboxId` is required but was not set"
            },
            description,
            status,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    class Status @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Status &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val ACTIVE = Status(JsonField.of("active"))

            val INACTIVE = Status(JsonField.of("inactive"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            ACTIVE,
            INACTIVE,
        }

        enum class Value {
            ACTIVE,
            INACTIVE,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            ACTIVE -> Value.ACTIVE
            INACTIVE -> Value.INACTIVE
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            ACTIVE -> Known.ACTIVE
            INACTIVE -> Known.INACTIVE
            else -> throw IncreaseInvalidDataException("Unknown Status: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
