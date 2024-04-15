// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.models.*

class AgentConfigChatUpdateParams
constructor(
    private val agentId: String,
    private val id: String?,
    private val welcomeMessage: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun agentId(): String = agentId

    fun id(): String? = id

    fun welcomeMessage(): String? = welcomeMessage

    internal fun getBody(): AgentConfigChatUpdateBody {
        return AgentConfigChatUpdateBody(
            id,
            welcomeMessage,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> agentId
            else -> ""
        }
    }

    @JsonDeserialize(builder = AgentConfigChatUpdateBody.Builder::class)
    @NoAutoDetect
    class AgentConfigChatUpdateBody
    internal constructor(
        private val id: String?,
        private val welcomeMessage: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("welcomeMessage") fun welcomeMessage(): String? = welcomeMessage

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentConfigChatUpdateBody &&
                this.id == other.id &&
                this.welcomeMessage == other.welcomeMessage &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        welcomeMessage,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AgentConfigChatUpdateBody{id=$id, welcomeMessage=$welcomeMessage, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var welcomeMessage: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(agentConfigChatUpdateBody: AgentConfigChatUpdateBody) = apply {
                this.id = agentConfigChatUpdateBody.id
                this.welcomeMessage = agentConfigChatUpdateBody.welcomeMessage
                additionalProperties(agentConfigChatUpdateBody.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("welcomeMessage")
            fun welcomeMessage(welcomeMessage: String) = apply {
                this.welcomeMessage = welcomeMessage
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): AgentConfigChatUpdateBody =
                AgentConfigChatUpdateBody(
                    id,
                    welcomeMessage,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentConfigChatUpdateParams &&
            this.agentId == other.agentId &&
            this.id == other.id &&
            this.welcomeMessage == other.welcomeMessage &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            agentId,
            id,
            welcomeMessage,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AgentConfigChatUpdateParams{agentId=$agentId, id=$id, welcomeMessage=$welcomeMessage, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var agentId: String? = null
        private var id: String? = null
        private var welcomeMessage: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(agentConfigChatUpdateParams: AgentConfigChatUpdateParams) = apply {
            this.agentId = agentConfigChatUpdateParams.agentId
            this.id = agentConfigChatUpdateParams.id
            this.welcomeMessage = agentConfigChatUpdateParams.welcomeMessage
            additionalQueryParams(agentConfigChatUpdateParams.additionalQueryParams)
            additionalHeaders(agentConfigChatUpdateParams.additionalHeaders)
            additionalBodyProperties(agentConfigChatUpdateParams.additionalBodyProperties)
        }

        fun agentId(agentId: String) = apply { this.agentId = agentId }

        fun id(id: String) = apply { this.id = id }

        fun welcomeMessage(welcomeMessage: String) = apply { this.welcomeMessage = welcomeMessage }

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): AgentConfigChatUpdateParams =
            AgentConfigChatUpdateParams(
                checkNotNull(agentId) { "`agentId` is required but was not set" },
                id,
                welcomeMessage,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }
}
