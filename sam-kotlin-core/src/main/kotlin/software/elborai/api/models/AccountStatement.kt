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
 * Account Statements are generated monthly for every active Account. You can
 * access the statement's data via the API or retrieve a PDF with its details via
 * its associated File.
 */
@JsonDeserialize(builder = AccountStatement.Builder::class)
@NoAutoDetect
class AccountStatement private constructor(
  private val accountId: JsonField<String>,
  private val createdAt: JsonField<OffsetDateTime>,
  private val endingBalance: JsonField<Long>,
  private val fileId: JsonField<String>,
  private val id: JsonField<String>,
  private val startingBalance: JsonField<Long>,
  private val statementPeriodEnd: JsonField<OffsetDateTime>,
  private val statementPeriodStart: JsonField<OffsetDateTime>,
  private val type: JsonField<Type>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The identifier for the Account this Account Statement belongs to. */
    fun accountId(): String = accountId.getRequired("account_id")

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
     * Statement was created.
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /** The Account's balance at the start of its statement period. */
    fun endingBalance(): Long = endingBalance.getRequired("ending_balance")

    /** The identifier of the File containing a PDF of the statement. */
    fun fileId(): String = fileId.getRequired("file_id")

    /** The Account Statement identifier. */
    fun id(): String = id.getRequired("id")

    /** The Account's balance at the start of its statement period. */
    fun startingBalance(): Long = startingBalance.getRequired("starting_balance")

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the end
     * of the period the Account Statement covers.
     */
    fun statementPeriodEnd(): OffsetDateTime = statementPeriodEnd.getRequired("statement_period_end")

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the
     * start of the period the Account Statement covers.
     */
    fun statementPeriodStart(): OffsetDateTime = statementPeriodStart.getRequired("statement_period_start")

    /**
     * A constant representing the object's type. For this resource it will always be
     * `account_statement`.
     */
    fun type(): Type = type.getRequired("type")

    /** The identifier for the Account this Account Statement belongs to. */
    @JsonProperty("account_id")
    @ExcludeMissing
    fun _accountId() = accountId

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
     * Statement was created.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt() = createdAt

    /** The Account's balance at the start of its statement period. */
    @JsonProperty("ending_balance")
    @ExcludeMissing
    fun _endingBalance() = endingBalance

    /** The identifier of the File containing a PDF of the statement. */
    @JsonProperty("file_id")
    @ExcludeMissing
    fun _fileId() = fileId

    /** The Account Statement identifier. */
    @JsonProperty("id")
    @ExcludeMissing
    fun _id() = id

    /** The Account's balance at the start of its statement period. */
    @JsonProperty("starting_balance")
    @ExcludeMissing
    fun _startingBalance() = startingBalance

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the end
     * of the period the Account Statement covers.
     */
    @JsonProperty("statement_period_end")
    @ExcludeMissing
    fun _statementPeriodEnd() = statementPeriodEnd

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the
     * start of the period the Account Statement covers.
     */
    @JsonProperty("statement_period_start")
    @ExcludeMissing
    fun _statementPeriodStart() = statementPeriodStart

    /**
     * A constant representing the object's type. For this resource it will always be
     * `account_statement`.
     */
    @JsonProperty("type")
    @ExcludeMissing
    fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): AccountStatement = apply {
        if (!validated) {
          accountId()
          createdAt()
          endingBalance()
          fileId()
          id()
          startingBalance()
          statementPeriodEnd()
          statementPeriodStart()
          type()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is AccountStatement &&
          this.accountId == other.accountId &&
          this.createdAt == other.createdAt &&
          this.endingBalance == other.endingBalance &&
          this.fileId == other.fileId &&
          this.id == other.id &&
          this.startingBalance == other.startingBalance &&
          this.statementPeriodEnd == other.statementPeriodEnd &&
          this.statementPeriodStart == other.statementPeriodStart &&
          this.type == other.type &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            accountId,
            createdAt,
            endingBalance,
            fileId,
            id,
            startingBalance,
            statementPeriodEnd,
            statementPeriodStart,
            type,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "AccountStatement{accountId=$accountId, createdAt=$createdAt, endingBalance=$endingBalance, fileId=$fileId, id=$id, startingBalance=$startingBalance, statementPeriodEnd=$statementPeriodEnd, statementPeriodStart=$statementPeriodStart, type=$type, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var accountId: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var endingBalance: JsonField<Long> = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var startingBalance: JsonField<Long> = JsonMissing.of()
        private var statementPeriodEnd: JsonField<OffsetDateTime> = JsonMissing.of()
        private var statementPeriodStart: JsonField<OffsetDateTime> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(accountStatement: AccountStatement) = apply {
            this.accountId = accountStatement.accountId
            this.createdAt = accountStatement.createdAt
            this.endingBalance = accountStatement.endingBalance
            this.fileId = accountStatement.fileId
            this.id = accountStatement.id
            this.startingBalance = accountStatement.startingBalance
            this.statementPeriodEnd = accountStatement.statementPeriodEnd
            this.statementPeriodStart = accountStatement.statementPeriodStart
            this.type = accountStatement.type
            additionalProperties(accountStatement.additionalProperties)
        }

        /** The identifier for the Account this Account Statement belongs to. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /** The identifier for the Account this Account Statement belongs to. */
        @JsonProperty("account_id")
        @ExcludeMissing
        fun accountId(accountId: JsonField<String>) = apply {
            this.accountId = accountId
        }

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
         * Statement was created.
         */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time at which the Account
         * Statement was created.
         */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
            this.createdAt = createdAt
        }

        /** The Account's balance at the start of its statement period. */
        fun endingBalance(endingBalance: Long) = endingBalance(JsonField.of(endingBalance))

        /** The Account's balance at the start of its statement period. */
        @JsonProperty("ending_balance")
        @ExcludeMissing
        fun endingBalance(endingBalance: JsonField<Long>) = apply {
            this.endingBalance = endingBalance
        }

        /** The identifier of the File containing a PDF of the statement. */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /** The identifier of the File containing a PDF of the statement. */
        @JsonProperty("file_id")
        @ExcludeMissing
        fun fileId(fileId: JsonField<String>) = apply {
            this.fileId = fileId
        }

        /** The Account Statement identifier. */
        fun id(id: String) = id(JsonField.of(id))

        /** The Account Statement identifier. */
        @JsonProperty("id")
        @ExcludeMissing
        fun id(id: JsonField<String>) = apply {
            this.id = id
        }

        /** The Account's balance at the start of its statement period. */
        fun startingBalance(startingBalance: Long) = startingBalance(JsonField.of(startingBalance))

        /** The Account's balance at the start of its statement period. */
        @JsonProperty("starting_balance")
        @ExcludeMissing
        fun startingBalance(startingBalance: JsonField<Long>) = apply {
            this.startingBalance = startingBalance
        }

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the end
         * of the period the Account Statement covers.
         */
        fun statementPeriodEnd(statementPeriodEnd: OffsetDateTime) = statementPeriodEnd(JsonField.of(statementPeriodEnd))

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the end
         * of the period the Account Statement covers.
         */
        @JsonProperty("statement_period_end")
        @ExcludeMissing
        fun statementPeriodEnd(statementPeriodEnd: JsonField<OffsetDateTime>) = apply {
            this.statementPeriodEnd = statementPeriodEnd
        }

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the
         * start of the period the Account Statement covers.
         */
        fun statementPeriodStart(statementPeriodStart: OffsetDateTime) = statementPeriodStart(JsonField.of(statementPeriodStart))

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) time representing the
         * start of the period the Account Statement covers.
         */
        @JsonProperty("statement_period_start")
        @ExcludeMissing
        fun statementPeriodStart(statementPeriodStart: JsonField<OffsetDateTime>) = apply {
            this.statementPeriodStart = statementPeriodStart
        }

        /**
         * A constant representing the object's type. For this resource it will always be
         * `account_statement`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * A constant representing the object's type. For this resource it will always be
         * `account_statement`.
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

        fun build(): AccountStatement = AccountStatement(
            accountId,
            createdAt,
            endingBalance,
            fileId,
            id,
            startingBalance,
            statementPeriodEnd,
            statementPeriodStart,
            type,
            additionalProperties.toUnmodifiable(),
        )
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

            val ACCOUNT_STATEMENT = Type(JsonField.of("account_statement"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            ACCOUNT_STATEMENT,
        }

        enum class Value {
            ACCOUNT_STATEMENT,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            ACCOUNT_STATEMENT -> Value.ACCOUNT_STATEMENT
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            ACCOUNT_STATEMENT -> Known.ACCOUNT_STATEMENT
            else -> throw IncreaseInvalidDataException("Unknown Type: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
