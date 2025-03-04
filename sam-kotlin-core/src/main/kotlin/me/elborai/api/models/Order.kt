// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Objects
import me.elborai.api.core.Enum
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.NoAutoDetect
import me.elborai.api.core.immutableEmptyMap
import me.elborai.api.core.toImmutable
import me.elborai.api.errors.SamInvalidDataException

@NoAutoDetect
class Order
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("complete")
    @ExcludeMissing
    private val complete: JsonField<Boolean> = JsonMissing.of(),
    @JsonProperty("petId") @ExcludeMissing private val petId: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("quantity")
    @ExcludeMissing
    private val quantity: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("shipDate")
    @ExcludeMissing
    private val shipDate: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): Long? = id.getNullable("id")

    fun complete(): Boolean? = complete.getNullable("complete")

    fun petId(): Long? = petId.getNullable("petId")

    fun quantity(): Long? = quantity.getNullable("quantity")

    fun shipDate(): OffsetDateTime? = shipDate.getNullable("shipDate")

    /** Order Status */
    fun status(): Status? = status.getNullable("status")

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Long> = id

    @JsonProperty("complete") @ExcludeMissing fun _complete(): JsonField<Boolean> = complete

    @JsonProperty("petId") @ExcludeMissing fun _petId(): JsonField<Long> = petId

    @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Long> = quantity

    @JsonProperty("shipDate") @ExcludeMissing fun _shipDate(): JsonField<OffsetDateTime> = shipDate

    /** Order Status */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Order = apply {
        if (validated) {
            return@apply
        }

        id()
        complete()
        petId()
        quantity()
        shipDate()
        status()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [Order]. */
        fun builder() = Builder()
    }

    /** A builder for [Order]. */
    class Builder internal constructor() {

        private var id: JsonField<Long> = JsonMissing.of()
        private var complete: JsonField<Boolean> = JsonMissing.of()
        private var petId: JsonField<Long> = JsonMissing.of()
        private var quantity: JsonField<Long> = JsonMissing.of()
        private var shipDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(order: Order) = apply {
            id = order.id
            complete = order.complete
            petId = order.petId
            quantity = order.quantity
            shipDate = order.shipDate
            status = order.status
            additionalProperties = order.additionalProperties.toMutableMap()
        }

        fun id(id: Long) = id(JsonField.of(id))

        fun id(id: JsonField<Long>) = apply { this.id = id }

        fun complete(complete: Boolean) = complete(JsonField.of(complete))

        fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

        fun petId(petId: Long) = petId(JsonField.of(petId))

        fun petId(petId: JsonField<Long>) = apply { this.petId = petId }

        fun quantity(quantity: Long) = quantity(JsonField.of(quantity))

        fun quantity(quantity: JsonField<Long>) = apply { this.quantity = quantity }

        fun shipDate(shipDate: OffsetDateTime) = shipDate(JsonField.of(shipDate))

        fun shipDate(shipDate: JsonField<OffsetDateTime>) = apply { this.shipDate = shipDate }

        /** Order Status */
        fun status(status: Status) = status(JsonField.of(status))

        /** Order Status */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): Order =
            Order(
                id,
                complete,
                petId,
                quantity,
                shipDate,
                status,
                additionalProperties.toImmutable(),
            )
    }

    /** Order Status */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            val PLACED = of("placed")

            val APPROVED = of("approved")

            val DELIVERED = of("delivered")

            fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PLACED,
            APPROVED,
            DELIVERED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PLACED,
            APPROVED,
            DELIVERED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PLACED -> Value.PLACED
                APPROVED -> Value.APPROVED
                DELIVERED -> Value.DELIVERED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SamInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                PLACED -> Known.PLACED
                APPROVED -> Known.APPROVED
                DELIVERED -> Known.DELIVERED
                else -> throw SamInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SamInvalidDataException if this class instance's value does not have the expected
         *   primitive type.
         */
        fun asString(): String =
            _value().asString() ?: throw SamInvalidDataException("Value is not a String")

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Order && id == other.id && complete == other.complete && petId == other.petId && quantity == other.quantity && shipDate == other.shipDate && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, complete, petId, quantity, shipDate, status, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Order{id=$id, complete=$complete, petId=$petId, quantity=$quantity, shipDate=$shipDate, status=$status, additionalProperties=$additionalProperties}"
}
