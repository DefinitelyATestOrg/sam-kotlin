// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches.betatrue

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
import me.elborai.api.core.checkRequired
import me.elborai.api.core.immutableEmptyMap
import me.elborai.api.core.toImmutable
import me.elborai.api.errors.SamInvalidDataException

@NoAutoDetect
class BetaTrueRetrieveResponse
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("archived_at")
    @ExcludeMissing
    private val archivedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("cancel_initiated_at")
    @ExcludeMissing
    private val cancelInitiatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("ended_at")
    @ExcludeMissing
    private val endedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("expires_at")
    @ExcludeMissing
    private val expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("processing_status")
    @ExcludeMissing
    private val processingStatus: JsonField<ProcessingStatus> = JsonMissing.of(),
    @JsonProperty("request_counts")
    @ExcludeMissing
    private val requestCounts: JsonField<RequestCounts> = JsonMissing.of(),
    @JsonProperty("results_url")
    @ExcludeMissing
    private val resultsUrl: JsonField<String> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     */
    fun id(): String = id.getRequired("id")

    /**
     * RFC 3339 datetime string representing the time at which the Message Batch was archived and
     * its results became unavailable.
     */
    fun archivedAt(): OffsetDateTime? = archivedAt.getNullable("archived_at")

    /**
     * RFC 3339 datetime string representing the time at which cancellation was initiated for the
     * Message Batch. Specified only if cancellation was initiated.
     */
    fun cancelInitiatedAt(): OffsetDateTime? = cancelInitiatedAt.getNullable("cancel_initiated_at")

    /** RFC 3339 datetime string representing the time at which the Message Batch was created. */
    fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

    /**
     * RFC 3339 datetime string representing the time at which processing for the Message Batch
     * ended. Specified only once processing ends.
     *
     * Processing ends when every request in a Message Batch has either succeeded, errored,
     * canceled, or expired.
     */
    fun endedAt(): OffsetDateTime? = endedAt.getNullable("ended_at")

    /**
     * RFC 3339 datetime string representing the time at which the Message Batch will expire and end
     * processing, which is 24 hours after creation.
     */
    fun expiresAt(): OffsetDateTime = expiresAt.getRequired("expires_at")

    /** Processing status of the Message Batch. */
    fun processingStatus(): ProcessingStatus = processingStatus.getRequired("processing_status")

    /**
     * Tallies requests within the Message Batch, categorized by their status.
     *
     * Requests start as `processing` and move to one of the other statuses only once processing of
     * the entire batch ends. The sum of all values always matches the total number of requests in
     * the batch.
     */
    fun requestCounts(): RequestCounts = requestCounts.getRequired("request_counts")

    /**
     * URL to a `.jsonl` file containing the results of the Message Batch requests. Specified only
     * once processing ends.
     *
     * Results in the file are not guaranteed to be in the same order as requests. Use the
     * `custom_id` field to match results to requests.
     */
    fun resultsUrl(): String? = resultsUrl.getNullable("results_url")

    /**
     * Object type.
     *
     * For Message Batches, this is always `"message_batch"`.
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Unique object identifier.
     *
     * The format and length of IDs may change over time.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * RFC 3339 datetime string representing the time at which the Message Batch was archived and
     * its results became unavailable.
     */
    @JsonProperty("archived_at")
    @ExcludeMissing
    fun _archivedAt(): JsonField<OffsetDateTime> = archivedAt

    /**
     * RFC 3339 datetime string representing the time at which cancellation was initiated for the
     * Message Batch. Specified only if cancellation was initiated.
     */
    @JsonProperty("cancel_initiated_at")
    @ExcludeMissing
    fun _cancelInitiatedAt(): JsonField<OffsetDateTime> = cancelInitiatedAt

    /** RFC 3339 datetime string representing the time at which the Message Batch was created. */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * RFC 3339 datetime string representing the time at which processing for the Message Batch
     * ended. Specified only once processing ends.
     *
     * Processing ends when every request in a Message Batch has either succeeded, errored,
     * canceled, or expired.
     */
    @JsonProperty("ended_at") @ExcludeMissing fun _endedAt(): JsonField<OffsetDateTime> = endedAt

    /**
     * RFC 3339 datetime string representing the time at which the Message Batch will expire and end
     * processing, which is 24 hours after creation.
     */
    @JsonProperty("expires_at")
    @ExcludeMissing
    fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

    /** Processing status of the Message Batch. */
    @JsonProperty("processing_status")
    @ExcludeMissing
    fun _processingStatus(): JsonField<ProcessingStatus> = processingStatus

    /**
     * Tallies requests within the Message Batch, categorized by their status.
     *
     * Requests start as `processing` and move to one of the other statuses only once processing of
     * the entire batch ends. The sum of all values always matches the total number of requests in
     * the batch.
     */
    @JsonProperty("request_counts")
    @ExcludeMissing
    fun _requestCounts(): JsonField<RequestCounts> = requestCounts

    /**
     * URL to a `.jsonl` file containing the results of the Message Batch requests. Specified only
     * once processing ends.
     *
     * Results in the file are not guaranteed to be in the same order as requests. Use the
     * `custom_id` field to match results to requests.
     */
    @JsonProperty("results_url") @ExcludeMissing fun _resultsUrl(): JsonField<String> = resultsUrl

    /**
     * Object type.
     *
     * For Message Batches, this is always `"message_batch"`.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): BetaTrueRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        archivedAt()
        cancelInitiatedAt()
        createdAt()
        endedAt()
        expiresAt()
        processingStatus()
        requestCounts().validate()
        resultsUrl()
        type()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BetaTrueRetrieveResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .id()
         * .archivedAt()
         * .cancelInitiatedAt()
         * .createdAt()
         * .endedAt()
         * .expiresAt()
         * .processingStatus()
         * .requestCounts()
         * .resultsUrl()
         * .type()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [BetaTrueRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var archivedAt: JsonField<OffsetDateTime>? = null
        private var cancelInitiatedAt: JsonField<OffsetDateTime>? = null
        private var createdAt: JsonField<OffsetDateTime>? = null
        private var endedAt: JsonField<OffsetDateTime>? = null
        private var expiresAt: JsonField<OffsetDateTime>? = null
        private var processingStatus: JsonField<ProcessingStatus>? = null
        private var requestCounts: JsonField<RequestCounts>? = null
        private var resultsUrl: JsonField<String>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(betaTrueRetrieveResponse: BetaTrueRetrieveResponse) = apply {
            id = betaTrueRetrieveResponse.id
            archivedAt = betaTrueRetrieveResponse.archivedAt
            cancelInitiatedAt = betaTrueRetrieveResponse.cancelInitiatedAt
            createdAt = betaTrueRetrieveResponse.createdAt
            endedAt = betaTrueRetrieveResponse.endedAt
            expiresAt = betaTrueRetrieveResponse.expiresAt
            processingStatus = betaTrueRetrieveResponse.processingStatus
            requestCounts = betaTrueRetrieveResponse.requestCounts
            resultsUrl = betaTrueRetrieveResponse.resultsUrl
            type = betaTrueRetrieveResponse.type
            additionalProperties = betaTrueRetrieveResponse.additionalProperties.toMutableMap()
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
         * RFC 3339 datetime string representing the time at which the Message Batch was archived
         * and its results became unavailable.
         */
        fun archivedAt(archivedAt: OffsetDateTime?) = archivedAt(JsonField.ofNullable(archivedAt))

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch was archived
         * and its results became unavailable.
         */
        fun archivedAt(archivedAt: JsonField<OffsetDateTime>) = apply {
            this.archivedAt = archivedAt
        }

        /**
         * RFC 3339 datetime string representing the time at which cancellation was initiated for
         * the Message Batch. Specified only if cancellation was initiated.
         */
        fun cancelInitiatedAt(cancelInitiatedAt: OffsetDateTime?) =
            cancelInitiatedAt(JsonField.ofNullable(cancelInitiatedAt))

        /**
         * RFC 3339 datetime string representing the time at which cancellation was initiated for
         * the Message Batch. Specified only if cancellation was initiated.
         */
        fun cancelInitiatedAt(cancelInitiatedAt: JsonField<OffsetDateTime>) = apply {
            this.cancelInitiatedAt = cancelInitiatedAt
        }

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch was created.
         */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch was created.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /**
         * RFC 3339 datetime string representing the time at which processing for the Message Batch
         * ended. Specified only once processing ends.
         *
         * Processing ends when every request in a Message Batch has either succeeded, errored,
         * canceled, or expired.
         */
        fun endedAt(endedAt: OffsetDateTime?) = endedAt(JsonField.ofNullable(endedAt))

        /**
         * RFC 3339 datetime string representing the time at which processing for the Message Batch
         * ended. Specified only once processing ends.
         *
         * Processing ends when every request in a Message Batch has either succeeded, errored,
         * canceled, or expired.
         */
        fun endedAt(endedAt: JsonField<OffsetDateTime>) = apply { this.endedAt = endedAt }

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch will expire and
         * end processing, which is 24 hours after creation.
         */
        fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch will expire and
         * end processing, which is 24 hours after creation.
         */
        fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply { this.expiresAt = expiresAt }

        /** Processing status of the Message Batch. */
        fun processingStatus(processingStatus: ProcessingStatus) =
            processingStatus(JsonField.of(processingStatus))

        /** Processing status of the Message Batch. */
        fun processingStatus(processingStatus: JsonField<ProcessingStatus>) = apply {
            this.processingStatus = processingStatus
        }

        /**
         * Tallies requests within the Message Batch, categorized by their status.
         *
         * Requests start as `processing` and move to one of the other statuses only once processing
         * of the entire batch ends. The sum of all values always matches the total number of
         * requests in the batch.
         */
        fun requestCounts(requestCounts: RequestCounts) = requestCounts(JsonField.of(requestCounts))

        /**
         * Tallies requests within the Message Batch, categorized by their status.
         *
         * Requests start as `processing` and move to one of the other statuses only once processing
         * of the entire batch ends. The sum of all values always matches the total number of
         * requests in the batch.
         */
        fun requestCounts(requestCounts: JsonField<RequestCounts>) = apply {
            this.requestCounts = requestCounts
        }

        /**
         * URL to a `.jsonl` file containing the results of the Message Batch requests. Specified
         * only once processing ends.
         *
         * Results in the file are not guaranteed to be in the same order as requests. Use the
         * `custom_id` field to match results to requests.
         */
        fun resultsUrl(resultsUrl: String?) = resultsUrl(JsonField.ofNullable(resultsUrl))

        /**
         * URL to a `.jsonl` file containing the results of the Message Batch requests. Specified
         * only once processing ends.
         *
         * Results in the file are not guaranteed to be in the same order as requests. Use the
         * `custom_id` field to match results to requests.
         */
        fun resultsUrl(resultsUrl: JsonField<String>) = apply { this.resultsUrl = resultsUrl }

        /**
         * Object type.
         *
         * For Message Batches, this is always `"message_batch"`.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Object type.
         *
         * For Message Batches, this is always `"message_batch"`.
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

        fun build(): BetaTrueRetrieveResponse =
            BetaTrueRetrieveResponse(
                checkRequired("id", id),
                checkRequired("archivedAt", archivedAt),
                checkRequired("cancelInitiatedAt", cancelInitiatedAt),
                checkRequired("createdAt", createdAt),
                checkRequired("endedAt", endedAt),
                checkRequired("expiresAt", expiresAt),
                checkRequired("processingStatus", processingStatus),
                checkRequired("requestCounts", requestCounts),
                checkRequired("resultsUrl", resultsUrl),
                checkRequired("type", type),
                additionalProperties.toImmutable(),
            )
    }

    /** Processing status of the Message Batch. */
    class ProcessingStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            val IN_PROGRESS = of("in_progress")

            val CANCELING = of("canceling")

            val ENDED = of("ended")

            fun of(value: String) = ProcessingStatus(JsonField.of(value))
        }

        /** An enum containing [ProcessingStatus]'s known values. */
        enum class Known {
            IN_PROGRESS,
            CANCELING,
            ENDED,
        }

        /**
         * An enum containing [ProcessingStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ProcessingStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IN_PROGRESS,
            CANCELING,
            ENDED,
            /**
             * An enum member indicating that [ProcessingStatus] was instantiated with an unknown
             * value.
             */
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
                IN_PROGRESS -> Value.IN_PROGRESS
                CANCELING -> Value.CANCELING
                ENDED -> Value.ENDED
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
                IN_PROGRESS -> Known.IN_PROGRESS
                CANCELING -> Known.CANCELING
                ENDED -> Known.ENDED
                else -> throw SamInvalidDataException("Unknown ProcessingStatus: $value")
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

            return /* spotless:off */ other is ProcessingStatus && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Tallies requests within the Message Batch, categorized by their status.
     *
     * Requests start as `processing` and move to one of the other statuses only once processing of
     * the entire batch ends. The sum of all values always matches the total number of requests in
     * the batch.
     */
    @NoAutoDetect
    class RequestCounts
    @JsonCreator
    private constructor(
        @JsonProperty("canceled")
        @ExcludeMissing
        private val canceled: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("errored")
        @ExcludeMissing
        private val errored: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("expired")
        @ExcludeMissing
        private val expired: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("processing")
        @ExcludeMissing
        private val processing: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("succeeded")
        @ExcludeMissing
        private val succeeded: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Number of requests in the Message Batch that have been canceled.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        fun canceled(): Long = canceled.getRequired("canceled")

        /**
         * Number of requests in the Message Batch that encountered an error.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        fun errored(): Long = errored.getRequired("errored")

        /**
         * Number of requests in the Message Batch that have expired.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        fun expired(): Long = expired.getRequired("expired")

        /** Number of requests in the Message Batch that are processing. */
        fun processing(): Long = processing.getRequired("processing")

        /**
         * Number of requests in the Message Batch that have completed successfully.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        fun succeeded(): Long = succeeded.getRequired("succeeded")

        /**
         * Number of requests in the Message Batch that have been canceled.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        @JsonProperty("canceled") @ExcludeMissing fun _canceled(): JsonField<Long> = canceled

        /**
         * Number of requests in the Message Batch that encountered an error.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        @JsonProperty("errored") @ExcludeMissing fun _errored(): JsonField<Long> = errored

        /**
         * Number of requests in the Message Batch that have expired.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        @JsonProperty("expired") @ExcludeMissing fun _expired(): JsonField<Long> = expired

        /** Number of requests in the Message Batch that are processing. */
        @JsonProperty("processing") @ExcludeMissing fun _processing(): JsonField<Long> = processing

        /**
         * Number of requests in the Message Batch that have completed successfully.
         *
         * This is zero until processing of the entire Message Batch has ended.
         */
        @JsonProperty("succeeded") @ExcludeMissing fun _succeeded(): JsonField<Long> = succeeded

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): RequestCounts = apply {
            if (validated) {
                return@apply
            }

            canceled()
            errored()
            expired()
            processing()
            succeeded()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [RequestCounts].
             *
             * The following fields are required:
             * ```kotlin
             * .canceled()
             * .errored()
             * .expired()
             * .processing()
             * .succeeded()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [RequestCounts]. */
        class Builder internal constructor() {

            private var canceled: JsonField<Long>? = null
            private var errored: JsonField<Long>? = null
            private var expired: JsonField<Long>? = null
            private var processing: JsonField<Long>? = null
            private var succeeded: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(requestCounts: RequestCounts) = apply {
                canceled = requestCounts.canceled
                errored = requestCounts.errored
                expired = requestCounts.expired
                processing = requestCounts.processing
                succeeded = requestCounts.succeeded
                additionalProperties = requestCounts.additionalProperties.toMutableMap()
            }

            /**
             * Number of requests in the Message Batch that have been canceled.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun canceled(canceled: Long) = canceled(JsonField.of(canceled))

            /**
             * Number of requests in the Message Batch that have been canceled.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun canceled(canceled: JsonField<Long>) = apply { this.canceled = canceled }

            /**
             * Number of requests in the Message Batch that encountered an error.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun errored(errored: Long) = errored(JsonField.of(errored))

            /**
             * Number of requests in the Message Batch that encountered an error.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun errored(errored: JsonField<Long>) = apply { this.errored = errored }

            /**
             * Number of requests in the Message Batch that have expired.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun expired(expired: Long) = expired(JsonField.of(expired))

            /**
             * Number of requests in the Message Batch that have expired.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun expired(expired: JsonField<Long>) = apply { this.expired = expired }

            /** Number of requests in the Message Batch that are processing. */
            fun processing(processing: Long) = processing(JsonField.of(processing))

            /** Number of requests in the Message Batch that are processing. */
            fun processing(processing: JsonField<Long>) = apply { this.processing = processing }

            /**
             * Number of requests in the Message Batch that have completed successfully.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun succeeded(succeeded: Long) = succeeded(JsonField.of(succeeded))

            /**
             * Number of requests in the Message Batch that have completed successfully.
             *
             * This is zero until processing of the entire Message Batch has ended.
             */
            fun succeeded(succeeded: JsonField<Long>) = apply { this.succeeded = succeeded }

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

            fun build(): RequestCounts =
                RequestCounts(
                    checkRequired("canceled", canceled),
                    checkRequired("errored", errored),
                    checkRequired("expired", expired),
                    checkRequired("processing", processing),
                    checkRequired("succeeded", succeeded),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is RequestCounts && canceled == other.canceled && errored == other.errored && expired == other.expired && processing == other.processing && succeeded == other.succeeded && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(canceled, errored, expired, processing, succeeded, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "RequestCounts{canceled=$canceled, errored=$errored, expired=$expired, processing=$processing, succeeded=$succeeded, additionalProperties=$additionalProperties}"
    }

    /**
     * Object type.
     *
     * For Message Batches, this is always `"message_batch"`.
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

            val MESSAGE_BATCH = of("message_batch")

            fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            MESSAGE_BATCH
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
            MESSAGE_BATCH,
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
                MESSAGE_BATCH -> Value.MESSAGE_BATCH
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
                MESSAGE_BATCH -> Known.MESSAGE_BATCH
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

        return /* spotless:off */ other is BetaTrueRetrieveResponse && id == other.id && archivedAt == other.archivedAt && cancelInitiatedAt == other.cancelInitiatedAt && createdAt == other.createdAt && endedAt == other.endedAt && expiresAt == other.expiresAt && processingStatus == other.processingStatus && requestCounts == other.requestCounts && resultsUrl == other.resultsUrl && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, archivedAt, cancelInitiatedAt, createdAt, endedAt, expiresAt, processingStatus, requestCounts, resultsUrl, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BetaTrueRetrieveResponse{id=$id, archivedAt=$archivedAt, cancelInitiatedAt=$cancelInitiatedAt, createdAt=$createdAt, endedAt=$endedAt, expiresAt=$expiresAt, processingStatus=$processingStatus, requestCounts=$requestCounts, resultsUrl=$resultsUrl, type=$type, additionalProperties=$additionalProperties}"
}
