// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import software.elborai.api.core.Enum
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*

class AgentConfigUpdateParams
constructor(
    private val agentId: String,
    private val integration: Integration,
    private val class_: String,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun agentId(): String = agentId

    fun integration(): Integration = integration

    fun class_(): String = class_

    internal fun getBody(): AgentConfigUpdateBody {
        return AgentConfigUpdateBody(class_, additionalBodyProperties)
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> agentId
            1 -> integration.toString()
            else -> ""
        }
    }

    @JsonDeserialize(builder = AgentConfigUpdateBody.Builder::class)
    @NoAutoDetect
    class AgentConfigUpdateBody
    internal constructor(
        private val class_: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("@class") fun class_(): String? = class_

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AgentConfigUpdateBody &&
                this.class_ == other.class_ &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(class_, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "AgentConfigUpdateBody{class_=$class_, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var class_: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(agentConfigUpdateBody: AgentConfigUpdateBody) = apply {
                this.class_ = agentConfigUpdateBody.class_
                additionalProperties(agentConfigUpdateBody.additionalProperties)
            }

            @JsonProperty("@class") fun class_(class_: String) = apply { this.class_ = class_ }

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

            fun build(): AgentConfigUpdateBody =
                AgentConfigUpdateBody(
                    checkNotNull(class_) { "`class_` is required but was not set" },
                    additionalProperties.toUnmodifiable()
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

        return other is AgentConfigUpdateParams &&
            this.agentId == other.agentId &&
            this.integration == other.integration &&
            this.class_ == other.class_ &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            agentId,
            integration,
            class_,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AgentConfigUpdateParams{agentId=$agentId, integration=$integration, class_=$class_, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var agentId: String? = null
        private var integration: Integration? = null
        private var class_: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(agentConfigUpdateParams: AgentConfigUpdateParams) = apply {
            this.agentId = agentConfigUpdateParams.agentId
            this.integration = agentConfigUpdateParams.integration
            this.class_ = agentConfigUpdateParams.class_
            additionalQueryParams(agentConfigUpdateParams.additionalQueryParams)
            additionalHeaders(agentConfigUpdateParams.additionalHeaders)
            additionalBodyProperties(agentConfigUpdateParams.additionalBodyProperties)
        }

        fun agentId(agentId: String) = apply { this.agentId = agentId }

        fun integration(integration: Integration) = apply { this.integration = integration }

        fun class_(class_: String) = apply { this.class_ = class_ }

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

        fun build(): AgentConfigUpdateParams =
            AgentConfigUpdateParams(
                checkNotNull(agentId) { "`agentId` is required but was not set" },
                checkNotNull(integration) { "`integration` is required but was not set" },
                checkNotNull(class_) { "`class_` is required but was not set" },
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class Integration
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Integration && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val SALESFORCE = Integration(JsonField.of("SALESFORCE"))

            val ZENDESK = Integration(JsonField.of("ZENDESK"))

            val FRESHDESK = Integration(JsonField.of("FRESHDESK"))

            val SLACK_QA_BOT = Integration(JsonField.of("SLACK_QA_BOT"))

            val TWILIO = Integration(JsonField.of("TWILIO"))

            fun of(value: String) = Integration(JsonField.of(value))
        }

        enum class Known {
            SALESFORCE,
            ZENDESK,
            FRESHDESK,
            SLACK_QA_BOT,
            TWILIO,
        }

        enum class Value {
            SALESFORCE,
            ZENDESK,
            FRESHDESK,
            SLACK_QA_BOT,
            TWILIO,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SALESFORCE -> Value.SALESFORCE
                ZENDESK -> Value.ZENDESK
                FRESHDESK -> Value.FRESHDESK
                SLACK_QA_BOT -> Value.SLACK_QA_BOT
                TWILIO -> Value.TWILIO
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SALESFORCE -> Known.SALESFORCE
                ZENDESK -> Known.ZENDESK
                FRESHDESK -> Known.FRESHDESK
                SLACK_QA_BOT -> Known.SLACK_QA_BOT
                TWILIO -> Known.TWILIO
                else -> throw SamInvalidDataException("Unknown Integration: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
