// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models.models

import java.util.Objects
import me.elborai.api.core.NoAutoDetect
import me.elborai.api.core.Params
import me.elborai.api.core.checkRequired
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
    private val modelId: String,
    private val anthropicVersion: String?,
    private val xApiKey: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Model identifier or alias. */
    fun modelId(): String = modelId

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

    override fun _headers(): Headers {
        val headers = Headers.builder()
        this.anthropicVersion?.let { headers.put("anthropic-version", listOf(it.toString())) }
        this.xApiKey?.let { headers.put("x-api-key", listOf(it.toString())) }
        headers.putAll(additionalHeaders)
        return headers.build()
    }

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> modelId
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ModelRetrieveBetaParams].
         *
         * The following fields are required:
         * ```kotlin
         * .modelId()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [ModelRetrieveBetaParams]. */
    @NoAutoDetect
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
        fun modelId(modelId: String) = apply { this.modelId = modelId }

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

        fun build(): ModelRetrieveBetaParams =
            ModelRetrieveBetaParams(
                checkRequired("modelId", modelId),
                anthropicVersion,
                xApiKey,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelRetrieveBetaParams && modelId == other.modelId && anthropicVersion == other.anthropicVersion && xApiKey == other.xApiKey && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(modelId, anthropicVersion, xApiKey, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ModelRetrieveBetaParams{modelId=$modelId, anthropicVersion=$anthropicVersion, xApiKey=$xApiKey, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
