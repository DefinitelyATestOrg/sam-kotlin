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
 * This contains artwork and metadata relating to a Physical Card's appearance. For
 * more information, see our guide on
 * [physical card artwork](https://increase.com/documentation/card-art-physical-cards).
 */
@JsonDeserialize(builder = PhysicalCardProfile.Builder::class)
@NoAutoDetect
class PhysicalCardProfile private constructor(
  private val backImageFileId: JsonField<String>,
  private val carrierImageFileId: JsonField<String>,
  private val contactPhone: JsonField<String>,
  private val createdAt: JsonField<OffsetDateTime>,
  private val creator: JsonField<Creator>,
  private val description: JsonField<String>,
  private val frontImageFileId: JsonField<String>,
  private val id: JsonField<String>,
  private val idempotencyKey: JsonField<String>,
  private val isDefault: JsonField<Boolean>,
  private val status: JsonField<Status>,
  private val type: JsonField<Type>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The identifier of the File containing the physical card's back image. */
    fun backImageFileId(): String? = backImageFileId.getNullable("back_image_file_id")

    /** The identifier of the File containing the physical card's carrier image. */
    fun carrierImageFileId(): String? = carrierImageFileId.getNullable("carrier_image_file_id")

    /** A phone number the user can contact to receive support for their card. */
    fun contactPhone(): String? = contactPhone.getNullable("contact_phone")

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) date and time at which
     * the Card Dispute was created.
     */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /** The creator of this Physical Card Profile. */
    fun creator(): Creator = creator.getRequired("creator")

    /** A description you can use to identify the Physical Card Profile. */
    fun description(): String = description.getRequired("description")

    /** The identifier of the File containing the physical card's front image. */
    fun frontImageFileId(): String? = frontImageFileId.getNullable("front_image_file_id")

    /** The Card Profile identifier. */
    fun id(): String = id.getRequired("id")

    /**
     * The idempotency key you chose for this object. This value is unique across
     * Increase and is used to ensure that a request is only processed once. Learn more
     * about [idempotency](https://increase.com/documentation/idempotency-keys).
     */
    fun idempotencyKey(): String? = idempotencyKey.getNullable("idempotency_key")

    /**
     * Whether this Physical Card Profile is the default for all cards in its Increase
     * group.
     */
    fun isDefault(): Boolean = isDefault.getRequired("is_default")

    /** The status of the Physical Card Profile. */
    fun status(): Status = status.getRequired("status")

    /**
     * A constant representing the object's type. For this resource it will always be
     * `physical_card_profile`.
     */
    fun type(): Type = type.getRequired("type")

    /** The identifier of the File containing the physical card's back image. */
    @JsonProperty("back_image_file_id")
    @ExcludeMissing
    fun _backImageFileId() = backImageFileId

    /** The identifier of the File containing the physical card's carrier image. */
    @JsonProperty("carrier_image_file_id")
    @ExcludeMissing
    fun _carrierImageFileId() = carrierImageFileId

    /** A phone number the user can contact to receive support for their card. */
    @JsonProperty("contact_phone")
    @ExcludeMissing
    fun _contactPhone() = contactPhone

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) date and time at which
     * the Card Dispute was created.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt() = createdAt

    /** The creator of this Physical Card Profile. */
    @JsonProperty("creator")
    @ExcludeMissing
    fun _creator() = creator

    /** A description you can use to identify the Physical Card Profile. */
    @JsonProperty("description")
    @ExcludeMissing
    fun _description() = description

    /** The identifier of the File containing the physical card's front image. */
    @JsonProperty("front_image_file_id")
    @ExcludeMissing
    fun _frontImageFileId() = frontImageFileId

    /** The Card Profile identifier. */
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

    /**
     * Whether this Physical Card Profile is the default for all cards in its Increase
     * group.
     */
    @JsonProperty("is_default")
    @ExcludeMissing
    fun _isDefault() = isDefault

    /** The status of the Physical Card Profile. */
    @JsonProperty("status")
    @ExcludeMissing
    fun _status() = status

    /**
     * A constant representing the object's type. For this resource it will always be
     * `physical_card_profile`.
     */
    @JsonProperty("type")
    @ExcludeMissing
    fun _type() = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PhysicalCardProfile = apply {
        if (!validated) {
          backImageFileId()
          carrierImageFileId()
          contactPhone()
          createdAt()
          creator()
          description()
          frontImageFileId()
          id()
          idempotencyKey()
          isDefault()
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

      return other is PhysicalCardProfile &&
          this.backImageFileId == other.backImageFileId &&
          this.carrierImageFileId == other.carrierImageFileId &&
          this.contactPhone == other.contactPhone &&
          this.createdAt == other.createdAt &&
          this.creator == other.creator &&
          this.description == other.description &&
          this.frontImageFileId == other.frontImageFileId &&
          this.id == other.id &&
          this.idempotencyKey == other.idempotencyKey &&
          this.isDefault == other.isDefault &&
          this.status == other.status &&
          this.type == other.type &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            backImageFileId,
            carrierImageFileId,
            contactPhone,
            createdAt,
            creator,
            description,
            frontImageFileId,
            id,
            idempotencyKey,
            isDefault,
            status,
            type,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "PhysicalCardProfile{backImageFileId=$backImageFileId, carrierImageFileId=$carrierImageFileId, contactPhone=$contactPhone, createdAt=$createdAt, creator=$creator, description=$description, frontImageFileId=$frontImageFileId, id=$id, idempotencyKey=$idempotencyKey, isDefault=$isDefault, status=$status, type=$type, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var backImageFileId: JsonField<String> = JsonMissing.of()
        private var carrierImageFileId: JsonField<String> = JsonMissing.of()
        private var contactPhone: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var creator: JsonField<Creator> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var frontImageFileId: JsonField<String> = JsonMissing.of()
        private var id: JsonField<String> = JsonMissing.of()
        private var idempotencyKey: JsonField<String> = JsonMissing.of()
        private var isDefault: JsonField<Boolean> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(physicalCardProfile: PhysicalCardProfile) = apply {
            this.backImageFileId = physicalCardProfile.backImageFileId
            this.carrierImageFileId = physicalCardProfile.carrierImageFileId
            this.contactPhone = physicalCardProfile.contactPhone
            this.createdAt = physicalCardProfile.createdAt
            this.creator = physicalCardProfile.creator
            this.description = physicalCardProfile.description
            this.frontImageFileId = physicalCardProfile.frontImageFileId
            this.id = physicalCardProfile.id
            this.idempotencyKey = physicalCardProfile.idempotencyKey
            this.isDefault = physicalCardProfile.isDefault
            this.status = physicalCardProfile.status
            this.type = physicalCardProfile.type
            additionalProperties(physicalCardProfile.additionalProperties)
        }

        /** The identifier of the File containing the physical card's back image. */
        fun backImageFileId(backImageFileId: String) = backImageFileId(JsonField.of(backImageFileId))

        /** The identifier of the File containing the physical card's back image. */
        @JsonProperty("back_image_file_id")
        @ExcludeMissing
        fun backImageFileId(backImageFileId: JsonField<String>) = apply {
            this.backImageFileId = backImageFileId
        }

        /** The identifier of the File containing the physical card's carrier image. */
        fun carrierImageFileId(carrierImageFileId: String) = carrierImageFileId(JsonField.of(carrierImageFileId))

        /** The identifier of the File containing the physical card's carrier image. */
        @JsonProperty("carrier_image_file_id")
        @ExcludeMissing
        fun carrierImageFileId(carrierImageFileId: JsonField<String>) = apply {
            this.carrierImageFileId = carrierImageFileId
        }

        /** A phone number the user can contact to receive support for their card. */
        fun contactPhone(contactPhone: String) = contactPhone(JsonField.of(contactPhone))

        /** A phone number the user can contact to receive support for their card. */
        @JsonProperty("contact_phone")
        @ExcludeMissing
        fun contactPhone(contactPhone: JsonField<String>) = apply {
            this.contactPhone = contactPhone
        }

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) date and time at which
         * the Card Dispute was created.
         */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) date and time at which
         * the Card Dispute was created.
         */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
            this.createdAt = createdAt
        }

        /** The creator of this Physical Card Profile. */
        fun creator(creator: Creator) = creator(JsonField.of(creator))

        /** The creator of this Physical Card Profile. */
        @JsonProperty("creator")
        @ExcludeMissing
        fun creator(creator: JsonField<Creator>) = apply {
            this.creator = creator
        }

        /** A description you can use to identify the Physical Card Profile. */
        fun description(description: String) = description(JsonField.of(description))

        /** A description you can use to identify the Physical Card Profile. */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply {
            this.description = description
        }

        /** The identifier of the File containing the physical card's front image. */
        fun frontImageFileId(frontImageFileId: String) = frontImageFileId(JsonField.of(frontImageFileId))

        /** The identifier of the File containing the physical card's front image. */
        @JsonProperty("front_image_file_id")
        @ExcludeMissing
        fun frontImageFileId(frontImageFileId: JsonField<String>) = apply {
            this.frontImageFileId = frontImageFileId
        }

        /** The Card Profile identifier. */
        fun id(id: String) = id(JsonField.of(id))

        /** The Card Profile identifier. */
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

        /**
         * Whether this Physical Card Profile is the default for all cards in its Increase
         * group.
         */
        fun isDefault(isDefault: Boolean) = isDefault(JsonField.of(isDefault))

        /**
         * Whether this Physical Card Profile is the default for all cards in its Increase
         * group.
         */
        @JsonProperty("is_default")
        @ExcludeMissing
        fun isDefault(isDefault: JsonField<Boolean>) = apply {
            this.isDefault = isDefault
        }

        /** The status of the Physical Card Profile. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The status of the Physical Card Profile. */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply {
            this.status = status
        }

        /**
         * A constant representing the object's type. For this resource it will always be
         * `physical_card_profile`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * A constant representing the object's type. For this resource it will always be
         * `physical_card_profile`.
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

        fun build(): PhysicalCardProfile = PhysicalCardProfile(
            backImageFileId,
            carrierImageFileId,
            contactPhone,
            createdAt,
            creator,
            description,
            frontImageFileId,
            id,
            idempotencyKey,
            isDefault,
            status,
            type,
            additionalProperties.toUnmodifiable(),
        )
    }

    class Creator @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Creator &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val INCREASE = Creator(JsonField.of("increase"))

            val USER = Creator(JsonField.of("user"))

            fun of(value: String) = Creator(JsonField.of(value))
        }

        enum class Known {
            INCREASE,
            USER,
        }

        enum class Value {
            INCREASE,
            USER,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            INCREASE -> Value.INCREASE
            USER -> Value.USER
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            INCREASE -> Known.INCREASE
            USER -> Known.USER
            else -> throw IncreaseInvalidDataException("Unknown Creator: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
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

            val PENDING_CREATING = Status(JsonField.of("pending_creating"))

            val PENDING_REVIEWING = Status(JsonField.of("pending_reviewing"))

            val REJECTED = Status(JsonField.of("rejected"))

            val PENDING_SUBMITTING = Status(JsonField.of("pending_submitting"))

            val ACTIVE = Status(JsonField.of("active"))

            val ARCHIVED = Status(JsonField.of("archived"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PENDING_CREATING,
            PENDING_REVIEWING,
            REJECTED,
            PENDING_SUBMITTING,
            ACTIVE,
            ARCHIVED,
        }

        enum class Value {
            PENDING_CREATING,
            PENDING_REVIEWING,
            REJECTED,
            PENDING_SUBMITTING,
            ACTIVE,
            ARCHIVED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            PENDING_CREATING -> Value.PENDING_CREATING
            PENDING_REVIEWING -> Value.PENDING_REVIEWING
            REJECTED -> Value.REJECTED
            PENDING_SUBMITTING -> Value.PENDING_SUBMITTING
            ACTIVE -> Value.ACTIVE
            ARCHIVED -> Value.ARCHIVED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            PENDING_CREATING -> Known.PENDING_CREATING
            PENDING_REVIEWING -> Known.PENDING_REVIEWING
            REJECTED -> Known.REJECTED
            PENDING_SUBMITTING -> Known.PENDING_SUBMITTING
            ACTIVE -> Known.ACTIVE
            ARCHIVED -> Known.ARCHIVED
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

            val PHYSICAL_CARD_PROFILE = Type(JsonField.of("physical_card_profile"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            PHYSICAL_CARD_PROFILE,
        }

        enum class Value {
            PHYSICAL_CARD_PROFILE,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            PHYSICAL_CARD_PROFILE -> Value.PHYSICAL_CARD_PROFILE
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            PHYSICAL_CARD_PROFILE -> Known.PHYSICAL_CARD_PROFILE
            else -> throw IncreaseInvalidDataException("Unknown Type: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }
}
