// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import me.elborai.api.core.Enum
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.checkKnown
import me.elborai.api.core.checkRequired
import me.elborai.api.core.toImmutable
import me.elborai.api.errors.SamInvalidDataException

class BatchListResponse
private constructor(
    private val data: JsonField<List<Data>>,
    private val firstId: JsonField<String>,
    private val hasMore: JsonField<Boolean>,
    private val lastId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<List<Data>> = JsonMissing.of(),
        @JsonProperty("first_id") @ExcludeMissing firstId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_id") @ExcludeMissing lastId: JsonField<String> = JsonMissing.of(),
    ) : this(data, firstId, hasMore, lastId, mutableMapOf())

    /**
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): List<Data> = data.getRequired("data")

    /**
     * First ID in the `data` list. Can be used as the `before_id` for the previous page.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun firstId(): String? = firstId.getNullable("first_id")

    /**
     * Indicates if there are more results in the requested page direction.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun hasMore(): Boolean = hasMore.getRequired("has_more")

    /**
     * Last ID in the `data` list. Can be used as the `after_id` for the next page.
     *
     * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun lastId(): String? = lastId.getNullable("last_id")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Data>> = data

    /**
     * Returns the raw JSON value of [firstId].
     *
     * Unlike [firstId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("first_id") @ExcludeMissing fun _firstId(): JsonField<String> = firstId

    /**
     * Returns the raw JSON value of [hasMore].
     *
     * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

    /**
     * Returns the raw JSON value of [lastId].
     *
     * Unlike [lastId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_id") @ExcludeMissing fun _lastId(): JsonField<String> = lastId

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
         * Returns a mutable builder for constructing an instance of [BatchListResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [BatchListResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<MutableList<Data>>? = null
        private var firstId: JsonField<String>? = null
        private var hasMore: JsonField<Boolean>? = null
        private var lastId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(batchListResponse: BatchListResponse) = apply {
            data = batchListResponse.data.map { it.toMutableList() }
            firstId = batchListResponse.firstId
            hasMore = batchListResponse.hasMore
            lastId = batchListResponse.lastId
            additionalProperties = batchListResponse.additionalProperties.toMutableMap()
        }

        fun data(data: List<Data>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<Data>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<List<Data>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [Data] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: Data) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** First ID in the `data` list. Can be used as the `before_id` for the previous page. */
        fun firstId(firstId: String?) = firstId(JsonField.ofNullable(firstId))

        /**
         * Sets [Builder.firstId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.firstId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun firstId(firstId: JsonField<String>) = apply { this.firstId = firstId }

        /** Indicates if there are more results in the requested page direction. */
        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** Last ID in the `data` list. Can be used as the `after_id` for the next page. */
        fun lastId(lastId: String?) = lastId(JsonField.ofNullable(lastId))

        /**
         * Sets [Builder.lastId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun lastId(lastId: JsonField<String>) = apply { this.lastId = lastId }

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
         * Returns an immutable instance of [BatchListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .data()
         * .firstId()
         * .hasMore()
         * .lastId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BatchListResponse =
            BatchListResponse(
                checkRequired("data", data).map { it.toImmutable() },
                checkRequired("firstId", firstId),
                checkRequired("hasMore", hasMore),
                checkRequired("lastId", lastId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BatchListResponse = apply {
        if (validated) {
            return@apply
        }

        data().forEach { it.validate() }
        firstId()
        hasMore()
        lastId()
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
        (data.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (firstId.asKnown() == null) 0 else 1) +
            (if (hasMore.asKnown() == null) 0 else 1) +
            (if (lastId.asKnown() == null) 0 else 1)

    class Data
    private constructor(
        private val id: JsonField<String>,
        private val archivedAt: JsonField<OffsetDateTime>,
        private val cancelInitiatedAt: JsonField<OffsetDateTime>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val endedAt: JsonField<OffsetDateTime>,
        private val expiresAt: JsonField<OffsetDateTime>,
        private val processingStatus: JsonField<ProcessingStatus>,
        private val requestCounts: JsonField<RequestCounts>,
        private val resultsUrl: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("archived_at")
            @ExcludeMissing
            archivedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("cancel_initiated_at")
            @ExcludeMissing
            cancelInitiatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("created_at")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("ended_at")
            @ExcludeMissing
            endedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("processing_status")
            @ExcludeMissing
            processingStatus: JsonField<ProcessingStatus> = JsonMissing.of(),
            @JsonProperty("request_counts")
            @ExcludeMissing
            requestCounts: JsonField<RequestCounts> = JsonMissing.of(),
            @JsonProperty("results_url")
            @ExcludeMissing
            resultsUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(
            id,
            archivedAt,
            cancelInitiatedAt,
            createdAt,
            endedAt,
            expiresAt,
            processingStatus,
            requestCounts,
            resultsUrl,
            type,
            mutableMapOf(),
        )

        /**
         * Unique object identifier.
         *
         * The format and length of IDs may change over time.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch was archived
         * and its results became unavailable.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun archivedAt(): OffsetDateTime? = archivedAt.getNullable("archived_at")

        /**
         * RFC 3339 datetime string representing the time at which cancellation was initiated for
         * the Message Batch. Specified only if cancellation was initiated.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cancelInitiatedAt(): OffsetDateTime? =
            cancelInitiatedAt.getNullable("cancel_initiated_at")

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch was created.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun createdAt(): OffsetDateTime = createdAt.getRequired("created_at")

        /**
         * RFC 3339 datetime string representing the time at which processing for the Message Batch
         * ended. Specified only once processing ends.
         *
         * Processing ends when every request in a Message Batch has either succeeded, errored,
         * canceled, or expired.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun endedAt(): OffsetDateTime? = endedAt.getNullable("ended_at")

        /**
         * RFC 3339 datetime string representing the time at which the Message Batch will expire and
         * end processing, which is 24 hours after creation.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun expiresAt(): OffsetDateTime = expiresAt.getRequired("expires_at")

        /**
         * Processing status of the Message Batch.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun processingStatus(): ProcessingStatus = processingStatus.getRequired("processing_status")

        /**
         * Tallies requests within the Message Batch, categorized by their status.
         *
         * Requests start as `processing` and move to one of the other statuses only once processing
         * of the entire batch ends. The sum of all values always matches the total number of
         * requests in the batch.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun requestCounts(): RequestCounts = requestCounts.getRequired("request_counts")

        /**
         * URL to a `.jsonl` file containing the results of the Message Batch requests. Specified
         * only once processing ends.
         *
         * Results in the file are not guaranteed to be in the same order as requests. Use the
         * `custom_id` field to match results to requests.
         *
         * @throws SamInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun resultsUrl(): String? = resultsUrl.getNullable("results_url")

        /**
         * Object type.
         *
         * For Message Batches, this is always `"message_batch"`.
         *
         * Expected to always return the following:
         * ```kotlin
         * JsonValue.from("message_batch")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [archivedAt].
         *
         * Unlike [archivedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("archived_at")
        @ExcludeMissing
        fun _archivedAt(): JsonField<OffsetDateTime> = archivedAt

        /**
         * Returns the raw JSON value of [cancelInitiatedAt].
         *
         * Unlike [cancelInitiatedAt], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cancel_initiated_at")
        @ExcludeMissing
        fun _cancelInitiatedAt(): JsonField<OffsetDateTime> = cancelInitiatedAt

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [endedAt].
         *
         * Unlike [endedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ended_at")
        @ExcludeMissing
        fun _endedAt(): JsonField<OffsetDateTime> = endedAt

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

        /**
         * Returns the raw JSON value of [processingStatus].
         *
         * Unlike [processingStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("processing_status")
        @ExcludeMissing
        fun _processingStatus(): JsonField<ProcessingStatus> = processingStatus

        /**
         * Returns the raw JSON value of [requestCounts].
         *
         * Unlike [requestCounts], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("request_counts")
        @ExcludeMissing
        fun _requestCounts(): JsonField<RequestCounts> = requestCounts

        /**
         * Returns the raw JSON value of [resultsUrl].
         *
         * Unlike [resultsUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("results_url")
        @ExcludeMissing
        fun _resultsUrl(): JsonField<String> = resultsUrl

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
             * Returns a mutable builder for constructing an instance of [Data].
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
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [Data]. */
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
            private var type: JsonValue = JsonValue.from("message_batch")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(data: Data) = apply {
                id = data.id
                archivedAt = data.archivedAt
                cancelInitiatedAt = data.cancelInitiatedAt
                createdAt = data.createdAt
                endedAt = data.endedAt
                expiresAt = data.expiresAt
                processingStatus = data.processingStatus
                requestCounts = data.requestCounts
                resultsUrl = data.resultsUrl
                type = data.type
                additionalProperties = data.additionalProperties.toMutableMap()
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
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * RFC 3339 datetime string representing the time at which the Message Batch was
             * archived and its results became unavailable.
             */
            fun archivedAt(archivedAt: OffsetDateTime?) =
                archivedAt(JsonField.ofNullable(archivedAt))

            /**
             * Sets [Builder.archivedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.archivedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun archivedAt(archivedAt: JsonField<OffsetDateTime>) = apply {
                this.archivedAt = archivedAt
            }

            /**
             * RFC 3339 datetime string representing the time at which cancellation was initiated
             * for the Message Batch. Specified only if cancellation was initiated.
             */
            fun cancelInitiatedAt(cancelInitiatedAt: OffsetDateTime?) =
                cancelInitiatedAt(JsonField.ofNullable(cancelInitiatedAt))

            /**
             * Sets [Builder.cancelInitiatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cancelInitiatedAt] with a well-typed
             * [OffsetDateTime] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun cancelInitiatedAt(cancelInitiatedAt: JsonField<OffsetDateTime>) = apply {
                this.cancelInitiatedAt = cancelInitiatedAt
            }

            /**
             * RFC 3339 datetime string representing the time at which the Message Batch was
             * created.
             */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /**
             * RFC 3339 datetime string representing the time at which processing for the Message
             * Batch ended. Specified only once processing ends.
             *
             * Processing ends when every request in a Message Batch has either succeeded, errored,
             * canceled, or expired.
             */
            fun endedAt(endedAt: OffsetDateTime?) = endedAt(JsonField.ofNullable(endedAt))

            /**
             * Sets [Builder.endedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endedAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endedAt(endedAt: JsonField<OffsetDateTime>) = apply { this.endedAt = endedAt }

            /**
             * RFC 3339 datetime string representing the time at which the Message Batch will expire
             * and end processing, which is 24 hours after creation.
             */
            fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply {
                this.expiresAt = expiresAt
            }

            /** Processing status of the Message Batch. */
            fun processingStatus(processingStatus: ProcessingStatus) =
                processingStatus(JsonField.of(processingStatus))

            /**
             * Sets [Builder.processingStatus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.processingStatus] with a well-typed
             * [ProcessingStatus] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun processingStatus(processingStatus: JsonField<ProcessingStatus>) = apply {
                this.processingStatus = processingStatus
            }

            /**
             * Tallies requests within the Message Batch, categorized by their status.
             *
             * Requests start as `processing` and move to one of the other statuses only once
             * processing of the entire batch ends. The sum of all values always matches the total
             * number of requests in the batch.
             */
            fun requestCounts(requestCounts: RequestCounts) =
                requestCounts(JsonField.of(requestCounts))

            /**
             * Sets [Builder.requestCounts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestCounts] with a well-typed [RequestCounts]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun requestCounts(requestCounts: JsonField<RequestCounts>) = apply {
                this.requestCounts = requestCounts
            }

            /**
             * URL to a `.jsonl` file containing the results of the Message Batch requests.
             * Specified only once processing ends.
             *
             * Results in the file are not guaranteed to be in the same order as requests. Use the
             * `custom_id` field to match results to requests.
             */
            fun resultsUrl(resultsUrl: String?) = resultsUrl(JsonField.ofNullable(resultsUrl))

            /**
             * Sets [Builder.resultsUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resultsUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resultsUrl(resultsUrl: JsonField<String>) = apply { this.resultsUrl = resultsUrl }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```kotlin
             * JsonValue.from("message_batch")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
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
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("archivedAt", archivedAt),
                    checkRequired("cancelInitiatedAt", cancelInitiatedAt),
                    checkRequired("createdAt", createdAt),
                    checkRequired("endedAt", endedAt),
                    checkRequired("expiresAt", expiresAt),
                    checkRequired("processingStatus", processingStatus),
                    checkRequired("requestCounts", requestCounts),
                    checkRequired("resultsUrl", resultsUrl),
                    type,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            id()
            archivedAt()
            cancelInitiatedAt()
            createdAt()
            endedAt()
            expiresAt()
            processingStatus().validate()
            requestCounts().validate()
            resultsUrl()
            _type().let {
                if (it != JsonValue.from("message_batch")) {
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
            (if (id.asKnown() == null) 0 else 1) +
                (if (archivedAt.asKnown() == null) 0 else 1) +
                (if (cancelInitiatedAt.asKnown() == null) 0 else 1) +
                (if (createdAt.asKnown() == null) 0 else 1) +
                (if (endedAt.asKnown() == null) 0 else 1) +
                (if (expiresAt.asKnown() == null) 0 else 1) +
                (processingStatus.asKnown()?.validity() ?: 0) +
                (requestCounts.asKnown()?.validity() ?: 0) +
                (if (resultsUrl.asKnown() == null) 0 else 1) +
                type.let { if (it == JsonValue.from("message_batch")) 1 else 0 }

        /** Processing status of the Message Batch. */
        class ProcessingStatus
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * An enum containing [ProcessingStatus]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [ProcessingStatus] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IN_PROGRESS,
                CANCELING,
                ENDED,
                /**
                 * An enum member indicating that [ProcessingStatus] was instantiated with an
                 * unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SamInvalidDataException if this class instance's value is a not a known
             *   member.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SamInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString() ?: throw SamInvalidDataException("Value is not a String")

            private var validated: Boolean = false

            fun validate(): ProcessingStatus = apply {
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

                return /* spotless:off */ other is ProcessingStatus && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /**
         * Tallies requests within the Message Batch, categorized by their status.
         *
         * Requests start as `processing` and move to one of the other statuses only once processing
         * of the entire batch ends. The sum of all values always matches the total number of
         * requests in the batch.
         */
        class RequestCounts
        private constructor(
            private val canceled: JsonField<Long>,
            private val errored: JsonField<Long>,
            private val expired: JsonField<Long>,
            private val processing: JsonField<Long>,
            private val succeeded: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("canceled")
                @ExcludeMissing
                canceled: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("errored")
                @ExcludeMissing
                errored: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("expired")
                @ExcludeMissing
                expired: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("processing")
                @ExcludeMissing
                processing: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("succeeded")
                @ExcludeMissing
                succeeded: JsonField<Long> = JsonMissing.of(),
            ) : this(canceled, errored, expired, processing, succeeded, mutableMapOf())

            /**
             * Number of requests in the Message Batch that have been canceled.
             *
             * This is zero until processing of the entire Message Batch has ended.
             *
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun canceled(): Long = canceled.getRequired("canceled")

            /**
             * Number of requests in the Message Batch that encountered an error.
             *
             * This is zero until processing of the entire Message Batch has ended.
             *
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun errored(): Long = errored.getRequired("errored")

            /**
             * Number of requests in the Message Batch that have expired.
             *
             * This is zero until processing of the entire Message Batch has ended.
             *
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun expired(): Long = expired.getRequired("expired")

            /**
             * Number of requests in the Message Batch that are processing.
             *
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun processing(): Long = processing.getRequired("processing")

            /**
             * Number of requests in the Message Batch that have completed successfully.
             *
             * This is zero until processing of the entire Message Batch has ended.
             *
             * @throws SamInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun succeeded(): Long = succeeded.getRequired("succeeded")

            /**
             * Returns the raw JSON value of [canceled].
             *
             * Unlike [canceled], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("canceled") @ExcludeMissing fun _canceled(): JsonField<Long> = canceled

            /**
             * Returns the raw JSON value of [errored].
             *
             * Unlike [errored], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("errored") @ExcludeMissing fun _errored(): JsonField<Long> = errored

            /**
             * Returns the raw JSON value of [expired].
             *
             * Unlike [expired], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("expired") @ExcludeMissing fun _expired(): JsonField<Long> = expired

            /**
             * Returns the raw JSON value of [processing].
             *
             * Unlike [processing], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("processing")
            @ExcludeMissing
            fun _processing(): JsonField<Long> = processing

            /**
             * Returns the raw JSON value of [succeeded].
             *
             * Unlike [succeeded], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("succeeded") @ExcludeMissing fun _succeeded(): JsonField<Long> = succeeded

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
                 * Sets [Builder.canceled] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.canceled] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun canceled(canceled: JsonField<Long>) = apply { this.canceled = canceled }

                /**
                 * Number of requests in the Message Batch that encountered an error.
                 *
                 * This is zero until processing of the entire Message Batch has ended.
                 */
                fun errored(errored: Long) = errored(JsonField.of(errored))

                /**
                 * Sets [Builder.errored] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.errored] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun errored(errored: JsonField<Long>) = apply { this.errored = errored }

                /**
                 * Number of requests in the Message Batch that have expired.
                 *
                 * This is zero until processing of the entire Message Batch has ended.
                 */
                fun expired(expired: Long) = expired(JsonField.of(expired))

                /**
                 * Sets [Builder.expired] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.expired] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun expired(expired: JsonField<Long>) = apply { this.expired = expired }

                /** Number of requests in the Message Batch that are processing. */
                fun processing(processing: Long) = processing(JsonField.of(processing))

                /**
                 * Sets [Builder.processing] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.processing] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun processing(processing: JsonField<Long>) = apply { this.processing = processing }

                /**
                 * Number of requests in the Message Batch that have completed successfully.
                 *
                 * This is zero until processing of the entire Message Batch has ended.
                 */
                fun succeeded(succeeded: Long) = succeeded(JsonField.of(succeeded))

                /**
                 * Sets [Builder.succeeded] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.succeeded] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun succeeded(succeeded: JsonField<Long>) = apply { this.succeeded = succeeded }

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
                 * Returns an immutable instance of [RequestCounts].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .canceled()
                 * .errored()
                 * .expired()
                 * .processing()
                 * .succeeded()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): RequestCounts =
                    RequestCounts(
                        checkRequired("canceled", canceled),
                        checkRequired("errored", errored),
                        checkRequired("expired", expired),
                        checkRequired("processing", processing),
                        checkRequired("succeeded", succeeded),
                        additionalProperties.toMutableMap(),
                    )
            }

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
                (if (canceled.asKnown() == null) 0 else 1) +
                    (if (errored.asKnown() == null) 0 else 1) +
                    (if (expired.asKnown() == null) 0 else 1) +
                    (if (processing.asKnown() == null) 0 else 1) +
                    (if (succeeded.asKnown() == null) 0 else 1)

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && id == other.id && archivedAt == other.archivedAt && cancelInitiatedAt == other.cancelInitiatedAt && createdAt == other.createdAt && endedAt == other.endedAt && expiresAt == other.expiresAt && processingStatus == other.processingStatus && requestCounts == other.requestCounts && resultsUrl == other.resultsUrl && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, archivedAt, cancelInitiatedAt, createdAt, endedAt, expiresAt, processingStatus, requestCounts, resultsUrl, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, archivedAt=$archivedAt, cancelInitiatedAt=$cancelInitiatedAt, createdAt=$createdAt, endedAt=$endedAt, expiresAt=$expiresAt, processingStatus=$processingStatus, requestCounts=$requestCounts, resultsUrl=$resultsUrl, type=$type, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchListResponse && data == other.data && firstId == other.firstId && hasMore == other.hasMore && lastId == other.lastId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, firstId, hasMore, lastId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchListResponse{data=$data, firstId=$firstId, hasMore=$hasMore, lastId=$lastId, additionalProperties=$additionalProperties}"
}
