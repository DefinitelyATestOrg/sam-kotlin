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
import java.util.Objects
import me.elborai.api.core.BaseDeserializer
import me.elborai.api.core.BaseSerializer
import me.elborai.api.core.Enum
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.NoAutoDetect
import me.elborai.api.core.checkKnown
import me.elborai.api.core.checkRequired
import me.elborai.api.core.getOrThrow
import me.elborai.api.core.immutableEmptyMap
import me.elborai.api.core.toImmutable
import me.elborai.api.errors.SamInvalidDataException

/**
 * This is a single line in the response `.jsonl` file and does not represent the response as a
 * whole.
 */
@NoAutoDetect
class BatchResultsBetaResponse
@JsonCreator
private constructor(
    @JsonProperty("custom_id")
    @ExcludeMissing
    private val customId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("result")
    @ExcludeMissing
    private val result: JsonField<Result> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Developer-provided ID created for each request in a Message Batch. Useful for matching
     * results to requests, as results may be given out of request order.
     *
     * Must be unique for each request within the Message Batch.
     */
    fun customId(): String = customId.getRequired("custom_id")

    /**
     * Processing result for this request.
     *
     * Contains a Message output if processing was successful, an error response if processing
     * failed, or the reason why processing was not attempted, such as cancellation or expiration.
     */
    fun result(): Result = result.getRequired("result")

    /**
     * Developer-provided ID created for each request in a Message Batch. Useful for matching
     * results to requests, as results may be given out of request order.
     *
     * Must be unique for each request within the Message Batch.
     */
    @JsonProperty("custom_id") @ExcludeMissing fun _customId(): JsonField<String> = customId

    /**
     * Processing result for this request.
     *
     * Contains a Message output if processing was successful, an error response if processing
     * failed, or the reason why processing was not attempted, such as cancellation or expiration.
     */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<Result> = result

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): BatchResultsBetaResponse = apply {
        if (validated) {
            return@apply
        }

        customId()
        result().validate()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchResultsBetaResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .customId()
         * .result()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [BatchResultsBetaResponse]. */
    class Builder internal constructor() {

        private var customId: JsonField<String>? = null
        private var result: JsonField<Result>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(batchResultsBetaResponse: BatchResultsBetaResponse) = apply {
            customId = batchResultsBetaResponse.customId
            result = batchResultsBetaResponse.result
            additionalProperties = batchResultsBetaResponse.additionalProperties.toMutableMap()
        }

        /**
         * Developer-provided ID created for each request in a Message Batch. Useful for matching
         * results to requests, as results may be given out of request order.
         *
         * Must be unique for each request within the Message Batch.
         */
        fun customId(customId: String) = customId(JsonField.of(customId))

        /**
         * Developer-provided ID created for each request in a Message Batch. Useful for matching
         * results to requests, as results may be given out of request order.
         *
         * Must be unique for each request within the Message Batch.
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
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun result(result: JsonField<Result>) = apply { this.result = result }

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun result(betaSucceeded: Result.BetaSucceededResult) =
            result(Result.ofBetaSucceeded(betaSucceeded))

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun betaSucceededResult(message: Result.BetaSucceededResult.Message) =
            result(
                Result.BetaSucceededResult.builder()
                    .type(BatchResultsBetaResponse.Result.BetaSucceededResult.Type.SUCCEEDED)
                    .message(message)
                    .build()
            )

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun result(betaErrored: Result.BetaErroredResult) =
            result(Result.ofBetaErrored(betaErrored))

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun betaErroredResult(error: Result.BetaErroredResult.Error) =
            result(
                Result.BetaErroredResult.builder()
                    .type(BatchResultsBetaResponse.Result.BetaErroredResult.Type.ERRORED)
                    .error(error)
                    .build()
            )

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun result(betaCanceled: Result.BetaCanceledResult) =
            result(Result.ofBetaCanceled(betaCanceled))

        /**
         * Processing result for this request.
         *
         * Contains a Message output if processing was successful, an error response if processing
         * failed, or the reason why processing was not attempted, such as cancellation or
         * expiration.
         */
        fun result(betaExpired: Result.BetaExpiredResult) =
            result(Result.ofBetaExpired(betaExpired))

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

        fun build(): BatchResultsBetaResponse =
            BatchResultsBetaResponse(
                checkRequired("customId", customId),
                checkRequired("result", result),
                additionalProperties.toImmutable(),
            )
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
        private val betaSucceeded: BetaSucceededResult? = null,
        private val betaErrored: BetaErroredResult? = null,
        private val betaCanceled: BetaCanceledResult? = null,
        private val betaExpired: BetaExpiredResult? = null,
        private val _json: JsonValue? = null,
    ) {

        fun betaSucceeded(): BetaSucceededResult? = betaSucceeded

        fun betaErrored(): BetaErroredResult? = betaErrored

        fun betaCanceled(): BetaCanceledResult? = betaCanceled

        fun betaExpired(): BetaExpiredResult? = betaExpired

        fun isBetaSucceeded(): Boolean = betaSucceeded != null

        fun isBetaErrored(): Boolean = betaErrored != null

        fun isBetaCanceled(): Boolean = betaCanceled != null

        fun isBetaExpired(): Boolean = betaExpired != null

        fun asBetaSucceeded(): BetaSucceededResult = betaSucceeded.getOrThrow("betaSucceeded")

        fun asBetaErrored(): BetaErroredResult = betaErrored.getOrThrow("betaErrored")

        fun asBetaCanceled(): BetaCanceledResult = betaCanceled.getOrThrow("betaCanceled")

        fun asBetaExpired(): BetaExpiredResult = betaExpired.getOrThrow("betaExpired")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                betaSucceeded != null -> visitor.visitBetaSucceeded(betaSucceeded)
                betaErrored != null -> visitor.visitBetaErrored(betaErrored)
                betaCanceled != null -> visitor.visitBetaCanceled(betaCanceled)
                betaExpired != null -> visitor.visitBetaExpired(betaExpired)
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
                    override fun visitBetaSucceeded(betaSucceeded: BetaSucceededResult) {
                        betaSucceeded.validate()
                    }

                    override fun visitBetaErrored(betaErrored: BetaErroredResult) {
                        betaErrored.validate()
                    }

                    override fun visitBetaCanceled(betaCanceled: BetaCanceledResult) {
                        betaCanceled.validate()
                    }

                    override fun visitBetaExpired(betaExpired: BetaExpiredResult) {
                        betaExpired.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Result && betaSucceeded == other.betaSucceeded && betaErrored == other.betaErrored && betaCanceled == other.betaCanceled && betaExpired == other.betaExpired /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(betaSucceeded, betaErrored, betaCanceled, betaExpired) /* spotless:on */

        override fun toString(): String =
            when {
                betaSucceeded != null -> "Result{betaSucceeded=$betaSucceeded}"
                betaErrored != null -> "Result{betaErrored=$betaErrored}"
                betaCanceled != null -> "Result{betaCanceled=$betaCanceled}"
                betaExpired != null -> "Result{betaExpired=$betaExpired}"
                _json != null -> "Result{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Result")
            }

        companion object {

            fun ofBetaSucceeded(betaSucceeded: BetaSucceededResult) =
                Result(betaSucceeded = betaSucceeded)

            fun ofBetaErrored(betaErrored: BetaErroredResult) = Result(betaErrored = betaErrored)

            fun ofBetaCanceled(betaCanceled: BetaCanceledResult) =
                Result(betaCanceled = betaCanceled)

            fun ofBetaExpired(betaExpired: BetaExpiredResult) = Result(betaExpired = betaExpired)
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBetaSucceeded(betaSucceeded: BetaSucceededResult): T

            fun visitBetaErrored(betaErrored: BetaErroredResult): T

            fun visitBetaCanceled(betaCanceled: BetaCanceledResult): T

            fun visitBetaExpired(betaExpired: BetaExpiredResult): T

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
                        tryDeserialize(node, jacksonTypeRef<BetaSucceededResult>()) {
                                it.validate()
                            }
                            ?.let {
                                return Result(betaSucceeded = it, _json = json)
                            }
                    }
                    "errored" -> {
                        tryDeserialize(node, jacksonTypeRef<BetaErroredResult>()) { it.validate() }
                            ?.let {
                                return Result(betaErrored = it, _json = json)
                            }
                    }
                    "canceled" -> {
                        tryDeserialize(node, jacksonTypeRef<BetaCanceledResult>()) { it.validate() }
                            ?.let {
                                return Result(betaCanceled = it, _json = json)
                            }
                    }
                    "expired" -> {
                        tryDeserialize(node, jacksonTypeRef<BetaExpiredResult>()) { it.validate() }
                            ?.let {
                                return Result(betaExpired = it, _json = json)
                            }
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
                    value.betaSucceeded != null -> generator.writeObject(value.betaSucceeded)
                    value.betaErrored != null -> generator.writeObject(value.betaErrored)
                    value.betaCanceled != null -> generator.writeObject(value.betaCanceled)
                    value.betaExpired != null -> generator.writeObject(value.betaExpired)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Result")
                }
            }
        }

        @NoAutoDetect
        class BetaSucceededResult
        @JsonCreator
        private constructor(
            @JsonProperty("message")
            @ExcludeMissing
            private val message: JsonField<Message> = JsonMissing.of(),
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun message(): Message = message.getRequired("message")

            fun type(): Type = type.getRequired("type")

            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<Message> = message

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): BetaSucceededResult = apply {
                if (validated) {
                    return@apply
                }

                message().validate()
                type()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [BetaSucceededResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .message()
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [BetaSucceededResult]. */
            class Builder internal constructor() {

                private var message: JsonField<Message>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(betaSucceededResult: BetaSucceededResult) = apply {
                    message = betaSucceededResult.message
                    type = betaSucceededResult.type
                    additionalProperties = betaSucceededResult.additionalProperties.toMutableMap()
                }

                fun message(message: Message) = message(JsonField.of(message))

                fun message(message: JsonField<Message>) = apply { this.message = message }

                fun type(type: Type) = type(JsonField.of(type))

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

                fun build(): BetaSucceededResult =
                    BetaSucceededResult(
                        checkRequired("message", message),
                        checkRequired("type", type),
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class Message
            @JsonCreator
            private constructor(
                @JsonProperty("id")
                @ExcludeMissing
                private val id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("content")
                @ExcludeMissing
                private val content: JsonField<List<Content>> = JsonMissing.of(),
                @JsonProperty("model")
                @ExcludeMissing
                private val model: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role")
                @ExcludeMissing
                private val role: JsonField<Role> = JsonMissing.of(),
                @JsonProperty("stop_reason")
                @ExcludeMissing
                private val stopReason: JsonField<StopReason> = JsonMissing.of(),
                @JsonProperty("stop_sequence")
                @ExcludeMissing
                private val stopSequence: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("usage")
                @ExcludeMissing
                private val usage: JsonField<Usage> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /**
                 * Unique object identifier.
                 *
                 * The format and length of IDs may change over time.
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
                 */
                fun content(): List<Content> = content.getRequired("content")

                /** The model that handled the request. */
                fun model(): String = model.getRequired("model")

                /**
                 * Conversational role of the generated message.
                 *
                 * This will always be `"assistant"`.
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
                 */
                fun stopReason(): StopReason? = stopReason.getNullable("stop_reason")

                /**
                 * Which custom stop sequence was generated, if any.
                 *
                 * This value will be a non-null string if one of your custom stop sequences was
                 * generated.
                 */
                fun stopSequence(): String? = stopSequence.getNullable("stop_sequence")

                /**
                 * Object type.
                 *
                 * For Messages, this is always `"message"`.
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
                 */
                fun usage(): Usage = usage.getRequired("usage")

                /**
                 * Unique object identifier.
                 *
                 * The format and length of IDs may change over time.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
                 */
                @JsonProperty("content")
                @ExcludeMissing
                fun _content(): JsonField<List<Content>> = content

                /** The model that handled the request. */
                @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

                /**
                 * Conversational role of the generated message.
                 *
                 * This will always be `"assistant"`.
                 */
                @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<Role> = role

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
                @JsonProperty("stop_reason")
                @ExcludeMissing
                fun _stopReason(): JsonField<StopReason> = stopReason

                /**
                 * Which custom stop sequence was generated, if any.
                 *
                 * This value will be a non-null string if one of your custom stop sequences was
                 * generated.
                 */
                @JsonProperty("stop_sequence")
                @ExcludeMissing
                fun _stopSequence(): JsonField<String> = stopSequence

                /**
                 * Object type.
                 *
                 * For Messages, this is always `"message"`.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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
                     * Unique object identifier.
                     *
                     * The format and length of IDs may change over time.
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
                    fun content(content: JsonField<List<Content>>) = apply {
                        this.content = content.map { it.toMutableList() }
                    }

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
                    fun addContent(content: Content) = apply {
                        this.content =
                            (this.content ?: JsonField.of(mutableListOf())).also {
                                checkKnown("content", it).add(content)
                            }
                    }

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
                    fun addContent(betaResponseTextBlock: Content.BetaResponseTextBlock) =
                        addContent(Content.ofBetaResponseTextBlock(betaResponseTextBlock))

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
                    fun addContent(betaResponseToolUseBlock: Content.BetaResponseToolUseBlock) =
                        addContent(Content.ofBetaResponseToolUseBlock(betaResponseToolUseBlock))

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
                    fun addContent(betaResponseThinkingBlock: Content.BetaResponseThinkingBlock) =
                        addContent(Content.ofBetaResponseThinkingBlock(betaResponseThinkingBlock))

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
                    fun addContent(
                        betaResponseRedactedThinkingBlock: Content.BetaResponseRedactedThinkingBlock
                    ) =
                        addContent(
                            Content.ofBetaResponseRedactedThinkingBlock(
                                betaResponseRedactedThinkingBlock
                            )
                        )

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
                    fun addBetaResponseRedactedThinkingBlockContent(data: String) =
                        addContent(
                            Content.BetaResponseRedactedThinkingBlock.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaSucceededResult.Message
                                        .Content
                                        .BetaResponseRedactedThinkingBlock
                                        .Type
                                        .REDACTED_THINKING
                                )
                                .data(data)
                                .build()
                        )

                    /** The model that handled the request. */
                    fun model(model: String) = model(JsonField.of(model))

                    /** The model that handled the request. */
                    fun model(model: JsonField<String>) = apply { this.model = model }

                    /**
                     * Conversational role of the generated message.
                     *
                     * This will always be `"assistant"`.
                     */
                    fun role(role: Role) = role(JsonField.of(role))

                    /**
                     * Conversational role of the generated message.
                     *
                     * This will always be `"assistant"`.
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
                     * Which custom stop sequence was generated, if any.
                     *
                     * This value will be a non-null string if one of your custom stop sequences was
                     * generated.
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
                     * Object type.
                     *
                     * For Messages, this is always `"message"`.
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
                            additionalProperties.toImmutable(),
                        )
                }

                @JsonDeserialize(using = Content.Deserializer::class)
                @JsonSerialize(using = Content.Serializer::class)
                class Content
                private constructor(
                    private val betaResponseTextBlock: BetaResponseTextBlock? = null,
                    private val betaResponseToolUseBlock: BetaResponseToolUseBlock? = null,
                    private val betaResponseThinkingBlock: BetaResponseThinkingBlock? = null,
                    private val betaResponseRedactedThinkingBlock:
                        BetaResponseRedactedThinkingBlock? =
                        null,
                    private val _json: JsonValue? = null,
                ) {

                    fun betaResponseTextBlock(): BetaResponseTextBlock? = betaResponseTextBlock

                    fun betaResponseToolUseBlock(): BetaResponseToolUseBlock? =
                        betaResponseToolUseBlock

                    fun betaResponseThinkingBlock(): BetaResponseThinkingBlock? =
                        betaResponseThinkingBlock

                    fun betaResponseRedactedThinkingBlock(): BetaResponseRedactedThinkingBlock? =
                        betaResponseRedactedThinkingBlock

                    fun isBetaResponseTextBlock(): Boolean = betaResponseTextBlock != null

                    fun isBetaResponseToolUseBlock(): Boolean = betaResponseToolUseBlock != null

                    fun isBetaResponseThinkingBlock(): Boolean = betaResponseThinkingBlock != null

                    fun isBetaResponseRedactedThinkingBlock(): Boolean =
                        betaResponseRedactedThinkingBlock != null

                    fun asBetaResponseTextBlock(): BetaResponseTextBlock =
                        betaResponseTextBlock.getOrThrow("betaResponseTextBlock")

                    fun asBetaResponseToolUseBlock(): BetaResponseToolUseBlock =
                        betaResponseToolUseBlock.getOrThrow("betaResponseToolUseBlock")

                    fun asBetaResponseThinkingBlock(): BetaResponseThinkingBlock =
                        betaResponseThinkingBlock.getOrThrow("betaResponseThinkingBlock")

                    fun asBetaResponseRedactedThinkingBlock(): BetaResponseRedactedThinkingBlock =
                        betaResponseRedactedThinkingBlock.getOrThrow(
                            "betaResponseRedactedThinkingBlock"
                        )

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            betaResponseTextBlock != null ->
                                visitor.visitBetaResponseTextBlock(betaResponseTextBlock)
                            betaResponseToolUseBlock != null ->
                                visitor.visitBetaResponseToolUseBlock(betaResponseToolUseBlock)
                            betaResponseThinkingBlock != null ->
                                visitor.visitBetaResponseThinkingBlock(betaResponseThinkingBlock)
                            betaResponseRedactedThinkingBlock != null ->
                                visitor.visitBetaResponseRedactedThinkingBlock(
                                    betaResponseRedactedThinkingBlock
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
                                override fun visitBetaResponseTextBlock(
                                    betaResponseTextBlock: BetaResponseTextBlock
                                ) {
                                    betaResponseTextBlock.validate()
                                }

                                override fun visitBetaResponseToolUseBlock(
                                    betaResponseToolUseBlock: BetaResponseToolUseBlock
                                ) {
                                    betaResponseToolUseBlock.validate()
                                }

                                override fun visitBetaResponseThinkingBlock(
                                    betaResponseThinkingBlock: BetaResponseThinkingBlock
                                ) {
                                    betaResponseThinkingBlock.validate()
                                }

                                override fun visitBetaResponseRedactedThinkingBlock(
                                    betaResponseRedactedThinkingBlock:
                                        BetaResponseRedactedThinkingBlock
                                ) {
                                    betaResponseRedactedThinkingBlock.validate()
                                }
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Content && betaResponseTextBlock == other.betaResponseTextBlock && betaResponseToolUseBlock == other.betaResponseToolUseBlock && betaResponseThinkingBlock == other.betaResponseThinkingBlock && betaResponseRedactedThinkingBlock == other.betaResponseRedactedThinkingBlock /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(betaResponseTextBlock, betaResponseToolUseBlock, betaResponseThinkingBlock, betaResponseRedactedThinkingBlock) /* spotless:on */

                    override fun toString(): String =
                        when {
                            betaResponseTextBlock != null ->
                                "Content{betaResponseTextBlock=$betaResponseTextBlock}"
                            betaResponseToolUseBlock != null ->
                                "Content{betaResponseToolUseBlock=$betaResponseToolUseBlock}"
                            betaResponseThinkingBlock != null ->
                                "Content{betaResponseThinkingBlock=$betaResponseThinkingBlock}"
                            betaResponseRedactedThinkingBlock != null ->
                                "Content{betaResponseRedactedThinkingBlock=$betaResponseRedactedThinkingBlock}"
                            _json != null -> "Content{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid Content")
                        }

                    companion object {

                        fun ofBetaResponseTextBlock(betaResponseTextBlock: BetaResponseTextBlock) =
                            Content(betaResponseTextBlock = betaResponseTextBlock)

                        fun ofBetaResponseToolUseBlock(
                            betaResponseToolUseBlock: BetaResponseToolUseBlock
                        ) = Content(betaResponseToolUseBlock = betaResponseToolUseBlock)

                        fun ofBetaResponseThinkingBlock(
                            betaResponseThinkingBlock: BetaResponseThinkingBlock
                        ) = Content(betaResponseThinkingBlock = betaResponseThinkingBlock)

                        fun ofBetaResponseRedactedThinkingBlock(
                            betaResponseRedactedThinkingBlock: BetaResponseRedactedThinkingBlock
                        ) =
                            Content(
                                betaResponseRedactedThinkingBlock =
                                    betaResponseRedactedThinkingBlock
                            )
                    }

                    /**
                     * An interface that defines how to map each variant of [Content] to a value of
                     * type [T].
                     */
                    interface Visitor<out T> {

                        fun visitBetaResponseTextBlock(
                            betaResponseTextBlock: BetaResponseTextBlock
                        ): T

                        fun visitBetaResponseToolUseBlock(
                            betaResponseToolUseBlock: BetaResponseToolUseBlock
                        ): T

                        fun visitBetaResponseThinkingBlock(
                            betaResponseThinkingBlock: BetaResponseThinkingBlock
                        ): T

                        fun visitBetaResponseRedactedThinkingBlock(
                            betaResponseRedactedThinkingBlock: BetaResponseRedactedThinkingBlock
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
                                    tryDeserialize(node, jacksonTypeRef<BetaResponseTextBlock>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return Content(betaResponseTextBlock = it, _json = json)
                                        }
                                }
                                "tool_use" -> {
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<BetaResponseToolUseBlock>(),
                                        ) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return Content(
                                                betaResponseToolUseBlock = it,
                                                _json = json,
                                            )
                                        }
                                }
                                "thinking" -> {
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<BetaResponseThinkingBlock>(),
                                        ) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return Content(
                                                betaResponseThinkingBlock = it,
                                                _json = json,
                                            )
                                        }
                                }
                                "redacted_thinking" -> {
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<BetaResponseRedactedThinkingBlock>(),
                                        ) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return Content(
                                                betaResponseRedactedThinkingBlock = it,
                                                _json = json,
                                            )
                                        }
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
                                value.betaResponseTextBlock != null ->
                                    generator.writeObject(value.betaResponseTextBlock)
                                value.betaResponseToolUseBlock != null ->
                                    generator.writeObject(value.betaResponseToolUseBlock)
                                value.betaResponseThinkingBlock != null ->
                                    generator.writeObject(value.betaResponseThinkingBlock)
                                value.betaResponseRedactedThinkingBlock != null ->
                                    generator.writeObject(value.betaResponseRedactedThinkingBlock)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid Content")
                            }
                        }
                    }

                    @NoAutoDetect
                    class BetaResponseTextBlock
                    @JsonCreator
                    private constructor(
                        @JsonProperty("citations")
                        @ExcludeMissing
                        private val citations: JsonField<List<Citation>> = JsonMissing.of(),
                        @JsonProperty("text")
                        @ExcludeMissing
                        private val text: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        /**
                         * Citations supporting the text block.
                         *
                         * The type of citation returned will depend on the type of document being
                         * cited. Citing a PDF results in `page_location`, plain text results in
                         * `char_location`, and content document results in
                         * `content_block_location`.
                         */
                        fun citations(): List<Citation>? = citations.getNullable("citations")

                        fun text(): String = text.getRequired("text")

                        fun type(): Type = type.getRequired("type")

                        /**
                         * Citations supporting the text block.
                         *
                         * The type of citation returned will depend on the type of document being
                         * cited. Citing a PDF results in `page_location`, plain text results in
                         * `char_location`, and content document results in
                         * `content_block_location`.
                         */
                        @JsonProperty("citations")
                        @ExcludeMissing
                        fun _citations(): JsonField<List<Citation>> = citations

                        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaResponseTextBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            citations()?.forEach { it.validate() }
                            text()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaResponseTextBlock].
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

                        /** A builder for [BetaResponseTextBlock]. */
                        class Builder internal constructor() {

                            private var citations: JsonField<MutableList<Citation>>? = null
                            private var text: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaResponseTextBlock: BetaResponseTextBlock) =
                                apply {
                                    citations =
                                        betaResponseTextBlock.citations.map { it.toMutableList() }
                                    text = betaResponseTextBlock.text
                                    type = betaResponseTextBlock.type
                                    additionalProperties =
                                        betaResponseTextBlock.additionalProperties.toMutableMap()
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
                             * Citations supporting the text block.
                             *
                             * The type of citation returned will depend on the type of document
                             * being cited. Citing a PDF results in `page_location`, plain text
                             * results in `char_location`, and content document results in
                             * `content_block_location`.
                             */
                            fun citations(citations: JsonField<List<Citation>>) = apply {
                                this.citations = citations.map { it.toMutableList() }
                            }

                            /**
                             * Citations supporting the text block.
                             *
                             * The type of citation returned will depend on the type of document
                             * being cited. Citing a PDF results in `page_location`, plain text
                             * results in `char_location`, and content document results in
                             * `content_block_location`.
                             */
                            fun addCitation(citation: Citation) = apply {
                                citations =
                                    (citations ?: JsonField.of(mutableListOf())).also {
                                        checkKnown("citations", it).add(citation)
                                    }
                            }

                            /**
                             * Citations supporting the text block.
                             *
                             * The type of citation returned will depend on the type of document
                             * being cited. Citing a PDF results in `page_location`, plain text
                             * results in `char_location`, and content document results in
                             * `content_block_location`.
                             */
                            fun addCitation(
                                betaResponseCharLocation: Citation.BetaResponseCharLocationCitation
                            ) =
                                addCitation(
                                    Citation.ofBetaResponseCharLocation(betaResponseCharLocation)
                                )

                            /**
                             * Citations supporting the text block.
                             *
                             * The type of citation returned will depend on the type of document
                             * being cited. Citing a PDF results in `page_location`, plain text
                             * results in `char_location`, and content document results in
                             * `content_block_location`.
                             */
                            fun addCitation(
                                betaResponsePageLocation: Citation.BetaResponsePageLocationCitation
                            ) =
                                addCitation(
                                    Citation.ofBetaResponsePageLocation(betaResponsePageLocation)
                                )

                            /**
                             * Citations supporting the text block.
                             *
                             * The type of citation returned will depend on the type of document
                             * being cited. Citing a PDF results in `page_location`, plain text
                             * results in `char_location`, and content document results in
                             * `content_block_location`.
                             */
                            fun addCitation(
                                betaResponseContentBlockLocation:
                                    Citation.BetaResponseContentBlockLocationCitation
                            ) =
                                addCitation(
                                    Citation.ofBetaResponseContentBlockLocation(
                                        betaResponseContentBlockLocation
                                    )
                                )

                            fun text(text: String) = text(JsonField.of(text))

                            fun text(text: JsonField<String>) = apply { this.text = text }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaResponseTextBlock =
                                BetaResponseTextBlock(
                                    checkRequired("citations", citations).map { it.toImmutable() },
                                    checkRequired("text", text),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
                        }

                        @JsonDeserialize(using = Citation.Deserializer::class)
                        @JsonSerialize(using = Citation.Serializer::class)
                        class Citation
                        private constructor(
                            private val betaResponseCharLocation:
                                BetaResponseCharLocationCitation? =
                                null,
                            private val betaResponsePageLocation:
                                BetaResponsePageLocationCitation? =
                                null,
                            private val betaResponseContentBlockLocation:
                                BetaResponseContentBlockLocationCitation? =
                                null,
                            private val _json: JsonValue? = null,
                        ) {

                            fun betaResponseCharLocation(): BetaResponseCharLocationCitation? =
                                betaResponseCharLocation

                            fun betaResponsePageLocation(): BetaResponsePageLocationCitation? =
                                betaResponsePageLocation

                            fun betaResponseContentBlockLocation():
                                BetaResponseContentBlockLocationCitation? =
                                betaResponseContentBlockLocation

                            fun isBetaResponseCharLocation(): Boolean =
                                betaResponseCharLocation != null

                            fun isBetaResponsePageLocation(): Boolean =
                                betaResponsePageLocation != null

                            fun isBetaResponseContentBlockLocation(): Boolean =
                                betaResponseContentBlockLocation != null

                            fun asBetaResponseCharLocation(): BetaResponseCharLocationCitation =
                                betaResponseCharLocation.getOrThrow("betaResponseCharLocation")

                            fun asBetaResponsePageLocation(): BetaResponsePageLocationCitation =
                                betaResponsePageLocation.getOrThrow("betaResponsePageLocation")

                            fun asBetaResponseContentBlockLocation():
                                BetaResponseContentBlockLocationCitation =
                                betaResponseContentBlockLocation.getOrThrow(
                                    "betaResponseContentBlockLocation"
                                )

                            fun _json(): JsonValue? = _json

                            fun <T> accept(visitor: Visitor<T>): T {
                                return when {
                                    betaResponseCharLocation != null ->
                                        visitor.visitBetaResponseCharLocation(
                                            betaResponseCharLocation
                                        )
                                    betaResponsePageLocation != null ->
                                        visitor.visitBetaResponsePageLocation(
                                            betaResponsePageLocation
                                        )
                                    betaResponseContentBlockLocation != null ->
                                        visitor.visitBetaResponseContentBlockLocation(
                                            betaResponseContentBlockLocation
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
                                        override fun visitBetaResponseCharLocation(
                                            betaResponseCharLocation:
                                                BetaResponseCharLocationCitation
                                        ) {
                                            betaResponseCharLocation.validate()
                                        }

                                        override fun visitBetaResponsePageLocation(
                                            betaResponsePageLocation:
                                                BetaResponsePageLocationCitation
                                        ) {
                                            betaResponsePageLocation.validate()
                                        }

                                        override fun visitBetaResponseContentBlockLocation(
                                            betaResponseContentBlockLocation:
                                                BetaResponseContentBlockLocationCitation
                                        ) {
                                            betaResponseContentBlockLocation.validate()
                                        }
                                    }
                                )
                                validated = true
                            }

                            override fun equals(other: Any?): Boolean {
                                if (this === other) {
                                    return true
                                }

                                return /* spotless:off */ other is Citation && betaResponseCharLocation == other.betaResponseCharLocation && betaResponsePageLocation == other.betaResponsePageLocation && betaResponseContentBlockLocation == other.betaResponseContentBlockLocation /* spotless:on */
                            }

                            override fun hashCode(): Int = /* spotless:off */ Objects.hash(betaResponseCharLocation, betaResponsePageLocation, betaResponseContentBlockLocation) /* spotless:on */

                            override fun toString(): String =
                                when {
                                    betaResponseCharLocation != null ->
                                        "Citation{betaResponseCharLocation=$betaResponseCharLocation}"
                                    betaResponsePageLocation != null ->
                                        "Citation{betaResponsePageLocation=$betaResponsePageLocation}"
                                    betaResponseContentBlockLocation != null ->
                                        "Citation{betaResponseContentBlockLocation=$betaResponseContentBlockLocation}"
                                    _json != null -> "Citation{_unknown=$_json}"
                                    else -> throw IllegalStateException("Invalid Citation")
                                }

                            companion object {

                                fun ofBetaResponseCharLocation(
                                    betaResponseCharLocation: BetaResponseCharLocationCitation
                                ) = Citation(betaResponseCharLocation = betaResponseCharLocation)

                                fun ofBetaResponsePageLocation(
                                    betaResponsePageLocation: BetaResponsePageLocationCitation
                                ) = Citation(betaResponsePageLocation = betaResponsePageLocation)

                                fun ofBetaResponseContentBlockLocation(
                                    betaResponseContentBlockLocation:
                                        BetaResponseContentBlockLocationCitation
                                ) =
                                    Citation(
                                        betaResponseContentBlockLocation =
                                            betaResponseContentBlockLocation
                                    )
                            }

                            /**
                             * An interface that defines how to map each variant of [Citation] to a
                             * value of type [T].
                             */
                            interface Visitor<out T> {

                                fun visitBetaResponseCharLocation(
                                    betaResponseCharLocation: BetaResponseCharLocationCitation
                                ): T

                                fun visitBetaResponsePageLocation(
                                    betaResponsePageLocation: BetaResponsePageLocationCitation
                                ): T

                                fun visitBetaResponseContentBlockLocation(
                                    betaResponseContentBlockLocation:
                                        BetaResponseContentBlockLocationCitation
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
                                            tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<
                                                        BetaResponseCharLocationCitation
                                                    >(),
                                                ) {
                                                    it.validate()
                                                }
                                                ?.let {
                                                    return Citation(
                                                        betaResponseCharLocation = it,
                                                        _json = json,
                                                    )
                                                }
                                        }
                                        "page_location" -> {
                                            tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<
                                                        BetaResponsePageLocationCitation
                                                    >(),
                                                ) {
                                                    it.validate()
                                                }
                                                ?.let {
                                                    return Citation(
                                                        betaResponsePageLocation = it,
                                                        _json = json,
                                                    )
                                                }
                                        }
                                        "content_block_location" -> {
                                            tryDeserialize(
                                                    node,
                                                    jacksonTypeRef<
                                                        BetaResponseContentBlockLocationCitation
                                                    >(),
                                                ) {
                                                    it.validate()
                                                }
                                                ?.let {
                                                    return Citation(
                                                        betaResponseContentBlockLocation = it,
                                                        _json = json,
                                                    )
                                                }
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
                                        value.betaResponseCharLocation != null ->
                                            generator.writeObject(value.betaResponseCharLocation)
                                        value.betaResponsePageLocation != null ->
                                            generator.writeObject(value.betaResponsePageLocation)
                                        value.betaResponseContentBlockLocation != null ->
                                            generator.writeObject(
                                                value.betaResponseContentBlockLocation
                                            )
                                        value._json != null -> generator.writeObject(value._json)
                                        else -> throw IllegalStateException("Invalid Citation")
                                    }
                                }
                            }

                            @NoAutoDetect
                            class BetaResponseCharLocationCitation
                            @JsonCreator
                            private constructor(
                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                private val citedText: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("document_index")
                                @ExcludeMissing
                                private val documentIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("document_title")
                                @ExcludeMissing
                                private val documentTitle: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("end_char_index")
                                @ExcludeMissing
                                private val endCharIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("start_char_index")
                                @ExcludeMissing
                                private val startCharIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                private val type: JsonField<Type> = JsonMissing.of(),
                                @JsonAnySetter
                                private val additionalProperties: Map<String, JsonValue> =
                                    immutableEmptyMap(),
                            ) {

                                fun citedText(): String = citedText.getRequired("cited_text")

                                fun documentIndex(): Long =
                                    documentIndex.getRequired("document_index")

                                fun documentTitle(): String? =
                                    documentTitle.getNullable("document_title")

                                fun endCharIndex(): Long =
                                    endCharIndex.getRequired("end_char_index")

                                fun startCharIndex(): Long =
                                    startCharIndex.getRequired("start_char_index")

                                fun type(): Type = type.getRequired("type")

                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                fun _citedText(): JsonField<String> = citedText

                                @JsonProperty("document_index")
                                @ExcludeMissing
                                fun _documentIndex(): JsonField<Long> = documentIndex

                                @JsonProperty("document_title")
                                @ExcludeMissing
                                fun _documentTitle(): JsonField<String> = documentTitle

                                @JsonProperty("end_char_index")
                                @ExcludeMissing
                                fun _endCharIndex(): JsonField<Long> = endCharIndex

                                @JsonProperty("start_char_index")
                                @ExcludeMissing
                                fun _startCharIndex(): JsonField<Long> = startCharIndex

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<Type> = type

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                private var validated: Boolean = false

                                fun validate(): BetaResponseCharLocationCitation = apply {
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

                                fun toBuilder() = Builder().from(this)

                                companion object {

                                    /**
                                     * Returns a mutable builder for constructing an instance of
                                     * [BetaResponseCharLocationCitation].
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

                                /** A builder for [BetaResponseCharLocationCitation]. */
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
                                        betaResponseCharLocationCitation:
                                            BetaResponseCharLocationCitation
                                    ) = apply {
                                        citedText = betaResponseCharLocationCitation.citedText
                                        documentIndex =
                                            betaResponseCharLocationCitation.documentIndex
                                        documentTitle =
                                            betaResponseCharLocationCitation.documentTitle
                                        endCharIndex = betaResponseCharLocationCitation.endCharIndex
                                        startCharIndex =
                                            betaResponseCharLocationCitation.startCharIndex
                                        type = betaResponseCharLocationCitation.type
                                        additionalProperties =
                                            betaResponseCharLocationCitation.additionalProperties
                                                .toMutableMap()
                                    }

                                    fun citedText(citedText: String) =
                                        citedText(JsonField.of(citedText))

                                    fun citedText(citedText: JsonField<String>) = apply {
                                        this.citedText = citedText
                                    }

                                    fun documentIndex(documentIndex: Long) =
                                        documentIndex(JsonField.of(documentIndex))

                                    fun documentIndex(documentIndex: JsonField<Long>) = apply {
                                        this.documentIndex = documentIndex
                                    }

                                    fun documentTitle(documentTitle: String?) =
                                        documentTitle(JsonField.ofNullable(documentTitle))

                                    fun documentTitle(documentTitle: JsonField<String>) = apply {
                                        this.documentTitle = documentTitle
                                    }

                                    fun endCharIndex(endCharIndex: Long) =
                                        endCharIndex(JsonField.of(endCharIndex))

                                    fun endCharIndex(endCharIndex: JsonField<Long>) = apply {
                                        this.endCharIndex = endCharIndex
                                    }

                                    fun startCharIndex(startCharIndex: Long) =
                                        startCharIndex(JsonField.of(startCharIndex))

                                    fun startCharIndex(startCharIndex: JsonField<Long>) = apply {
                                        this.startCharIndex = startCharIndex
                                    }

                                    fun type(type: Type) = type(JsonField.of(type))

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

                                    fun build(): BetaResponseCharLocationCitation =
                                        BetaResponseCharLocationCitation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endCharIndex", endCharIndex),
                                            checkRequired("startCharIndex", startCharIndex),
                                            checkRequired("type", type),
                                            additionalProperties.toImmutable(),
                                        )
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

                                    return /* spotless:off */ other is BetaResponseCharLocationCitation && citedText == other.citedText && documentIndex == other.documentIndex && documentTitle == other.documentTitle && endCharIndex == other.endCharIndex && startCharIndex == other.startCharIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(citedText, documentIndex, documentTitle, endCharIndex, startCharIndex, type, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "BetaResponseCharLocationCitation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endCharIndex=$endCharIndex, startCharIndex=$startCharIndex, type=$type, additionalProperties=$additionalProperties}"
                            }

                            @NoAutoDetect
                            class BetaResponsePageLocationCitation
                            @JsonCreator
                            private constructor(
                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                private val citedText: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("document_index")
                                @ExcludeMissing
                                private val documentIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("document_title")
                                @ExcludeMissing
                                private val documentTitle: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("end_page_number")
                                @ExcludeMissing
                                private val endPageNumber: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("start_page_number")
                                @ExcludeMissing
                                private val startPageNumber: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                private val type: JsonField<Type> = JsonMissing.of(),
                                @JsonAnySetter
                                private val additionalProperties: Map<String, JsonValue> =
                                    immutableEmptyMap(),
                            ) {

                                fun citedText(): String = citedText.getRequired("cited_text")

                                fun documentIndex(): Long =
                                    documentIndex.getRequired("document_index")

                                fun documentTitle(): String? =
                                    documentTitle.getNullable("document_title")

                                fun endPageNumber(): Long =
                                    endPageNumber.getRequired("end_page_number")

                                fun startPageNumber(): Long =
                                    startPageNumber.getRequired("start_page_number")

                                fun type(): Type = type.getRequired("type")

                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                fun _citedText(): JsonField<String> = citedText

                                @JsonProperty("document_index")
                                @ExcludeMissing
                                fun _documentIndex(): JsonField<Long> = documentIndex

                                @JsonProperty("document_title")
                                @ExcludeMissing
                                fun _documentTitle(): JsonField<String> = documentTitle

                                @JsonProperty("end_page_number")
                                @ExcludeMissing
                                fun _endPageNumber(): JsonField<Long> = endPageNumber

                                @JsonProperty("start_page_number")
                                @ExcludeMissing
                                fun _startPageNumber(): JsonField<Long> = startPageNumber

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<Type> = type

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                private var validated: Boolean = false

                                fun validate(): BetaResponsePageLocationCitation = apply {
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

                                fun toBuilder() = Builder().from(this)

                                companion object {

                                    /**
                                     * Returns a mutable builder for constructing an instance of
                                     * [BetaResponsePageLocationCitation].
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

                                /** A builder for [BetaResponsePageLocationCitation]. */
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
                                        betaResponsePageLocationCitation:
                                            BetaResponsePageLocationCitation
                                    ) = apply {
                                        citedText = betaResponsePageLocationCitation.citedText
                                        documentIndex =
                                            betaResponsePageLocationCitation.documentIndex
                                        documentTitle =
                                            betaResponsePageLocationCitation.documentTitle
                                        endPageNumber =
                                            betaResponsePageLocationCitation.endPageNumber
                                        startPageNumber =
                                            betaResponsePageLocationCitation.startPageNumber
                                        type = betaResponsePageLocationCitation.type
                                        additionalProperties =
                                            betaResponsePageLocationCitation.additionalProperties
                                                .toMutableMap()
                                    }

                                    fun citedText(citedText: String) =
                                        citedText(JsonField.of(citedText))

                                    fun citedText(citedText: JsonField<String>) = apply {
                                        this.citedText = citedText
                                    }

                                    fun documentIndex(documentIndex: Long) =
                                        documentIndex(JsonField.of(documentIndex))

                                    fun documentIndex(documentIndex: JsonField<Long>) = apply {
                                        this.documentIndex = documentIndex
                                    }

                                    fun documentTitle(documentTitle: String?) =
                                        documentTitle(JsonField.ofNullable(documentTitle))

                                    fun documentTitle(documentTitle: JsonField<String>) = apply {
                                        this.documentTitle = documentTitle
                                    }

                                    fun endPageNumber(endPageNumber: Long) =
                                        endPageNumber(JsonField.of(endPageNumber))

                                    fun endPageNumber(endPageNumber: JsonField<Long>) = apply {
                                        this.endPageNumber = endPageNumber
                                    }

                                    fun startPageNumber(startPageNumber: Long) =
                                        startPageNumber(JsonField.of(startPageNumber))

                                    fun startPageNumber(startPageNumber: JsonField<Long>) = apply {
                                        this.startPageNumber = startPageNumber
                                    }

                                    fun type(type: Type) = type(JsonField.of(type))

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

                                    fun build(): BetaResponsePageLocationCitation =
                                        BetaResponsePageLocationCitation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endPageNumber", endPageNumber),
                                            checkRequired("startPageNumber", startPageNumber),
                                            checkRequired("type", type),
                                            additionalProperties.toImmutable(),
                                        )
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

                                    return /* spotless:off */ other is BetaResponsePageLocationCitation && citedText == other.citedText && documentIndex == other.documentIndex && documentTitle == other.documentTitle && endPageNumber == other.endPageNumber && startPageNumber == other.startPageNumber && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(citedText, documentIndex, documentTitle, endPageNumber, startPageNumber, type, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "BetaResponsePageLocationCitation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endPageNumber=$endPageNumber, startPageNumber=$startPageNumber, type=$type, additionalProperties=$additionalProperties}"
                            }

                            @NoAutoDetect
                            class BetaResponseContentBlockLocationCitation
                            @JsonCreator
                            private constructor(
                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                private val citedText: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("document_index")
                                @ExcludeMissing
                                private val documentIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("document_title")
                                @ExcludeMissing
                                private val documentTitle: JsonField<String> = JsonMissing.of(),
                                @JsonProperty("end_block_index")
                                @ExcludeMissing
                                private val endBlockIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("start_block_index")
                                @ExcludeMissing
                                private val startBlockIndex: JsonField<Long> = JsonMissing.of(),
                                @JsonProperty("type")
                                @ExcludeMissing
                                private val type: JsonField<Type> = JsonMissing.of(),
                                @JsonAnySetter
                                private val additionalProperties: Map<String, JsonValue> =
                                    immutableEmptyMap(),
                            ) {

                                fun citedText(): String = citedText.getRequired("cited_text")

                                fun documentIndex(): Long =
                                    documentIndex.getRequired("document_index")

                                fun documentTitle(): String? =
                                    documentTitle.getNullable("document_title")

                                fun endBlockIndex(): Long =
                                    endBlockIndex.getRequired("end_block_index")

                                fun startBlockIndex(): Long =
                                    startBlockIndex.getRequired("start_block_index")

                                fun type(): Type = type.getRequired("type")

                                @JsonProperty("cited_text")
                                @ExcludeMissing
                                fun _citedText(): JsonField<String> = citedText

                                @JsonProperty("document_index")
                                @ExcludeMissing
                                fun _documentIndex(): JsonField<Long> = documentIndex

                                @JsonProperty("document_title")
                                @ExcludeMissing
                                fun _documentTitle(): JsonField<String> = documentTitle

                                @JsonProperty("end_block_index")
                                @ExcludeMissing
                                fun _endBlockIndex(): JsonField<Long> = endBlockIndex

                                @JsonProperty("start_block_index")
                                @ExcludeMissing
                                fun _startBlockIndex(): JsonField<Long> = startBlockIndex

                                @JsonProperty("type")
                                @ExcludeMissing
                                fun _type(): JsonField<Type> = type

                                @JsonAnyGetter
                                @ExcludeMissing
                                fun _additionalProperties(): Map<String, JsonValue> =
                                    additionalProperties

                                private var validated: Boolean = false

                                fun validate(): BetaResponseContentBlockLocationCitation = apply {
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

                                fun toBuilder() = Builder().from(this)

                                companion object {

                                    /**
                                     * Returns a mutable builder for constructing an instance of
                                     * [BetaResponseContentBlockLocationCitation].
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

                                /** A builder for [BetaResponseContentBlockLocationCitation]. */
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
                                        betaResponseContentBlockLocationCitation:
                                            BetaResponseContentBlockLocationCitation
                                    ) = apply {
                                        citedText =
                                            betaResponseContentBlockLocationCitation.citedText
                                        documentIndex =
                                            betaResponseContentBlockLocationCitation.documentIndex
                                        documentTitle =
                                            betaResponseContentBlockLocationCitation.documentTitle
                                        endBlockIndex =
                                            betaResponseContentBlockLocationCitation.endBlockIndex
                                        startBlockIndex =
                                            betaResponseContentBlockLocationCitation.startBlockIndex
                                        type = betaResponseContentBlockLocationCitation.type
                                        additionalProperties =
                                            betaResponseContentBlockLocationCitation
                                                .additionalProperties
                                                .toMutableMap()
                                    }

                                    fun citedText(citedText: String) =
                                        citedText(JsonField.of(citedText))

                                    fun citedText(citedText: JsonField<String>) = apply {
                                        this.citedText = citedText
                                    }

                                    fun documentIndex(documentIndex: Long) =
                                        documentIndex(JsonField.of(documentIndex))

                                    fun documentIndex(documentIndex: JsonField<Long>) = apply {
                                        this.documentIndex = documentIndex
                                    }

                                    fun documentTitle(documentTitle: String?) =
                                        documentTitle(JsonField.ofNullable(documentTitle))

                                    fun documentTitle(documentTitle: JsonField<String>) = apply {
                                        this.documentTitle = documentTitle
                                    }

                                    fun endBlockIndex(endBlockIndex: Long) =
                                        endBlockIndex(JsonField.of(endBlockIndex))

                                    fun endBlockIndex(endBlockIndex: JsonField<Long>) = apply {
                                        this.endBlockIndex = endBlockIndex
                                    }

                                    fun startBlockIndex(startBlockIndex: Long) =
                                        startBlockIndex(JsonField.of(startBlockIndex))

                                    fun startBlockIndex(startBlockIndex: JsonField<Long>) = apply {
                                        this.startBlockIndex = startBlockIndex
                                    }

                                    fun type(type: Type) = type(JsonField.of(type))

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

                                    fun build(): BetaResponseContentBlockLocationCitation =
                                        BetaResponseContentBlockLocationCitation(
                                            checkRequired("citedText", citedText),
                                            checkRequired("documentIndex", documentIndex),
                                            checkRequired("documentTitle", documentTitle),
                                            checkRequired("endBlockIndex", endBlockIndex),
                                            checkRequired("startBlockIndex", startBlockIndex),
                                            checkRequired("type", type),
                                            additionalProperties.toImmutable(),
                                        )
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

                                    return /* spotless:off */ other is BetaResponseContentBlockLocationCitation && citedText == other.citedText && documentIndex == other.documentIndex && documentTitle == other.documentTitle && endBlockIndex == other.endBlockIndex && startBlockIndex == other.startBlockIndex && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                                }

                                /* spotless:off */
                                private val hashCode: Int by lazy { Objects.hash(citedText, documentIndex, documentTitle, endBlockIndex, startBlockIndex, type, additionalProperties) }
                                /* spotless:on */

                                override fun hashCode(): Int = hashCode

                                override fun toString() =
                                    "BetaResponseContentBlockLocationCitation{citedText=$citedText, documentIndex=$documentIndex, documentTitle=$documentTitle, endBlockIndex=$endBlockIndex, startBlockIndex=$startBlockIndex, type=$type, additionalProperties=$additionalProperties}"
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

                            return /* spotless:off */ other is BetaResponseTextBlock && citations == other.citations && text == other.text && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(citations, text, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaResponseTextBlock{citations=$citations, text=$text, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaResponseToolUseBlock
                    @JsonCreator
                    private constructor(
                        @JsonProperty("id")
                        @ExcludeMissing
                        private val id: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("input")
                        @ExcludeMissing
                        private val input: JsonValue = JsonMissing.of(),
                        @JsonProperty("name")
                        @ExcludeMissing
                        private val name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun id(): String = id.getRequired("id")

                        @JsonProperty("input") @ExcludeMissing fun _input(): JsonValue = input

                        fun name(): String = name.getRequired("name")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaResponseToolUseBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            id()
                            name()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaResponseToolUseBlock].
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

                        /** A builder for [BetaResponseToolUseBlock]. */
                        class Builder internal constructor() {

                            private var id: JsonField<String>? = null
                            private var input: JsonValue? = null
                            private var name: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaResponseToolUseBlock: BetaResponseToolUseBlock) =
                                apply {
                                    id = betaResponseToolUseBlock.id
                                    input = betaResponseToolUseBlock.input
                                    name = betaResponseToolUseBlock.name
                                    type = betaResponseToolUseBlock.type
                                    additionalProperties =
                                        betaResponseToolUseBlock.additionalProperties.toMutableMap()
                                }

                            fun id(id: String) = id(JsonField.of(id))

                            fun id(id: JsonField<String>) = apply { this.id = id }

                            fun input(input: JsonValue) = apply { this.input = input }

                            fun name(name: String) = name(JsonField.of(name))

                            fun name(name: JsonField<String>) = apply { this.name = name }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaResponseToolUseBlock =
                                BetaResponseToolUseBlock(
                                    checkRequired("id", id),
                                    checkRequired("input", input),
                                    checkRequired("name", name),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaResponseToolUseBlock && id == other.id && input == other.input && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(id, input, name, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaResponseToolUseBlock{id=$id, input=$input, name=$name, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaResponseThinkingBlock
                    @JsonCreator
                    private constructor(
                        @JsonProperty("signature")
                        @ExcludeMissing
                        private val signature: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("thinking")
                        @ExcludeMissing
                        private val thinking: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun signature(): String = signature.getRequired("signature")

                        fun thinking(): String = thinking.getRequired("thinking")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("signature")
                        @ExcludeMissing
                        fun _signature(): JsonField<String> = signature

                        @JsonProperty("thinking")
                        @ExcludeMissing
                        fun _thinking(): JsonField<String> = thinking

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaResponseThinkingBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            signature()
                            thinking()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaResponseThinkingBlock].
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

                        /** A builder for [BetaResponseThinkingBlock]. */
                        class Builder internal constructor() {

                            private var signature: JsonField<String>? = null
                            private var thinking: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(
                                betaResponseThinkingBlock: BetaResponseThinkingBlock
                            ) = apply {
                                signature = betaResponseThinkingBlock.signature
                                thinking = betaResponseThinkingBlock.thinking
                                type = betaResponseThinkingBlock.type
                                additionalProperties =
                                    betaResponseThinkingBlock.additionalProperties.toMutableMap()
                            }

                            fun signature(signature: String) = signature(JsonField.of(signature))

                            fun signature(signature: JsonField<String>) = apply {
                                this.signature = signature
                            }

                            fun thinking(thinking: String) = thinking(JsonField.of(thinking))

                            fun thinking(thinking: JsonField<String>) = apply {
                                this.thinking = thinking
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaResponseThinkingBlock =
                                BetaResponseThinkingBlock(
                                    checkRequired("signature", signature),
                                    checkRequired("thinking", thinking),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaResponseThinkingBlock && signature == other.signature && thinking == other.thinking && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(signature, thinking, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaResponseThinkingBlock{signature=$signature, thinking=$thinking, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaResponseRedactedThinkingBlock
                    @JsonCreator
                    private constructor(
                        @JsonProperty("data")
                        @ExcludeMissing
                        private val data: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun data(): String = data.getRequired("data")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<String> = data

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaResponseRedactedThinkingBlock = apply {
                            if (validated) {
                                return@apply
                            }

                            data()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaResponseRedactedThinkingBlock].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .data()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaResponseRedactedThinkingBlock]. */
                        class Builder internal constructor() {

                            private var data: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(
                                betaResponseRedactedThinkingBlock: BetaResponseRedactedThinkingBlock
                            ) = apply {
                                data = betaResponseRedactedThinkingBlock.data
                                type = betaResponseRedactedThinkingBlock.type
                                additionalProperties =
                                    betaResponseRedactedThinkingBlock.additionalProperties
                                        .toMutableMap()
                            }

                            fun data(data: String) = data(JsonField.of(data))

                            fun data(data: JsonField<String>) = apply { this.data = data }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaResponseRedactedThinkingBlock =
                                BetaResponseRedactedThinkingBlock(
                                    checkRequired("data", data),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaResponseRedactedThinkingBlock && data == other.data && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(data, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaResponseRedactedThinkingBlock{data=$data, type=$type, additionalProperties=$additionalProperties}"
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
                @NoAutoDetect
                class Usage
                @JsonCreator
                private constructor(
                    @JsonProperty("cache_creation_input_tokens")
                    @ExcludeMissing
                    private val cacheCreationInputTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("cache_read_input_tokens")
                    @ExcludeMissing
                    private val cacheReadInputTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("input_tokens")
                    @ExcludeMissing
                    private val inputTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("output_tokens")
                    @ExcludeMissing
                    private val outputTokens: JsonField<Long> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    /** The number of input tokens used to create the cache entry. */
                    fun cacheCreationInputTokens(): Long? =
                        cacheCreationInputTokens.getNullable("cache_creation_input_tokens")

                    /** The number of input tokens read from the cache. */
                    fun cacheReadInputTokens(): Long? =
                        cacheReadInputTokens.getNullable("cache_read_input_tokens")

                    /** The number of input tokens which were used. */
                    fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

                    /** The number of output tokens which were used. */
                    fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

                    /** The number of input tokens used to create the cache entry. */
                    @JsonProperty("cache_creation_input_tokens")
                    @ExcludeMissing
                    fun _cacheCreationInputTokens(): JsonField<Long> = cacheCreationInputTokens

                    /** The number of input tokens read from the cache. */
                    @JsonProperty("cache_read_input_tokens")
                    @ExcludeMissing
                    fun _cacheReadInputTokens(): JsonField<Long> = cacheReadInputTokens

                    /** The number of input tokens which were used. */
                    @JsonProperty("input_tokens")
                    @ExcludeMissing
                    fun _inputTokens(): JsonField<Long> = inputTokens

                    /** The number of output tokens which were used. */
                    @JsonProperty("output_tokens")
                    @ExcludeMissing
                    fun _outputTokens(): JsonField<Long> = outputTokens

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                        /** The number of input tokens used to create the cache entry. */
                        fun cacheCreationInputTokens(cacheCreationInputTokens: Long) =
                            cacheCreationInputTokens(cacheCreationInputTokens as Long?)

                        /** The number of input tokens used to create the cache entry. */
                        fun cacheCreationInputTokens(cacheCreationInputTokens: JsonField<Long>) =
                            apply {
                                this.cacheCreationInputTokens = cacheCreationInputTokens
                            }

                        /** The number of input tokens read from the cache. */
                        fun cacheReadInputTokens(cacheReadInputTokens: Long?) =
                            cacheReadInputTokens(JsonField.ofNullable(cacheReadInputTokens))

                        /** The number of input tokens read from the cache. */
                        fun cacheReadInputTokens(cacheReadInputTokens: Long) =
                            cacheReadInputTokens(cacheReadInputTokens as Long?)

                        /** The number of input tokens read from the cache. */
                        fun cacheReadInputTokens(cacheReadInputTokens: JsonField<Long>) = apply {
                            this.cacheReadInputTokens = cacheReadInputTokens
                        }

                        /** The number of input tokens which were used. */
                        fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

                        /** The number of input tokens which were used. */
                        fun inputTokens(inputTokens: JsonField<Long>) = apply {
                            this.inputTokens = inputTokens
                        }

                        /** The number of output tokens which were used. */
                        fun outputTokens(outputTokens: Long) =
                            outputTokens(JsonField.of(outputTokens))

                        /** The number of output tokens which were used. */
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

                        fun build(): Usage =
                            Usage(
                                checkRequired("cacheCreationInputTokens", cacheCreationInputTokens),
                                checkRequired("cacheReadInputTokens", cacheReadInputTokens),
                                checkRequired("inputTokens", inputTokens),
                                checkRequired("outputTokens", outputTokens),
                                additionalProperties.toImmutable(),
                            )
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

                return /* spotless:off */ other is BetaSucceededResult && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "BetaSucceededResult{message=$message, type=$type, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class BetaErroredResult
        @JsonCreator
        private constructor(
            @JsonProperty("error")
            @ExcludeMissing
            private val error: JsonField<Error> = JsonMissing.of(),
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun error(): Error = error.getRequired("error")

            fun type(): Type = type.getRequired("type")

            @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): BetaErroredResult = apply {
                if (validated) {
                    return@apply
                }

                error().validate()
                type()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [BetaErroredResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .error()
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [BetaErroredResult]. */
            class Builder internal constructor() {

                private var error: JsonField<Error>? = null
                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(betaErroredResult: BetaErroredResult) = apply {
                    error = betaErroredResult.error
                    type = betaErroredResult.type
                    additionalProperties = betaErroredResult.additionalProperties.toMutableMap()
                }

                fun error(error: Error) = error(JsonField.of(error))

                fun error(error: JsonField<Error>) = apply { this.error = error }

                fun type(type: Type) = type(JsonField.of(type))

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

                fun build(): BetaErroredResult =
                    BetaErroredResult(
                        checkRequired("error", error),
                        checkRequired("type", type),
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class Error
            @JsonCreator
            private constructor(
                @JsonProperty("error")
                @ExcludeMissing
                private val error: JsonField<InnerError> = JsonMissing.of(),
                @JsonProperty("type")
                @ExcludeMissing
                private val type: JsonField<Type> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                fun error(): InnerError = error.getRequired("error")

                fun type(): Type = type.getRequired("type")

                @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<InnerError> = error

                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Error = apply {
                    if (validated) {
                        return@apply
                    }

                    error().validate()
                    type()
                    validated = true
                }

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

                    fun error(error: JsonField<InnerError>) = apply { this.error = error }

                    fun error(betaInvalidRequest: InnerError.BetaInvalidRequestError) =
                        error(InnerError.ofBetaInvalidRequest(betaInvalidRequest))

                    fun betaInvalidRequestError(message: String) =
                        error(
                            InnerError.BetaInvalidRequestError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaInvalidRequestError
                                        .Type
                                        .INVALID_REQUEST_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaAuthentication: InnerError.BetaAuthenticationError) =
                        error(InnerError.ofBetaAuthentication(betaAuthentication))

                    fun betaAuthenticationError(message: String) =
                        error(
                            InnerError.BetaAuthenticationError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaAuthenticationError
                                        .Type
                                        .AUTHENTICATION_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaBilling: InnerError.BetaBillingError) =
                        error(InnerError.ofBetaBilling(betaBilling))

                    fun betaBillingError(message: String) =
                        error(
                            InnerError.BetaBillingError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaBillingError
                                        .Type
                                        .BILLING_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaPermission: InnerError.BetaPermissionError) =
                        error(InnerError.ofBetaPermission(betaPermission))

                    fun betaPermissionError(message: String) =
                        error(
                            InnerError.BetaPermissionError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaPermissionError
                                        .Type
                                        .PERMISSION_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaNotFound: InnerError.BetaNotFoundError) =
                        error(InnerError.ofBetaNotFound(betaNotFound))

                    fun betaNotFoundError(message: String) =
                        error(
                            InnerError.BetaNotFoundError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaNotFoundError
                                        .Type
                                        .NOT_FOUND_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaRateLimit: InnerError.BetaRateLimitError) =
                        error(InnerError.ofBetaRateLimit(betaRateLimit))

                    fun betaRateLimitError(message: String) =
                        error(
                            InnerError.BetaRateLimitError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaRateLimitError
                                        .Type
                                        .RATE_LIMIT_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaGatewayTimeout: InnerError.BetaGatewayTimeoutError) =
                        error(InnerError.ofBetaGatewayTimeout(betaGatewayTimeout))

                    fun betaGatewayTimeoutError(message: String) =
                        error(
                            InnerError.BetaGatewayTimeoutError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaGatewayTimeoutError
                                        .Type
                                        .TIMEOUT_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaApi: InnerError.BetaApiError) =
                        error(InnerError.ofBetaApi(betaApi))

                    fun betaApiError(message: String) =
                        error(
                            InnerError.BetaApiError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaApiError
                                        .Type
                                        .API_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun error(betaOverloaded: InnerError.BetaOverloadedError) =
                        error(InnerError.ofBetaOverloaded(betaOverloaded))

                    fun betaOverloadedError(message: String) =
                        error(
                            InnerError.BetaOverloadedError.builder()
                                .type(
                                    BatchResultsBetaResponse.Result.BetaErroredResult.Error
                                        .InnerError
                                        .BetaOverloadedError
                                        .Type
                                        .OVERLOADED_ERROR
                                )
                                .message(message)
                                .build()
                        )

                    fun type(type: Type) = type(JsonField.of(type))

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

                    fun build(): Error =
                        Error(
                            checkRequired("error", error),
                            checkRequired("type", type),
                            additionalProperties.toImmutable(),
                        )
                }

                @JsonDeserialize(using = InnerError.Deserializer::class)
                @JsonSerialize(using = InnerError.Serializer::class)
                class InnerError
                private constructor(
                    private val betaInvalidRequest: BetaInvalidRequestError? = null,
                    private val betaAuthentication: BetaAuthenticationError? = null,
                    private val betaBilling: BetaBillingError? = null,
                    private val betaPermission: BetaPermissionError? = null,
                    private val betaNotFound: BetaNotFoundError? = null,
                    private val betaRateLimit: BetaRateLimitError? = null,
                    private val betaGatewayTimeout: BetaGatewayTimeoutError? = null,
                    private val betaApi: BetaApiError? = null,
                    private val betaOverloaded: BetaOverloadedError? = null,
                    private val _json: JsonValue? = null,
                ) {

                    fun betaInvalidRequest(): BetaInvalidRequestError? = betaInvalidRequest

                    fun betaAuthentication(): BetaAuthenticationError? = betaAuthentication

                    fun betaBilling(): BetaBillingError? = betaBilling

                    fun betaPermission(): BetaPermissionError? = betaPermission

                    fun betaNotFound(): BetaNotFoundError? = betaNotFound

                    fun betaRateLimit(): BetaRateLimitError? = betaRateLimit

                    fun betaGatewayTimeout(): BetaGatewayTimeoutError? = betaGatewayTimeout

                    fun betaApi(): BetaApiError? = betaApi

                    fun betaOverloaded(): BetaOverloadedError? = betaOverloaded

                    fun isBetaInvalidRequest(): Boolean = betaInvalidRequest != null

                    fun isBetaAuthentication(): Boolean = betaAuthentication != null

                    fun isBetaBilling(): Boolean = betaBilling != null

                    fun isBetaPermission(): Boolean = betaPermission != null

                    fun isBetaNotFound(): Boolean = betaNotFound != null

                    fun isBetaRateLimit(): Boolean = betaRateLimit != null

                    fun isBetaGatewayTimeout(): Boolean = betaGatewayTimeout != null

                    fun isBetaApi(): Boolean = betaApi != null

                    fun isBetaOverloaded(): Boolean = betaOverloaded != null

                    fun asBetaInvalidRequest(): BetaInvalidRequestError =
                        betaInvalidRequest.getOrThrow("betaInvalidRequest")

                    fun asBetaAuthentication(): BetaAuthenticationError =
                        betaAuthentication.getOrThrow("betaAuthentication")

                    fun asBetaBilling(): BetaBillingError = betaBilling.getOrThrow("betaBilling")

                    fun asBetaPermission(): BetaPermissionError =
                        betaPermission.getOrThrow("betaPermission")

                    fun asBetaNotFound(): BetaNotFoundError =
                        betaNotFound.getOrThrow("betaNotFound")

                    fun asBetaRateLimit(): BetaRateLimitError =
                        betaRateLimit.getOrThrow("betaRateLimit")

                    fun asBetaGatewayTimeout(): BetaGatewayTimeoutError =
                        betaGatewayTimeout.getOrThrow("betaGatewayTimeout")

                    fun asBetaApi(): BetaApiError = betaApi.getOrThrow("betaApi")

                    fun asBetaOverloaded(): BetaOverloadedError =
                        betaOverloaded.getOrThrow("betaOverloaded")

                    fun _json(): JsonValue? = _json

                    fun <T> accept(visitor: Visitor<T>): T {
                        return when {
                            betaInvalidRequest != null ->
                                visitor.visitBetaInvalidRequest(betaInvalidRequest)
                            betaAuthentication != null ->
                                visitor.visitBetaAuthentication(betaAuthentication)
                            betaBilling != null -> visitor.visitBetaBilling(betaBilling)
                            betaPermission != null -> visitor.visitBetaPermission(betaPermission)
                            betaNotFound != null -> visitor.visitBetaNotFound(betaNotFound)
                            betaRateLimit != null -> visitor.visitBetaRateLimit(betaRateLimit)
                            betaGatewayTimeout != null ->
                                visitor.visitBetaGatewayTimeout(betaGatewayTimeout)
                            betaApi != null -> visitor.visitBetaApi(betaApi)
                            betaOverloaded != null -> visitor.visitBetaOverloaded(betaOverloaded)
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
                                override fun visitBetaInvalidRequest(
                                    betaInvalidRequest: BetaInvalidRequestError
                                ) {
                                    betaInvalidRequest.validate()
                                }

                                override fun visitBetaAuthentication(
                                    betaAuthentication: BetaAuthenticationError
                                ) {
                                    betaAuthentication.validate()
                                }

                                override fun visitBetaBilling(betaBilling: BetaBillingError) {
                                    betaBilling.validate()
                                }

                                override fun visitBetaPermission(
                                    betaPermission: BetaPermissionError
                                ) {
                                    betaPermission.validate()
                                }

                                override fun visitBetaNotFound(betaNotFound: BetaNotFoundError) {
                                    betaNotFound.validate()
                                }

                                override fun visitBetaRateLimit(betaRateLimit: BetaRateLimitError) {
                                    betaRateLimit.validate()
                                }

                                override fun visitBetaGatewayTimeout(
                                    betaGatewayTimeout: BetaGatewayTimeoutError
                                ) {
                                    betaGatewayTimeout.validate()
                                }

                                override fun visitBetaApi(betaApi: BetaApiError) {
                                    betaApi.validate()
                                }

                                override fun visitBetaOverloaded(
                                    betaOverloaded: BetaOverloadedError
                                ) {
                                    betaOverloaded.validate()
                                }
                            }
                        )
                        validated = true
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is InnerError && betaInvalidRequest == other.betaInvalidRequest && betaAuthentication == other.betaAuthentication && betaBilling == other.betaBilling && betaPermission == other.betaPermission && betaNotFound == other.betaNotFound && betaRateLimit == other.betaRateLimit && betaGatewayTimeout == other.betaGatewayTimeout && betaApi == other.betaApi && betaOverloaded == other.betaOverloaded /* spotless:on */
                    }

                    override fun hashCode(): Int = /* spotless:off */ Objects.hash(betaInvalidRequest, betaAuthentication, betaBilling, betaPermission, betaNotFound, betaRateLimit, betaGatewayTimeout, betaApi, betaOverloaded) /* spotless:on */

                    override fun toString(): String =
                        when {
                            betaInvalidRequest != null ->
                                "InnerError{betaInvalidRequest=$betaInvalidRequest}"
                            betaAuthentication != null ->
                                "InnerError{betaAuthentication=$betaAuthentication}"
                            betaBilling != null -> "InnerError{betaBilling=$betaBilling}"
                            betaPermission != null -> "InnerError{betaPermission=$betaPermission}"
                            betaNotFound != null -> "InnerError{betaNotFound=$betaNotFound}"
                            betaRateLimit != null -> "InnerError{betaRateLimit=$betaRateLimit}"
                            betaGatewayTimeout != null ->
                                "InnerError{betaGatewayTimeout=$betaGatewayTimeout}"
                            betaApi != null -> "InnerError{betaApi=$betaApi}"
                            betaOverloaded != null -> "InnerError{betaOverloaded=$betaOverloaded}"
                            _json != null -> "InnerError{_unknown=$_json}"
                            else -> throw IllegalStateException("Invalid InnerError")
                        }

                    companion object {

                        fun ofBetaInvalidRequest(betaInvalidRequest: BetaInvalidRequestError) =
                            InnerError(betaInvalidRequest = betaInvalidRequest)

                        fun ofBetaAuthentication(betaAuthentication: BetaAuthenticationError) =
                            InnerError(betaAuthentication = betaAuthentication)

                        fun ofBetaBilling(betaBilling: BetaBillingError) =
                            InnerError(betaBilling = betaBilling)

                        fun ofBetaPermission(betaPermission: BetaPermissionError) =
                            InnerError(betaPermission = betaPermission)

                        fun ofBetaNotFound(betaNotFound: BetaNotFoundError) =
                            InnerError(betaNotFound = betaNotFound)

                        fun ofBetaRateLimit(betaRateLimit: BetaRateLimitError) =
                            InnerError(betaRateLimit = betaRateLimit)

                        fun ofBetaGatewayTimeout(betaGatewayTimeout: BetaGatewayTimeoutError) =
                            InnerError(betaGatewayTimeout = betaGatewayTimeout)

                        fun ofBetaApi(betaApi: BetaApiError) = InnerError(betaApi = betaApi)

                        fun ofBetaOverloaded(betaOverloaded: BetaOverloadedError) =
                            InnerError(betaOverloaded = betaOverloaded)
                    }

                    /**
                     * An interface that defines how to map each variant of [InnerError] to a value
                     * of type [T].
                     */
                    interface Visitor<out T> {

                        fun visitBetaInvalidRequest(betaInvalidRequest: BetaInvalidRequestError): T

                        fun visitBetaAuthentication(betaAuthentication: BetaAuthenticationError): T

                        fun visitBetaBilling(betaBilling: BetaBillingError): T

                        fun visitBetaPermission(betaPermission: BetaPermissionError): T

                        fun visitBetaNotFound(betaNotFound: BetaNotFoundError): T

                        fun visitBetaRateLimit(betaRateLimit: BetaRateLimitError): T

                        fun visitBetaGatewayTimeout(betaGatewayTimeout: BetaGatewayTimeoutError): T

                        fun visitBetaApi(betaApi: BetaApiError): T

                        fun visitBetaOverloaded(betaOverloaded: BetaOverloadedError): T

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
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<BetaInvalidRequestError>(),
                                        ) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaInvalidRequest = it, _json = json)
                                        }
                                }
                                "authentication_error" -> {
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<BetaAuthenticationError>(),
                                        ) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaAuthentication = it, _json = json)
                                        }
                                }
                                "billing_error" -> {
                                    tryDeserialize(node, jacksonTypeRef<BetaBillingError>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaBilling = it, _json = json)
                                        }
                                }
                                "permission_error" -> {
                                    tryDeserialize(node, jacksonTypeRef<BetaPermissionError>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaPermission = it, _json = json)
                                        }
                                }
                                "not_found_error" -> {
                                    tryDeserialize(node, jacksonTypeRef<BetaNotFoundError>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaNotFound = it, _json = json)
                                        }
                                }
                                "rate_limit_error" -> {
                                    tryDeserialize(node, jacksonTypeRef<BetaRateLimitError>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaRateLimit = it, _json = json)
                                        }
                                }
                                "timeout_error" -> {
                                    tryDeserialize(
                                            node,
                                            jacksonTypeRef<BetaGatewayTimeoutError>(),
                                        ) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaGatewayTimeout = it, _json = json)
                                        }
                                }
                                "api_error" -> {
                                    tryDeserialize(node, jacksonTypeRef<BetaApiError>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaApi = it, _json = json)
                                        }
                                }
                                "overloaded_error" -> {
                                    tryDeserialize(node, jacksonTypeRef<BetaOverloadedError>()) {
                                            it.validate()
                                        }
                                        ?.let {
                                            return InnerError(betaOverloaded = it, _json = json)
                                        }
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
                                value.betaInvalidRequest != null ->
                                    generator.writeObject(value.betaInvalidRequest)
                                value.betaAuthentication != null ->
                                    generator.writeObject(value.betaAuthentication)
                                value.betaBilling != null ->
                                    generator.writeObject(value.betaBilling)
                                value.betaPermission != null ->
                                    generator.writeObject(value.betaPermission)
                                value.betaNotFound != null ->
                                    generator.writeObject(value.betaNotFound)
                                value.betaRateLimit != null ->
                                    generator.writeObject(value.betaRateLimit)
                                value.betaGatewayTimeout != null ->
                                    generator.writeObject(value.betaGatewayTimeout)
                                value.betaApi != null -> generator.writeObject(value.betaApi)
                                value.betaOverloaded != null ->
                                    generator.writeObject(value.betaOverloaded)
                                value._json != null -> generator.writeObject(value._json)
                                else -> throw IllegalStateException("Invalid InnerError")
                            }
                        }
                    }

                    @NoAutoDetect
                    class BetaInvalidRequestError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaInvalidRequestError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaInvalidRequestError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaInvalidRequestError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaInvalidRequestError: BetaInvalidRequestError) =
                                apply {
                                    message = betaInvalidRequestError.message
                                    type = betaInvalidRequestError.type
                                    additionalProperties =
                                        betaInvalidRequestError.additionalProperties.toMutableMap()
                                }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaInvalidRequestError =
                                BetaInvalidRequestError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaInvalidRequestError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaInvalidRequestError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaAuthenticationError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaAuthenticationError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaAuthenticationError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaAuthenticationError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaAuthenticationError: BetaAuthenticationError) =
                                apply {
                                    message = betaAuthenticationError.message
                                    type = betaAuthenticationError.type
                                    additionalProperties =
                                        betaAuthenticationError.additionalProperties.toMutableMap()
                                }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaAuthenticationError =
                                BetaAuthenticationError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaAuthenticationError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaAuthenticationError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaBillingError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaBillingError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaBillingError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaBillingError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaBillingError: BetaBillingError) = apply {
                                message = betaBillingError.message
                                type = betaBillingError.type
                                additionalProperties =
                                    betaBillingError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaBillingError =
                                BetaBillingError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaBillingError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaBillingError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaPermissionError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaPermissionError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaPermissionError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaPermissionError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaPermissionError: BetaPermissionError) = apply {
                                message = betaPermissionError.message
                                type = betaPermissionError.type
                                additionalProperties =
                                    betaPermissionError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaPermissionError =
                                BetaPermissionError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaPermissionError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaPermissionError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaNotFoundError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaNotFoundError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaNotFoundError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaNotFoundError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaNotFoundError: BetaNotFoundError) = apply {
                                message = betaNotFoundError.message
                                type = betaNotFoundError.type
                                additionalProperties =
                                    betaNotFoundError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaNotFoundError =
                                BetaNotFoundError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaNotFoundError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaNotFoundError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaRateLimitError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaRateLimitError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaRateLimitError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaRateLimitError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaRateLimitError: BetaRateLimitError) = apply {
                                message = betaRateLimitError.message
                                type = betaRateLimitError.type
                                additionalProperties =
                                    betaRateLimitError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaRateLimitError =
                                BetaRateLimitError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaRateLimitError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaRateLimitError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaGatewayTimeoutError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaGatewayTimeoutError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaGatewayTimeoutError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaGatewayTimeoutError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaGatewayTimeoutError: BetaGatewayTimeoutError) =
                                apply {
                                    message = betaGatewayTimeoutError.message
                                    type = betaGatewayTimeoutError.type
                                    additionalProperties =
                                        betaGatewayTimeoutError.additionalProperties.toMutableMap()
                                }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaGatewayTimeoutError =
                                BetaGatewayTimeoutError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaGatewayTimeoutError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaGatewayTimeoutError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaApiError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaApiError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaApiError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaApiError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaApiError: BetaApiError) = apply {
                                message = betaApiError.message
                                type = betaApiError.type
                                additionalProperties =
                                    betaApiError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaApiError =
                                BetaApiError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaApiError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaApiError{message=$message, type=$type, additionalProperties=$additionalProperties}"
                    }

                    @NoAutoDetect
                    class BetaOverloadedError
                    @JsonCreator
                    private constructor(
                        @JsonProperty("message")
                        @ExcludeMissing
                        private val message: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        private val type: JsonField<Type> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun message(): String = message.getRequired("message")

                        fun type(): Type = type.getRequired("type")

                        @JsonProperty("message")
                        @ExcludeMissing
                        fun _message(): JsonField<String> = message

                        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                        private var validated: Boolean = false

                        fun validate(): BetaOverloadedError = apply {
                            if (validated) {
                                return@apply
                            }

                            message()
                            type()
                            validated = true
                        }

                        fun toBuilder() = Builder().from(this)

                        companion object {

                            /**
                             * Returns a mutable builder for constructing an instance of
                             * [BetaOverloadedError].
                             *
                             * The following fields are required:
                             * ```kotlin
                             * .message()
                             * .type()
                             * ```
                             */
                            fun builder() = Builder()
                        }

                        /** A builder for [BetaOverloadedError]. */
                        class Builder internal constructor() {

                            private var message: JsonField<String>? = null
                            private var type: JsonField<Type>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            internal fun from(betaOverloadedError: BetaOverloadedError) = apply {
                                message = betaOverloadedError.message
                                type = betaOverloadedError.type
                                additionalProperties =
                                    betaOverloadedError.additionalProperties.toMutableMap()
                            }

                            fun message(message: String) = message(JsonField.of(message))

                            fun message(message: JsonField<String>) = apply {
                                this.message = message
                            }

                            fun type(type: Type) = type(JsonField.of(type))

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

                            fun build(): BetaOverloadedError =
                                BetaOverloadedError(
                                    checkRequired("message", message),
                                    checkRequired("type", type),
                                    additionalProperties.toImmutable(),
                                )
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

                            return /* spotless:off */ other is BetaOverloadedError && message == other.message && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(message, type, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "BetaOverloadedError{message=$message, type=$type, additionalProperties=$additionalProperties}"
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

                return /* spotless:off */ other is BetaErroredResult && error == other.error && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(error, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "BetaErroredResult{error=$error, type=$type, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class BetaCanceledResult
        @JsonCreator
        private constructor(
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun type(): Type = type.getRequired("type")

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): BetaCanceledResult = apply {
                if (validated) {
                    return@apply
                }

                type()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [BetaCanceledResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [BetaCanceledResult]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(betaCanceledResult: BetaCanceledResult) = apply {
                    type = betaCanceledResult.type
                    additionalProperties = betaCanceledResult.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

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

                fun build(): BetaCanceledResult =
                    BetaCanceledResult(
                        checkRequired("type", type),
                        additionalProperties.toImmutable(),
                    )
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

                return /* spotless:off */ other is BetaCanceledResult && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "BetaCanceledResult{type=$type, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class BetaExpiredResult
        @JsonCreator
        private constructor(
            @JsonProperty("type")
            @ExcludeMissing
            private val type: JsonField<Type> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun type(): Type = type.getRequired("type")

            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): BetaExpiredResult = apply {
                if (validated) {
                    return@apply
                }

                type()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [BetaExpiredResult].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .type()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [BetaExpiredResult]. */
            class Builder internal constructor() {

                private var type: JsonField<Type>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(betaExpiredResult: BetaExpiredResult) = apply {
                    type = betaExpiredResult.type
                    additionalProperties = betaExpiredResult.additionalProperties.toMutableMap()
                }

                fun type(type: Type) = type(JsonField.of(type))

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

                fun build(): BetaExpiredResult =
                    BetaExpiredResult(
                        checkRequired("type", type),
                        additionalProperties.toImmutable(),
                    )
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

                return /* spotless:off */ other is BetaExpiredResult && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "BetaExpiredResult{type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchResultsBetaResponse && customId == other.customId && result == other.result && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(customId, result, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchResultsBetaResponse{customId=$customId, result=$result, additionalProperties=$additionalProperties}"
}
