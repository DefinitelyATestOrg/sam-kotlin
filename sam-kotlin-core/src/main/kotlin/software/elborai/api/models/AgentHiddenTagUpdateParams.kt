// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.models.*

class AgentHiddenTagUpdateParams
constructor(
    private val id: String,
    private val body: List<String>,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun id(): String = id

    fun body(): List<String> = body

    internal fun getBody(): List<String> {
        return body
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> id
            else -> ""
        }
    }

    @JsonDeserialize(builder = AgentHiddenTagUpdateBody.Builder::class)
    @NoAutoDetect
    class AgentHiddenTagUpdateBody
    internal constructor(
        private val body: List<String>?,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("body") fun body(): List<String>? = body

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentHiddenTagUpdateBody && this.body == other.body
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(body)
            }
            return hashCode
        }

        override fun toString() = "AgentHiddenTagUpdateBody{body=$body}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var body: List<String>? = null

            internal fun from(agentHiddenTagUpdateBody: AgentHiddenTagUpdateBody) = apply {
                this.body = agentHiddenTagUpdateBody.body
            }

            @JsonProperty("body") fun body(body: List<String>) = apply { this.body = body }
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentHiddenTagUpdateParams &&
            this.id == other.id &&
            this.body == other.body &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            body,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "AgentHiddenTagUpdateParams{id=$id, body=$body, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var body: MutableList<String> = mutableListOf()
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(agentHiddenTagUpdateParams: AgentHiddenTagUpdateParams) = apply {
            this.id = agentHiddenTagUpdateParams.id
            this.body(agentHiddenTagUpdateParams.body)
            additionalQueryParams(agentHiddenTagUpdateParams.additionalQueryParams)
            additionalHeaders(agentHiddenTagUpdateParams.additionalHeaders)
        }

        fun id(id: String) = apply { this.id = id }

        fun body(body: List<String>) = apply {
            this.body.clear()
            this.body.addAll(body)
        }

        fun addBody(body: String) = apply { this.body.add(body) }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun build(): AgentHiddenTagUpdateParams =
            AgentHiddenTagUpdateParams(
                checkNotNull(id) { "`id` is required but was not set" },
                checkNotNull(body) { "`body` is required but was not set" }.toUnmodifiable(),
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }
}
