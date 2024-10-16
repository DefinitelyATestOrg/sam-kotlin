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

class SimulationCardFuelConfirmationsParams constructor(
  private val amount: Long,
  private val cardPaymentId: String,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun amount(): Long = amount

    fun cardPaymentId(): String = cardPaymentId

    internal fun getBody(): SimulationCardFuelConfirmationsBody {
      return SimulationCardFuelConfirmationsBody(
          amount,
          cardPaymentId,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = SimulationCardFuelConfirmationsBody.Builder::class)
    @NoAutoDetect
    class SimulationCardFuelConfirmationsBody internal constructor(private val amount: Long?, private val cardPaymentId: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        /**
         * The amount of the fuel_confirmation in minor units in the card authorization's
         * currency.
         */
        @JsonProperty("amount")
        fun amount(): Long? = amount

        /** The identifier of the Card Payment to create a fuel_confirmation on. */
        @JsonProperty("card_payment_id")
        fun cardPaymentId(): String? = cardPaymentId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is SimulationCardFuelConfirmationsBody &&
              this.amount == other.amount &&
              this.cardPaymentId == other.cardPaymentId &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                amount,
                cardPaymentId,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "SimulationCardFuelConfirmationsBody{amount=$amount, cardPaymentId=$cardPaymentId, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var amount: Long? = null
            private var cardPaymentId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(simulationCardFuelConfirmationsBody: SimulationCardFuelConfirmationsBody) = apply {
                this.amount = simulationCardFuelConfirmationsBody.amount
                this.cardPaymentId = simulationCardFuelConfirmationsBody.cardPaymentId
                additionalProperties(simulationCardFuelConfirmationsBody.additionalProperties)
            }

            /**
             * The amount of the fuel_confirmation in minor units in the card authorization's
             * currency.
             */
            @JsonProperty("amount")
            fun amount(amount: Long) = apply {
                this.amount = amount
            }

            /** The identifier of the Card Payment to create a fuel_confirmation on. */
            @JsonProperty("card_payment_id")
            fun cardPaymentId(cardPaymentId: String) = apply {
                this.cardPaymentId = cardPaymentId
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

            fun build(): SimulationCardFuelConfirmationsBody = SimulationCardFuelConfirmationsBody(
                checkNotNull(amount) {
                    "`amount` is required but was not set"
                },
                checkNotNull(cardPaymentId) {
                    "`cardPaymentId` is required but was not set"
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

      return other is SimulationCardFuelConfirmationsParams &&
          this.amount == other.amount &&
          this.cardPaymentId == other.cardPaymentId &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          amount,
          cardPaymentId,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "SimulationCardFuelConfirmationsParams{amount=$amount, cardPaymentId=$cardPaymentId, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var amount: Long? = null
        private var cardPaymentId: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(simulationCardFuelConfirmationsParams: SimulationCardFuelConfirmationsParams) = apply {
            this.amount = simulationCardFuelConfirmationsParams.amount
            this.cardPaymentId = simulationCardFuelConfirmationsParams.cardPaymentId
            additionalQueryParams(simulationCardFuelConfirmationsParams.additionalQueryParams)
            additionalHeaders(simulationCardFuelConfirmationsParams.additionalHeaders)
            additionalBodyProperties(simulationCardFuelConfirmationsParams.additionalBodyProperties)
        }

        /**
         * The amount of the fuel_confirmation in minor units in the card authorization's
         * currency.
         */
        fun amount(amount: Long) = apply {
            this.amount = amount
        }

        /** The identifier of the Card Payment to create a fuel_confirmation on. */
        fun cardPaymentId(cardPaymentId: String) = apply {
            this.cardPaymentId = cardPaymentId
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

        fun build(): SimulationCardFuelConfirmationsParams = SimulationCardFuelConfirmationsParams(
            checkNotNull(amount) {
                "`amount` is required but was not set"
            },
            checkNotNull(cardPaymentId) {
                "`cardPaymentId` is required but was not set"
            },
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }
}
