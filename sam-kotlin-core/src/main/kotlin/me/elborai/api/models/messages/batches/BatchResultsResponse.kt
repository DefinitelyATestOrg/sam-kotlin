// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects
import me.elborai.api.core.BaseDeserializer
import me.elborai.api.core.BaseSerializer
import me.elborai.api.core.Enum
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.checkKnown
import me.elborai.api.core.checkRequired
import me.elborai.api.core.getOrThrow
import me.elborai.api.core.toImmutable
import me.elborai.api.errors.SamInvalidDataException

/**
 * This is a single line in the response `.jsonl` file and does not represent the response as a
 * whole.
 */
class BatchResultsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val customId: JsonField<String>,
    private val result: JsonField<Result>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("custom_id") @ExcludeMissing customId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("result") @ExcludeMissing result: JsonField<Result> = JsonMissing.of(),
    ) : this(customId, result, mutableMapOf())

    /**
     * Developer-provided ID created for each request in a Message Batch. Useful for matching
     * results to requests, as results may be given out of request order.
     *
     * Must be unique for each request within the Message Batch.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun customId(): String = customId.getRequired("custom_id")

    /**
     * Processing result for this request.
     *
     * Contains a Message output if processing was successful, an error response if processing
     * failed, or the reason why processing was not attempted, such as cancellation or expiration.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun result(): Result = result.getRequired("result")

    /**
     * Returns the raw JSON value of [customId].
     *
     * Unlike [customId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("custom_id") @ExcludeMissing fun _customId(): JsonField<String> = customId

    /**
     * Returns the raw JSON value of [result].
     *
     * Unlike [result], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<Result> = result

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
         * Returns a mutable builder for constructing an instance of [BatchResultsResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .customId()
         * .result()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [BatchResultsResponse]. */
    class Builder internal constructor() {

        private var customId: JsonField<String>? = null
        private var result: JsonField<Result>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(batchResultsResponse: BatchResultsResponse) = apply {
            customId = batchResultsResponse.customId
            result = batchResultsResponse.result
            additionalProperties = batchResultsResponse.additionalProperties.toMutableMap()
        }

        /**
         * Developer-provided ID created for each request in a Message Batch. Useful for matching
         * results to requests, as results may be given out of request order.
         *
         * Must be unique for each request within the Message Batch.
         */
        fun customId(customId: String) = customId(JsonField.of(customId))

        /**
         * Sets [Builder.customId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun customId(customId: JsonField<String>) = apply { this.customId = customId }

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun result(result: Result) = result(JsonField.of(result))

        /**
         * Sets [Builder.result] to an arbitrary JSON value.
         *
         * You should usually call [Builder.result] with a well-typed [Result] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun result(result: JsonField<Result>) = apply { this.result = result }

        /** Alias for calling [result] with `Result.ofSucceeded(succeeded)`. */
        fun result(succeeded: Result.Succeeded) = result(Result.ofSucceeded(succeeded))

        /**
         * Alias for calling [result] with the following:
         * ```kotlin
         * Result.Succeeded.builder()
         *     .message(message)
         *     .build()
         * ```
         */
        fun succeededResult(message: Result.Succeeded.Message) =
            result(Result.Succeeded.builder().message(message).build())

        /** Alias for calling [result] with `Result.ofErrored(errored)`. */
        fun result(errored: Result.Errored) = result(Result.ofErrored(errored))

        /**
         * Alias for calling [result] with the following:
         * ```kotlin
         * Result.Errored.builder()
         *     .error(error)
         *     .build()
         * ```
         */
        fun erroredResult(error: Result.Errored.Error) =
            result(Result.Errored.builder().error(error).build())

        /** Alias for calling [result] with `Result.ofCanceled()`. */
        fun resultCanceled() = result(Result.ofCanceled())

        /** Alias for calling [result] with `Result.ofExpired()`. */
        fun resultExpired() = result(Result.ofExpired())

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
         * Returns an immutable instance of [BatchResultsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .customId()
         * .result()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BatchResultsResponse =
            BatchResultsResponse(
                checkRequired("customId", customId),
                checkRequired("result", result),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BatchResultsResponse = apply {
        if (validated) {
            return@apply
        }

        customId()
        result().validate()
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
        (if (customId.asKnown() == null) 0 else 1) + (result.asKnown()?.validity() ?: 0)

    /**
     * Processing result for this request.
     *
     * Contains a Message output if processing was successful, an error response if processing
     * failed, or the reason why processing was not attempted, such as cancellation or expiration.
     */
    @JsonDeserialize(using = Result.Deserializer::class)
    @JsonSerialize(using = Result.Serializer::class)
    class Result
    private constructor(
        private val succeeded: Succeeded? = null,
        private val errored: Errored? = null,
        private val canceled: JsonValue? = null,
        private val expired: JsonValue? = null,
        private val _json: JsonValue? = null,
    ) {

        fun succeeded(): Succeeded? = succeeded

        fun errored(): Errored? = errored

        fun canceled(): JsonValue? = canceled

        fun expired(): JsonValue? = expired

        fun isSucceeded(): Boolean = succeeded != null

        fun isErrored(): Boolean = errored != null

        fun isCanceled(): Boolean = canceled != null

        fun isExpired(): Boolean = expired != null

        fun asSucceeded(): Succeeded = succeeded.getOrThrow("succeeded")

        fun asErrored(): Errored = errored.getOrThrow("errored")

        fun asCanceled(): JsonValue = canceled.getOrThrow("canceled")

        fun asExpired(): JsonValue = expired.getOrThrow("expired")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                succeeded != null -> visitor.visitSucceeded(succeeded)
                errored != null -> visitor.visitErrored(errored)
                canceled != null -> visitor.visitCanceled(canceled)
                expired != null -> visitor.visitExpired(expired)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitSucceeded(succeeded: Succeeded) {
                        succeeded.validate()
                    }

                    override fun visitErrored(errored: Errored) {
                        errored.validate()
                    }

                    override fun visitCanceled(canceled: JsonValue) {
                        canceled.let {
                            if (it != JsonValue.from(mapOf("type" to "canceled"))) {
                                throw SamInvalidDataException("'canceled' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitExpired(expired: JsonValue) {
                        expired.let {
                            if (it != JsonValue.from(mapOf("type" to "expired"))) {
                                throw SamInvalidDataException("'expired' is invalid, received $it")
                            }
                        }
                    }
                }
            )
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitSucceeded(succeeded: Succeeded) = succeeded.validity()

                    override fun visitErrored(errored: Errored) = errored.validity()

                    override fun visitCanceled(canceled: JsonValue) =
                        canceled.let {
                            if (it == JsonValue.from(mapOf("type" to "canceled"))) 1 else 0
                        }

                    override fun visitExpired(expired: JsonValue) =
                        expired.let {
                            if (it == JsonValue.from(mapOf("type" to "expired"))) 1 else 0
                        }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result &&
                succeeded == other.succeeded &&
                errored == other.errored &&
                canceled == other.canceled &&
                expired == other.expired
        }

        override fun hashCode(): Int = Objects.hash(succeeded, errored, canceled, expired)

        override fun toString(): String =
            when {
                succeeded != null -> "Result{succeeded=$succeeded}"
                errored != null -> "Result{errored=$errored}"
                canceled != null -> "Result{canceled=$canceled}"
                expired != null -> "Result{expired=$expired}"
                _json != null -> "Result{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Result")
            }

        companion object {

            fun ofSucceeded(succeeded: Succeeded) = Result(succeeded = succeeded)

            fun ofErrored(errored: Errored) = Result(errored = errored)

            fun ofCanceled() = Result(canceled = JsonValue.from(mapOf("type" to "canceled")))

            fun ofExpired() = Result(expired = JsonValue.from(mapOf("type" to "expired")))
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitSucceeded(succeeded: Succeeded): T

            fun visitErrored(errored: Errored): T

            fun visitCanceled(canceled: JsonValue): T

            fun visitExpired(expired: JsonValue): T

            /**
             * Maps an unknown variant of [Result] to a value of type [T].
             *
             * An instance of [Result] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws SamInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw SamInvalidDataException("Unknown Result: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Result>(Result::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Result {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject()?.get("type")?.asString()

                when (type) {
                    "succeeded" -> {
                        return tryDeserialize(node, jacksonTypeRef<Succeeded>())?.let {
                            Result(succeeded = it, _json = json)
                        } ?: Result(_json = json)
                    }
                    "errored" -> {
                        return tryDeserialize(node, jacksonTypeRef<Errored>())?.let {
                            Result(errored = it, _json = json)
                        } ?: Result(_json = json)
                    }
                    "canceled" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Result(canceled = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Result(_json = json)
                    }
                    "expired" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Result(expired = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Result(_json = json)
                    }
                }

                return Result(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Result>(Result::class) {

            override fun serialize(
                value: Result,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.succeeded != null -> generator.writeObject(value.succeeded)
                    value.errored != null -> generator.writeObject(value.errored)
                    value.canceled != null -> generator.writeObject(value.canceled)
                    value.expired != null -> generator.writeObject(value.expired)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Result")
                }
            }
        }

        class Succeeded
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val message: JsonField<Message>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<Message> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(message, type, mutableMapOf())

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): Message = message.getRequired("message")

            /**
             * Expected to always return the following:
             * ```kotlin
             * JsonValue.from("succeeded")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<Message> = message

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
                 * Returns a mutable builder for constructing an instance of [Succeeded].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .message()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [Succeeded]. */
            class Builder internal constructor() {

                private var message: JsonField<Message>? = null
                private var type: JsonValue = JsonValue.from("succeeded")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(succeeded: Succeeded) = apply {
                    message = succeeded.message
                    type = succeeded.type
                    additionalProperties = succeeded.additionalProperties.toMutableMap()
                }

                fun message(message: Message) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [Message] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<Message>) = apply { this.message = message }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```kotlin
                 * JsonValue.from("succeeded")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Succeeded].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .message()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Succeeded =
                    Succeeded(
                        checkRequired("message", message),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Succeeded = apply {
                if (validated) {
                    return@apply
                }

                message().validate()
                _type().let {
                    if (it != JsonValue.from("succeeded")) {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            internal fun validity(): Int =
                (message.asKnown()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("succeeded")) 1 else 0 }

            class Message
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val content: JsonField<List<Content>>,
                private val model: JsonField<String>,
                private val role: JsonValue,
                private val stopReason: JsonField<StopReason>,
                private val stopSequence: JsonField<String>,
                private val type: JsonValue,
                private val usage: JsonField<Usage>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("content")
                    @ExcludeMissing
                    content: JsonField<List<Content>> = JsonMissing.of(),
                    @JsonProperty("model")
                    @ExcludeMissing
                    model: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("role") @ExcludeMissing role: JsonValue = JsonMissing.of(),
                    @JsonProperty("stop_reason")
                    @ExcludeMissing
                    stopReason: JsonField<StopReason> = JsonMissing.of(),
                    @JsonProperty("stop_sequence")
                    @ExcludeMissing
                    stopSequence: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("usage")
                    @ExcludeMissing
                    usage: JsonField<Usage> = JsonMissing.of(),
                ) : this(
                    id,
                    content,
                    model,
                    role,
                    stopReason,
                    stopSequence,
                    type,
                    usage,
                    mutableMapOf(),
                )

                /**
                 * Unique object identifier.
                 *
                 * The format and length of IDs may change over time.
                 *
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun id(): String = id.getRequired("id")

                /**
                 * Content generated by the model.
                 *
                 * This is an array of content blocks, each of which has a `type` that determines
                 * its shape.
                 *
                 * Example:
                 * ```json
                 * [{"type": "text", "text": "Hi, I'm Claude."}]
                 * ```
                 *
                 * If the request input `messages` ended with an `assistant` turn, then the response
                 * `content` will continue directly from that last turn. You can use this to
                 * constrain the model's output.
                 *
                 * For example, if the input `messages` were:
                 * ```json
                 * [
                 *   {"role": "user", "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"},
                 *   {"role": "assistant", "content": "The best answer is ("}
                 * ]
                 * ```
                 *
                 * Then the response `content` might be:
                 * ```json
                 * [{"type": "text", "text": "B)"}]
                 * ```
                 *
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun content(): List<Content> = content.getRequired("content")

                /**
                 * The model that handled the request.
                 *
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun model(): String = model.getRequired("model")

                /**
                 * Conversational role of the generated message.
                 *
                 * This will always be `"assistant"`.
                 *
                 * Expected to always return the following:
                 * ```kotlin
                 * JsonValue.from("assistant")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("role") @ExcludeMissing fun _role(): JsonValue = role

                /**
                 * The reason that we stopped.
                 *
                 * This may be one the following values:
                 * * `"end_turn"`: the model reached a natural stopping point
                 * * `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
                 * * `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
                 * * `"tool_use"`: the model invoked one or more tools
                 *
                 * In non-streaming mode this value is always non-null. In streaming mode, it is
                 * null in the `message_start` event and non-null otherwise.
                 *
                 * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if
                 *   the server responded with an unexpected value).
                 */
                fun stopReason(): StopReason? = stopReason.getNullable("stop_reason")

                /**
                 * Which custom stop sequence was generated, if any.
                 *
                 * This value will be a non-null string if one of your custom stop sequences was
                 * generated.
                 *
                 * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if
                 *   the server responded with an unexpected value).
                 */
                fun stopSequence(): String? = stopSequence.getNullable("stop_sequence")

                /**
                 * Object type.
                 *
                 * For Messages, this is always `"message"`.
                 *
                 * Expected to always return the following:
                 * ```kotlin
                 * JsonValue.from("message")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Billing and rate-limit usage.
                 *
                 * Anthropic's API bills and rate-limits by token counts, as tokens represent the
                 * underlying cost to our systems.
                 *
                 * Under the hood, the API transforms requests into a format suitable for the model.
                 * The model's output then goes through a parsing stage before becoming an API
                 * response. As a result, the token counts in `usage` will not match one-to-one with
                 * the exact visible content of an API request or response.
                 *
                 * For example, `output_tokens` will be non-zero, even for an empty string response
                 * from Claude.
                 *
                 * Total input tokens in a request is the summation of `input_tokens`,
                 * `cache_creation_input_tokens`, and `cache_read_input_tokens`.
                 *
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun usage(): Usage = usage.getRequired("usage")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [content].
                 *
                 * Unlike [content], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("content")
                @ExcludeMissing
                fun _content(): JsonField<List<Content>> = content

                /**
                 * Returns the raw JSON value of [model].
                 *
                 * Unlike [model], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

                /**
                 * Returns the raw JSON value of [stopReason].
                 *
                 * Unlike [stopReason], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("stop_reason")
                @ExcludeMissing
                fun _stopReason(): JsonField<StopReason> = stopReason

                /**
                 * Returns the raw JSON value of [stopSequence].
                 *
                 * Unlike [stopSequence], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("stop_sequence")
                @ExcludeMissing
                fun _stopSequence(): JsonField<String> = stopSequence

                /**
                 * Returns the raw JSON value of [usage].
                 *
                 * Unlike [usage], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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
                     * Returns a mutable builder for constructing an instance of [Message].
                     *
                     * The following fields are required:
                     * ```kotlin
                     * .id()
                     * .content()
                     * .model()
                     * .stopReason()
                     * .stopSequence()
                     * .usage()
                     * ```
                     */
                    fun builder() = Builder()
                }

                /** A builder for [Message]. */
                class Builder internal constructor() {

                    private var id: JsonField<String>? = null
                    private var content: JsonField<MutableList<Content>>? = null
                    private var model: JsonField<String>? = null
                    private var role: JsonValue = JsonValue.from("assistant")
                    private var stopReason: JsonField<StopReason>? = null
                    private var stopSequence: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("message")
                    private var usage: JsonField<Usage>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(message: Message) = apply {
                        id = message.id
                        content = message.content.map { it.toMutableList() }
                        model = message.model
                        role = message.role
                        stopReason = message.stopReason
                        stopSequence = message.stopSequence
                        type = message.type
                        usage = message.usage
                        additionalProperties = message.additionalProperties.toMutableMap()
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
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /**
                     * Content generated by the model.
                     *
                     * This is an array of content blocks, each of which has a `type` that
                     * determines its shape.
                     *
                     * Example:
                     * ```json
                     * [{"type": "text", "text": "Hi, I'm Claude."}]
                     * ```
                     *
                     * If the request input `messages` ended with an `assistant` turn, then the
                     * response `content` will continue directly from that last turn. You can use
                     * this to constrain the model's output.
                     *
                     * For example, if the input `messages` were:
                     * ```json
                     * [
                     *   {"role": "user", "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"},
                     *   {"role": "assistant", "content": "The best answer is ("}
                     * ]
                     * ```
                     *
                     * Then the response `content` might be:
                     * ```json
                     * [{"type": "text", "text": "B)"}]
                     * ```
                     */
                    fun content(content: List<Content>) = content(JsonField.of(content))

                    /**
                     * Sets [Builder.content] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.content] with a well-typed `List<Content>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun content(content: JsonField<List<Content>>) = apply {
                        this.content = content.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Content] to [Builder.content].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addContent(content: Content) = apply {
                        this.content =
                            (this.content ?: JsonField.of(mutableListOf())).also {
                                checkKnown("content", it).add(content)
                            }
                    }

                    /** Alias for calling [addContent] with `Content.ofText(text)`. */
                    fun addContent(text: Content.Text) = addContent(Content.ofText(text))

                    /** Alias for calling [addContent] with `Content.ofToolUse(toolUse)`. */
                    fun addContent(toolUse: Content.ToolUse) =
                        addContent(Content.ofToolUse(toolUse))

                    /** Alias for calling [addContent] with `Content.ofThinking(thinking)`. */
                    fun addContent(thinking: Content.Thinking) =
                        addContent(Content.ofThinking(thinking))

                    /**
                     * Alias for calling [addContent] with
                     * `Content.ofRedactedThinking(redactedThinking)`.
                     */
                    fun addContent(redactedThinking: Content.RedactedThinking) =
                        addContent(Content.ofRedactedThinking(redactedThinking))

                    /**
                     * Alias for calling [addContent] with the following:
                     * ```kotlin
                     * Content.RedactedThinking.builder()
                     *     .data(data)
                     *     .build()
                     * ```
                     */
                    fun addRedactedThinkingContent(data: String) =
                        addContent(Content.RedactedThinking.builder().data(data).build())

                    /** The model that handled the request. */
                    fun model(model: String) = model(JsonField.of(model))

                    /**
                     * Sets [Builder.model] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.model] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```kotlin
                     * JsonValue.from("assistant")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun role(role: JsonValue) = apply { this.role = role }

                    /**
                     * The reason that we stopped.
                     *
                     * This may be one the following values:
                     * * `"end_turn"`: the model reached a natural stopping point
                     * * `"max_tokens"`: we exceeded the requested `max_tokens` or the model's
                     *   maximum
                     * * `"stop_sequence"`: one of your provided custom `stop_sequences` was
                     *   generated
                     * * `"tool_use"`: the model invoked one or more tools
                     *
                     * In non-streaming mode this value is always non-null. In streaming mode, it is
                     * null in the `message_start` event and non-null otherwise.
                     */
                    fun stopReason(stopReason: StopReason?) =
                        stopReason(JsonField.ofNullable(stopReason))

                    /**
                     * Sets [Builder.stopReason] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.stopReason] with a well-typed [StopReason]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun stopReason(stopReason: JsonField<StopReason>) = apply {
                        this.stopReason = stopReason
                    }

                    /**
                     * Which custom stop sequence was generated, if any.
                     *
                     * This value will be a non-null string if one of your custom stop sequences was
                     * generated.
                     */
                    fun stopSequence(stopSequence: String?) =
                        stopSequence(JsonField.ofNullable(stopSequence))

                    /**
                     * Sets [Builder.stopSequence] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.stopSequence] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun stopSequence(stopSequence: JsonField<String>) = apply {
                        this.stopSequence = stopSequence
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```kotlin
                     * JsonValue.from("message")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /**
                     * Billing and rate-limit usage.
                     *
                     * Anthropic's API bills and rate-limits by token counts, as tokens represent
                     * the underlying cost to our systems.
                     *
                     * Under the hood, the API transforms requests into a format suitable for the
                     * model. The model's output then goes through a parsing stage before becoming
                     * an API response. As a result, the token counts in `usage` will not match
                     * one-to-one with the exact visible content of an API request or response.
                     *
                     * For example, `output_tokens` will be non-zero, even for an empty string
                     * response from Claude.
                     *
                     * Total input tokens in a request is the summation of `input_tokens`,
                     * `cache_creation_input_tokens`, and `cache_read_input_tokens`.
                     */
                    fun usage(usage: Usage) = usage(JsonField.of(usage))

                    /**
                     * Sets [Builder.usage] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.usage] with a well-typed [Usage] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Message].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```kotlin
                     * .id()
                     * .content()
                     * .model()
                     * .stopReason()
                     * .stopSequence()
                     * .usage()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Message =
                        Message(
                            checkRequired("id", id),
                            checkRequired("content", content).map { it.toImmutable() },
                            checkRequired("model", model),
                            role,
                            checkRequired("stopReason", stopReason),
                            checkRequired("stopSequence", stopSequence),
                            type,
                            checkRequired("usage", usage),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Message = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    content().forEach { it.validate() }
                    model()
                    _role().let {
                        if (it != JsonValue.from("assistant")) {
                            throw SamInvalidDataException("'role' is invalid, received $it")
                        }
                    }
                    stopReason()?.validate()
                    stopSequence()
                    _type().let {
                        if (it != JsonValue.from("message")) {
                            throw SamInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    usage().validate()
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                internal fun validity(): Int =
                    (if (id.asKnown() == null) 0 else 1) +
                        (content.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
                        (if (model.asKnown() == null) 0 else 1) +
                        role.let { if (it == JsonValue.from("assistant")) 1 else 0 } +
                        (stopReason.asKnown()?.validity() ?: 0) +
                        (if (stopSequence.asKnown() == null) 0 else 1) +
                        type.let { if (it == JsonValue.from("message")) 1 else 0 } +
                        (usage.asKnown()?.validity() ?: 0)

                @JsonDeserialize(using = Content.Deserializer::class)
                @JsonSerialize(using = Content.Serializer::class)
                class Content
                private constructor(
                    private val text: Text? = null,
                    private val toolUse: ToolUse? = null,
                    private val thinking: Thinking? = null,
                    private val redactedThinking: RedactedThinking? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun text(): Text? = text

                    fun toolUse(): ToolUse? = toolUse

                    fun thinking(): Thinking? = thinking

                    fun redactedThinking(): RedactedThinking? = redactedThinking

                    fun isText(): Boolean = text != null

                    fun isToolUse(): Boolean = toolUse != null

                    fun isThinking(): Boolean = thinking != null

                    fun isRedactedThinking(): Boolean = redactedThinking != null

                    fun asText(): Text = text.getOrThrow("text")

                    fun asToolUse(): ToolUse = toolUse.getOrThrow("toolUse")

                    fun asThinking(): Thinking = thinking.getOrThrow("thinking")

                    fun asRedactedThinking(): RedactedThinking =
                        redactedThinking.getOrThrow("redactedThinking")

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            text != null -> visitor.visitText(text)
                            toolUse != null -> visitor.visitToolUse(toolUse)
                            thinking != null -> visitor.visitThinking(thinking)
                            redactedThinking != null ->
                                visitor.visitRedactedThinking(redactedThinking)
                            else -> visitor.unknown(_json)
                        }

                    private var validated: Boolean = false

                    fun validate(): Content = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitText(text: Text) {
                                    text.validate()
                                }

                                override fun visitToolUse(toolUse: ToolUse) {
                                    toolUse.validate()
                                }

                                override fun visitThinking(thinking: Thinking) {
                                    thinking.validate()
                                }

                                override fun visitRedactedThinking(
                                    redactedThinking: RedactedThinking
                                ) {
                                    redactedThinking.validate()
                                }
                            }
                        )
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    internal fun validity(): Int =
                        accept(
                            object : Visitor<Int> {
                                override fun visitText(text: Text) = text.validity()

                                override fun visitToolUse(toolUse: ToolUse) = toolUse.validity()

                                override fun visitThinking(thinking: Thinking) = thinking.validity()

                                override fun visitRedactedThinking(
                                    redactedThinking: RedactedThinking
                                ) = redactedThinking.validity()

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Content &&
                            text == other.text &&
                            toolUse == other.toolUse &&
                            thinking == other.thinking &&
                            redactedThinking == other.redactedThinking
                    }

                    override fun hashCode(): Int =
                        Objects.hash(text, toolUse, thinking, redactedThinking)

                    override fun toString(): String =
                        when {
                            text != null -> "Content{text=$text}"
                            toolUse != null -> "Content{toolUse=$toolUse}"
                            thinking != null -> "Content{thinking=$thinking}"
                            redactedThinking != null ->
                                "Content{redactedThinking=$redactedThinking}"
                            _json != null -> "Content{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Content")
                        }

                    companion object {

                        fun ofText(text: Text) = Content(text = text)

                        fun ofToolUse(toolUse: ToolUse) = Content(toolUse = toolUse)

                        fun ofThinking(thinking: Thinking) = Content(thinking = thinking)

                        fun ofRedactedThinking(redactedThinking: RedactedThinking) =
                            Content(redactedThinking = redactedThinking)
                    }

                    /**
                     * An interface that defines how to map each variant of [Content] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitText(text: Text): T

                        fun visitToolUse(toolUse: ToolUse): T

                        fun visitThinking(thinking: Thinking): T

                        fun visitRedactedThinking(redactedThinking: RedactedThinking): T

                        /**
                         * Maps an unknown variant of [Content] to a value of type [T].
                         *
                         * An instance of [Content] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws SamInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw SamInvalidDataException("Unknown Content: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<Content>(Content::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): Content {
                            val json = JsonValue.fromJsonNode(node)
                            val type = json.asObject()?.get("type")?.asString()

                            when (type) {
                                "text" -> {
                                    return tryDeserialize(node, jacksonTypeRef<Text>())?.let {
                                        Content(text = it, _json = json)
                                    } ?: Content(_json = json)
                                }
                                "tool_use" -> {
                                    return tryDeserialize(node, jacksonTypeRef<ToolUse>())?.let {
                                        Content(toolUse = it, _json = json)
                                    } ?: Content(_json = json)
                                }
                                "thinking" -> {
                                    return tryDeserialize(node, jacksonTypeRef<Thinking>())?.let {
                                        Content(thinking = it, _json = json)
                                    } ?: Content(_json = json)
                                }
                                "redacted_thinking" -> {
                                    return tryDeserialize(node, jacksonTypeRef<RedactedThinking>())
                                        ?.let { Content(redactedThinking = it, _json = json) }
                                        ?: Content(_json = json)
                                }
                            }

                            return Content(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<Content>(Content::class) {

                        override fun serialize(
                            value: Content,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.text != null -> generator.writeObject(value.text)
                                value.toolUse != null -> generator.writeObject(value.toolUse)
                                value.thinking != null -> generator.writeObject(value.thinking)
                                value.redactedThinking != null ->
                                    generator.writeObject(value.redactedThinking)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Content")
                            }
                        }
                    }

                    class Text
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val citations: JsonField<List<Citation>>,
                        private val text: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("citations")
                            @ExcludeMissing
                            citations: JsonField<List<Citation>> = JsonMissing.of(),
                            @JsonProperty("text")
                            @ExcludeMissing
                            text: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(citations, text, type, mutableMapOf())

                        /**
                         * Citations supporting the text block.
                         *
                         * The type of citation returned will depend on the type of document being
                         * cited. Citing a PDF results in `page_location`, plain text results in
                         * `char_location`, and content document results in
                         * `content_block_location`.
                         *
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun citations(): List<Citation>? = citations.getNullable("citations")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun text(): String = text.getRequired("text")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("text")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [citations].
                         *
                         * Unlike [citations], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("citations")
                        @ExcludeMissing
                        fun _citations(): JsonField<List<Citation>> = citations

                        /**
                         * Returns the raw JSON value of [text].
                         *
                         * Unlike [text], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
                             * Returns a mutable builder for constructing an instance of [Text].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .citations()
                             * .text()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [Text]. */
                        class Builder internal constructor() {

                            private var citations: JsonField<MutableList<Citation>>? = null
                            private var text: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("text")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(text: Text) = apply {
                                citations = text.citations.map { it.toMutableList() }
                                this.text = text.text
                                type = text.type
                                additionalProperties = text.additionalProperties.toMutableMap()
                            }

                            /**
                             * Citations supporting the text block.
                             *
                             * The type of citation returned will depend on the type of document
                             * being cited. Citing a PDF results in `page_location`, plain text
                             * results in `char_location`, and content document results in
                             * `content_block_location`.
                             */
                            fun citations(citations: List<Citation>?) =
                                citations(JsonField.ofNullable(citations))

                            /**
                             * Sets [Builder.citations] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.citations] with a well-typed
                             * `List<Citation>` value instead. This method is primarily for setting
                             * the field to an undocumented or not yet supported value.
                             */
                            fun citations(citations: JsonField<List<Citation>>) = apply {
                                this.citations = citations.map { it.toMutableList() }
                            }

                            /**
                             * Adds a single [Citation] to [citations].
                             *
                             * @throws IllegalStateException if the field was previously set to a
                             *   non-list.
                             */
                            fun addCitation(citation: Citation) = apply {
                                citations =
                                    (citations ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("citations", it).add(citation)
                                    }
                            }

                            /**
                             * Alias for calling [addCitation] with
                             * `Citation.ofCharLocation(charLocation)`.
                             */
                            fun addCitation(charLocation: Citation.CharLocation) =
                                addCitation(Citation.ofCharLocation(charLocation))

                            /**
                             * Alias for calling [addCitation] with
                             * `Citation.ofPageLocation(pageLocation)`.
                             */
                            fun addCitation(pageLocation: Citation.PageLocation) =
                                addCitation(Citation.ofPageLocation(pageLocation))

                            /**
                             * Alias for calling [addCitation] with
                             * `Citation.ofContentBlockLocation(contentBlockLocation)`.
                             */
                            fun addCitation(contentBlockLocation: Citation.ContentBlockLocation) =
                                addCitation(Citation.ofContentBlockLocation(contentBlockLocation))

                            fun text(text: String) = text(JsonField.of(text))

                            /**
                             * Sets [Builder.text] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.text] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun text(text: JsonField<String>) = apply { this.text = text }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("text")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Text].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .citations()
                             * .text()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Text =
                                Text(
                                    checkRequired("citations", citations).map { it.toImmutable() },
                                    checkRequired("text", text),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Text = apply {
                            if (validated) {
                                return@apply
                            }

                            citations()?.forEach { it.validate() }
                            text()
                            _type().let {
                                if (it != JsonValue.from("text")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (citations.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
                                (if (text.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("text")) 1 else 0 }

                        @JsonDeserialize(using = Citation.Deserializer::class)
                        @JsonSerialize(using = Citation.Serializer::class)
                        class Citation
                        private constructor(
                            private val charLocation: CharLocation? = null,
                            private val pageLocation: PageLocation? = null,
                            private val contentBlockLocation: ContentBlockLocation? = null,
                            private val _json: JsonValue? = null,
                        ) {

                            fun charLocation(): CharLocation? = charLocation

                            fun pageLocation(): PageLocation? = pageLocation

                            fun contentBlockLocation(): ContentBlockLocation? = contentBlockLocation

                            fun isCharLocation(): Boolean = charLocation != null

                            fun isPageLocation(): Boolean = pageLocation != null

                            fun isContentBlockLocation(): Boolean = contentBlockLocation != null

                            fun asCharLocation(): CharLocation =
                                charLocation.getOrThrow("charLocation")

                            fun asPageLocation(): PageLocation =
                                pageLocation.getOrThrow("pageLocation")

                            fun asContentBlockLocation(): ContentBlockLocation =
                                contentBlockLocation.getOrThrow("contentBlockLocation")

                            fun _json(): JsonValue? = _json

                            fun <T> accept(visitor: Visitor<T>): T =
                                when {
                                    charLocation != null -> visitor.visitCharLocation(charLocation)
                                    pageLocation != null -> visitor.visitPageLocation(pageLocation)
                                    contentBlockLocation != null ->
                                        visitor.visitContentBlockLocation(contentBlockLocation)
                                    else -> visitor.unknown(_json)
                                }

                            private var validated: Boolean = false

                            fun validate(): Citation = apply {
                                if (validated) {
                                    return@apply
                                }

                                accept(
                                    object : Visitor<Unit> {
                                        override fun visitCharLocation(charLocation: CharLocation) {
                                            charLocation.validate()
                                        }

                                        override fun visitPageLocation(pageLocation: PageLocation) {
                                            pageLocation.validate()
                                        }

                                        override fun visitContentBlockLocation(
                                            contentBlockLocation: ContentBlockLocation
                                        ) {
                                            contentBlockLocation.validate()
                                        }
                                    }
                                )
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
                             * Returns a score indicating how many valid values are contained in
                             * this object recursively.
                             *
                             * Used for best match union deserialization.
                             */
                            internal fun validity(): Int =
                                accept(
                                    object : Visitor<Int> {
                                        override fun visitCharLocation(charLocation: CharLocation) =
                                            charLocation.validity()

                                        override fun visitPageLocation(pageLocation: PageLocation) =
                                            pageLocation.validity()

                                        override fun visitContentBlockLocation(
                                            contentBlockLocation: ContentBlockLocation
                                        ) = contentBlockLocation.validity()

                                        override fun unknown(json: JsonValue?) = 0
                                    }
                                )

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return other is Citation &&
                                    charLocation == other.charLocation &&
                                    pageLocation == other.pageLocation &&
                                    contentBlockLocation == other.contentBlockLocation
                            }

                            override fun hashCode(): Int =
                                Objects.hash(charLocation, pageLocation, contentBlockLocation)

                            override fun toString(): String =
                                when {
                                    charLocation != null -> "Citation{charLocation=$charLocation}"
                                    pageLocation != null -> "Citation{pageLocation=$pageLocation}"
                                    contentBlockLocation != null ->
                                        "Citation{contentBlockLocation=$contentBlockLocation}"
                                    _json != null -> "Citation{_unknown=$_json}"
                                    else -> throw IllegalStateException("Invalid Citation")
                                }

                            companion object {

                                fun ofCharLocation(charLocation: CharLocation) =
                                    Citation(charLocation = charLocation)

                                fun ofPageLocation(pageLocation: PageLocation) =
                                    Citation(pageLocation = pageLocation)

                                fun ofContentBlockLocation(
                                    contentBlockLocation: ContentBlockLocation
                                ) = Citation(contentBlockLocation = contentBlockLocation)
                            }

                            /**
                             * An interface that defines how to map each variant of [Citation] to a
                             * value of type [T].
                             */
                            interface Visitor<out T> {

                                fun visitCharLocation(charLocation: CharLocation): T

                                fun visitPageLocation(pageLocation: PageLocation): T

                                fun visitContentBlockLocation(
                                    contentBlockLocation: ContentBlockLocation
                                ): T

                                /**
                                 * Maps an unknown variant of [Citation] to a value of type [T].
                                 *
                                 * An instance of [Citation] can contain an unknown variant if it
                                 * was deserialized from data that doesn't match any known variant.
                                 * For example, if the SDK is on an older version than the API, then
                                 * the API may respond with new variants that the SDK is unaware of.
                                 *
                                 * @throws SamInvalidDataException in the default implementation.
                                 */
                                fun unknown(json: JsonValue?): T {
                                    throw SamInvalidDataException("Unknown Citation: $json")
                                }
                            }

                            internal class Deserializer :
                                BaseDeserializer<Citation>(Citation::class) {

                                override fun ObjectCodec.deserialize(node: JsonNode): Citation {
                                    val json = JsonValue.fromJsonNode(node)
                                    val type = json.asObject()?.get("type")?.asString()

                                    when (type) {
                                        "char_location" -> {
                                            return tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<CharLocation>(),
                                                )
                                                ?.let { Citation(charLocation = it, _json = json) }
                                                ?: Citation(_json = json)
                                        }
                                        "page_location" -> {
                                            return tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<PageLocation>(),
                                                )
                                                ?.let { Citation(pageLocation = it, _json = json) }
                                                ?: Citation(_json = json)
                                        }
                                        "content_block_location" -> {
                                            return tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<ContentBlockLocation>(),
                                                )
                                                ?.let {
                                                    Citation(
                                                        contentBlockLocation = it,
                                                        _json = json,
                                                    )
                                                } ?: Citation(_json = json)
                                        }
                                    }

                                    return Citation(_json = json)
                                }
                            }

                            internal class Serializer : BaseSerializer<Citation>(Citation::class) {

                                override fun serialize(
                                    value: Citation,
                                    generator: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    when {
                                        value.charLocation != null ->
                                            generator.writeObject(value.charLocation)
                                        value.pageLocation != null ->
                                            generator.writeObject(value.pageLocation)
                                        value.contentBlockLocation != null ->
                                            generator.writeObject(value.contentBlockLocation)
                                        value._json != null -> generator.writeObject(value._json)
                                        else -> throw IllegalStateException("Invalid Citation")
                                    }
                                }
                            }

                            class CharLocation
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val citedText: JsonField<String>,
                                private val documentIndex: JsonField<Long>,
                                private val documentTitle: JsonField<String>,
                                private val endCharIndex: JsonField<Long>,
                                private val startCharIndex: JsonField<Long>,
                                private val type: JsonValue,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("cited_text")
                                    @ExcludeMissing
                                    citedText: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("document_index")
                                    @ExcludeMissing
                                    documentIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("document_title")
                                    @ExcludeMissing
                                    documentTitle: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("end_char_index")
                                    @ExcludeMissing
                                    endCharIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("start_char_index")
                                    @ExcludeMissing
                                    startCharIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("type")
                                    @ExcludeMissing
                                    type: JsonValue = JsonMissing.of(),
                                ) : this(
                                    citedText,
                                    documentIndex,
                                    documentTitle,
                                    endCharIndex,
                                    startCharIndex,
                                    type,
                                    mutableMapOf(),
                                )

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun citedText(): String = citedText.getRequired("cited_text")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun documentIndex(): Long =
                                    documentIndex.getRequired("document_index")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type (e.g. if the server responded with an
                                 *   unexpected value).
                                 */
                                fun documentTitle(): String? =
                                    documentTitle.getNullable("document_title")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun endCharIndex(): Long =
                                    endCharIndex.getRequired("end_char_index")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun startCharIndex(): Long =
                                    startCharIndex.getRequired("start_char_index")

                                /**
                                 * Expected to always return the following:
                                 * ```kotlin
                                 * JsonValue.from("char_location")
                                 * ```
                                 *
                                 * However, this method can be useful for debugging and logging
                                 * (e.g. if the server responded with an unexpected value).
                                 */
                                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                                /**
                                 * Returns the raw JSON value of [citedText].
                                 *
                                 * Unlike [citedText], this method doesn't throw if the JSON field
                                 * has an unexpected type.
                                 */
                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                fun _citedText(): JsonField<String> = citedText

                                /**
                                 * Returns the raw JSON value of [documentIndex].
                                 *
                                 * Unlike [documentIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("document_index")
                                @ExcludeMissing
                                fun _documentIndex(): JsonField<Long> = documentIndex

                                /**
                                 * Returns the raw JSON value of [documentTitle].
                                 *
                                 * Unlike [documentTitle], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("document_title")
                                @ExcludeMissing
                                fun _documentTitle(): JsonField<String> = documentTitle

                                /**
                                 * Returns the raw JSON value of [endCharIndex].
                                 *
                                 * Unlike [endCharIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("end_char_index")
                                @ExcludeMissing
                                fun _endCharIndex(): JsonField<Long> = endCharIndex

                                /**
                                 * Returns the raw JSON value of [startCharIndex].
                                 *
                                 * Unlike [startCharIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("start_char_index")
                                @ExcludeMissing
                                fun _startCharIndex(): JsonField<Long> = startCharIndex

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
                                     * Returns a mutable builder for constructing an instance of
                                     * [CharLocation].
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endCharIndex()
                                     * .startCharIndex()
                                     * ```
                                     */
                                    fun builder() = Builder()
                                }

                                /** A builder for [CharLocation]. */
                                class Builder internal constructor() {

                                    private var citedText: JsonField<String>? = null
                                    private var documentIndex: JsonField<Long>? = null
                                    private var documentTitle: JsonField<String>? = null
                                    private var endCharIndex: JsonField<Long>? = null
                                    private var startCharIndex: JsonField<Long>? = null
                                    private var type: JsonValue = JsonValue.from("char_location")
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(charLocation: CharLocation) = apply {
                                        citedText = charLocation.citedText
                                        documentIndex = charLocation.documentIndex
                                        documentTitle = charLocation.documentTitle
                                        endCharIndex = charLocation.endCharIndex
                                        startCharIndex = charLocation.startCharIndex
                                        type = charLocation.type
                                        additionalProperties =
                                            charLocation.additionalProperties.toMutableMap()
                                    }

                                    fun citedText(citedText: String) =
                                        citedText(JsonField.of(citedText))

                                    /**
                                     * Sets [Builder.citedText] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.citedText] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun citedText(citedText: JsonField<String>) = apply {
                                        this.citedText = citedText
                                    }

                                    fun documentIndex(documentIndex: Long) =
                                        documentIndex(JsonField.of(documentIndex))

                                    /**
                                     * Sets [Builder.documentIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.documentIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun documentIndex(documentIndex: JsonField<Long>) = apply {
                                        this.documentIndex = documentIndex
                                    }

                                    fun documentTitle(documentTitle: String?) =
                                        documentTitle(JsonField.ofNullable(documentTitle))

                                    /**
                                     * Sets [Builder.documentTitle] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.documentTitle] with a
                                     * well-typed [String] value instead. This method is primarily
                                     * for setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun documentTitle(documentTitle: JsonField<String>) = apply {
                                        this.documentTitle = documentTitle
                                    }

                                    fun endCharIndex(endCharIndex: Long) =
                                        endCharIndex(JsonField.of(endCharIndex))

                                    /**
                                     * Sets [Builder.endCharIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.endCharIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun endCharIndex(endCharIndex: JsonField<Long>) = apply {
                                        this.endCharIndex = endCharIndex
                                    }

                                    fun startCharIndex(startCharIndex: Long) =
                                        startCharIndex(JsonField.of(startCharIndex))

                                    /**
                                     * Sets [Builder.startCharIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.startCharIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun startCharIndex(startCharIndex: JsonField<Long>) = apply {
                                        this.startCharIndex = startCharIndex
                                    }

                                    /**
                                     * Sets the field to an arbitrary JSON value.
                                     *
                                     * It is usually unnecessary to call this method because the
                                     * field defaults to the following:
                                     * ```kotlin
                                     * JsonValue.from("char_location")
                                     * ```
                                     *
                                     * This method is primarily for setting the field to an
                                     * undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonValue) = apply { this.type = type }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [CharLocation].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endCharIndex()
                                     * .startCharIndex()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): CharLocation =
                                        CharLocation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endCharIndex", endCharIndex),
                                            checkRequired("startCharIndex", startCharIndex),
                                            type,
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): CharLocation = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    citedText()
                                    documentIndex()
                                    documentTitle()
                                    endCharIndex()
                                    startCharIndex()
                                    _type().let {
                                        if (it != JsonValue.from("char_location")) {
                                            throw SamInvalidDataException(
                                                "'type' is invalid, received $it"
                                            )
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                internal fun validity(): Int =
                                    (if (citedText.asKnown() == null) 0 else 1) +
                                        (if (documentIndex.asKnown() == null) 0 else 1) +
                                        (if (documentTitle.asKnown() == null) 0 else 1) +
                                        (if (endCharIndex.asKnown() == null) 0 else 1) +
                                        (if (startCharIndex.asKnown() == null) 0 else 1) +
                                        type.let {
                                            if (it == JsonValue.from("char_location")) 1 else 0
                                        }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is CharLocation &&
                                        citedText == other.citedText &&
                                        documentIndex == other.documentIndex &&
                                        documentTitle == other.documentTitle &&
                                        endCharIndex == other.endCharIndex &&
                                        startCharIndex == other.startCharIndex &&
                                        type == other.type &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(
                                        citedText,
                                        documentIndex,
                                        documentTitle,
                                        endCharIndex,
                                        startCharIndex,
                                        type,
                                        additionalProperties,
                                    )
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "CharLocation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endCharIndex=$endCharIndex, startCharIndex=$startCharIndex, type=$type, additionalProperties=$additionalProperties}"
                            }

                            class PageLocation
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val citedText: JsonField<String>,
                                private val documentIndex: JsonField<Long>,
                                private val documentTitle: JsonField<String>,
                                private val endPageNumber: JsonField<Long>,
                                private val startPageNumber: JsonField<Long>,
                                private val type: JsonValue,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("cited_text")
                                    @ExcludeMissing
                                    citedText: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("document_index")
                                    @ExcludeMissing
                                    documentIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("document_title")
                                    @ExcludeMissing
                                    documentTitle: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("end_page_number")
                                    @ExcludeMissing
                                    endPageNumber: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("start_page_number")
                                    @ExcludeMissing
                                    startPageNumber: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("type")
                                    @ExcludeMissing
                                    type: JsonValue = JsonMissing.of(),
                                ) : this(
                                    citedText,
                                    documentIndex,
                                    documentTitle,
                                    endPageNumber,
                                    startPageNumber,
                                    type,
                                    mutableMapOf(),
                                )

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun citedText(): String = citedText.getRequired("cited_text")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun documentIndex(): Long =
                                    documentIndex.getRequired("document_index")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type (e.g. if the server responded with an
                                 *   unexpected value).
                                 */
                                fun documentTitle(): String? =
                                    documentTitle.getNullable("document_title")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun endPageNumber(): Long =
                                    endPageNumber.getRequired("end_page_number")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun startPageNumber(): Long =
                                    startPageNumber.getRequired("start_page_number")

                                /**
                                 * Expected to always return the following:
                                 * ```kotlin
                                 * JsonValue.from("page_location")
                                 * ```
                                 *
                                 * However, this method can be useful for debugging and logging
                                 * (e.g. if the server responded with an unexpected value).
                                 */
                                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                                /**
                                 * Returns the raw JSON value of [citedText].
                                 *
                                 * Unlike [citedText], this method doesn't throw if the JSON field
                                 * has an unexpected type.
                                 */
                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                fun _citedText(): JsonField<String> = citedText

                                /**
                                 * Returns the raw JSON value of [documentIndex].
                                 *
                                 * Unlike [documentIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("document_index")
                                @ExcludeMissing
                                fun _documentIndex(): JsonField<Long> = documentIndex

                                /**
                                 * Returns the raw JSON value of [documentTitle].
                                 *
                                 * Unlike [documentTitle], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("document_title")
                                @ExcludeMissing
                                fun _documentTitle(): JsonField<String> = documentTitle

                                /**
                                 * Returns the raw JSON value of [endPageNumber].
                                 *
                                 * Unlike [endPageNumber], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("end_page_number")
                                @ExcludeMissing
                                fun _endPageNumber(): JsonField<Long> = endPageNumber

                                /**
                                 * Returns the raw JSON value of [startPageNumber].
                                 *
                                 * Unlike [startPageNumber], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("start_page_number")
                                @ExcludeMissing
                                fun _startPageNumber(): JsonField<Long> = startPageNumber

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
                                     * Returns a mutable builder for constructing an instance of
                                     * [PageLocation].
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endPageNumber()
                                     * .startPageNumber()
                                     * ```
                                     */
                                    fun builder() = Builder()
                                }

                                /** A builder for [PageLocation]. */
                                class Builder internal constructor() {

                                    private var citedText: JsonField<String>? = null
                                    private var documentIndex: JsonField<Long>? = null
                                    private var documentTitle: JsonField<String>? = null
                                    private var endPageNumber: JsonField<Long>? = null
                                    private var startPageNumber: JsonField<Long>? = null
                                    private var type: JsonValue = JsonValue.from("page_location")
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(pageLocation: PageLocation) = apply {
                                        citedText = pageLocation.citedText
                                        documentIndex = pageLocation.documentIndex
                                        documentTitle = pageLocation.documentTitle
                                        endPageNumber = pageLocation.endPageNumber
                                        startPageNumber = pageLocation.startPageNumber
                                        type = pageLocation.type
                                        additionalProperties =
                                            pageLocation.additionalProperties.toMutableMap()
                                    }

                                    fun citedText(citedText: String) =
                                        citedText(JsonField.of(citedText))

                                    /**
                                     * Sets [Builder.citedText] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.citedText] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun citedText(citedText: JsonField<String>) = apply {
                                        this.citedText = citedText
                                    }

                                    fun documentIndex(documentIndex: Long) =
                                        documentIndex(JsonField.of(documentIndex))

                                    /**
                                     * Sets [Builder.documentIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.documentIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun documentIndex(documentIndex: JsonField<Long>) = apply {
                                        this.documentIndex = documentIndex
                                    }

                                    fun documentTitle(documentTitle: String?) =
                                        documentTitle(JsonField.ofNullable(documentTitle))

                                    /**
                                     * Sets [Builder.documentTitle] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.documentTitle] with a
                                     * well-typed [String] value instead. This method is primarily
                                     * for setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun documentTitle(documentTitle: JsonField<String>) = apply {
                                        this.documentTitle = documentTitle
                                    }

                                    fun endPageNumber(endPageNumber: Long) =
                                        endPageNumber(JsonField.of(endPageNumber))

                                    /**
                                     * Sets [Builder.endPageNumber] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.endPageNumber] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun endPageNumber(endPageNumber: JsonField<Long>) = apply {
                                        this.endPageNumber = endPageNumber
                                    }

                                    fun startPageNumber(startPageNumber: Long) =
                                        startPageNumber(JsonField.of(startPageNumber))

                                    /**
                                     * Sets [Builder.startPageNumber] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.startPageNumber] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun startPageNumber(startPageNumber: JsonField<Long>) = apply {
                                        this.startPageNumber = startPageNumber
                                    }

                                    /**
                                     * Sets the field to an arbitrary JSON value.
                                     *
                                     * It is usually unnecessary to call this method because the
                                     * field defaults to the following:
                                     * ```kotlin
                                     * JsonValue.from("page_location")
                                     * ```
                                     *
                                     * This method is primarily for setting the field to an
                                     * undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonValue) = apply { this.type = type }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [PageLocation].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endPageNumber()
                                     * .startPageNumber()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): PageLocation =
                                        PageLocation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endPageNumber", endPageNumber),
                                            checkRequired("startPageNumber", startPageNumber),
                                            type,
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): PageLocation = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    citedText()
                                    documentIndex()
                                    documentTitle()
                                    endPageNumber()
                                    startPageNumber()
                                    _type().let {
                                        if (it != JsonValue.from("page_location")) {
                                            throw SamInvalidDataException(
                                                "'type' is invalid, received $it"
                                            )
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                internal fun validity(): Int =
                                    (if (citedText.asKnown() == null) 0 else 1) +
                                        (if (documentIndex.asKnown() == null) 0 else 1) +
                                        (if (documentTitle.asKnown() == null) 0 else 1) +
                                        (if (endPageNumber.asKnown() == null) 0 else 1) +
                                        (if (startPageNumber.asKnown() == null) 0 else 1) +
                                        type.let {
                                            if (it == JsonValue.from("page_location")) 1 else 0
                                        }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is PageLocation &&
                                        citedText == other.citedText &&
                                        documentIndex == other.documentIndex &&
                                        documentTitle == other.documentTitle &&
                                        endPageNumber == other.endPageNumber &&
                                        startPageNumber == other.startPageNumber &&
                                        type == other.type &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(
                                        citedText,
                                        documentIndex,
                                        documentTitle,
                                        endPageNumber,
                                        startPageNumber,
                                        type,
                                        additionalProperties,
                                    )
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "PageLocation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endPageNumber=$endPageNumber, startPageNumber=$startPageNumber, type=$type, additionalProperties=$additionalProperties}"
                            }

                            class ContentBlockLocation
                            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                            private constructor(
                                private val citedText: JsonField<String>,
                                private val documentIndex: JsonField<Long>,
                                private val documentTitle: JsonField<String>,
                                private val endBlockIndex: JsonField<Long>,
                                private val startBlockIndex: JsonField<Long>,
                                private val type: JsonValue,
                                private val additionalProperties: MutableMap<String, JsonValue>,
                            ) {

                                @JsonCreator
                                private constructor(
                                    @JsonProperty("cited_text")
                                    @ExcludeMissing
                                    citedText: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("document_index")
                                    @ExcludeMissing
                                    documentIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("document_title")
                                    @ExcludeMissing
                                    documentTitle: JsonField<String> = JsonMissing.of(),
                                    @JsonProperty("end_block_index")
                                    @ExcludeMissing
                                    endBlockIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("start_block_index")
                                    @ExcludeMissing
                                    startBlockIndex: JsonField<Long> = JsonMissing.of(),
                                    @JsonProperty("type")
                                    @ExcludeMissing
                                    type: JsonValue = JsonMissing.of(),
                                ) : this(
                                    citedText,
                                    documentIndex,
                                    documentTitle,
                                    endBlockIndex,
                                    startBlockIndex,
                                    type,
                                    mutableMapOf(),
                                )

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun citedText(): String = citedText.getRequired("cited_text")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun documentIndex(): Long =
                                    documentIndex.getRequired("document_index")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type (e.g. if the server responded with an
                                 *   unexpected value).
                                 */
                                fun documentTitle(): String? =
                                    documentTitle.getNullable("document_title")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun endBlockIndex(): Long =
                                    endBlockIndex.getRequired("end_block_index")

                                /**
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun startBlockIndex(): Long =
                                    startBlockIndex.getRequired("start_block_index")

                                /**
                                 * Expected to always return the following:
                                 * ```kotlin
                                 * JsonValue.from("content_block_location")
                                 * ```
                                 *
                                 * However, this method can be useful for debugging and logging
                                 * (e.g. if the server responded with an unexpected value).
                                 */
                                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                                /**
                                 * Returns the raw JSON value of [citedText].
                                 *
                                 * Unlike [citedText], this method doesn't throw if the JSON field
                                 * has an unexpected type.
                                 */
                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                fun _citedText(): JsonField<String> = citedText

                                /**
                                 * Returns the raw JSON value of [documentIndex].
                                 *
                                 * Unlike [documentIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("document_index")
                                @ExcludeMissing
                                fun _documentIndex(): JsonField<Long> = documentIndex

                                /**
                                 * Returns the raw JSON value of [documentTitle].
                                 *
                                 * Unlike [documentTitle], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("document_title")
                                @ExcludeMissing
                                fun _documentTitle(): JsonField<String> = documentTitle

                                /**
                                 * Returns the raw JSON value of [endBlockIndex].
                                 *
                                 * Unlike [endBlockIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("end_block_index")
                                @ExcludeMissing
                                fun _endBlockIndex(): JsonField<Long> = endBlockIndex

                                /**
                                 * Returns the raw JSON value of [startBlockIndex].
                                 *
                                 * Unlike [startBlockIndex], this method doesn't throw if the JSON
                                 * field has an unexpected type.
                                 */
                                @JsonProperty("start_block_index")
                                @ExcludeMissing
                                fun _startBlockIndex(): JsonField<Long> = startBlockIndex

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
                                     * Returns a mutable builder for constructing an instance of
                                     * [ContentBlockLocation].
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endBlockIndex()
                                     * .startBlockIndex()
                                     * ```
                                     */
                                    fun builder() = Builder()
                                }

                                /** A builder for [ContentBlockLocation]. */
                                class Builder internal constructor() {

                                    private var citedText: JsonField<String>? = null
                                    private var documentIndex: JsonField<Long>? = null
                                    private var documentTitle: JsonField<String>? = null
                                    private var endBlockIndex: JsonField<Long>? = null
                                    private var startBlockIndex: JsonField<Long>? = null
                                    private var type: JsonValue =
                                        JsonValue.from("content_block_location")
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(contentBlockLocation: ContentBlockLocation) =
                                        apply {
                                            citedText = contentBlockLocation.citedText
                                            documentIndex = contentBlockLocation.documentIndex
                                            documentTitle = contentBlockLocation.documentTitle
                                            endBlockIndex = contentBlockLocation.endBlockIndex
                                            startBlockIndex = contentBlockLocation.startBlockIndex
                                            type = contentBlockLocation.type
                                            additionalProperties =
                                                contentBlockLocation.additionalProperties
                                                    .toMutableMap()
                                        }

                                    fun citedText(citedText: String) =
                                        citedText(JsonField.of(citedText))

                                    /**
                                     * Sets [Builder.citedText] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.citedText] with a well-typed
                                     * [String] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun citedText(citedText: JsonField<String>) = apply {
                                        this.citedText = citedText
                                    }

                                    fun documentIndex(documentIndex: Long) =
                                        documentIndex(JsonField.of(documentIndex))

                                    /**
                                     * Sets [Builder.documentIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.documentIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun documentIndex(documentIndex: JsonField<Long>) = apply {
                                        this.documentIndex = documentIndex
                                    }

                                    fun documentTitle(documentTitle: String?) =
                                        documentTitle(JsonField.ofNullable(documentTitle))

                                    /**
                                     * Sets [Builder.documentTitle] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.documentTitle] with a
                                     * well-typed [String] value instead. This method is primarily
                                     * for setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun documentTitle(documentTitle: JsonField<String>) = apply {
                                        this.documentTitle = documentTitle
                                    }

                                    fun endBlockIndex(endBlockIndex: Long) =
                                        endBlockIndex(JsonField.of(endBlockIndex))

                                    /**
                                     * Sets [Builder.endBlockIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.endBlockIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun endBlockIndex(endBlockIndex: JsonField<Long>) = apply {
                                        this.endBlockIndex = endBlockIndex
                                    }

                                    fun startBlockIndex(startBlockIndex: Long) =
                                        startBlockIndex(JsonField.of(startBlockIndex))

                                    /**
                                     * Sets [Builder.startBlockIndex] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.startBlockIndex] with a
                                     * well-typed [Long] value instead. This method is primarily for
                                     * setting the field to an undocumented or not yet supported
                                     * value.
                                     */
                                    fun startBlockIndex(startBlockIndex: JsonField<Long>) = apply {
                                        this.startBlockIndex = startBlockIndex
                                    }

                                    /**
                                     * Sets the field to an arbitrary JSON value.
                                     *
                                     * It is usually unnecessary to call this method because the
                                     * field defaults to the following:
                                     * ```kotlin
                                     * JsonValue.from("content_block_location")
                                     * ```
                                     *
                                     * This method is primarily for setting the field to an
                                     * undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonValue) = apply { this.type = type }

                                    fun additionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.clear()
                                        putAllAdditionalProperties(additionalProperties)
                                    }

                                    fun putAdditionalProperty(key: String, value: JsonValue) =
                                        apply {
                                            additionalProperties.put(key, value)
                                        }

                                    fun putAllAdditionalProperties(
                                        additionalProperties: Map<String, JsonValue>
                                    ) = apply {
                                        this.additionalProperties.putAll(additionalProperties)
                                    }

                                    fun removeAdditionalProperty(key: String) = apply {
                                        additionalProperties.remove(key)
                                    }

                                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                        keys.forEach(::removeAdditionalProperty)
                                    }

                                    /**
                                     * Returns an immutable instance of [ContentBlockLocation].
                                     *
                                     * Further updates to this [Builder] will not mutate the
                                     * returned instance.
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endBlockIndex()
                                     * .startBlockIndex()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): ContentBlockLocation =
                                        ContentBlockLocation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endBlockIndex", endBlockIndex),
                                            checkRequired("startBlockIndex", startBlockIndex),
                                            type,
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): ContentBlockLocation = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    citedText()
                                    documentIndex()
                                    documentTitle()
                                    endBlockIndex()
                                    startBlockIndex()
                                    _type().let {
                                        if (it != JsonValue.from("content_block_location")) {
                                            throw SamInvalidDataException(
                                                "'type' is invalid, received $it"
                                            )
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
                                 * Returns a score indicating how many valid values are contained in
                                 * this object recursively.
                                 *
                                 * Used for best match union deserialization.
                                 */
                                internal fun validity(): Int =
                                    (if (citedText.asKnown() == null) 0 else 1) +
                                        (if (documentIndex.asKnown() == null) 0 else 1) +
                                        (if (documentTitle.asKnown() == null) 0 else 1) +
                                        (if (endBlockIndex.asKnown() == null) 0 else 1) +
                                        (if (startBlockIndex.asKnown() == null) 0 else 1) +
                                        type.let {
                                            if (it == JsonValue.from("content_block_location")) 1
                                            else 0
                                        }

                                override fun equals(other: Any?): Boolean {
                                    if (this === other) {
                                        return true
                                    }

                                    return other is ContentBlockLocation &&
                                        citedText == other.citedText &&
                                        documentIndex == other.documentIndex &&
                                        documentTitle == other.documentTitle &&
                                        endBlockIndex == other.endBlockIndex &&
                                        startBlockIndex == other.startBlockIndex &&
                                        type == other.type &&
                                        additionalProperties == other.additionalProperties
                                }

                                private val hashCode: Int by lazy {
                                    Objects.hash(
                                        citedText,
                                        documentIndex,
                                        documentTitle,
                                        endBlockIndex,
                                        startBlockIndex,
                                        type,
                                        additionalProperties,
                                    )
                                }

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "ContentBlockLocation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endBlockIndex=$endBlockIndex, startBlockIndex=$startBlockIndex, type=$type, additionalProperties=$additionalProperties}"
                            }
                        }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Text &&
                                citations == other.citations &&
                                text == other.text &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(citations, text, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Text{citations=$citations, text=$text, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class ToolUse
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val id: JsonField<String>,
                        private val input: JsonValue,
                        private val name: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("id")
                            @ExcludeMissing
                            id: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("input")
                            @ExcludeMissing
                            input: JsonValue = JsonMissing.of(),
                            @JsonProperty("name")
                            @ExcludeMissing
                            name: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(id, input, name, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun id(): String = id.getRequired("id")

                        @JsonProperty("input") @ExcludeMissing fun _input(): JsonValue = input

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun name(): String = name.getRequired("name")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("tool_use")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [id].
                         *
                         * Unlike [id], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                        /**
                         * Returns the raw JSON value of [name].
                         *
                         * Unlike [name], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                             * Returns a mutable builder for constructing an instance of [ToolUse].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .id()
                             * .input()
                             * .name()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ToolUse]. */
                        class Builder internal constructor() {

                            private var id: JsonField<String>? = null
                            private var input: JsonValue? = null
                            private var name: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("tool_use")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(toolUse: ToolUse) = apply {
                                id = toolUse.id
                                input = toolUse.input
                                name = toolUse.name
                                type = toolUse.type
                                additionalProperties = toolUse.additionalProperties.toMutableMap()
                            }

                            fun id(id: String) = id(JsonField.of(id))

                            /**
                             * Sets [Builder.id] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.id] with a well-typed [String] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun id(id: JsonField<String>) = apply { this.id = id }

                            fun input(input: JsonValue) = apply { this.input = input }

                            fun name(name: String) = name(JsonField.of(name))

                            /**
                             * Sets [Builder.name] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.name] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun name(name: JsonField<String>) = apply { this.name = name }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("tool_use")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [ToolUse].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .id()
                             * .input()
                             * .name()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ToolUse =
                                ToolUse(
                                    checkRequired("id", id),
                                    checkRequired("input", input),
                                    checkRequired("name", name),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ToolUse = apply {
                            if (validated) {
                                return@apply
                            }

                            id()
                            name()
                            _type().let {
                                if (it != JsonValue.from("tool_use")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (id.asKnown() == null) 0 else 1) +
                                (if (name.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("tool_use")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is ToolUse &&
                                id == other.id &&
                                input == other.input &&
                                name == other.name &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(id, input, name, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ToolUse{id=$id, input=$input, name=$name, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class Thinking
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val signature: JsonField<String>,
                        private val thinking: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("signature")
                            @ExcludeMissing
                            signature: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("thinking")
                            @ExcludeMissing
                            thinking: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(signature, thinking, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun signature(): String = signature.getRequired("signature")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun thinking(): String = thinking.getRequired("thinking")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("thinking")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [signature].
                         *
                         * Unlike [signature], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("signature")
                        @ExcludeMissing
                        fun _signature(): JsonField<String> = signature

                        /**
                         * Returns the raw JSON value of [thinking].
                         *
                         * Unlike [thinking], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("thinking")
                        @ExcludeMissing
                        fun _thinking(): JsonField<String> = thinking

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
                             * Returns a mutable builder for constructing an instance of [Thinking].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .signature()
                             * .thinking()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [Thinking]. */
                        class Builder internal constructor() {

                            private var signature: JsonField<String>? = null
                            private var thinking: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("thinking")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(thinking: Thinking) = apply {
                                signature = thinking.signature
                                this.thinking = thinking.thinking
                                type = thinking.type
                                additionalProperties = thinking.additionalProperties.toMutableMap()
                            }

                            fun signature(signature: String) = signature(JsonField.of(signature))

                            /**
                             * Sets [Builder.signature] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.signature] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun signature(signature: JsonField<String>) = apply {
                                this.signature = signature
                            }

                            fun thinking(thinking: String) = thinking(JsonField.of(thinking))

                            /**
                             * Sets [Builder.thinking] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.thinking] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun thinking(thinking: JsonField<String>) = apply {
                                this.thinking = thinking
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("thinking")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Thinking].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .signature()
                             * .thinking()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Thinking =
                                Thinking(
                                    checkRequired("signature", signature),
                                    checkRequired("thinking", thinking),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Thinking = apply {
                            if (validated) {
                                return@apply
                            }

                            signature()
                            thinking()
                            _type().let {
                                if (it != JsonValue.from("thinking")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (signature.asKnown() == null) 0 else 1) +
                                (if (thinking.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("thinking")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Thinking &&
                                signature == other.signature &&
                                thinking == other.thinking &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(signature, thinking, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Thinking{signature=$signature, thinking=$thinking, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class RedactedThinking
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val data: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("data")
                            @ExcludeMissing
                            data: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(data, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun data(): String = data.getRequired("data")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("redacted_thinking")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [data].
                         *
                         * Unlike [data], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

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
                             * Returns a mutable builder for constructing an instance of
                             * [RedactedThinking].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .data()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [RedactedThinking]. */
                        class Builder internal constructor() {

                            private var data: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("redacted_thinking")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(redactedThinking: RedactedThinking) = apply {
                                data = redactedThinking.data
                                type = redactedThinking.type
                                additionalProperties =
                                    redactedThinking.additionalProperties.toMutableMap()
                            }

                            fun data(data: String) = data(JsonField.of(data))

                            /**
                             * Sets [Builder.data] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.data] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun data(data: JsonField<String>) = apply { this.data = data }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("redacted_thinking")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [RedactedThinking].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .data()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): RedactedThinking =
                                RedactedThinking(
                                    checkRequired("data", data),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): RedactedThinking = apply {
                            if (validated) {
                                return@apply
                            }

                            data()
                            _type().let {
                                if (it != JsonValue.from("redacted_thinking")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (data.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("redacted_thinking")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is RedactedThinking &&
                                data == other.data &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(data, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "RedactedThinking{data=$data, type=$type, additionalProperties=$additionalProperties}"
                    }
                }

                /**
                 * The reason that we stopped.
                 *
                 * This may be one the following values:
                 * * `"end_turn"`: the model reached a natural stopping point
                 * * `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
                 * * `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
                 * * `"tool_use"`: the model invoked one or more tools
                 *
                 * In non-streaming mode this value is always non-null. In streaming mode, it is
                 * null in the `message_start` event and non-null otherwise.
                 */
                class StopReason
                @JsonCreator
                private constructor(private val value: JsonField<String>) : Enum {

                    /**
                     * Returns this class instance's raw value.
                     *
                     * This is usually only useful if this instance was deserialized from data that
                     * doesn't match any known member, and you want to know that value. For example,
                     * if the SDK is on an older version than the API, then the API may respond with
                     * new members that the SDK is unaware of.
                     */
                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    companion object {

                        val END_TURN = of("end_turn")

                        val MAX_TOKENS = of("max_tokens")

                        val STOP_SEQUENCE = of("stop_sequence")

                        val TOOL_USE = of("tool_use")

                        fun of(value: String) = StopReason(JsonField.of(value))
                    }

                    /** An enum containing [StopReason]'s known values. */
                    enum class Known {
                        END_TURN,
                        MAX_TOKENS,
                        STOP_SEQUENCE,
                        TOOL_USE,
                    }

                    /**
                     * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN]
                     * member.
                     *
                     * An instance of [StopReason] can contain an unknown value in a couple of
                     * cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        END_TURN,
                        MAX_TOKENS,
                        STOP_SEQUENCE,
                        TOOL_USE,
                        /**
                         * An enum member indicating that [StopReason] was instantiated with an
                         * unknown value.
                         */
                        _UNKNOWN,
                    }

                    /**
                     * Returns an enum member corresponding to this class instance's value, or
                     * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                     *
                     * Use the [known] method instead if you're certain the value is always known or
                     * if you want to throw for the unknown case.
                     */
                    fun value(): Value =
                        when (this) {
                            END_TURN -> Value.END_TURN
                            MAX_TOKENS -> Value.MAX_TOKENS
                            STOP_SEQUENCE -> Value.STOP_SEQUENCE
                            TOOL_USE -> Value.TOOL_USE
                            else -> Value._UNKNOWN
                        }

                    /**
                     * Returns an enum member corresponding to this class instance's value.
                     *
                     * Use the [value] method instead if you're uncertain the value is always known
                     * and don't want to throw for the unknown case.
                     *
                     * @throws SamInvalidDataException if this class instance's value is a not a
                     *   known member.
                     */
                    fun known(): Known =
                        when (this) {
                            END_TURN -> Known.END_TURN
                            MAX_TOKENS -> Known.MAX_TOKENS
                            STOP_SEQUENCE -> Known.STOP_SEQUENCE
                            TOOL_USE -> Known.TOOL_USE
                            else -> throw SamInvalidDataException("Unknown StopReason: $value")
                        }

                    /**
                     * Returns this class instance's primitive wire representation.
                     *
                     * This differs from the [toString] method because that method is primarily for
                     * debugging and generally doesn't throw.
                     *
                     * @throws SamInvalidDataException if this class instance's value does not have
                     *   the expected primitive type.
                     */
                    fun asString(): String =
                        _value().asString()
                            ?: throw SamInvalidDataException("Value is not a String")

                    private var validated: Boolean = false

                    fun validate(): StopReason = apply {
                        if (validated) {
                            return@apply
                        }

                        known()
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is StopReason && value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /**
                 * Billing and rate-limit usage.
                 *
                 * Anthropic's API bills and rate-limits by token counts, as tokens represent the
                 * underlying cost to our systems.
                 *
                 * Under the hood, the API transforms requests into a format suitable for the model.
                 * The model's output then goes through a parsing stage before becoming an API
                 * response. As a result, the token counts in `usage` will not match one-to-one with
                 * the exact visible content of an API request or response.
                 *
                 * For example, `output_tokens` will be non-zero, even for an empty string response
                 * from Claude.
                 *
                 * Total input tokens in a request is the summation of `input_tokens`,
                 * `cache_creation_input_tokens`, and `cache_read_input_tokens`.
                 */
                class Usage
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val cacheCreationInputTokens: JsonField<Long>,
                    private val cacheReadInputTokens: JsonField<Long>,
                    private val inputTokens: JsonField<Long>,
                    private val outputTokens: JsonField<Long>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("cache_creation_input_tokens")
                        @ExcludeMissing
                        cacheCreationInputTokens: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("cache_read_input_tokens")
                        @ExcludeMissing
                        cacheReadInputTokens: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("input_tokens")
                        @ExcludeMissing
                        inputTokens: JsonField<Long> = JsonMissing.of(),
                        @JsonProperty("output_tokens")
                        @ExcludeMissing
                        outputTokens: JsonField<Long> = JsonMissing.of(),
                    ) : this(
                        cacheCreationInputTokens,
                        cacheReadInputTokens,
                        inputTokens,
                        outputTokens,
                        mutableMapOf(),
                    )

                    /**
                     * The number of input tokens used to create the cache entry.
                     *
                     * @throws SamInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun cacheCreationInputTokens(): Long? =
                        cacheCreationInputTokens.getNullable("cache_creation_input_tokens")

                    /**
                     * The number of input tokens read from the cache.
                     *
                     * @throws SamInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun cacheReadInputTokens(): Long? =
                        cacheReadInputTokens.getNullable("cache_read_input_tokens")

                    /**
                     * The number of input tokens which were used.
                     *
                     * @throws SamInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

                    /**
                     * The number of output tokens which were used.
                     *
                     * @throws SamInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

                    /**
                     * Returns the raw JSON value of [cacheCreationInputTokens].
                     *
                     * Unlike [cacheCreationInputTokens], this method doesn't throw if the JSON
                     * field has an unexpected type.
                     */
                    @JsonProperty("cache_creation_input_tokens")
                    @ExcludeMissing
                    fun _cacheCreationInputTokens(): JsonField<Long> = cacheCreationInputTokens

                    /**
                     * Returns the raw JSON value of [cacheReadInputTokens].
                     *
                     * Unlike [cacheReadInputTokens], this method doesn't throw if the JSON field
                     * has an unexpected type.
                     */
                    @JsonProperty("cache_read_input_tokens")
                    @ExcludeMissing
                    fun _cacheReadInputTokens(): JsonField<Long> = cacheReadInputTokens

                    /**
                     * Returns the raw JSON value of [inputTokens].
                     *
                     * Unlike [inputTokens], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("input_tokens")
                    @ExcludeMissing
                    fun _inputTokens(): JsonField<Long> = inputTokens

                    /**
                     * Returns the raw JSON value of [outputTokens].
                     *
                     * Unlike [outputTokens], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("output_tokens")
                    @ExcludeMissing
                    fun _outputTokens(): JsonField<Long> = outputTokens

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
                         * Returns a mutable builder for constructing an instance of [Usage].
                         *
                         * The following fields are required:
                         * ```kotlin
                         * .cacheCreationInputTokens()
                         * .cacheReadInputTokens()
                         * .inputTokens()
                         * .outputTokens()
                         * ```
                         */
                        fun builder() = Builder()
                    }

                    /** A builder for [Usage]. */
                    class Builder internal constructor() {

                        private var cacheCreationInputTokens: JsonField<Long>? = null
                        private var cacheReadInputTokens: JsonField<Long>? = null
                        private var inputTokens: JsonField<Long>? = null
                        private var outputTokens: JsonField<Long>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        internal fun from(usage: Usage) = apply {
                            cacheCreationInputTokens = usage.cacheCreationInputTokens
                            cacheReadInputTokens = usage.cacheReadInputTokens
                            inputTokens = usage.inputTokens
                            outputTokens = usage.outputTokens
                            additionalProperties = usage.additionalProperties.toMutableMap()
                        }

                        /** The number of input tokens used to create the cache entry. */
                        fun cacheCreationInputTokens(cacheCreationInputTokens: Long?) =
                            cacheCreationInputTokens(JsonField.ofNullable(cacheCreationInputTokens))

                        /**
                         * Alias for [Builder.cacheCreationInputTokens].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun cacheCreationInputTokens(cacheCreationInputTokens: Long) =
                            cacheCreationInputTokens(cacheCreationInputTokens as Long?)

                        /**
                         * Sets [Builder.cacheCreationInputTokens] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.cacheCreationInputTokens] with a
                         * well-typed [Long] value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun cacheCreationInputTokens(cacheCreationInputTokens: JsonField<Long>) =
                            apply {
                                this.cacheCreationInputTokens = cacheCreationInputTokens
                            }

                        /** The number of input tokens read from the cache. */
                        fun cacheReadInputTokens(cacheReadInputTokens: Long?) =
                            cacheReadInputTokens(JsonField.ofNullable(cacheReadInputTokens))

                        /**
                         * Alias for [Builder.cacheReadInputTokens].
                         *
                         * This unboxed primitive overload exists for backwards compatibility.
                         */
                        fun cacheReadInputTokens(cacheReadInputTokens: Long) =
                            cacheReadInputTokens(cacheReadInputTokens as Long?)

                        /**
                         * Sets [Builder.cacheReadInputTokens] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.cacheReadInputTokens] with a well-typed
                         * [Long] value instead. This method is primarily for setting the field to
                         * an undocumented or not yet supported value.
                         */
                        fun cacheReadInputTokens(cacheReadInputTokens: JsonField<Long>) = apply {
                            this.cacheReadInputTokens = cacheReadInputTokens
                        }

                        /** The number of input tokens which were used. */
                        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                        /**
                         * Sets [Builder.inputTokens] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.inputTokens] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun inputTokens(inputTokens: JsonField<Long>) = apply {
                            this.inputTokens = inputTokens
                        }

                        /** The number of output tokens which were used. */
                        fun outputTokens(outputTokens: Long) =
                            outputTokens(JsonField.of(outputTokens))

                        /**
                         * Sets [Builder.outputTokens] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.outputTokens] with a well-typed [Long]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun outputTokens(outputTokens: JsonField<Long>) = apply {
                            this.outputTokens = outputTokens
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Usage].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```kotlin
                         * .cacheCreationInputTokens()
                         * .cacheReadInputTokens()
                         * .inputTokens()
                         * .outputTokens()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Usage =
                            Usage(
                                checkRequired("cacheCreationInputTokens", cacheCreationInputTokens),
                                checkRequired("cacheReadInputTokens", cacheReadInputTokens),
                                checkRequired("inputTokens", inputTokens),
                                checkRequired("outputTokens", outputTokens),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Usage = apply {
                        if (validated) {
                            return@apply
                        }

                        cacheCreationInputTokens()
                        cacheReadInputTokens()
                        inputTokens()
                        outputTokens()
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    internal fun validity(): Int =
                        (if (cacheCreationInputTokens.asKnown() == null) 0 else 1) +
                            (if (cacheReadInputTokens.asKnown() == null) 0 else 1) +
                            (if (inputTokens.asKnown() == null) 0 else 1) +
                            (if (outputTokens.asKnown() == null) 0 else 1)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Usage &&
                            cacheCreationInputTokens == other.cacheCreationInputTokens &&
                            cacheReadInputTokens == other.cacheReadInputTokens &&
                            inputTokens == other.inputTokens &&
                            outputTokens == other.outputTokens &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            cacheCreationInputTokens,
                            cacheReadInputTokens,
                            inputTokens,
                            outputTokens,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Usage{cacheCreationInputTokens=$cacheCreationInputTokens, cacheReadInputTokens=$cacheReadInputTokens, inputTokens=$inputTokens, outputTokens=$outputTokens, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Message &&
                        id == other.id &&
                        content == other.content &&
                        model == other.model &&
                        role == other.role &&
                        stopReason == other.stopReason &&
                        stopSequence == other.stopSequence &&
                        type == other.type &&
                        usage == other.usage &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        id,
                        content,
                        model,
                        role,
                        stopReason,
                        stopSequence,
                        type,
                        usage,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Message{id=$id, content=$content, model=$model, role=$role, stopReason=$stopReason, stopSequence=$stopSequence, type=$type, usage=$usage, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Succeeded &&
                    message == other.message &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Succeeded{message=$message, type=$type, additionalProperties=$additionalProperties}"
        }

        class Errored
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val error: JsonField<Error>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(error, type, mutableMapOf())

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun error(): Error = error.getRequired("error")

            /**
             * Expected to always return the following:
             * ```kotlin
             * JsonValue.from("errored")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [error].
             *
             * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

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
                 * Returns a mutable builder for constructing an instance of [Errored].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .error()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [Errored]. */
            class Builder internal constructor() {

                private var error: JsonField<Error>? = null
                private var type: JsonValue = JsonValue.from("errored")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(errored: Errored) = apply {
                    error = errored.error
                    type = errored.type
                    additionalProperties = errored.additionalProperties.toMutableMap()
                }

                fun error(error: Error) = error(JsonField.of(error))

                /**
                 * Sets [Builder.error] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.error] with a well-typed [Error] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun error(error: JsonField<Error>) = apply { this.error = error }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```kotlin
                 * JsonValue.from("errored")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Errored].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .error()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Errored =
                    Errored(
                        checkRequired("error", error),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Errored = apply {
                if (validated) {
                    return@apply
                }

                error().validate()
                _type().let {
                    if (it != JsonValue.from("errored")) {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            internal fun validity(): Int =
                (error.asKnown()?.validity() ?: 0) +
                    type.let { if (it == JsonValue.from("errored")) 1 else 0 }

            class Error
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val error: JsonField<InnerError>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("error")
                    @ExcludeMissing
                    error: JsonField<InnerError> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(error, type, mutableMapOf())

                /**
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun error(): InnerError = error.getRequired("error")

                /**
                 * Expected to always return the following:
                 * ```kotlin
                 * JsonValue.from("error")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [error].
                 *
                 * Unlike [error], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<InnerError> = error

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
                     * Returns a mutable builder for constructing an instance of [Error].
                     *
                     * The following fields are required:
                     * ```kotlin
                     * .error()
                     * ```
                     */
                    fun builder() = Builder()
                }

                /** A builder for [Error]. */
                class Builder internal constructor() {

                    private var error: JsonField<InnerError>? = null
                    private var type: JsonValue = JsonValue.from("error")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(error: Error) = apply {
                        this.error = error.error
                        type = error.type
                        additionalProperties = error.additionalProperties.toMutableMap()
                    }

                    fun error(error: InnerError) = error(JsonField.of(error))

                    /**
                     * Sets [Builder.error] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.error] with a well-typed [InnerError] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun error(error: JsonField<InnerError>) = apply { this.error = error }

                    /**
                     * Alias for calling [error] with `InnerError.ofInvalidRequest(invalidRequest)`.
                     */
                    fun error(invalidRequest: InnerError.InvalidRequestError) =
                        error(InnerError.ofInvalidRequest(invalidRequest))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.InvalidRequestError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun invalidRequestError(message: String) =
                        error(InnerError.InvalidRequestError.builder().message(message).build())

                    /**
                     * Alias for calling [error] with `InnerError.ofAuthentication(authentication)`.
                     */
                    fun error(authentication: InnerError.AuthenticationError) =
                        error(InnerError.ofAuthentication(authentication))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.AuthenticationError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun authenticationError(message: String) =
                        error(InnerError.AuthenticationError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofBilling(billing)`. */
                    fun error(billing: InnerError.BillingError) =
                        error(InnerError.ofBilling(billing))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.BillingError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun billingError(message: String) =
                        error(InnerError.BillingError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofPermission(permission)`. */
                    fun error(permission: InnerError.PermissionError) =
                        error(InnerError.ofPermission(permission))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.PermissionError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun permissionError(message: String) =
                        error(InnerError.PermissionError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofNotFound(notFound)`. */
                    fun error(notFound: InnerError.NotFoundError) =
                        error(InnerError.ofNotFound(notFound))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.NotFoundError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun notFoundError(message: String) =
                        error(InnerError.NotFoundError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofRateLimit(rateLimit)`. */
                    fun error(rateLimit: InnerError.RateLimitError) =
                        error(InnerError.ofRateLimit(rateLimit))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.RateLimitError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun rateLimitError(message: String) =
                        error(InnerError.RateLimitError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofTimeout(timeout)`. */
                    fun error(timeout: InnerError.TimeoutError) =
                        error(InnerError.ofTimeout(timeout))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.TimeoutError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun timeoutError(message: String) =
                        error(InnerError.TimeoutError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofApi(api)`. */
                    fun error(api: InnerError.ApiError) = error(InnerError.ofApi(api))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.ApiError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun apiError(message: String) =
                        error(InnerError.ApiError.builder().message(message).build())

                    /** Alias for calling [error] with `InnerError.ofOverloaded(overloaded)`. */
                    fun error(overloaded: InnerError.OverloadedError) =
                        error(InnerError.ofOverloaded(overloaded))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.OverloadedError.builder()
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun overloadedError(message: String) =
                        error(InnerError.OverloadedError.builder().message(message).build())

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```kotlin
                     * JsonValue.from("error")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Error].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```kotlin
                     * .error()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Error =
                        Error(
                            checkRequired("error", error),
                            type,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    error().validate()
                    _type().let {
                        if (it != JsonValue.from("error")) {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                internal fun validity(): Int =
                    (error.asKnown()?.validity() ?: 0) +
                        type.let { if (it == JsonValue.from("error")) 1 else 0 }

                @JsonDeserialize(using = InnerError.Deserializer::class)
                @JsonSerialize(using = InnerError.Serializer::class)
                class InnerError
                private constructor(
                    private val invalidRequest: InvalidRequestError? = null,
                    private val authentication: AuthenticationError? = null,
                    private val billing: BillingError? = null,
                    private val permission: PermissionError? = null,
                    private val notFound: NotFoundError? = null,
                    private val rateLimit: RateLimitError? = null,
                    private val timeout: TimeoutError? = null,
                    private val api: ApiError? = null,
                    private val overloaded: OverloadedError? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun invalidRequest(): InvalidRequestError? = invalidRequest

                    fun authentication(): AuthenticationError? = authentication

                    fun billing(): BillingError? = billing

                    fun permission(): PermissionError? = permission

                    fun notFound(): NotFoundError? = notFound

                    fun rateLimit(): RateLimitError? = rateLimit

                    fun timeout(): TimeoutError? = timeout

                    fun api(): ApiError? = api

                    fun overloaded(): OverloadedError? = overloaded

                    fun isInvalidRequest(): Boolean = invalidRequest != null

                    fun isAuthentication(): Boolean = authentication != null

                    fun isBilling(): Boolean = billing != null

                    fun isPermission(): Boolean = permission != null

                    fun isNotFound(): Boolean = notFound != null

                    fun isRateLimit(): Boolean = rateLimit != null

                    fun isTimeout(): Boolean = timeout != null

                    fun isApi(): Boolean = api != null

                    fun isOverloaded(): Boolean = overloaded != null

                    fun asInvalidRequest(): InvalidRequestError =
                        invalidRequest.getOrThrow("invalidRequest")

                    fun asAuthentication(): AuthenticationError =
                        authentication.getOrThrow("authentication")

                    fun asBilling(): BillingError = billing.getOrThrow("billing")

                    fun asPermission(): PermissionError = permission.getOrThrow("permission")

                    fun asNotFound(): NotFoundError = notFound.getOrThrow("notFound")

                    fun asRateLimit(): RateLimitError = rateLimit.getOrThrow("rateLimit")

                    fun asTimeout(): TimeoutError = timeout.getOrThrow("timeout")

                    fun asApi(): ApiError = api.getOrThrow("api")

                    fun asOverloaded(): OverloadedError = overloaded.getOrThrow("overloaded")

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T =
                        when {
                            invalidRequest != null -> visitor.visitInvalidRequest(invalidRequest)
                            authentication != null -> visitor.visitAuthentication(authentication)
                            billing != null -> visitor.visitBilling(billing)
                            permission != null -> visitor.visitPermission(permission)
                            notFound != null -> visitor.visitNotFound(notFound)
                            rateLimit != null -> visitor.visitRateLimit(rateLimit)
                            timeout != null -> visitor.visitTimeout(timeout)
                            api != null -> visitor.visitApi(api)
                            overloaded != null -> visitor.visitOverloaded(overloaded)
                            else -> visitor.unknown(_json)
                        }

                    private var validated: Boolean = false

                    fun validate(): InnerError = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitInvalidRequest(
                                    invalidRequest: InvalidRequestError
                                ) {
                                    invalidRequest.validate()
                                }

                                override fun visitAuthentication(
                                    authentication: AuthenticationError
                                ) {
                                    authentication.validate()
                                }

                                override fun visitBilling(billing: BillingError) {
                                    billing.validate()
                                }

                                override fun visitPermission(permission: PermissionError) {
                                    permission.validate()
                                }

                                override fun visitNotFound(notFound: NotFoundError) {
                                    notFound.validate()
                                }

                                override fun visitRateLimit(rateLimit: RateLimitError) {
                                    rateLimit.validate()
                                }

                                override fun visitTimeout(timeout: TimeoutError) {
                                    timeout.validate()
                                }

                                override fun visitApi(api: ApiError) {
                                    api.validate()
                                }

                                override fun visitOverloaded(overloaded: OverloadedError) {
                                    overloaded.validate()
                                }
                            }
                        )
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
                     * Returns a score indicating how many valid values are contained in this object
                     * recursively.
                     *
                     * Used for best match union deserialization.
                     */
                    internal fun validity(): Int =
                        accept(
                            object : Visitor<Int> {
                                override fun visitInvalidRequest(
                                    invalidRequest: InvalidRequestError
                                ) = invalidRequest.validity()

                                override fun visitAuthentication(
                                    authentication: AuthenticationError
                                ) = authentication.validity()

                                override fun visitBilling(billing: BillingError) =
                                    billing.validity()

                                override fun visitPermission(permission: PermissionError) =
                                    permission.validity()

                                override fun visitNotFound(notFound: NotFoundError) =
                                    notFound.validity()

                                override fun visitRateLimit(rateLimit: RateLimitError) =
                                    rateLimit.validity()

                                override fun visitTimeout(timeout: TimeoutError) =
                                    timeout.validity()

                                override fun visitApi(api: ApiError) = api.validity()

                                override fun visitOverloaded(overloaded: OverloadedError) =
                                    overloaded.validity()

                                override fun unknown(json: JsonValue?) = 0
                            }
                        )

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is InnerError &&
                            invalidRequest == other.invalidRequest &&
                            authentication == other.authentication &&
                            billing == other.billing &&
                            permission == other.permission &&
                            notFound == other.notFound &&
                            rateLimit == other.rateLimit &&
                            timeout == other.timeout &&
                            api == other.api &&
                            overloaded == other.overloaded
                    }

                    override fun hashCode(): Int =
                        Objects.hash(
                            invalidRequest,
                            authentication,
                            billing,
                            permission,
                            notFound,
                            rateLimit,
                            timeout,
                            api,
                            overloaded,
                        )

                    override fun toString(): String =
                        when {
                            invalidRequest != null -> "InnerError{invalidRequest=$invalidRequest}"
                            authentication != null -> "InnerError{authentication=$authentication}"
                            billing != null -> "InnerError{billing=$billing}"
                            permission != null -> "InnerError{permission=$permission}"
                            notFound != null -> "InnerError{notFound=$notFound}"
                            rateLimit != null -> "InnerError{rateLimit=$rateLimit}"
                            timeout != null -> "InnerError{timeout=$timeout}"
                            api != null -> "InnerError{api=$api}"
                            overloaded != null -> "InnerError{overloaded=$overloaded}"
                            _json != null -> "InnerError{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid InnerError")
                        }

                    companion object {

                        fun ofInvalidRequest(invalidRequest: InvalidRequestError) =
                            InnerError(invalidRequest = invalidRequest)

                        fun ofAuthentication(authentication: AuthenticationError) =
                            InnerError(authentication = authentication)

                        fun ofBilling(billing: BillingError) = InnerError(billing = billing)

                        fun ofPermission(permission: PermissionError) =
                            InnerError(permission = permission)

                        fun ofNotFound(notFound: NotFoundError) = InnerError(notFound = notFound)

                        fun ofRateLimit(rateLimit: RateLimitError) =
                            InnerError(rateLimit = rateLimit)

                        fun ofTimeout(timeout: TimeoutError) = InnerError(timeout = timeout)

                        fun ofApi(api: ApiError) = InnerError(api = api)

                        fun ofOverloaded(overloaded: OverloadedError) =
                            InnerError(overloaded = overloaded)
                    }

                    /**
                     * An interface that defines how to map each variant of [InnerError] to a value
                     * of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitInvalidRequest(invalidRequest: InvalidRequestError): T

                        fun visitAuthentication(authentication: AuthenticationError): T

                        fun visitBilling(billing: BillingError): T

                        fun visitPermission(permission: PermissionError): T

                        fun visitNotFound(notFound: NotFoundError): T

                        fun visitRateLimit(rateLimit: RateLimitError): T

                        fun visitTimeout(timeout: TimeoutError): T

                        fun visitApi(api: ApiError): T

                        fun visitOverloaded(overloaded: OverloadedError): T

                        /**
                         * Maps an unknown variant of [InnerError] to a value of type [T].
                         *
                         * An instance of [InnerError] can contain an unknown variant if it was
                         * deserialized from data that doesn't match any known variant. For example,
                         * if the SDK is on an older version than the API, then the API may respond
                         * with new variants that the SDK is unaware of.
                         *
                         * @throws SamInvalidDataException in the default implementation.
                         */
                        fun unknown(json: JsonValue?): T {
                            throw SamInvalidDataException("Unknown InnerError: $json")
                        }
                    }

                    internal class Deserializer : BaseDeserializer<InnerError>(InnerError::class) {

                        override fun ObjectCodec.deserialize(node: JsonNode): InnerError {
                            val json = JsonValue.fromJsonNode(node)
                            val type = json.asObject()?.get("type")?.asString()

                            when (type) {
                                "invalid_request_error" -> {
                                    return tryDeserialize(
                                            node,
                                            jacksonTypeRef<InvalidRequestError>(),
                                        )
                                        ?.let { InnerError(invalidRequest = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "authentication_error" -> {
                                    return tryDeserialize(
                                            node,
                                            jacksonTypeRef<AuthenticationError>(),
                                        )
                                        ?.let { InnerError(authentication = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "billing_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<BillingError>())
                                        ?.let { InnerError(billing = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "permission_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<PermissionError>())
                                        ?.let { InnerError(permission = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "not_found_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<NotFoundError>())
                                        ?.let { InnerError(notFound = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "rate_limit_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<RateLimitError>())
                                        ?.let { InnerError(rateLimit = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "timeout_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<TimeoutError>())
                                        ?.let { InnerError(timeout = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                                "api_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<ApiError>())?.let {
                                        InnerError(api = it, _json = json)
                                    } ?: InnerError(_json = json)
                                }
                                "overloaded_error" -> {
                                    return tryDeserialize(node, jacksonTypeRef<OverloadedError>())
                                        ?.let { InnerError(overloaded = it, _json = json) }
                                        ?: InnerError(_json = json)
                                }
                            }

                            return InnerError(_json = json)
                        }
                    }

                    internal class Serializer : BaseSerializer<InnerError>(InnerError::class) {

                        override fun serialize(
                            value: InnerError,
                            generator: JsonGenerator,
                            provider: SerializerProvider,
                        ) {
                            when {
                                value.invalidRequest != null ->
                                    generator.writeObject(value.invalidRequest)
                                value.authentication != null ->
                                    generator.writeObject(value.authentication)
                                value.billing != null -> generator.writeObject(value.billing)
                                value.permission != null -> generator.writeObject(value.permission)
                                value.notFound != null -> generator.writeObject(value.notFound)
                                value.rateLimit != null -> generator.writeObject(value.rateLimit)
                                value.timeout != null -> generator.writeObject(value.timeout)
                                value.api != null -> generator.writeObject(value.api)
                                value.overloaded != null -> generator.writeObject(value.overloaded)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid InnerError")
                            }
                        }
                    }

                    class InvalidRequestError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("invalid_request_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [InvalidRequestError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [InvalidRequestError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("invalid_request_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(invalidRequestError: InvalidRequestError) = apply {
                                message = invalidRequestError.message
                                type = invalidRequestError.type
                                additionalProperties =
                                    invalidRequestError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("invalid_request_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [InvalidRequestError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): InvalidRequestError =
                                InvalidRequestError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): InvalidRequestError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("invalid_request_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let {
                                    if (it == JsonValue.from("invalid_request_error")) 1 else 0
                                }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is InvalidRequestError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "InvalidRequestError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class AuthenticationError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("authentication_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [AuthenticationError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [AuthenticationError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("authentication_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(authenticationError: AuthenticationError) = apply {
                                message = authenticationError.message
                                type = authenticationError.type
                                additionalProperties =
                                    authenticationError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("authentication_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [AuthenticationError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): AuthenticationError =
                                AuthenticationError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): AuthenticationError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("authentication_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let {
                                    if (it == JsonValue.from("authentication_error")) 1 else 0
                                }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is AuthenticationError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "AuthenticationError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class BillingError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("billing_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [BillingError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BillingError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("billing_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(billingError: BillingError) = apply {
                                message = billingError.message
                                type = billingError.type
                                additionalProperties =
                                    billingError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("billing_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [BillingError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): BillingError =
                                BillingError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): BillingError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("billing_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("billing_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is BillingError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BillingError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class PermissionError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("permission_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [PermissionError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [PermissionError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("permission_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(permissionError: PermissionError) = apply {
                                message = permissionError.message
                                type = permissionError.type
                                additionalProperties =
                                    permissionError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("permission_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [PermissionError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): PermissionError =
                                PermissionError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): PermissionError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("permission_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("permission_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is PermissionError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "PermissionError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class NotFoundError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("not_found_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [NotFoundError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [NotFoundError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("not_found_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(notFoundError: NotFoundError) = apply {
                                message = notFoundError.message
                                type = notFoundError.type
                                additionalProperties =
                                    notFoundError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("not_found_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [NotFoundError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): NotFoundError =
                                NotFoundError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): NotFoundError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("not_found_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("not_found_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is NotFoundError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "NotFoundError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class RateLimitError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("rate_limit_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [RateLimitError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [RateLimitError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("rate_limit_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(rateLimitError: RateLimitError) = apply {
                                message = rateLimitError.message
                                type = rateLimitError.type
                                additionalProperties =
                                    rateLimitError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("rate_limit_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [RateLimitError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): RateLimitError =
                                RateLimitError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): RateLimitError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("rate_limit_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("rate_limit_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is RateLimitError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "RateLimitError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class TimeoutError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("timeout_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [TimeoutError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [TimeoutError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("timeout_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(timeoutError: TimeoutError) = apply {
                                message = timeoutError.message
                                type = timeoutError.type
                                additionalProperties =
                                    timeoutError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("timeout_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [TimeoutError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): TimeoutError =
                                TimeoutError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): TimeoutError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("timeout_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("timeout_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is TimeoutError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "TimeoutError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class ApiError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("api_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of [ApiError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ApiError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("api_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(apiError: ApiError) = apply {
                                message = apiError.message
                                type = apiError.type
                                additionalProperties = apiError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("api_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [ApiError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ApiError =
                                ApiError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ApiError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("api_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("api_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is ApiError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ApiError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class OverloadedError
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonValue,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * Expected to always return the following:
                         * ```kotlin
                         * JsonValue.from("overloaded_error")
                         * ```
                         *
                         * However, this method can be useful for debugging and logging (e.g. if the
                         * server responded with an unexpected value).
                         */
                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

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
                             * Returns a mutable builder for constructing an instance of
                             * [OverloadedError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [OverloadedError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonValue = JsonValue.from("overloaded_error")
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(overloadedError: OverloadedError) = apply {
                                message = overloadedError.message
                                type = overloadedError.type
                                additionalProperties =
                                    overloadedError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            /**
                             * Sets [Builder.message] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.message] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            /**
                             * Sets the field to an arbitrary JSON value.
                             *
                             * It is usually unnecessary to call this method because the field
                             * defaults to the following:
                             * ```kotlin
                             * JsonValue.from("overloaded_error")
                             * ```
                             *
                             * This method is primarily for setting the field to an undocumented or
                             * not yet supported value.
                             */
                            fun type(type: JsonValue) = apply { this.type = type }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [OverloadedError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): OverloadedError =
                                OverloadedError(
                                    checkRequired("message", message),
                                    type,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): OverloadedError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            _type().let {
                                if (it != JsonValue.from("overloaded_error")) {
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        internal fun validity(): Int =
                            (if (message.asKnown() == null) 0 else 1) +
                                type.let { if (it == JsonValue.from("overloaded_error")) 1 else 0 }

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is OverloadedError &&
                                message == other.message &&
                                type == other.type &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(message, type, additionalProperties)
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "OverloadedError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Error &&
                        error == other.error &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(error, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Error{error=$error, type=$type, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Errored &&
                    error == other.error &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(error, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Errored{error=$error, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchResultsResponse &&
            customId == other.customId &&
            result == other.result &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(customId, result, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchResultsResponse{customId=$customId, result=$result, additionalProperties=$additionalProperties}"
}
