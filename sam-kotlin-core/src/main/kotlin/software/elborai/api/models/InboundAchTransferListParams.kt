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

class InboundAchTransferListParams constructor(
  private val accountId: String?,
  private val accountNumberId: String?,
  private val createdAt: CreatedAt?,
  private val cursor: String?,
  private val limit: Long?,
  private val status: Status?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun accountId(): String? = accountId

    fun accountNumberId(): String? = accountNumberId

    fun createdAt(): CreatedAt? = createdAt

    fun cursor(): String? = cursor

    fun limit(): Long? = limit

    fun status(): Status? = status

    internal fun getQueryParams(): Map<String, List<String>> {
      val params = mutableMapOf<String, List<String>>()
      this.accountId?.let {
          params.put("account_id", listOf(it.toString()))
      }
      this.accountNumberId?.let {
          params.put("account_number_id", listOf(it.toString()))
      }
      this.createdAt?.forEachQueryParam { key, values -> 
          params.put("created_at.$key", values)
      }
      this.cursor?.let {
          params.put("cursor", listOf(it.toString()))
      }
      this.limit?.let {
          params.put("limit", listOf(it.toString()))
      }
      this.status?.let {
          params.put("status", listOf(it.toString()))
      }
      params.putAll(additionalQueryParams)
      return params.toUnmodifiable()
    }

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is InboundAchTransferListParams &&
          this.accountId == other.accountId &&
          this.accountNumberId == other.accountNumberId &&
          this.createdAt == other.createdAt &&
          this.cursor == other.cursor &&
          this.limit == other.limit &&
          this.status == other.status &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          accountId,
          accountNumberId,
          createdAt,
          cursor,
          limit,
          status,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "InboundAchTransferListParams{accountId=$accountId, accountNumberId=$accountNumberId, createdAt=$createdAt, cursor=$cursor, limit=$limit, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var accountId: String? = null
        private var accountNumberId: String? = null
        private var createdAt: CreatedAt? = null
        private var cursor: String? = null
        private var limit: Long? = null
        private var status: Status? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(inboundAchTransferListParams: InboundAchTransferListParams) = apply {
            this.accountId = inboundAchTransferListParams.accountId
            this.accountNumberId = inboundAchTransferListParams.accountNumberId
            this.createdAt = inboundAchTransferListParams.createdAt
            this.cursor = inboundAchTransferListParams.cursor
            this.limit = inboundAchTransferListParams.limit
            this.status = inboundAchTransferListParams.status
            additionalQueryParams(inboundAchTransferListParams.additionalQueryParams)
            additionalHeaders(inboundAchTransferListParams.additionalHeaders)
            additionalBodyProperties(inboundAchTransferListParams.additionalBodyProperties)
        }

        /** Filter Inbound ACH Tranfers to ones belonging to the specified Account. */
        fun accountId(accountId: String) = apply {
            this.accountId = accountId
        }

        /** Filter Inbound ACH Tranfers to ones belonging to the specified Account Number. */
        fun accountNumberId(accountNumberId: String) = apply {
            this.accountNumberId = accountNumberId
        }

        fun createdAt(createdAt: CreatedAt) = apply {
            this.createdAt = createdAt
        }

        /** Return the page of entries after this one. */
        fun cursor(cursor: String) = apply {
            this.cursor = cursor
        }

        /**
         * Limit the size of the list that is returned. The default (and maximum) is 100
         * objects.
         */
        fun limit(limit: Long) = apply {
            this.limit = limit
        }

        /** Filter Inbound ACH Transfers to those with the specified status. */
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

        fun build(): InboundAchTransferListParams = InboundAchTransferListParams(
            accountId,
            accountNumberId,
            createdAt,
            cursor,
            limit,
            status,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    @JsonDeserialize(builder = CreatedAt.Builder::class)
    @NoAutoDetect
    class CreatedAt private constructor(
      private val after: OffsetDateTime?,
      private val before: OffsetDateTime?,
      private val onOrAfter: OffsetDateTime?,
      private val onOrBefore: OffsetDateTime?,
      private val additionalProperties: Map<String, List<String>>,

    ) {

        private var hashCode: Int = 0

        /**
         * Return results after this [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
         * timestamp.
         */
        fun after(): OffsetDateTime? = after

        /**
         * Return results before this [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
         * timestamp.
         */
        fun before(): OffsetDateTime? = before

        /**
         * Return results on or after this
         * [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) timestamp.
         */
        fun onOrAfter(): OffsetDateTime? = onOrAfter

        /**
         * Return results on or before this
         * [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) timestamp.
         */
        fun onOrBefore(): OffsetDateTime? = onOrBefore

        fun _additionalProperties(): Map<String, List<String>> = additionalProperties

        internal fun forEachQueryParam(putParam: (String, List<String>) -> Unit) {
          this.after?.let {
              putParam("after", listOf(it.toString()))
          }
          this.before?.let {
              putParam("before", listOf(it.toString()))
          }
          this.onOrAfter?.let {
              putParam("on_or_after", listOf(it.toString()))
          }
          this.onOrBefore?.let {
              putParam("on_or_before", listOf(it.toString()))
          }
          this.additionalProperties.forEach { key, values -> 
              putParam(key, values)
          }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is CreatedAt &&
              this.after == other.after &&
              this.before == other.before &&
              this.onOrAfter == other.onOrAfter &&
              this.onOrBefore == other.onOrBefore &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                after,
                before,
                onOrAfter,
                onOrBefore,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "CreatedAt{after=$after, before=$before, onOrAfter=$onOrAfter, onOrBefore=$onOrBefore, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var after: OffsetDateTime? = null
            private var before: OffsetDateTime? = null
            private var onOrAfter: OffsetDateTime? = null
            private var onOrBefore: OffsetDateTime? = null
            private var additionalProperties: MutableMap<String, List<String>> = mutableMapOf()

            internal fun from(createdAt: CreatedAt) = apply {
                this.after = createdAt.after
                this.before = createdAt.before
                this.onOrAfter = createdAt.onOrAfter
                this.onOrBefore = createdAt.onOrBefore
                additionalProperties(createdAt.additionalProperties)
            }

            /**
             * Return results after this [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
             * timestamp.
             */
            fun after(after: OffsetDateTime) = apply {
                this.after = after
            }

            /**
             * Return results before this [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601)
             * timestamp.
             */
            fun before(before: OffsetDateTime) = apply {
                this.before = before
            }

            /**
             * Return results on or after this
             * [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) timestamp.
             */
            fun onOrAfter(onOrAfter: OffsetDateTime) = apply {
                this.onOrAfter = onOrAfter
            }

            /**
             * Return results on or before this
             * [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) timestamp.
             */
            fun onOrBefore(onOrBefore: OffsetDateTime) = apply {
                this.onOrBefore = onOrBefore
            }

            fun additionalProperties(additionalProperties: Map<String, List<String>>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: List<String>) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, List<String>>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): CreatedAt = CreatedAt(
                after,
                before,
                onOrAfter,
                onOrBefore,
                additionalProperties.toUnmodifiable(),
            )
        }
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

            val PENDING = Status(JsonField.of("pending"))

            val DECLINED = Status(JsonField.of("declined"))

            val ACCEPTED = Status(JsonField.of("accepted"))

            val RETURNED = Status(JsonField.of("returned"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PENDING,
            DECLINED,
            ACCEPTED,
            RETURNED,
        }

        enum class Value {
            PENDING,
            DECLINED,
            ACCEPTED,
            RETURNED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            PENDING -> Value.PENDING
            DECLINED -> Value.DECLINED
            ACCEPTED -> Value.ACCEPTED
            RETURNED -> Value.RETURNED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            PENDING -> Known.PENDING
            DECLINED -> Known.DECLINED
            ACCEPTED -> Known.ACCEPTED
            RETURNED -> Known.RETURNED
            else -> throw IncreaseInvalidDataException("Unknown Status: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
