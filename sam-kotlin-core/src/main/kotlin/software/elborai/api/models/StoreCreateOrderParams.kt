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
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toImmutable
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*

class StoreCreateOrderParams
constructor(
    private val id: Long?,
    private val complete: Boolean?,
    private val petId: Long?,
    private val quantity: Long?,
    private val shipDate: OffsetDateTime?,
    private val status: Status?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): Long? = id

    fun complete(): Boolean? = complete

    fun petId(): Long? = petId

    fun quantity(): Long? = quantity

    fun shipDate(): OffsetDateTime? = shipDate

    fun status(): Status? = status

    internal fun getBody(): StoreCreateOrderBody {
        return StoreCreateOrderBody(
            id,
            complete,
            petId,
            quantity,
            shipDate,
            status,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = StoreCreateOrderBody.Builder::class)
    @NoAutoDetect
    class StoreCreateOrderBody
    internal constructor(
        private val id: Long?,
        private val complete: Boolean?,
        private val petId: Long?,
        private val quantity: Long?,
        private val shipDate: OffsetDateTime?,
        private val status: Status?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonProperty("id") fun id(): Long? = id

        @JsonProperty("complete") fun complete(): Boolean? = complete

        @JsonProperty("petId") fun petId(): Long? = petId

        @JsonProperty("quantity") fun quantity(): Long? = quantity

        @JsonProperty("shipDate") fun shipDate(): OffsetDateTime? = shipDate

        /** Order Status */
        @JsonProperty("status") fun status(): Status? = status

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: Long? = null
            private var complete: Boolean? = null
            private var petId: Long? = null
            private var quantity: Long? = null
            private var shipDate: OffsetDateTime? = null
            private var status: Status? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(storeCreateOrderBody: StoreCreateOrderBody) = apply {
                this.id = storeCreateOrderBody.id
                this.complete = storeCreateOrderBody.complete
                this.petId = storeCreateOrderBody.petId
                this.quantity = storeCreateOrderBody.quantity
                this.shipDate = storeCreateOrderBody.shipDate
                this.status = storeCreateOrderBody.status
                additionalProperties(storeCreateOrderBody.additionalProperties)
            }

            @JsonProperty("id") fun id(id: Long) = apply { this.id = id }

            @JsonProperty("complete")
            fun complete(complete: Boolean) = apply { this.complete = complete }

            @JsonProperty("petId") fun petId(petId: Long) = apply { this.petId = petId }

            @JsonProperty("quantity")
            fun quantity(quantity: Long) = apply { this.quantity = quantity }

            @JsonProperty("shipDate")
            fun shipDate(shipDate: OffsetDateTime) = apply { this.shipDate = shipDate }

            /** Order Status */
            @JsonProperty("status") fun status(status: Status) = apply { this.status = status }

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

            fun build(): StoreCreateOrderBody =
                StoreCreateOrderBody(
                    id,
                    complete,
                    petId,
                    quantity,
                    shipDate,
                    status,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StoreCreateOrderBody && this.id == other.id && this.complete == other.complete && this.petId == other.petId && this.quantity == other.quantity && this.shipDate == other.shipDate && this.status == other.status && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(id, complete, petId, quantity, shipDate, status, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "StoreCreateOrderBody{id=$id, complete=$complete, petId=$petId, quantity=$quantity, shipDate=$shipDate, status=$status, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is StoreCreateOrderParams && this.id == other.id && this.complete == other.complete && this.petId == other.petId && this.quantity == other.quantity && this.shipDate == other.shipDate && this.status == other.status && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(id, complete, petId, quantity, shipDate, status, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "StoreCreateOrderParams{id=$id, complete=$complete, petId=$petId, quantity=$quantity, shipDate=$shipDate, status=$status, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: Long? = null
        private var complete: Boolean? = null
        private var petId: Long? = null
        private var quantity: Long? = null
        private var shipDate: OffsetDateTime? = null
        private var status: Status? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(storeCreateOrderParams: StoreCreateOrderParams) = apply {
            this.id = storeCreateOrderParams.id
            this.complete = storeCreateOrderParams.complete
            this.petId = storeCreateOrderParams.petId
            this.quantity = storeCreateOrderParams.quantity
            this.shipDate = storeCreateOrderParams.shipDate
            this.status = storeCreateOrderParams.status
            additionalQueryParams(storeCreateOrderParams.additionalQueryParams)
            additionalHeaders(storeCreateOrderParams.additionalHeaders)
            additionalBodyProperties(storeCreateOrderParams.additionalBodyProperties)
        }

        fun id(id: Long) = apply { this.id = id }

        fun complete(complete: Boolean) = apply { this.complete = complete }

        fun petId(petId: Long) = apply { this.petId = petId }

        fun quantity(quantity: Long) = apply { this.quantity = quantity }

        fun shipDate(shipDate: OffsetDateTime) = apply { this.shipDate = shipDate }

        /** Order Status */
        fun status(status: Status) = apply { this.status = status }

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

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): StoreCreateOrderParams =
            StoreCreateOrderParams(
                id,
                complete,
                petId,
                quantity,
                shipDate,
                status,
                additionalQueryParams.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalHeaders.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalBodyProperties.toImmutable(),
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

            return /* spotless:off */ other is Status && this.value == other.value /* spotless:on */
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
}
