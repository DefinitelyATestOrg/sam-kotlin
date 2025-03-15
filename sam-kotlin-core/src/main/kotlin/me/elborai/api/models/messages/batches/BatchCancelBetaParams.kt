// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.messages.batches

import java.util.Objects
import me.elborai.api.core.JsonValue
import me.elborai.api.core.NoAutoDetect
import me.elborai.api.core.Params
import me.elborai.api.core.checkRequired
import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.QueryParams
import me.elborai.api.core.toImmutable

/**
 * Batches may be canceled any time before processing ends. Once cancellation is initiated, the
 * batch enters a `canceling` state, at which time the system may complete any in-progress,
 * non-interruptible requests before finalizing cancellation.
 *
 * The number of canceled requests is specified in `request_counts`. To determine which requests
 * were canceled, check the individual results within the batch. Note that cancellation may not
 * result in any canceled requests if they were non-interruptible.
 *
 * Learn more about the Message Batches API in our
 * [user guide](/en/docs/build-with-claude/batch-processing)
 */
class BatchCancelBetaParams
private constructor(
    private val messageBatchId: String,
    private val anthropicBeta: List<String>?,
    private val anthropicVersion: String?,
    private val xApiKey: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) : Params {

    /** ID of the Message Batch. */
    fun messageBatchId(): String = messageBatchId

    /**
     * Optional header to specify the beta version(s) you want to use.
     *
     * To use multiple betas, use a comma separated list like `beta1,beta2` or specify the header
     * multiple times for each beta.
     */
    fun anthropicBeta(): List<String>? = anthropicBeta

    /**
     * The version of the Anthropic API you want to use.
     *
     * Read more about versioning and our version history
     * [here](https://docs.anthropic.com/en/api/versioning).
     */
    fun anthropicVersion(): String? = anthropicVersion

    /**
     * Your unique API key for authentication.
     *
     * This key is required in the header of all API requests, to authenticate your account and
     * access Anthropic's services. Get your API key through the
     * [Console](https://console.anthropic.com/settings/keys). Each key is scoped to a Workspace.
     */
    fun xApiKey(): String? = xApiKey

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    internal fun _body(): Map<String, JsonValue>? = additionalBodyProperties.ifEmpty { null }

    override fun _headers(): Headers {
        val headers = Headers.builder()
        this.anthropicBeta?.let { headers.put("anthropic-beta", it.map(Any::toString)) }
        this.anthropicVersion?.let { headers.put("anthropic-version", listOf(it.toString())) }
        this.xApiKey?.let { headers.put("x-api-key", listOf(it.toString())) }
        headers.putAll(additionalHeaders)
        return headers.build()
    }

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> messageBatchId
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchCancelBetaParams].
         *
         * The following fields are required:
         * ```kotlin
         * .messageBatchId()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [BatchCancelBetaParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var messageBatchId: String? = null
        private var anthropicBeta: MutableList<String>? = null
        private var anthropicVersion: String? = null
        private var xApiKey: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(batchCancelBetaParams: BatchCancelBetaParams) = apply {
            messageBatchId = batchCancelBetaParams.messageBatchId
            anthropicBeta = batchCancelBetaParams.anthropicBeta?.toMutableList()
            anthropicVersion = batchCancelBetaParams.anthropicVersion
            xApiKey = batchCancelBetaParams.xApiKey
            additionalHeaders = batchCancelBetaParams.additionalHeaders.toBuilder()
            additionalQueryParams = batchCancelBetaParams.additionalQueryParams.toBuilder()
            additionalBodyProperties = batchCancelBetaParams.additionalBodyProperties.toMutableMap()
        }

        /** ID of the Message Batch. */
        fun messageBatchId(messageBatchId: String) = apply { this.messageBatchId = messageBatchId }

        /**
         * Optional header to specify the beta version(s) you want to use.
         *
         * To use multiple betas, use a comma separated list like `beta1,beta2` or specify the
         * header multiple times for each beta.
         */
        fun anthropicBeta(anthropicBeta: List<String>?) = apply {
            this.anthropicBeta = anthropicBeta?.toMutableList()
        }

        /**
         * Adds a single [String] to [Builder.anthropicBeta].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAnthropicBeta(anthropicBeta: String) = apply {
            this.anthropicBeta =
                (this.anthropicBeta ?: mutableListOf()).apply { add(anthropicBeta) }
        }

        /**
         * The version of the Anthropic API you want to use.
         *
         * Read more about versioning and our version history
         * [here](https://docs.anthropic.com/en/api/versioning).
         */
        fun anthropicVersion(anthropicVersion: String?) = apply {
            this.anthropicVersion = anthropicVersion
        }

        /**
         * Your unique API key for authentication.
         *
         * This key is required in the header of all API requests, to authenticate your account and
         * access Anthropic's services. Get your API key through the
         * [Console](https://console.anthropic.com/settings/keys). Each key is scoped to a
         * Workspace.
         */
        fun xApiKey(xApiKey: String?) = apply { this.xApiKey = xApiKey }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): BatchCancelBetaParams =
            BatchCancelBetaParams(
                checkRequired("messageBatchId", messageBatchId),
                anthropicBeta?.toImmutable(),
                anthropicVersion,
                xApiKey,
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchCancelBetaParams && messageBatchId == other.messageBatchId && anthropicBeta == other.anthropicBeta && anthropicVersion == other.anthropicVersion && xApiKey == other.xApiKey && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams && additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messageBatchId, anthropicBeta, anthropicVersion, xApiKey, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */

    override fun toString() =
        "BatchCancelBetaParams{messageBatchId=$messageBatchId, anthropicBeta=$anthropicBeta, anthropicVersion=$anthropicVersion, xApiKey=$xApiKey, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"
}
