// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.OffsetDateTime
import java.util.Objects
import software.elborai.api.core.Enum
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.errors.SamInvalidDataException

@JsonDeserialize(builder = Order.Builder::class)
@NoAutoDetect
class Order
private constructor(
    private val id: JsonField<Long>,
    private val petId: JsonField<Long>,
    private val quantity: JsonField<Long>,
    private val shipDate: JsonField<OffsetDateTime>,
    private val status: JsonField<Status>,
    private val complete: JsonField<Boolean>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun id(): Long? = id.getNullable("id")

    fun petId(): Long? = petId.getNullable("petId")

    fun quantity(): Long? = quantity.getNullable("quantity")

    fun shipDate(): OffsetDateTime? = shipDate.getNullable("shipDate")

    /** Order Status */
    fun status(): Status? = status.getNullable("status")

    fun complete(): Boolean? = complete.getNullable("complete")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("petId") @ExcludeMissing fun _petId() = petId

    @JsonProperty("quantity") @ExcludeMissing fun _quantity() = quantity

    @JsonProperty("shipDate") @ExcludeMissing fun _shipDate() = shipDate

    /** Order Status */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("complete") @ExcludeMissing fun _complete() = complete

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Order = apply {
        if (!validated) {
            id()
            petId()
            quantity()
            shipDate()
            status()
            complete()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<Long> = JsonMissing.of()
        private var petId: JsonField<Long> = JsonMissing.of()
        private var quantity: JsonField<Long> = JsonMissing.of()
        private var shipDate: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var complete: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(order: Order) = apply {
            this.id = order.id
            this.petId = order.petId
            this.quantity = order.quantity
            this.shipDate = order.shipDate
            this.status = order.status
            this.complete = order.complete
            additionalProperties(order.additionalProperties)
        }

        fun id(id: Long) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<Long>) = apply { this.id = id }

        fun petId(petId: Long) = petId(JsonField.of(petId))

        @JsonProperty("petId")
        @ExcludeMissing
        fun petId(petId: JsonField<Long>) = apply { this.petId = petId }

        fun quantity(quantity: Long) = quantity(JsonField.of(quantity))

        @JsonProperty("quantity")
        @ExcludeMissing
        fun quantity(quantity: JsonField<Long>) = apply { this.quantity = quantity }

        fun shipDate(shipDate: OffsetDateTime) = shipDate(JsonField.of(shipDate))

        @JsonProperty("shipDate")
        @ExcludeMissing
        fun shipDate(shipDate: JsonField<OffsetDateTime>) = apply { this.shipDate = shipDate }

        /** Order Status */
        fun status(status: Status) = status(JsonField.of(status))

        /** Order Status */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        fun complete(complete: Boolean) = complete(JsonField.of(complete))

        @JsonProperty("complete")
        @ExcludeMissing
        fun complete(complete: JsonField<Boolean>) = apply { this.complete = complete }

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

        fun build(): Order =
            Order(
                id,
                petId,
                quantity,
                shipDate,
                status,
                complete,
                additionalProperties.toUnmodifiable(),
            )
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val PLACED = Status(JsonField.of("placed"))

            val APPROVED = Status(JsonField.of("approved"))

            val DELIVERED = Status(JsonField.of("delivered"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PLACED,
            APPROVED,
            DELIVERED,
        }

        enum class Value {
            PLACED,
            APPROVED,
            DELIVERED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PLACED -> Value.PLACED
                APPROVED -> Value.APPROVED
                DELIVERED -> Value.DELIVERED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PLACED -> Known.PLACED
                APPROVED -> Known.APPROVED
                DELIVERED -> Known.DELIVERED
                else -> throw SamInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Order &&
            this.id == other.id &&
            this.petId == other.petId &&
            this.quantity == other.quantity &&
            this.shipDate == other.shipDate &&
            this.status == other.status &&
            this.complete == other.complete &&
            this.additionalProperties == other.additionalProperties
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    petId,
                    quantity,
                    shipDate,
                    status,
                    complete,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "Order{id=$id, petId=$petId, quantity=$quantity, shipDate=$shipDate, status=$status, complete=$complete, additionalProperties=$additionalProperties}"
}
