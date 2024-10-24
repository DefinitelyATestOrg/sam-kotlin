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

/**
 * Each account can have multiple account and routing numbers. We recommend that
 * you use a set per vendor. This is similar to how you use different passwords for
 * different websites. Account numbers can also be used to seamlessly reconcile
 * inbound payments. Generating a unique account number per vendor ensures you
 * always know the originator of an incoming payment.
 */
@JsonDeserialize(builder = AccountNumber.Builder::class)
@NoAutoDetect
class AccountNumber private constructor(
  private val accountId: JsonField<String>,
  private val accountNumber: JsonField<String>,
  private val createdAt: JsonField<OffsetDateTime>,
  private val id: JsonField<String>,
  private val idempotencyKey: JsonField<String>,
  private val inboundAch: JsonField<InboundAch>,
  private val inboundChecks: JsonField<InboundChecks>,
  private val name: JsonField<String>,
  private val routingNumber: JsonField<String>,
  private val status: JsonField<Status>,
  private val type: JsonField<Type>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The identifier for the account this Account Number belongs to. */
    fun accountId(): String = accountId.getRequired("account_id")

    /** The account number. */
    fun accountNumber(): String = accountNumber.getRequired("account_number")

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
     * Number was created.
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /** The Account Number identifier. */
    fun id(): String = id.getRequired("id")

    /**
     * The idempotency key you chose for this object. This value is unique across
     * Increase and is used to ensure that a request is only processed once. Learn more
     * about [idempotency](https://increase.com/documentation/idempotency-keys).
     */
    fun idempotencyKey(): String? = idempotencyKey.getNullable("idempotency_key")

    /** Properties related to how this Account Number handles inbound ACH transfers. */
    fun inboundAch(): InboundAch = inboundAch.getRequired("inbound_ach")

    /**
     * Properties related to how this Account Number should handle inbound check
     * withdrawals.
     */
    fun inboundChecks(): InboundChecks = inboundChecks.getRequired("inbound_checks")

    /** The name you choose for the Account Number. */
    fun name(): String = name.getRequired("name")

    /** The American Bankers' Association (ABA) Routing Transit Number (RTN). */
    fun routingNumber(): String = routingNumber.getRequired("routing_number")

    /** This indicates if payments can be made to the Account Number. */
    fun status(): Status = status.getRequired("status")

    /**
     * A constant representing the object's type. For this resource it will always be
     * `account_number`.
     */
    fun type(): Type = type.getRequired("type")

    /** The identifier for the account this Account Number belongs to. */
    @JsonProperty("account_id")
    @ExcludeMissing
    fun _accountId() = accountId

    /** The account number. */
    @JsonProperty("account_number")
    @ExcludeMissing
    fun _accountNumber() = accountNumber

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
     * Number was created.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt() = createdAt

    /** The Account Number identifier. */
    @JsonProperty("id")
    @ExcludeMissing
    fun _id() = id

    /**
     * The idempotency key you chose for this object. This value is unique across
     * Increase and is used to ensure that a request is only processed once. Learn more
     * about [idempotency](https://increase.com/documentation/idempotency-keys).
     */
    @JsonProperty("idempotency_key")
    @ExcludeMissing
    fun _idempotencyKey() = idempotencyKey

    /** Properties related to how this Account Number handles inbound ACH transfers. */
    @JsonProperty("inbound_ach")
    @ExcludeMissing
    fun _inboundAch() = inboundAch

    /**
     * Properties related to how this Account Number should handle inbound check
     * withdrawals.
     */
    @JsonProperty("inbound_checks")
    @ExcludeMissing
    fun _inboundChecks() = inboundChecks

    /** The name you choose for the Account Number. */
    @JsonProperty("name")
    @ExcludeMissing
    fun _name() = name

    /** The American Bankers' Association (ABA) Routing Transit Number (RTN). */
    @JsonProperty("routing_number")
    @ExcludeMissing
    fun _routingNumber() = routingNumber

    /** This indicates if payments can be made to the Account Number. */
    @JsonProperty("status")
    @ExcludeMissing
    fun _status() = status

    /**
     * A constant representing the object's type. For this resource it will always be
     * `account_number`.
     */
    @JsonProperty("type")
    @ExcludeMissing
    fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AccountNumber = apply {
        if (!validated) {
          accountId()
          accountNumber()
          createdAt()
          id()
          idempotencyKey()
          inboundAch().validate()
          inboundChecks().validate()
          name()
          routingNumber()
          status()
          type()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is AccountNumber &&
          this.accountId == other.accountId &&
          this.accountNumber == other.accountNumber &&
          this.createdAt == other.createdAt &&
          this.id == other.id &&
          this.idempotencyKey == other.idempotencyKey &&
          this.inboundAch == other.inboundAch &&
          this.inboundChecks == other.inboundChecks &&
          this.name == other.name &&
          this.routingNumber == other.routingNumber &&
          this.status == other.status &&
          this.type == other.type &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            accountId,
            accountNumber,
            createdAt,
            id,
            idempotencyKey,
            inboundAch,
            inboundChecks,
            name,
            routingNumber,
            status,
            type,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "AccountNumber{accountId=$accountId, accountNumber=$accountNumber, createdAt=$createdAt, id=$id, idempotencyKey=$idempotencyKey, inboundAch=$inboundAch, inboundChecks=$inboundChecks, name=$name, routingNumber=$routingNumber, status=$status, type=$type, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var accountId: JsonField<String> = JsonMissing.of()
        private var accountNumber: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var idempotencyKey: JsonField<String> = JsonMissing.of()
        private var inboundAch: JsonField<InboundAch> = JsonMissing.of()
        private var inboundChecks: JsonField<InboundChecks> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var routingNumber: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(accountNumber: AccountNumber) = apply {
            this.accountId = accountNumber.accountId
            this.accountNumber = accountNumber.accountNumber
            this.createdAt = accountNumber.createdAt
            this.id = accountNumber.id
            this.idempotencyKey = accountNumber.idempotencyKey
            this.inboundAch = accountNumber.inboundAch
            this.inboundChecks = accountNumber.inboundChecks
            this.name = accountNumber.name
            this.routingNumber = accountNumber.routingNumber
            this.status = accountNumber.status
            this.type = accountNumber.type
            additionalProperties(accountNumber.additionalProperties)
        }

        /** The identifier for the account this Account Number belongs to. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /** The identifier for the account this Account Number belongs to. */
        @JsonProperty("account_id")
        @ExcludeMissing
        fun accountId(accountId: JsonField<String>) = apply {
            this.accountId = accountId
        }

        /** The account number. */
        fun accountNumber(accountNumber: String) = accountNumber(JsonField.of(accountNumber))

        /** The account number. */
        @JsonProperty("account_number")
        @ExcludeMissing
        fun accountNumber(accountNumber: JsonField<String>) = apply {
            this.accountNumber = accountNumber
        }

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
         * Number was created.
         */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
         * Number was created.
         */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
            this.createdAt = createdAt
        }

        /** The Account Number identifier. */
        fun id(id: String) = id(JsonField.of(id))

        /** The Account Number identifier. */
        @JsonProperty("id")
        @ExcludeMissing
        fun id(id: JsonField<String>) = apply {
            this.id = id
        }

        /**
         * The idempotency key you chose for this object. This value is unique across
         * Increase and is used to ensure that a request is only processed once. Learn more
         * about [idempotency](https://increase.com/documentation/idempotency-keys).
         */
        fun idempotencyKey(idempotencyKey: String) = idempotencyKey(JsonField.of(idempotencyKey))

        /**
         * The idempotency key you chose for this object. This value is unique across
         * Increase and is used to ensure that a request is only processed once. Learn more
         * about [idempotency](https://increase.com/documentation/idempotency-keys).
         */
        @JsonProperty("idempotency_key")
        @ExcludeMissing
        fun idempotencyKey(idempotencyKey: JsonField<String>) = apply {
            this.idempotencyKey = idempotencyKey
        }

        /** Properties related to how this Account Number handles inbound ACH transfers. */
        fun inboundAch(inboundAch: InboundAch) = inboundAch(JsonField.of(inboundAch))

        /** Properties related to how this Account Number handles inbound ACH transfers. */
        @JsonProperty("inbound_ach")
        @ExcludeMissing
        fun inboundAch(inboundAch: JsonField<InboundAch>) = apply {
            this.inboundAch = inboundAch
        }

        /**
         * Properties related to how this Account Number should handle inbound check
         * withdrawals.
         */
        fun inboundChecks(inboundChecks: InboundChecks) = inboundChecks(JsonField.of(inboundChecks))

        /**
         * Properties related to how this Account Number should handle inbound check
         * withdrawals.
         */
        @JsonProperty("inbound_checks")
        @ExcludeMissing
        fun inboundChecks(inboundChecks: JsonField<InboundChecks>) = apply {
            this.inboundChecks = inboundChecks
        }

        /** The name you choose for the Account Number. */
        fun name(name: String) = name(JsonField.of(name))

        /** The name you choose for the Account Number. */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply {
            this.name = name
        }

        /** The American Bankers' Association (ABA) Routing Transit Number (RTN). */
        fun routingNumber(routingNumber: String) = routingNumber(JsonField.of(routingNumber))

        /** The American Bankers' Association (ABA) Routing Transit Number (RTN). */
        @JsonProperty("routing_number")
        @ExcludeMissing
        fun routingNumber(routingNumber: JsonField<String>) = apply {
            this.routingNumber = routingNumber
        }

        /** This indicates if payments can be made to the Account Number. */
        fun status(status: Status) = status(JsonField.of(status))

        /** This indicates if payments can be made to the Account Number. */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply {
            this.status = status
        }

        /**
         * A constant representing the object's type. For this resource it will always be
         * `account_number`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * A constant representing the object's type. For this resource it will always be
         * `account_number`.
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

        fun build(): AccountNumber = AccountNumber(
            accountId,
            accountNumber,
            createdAt,
            id,
            idempotencyKey,
            inboundAch,
            inboundChecks,
            name,
            routingNumber,
            status,
            type,
            additionalProperties.toUnmodifiable(),
        )
    }

    /** Properties related to how this Account Number handles inbound ACH transfers. */
    @JsonDeserialize(builder = InboundAch.Builder::class)
    @NoAutoDetect
    class InboundAch private constructor(private val debitStatus: JsonField<DebitStatus>, private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /**
         * Whether ACH debits are allowed against this Account Number. Note that they will
         * still be declined if this is `allowed` if the Account Number is not active.
         */
        fun debitStatus(): DebitStatus = debitStatus.getRequired("debit_status")

        /**
         * Whether ACH debits are allowed against this Account Number. Note that they will
         * still be declined if this is `allowed` if the Account Number is not active.
         */
        @JsonProperty("debit_status")
        @ExcludeMissing
        fun _debitStatus() = debitStatus

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): InboundAch = apply {
            if (!validated) {
              debitStatus()
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is InboundAch &&
              this.debitStatus == other.debitStatus &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(debitStatus, additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "InboundAch{debitStatus=$debitStatus, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var debitStatus: JsonField<DebitStatus> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(inboundAch: InboundAch) = apply {
                this.debitStatus = inboundAch.debitStatus
                additionalProperties(inboundAch.additionalProperties)
            }

            /**
             * Whether ACH debits are allowed against this Account Number. Note that they will
             * still be declined if this is `allowed` if the Account Number is not active.
             */
            fun debitStatus(debitStatus: DebitStatus) = debitStatus(JsonField.of(debitStatus))

            /**
             * Whether ACH debits are allowed against this Account Number. Note that they will
             * still be declined if this is `allowed` if the Account Number is not active.
             */
            @JsonProperty("debit_status")
            @ExcludeMissing
            fun debitStatus(debitStatus: JsonField<DebitStatus>) = apply {
                this.debitStatus = debitStatus
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

            fun build(): InboundAch = InboundAch(debitStatus, additionalProperties.toUnmodifiable())
        }

        class DebitStatus @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is DebitStatus &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val ALLOWED = DebitStatus(JsonField.of("allowed"))

                val BLOCKED = DebitStatus(JsonField.of("blocked"))

                fun of(value: String) = DebitStatus(JsonField.of(value))
            }

            enum class Known {
                ALLOWED,
                BLOCKED,
            }

            enum class Value {
                ALLOWED,
                BLOCKED,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                ALLOWED -> Value.ALLOWED
                BLOCKED -> Value.BLOCKED
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                ALLOWED -> Known.ALLOWED
                BLOCKED -> Known.BLOCKED
                else -> throw IncreaseInvalidDataException("Unknown DebitStatus: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    /**
     * Properties related to how this Account Number should handle inbound check
     * withdrawals.
     */
    @JsonDeserialize(builder = InboundChecks.Builder::class)
    @NoAutoDetect
    class InboundChecks private constructor(private val status: JsonField<Status>, private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        /** How Increase should process checks with this account number printed on them. */
        fun status(): Status = status.getRequired("status")

        /** How Increase should process checks with this account number printed on them. */
        @JsonProperty("status")
        @ExcludeMissing
        fun _status() = status

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): InboundChecks = apply {
            if (!validated) {
              status()
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is InboundChecks &&
              this.status == other.status &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(status, additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "InboundChecks{status=$status, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(inboundChecks: InboundChecks) = apply {
                this.status = inboundChecks.status
                additionalProperties(inboundChecks.additionalProperties)
            }

            /** How Increase should process checks with this account number printed on them. */
            fun status(status: Status) = status(JsonField.of(status))

            /** How Increase should process checks with this account number printed on them. */
            @JsonProperty("status")
            @ExcludeMissing
            fun status(status: JsonField<Status>) = apply {
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

            fun build(): InboundChecks = InboundChecks(status, additionalProperties.toUnmodifiable())
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

                val ALLOWED = Status(JsonField.of("allowed"))

                val CHECK_TRANSFERS_ONLY = Status(JsonField.of("check_transfers_only"))

                fun of(value: String) = Status(JsonField.of(value))
            }

            enum class Known {
                ALLOWED,
                CHECK_TRANSFERS_ONLY,
            }

            enum class Value {
                ALLOWED,
                CHECK_TRANSFERS_ONLY,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                ALLOWED -> Value.ALLOWED
                CHECK_TRANSFERS_ONLY -> Value.CHECK_TRANSFERS_ONLY
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                ALLOWED -> Known.ALLOWED
                CHECK_TRANSFERS_ONLY -> Known.CHECK_TRANSFERS_ONLY
                else -> throw IncreaseInvalidDataException("Unknown Status: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
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

            val ACTIVE = Status(JsonField.of("active"))

            val DISABLED = Status(JsonField.of("disabled"))

            val CANCELED = Status(JsonField.of("canceled"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            ACTIVE,
            DISABLED,
            CANCELED,
        }

        enum class Value {
            ACTIVE,
            DISABLED,
            CANCELED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            ACTIVE -> Value.ACTIVE
            DISABLED -> Value.DISABLED
            CANCELED -> Value.CANCELED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            ACTIVE -> Known.ACTIVE
            DISABLED -> Known.DISABLED
            CANCELED -> Known.CANCELED
            else -> throw IncreaseInvalidDataException("Unknown Status: $value")
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

            val ACCOUNT_NUMBER = Type(JsonField.of("account_number"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            ACCOUNT_NUMBER,
        }

        enum class Value {
            ACCOUNT_NUMBER,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            ACCOUNT_NUMBER -> Value.ACCOUNT_NUMBER
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            ACCOUNT_NUMBER -> Known.ACCOUNT_NUMBER
            else -> throw IncreaseInvalidDataException("Unknown Type: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
