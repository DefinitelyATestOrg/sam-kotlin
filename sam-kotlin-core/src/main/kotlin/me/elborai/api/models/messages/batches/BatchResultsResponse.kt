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
        fun result(succeeded: Result.SucceededResult) = result(Result.ofSucceeded(succeeded))

        /**
         * Alias for calling [result] with the following:
         * ```kotlin
         * Result.SucceededResult.builder()
         *     .type(BatchResultsResponse.Result.SucceededResult.Type.SUCCEEDED)
         *     .message(message)
         *     .build()
         * ```
         */
        fun succeededResult(message: Result.SucceededResult.Message) =
            result(
                Result.SucceededResult.builder()
                    .type(BatchResultsResponse.Result.SucceededResult.Type.SUCCEEDED)
                    .message(message)
                    .build()
            )

        /** Alias for calling [result] with `Result.ofErrored(errored)`. */
        fun result(errored: Result.ErroredResult) = result(Result.ofErrored(errored))

        /**
         * Alias for calling [result] with the following:
         * ```kotlin
         * Result.ErroredResult.builder()
         *     .type(BatchResultsResponse.Result.ErroredResult.Type.ERRORED)
         *     .error(error)
         *     .build()
         * ```
         */
        fun erroredResult(error: Result.ErroredResult.Error) =
            result(
                Result.ErroredResult.builder()
                    .type(BatchResultsResponse.Result.ErroredResult.Type.ERRORED)
                    .error(error)
                    .build()
            )

        /** Alias for calling [result] with `Result.ofCanceled(canceled)`. */
        fun result(canceled: Result.CanceledResult) = result(Result.ofCanceled(canceled))

        /** Alias for calling [result] with `Result.ofExpired(expired)`. */
        fun result(expired: Result.ExpiredResult) = result(Result.ofExpired(expired))

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
        private val succeeded: SucceededResult? = null,
        private val errored: ErroredResult? = null,
        private val canceled: CanceledResult? = null,
        private val expired: ExpiredResult? = null,
        private val _json: JsonValue? = null,
    ) {

        fun succeeded(): SucceededResult? = succeeded

        fun errored(): ErroredResult? = errored

        fun canceled(): CanceledResult? = canceled

        fun expired(): ExpiredResult? = expired

        fun isSucceeded(): Boolean = succeeded != null

        fun isErrored(): Boolean = errored != null

        fun isCanceled(): Boolean = canceled != null

        fun isExpired(): Boolean = expired != null

        fun asSucceeded(): SucceededResult = succeeded.getOrThrow("succeeded")

        fun asErrored(): ErroredResult = errored.getOrThrow("errored")

        fun asCanceled(): CanceledResult = canceled.getOrThrow("canceled")

        fun asExpired(): ExpiredResult = expired.getOrThrow("expired")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                succeeded != null -> visitor.visitSucceeded(succeeded)
                errored != null -> visitor.visitErrored(errored)
                canceled != null -> visitor.visitCanceled(canceled)
                expired != null -> visitor.visitExpired(expired)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitSucceeded(succeeded: SucceededResult) {
                        succeeded.validate()
                    }

                    override fun visitErrored(errored: ErroredResult) {
                        errored.validate()
                    }

                    override fun visitCanceled(canceled: CanceledResult) {
                        canceled.validate()
                    }

                    override fun visitExpired(expired: ExpiredResult) {
                        expired.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Result && succeeded == other.succeeded && errored == other.errored && canceled == other.canceled && expired == other.expired /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(succeeded, errored, canceled, expired) /* spotless:on */

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

            fun ofSucceeded(succeeded: SucceededResult) = Result(succeeded = succeeded)

            fun ofErrored(errored: ErroredResult) = Result(errored = errored)

            fun ofCanceled(canceled: CanceledResult) = Result(canceled = canceled)

            fun ofExpired(expired: ExpiredResult) = Result(expired = expired)
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitSucceeded(succeeded: SucceededResult): T

            fun visitErrored(errored: ErroredResult): T

            fun visitCanceled(canceled: CanceledResult): T

            fun visitExpired(expired: ExpiredResult): T

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
                        return Result(
                            succeeded = deserialize(node, jacksonTypeRef<SucceededResult>()),
                            _json = json,
                        )
                    }
                    "errored" -> {
                        return Result(
                            errored = deserialize(node, jacksonTypeRef<ErroredResult>()),
                            _json = json,
                        )
                    }
                    "canceled" -> {
                        return Result(
                            canceled = deserialize(node, jacksonTypeRef<CanceledResult>()),
                            _json = json,
                        )
                    }
                    "expired" -> {
                        return Result(
                            expired = deserialize(node, jacksonTypeRef<ExpiredResult>()),
                            _json = json,
                        )
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

        class SucceededResult
        private constructor(
            private val message: JsonField<Message>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<Message> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(message, type, mutableMapOf())

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): Message = message.getRequired("message")

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<Message> = message

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
                 * Returns a mutable builder for constructing an instance of [SucceededResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .message()
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [SucceededResult]. */
            class Builder internal constructor() {

                private var message: JsonField<Message>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(succeededResult: SucceededResult) = apply {
                    message = succeededResult.message
                    type = succeededResult.type
                    additionalProperties = succeededResult.additionalProperties.toMutableMap()
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

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [SucceededResult].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .message()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SucceededResult =
                    SucceededResult(
                        checkRequired("message", message),
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): SucceededResult = apply {
                if (validated) {
                    return@apply
                }

                message().validate()
                type()
                validated = true
            }

            class Message
            private constructor(
                private val id: JsonField<String>,
                private val content: JsonField<List<Content>>,
                private val model: JsonField<String>,
                private val role: JsonField<Role>,
                private val stopReason: JsonField<StopReason>,
                private val stopSequence: JsonField<String>,
                private val type: JsonField<Type>,
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
                    @JsonProperty("role") @ExcludeMissing role: JsonField<Role> = JsonMissing.of(),
                    @JsonProperty("stop_reason")
                    @ExcludeMissing
                    stopReason: JsonField<StopReason> = JsonMissing.of(),
                    @JsonProperty("stop_sequence")
                    @ExcludeMissing
                    stopSequence: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
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
                 * [{ "type": "text", "text": "Hi, I'm Claude." }]
                 * ```
                 *
                 * If the request input `messages` ended with an `assistant` turn, then the response
                 * `content` will continue directly from that last turn. You can use this to
                 * constrain the model's output.
                 *
                 * For example, if the input `messages` were:
                 * ```json
                 * [
                 *   {
                 *     "role": "user",
                 *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
                 *   },
                 *   { "role": "assistant", "content": "The best answer is (" }
                 * ]
                 * ```
                 *
                 * Then the response `content` might be:
                 * ```json
                 * [{ "type": "text", "text": "B)" }]
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
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun role(): Role = role.getRequired("role")

                /**
                 * The reason that we stopped.
                 *
                 * This may be one the following values:
                 * - `"end_turn"`: the model reached a natural stopping point
                 * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
                 * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
                 * - `"tool_use"`: the model invoked one or more tools
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
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): Type = type.getRequired("type")

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
                 * Returns the raw JSON value of [role].
                 *
                 * Unlike [role], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

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
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                     * .role()
                     * .stopReason()
                     * .stopSequence()
                     * .type()
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
                    private var role: JsonField<Role>? = null
                    private var stopReason: JsonField<StopReason>? = null
                    private var stopSequence: JsonField<String>? = null
                    private var type: JsonField<Type>? = null
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
                     * [{ "type": "text", "text": "Hi, I'm Claude." }]
                     * ```
                     *
                     * If the request input `messages` ended with an `assistant` turn, then the
                     * response `content` will continue directly from that last turn. You can use
                     * this to constrain the model's output.
                     *
                     * For example, if the input `messages` were:
                     * ```json
                     * [
                     *   {
                     *     "role": "user",
                     *     "content": "What's the Greek name for Sun? (A) Sol (B) Helios (C) Sun"
                     *   },
                     *   { "role": "assistant", "content": "The best answer is (" }
                     * ]
                     * ```
                     *
                     * Then the response `content` might be:
                     * ```json
                     * [{ "type": "text", "text": "B)" }]
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

                    /**
                     * Alias for calling [addContent] with
                     * `Content.ofResponseTextBlock(responseTextBlock)`.
                     */
                    fun addContent(responseTextBlock: Content.ResponseTextBlock) =
                        addContent(Content.ofResponseTextBlock(responseTextBlock))

                    /**
                     * Alias for calling [addContent] with
                     * `Content.ofResponseToolUseBlock(responseToolUseBlock)`.
                     */
                    fun addContent(responseToolUseBlock: Content.ResponseToolUseBlock) =
                        addContent(Content.ofResponseToolUseBlock(responseToolUseBlock))

                    /**
                     * Alias for calling [addContent] with
                     * `Content.ofResponseThinkingBlock(responseThinkingBlock)`.
                     */
                    fun addContent(responseThinkingBlock: Content.ResponseThinkingBlock) =
                        addContent(Content.ofResponseThinkingBlock(responseThinkingBlock))

                    /**
                     * Alias for calling [addContent] with
                     * `Content.ofResponseRedactedThinkingBlock(responseRedactedThinkingBlock)`.
                     */
                    fun addContent(
                        responseRedactedThinkingBlock: Content.ResponseRedactedThinkingBlock
                    ) =
                        addContent(
                            Content.ofResponseRedactedThinkingBlock(responseRedactedThinkingBlock)
                        )

                    /**
                     * Alias for calling [addContent] with the following:
                     * ```kotlin
                     * Content.ResponseRedactedThinkingBlock.builder()
                     *     .type(BatchResultsResponse.Result.SucceededResult.Message.Content.ResponseRedactedThinkingBlock.Type.REDACTED_THINKING)
                     *     .data(data)
                     *     .build()
                     * ```
                     */
                    fun addResponseRedactedThinkingBlockContent(data: String) =
                        addContent(
                            Content.ResponseRedactedThinkingBlock.builder()
                                .type(
                                    BatchResultsResponse.Result.SucceededResult.Message.Content
                                        .ResponseRedactedThinkingBlock
                                        .Type
                                        .REDACTED_THINKING
                                )
                                .data(data)
                                .build()
                        )

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
                     * Conversational role of the generated message.
                     *
                     * This will always be `"assistant"`.
                     */
                    fun role(role: Role) = role(JsonField.of(role))

                    /**
                     * Sets [Builder.role] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.role] with a well-typed [Role] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun role(role: JsonField<Role>) = apply { this.role = role }

                    /**
                     * The reason that we stopped.
                     *
                     * This may be one the following values:
                     * - `"end_turn"`: the model reached a natural stopping point
                     * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's
                     *   maximum
                     * - `"stop_sequence"`: one of your provided custom `stop_sequences` was
                     *   generated
                     * - `"tool_use"`: the model invoked one or more tools
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
                     * Object type.
                     *
                     * For Messages, this is always `"message"`.
                     */
                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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
                     * .role()
                     * .stopReason()
                     * .stopSequence()
                     * .type()
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
                            checkRequired("role", role),
                            checkRequired("stopReason", stopReason),
                            checkRequired("stopSequence", stopSequence),
                            checkRequired("type", type),
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
                    role()
                    stopReason()
                    stopSequence()
                    type()
                    usage().validate()
                    validated = true
                }

                @JsonDeserialize(using = Content.Deserializer::class)
                @JsonSerialize(using = Content.Serializer::class)
                class Content
                private constructor(
                    private val responseTextBlock: ResponseTextBlock? = null,
                    private val responseToolUseBlock: ResponseToolUseBlock? = null,
                    private val responseThinkingBlock: ResponseThinkingBlock? = null,
                    private val responseRedactedThinkingBlock: ResponseRedactedThinkingBlock? =
                        null,
                    private val _json: JsonValue? = null,
                ) {

                    fun responseTextBlock(): ResponseTextBlock? = responseTextBlock

                    fun responseToolUseBlock(): ResponseToolUseBlock? = responseToolUseBlock

                    fun responseThinkingBlock(): ResponseThinkingBlock? = responseThinkingBlock

                    fun responseRedactedThinkingBlock(): ResponseRedactedThinkingBlock? =
                        responseRedactedThinkingBlock

                    fun isResponseTextBlock(): Boolean = responseTextBlock != null

                    fun isResponseToolUseBlock(): Boolean = responseToolUseBlock != null

                    fun isResponseThinkingBlock(): Boolean = responseThinkingBlock != null

                    fun isResponseRedactedThinkingBlock(): Boolean =
                        responseRedactedThinkingBlock != null

                    fun asResponseTextBlock(): ResponseTextBlock =
                        responseTextBlock.getOrThrow("responseTextBlock")

                    fun asResponseToolUseBlock(): ResponseToolUseBlock =
                        responseToolUseBlock.getOrThrow("responseToolUseBlock")

                    fun asResponseThinkingBlock(): ResponseThinkingBlock =
                        responseThinkingBlock.getOrThrow("responseThinkingBlock")

                    fun asResponseRedactedThinkingBlock(): ResponseRedactedThinkingBlock =
                        responseRedactedThinkingBlock.getOrThrow("responseRedactedThinkingBlock")

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            responseTextBlock != null ->
                                visitor.visitResponseTextBlock(responseTextBlock)
                            responseToolUseBlock != null ->
                                visitor.visitResponseToolUseBlock(responseToolUseBlock)
                            responseThinkingBlock != null ->
                                visitor.visitResponseThinkingBlock(responseThinkingBlock)
                            responseRedactedThinkingBlock != null ->
                                visitor.visitResponseRedactedThinkingBlock(
                                    responseRedactedThinkingBlock
                                )
                            else -> visitor.unknown(_json)
                        }
                    }

                    private var validated: Boolean = false

                    fun validate(): Content = apply {
                        if (validated) {
                            return@apply
                        }

                        accept(
                            object : Visitor<Unit> {
                                override fun visitResponseTextBlock(
                                    responseTextBlock: ResponseTextBlock
                                ) {
                                    responseTextBlock.validate()
                                }

                                override fun visitResponseToolUseBlock(
                                    responseToolUseBlock: ResponseToolUseBlock
                                ) {
                                    responseToolUseBlock.validate()
                                }

                                override fun visitResponseThinkingBlock(
                                    responseThinkingBlock: ResponseThinkingBlock
                                ) {
                                    responseThinkingBlock.validate()
                                }

                                override fun visitResponseRedactedThinkingBlock(
                                    responseRedactedThinkingBlock: ResponseRedactedThinkingBlock
                                ) {
                                    responseRedactedThinkingBlock.validate()
                                }
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Content && responseTextBlock == other.responseTextBlock && responseToolUseBlock == other.responseToolUseBlock && responseThinkingBlock == other.responseThinkingBlock && responseRedactedThinkingBlock == other.responseRedactedThinkingBlock /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(responseTextBlock, responseToolUseBlock, responseThinkingBlock, responseRedactedThinkingBlock) /* spotless:on */

                    override fun toString(): String =
                        when {
                            responseTextBlock != null ->
                                "Content{responseTextBlock=$responseTextBlock}"
                            responseToolUseBlock != null ->
                                "Content{responseToolUseBlock=$responseToolUseBlock}"
                            responseThinkingBlock != null ->
                                "Content{responseThinkingBlock=$responseThinkingBlock}"
                            responseRedactedThinkingBlock != null ->
                                "Content{responseRedactedThinkingBlock=$responseRedactedThinkingBlock}"
                            _json != null -> "Content{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Content")
                        }

                    companion object {

                        fun ofResponseTextBlock(responseTextBlock: ResponseTextBlock) =
                            Content(responseTextBlock = responseTextBlock)

                        fun ofResponseToolUseBlock(responseToolUseBlock: ResponseToolUseBlock) =
                            Content(responseToolUseBlock = responseToolUseBlock)

                        fun ofResponseThinkingBlock(responseThinkingBlock: ResponseThinkingBlock) =
                            Content(responseThinkingBlock = responseThinkingBlock)

                        fun ofResponseRedactedThinkingBlock(
                            responseRedactedThinkingBlock: ResponseRedactedThinkingBlock
                        ) = Content(responseRedactedThinkingBlock = responseRedactedThinkingBlock)
                    }

                    /**
                     * An interface that defines how to map each variant of [Content] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitResponseTextBlock(responseTextBlock: ResponseTextBlock): T

                        fun visitResponseToolUseBlock(responseToolUseBlock: ResponseToolUseBlock): T

                        fun visitResponseThinkingBlock(
                            responseThinkingBlock: ResponseThinkingBlock
                        ): T

                        fun visitResponseRedactedThinkingBlock(
                            responseRedactedThinkingBlock: ResponseRedactedThinkingBlock
                        ): T

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
                                    return Content(
                                        responseTextBlock =
                                            deserialize(node, jacksonTypeRef<ResponseTextBlock>()),
                                        _json = json,
                                    )
                                }
                                "tool_use" -> {
                                    return Content(
                                        responseToolUseBlock =
                                            deserialize(
                                                node,
                                                jacksonTypeRef<ResponseToolUseBlock>(),
                                            ),
                                        _json = json,
                                    )
                                }
                                "thinking" -> {
                                    return Content(
                                        responseThinkingBlock =
                                            deserialize(
                                                node,
                                                jacksonTypeRef<ResponseThinkingBlock>(),
                                            ),
                                        _json = json,
                                    )
                                }
                                "redacted_thinking" -> {
                                    return Content(
                                        responseRedactedThinkingBlock =
                                            deserialize(
                                                node,
                                                jacksonTypeRef<ResponseRedactedThinkingBlock>(),
                                            ),
                                        _json = json,
                                    )
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
                                value.responseTextBlock != null ->
                                    generator.writeObject(value.responseTextBlock)
                                value.responseToolUseBlock != null ->
                                    generator.writeObject(value.responseToolUseBlock)
                                value.responseThinkingBlock != null ->
                                    generator.writeObject(value.responseThinkingBlock)
                                value.responseRedactedThinkingBlock != null ->
                                    generator.writeObject(value.responseRedactedThinkingBlock)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Content")
                            }
                        }
                    }

                    class ResponseTextBlock
                    private constructor(
                        private val citations: JsonField<List<Citation>>,
                        private val text: JsonField<String>,
                        private val type: JsonField<Type>,
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
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
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
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

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

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [ResponseTextBlock].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .citations()
                             * .text()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ResponseTextBlock]. */
                        class Builder internal constructor() {

                            private var citations: JsonField<MutableList<Citation>>? = null
                            private var text: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(responseTextBlock: ResponseTextBlock) = apply {
                                citations = responseTextBlock.citations.map { it.toMutableList() }
                                text = responseTextBlock.text
                                type = responseTextBlock.type
                                additionalProperties =
                                    responseTextBlock.additionalProperties.toMutableMap()
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
                             * `Citation.ofResponseCharLocation(responseCharLocation)`.
                             */
                            fun addCitation(
                                responseCharLocation: Citation.ResponseCharLocationCitation
                            ) = addCitation(Citation.ofResponseCharLocation(responseCharLocation))

                            /**
                             * Alias for calling [addCitation] with
                             * `Citation.ofResponsePageLocation(responsePageLocation)`.
                             */
                            fun addCitation(
                                responsePageLocation: Citation.ResponsePageLocationCitation
                            ) = addCitation(Citation.ofResponsePageLocation(responsePageLocation))

                            /**
                             * Alias for calling [addCitation] with
                             * `Citation.ofResponseContentBlockLocation(responseContentBlockLocation)`.
                             */
                            fun addCitation(
                                responseContentBlockLocation:
                                    Citation.ResponseContentBlockLocationCitation
                            ) =
                                addCitation(
                                    Citation.ofResponseContentBlockLocation(
                                        responseContentBlockLocation
                                    )
                                )

                            fun text(text: String) = text(JsonField.of(text))

                            /**
                             * Sets [Builder.text] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.text] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun text(text: JsonField<String>) = apply { this.text = text }

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * Returns an immutable instance of [ResponseTextBlock].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .citations()
                             * .text()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ResponseTextBlock =
                                ResponseTextBlock(
                                    checkRequired("citations", citations).map { it.toImmutable() },
                                    checkRequired("text", text),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ResponseTextBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            citations()?.forEach { it.validate() }
                            text()
                            type()
                            validated = true
                        }

                        @JsonDeserialize(using = Citation.Deserializer::class)
                        @JsonSerialize(using = Citation.Serializer::class)
                        class Citation
                        private constructor(
                            private val responseCharLocation: ResponseCharLocationCitation? = null,
                            private val responsePageLocation: ResponsePageLocationCitation? = null,
                            private val responseContentBlockLocation:
                                ResponseContentBlockLocationCitation? =
                                null,
                            private val _json: JsonValue? = null,
                        ) {

                            fun responseCharLocation(): ResponseCharLocationCitation? =
                                responseCharLocation

                            fun responsePageLocation(): ResponsePageLocationCitation? =
                                responsePageLocation

                            fun responseContentBlockLocation():
                                ResponseContentBlockLocationCitation? = responseContentBlockLocation

                            fun isResponseCharLocation(): Boolean = responseCharLocation != null

                            fun isResponsePageLocation(): Boolean = responsePageLocation != null

                            fun isResponseContentBlockLocation(): Boolean =
                                responseContentBlockLocation != null

                            fun asResponseCharLocation(): ResponseCharLocationCitation =
                                responseCharLocation.getOrThrow("responseCharLocation")

                            fun asResponsePageLocation(): ResponsePageLocationCitation =
                                responsePageLocation.getOrThrow("responsePageLocation")

                            fun asResponseContentBlockLocation():
                                ResponseContentBlockLocationCitation =
                                responseContentBlockLocation.getOrThrow(
                                    "responseContentBlockLocation"
                                )

                            fun _json(): JsonValue? = _json

                            fun <T> accept(visitor: Visitor<T>): T {
                                return when {
                                    responseCharLocation != null ->
                                        visitor.visitResponseCharLocation(responseCharLocation)
                                    responsePageLocation != null ->
                                        visitor.visitResponsePageLocation(responsePageLocation)
                                    responseContentBlockLocation != null ->
                                        visitor.visitResponseContentBlockLocation(
                                            responseContentBlockLocation
                                        )
                                    else -> visitor.unknown(_json)
                                }
                            }

                            private var validated: Boolean = false

                            fun validate(): Citation = apply {
                                if (validated) {
                                    return@apply
                                }

                                accept(
                                    object : Visitor<Unit> {
                                        override fun visitResponseCharLocation(
                                            responseCharLocation: ResponseCharLocationCitation
                                        ) {
                                            responseCharLocation.validate()
                                        }

                                        override fun visitResponsePageLocation(
                                            responsePageLocation: ResponsePageLocationCitation
                                        ) {
                                            responsePageLocation.validate()
                                        }

                                        override fun visitResponseContentBlockLocation(
                                            responseContentBlockLocation:
                                                ResponseContentBlockLocationCitation
                                        ) {
                                            responseContentBlockLocation.validate()
                                        }
                                    }
                                )
                                validated = true
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is Citation && responseCharLocation == other.responseCharLocation && responsePageLocation == other.responsePageLocation && responseContentBlockLocation == other.responseContentBlockLocation /* spotless:on */
                            }

                            override fun hashCode(): Int = /* spotless:off */ Objects.hash(responseCharLocation, responsePageLocation, responseContentBlockLocation) /* spotless:on */

                            override fun toString(): String =
                                when {
                                    responseCharLocation != null ->
                                        "Citation{responseCharLocation=$responseCharLocation}"
                                    responsePageLocation != null ->
                                        "Citation{responsePageLocation=$responsePageLocation}"
                                    responseContentBlockLocation != null ->
                                        "Citation{responseContentBlockLocation=$responseContentBlockLocation}"
                                    _json != null -> "Citation{_unknown=$_json}"
                                    else -> throw IllegalStateException("Invalid Citation")
                                }

                            companion object {

                                fun ofResponseCharLocation(
                                    responseCharLocation: ResponseCharLocationCitation
                                ) = Citation(responseCharLocation = responseCharLocation)

                                fun ofResponsePageLocation(
                                    responsePageLocation: ResponsePageLocationCitation
                                ) = Citation(responsePageLocation = responsePageLocation)

                                fun ofResponseContentBlockLocation(
                                    responseContentBlockLocation:
                                        ResponseContentBlockLocationCitation
                                ) =
                                    Citation(
                                        responseContentBlockLocation = responseContentBlockLocation
                                    )
                            }

                            /**
                             * An interface that defines how to map each variant of [Citation] to a
                             * value of type [T].
                             */
                            interface Visitor<out T> {

                                fun visitResponseCharLocation(
                                    responseCharLocation: ResponseCharLocationCitation
                                ): T

                                fun visitResponsePageLocation(
                                    responsePageLocation: ResponsePageLocationCitation
                                ): T

                                fun visitResponseContentBlockLocation(
                                    responseContentBlockLocation:
                                        ResponseContentBlockLocationCitation
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
                                            return Citation(
                                                responseCharLocation =
                                                    deserialize(
                                                        node,
                                                        jacksonTypeRef<
                                                            ResponseCharLocationCitation
                                                        >(),
                                                    ),
                                                _json = json,
                                            )
                                        }
                                        "page_location" -> {
                                            return Citation(
                                                responsePageLocation =
                                                    deserialize(
                                                        node,
                                                        jacksonTypeRef<
                                                            ResponsePageLocationCitation
                                                        >(),
                                                    ),
                                                _json = json,
                                            )
                                        }
                                        "content_block_location" -> {
                                            return Citation(
                                                responseContentBlockLocation =
                                                    deserialize(
                                                        node,
                                                        jacksonTypeRef<
                                                            ResponseContentBlockLocationCitation
                                                        >(),
                                                    ),
                                                _json = json,
                                            )
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
                                        value.responseCharLocation != null ->
                                            generator.writeObject(value.responseCharLocation)
                                        value.responsePageLocation != null ->
                                            generator.writeObject(value.responsePageLocation)
                                        value.responseContentBlockLocation != null ->
                                            generator.writeObject(
                                                value.responseContentBlockLocation
                                            )
                                        value._json != null -> generator.writeObject(value._json)
                                        else -> throw IllegalStateException("Invalid Citation")
                                    }
                                }
                            }

                            class ResponseCharLocationCitation
                            private constructor(
                                private val citedText: JsonField<String>,
                                private val documentIndex: JsonField<Long>,
                                private val documentTitle: JsonField<String>,
                                private val endCharIndex: JsonField<Long>,
                                private val startCharIndex: JsonField<Long>,
                                private val type: JsonField<Type>,
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
                                    type: JsonField<Type> = JsonMissing.of(),
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
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun type(): Type = type.getRequired("type")

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

                                /**
                                 * Returns the raw JSON value of [type].
                                 *
                                 * Unlike [type], this method doesn't throw if the JSON field has an
                                 * unexpected type.
                                 */
                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<Type> = type

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
                                     * [ResponseCharLocationCitation].
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endCharIndex()
                                     * .startCharIndex()
                                     * .type()
                                     * ```
                                     */
                                    fun builder() = Builder()
                                }

                                /** A builder for [ResponseCharLocationCitation]. */
                                class Builder internal constructor() {

                                    private var citedText: JsonField<String>? = null
                                    private var documentIndex: JsonField<Long>? = null
                                    private var documentTitle: JsonField<String>? = null
                                    private var endCharIndex: JsonField<Long>? = null
                                    private var startCharIndex: JsonField<Long>? = null
                                    private var type: JsonField<Type>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(
                                        responseCharLocationCitation: ResponseCharLocationCitation
                                    ) = apply {
                                        citedText = responseCharLocationCitation.citedText
                                        documentIndex = responseCharLocationCitation.documentIndex
                                        documentTitle = responseCharLocationCitation.documentTitle
                                        endCharIndex = responseCharLocationCitation.endCharIndex
                                        startCharIndex = responseCharLocationCitation.startCharIndex
                                        type = responseCharLocationCitation.type
                                        additionalProperties =
                                            responseCharLocationCitation.additionalProperties
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

                                    fun type(type: Type) = type(JsonField.of(type))

                                    /**
                                     * Sets [Builder.type] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.type] with a well-typed
                                     * [Type] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonField<Type>) = apply { this.type = type }

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
                                     * Returns an immutable instance of
                                     * [ResponseCharLocationCitation].
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
                                     * .type()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): ResponseCharLocationCitation =
                                        ResponseCharLocationCitation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endCharIndex", endCharIndex),
                                            checkRequired("startCharIndex", startCharIndex),
                                            checkRequired("type", type),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): ResponseCharLocationCitation = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    citedText()
                                    documentIndex()
                                    documentTitle()
                                    endCharIndex()
                                    startCharIndex()
                                    type()
                                    validated = true
                                }

                                class Type
                                @JsonCreator
                                private constructor(private val value: JsonField<String>) : Enum {

                                    /**
                                     * Returns this class instance's raw value.
                                     *
                                     * This is usually only useful if this instance was deserialized
                                     * from data that doesn't match any known member, and you want
                                     * to know that value. For example, if the SDK is on an older
                                     * version than the API, then the API may respond with new
                                     * members that the SDK is unaware of.
                                     */
                                    @com.fasterxml.jackson.annotation.JsonValue
                                    fun _value(): JsonField<String> = value

                                    companion object {

                                        val CHAR_LOCATION = of("char_location")

                                        fun of(value: String) = Type(JsonField.of(value))
                                    }

                                    /** An enum containing [Type]'s known values. */
                                    enum class Known {
                                        CHAR_LOCATION
                                    }

                                    /**
                                     * An enum containing [Type]'s known values, as well as an
                                     * [_UNKNOWN] member.
                                     *
                                     * An instance of [Type] can contain an unknown value in a
                                     * couple of cases:
                                     * - It was deserialized from data that doesn't match any known
                                     *   member. For example, if the SDK is on an older version than
                                     *   the API, then the API may respond with new members that the
                                     *   SDK is unaware of.
                                     * - It was constructed with an arbitrary value using the [of]
                                     *   method.
                                     */
                                    enum class Value {
                                        CHAR_LOCATION,
                                        /**
                                         * An enum member indicating that [Type] was instantiated
                                         * with an unknown value.
                                         */
                                        _UNKNOWN,
                                    }

                                    /**
                                     * Returns an enum member corresponding to this class instance's
                                     * value, or [Value._UNKNOWN] if the class was instantiated with
                                     * an unknown value.
                                     *
                                     * Use the [known] method instead if you're certain the value is
                                     * always known or if you want to throw for the unknown case.
                                     */
                                    fun value(): Value =
                                        when (this) {
                                            CHAR_LOCATION -> Value.CHAR_LOCATION
                                            else -> Value._UNKNOWN
                                        }

                                    /**
                                     * Returns an enum member corresponding to this class instance's
                                     * value.
                                     *
                                     * Use the [value] method instead if you're uncertain the value
                                     * is always known and don't want to throw for the unknown case.
                                     *
                                     * @throws SamInvalidDataException if this class instance's
                                     *   value is a not a known member.
                                     */
                                    fun known(): Known =
                                        when (this) {
                                            CHAR_LOCATION -> Known.CHAR_LOCATION
                                            else ->
                                                throw SamInvalidDataException(
                                                    "Unknown Type: $value"
                                                )
                                        }

                                    /**
                                     * Returns this class instance's primitive wire representation.
                                     *
                                     * This differs from the [toString] method because that method
                                     * is primarily for debugging and generally doesn't throw.
                                     *
                                     * @throws SamInvalidDataException if this class instance's
                                     *   value does not have the expected primitive type.
                                     */
                                    fun asString(): String =
                                        _value().asString()
                                            ?: throw SamInvalidDataException(
                                                "Value is not a String"
                                            )

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

                                    return /* spotless:off */ other is ResponseCharLocationCitation && citedText == other.citedText && documentIndex == other.documentIndex && documentTitle == other.documentTitle && endCharIndex == other.endCharIndex && startCharIndex == other.startCharIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(citedText, documentIndex, documentTitle, endCharIndex, startCharIndex, type, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "ResponseCharLocationCitation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endCharIndex=$endCharIndex, startCharIndex=$startCharIndex, type=$type, additionalProperties=$additionalProperties}"
                            }

                            class ResponsePageLocationCitation
                            private constructor(
                                private val citedText: JsonField<String>,
                                private val documentIndex: JsonField<Long>,
                                private val documentTitle: JsonField<String>,
                                private val endPageNumber: JsonField<Long>,
                                private val startPageNumber: JsonField<Long>,
                                private val type: JsonField<Type>,
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
                                    type: JsonField<Type> = JsonMissing.of(),
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
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun type(): Type = type.getRequired("type")

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

                                /**
                                 * Returns the raw JSON value of [type].
                                 *
                                 * Unlike [type], this method doesn't throw if the JSON field has an
                                 * unexpected type.
                                 */
                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<Type> = type

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
                                     * [ResponsePageLocationCitation].
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endPageNumber()
                                     * .startPageNumber()
                                     * .type()
                                     * ```
                                     */
                                    fun builder() = Builder()
                                }

                                /** A builder for [ResponsePageLocationCitation]. */
                                class Builder internal constructor() {

                                    private var citedText: JsonField<String>? = null
                                    private var documentIndex: JsonField<Long>? = null
                                    private var documentTitle: JsonField<String>? = null
                                    private var endPageNumber: JsonField<Long>? = null
                                    private var startPageNumber: JsonField<Long>? = null
                                    private var type: JsonField<Type>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(
                                        responsePageLocationCitation: ResponsePageLocationCitation
                                    ) = apply {
                                        citedText = responsePageLocationCitation.citedText
                                        documentIndex = responsePageLocationCitation.documentIndex
                                        documentTitle = responsePageLocationCitation.documentTitle
                                        endPageNumber = responsePageLocationCitation.endPageNumber
                                        startPageNumber =
                                            responsePageLocationCitation.startPageNumber
                                        type = responsePageLocationCitation.type
                                        additionalProperties =
                                            responsePageLocationCitation.additionalProperties
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

                                    fun type(type: Type) = type(JsonField.of(type))

                                    /**
                                     * Sets [Builder.type] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.type] with a well-typed
                                     * [Type] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonField<Type>) = apply { this.type = type }

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
                                     * Returns an immutable instance of
                                     * [ResponsePageLocationCitation].
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
                                     * .type()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): ResponsePageLocationCitation =
                                        ResponsePageLocationCitation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endPageNumber", endPageNumber),
                                            checkRequired("startPageNumber", startPageNumber),
                                            checkRequired("type", type),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): ResponsePageLocationCitation = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    citedText()
                                    documentIndex()
                                    documentTitle()
                                    endPageNumber()
                                    startPageNumber()
                                    type()
                                    validated = true
                                }

                                class Type
                                @JsonCreator
                                private constructor(private val value: JsonField<String>) : Enum {

                                    /**
                                     * Returns this class instance's raw value.
                                     *
                                     * This is usually only useful if this instance was deserialized
                                     * from data that doesn't match any known member, and you want
                                     * to know that value. For example, if the SDK is on an older
                                     * version than the API, then the API may respond with new
                                     * members that the SDK is unaware of.
                                     */
                                    @com.fasterxml.jackson.annotation.JsonValue
                                    fun _value(): JsonField<String> = value

                                    companion object {

                                        val PAGE_LOCATION = of("page_location")

                                        fun of(value: String) = Type(JsonField.of(value))
                                    }

                                    /** An enum containing [Type]'s known values. */
                                    enum class Known {
                                        PAGE_LOCATION
                                    }

                                    /**
                                     * An enum containing [Type]'s known values, as well as an
                                     * [_UNKNOWN] member.
                                     *
                                     * An instance of [Type] can contain an unknown value in a
                                     * couple of cases:
                                     * - It was deserialized from data that doesn't match any known
                                     *   member. For example, if the SDK is on an older version than
                                     *   the API, then the API may respond with new members that the
                                     *   SDK is unaware of.
                                     * - It was constructed with an arbitrary value using the [of]
                                     *   method.
                                     */
                                    enum class Value {
                                        PAGE_LOCATION,
                                        /**
                                         * An enum member indicating that [Type] was instantiated
                                         * with an unknown value.
                                         */
                                        _UNKNOWN,
                                    }

                                    /**
                                     * Returns an enum member corresponding to this class instance's
                                     * value, or [Value._UNKNOWN] if the class was instantiated with
                                     * an unknown value.
                                     *
                                     * Use the [known] method instead if you're certain the value is
                                     * always known or if you want to throw for the unknown case.
                                     */
                                    fun value(): Value =
                                        when (this) {
                                            PAGE_LOCATION -> Value.PAGE_LOCATION
                                            else -> Value._UNKNOWN
                                        }

                                    /**
                                     * Returns an enum member corresponding to this class instance's
                                     * value.
                                     *
                                     * Use the [value] method instead if you're uncertain the value
                                     * is always known and don't want to throw for the unknown case.
                                     *
                                     * @throws SamInvalidDataException if this class instance's
                                     *   value is a not a known member.
                                     */
                                    fun known(): Known =
                                        when (this) {
                                            PAGE_LOCATION -> Known.PAGE_LOCATION
                                            else ->
                                                throw SamInvalidDataException(
                                                    "Unknown Type: $value"
                                                )
                                        }

                                    /**
                                     * Returns this class instance's primitive wire representation.
                                     *
                                     * This differs from the [toString] method because that method
                                     * is primarily for debugging and generally doesn't throw.
                                     *
                                     * @throws SamInvalidDataException if this class instance's
                                     *   value does not have the expected primitive type.
                                     */
                                    fun asString(): String =
                                        _value().asString()
                                            ?: throw SamInvalidDataException(
                                                "Value is not a String"
                                            )

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

                                    return /* spotless:off */ other is ResponsePageLocationCitation && citedText == other.citedText && documentIndex == other.documentIndex && documentTitle == other.documentTitle && endPageNumber == other.endPageNumber && startPageNumber == other.startPageNumber && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(citedText, documentIndex, documentTitle, endPageNumber, startPageNumber, type, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "ResponsePageLocationCitation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endPageNumber=$endPageNumber, startPageNumber=$startPageNumber, type=$type, additionalProperties=$additionalProperties}"
                            }

                            class ResponseContentBlockLocationCitation
                            private constructor(
                                private val citedText: JsonField<String>,
                                private val documentIndex: JsonField<Long>,
                                private val documentTitle: JsonField<String>,
                                private val endBlockIndex: JsonField<Long>,
                                private val startBlockIndex: JsonField<Long>,
                                private val type: JsonField<Type>,
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
                                    type: JsonField<Type> = JsonMissing.of(),
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
                                 * @throws SamInvalidDataException if the JSON field has an
                                 *   unexpected type or is unexpectedly missing or null (e.g. if the
                                 *   server responded with an unexpected value).
                                 */
                                fun type(): Type = type.getRequired("type")

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

                                /**
                                 * Returns the raw JSON value of [type].
                                 *
                                 * Unlike [type], this method doesn't throw if the JSON field has an
                                 * unexpected type.
                                 */
                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<Type> = type

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
                                     * [ResponseContentBlockLocationCitation].
                                     *
                                     * The following fields are required:
                                     * ```kotlin
                                     * .citedText()
                                     * .documentIndex()
                                     * .documentTitle()
                                     * .endBlockIndex()
                                     * .startBlockIndex()
                                     * .type()
                                     * ```
                                     */
                                    fun builder() = Builder()
                                }

                                /** A builder for [ResponseContentBlockLocationCitation]. */
                                class Builder internal constructor() {

                                    private var citedText: JsonField<String>? = null
                                    private var documentIndex: JsonField<Long>? = null
                                    private var documentTitle: JsonField<String>? = null
                                    private var endBlockIndex: JsonField<Long>? = null
                                    private var startBlockIndex: JsonField<Long>? = null
                                    private var type: JsonField<Type>? = null
                                    private var additionalProperties:
                                        MutableMap<String, JsonValue> =
                                        mutableMapOf()

                                    internal fun from(
                                        responseContentBlockLocationCitation:
                                            ResponseContentBlockLocationCitation
                                    ) = apply {
                                        citedText = responseContentBlockLocationCitation.citedText
                                        documentIndex =
                                            responseContentBlockLocationCitation.documentIndex
                                        documentTitle =
                                            responseContentBlockLocationCitation.documentTitle
                                        endBlockIndex =
                                            responseContentBlockLocationCitation.endBlockIndex
                                        startBlockIndex =
                                            responseContentBlockLocationCitation.startBlockIndex
                                        type = responseContentBlockLocationCitation.type
                                        additionalProperties =
                                            responseContentBlockLocationCitation
                                                .additionalProperties
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

                                    fun type(type: Type) = type(JsonField.of(type))

                                    /**
                                     * Sets [Builder.type] to an arbitrary JSON value.
                                     *
                                     * You should usually call [Builder.type] with a well-typed
                                     * [Type] value instead. This method is primarily for setting
                                     * the field to an undocumented or not yet supported value.
                                     */
                                    fun type(type: JsonField<Type>) = apply { this.type = type }

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
                                     * Returns an immutable instance of
                                     * [ResponseContentBlockLocationCitation].
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
                                     * .type()
                                     * ```
                                     *
                                     * @throws IllegalStateException if any required field is unset.
                                     */
                                    fun build(): ResponseContentBlockLocationCitation =
                                        ResponseContentBlockLocationCitation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endBlockIndex", endBlockIndex),
                                            checkRequired("startBlockIndex", startBlockIndex),
                                            checkRequired("type", type),
                                            additionalProperties.toMutableMap(),
                                        )
                                }

                                private var validated: Boolean = false

                                fun validate(): ResponseContentBlockLocationCitation = apply {
                                    if (validated) {
                                        return@apply
                                    }

                                    citedText()
                                    documentIndex()
                                    documentTitle()
                                    endBlockIndex()
                                    startBlockIndex()
                                    type()
                                    validated = true
                                }

                                class Type
                                @JsonCreator
                                private constructor(private val value: JsonField<String>) : Enum {

                                    /**
                                     * Returns this class instance's raw value.
                                     *
                                     * This is usually only useful if this instance was deserialized
                                     * from data that doesn't match any known member, and you want
                                     * to know that value. For example, if the SDK is on an older
                                     * version than the API, then the API may respond with new
                                     * members that the SDK is unaware of.
                                     */
                                    @com.fasterxml.jackson.annotation.JsonValue
                                    fun _value(): JsonField<String> = value

                                    companion object {

                                        val CONTENT_BLOCK_LOCATION = of("content_block_location")

                                        fun of(value: String) = Type(JsonField.of(value))
                                    }

                                    /** An enum containing [Type]'s known values. */
                                    enum class Known {
                                        CONTENT_BLOCK_LOCATION
                                    }

                                    /**
                                     * An enum containing [Type]'s known values, as well as an
                                     * [_UNKNOWN] member.
                                     *
                                     * An instance of [Type] can contain an unknown value in a
                                     * couple of cases:
                                     * - It was deserialized from data that doesn't match any known
                                     *   member. For example, if the SDK is on an older version than
                                     *   the API, then the API may respond with new members that the
                                     *   SDK is unaware of.
                                     * - It was constructed with an arbitrary value using the [of]
                                     *   method.
                                     */
                                    enum class Value {
                                        CONTENT_BLOCK_LOCATION,
                                        /**
                                         * An enum member indicating that [Type] was instantiated
                                         * with an unknown value.
                                         */
                                        _UNKNOWN,
                                    }

                                    /**
                                     * Returns an enum member corresponding to this class instance's
                                     * value, or [Value._UNKNOWN] if the class was instantiated with
                                     * an unknown value.
                                     *
                                     * Use the [known] method instead if you're certain the value is
                                     * always known or if you want to throw for the unknown case.
                                     */
                                    fun value(): Value =
                                        when (this) {
                                            CONTENT_BLOCK_LOCATION -> Value.CONTENT_BLOCK_LOCATION
                                            else -> Value._UNKNOWN
                                        }

                                    /**
                                     * Returns an enum member corresponding to this class instance's
                                     * value.
                                     *
                                     * Use the [value] method instead if you're uncertain the value
                                     * is always known and don't want to throw for the unknown case.
                                     *
                                     * @throws SamInvalidDataException if this class instance's
                                     *   value is a not a known member.
                                     */
                                    fun known(): Known =
                                        when (this) {
                                            CONTENT_BLOCK_LOCATION -> Known.CONTENT_BLOCK_LOCATION
                                            else ->
                                                throw SamInvalidDataException(
                                                    "Unknown Type: $value"
                                                )
                                        }

                                    /**
                                     * Returns this class instance's primitive wire representation.
                                     *
                                     * This differs from the [toString] method because that method
                                     * is primarily for debugging and generally doesn't throw.
                                     *
                                     * @throws SamInvalidDataException if this class instance's
                                     *   value does not have the expected primitive type.
                                     */
                                    fun asString(): String =
                                        _value().asString()
                                            ?: throw SamInvalidDataException(
                                                "Value is not a String"
                                            )

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

                                    return /* spotless:off */ other is ResponseContentBlockLocationCitation && citedText == other.citedText && documentIndex == other.documentIndex && documentTitle == other.documentTitle && endBlockIndex == other.endBlockIndex && startBlockIndex == other.startBlockIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(citedText, documentIndex, documentTitle, endBlockIndex, startBlockIndex, type, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "ResponseContentBlockLocationCitation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endBlockIndex=$endBlockIndex, startBlockIndex=$startBlockIndex, type=$type, additionalProperties=$additionalProperties}"
                            }
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val TEXT = of("text")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                TEXT
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                TEXT,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    TEXT -> Value.TEXT
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    TEXT -> Known.TEXT
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is ResponseTextBlock && citations == other.citations && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(citations, text, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ResponseTextBlock{citations=$citations, text=$text, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class ResponseToolUseBlock
                    private constructor(
                        private val id: JsonField<String>,
                        private val input: JsonValue,
                        private val name: JsonField<String>,
                        private val type: JsonField<Type>,
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
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
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
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

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

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [ResponseToolUseBlock].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .id()
                             * .input()
                             * .name()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ResponseToolUseBlock]. */
                        class Builder internal constructor() {

                            private var id: JsonField<String>? = null
                            private var input: JsonValue? = null
                            private var name: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(responseToolUseBlock: ResponseToolUseBlock) = apply {
                                id = responseToolUseBlock.id
                                input = responseToolUseBlock.input
                                name = responseToolUseBlock.name
                                type = responseToolUseBlock.type
                                additionalProperties =
                                    responseToolUseBlock.additionalProperties.toMutableMap()
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * Returns an immutable instance of [ResponseToolUseBlock].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .id()
                             * .input()
                             * .name()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ResponseToolUseBlock =
                                ResponseToolUseBlock(
                                    checkRequired("id", id),
                                    checkRequired("input", input),
                                    checkRequired("name", name),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ResponseToolUseBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            id()
                            name()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val TOOL_USE = of("tool_use")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                TOOL_USE
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                TOOL_USE,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    TOOL_USE -> Value.TOOL_USE
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    TOOL_USE -> Known.TOOL_USE
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is ResponseToolUseBlock && id == other.id && input == other.input && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(id, input, name, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ResponseToolUseBlock{id=$id, input=$input, name=$name, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class ResponseThinkingBlock
                    private constructor(
                        private val signature: JsonField<String>,
                        private val thinking: JsonField<String>,
                        private val type: JsonField<Type>,
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
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
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
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

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

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [ResponseThinkingBlock].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .signature()
                             * .thinking()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ResponseThinkingBlock]. */
                        class Builder internal constructor() {

                            private var signature: JsonField<String>? = null
                            private var thinking: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(responseThinkingBlock: ResponseThinkingBlock) =
                                apply {
                                    signature = responseThinkingBlock.signature
                                    thinking = responseThinkingBlock.thinking
                                    type = responseThinkingBlock.type
                                    additionalProperties =
                                        responseThinkingBlock.additionalProperties.toMutableMap()
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * Returns an immutable instance of [ResponseThinkingBlock].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .signature()
                             * .thinking()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ResponseThinkingBlock =
                                ResponseThinkingBlock(
                                    checkRequired("signature", signature),
                                    checkRequired("thinking", thinking),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ResponseThinkingBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            signature()
                            thinking()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val THINKING = of("thinking")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                THINKING
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                THINKING,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    THINKING -> Value.THINKING
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    THINKING -> Known.THINKING
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is ResponseThinkingBlock && signature == other.signature && thinking == other.thinking && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(signature, thinking, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ResponseThinkingBlock{signature=$signature, thinking=$thinking, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class ResponseRedactedThinkingBlock
                    private constructor(
                        private val data: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("data")
                            @ExcludeMissing
                            data: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(data, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun data(): String = data.getRequired("data")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [data].
                         *
                         * Unlike [data], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [ResponseRedactedThinkingBlock].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .data()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ResponseRedactedThinkingBlock]. */
                        class Builder internal constructor() {

                            private var data: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(
                                responseRedactedThinkingBlock: ResponseRedactedThinkingBlock
                            ) = apply {
                                data = responseRedactedThinkingBlock.data
                                type = responseRedactedThinkingBlock.type
                                additionalProperties =
                                    responseRedactedThinkingBlock.additionalProperties
                                        .toMutableMap()
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * Returns an immutable instance of [ResponseRedactedThinkingBlock].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .data()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ResponseRedactedThinkingBlock =
                                ResponseRedactedThinkingBlock(
                                    checkRequired("data", data),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ResponseRedactedThinkingBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            data()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val REDACTED_THINKING = of("redacted_thinking")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                REDACTED_THINKING
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                REDACTED_THINKING,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    REDACTED_THINKING -> Value.REDACTED_THINKING
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    REDACTED_THINKING -> Known.REDACTED_THINKING
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is ResponseRedactedThinkingBlock && data == other.data && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(data, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ResponseRedactedThinkingBlock{data=$data, type=$type, additionalProperties=$additionalProperties}"
                    }
                }

                /**
                 * Conversational role of the generated message.
                 *
                 * This will always be `"assistant"`.
                 */
                class Role @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

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

                        val ASSISTANT = of("assistant")

                        fun of(value: String) = Role(JsonField.of(value))
                    }

                    /** An enum containing [Role]'s known values. */
                    enum class Known {
                        ASSISTANT
                    }

                    /**
                     * An enum containing [Role]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Role] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        ASSISTANT,
                        /**
                         * An enum member indicating that [Role] was instantiated with an unknown
                         * value.
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
                            ASSISTANT -> Value.ASSISTANT
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
                            ASSISTANT -> Known.ASSISTANT
                            else -> throw SamInvalidDataException("Unknown Role: $value")
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

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Role && value == other.value /* spotless:on */
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /**
                 * The reason that we stopped.
                 *
                 * This may be one the following values:
                 * - `"end_turn"`: the model reached a natural stopping point
                 * - `"max_tokens"`: we exceeded the requested `max_tokens` or the model's maximum
                 * - `"stop_sequence"`: one of your provided custom `stop_sequences` was generated
                 * - `"tool_use"`: the model invoked one or more tools
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

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is StopReason && value == other.value /* spotless:on */
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()
                }

                /**
                 * Object type.
                 *
                 * For Messages, this is always `"message"`.
                 */
                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

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

                        val MESSAGE = of("message")

                        fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        MESSAGE
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        MESSAGE,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
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
                            MESSAGE -> Value.MESSAGE
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
                            MESSAGE -> Known.MESSAGE
                            else -> throw SamInvalidDataException("Unknown Type: $value")
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

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Type && value == other.value /* spotless:on */
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

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Usage && cacheCreationInputTokens == other.cacheCreationInputTokens && cacheReadInputTokens == other.cacheReadInputTokens && inputTokens == other.inputTokens && outputTokens == other.outputTokens && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(cacheCreationInputTokens, cacheReadInputTokens, inputTokens, outputTokens, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Usage{cacheCreationInputTokens=$cacheCreationInputTokens, cacheReadInputTokens=$cacheReadInputTokens, inputTokens=$inputTokens, outputTokens=$outputTokens, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Message && id == other.id && content == other.content && model == other.model && role == other.role && stopReason == other.stopReason && stopSequence == other.stopSequence && type == other.type && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(id, content, model, role, stopReason, stopSequence, type, usage, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Message{id=$id, content=$content, model=$model, role=$role, stopReason=$stopReason, stopSequence=$stopSequence, type=$type, usage=$usage, additionalProperties=$additionalProperties}"
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    val SUCCEEDED = of("succeeded")

                    fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    SUCCEEDED
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    SUCCEEDED,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        SUCCEEDED -> Value.SUCCEEDED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SamInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        SUCCEEDED -> Known.SUCCEEDED
                        else -> throw SamInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SamInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
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

                return /* spotless:off */ other is SucceededResult && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SucceededResult{message=$message, type=$type, additionalProperties=$additionalProperties}"
        }

        class ErroredResult
        private constructor(
            private val error: JsonField<Error>,
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            ) : this(error, type, mutableMapOf())

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun error(): Error = error.getRequired("error")

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

            /**
             * Returns the raw JSON value of [error].
             *
             * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

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
                 * Returns a mutable builder for constructing an instance of [ErroredResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .error()
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [ErroredResult]. */
            class Builder internal constructor() {

                private var error: JsonField<Error>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(erroredResult: ErroredResult) = apply {
                    error = erroredResult.error
                    type = erroredResult.type
                    additionalProperties = erroredResult.additionalProperties.toMutableMap()
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

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [ErroredResult].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .error()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ErroredResult =
                    ErroredResult(
                        checkRequired("error", error),
                        checkRequired("type", type),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ErroredResult = apply {
                if (validated) {
                    return@apply
                }

                error().validate()
                type()
                validated = true
            }

            class Error
            private constructor(
                private val error: JsonField<InnerError>,
                private val type: JsonField<Type>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("error")
                    @ExcludeMissing
                    error: JsonField<InnerError> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                ) : this(error, type, mutableMapOf())

                /**
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun error(): InnerError = error.getRequired("error")

                /**
                 * @throws SamInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): Type = type.getRequired("type")

                /**
                 * Returns the raw JSON value of [error].
                 *
                 * Unlike [error], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<InnerError> = error

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
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
                     * Returns a mutable builder for constructing an instance of [Error].
                     *
                     * The following fields are required:
                     * ```kotlin
                     * .error()
                     * .type()
                     * ```
                     */
                    fun builder() = Builder()
                }

                /** A builder for [Error]. */
                class Builder internal constructor() {

                    private var error: JsonField<InnerError>? = null
                    private var type: JsonField<Type>? = null
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
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.InvalidRequestError.Type.INVALID_REQUEST_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun invalidRequestError(message: String) =
                        error(
                            InnerError.InvalidRequestError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .InvalidRequestError
                                        .Type
                                        .INVALID_REQUEST_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /**
                     * Alias for calling [error] with `InnerError.ofAuthentication(authentication)`.
                     */
                    fun error(authentication: InnerError.AuthenticationError) =
                        error(InnerError.ofAuthentication(authentication))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.AuthenticationError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.AuthenticationError.Type.AUTHENTICATION_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun authenticationError(message: String) =
                        error(
                            InnerError.AuthenticationError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .AuthenticationError
                                        .Type
                                        .AUTHENTICATION_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /** Alias for calling [error] with `InnerError.ofBilling(billing)`. */
                    fun error(billing: InnerError.BillingError) =
                        error(InnerError.ofBilling(billing))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.BillingError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.BillingError.Type.BILLING_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun billingError(message: String) =
                        error(
                            InnerError.BillingError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .BillingError
                                        .Type
                                        .BILLING_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /** Alias for calling [error] with `InnerError.ofPermission(permission)`. */
                    fun error(permission: InnerError.PermissionError) =
                        error(InnerError.ofPermission(permission))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.PermissionError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.PermissionError.Type.PERMISSION_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun permissionError(message: String) =
                        error(
                            InnerError.PermissionError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .PermissionError
                                        .Type
                                        .PERMISSION_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /** Alias for calling [error] with `InnerError.ofNotFound(notFound)`. */
                    fun error(notFound: InnerError.NotFoundError) =
                        error(InnerError.ofNotFound(notFound))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.NotFoundError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.NotFoundError.Type.NOT_FOUND_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun notFoundError(message: String) =
                        error(
                            InnerError.NotFoundError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .NotFoundError
                                        .Type
                                        .NOT_FOUND_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /** Alias for calling [error] with `InnerError.ofRateLimit(rateLimit)`. */
                    fun error(rateLimit: InnerError.RateLimitError) =
                        error(InnerError.ofRateLimit(rateLimit))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.RateLimitError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.RateLimitError.Type.RATE_LIMIT_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun rateLimitError(message: String) =
                        error(
                            InnerError.RateLimitError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .RateLimitError
                                        .Type
                                        .RATE_LIMIT_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /**
                     * Alias for calling [error] with `InnerError.ofGatewayTimeout(gatewayTimeout)`.
                     */
                    fun error(gatewayTimeout: InnerError.GatewayTimeoutError) =
                        error(InnerError.ofGatewayTimeout(gatewayTimeout))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.GatewayTimeoutError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.GatewayTimeoutError.Type.TIMEOUT_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun gatewayTimeoutError(message: String) =
                        error(
                            InnerError.GatewayTimeoutError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .GatewayTimeoutError
                                        .Type
                                        .TIMEOUT_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /** Alias for calling [error] with `InnerError.ofApi(api)`. */
                    fun error(api: InnerError.ApiError) = error(InnerError.ofApi(api))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.ApiError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.ApiError.Type.API_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun apiError(message: String) =
                        error(
                            InnerError.ApiError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .ApiError
                                        .Type
                                        .API_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    /** Alias for calling [error] with `InnerError.ofOverloaded(overloaded)`. */
                    fun error(overloaded: InnerError.OverloadedError) =
                        error(InnerError.ofOverloaded(overloaded))

                    /**
                     * Alias for calling [error] with the following:
                     * ```kotlin
                     * InnerError.OverloadedError.builder()
                     *     .type(BatchResultsResponse.Result.ErroredResult.Error.InnerError.OverloadedError.Type.OVERLOADED_ERROR)
                     *     .message(message)
                     *     .build()
                     * ```
                     */
                    fun overloadedError(message: String) =
                        error(
                            InnerError.OverloadedError.builder()
                                .type(
                                    BatchResultsResponse.Result.ErroredResult.Error.InnerError
                                        .OverloadedError
                                        .Type
                                        .OVERLOADED_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun type(type: Type) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [Type] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<Type>) = apply { this.type = type }

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
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Error =
                        Error(
                            checkRequired("error", error),
                            checkRequired("type", type),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    error().validate()
                    type()
                    validated = true
                }

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
                    private val gatewayTimeout: GatewayTimeoutError? = null,
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

                    fun gatewayTimeout(): GatewayTimeoutError? = gatewayTimeout

                    fun api(): ApiError? = api

                    fun overloaded(): OverloadedError? = overloaded

                    fun isInvalidRequest(): Boolean = invalidRequest != null

                    fun isAuthentication(): Boolean = authentication != null

                    fun isBilling(): Boolean = billing != null

                    fun isPermission(): Boolean = permission != null

                    fun isNotFound(): Boolean = notFound != null

                    fun isRateLimit(): Boolean = rateLimit != null

                    fun isGatewayTimeout(): Boolean = gatewayTimeout != null

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

                    fun asGatewayTimeout(): GatewayTimeoutError =
                        gatewayTimeout.getOrThrow("gatewayTimeout")

                    fun asApi(): ApiError = api.getOrThrow("api")

                    fun asOverloaded(): OverloadedError = overloaded.getOrThrow("overloaded")

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            invalidRequest != null -> visitor.visitInvalidRequest(invalidRequest)
                            authentication != null -> visitor.visitAuthentication(authentication)
                            billing != null -> visitor.visitBilling(billing)
                            permission != null -> visitor.visitPermission(permission)
                            notFound != null -> visitor.visitNotFound(notFound)
                            rateLimit != null -> visitor.visitRateLimit(rateLimit)
                            gatewayTimeout != null -> visitor.visitGatewayTimeout(gatewayTimeout)
                            api != null -> visitor.visitApi(api)
                            overloaded != null -> visitor.visitOverloaded(overloaded)
                            else -> visitor.unknown(_json)
                        }
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

                                override fun visitGatewayTimeout(
                                    gatewayTimeout: GatewayTimeoutError
                                ) {
                                    gatewayTimeout.validate()
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

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is InnerError && invalidRequest == other.invalidRequest && authentication == other.authentication && billing == other.billing && permission == other.permission && notFound == other.notFound && rateLimit == other.rateLimit && gatewayTimeout == other.gatewayTimeout && api == other.api && overloaded == other.overloaded /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(invalidRequest, authentication, billing, permission, notFound, rateLimit, gatewayTimeout, api, overloaded) /* spotless:on */

                    override fun toString(): String =
                        when {
                            invalidRequest != null -> "InnerError{invalidRequest=$invalidRequest}"
                            authentication != null -> "InnerError{authentication=$authentication}"
                            billing != null -> "InnerError{billing=$billing}"
                            permission != null -> "InnerError{permission=$permission}"
                            notFound != null -> "InnerError{notFound=$notFound}"
                            rateLimit != null -> "InnerError{rateLimit=$rateLimit}"
                            gatewayTimeout != null -> "InnerError{gatewayTimeout=$gatewayTimeout}"
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

                        fun ofGatewayTimeout(gatewayTimeout: GatewayTimeoutError) =
                            InnerError(gatewayTimeout = gatewayTimeout)

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

                        fun visitGatewayTimeout(gatewayTimeout: GatewayTimeoutError): T

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
                                    return InnerError(
                                        invalidRequest =
                                            deserialize(
                                                node,
                                                jacksonTypeRef<InvalidRequestError>(),
                                            ),
                                        _json = json,
                                    )
                                }
                                "authentication_error" -> {
                                    return InnerError(
                                        authentication =
                                            deserialize(
                                                node,
                                                jacksonTypeRef<AuthenticationError>(),
                                            ),
                                        _json = json,
                                    )
                                }
                                "billing_error" -> {
                                    return InnerError(
                                        billing = deserialize(node, jacksonTypeRef<BillingError>()),
                                        _json = json,
                                    )
                                }
                                "permission_error" -> {
                                    return InnerError(
                                        permission =
                                            deserialize(node, jacksonTypeRef<PermissionError>()),
                                        _json = json,
                                    )
                                }
                                "not_found_error" -> {
                                    return InnerError(
                                        notFound =
                                            deserialize(node, jacksonTypeRef<NotFoundError>()),
                                        _json = json,
                                    )
                                }
                                "rate_limit_error" -> {
                                    return InnerError(
                                        rateLimit =
                                            deserialize(node, jacksonTypeRef<RateLimitError>()),
                                        _json = json,
                                    )
                                }
                                "timeout_error" -> {
                                    return InnerError(
                                        gatewayTimeout =
                                            deserialize(
                                                node,
                                                jacksonTypeRef<GatewayTimeoutError>(),
                                            ),
                                        _json = json,
                                    )
                                }
                                "api_error" -> {
                                    return InnerError(
                                        api = deserialize(node, jacksonTypeRef<ApiError>()),
                                        _json = json,
                                    )
                                }
                                "overloaded_error" -> {
                                    return InnerError(
                                        overloaded =
                                            deserialize(node, jacksonTypeRef<OverloadedError>()),
                                        _json = json,
                                    )
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
                                value.gatewayTimeout != null ->
                                    generator.writeObject(value.gatewayTimeout)
                                value.api != null -> generator.writeObject(value.api)
                                value.overloaded != null -> generator.writeObject(value.overloaded)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid InnerError")
                            }
                        }
                    }

                    class InvalidRequestError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [InvalidRequestError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [InvalidRequestError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): InvalidRequestError =
                                InvalidRequestError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): InvalidRequestError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val INVALID_REQUEST_ERROR = of("invalid_request_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                INVALID_REQUEST_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                INVALID_REQUEST_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    INVALID_REQUEST_ERROR -> Value.INVALID_REQUEST_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    INVALID_REQUEST_ERROR -> Known.INVALID_REQUEST_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is InvalidRequestError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "InvalidRequestError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class AuthenticationError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [AuthenticationError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [AuthenticationError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): AuthenticationError =
                                AuthenticationError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): AuthenticationError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val AUTHENTICATION_ERROR = of("authentication_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                AUTHENTICATION_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                AUTHENTICATION_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    AUTHENTICATION_ERROR -> Value.AUTHENTICATION_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    AUTHENTICATION_ERROR -> Known.AUTHENTICATION_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is AuthenticationError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "AuthenticationError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class BillingError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [BillingError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BillingError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): BillingError =
                                BillingError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): BillingError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val BILLING_ERROR = of("billing_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                BILLING_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                BILLING_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    BILLING_ERROR -> Value.BILLING_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    BILLING_ERROR -> Known.BILLING_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is BillingError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BillingError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class PermissionError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [PermissionError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [PermissionError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): PermissionError =
                                PermissionError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): PermissionError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val PERMISSION_ERROR = of("permission_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                PERMISSION_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                PERMISSION_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    PERMISSION_ERROR -> Value.PERMISSION_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    PERMISSION_ERROR -> Known.PERMISSION_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is PermissionError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "PermissionError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class NotFoundError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [NotFoundError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [NotFoundError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): NotFoundError =
                                NotFoundError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): NotFoundError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val NOT_FOUND_ERROR = of("not_found_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                NOT_FOUND_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                NOT_FOUND_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    NOT_FOUND_ERROR -> Value.NOT_FOUND_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    NOT_FOUND_ERROR -> Known.NOT_FOUND_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is NotFoundError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "NotFoundError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class RateLimitError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [RateLimitError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [RateLimitError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): RateLimitError =
                                RateLimitError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): RateLimitError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val RATE_LIMIT_ERROR = of("rate_limit_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                RATE_LIMIT_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                RATE_LIMIT_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    RATE_LIMIT_ERROR -> Value.RATE_LIMIT_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    RATE_LIMIT_ERROR -> Known.RATE_LIMIT_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is RateLimitError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "RateLimitError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class GatewayTimeoutError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [GatewayTimeoutError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [GatewayTimeoutError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(gatewayTimeoutError: GatewayTimeoutError) = apply {
                                message = gatewayTimeoutError.message
                                type = gatewayTimeoutError.type
                                additionalProperties =
                                    gatewayTimeoutError.additionalProperties.toMutableMap()
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * Returns an immutable instance of [GatewayTimeoutError].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): GatewayTimeoutError =
                                GatewayTimeoutError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): GatewayTimeoutError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val TIMEOUT_ERROR = of("timeout_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                TIMEOUT_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                TIMEOUT_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    TIMEOUT_ERROR -> Value.TIMEOUT_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    TIMEOUT_ERROR -> Known.TIMEOUT_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is GatewayTimeoutError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "GatewayTimeoutError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class ApiError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of [ApiError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [ApiError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): ApiError =
                                ApiError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): ApiError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val API_ERROR = of("api_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                API_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                API_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    API_ERROR -> Value.API_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    API_ERROR -> Known.API_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is ApiError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "ApiError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    class OverloadedError
                    private constructor(
                        private val message: JsonField<String>,
                        private val type: JsonField<Type>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("message")
                            @ExcludeMissing
                            message: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("type")
                            @ExcludeMissing
                            type: JsonField<Type> = JsonMissing.of(),
                        ) : this(message, type, mutableMapOf())

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun message(): String = message.getRequired("message")

                        /**
                         * @throws SamInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun type(): Type = type.getRequired("type")

                        /**
                         * Returns the raw JSON value of [message].
                         *
                         * Unlike [message], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        /**
                         * Returns the raw JSON value of [type].
                         *
                         * Unlike [type], this method doesn't throw if the JSON field has an
                         * unexpected type.
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
                             * Returns a mutable builder for constructing an instance of
                             * [OverloadedError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [OverloadedError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
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

                            fun type(type: Type) = type(JsonField.of(type))

                            /**
                             * Sets [Builder.type] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.type] with a well-typed [Type] value
                             * instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun type(type: JsonField<Type>) = apply { this.type = type }

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
                             * .type()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): OverloadedError =
                                OverloadedError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): OverloadedError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        class Type
                        @JsonCreator
                        private constructor(private val value: JsonField<String>) : Enum {

                            /**
                             * Returns this class instance's raw value.
                             *
                             * This is usually only useful if this instance was deserialized from
                             * data that doesn't match any known member, and you want to know that
                             * value. For example, if the SDK is on an older version than the API,
                             * then the API may respond with new members that the SDK is unaware of.
                             */
                            @com.fasterxml.jackson.annotation.JsonValue
                            fun _value(): JsonField<String> = value

                            companion object {

                                val OVERLOADED_ERROR = of("overloaded_error")

                                fun of(value: String) = Type(JsonField.of(value))
                            }

                            /** An enum containing [Type]'s known values. */
                            enum class Known {
                                OVERLOADED_ERROR
                            }

                            /**
                             * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                             * member.
                             *
                             * An instance of [Type] can contain an unknown value in a couple of
                             * cases:
                             * - It was deserialized from data that doesn't match any known member.
                             *   For example, if the SDK is on an older version than the API, then
                             *   the API may respond with new members that the SDK is unaware of.
                             * - It was constructed with an arbitrary value using the [of] method.
                             */
                            enum class Value {
                                OVERLOADED_ERROR,
                                /**
                                 * An enum member indicating that [Type] was instantiated with an
                                 * unknown value.
                                 */
                                _UNKNOWN,
                            }

                            /**
                             * Returns an enum member corresponding to this class instance's value,
                             * or [Value._UNKNOWN] if the class was instantiated with an unknown
                             * value.
                             *
                             * Use the [known] method instead if you're certain the value is always
                             * known or if you want to throw for the unknown case.
                             */
                            fun value(): Value =
                                when (this) {
                                    OVERLOADED_ERROR -> Value.OVERLOADED_ERROR
                                    else -> Value._UNKNOWN
                                }

                            /**
                             * Returns an enum member corresponding to this class instance's value.
                             *
                             * Use the [value] method instead if you're uncertain the value is
                             * always known and don't want to throw for the unknown case.
                             *
                             * @throws SamInvalidDataException if this class instance's value is a
                             *   not a known member.
                             */
                            fun known(): Known =
                                when (this) {
                                    OVERLOADED_ERROR -> Known.OVERLOADED_ERROR
                                    else -> throw SamInvalidDataException("Unknown Type: $value")
                                }

                            /**
                             * Returns this class instance's primitive wire representation.
                             *
                             * This differs from the [toString] method because that method is
                             * primarily for debugging and generally doesn't throw.
                             *
                             * @throws SamInvalidDataException if this class instance's value does
                             *   not have the expected primitive type.
                             */
                            fun asString(): String =
                                _value().asString()
                                    ?: throw SamInvalidDataException("Value is not a String")

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

                            return /* spotless:off */ other is OverloadedError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "OverloadedError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }
                }

                class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                    Enum {

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

                        val ERROR = of("error")

                        fun of(value: String) = Type(JsonField.of(value))
                    }

                    /** An enum containing [Type]'s known values. */
                    enum class Known {
                        ERROR
                    }

                    /**
                     * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                     *
                     * An instance of [Type] can contain an unknown value in a couple of cases:
                     * - It was deserialized from data that doesn't match any known member. For
                     *   example, if the SDK is on an older version than the API, then the API may
                     *   respond with new members that the SDK is unaware of.
                     * - It was constructed with an arbitrary value using the [of] method.
                     */
                    enum class Value {
                        ERROR,
                        /**
                         * An enum member indicating that [Type] was instantiated with an unknown
                         * value.
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
                            ERROR -> Value.ERROR
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
                            ERROR -> Known.ERROR
                            else -> throw SamInvalidDataException("Unknown Type: $value")
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

                    return /* spotless:off */ other is Error && error == other.error && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(error, type, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Error{error=$error, type=$type, additionalProperties=$additionalProperties}"
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    val ERRORED = of("errored")

                    fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    ERRORED
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ERRORED,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ERRORED -> Value.ERRORED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SamInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        ERRORED -> Known.ERRORED
                        else -> throw SamInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SamInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
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

                return /* spotless:off */ other is ErroredResult && error == other.error && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(error, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ErroredResult{error=$error, type=$type, additionalProperties=$additionalProperties}"
        }

        class CanceledResult
        private constructor(
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
            ) : this(type, mutableMapOf())

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

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
                 * Returns a mutable builder for constructing an instance of [CanceledResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [CanceledResult]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(canceledResult: CanceledResult) = apply {
                    type = canceledResult.type
                    additionalProperties = canceledResult.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [CanceledResult].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): CanceledResult =
                    CanceledResult(checkRequired("type", type), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): CanceledResult = apply {
                if (validated) {
                    return@apply
                }

                type()
                validated = true
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    val CANCELED = of("canceled")

                    fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    CANCELED
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    CANCELED,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        CANCELED -> Value.CANCELED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SamInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        CANCELED -> Known.CANCELED
                        else -> throw SamInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SamInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
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

                return /* spotless:off */ other is CanceledResult && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CanceledResult{type=$type, additionalProperties=$additionalProperties}"
        }

        class ExpiredResult
        private constructor(
            private val type: JsonField<Type>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of()
            ) : this(type, mutableMapOf())

            /**
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): Type = type.getRequired("type")

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
                 * Returns a mutable builder for constructing an instance of [ExpiredResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [ExpiredResult]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(expiredResult: ExpiredResult) = apply {
                    type = expiredResult.type
                    additionalProperties = expiredResult.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

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
                 * Returns an immutable instance of [ExpiredResult].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ExpiredResult =
                    ExpiredResult(checkRequired("type", type), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ExpiredResult = apply {
                if (validated) {
                    return@apply
                }

                type()
                validated = true
            }

            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    val EXPIRED = of("expired")

                    fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    EXPIRED
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    EXPIRED,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        EXPIRED -> Value.EXPIRED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws SamInvalidDataException if this class instance's value is a not a known
                 *   member.
                 */
                fun known(): Known =
                    when (this) {
                        EXPIRED -> Known.EXPIRED
                        else -> throw SamInvalidDataException("Unknown Type: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws SamInvalidDataException if this class instance's value does not have the
                 *   expected primitive type.
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

                return /* spotless:off */ other is ExpiredResult && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ExpiredResult{type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchResultsResponse && customId == other.customId && result == other.result && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(customId, result, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchResultsResponse{customId=$customId, result=$result, additionalProperties=$additionalProperties}"
}
