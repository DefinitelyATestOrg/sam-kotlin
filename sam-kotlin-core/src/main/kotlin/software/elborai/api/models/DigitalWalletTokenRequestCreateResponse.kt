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

/** The results of a Digital Wallet Token simulation. */
@JsonDeserialize(builder = DigitalWalletTokenRequestCreateResponse.Builder::class)
@NoAutoDetect
class DigitalWalletTokenRequestCreateResponse private constructor(
  private val declineReason: JsonField<DeclineReason>,
  private val digitalWalletTokenId: JsonField<String>,
  private val type: JsonField<Type>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /**
     * If the simulated tokenization attempt was declined, this field contains details
     * as to why.
     */
    fun declineReason(): DeclineReason? = declineReason.getNullable("decline_reason")

    /**
     * If the simulated tokenization attempt was accepted, this field contains the id
     * of the Digital Wallet Token that was created.
     */
    fun digitalWalletTokenId(): String? = digitalWalletTokenId.getNullable("digital_wallet_token_id")

    /**
     * A constant representing the object's type. For this resource it will always be
     * `inbound_digital_wallet_token_request_simulation_result`.
     */
    fun type(): Type = type.getRequired("type")

    /**
     * If the simulated tokenization attempt was declined, this field contains details
     * as to why.
     */
    @JsonProperty("decline_reason")
    @ExcludeMissing
    fun _declineReason() = declineReason

    /**
     * If the simulated tokenization attempt was accepted, this field contains the id
     * of the Digital Wallet Token that was created.
     */
    @JsonProperty("digital_wallet_token_id")
    @ExcludeMissing
    fun _digitalWalletTokenId() = digitalWalletTokenId

    /**
     * A constant representing the object's type. For this resource it will always be
     * `inbound_digital_wallet_token_request_simulation_result`.
     */
    @JsonProperty("type")
    @ExcludeMissing
    fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): DigitalWalletTokenRequestCreateResponse = apply {
        if (!validated) {
          declineReason()
          digitalWalletTokenId()
          type()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is DigitalWalletTokenRequestCreateResponse &&
          this.declineReason == other.declineReason &&
          this.digitalWalletTokenId == other.digitalWalletTokenId &&
          this.type == other.type &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            declineReason,
            digitalWalletTokenId,
            type,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "DigitalWalletTokenRequestCreateResponse{declineReason=$declineReason, digitalWalletTokenId=$digitalWalletTokenId, type=$type, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var declineReason: JsonField<DeclineReason> = JsonMissing.of()
        private var digitalWalletTokenId: JsonField<String> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(digitalWalletTokenRequestCreateResponse: DigitalWalletTokenRequestCreateResponse) = apply {
            this.declineReason = digitalWalletTokenRequestCreateResponse.declineReason
            this.digitalWalletTokenId = digitalWalletTokenRequestCreateResponse.digitalWalletTokenId
            this.type = digitalWalletTokenRequestCreateResponse.type
            additionalProperties(digitalWalletTokenRequestCreateResponse.additionalProperties)
        }

        /**
         * If the simulated tokenization attempt was declined, this field contains details
         * as to why.
         */
        fun declineReason(declineReason: DeclineReason) = declineReason(JsonField.of(declineReason))

        /**
         * If the simulated tokenization attempt was declined, this field contains details
         * as to why.
         */
        @JsonProperty("decline_reason")
        @ExcludeMissing
        fun declineReason(declineReason: JsonField<DeclineReason>) = apply {
            this.declineReason = declineReason
        }

        /**
         * If the simulated tokenization attempt was accepted, this field contains the id
         * of the Digital Wallet Token that was created.
         */
        fun digitalWalletTokenId(digitalWalletTokenId: String) = digitalWalletTokenId(JsonField.of(digitalWalletTokenId))

        /**
         * If the simulated tokenization attempt was accepted, this field contains the id
         * of the Digital Wallet Token that was created.
         */
        @JsonProperty("digital_wallet_token_id")
        @ExcludeMissing
        fun digitalWalletTokenId(digitalWalletTokenId: JsonField<String>) = apply {
            this.digitalWalletTokenId = digitalWalletTokenId
        }

        /**
         * A constant representing the object's type. For this resource it will always be
         * `inbound_digital_wallet_token_request_simulation_result`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * A constant representing the object's type. For this resource it will always be
         * `inbound_digital_wallet_token_request_simulation_result`.
         */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply {
            this.type = type
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

        fun build(): DigitalWalletTokenRequestCreateResponse = DigitalWalletTokenRequestCreateResponse(
            declineReason,
            digitalWalletTokenId,
            type,
            additionalProperties.toUnmodifiable(),
        )
    }

    class DeclineReason @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is DeclineReason &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val CARD_NOT_ACTIVE = DeclineReason(JsonField.of("card_not_active"))

            val NO_VERIFICATION_METHOD = DeclineReason(JsonField.of("no_verification_method"))

            val WEBHOOK_TIMED_OUT = DeclineReason(JsonField.of("webhook_timed_out"))

            val WEBHOOK_DECLINED = DeclineReason(JsonField.of("webhook_declined"))

            fun of(value: String) = DeclineReason(JsonField.of(value))
        }

        enum class Known {
            CARD_NOT_ACTIVE,
            NO_VERIFICATION_METHOD,
            WEBHOOK_TIMED_OUT,
            WEBHOOK_DECLINED,
        }

        enum class Value {
            CARD_NOT_ACTIVE,
            NO_VERIFICATION_METHOD,
            WEBHOOK_TIMED_OUT,
            WEBHOOK_DECLINED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            CARD_NOT_ACTIVE -> Value.CARD_NOT_ACTIVE
            NO_VERIFICATION_METHOD -> Value.NO_VERIFICATION_METHOD
            WEBHOOK_TIMED_OUT -> Value.WEBHOOK_TIMED_OUT
            WEBHOOK_DECLINED -> Value.WEBHOOK_DECLINED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            CARD_NOT_ACTIVE -> Known.CARD_NOT_ACTIVE
            NO_VERIFICATION_METHOD -> Known.NO_VERIFICATION_METHOD
            WEBHOOK_TIMED_OUT -> Known.WEBHOOK_TIMED_OUT
            WEBHOOK_DECLINED -> Known.WEBHOOK_DECLINED
            else -> throw IncreaseInvalidDataException("Unknown DeclineReason: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
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

            val INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT = Type(JsonField.of("inbound_digital_wallet_token_request_simulation_result"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT,
        }

        enum class Value {
            INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT -> Value.INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT -> Known.INBOUND_DIGITAL_WALLET_TOKEN_REQUEST_SIMULATION_RESULT
            else -> throw IncreaseInvalidDataException("Unknown Type: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
