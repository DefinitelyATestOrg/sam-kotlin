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

class CardDisputeCreateParams constructor(
  private val disputedTransactionId: String,
  private val explanation: String,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun disputedTransactionId(): String = disputedTransactionId

    fun explanation(): String = explanation

    internal fun getBody(): CardDisputeCreateBody {
      return CardDisputeCreateBody(
          disputedTransactionId,
          explanation,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = CardDisputeCreateBody.Builder::class)
    @NoAutoDetect
    class CardDisputeCreateBody internal constructor(private val disputedTransactionId: String?, private val explanation: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        /**
         * The Transaction you wish to dispute. This Transaction must have a `source_type`
         * of `card_settlement`.
         */
        @JsonProperty("disputed_transaction_id")
        fun disputedTransactionId(): String? = disputedTransactionId

        /** Why you are disputing this Transaction. */
        @JsonProperty("explanation")
        fun explanation(): String? = explanation

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is CardDisputeCreateBody &&
              this.disputedTransactionId == other.disputedTransactionId &&
              this.explanation == other.explanation &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                disputedTransactionId,
                explanation,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "CardDisputeCreateBody{disputedTransactionId=$disputedTransactionId, explanation=$explanation, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var disputedTransactionId: String? = null
            private var explanation: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(cardDisputeCreateBody: CardDisputeCreateBody) = apply {
                this.disputedTransactionId = cardDisputeCreateBody.disputedTransactionId
                this.explanation = cardDisputeCreateBody.explanation
                additionalProperties(cardDisputeCreateBody.additionalProperties)
            }

            /**
             * The Transaction you wish to dispute. This Transaction must have a `source_type`
             * of `card_settlement`.
             */
            @JsonProperty("disputed_transaction_id")
            fun disputedTransactionId(disputedTransactionId: String) = apply {
                this.disputedTransactionId = disputedTransactionId
            }

            /** Why you are disputing this Transaction. */
            @JsonProperty("explanation")
            fun explanation(explanation: String) = apply {
                this.explanation = explanation
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

            fun build(): CardDisputeCreateBody = CardDisputeCreateBody(
                checkNotNull(disputedTransactionId) {
                    "`disputedTransactionId` is required but was not set"
                },
                checkNotNull(explanation) {
                    "`explanation` is required but was not set"
                },
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

      return other is CardDisputeCreateParams &&
          this.disputedTransactionId == other.disputedTransactionId &&
          this.explanation == other.explanation &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          disputedTransactionId,
          explanation,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "CardDisputeCreateParams{disputedTransactionId=$disputedTransactionId, explanation=$explanation, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var disputedTransactionId: String? = null
        private var explanation: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(cardDisputeCreateParams: CardDisputeCreateParams) = apply {
            this.disputedTransactionId = cardDisputeCreateParams.disputedTransactionId
            this.explanation = cardDisputeCreateParams.explanation
            additionalQueryParams(cardDisputeCreateParams.additionalQueryParams)
            additionalHeaders(cardDisputeCreateParams.additionalHeaders)
            additionalBodyProperties(cardDisputeCreateParams.additionalBodyProperties)
        }

        /**
         * The Transaction you wish to dispute. This Transaction must have a `source_type`
         * of `card_settlement`.
         */
        fun disputedTransactionId(disputedTransactionId: String) = apply {
            this.disputedTransactionId = disputedTransactionId
        }

        /** Why you are disputing this Transaction. */
        fun explanation(explanation: String) = apply {
            this.explanation = explanation
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

        fun build(): CardDisputeCreateParams = CardDisputeCreateParams(
            checkNotNull(disputedTransactionId) {
                "`disputedTransactionId` is required but was not set"
            },
            checkNotNull(explanation) {
                "`explanation` is required but was not set"
            },
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }
}
