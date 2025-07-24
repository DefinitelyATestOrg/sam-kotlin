// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import java.util.Objects
import me.elborai.api.core.Params
import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.QueryParams

/**
 * List available models.
 *
 * The Models API response can be used to determine which models are available for use in the API.
 * More recently released models are listed first.
 */
class ModelListParams
private constructor(
    private val afterId: String?,
    private val beforeId: String?,
    private val limit: Long?,
    private val anthropicVersion: String?,
    private val xApiKey: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * ID of the object to use as a cursor for pagination. When provided, returns the page of
     * results immediately after this object.
     */
    fun afterId(): String? = afterId

    /**
     * ID of the object to use as a cursor for pagination. When provided, returns the page of
     * results immediately before this object.
     */
    fun beforeId(): String? = beforeId

    /**
     * Number of items to return per page.
     *
     * Defaults to `20`. Ranges from `1` to `1000`.
     */
    fun limit(): Long? = limit

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

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        fun none(): ModelListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ModelListParams]. */
        fun builder() = Builder()
    }

    /** A builder for [ModelListParams]. */
    class Builder internal constructor() {

        private var afterId: String? = null
        private var beforeId: String? = null
        private var limit: Long? = null
        private var anthropicVersion: String? = null
        private var xApiKey: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(modelListParams: ModelListParams) = apply {
            afterId = modelListParams.afterId
            beforeId = modelListParams.beforeId
            limit = modelListParams.limit
            anthropicVersion = modelListParams.anthropicVersion
            xApiKey = modelListParams.xApiKey
            additionalHeaders = modelListParams.additionalHeaders.toBuilder()
            additionalQueryParams = modelListParams.additionalQueryParams.toBuilder()
        }

        /**
         * ID of the object to use as a cursor for pagination. When provided, returns the page of
         * results immediately after this object.
         */
        fun afterId(afterId: String?) = apply { this.afterId = afterId }

        /**
         * ID of the object to use as a cursor for pagination. When provided, returns the page of
         * results immediately before this object.
         */
        fun beforeId(beforeId: String?) = apply { this.beforeId = beforeId }

        /**
         * Number of items to return per page.
         *
         * Defaults to `20`. Ranges from `1` to `1000`.
         */
        fun limit(limit: Long?) = apply { this.limit = limit }

        /**
         * Alias for [Builder.limit].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun limit(limit: Long) = limit(limit as Long?)

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

        /**
         * Returns an immutable instance of [ModelListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ModelListParams =
            ModelListParams(
                afterId,
                beforeId,
                limit,
                anthropicVersion,
                xApiKey,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                anthropicVersion?.let { put("anthropic-version", it) }
                xApiKey?.let { put("x-api-key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                afterId?.let { put("after_id", it) }
                beforeId?.let { put("before_id", it) }
                limit?.let { put("limit", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelListParams && afterId == other.afterId && beforeId == other.beforeId && limit == other.limit && anthropicVersion == other.anthropicVersion && xApiKey == other.xApiKey && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(afterId, beforeId, limit, anthropicVersion, xApiKey, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ModelListParams{afterId=$afterId, beforeId=$beforeId, limit=$limit, anthropicVersion=$anthropicVersion, xApiKey=$xApiKey, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
