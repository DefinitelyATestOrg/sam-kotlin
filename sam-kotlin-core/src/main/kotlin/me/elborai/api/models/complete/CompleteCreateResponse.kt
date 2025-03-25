// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.complete

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import me.elborai.api.core.Enum
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.checkRequired
import me.elborai.api.errors.SamInvalidDataException

class CompleteCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val completion: JsonField<String>,
    private val model: JsonField<String>,
    private val stopReason: JsonField<String>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completion")
        @ExcludeMissing
        completion: JsonField<String> = JsonMissing.of(),
        @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("stop_reason")
        @ExcludeMissing
        stopReason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(id, completion, model, stopReason, type, mutableMapOf())

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The resulting completion up to and excluding the stop sequences.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completion(): String = completion.getRequired("completion")

    /**
     * The model that handled the request.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = model.getRequired("model")

    /**
     * The reason that we stopped.
     *
     * This may be one the following values:
     * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
     *   `stop_sequences` parameter, or a stop sequence built into the model
     * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun stopReason(): String? = stopReason.getNullable("stop_reason")

    /**
     * Object type.
     *
     * For Text Completions, this is always `"completion"`.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [completion].
     *
     * Unlike [completion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("completion") @ExcludeMissing fun _completion(): JsonField<String> = completion

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

    /**
     * Returns the raw JSON value of [stopReason].
     *
     * Unlike [stopReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("stop_reason") @ExcludeMissing fun _stopReason(): JsonField<String> = stopReason

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CompleteCreateResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .id()
         * .completion()
         * .model()
         * .stopReason()
         * .type()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [CompleteCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var completion: JsonField<String>? = null
        private var model: JsonField<String>? = null
        private var stopReason: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(completeCreateResponse: CompleteCreateResponse) = apply {
            id = completeCreateResponse.id
            completion = completeCreateResponse.completion
            model = completeCreateResponse.model
            stopReason = completeCreateResponse.stopReason
            type = completeCreateResponse.type
            additionalProperties = completeCreateResponse.additionalProperties.toMutableMap()
        }

        /**
         * Unique object identifier.
         *
         * The format and length of IDs may change over time.
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The resulting completion up to and excluding the stop sequences. */
        fun completion(completion: String) = completion(JsonField.of(completion))

        /**
         * Sets [Builder.completion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completion] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun completion(completion: JsonField<String>) = apply { this.completion = completion }

        /** The model that handled the request. */
        fun model(model: String) = model(JsonField.of(model))

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { this.model = model }

        /**
         * The reason that we stopped.
         *
         * This may be one the following values:
         * - `"stop_sequence"`: we reached a stop sequence — either provided by you via the
         *   `stop_sequences` parameter, or a stop sequence built into the model
         * - `"max_tokens"`: we exceeded `max_tokens_to_sample` or the model's maximum
         */
        fun stopReason(stopReason: String?) = stopReason(JsonField.ofNullable(stopReason))

        /**
         * Sets [Builder.stopReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stopReason] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun stopReason(stopReason: JsonField<String>) = apply { this.stopReason = stopReason }

        /**
         * Object type.
         *
         * For Text Completions, this is always `"completion"`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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

        /**
         * Returns an immutable instance of [CompleteCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .id()
         * .completion()
         * .model()
         * .stopReason()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CompleteCreateResponse =
            CompleteCreateResponse(
                checkRequired("id", id),
                checkRequired("completion", completion),
                checkRequired("model", model),
                checkRequired("stopReason", stopReason),
                checkRequired("type", type),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CompleteCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        completion()
        model()
        stopReason()
        type()
        validated = true
    }

    /**
     * Object type.
     *
     * For Text Completions, this is always `"completion"`.
     */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            val COMPLETION = of("completion")

            fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            COMPLETION
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPLETION,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                COMPLETION -> Value.COMPLETION
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
                COMPLETION -> Known.COMPLETION
                else -> throw SamInvalidDataException("Unknown Type: $value")
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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is CompleteCreateResponse && id == other.id && completion == other.completion && model == other.model && stopReason == other.stopReason && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, completion, model, stopReason, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompleteCreateResponse{id=$id, completion=$completion, model=$model, stopReason=$stopReason, type=$type, additionalProperties=$additionalProperties}"
}
