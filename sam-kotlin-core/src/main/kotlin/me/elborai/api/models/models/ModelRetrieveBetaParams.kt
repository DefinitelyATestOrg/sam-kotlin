// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import java.util.Objects
import me.elborai.api.core.Params
import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.QueryParams

/**
 * Get a specific model.
 *
 * The Models API response can be used to determine information about a specific model or resolve a
 * model alias to a model ID.
 */
class ModelRetrieveBetaParams
private constructor(
    private val modelId: String?,
    private val anthropicVersion: String?,
    private val xApiKey: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Model identifier or alias. */
    fun modelId(): String? = modelId

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

        fun none(): ModelRetrieveBetaParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ModelRetrieveBetaParams]. */
        fun builder() = Builder()
    }

    /** A builder for [ModelRetrieveBetaParams]. */
    class Builder internal constructor() {

        private var modelId: String? = null
        private var anthropicVersion: String? = null
        private var xApiKey: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(modelRetrieveBetaParams: ModelRetrieveBetaParams) = apply {
            modelId = modelRetrieveBetaParams.modelId
            anthropicVersion = modelRetrieveBetaParams.anthropicVersion
            xApiKey = modelRetrieveBetaParams.xApiKey
            additionalHeaders = modelRetrieveBetaParams.additionalHeaders.toBuilder()
            additionalQueryParams = modelRetrieveBetaParams.additionalQueryParams.toBuilder()
        }

        /** Model identifier or alias. */
        fun modelId(modelId: String?) = apply { this.modelId = modelId }

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
            putAlladditional_headers(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAlladditional_headers(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putadditional_headers(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAlladditional_headers(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAlladditional_headers(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceadditional_headers(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceadditional_headers(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAlladditional_headers(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAlladditional_headers(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeadditional_headers(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAlladditional_headers(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAlladditional_query_params(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAlladditional_query_params(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putadditional_query_params(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAlladditional_query_params(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAlladditional_query_params(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceadditional_query_params(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceadditional_query_params(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAlladditional_query_params(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAlladditional_query_params(
            additionalQueryParams: Map<String, Iterable<String>>
        ) = apply { this.additionalQueryParams.replaceAll(additionalQueryParams) }

        fun removeadditional_query_params(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAlladditional_query_params(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ModelRetrieveBetaParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ModelRetrieveBetaParams =
            ModelRetrieveBetaParams(
                modelId,
                anthropicVersion,
                xApiKey,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> modelId ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                anthropicVersion?.let { put("anthropic-version", it) }
                xApiKey?.let { put("x-api-key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ModelRetrieveBetaParams &&
            modelId == other.modelId &&
            anthropicVersion == other.anthropicVersion &&
            xApiKey == other.xApiKey &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(modelId, anthropicVersion, xApiKey, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ModelRetrieveBetaParams{modelId=$modelId, anthropicVersion=$anthropicVersion, xApiKey=$xApiKey, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
