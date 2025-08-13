// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.complete

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
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
    private val type: JsonValue,
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
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
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
     * Expected to always return the following:
     * ```kotlin
     * JsonValue.from("completion")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

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
        private var type: JsonValue = JsonValue.from("completion")
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
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```kotlin
         * JsonValue.from("completion")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
                type,
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
        _type().let {
            if (it != JsonValue.from("completion")) {
                throw SamInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: SamInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    internal fun validity(): Int =
        (if (id.asKnown() == null) 0 else 1) +
            (if (completion.asKnown() == null) 0 else 1) +
            (if (model.asKnown() == null) 0 else 1) +
            (if (stopReason.asKnown() == null) 0 else 1) +
            type.let { if (it == JsonValue.from("completion")) 1 else 0 }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CompleteCreateResponse &&
            id == other.id &&
            completion == other.completion &&
            model == other.model &&
            stopReason == other.stopReason &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, completion, model, stopReason, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CompleteCreateResponse{id=$id, completion=$completion, model=$model, stopReason=$stopReason, type=$type, additionalProperties=$additionalProperties}"
}
