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

class ActionSetUpdateParams
constructor(
    private val pathId: String,
    private val name: String,
    private val bodyId: String?,
    private val agentId: String?,
    private val createdBy: CreatedBy?,
    private val openAPIUrl: String?,
    private val serverUrl: String?,
    private val type: Type?,
    private val updatedBy: UpdatedBy?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun pathId(): String = pathId

    fun name(): String = name

    fun bodyId(): String? = bodyId

    fun agentId(): String? = agentId

    fun createdBy(): CreatedBy? = createdBy

    fun openAPIUrl(): String? = openAPIUrl

    fun serverUrl(): String? = serverUrl

    fun type(): Type? = type

    fun updatedBy(): UpdatedBy? = updatedBy

    internal fun getBody(): ActionSetUpdateBody {
        return ActionSetUpdateBody(
            name,
            bodyId,
            agentId,
            createdBy,
            openAPIUrl,
            serverUrl,
            type,
            updatedBy,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> pathId
            else -> ""
        }
    }

    @JsonDeserialize(builder = ActionSetUpdateBody.Builder::class)
    @NoAutoDetect
    class ActionSetUpdateBody
    internal constructor(
        private val name: String?,
        private val bodyId: String?,
        private val agentId: String?,
        private val createdBy: CreatedBy?,
        private val openAPIUrl: String?,
        private val serverUrl: String?,
        private val type: Type?,
        private val updatedBy: UpdatedBy?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("id") fun bodyId(): String? = bodyId

        @JsonProperty("agentId") fun agentId(): String? = agentId

        @JsonProperty("createdBy") fun createdBy(): CreatedBy? = createdBy

        @JsonProperty("openApiUrl") fun openAPIUrl(): String? = openAPIUrl

        @JsonProperty("serverUrl") fun serverUrl(): String? = serverUrl

        @JsonProperty("type") fun type(): Type? = type

        @JsonProperty("updatedBy") fun updatedBy(): UpdatedBy? = updatedBy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ActionSetUpdateBody &&
                this.name == other.name &&
                this.bodyId == other.bodyId &&
                this.agentId == other.agentId &&
                this.createdBy == other.createdBy &&
                this.openAPIUrl == other.openAPIUrl &&
                this.serverUrl == other.serverUrl &&
                this.type == other.type &&
                this.updatedBy == other.updatedBy &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        name,
                        bodyId,
                        agentId,
                        createdBy,
                        openAPIUrl,
                        serverUrl,
                        type,
                        updatedBy,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ActionSetUpdateBody{name=$name, bodyId=$bodyId, agentId=$agentId, createdBy=$createdBy, openAPIUrl=$openAPIUrl, serverUrl=$serverUrl, type=$type, updatedBy=$updatedBy, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var bodyId: String? = null
            private var agentId: String? = null
            private var createdBy: CreatedBy? = null
            private var openAPIUrl: String? = null
            private var serverUrl: String? = null
            private var type: Type? = null
            private var updatedBy: UpdatedBy? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(actionSetUpdateBody: ActionSetUpdateBody) = apply {
                this.name = actionSetUpdateBody.name
                this.bodyId = actionSetUpdateBody.bodyId
                this.agentId = actionSetUpdateBody.agentId
                this.createdBy = actionSetUpdateBody.createdBy
                this.openAPIUrl = actionSetUpdateBody.openAPIUrl
                this.serverUrl = actionSetUpdateBody.serverUrl
                this.type = actionSetUpdateBody.type
                this.updatedBy = actionSetUpdateBody.updatedBy
                additionalProperties(actionSetUpdateBody.additionalProperties)
            }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("id") fun bodyId(bodyId: String) = apply { this.bodyId = bodyId }

            @JsonProperty("agentId") fun agentId(agentId: String) = apply { this.agentId = agentId }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply { this.createdBy = createdBy }

            @JsonProperty("openApiUrl")
            fun openAPIUrl(openAPIUrl: String) = apply { this.openAPIUrl = openAPIUrl }

            @JsonProperty("serverUrl")
            fun serverUrl(serverUrl: String) = apply { this.serverUrl = serverUrl }

            @JsonProperty("type") fun type(type: Type) = apply { this.type = type }

            @JsonProperty("updatedBy")
            fun updatedBy(updatedBy: UpdatedBy) = apply { this.updatedBy = updatedBy }

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

            fun build(): ActionSetUpdateBody =
                ActionSetUpdateBody(
                    checkNotNull(name) { "`name` is required but was not set" },
                    bodyId,
                    agentId,
                    createdBy,
                    openAPIUrl,
                    serverUrl,
                    type,
                    updatedBy,
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

        return other is ActionSetUpdateParams &&
            this.pathId == other.pathId &&
            this.name == other.name &&
            this.bodyId == other.bodyId &&
            this.agentId == other.agentId &&
            this.createdBy == other.createdBy &&
            this.openAPIUrl == other.openAPIUrl &&
            this.serverUrl == other.serverUrl &&
            this.type == other.type &&
            this.updatedBy == other.updatedBy &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            pathId,
            name,
            bodyId,
            agentId,
            createdBy,
            openAPIUrl,
            serverUrl,
            type,
            updatedBy,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ActionSetUpdateParams{pathId=$pathId, name=$name, bodyId=$bodyId, agentId=$agentId, createdBy=$createdBy, openAPIUrl=$openAPIUrl, serverUrl=$serverUrl, type=$type, updatedBy=$updatedBy, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var pathId: String? = null
        private var name: String? = null
        private var bodyId: String? = null
        private var agentId: String? = null
        private var createdBy: CreatedBy? = null
        private var openAPIUrl: String? = null
        private var serverUrl: String? = null
        private var type: Type? = null
        private var updatedBy: UpdatedBy? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(actionSetUpdateParams: ActionSetUpdateParams) = apply {
            this.pathId = actionSetUpdateParams.pathId
            this.name = actionSetUpdateParams.name
            this.bodyId = actionSetUpdateParams.bodyId
            this.agentId = actionSetUpdateParams.agentId
            this.createdBy = actionSetUpdateParams.createdBy
            this.openAPIUrl = actionSetUpdateParams.openAPIUrl
            this.serverUrl = actionSetUpdateParams.serverUrl
            this.type = actionSetUpdateParams.type
            this.updatedBy = actionSetUpdateParams.updatedBy
            additionalQueryParams(actionSetUpdateParams.additionalQueryParams)
            additionalHeaders(actionSetUpdateParams.additionalHeaders)
            additionalBodyProperties(actionSetUpdateParams.additionalBodyProperties)
        }

        fun pathId(pathId: String) = apply { this.pathId = pathId }

        fun name(name: String) = apply { this.name = name }

        fun bodyId(bodyId: String) = apply { this.bodyId = bodyId }

        fun agentId(agentId: String) = apply { this.agentId = agentId }

        fun createdBy(createdBy: CreatedBy) = apply { this.createdBy = createdBy }

        fun openAPIUrl(openAPIUrl: String) = apply { this.openAPIUrl = openAPIUrl }

        fun serverUrl(serverUrl: String) = apply { this.serverUrl = serverUrl }

        fun type(type: Type) = apply { this.type = type }

        fun updatedBy(updatedBy: UpdatedBy) = apply { this.updatedBy = updatedBy }

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

        fun build(): ActionSetUpdateParams =
            ActionSetUpdateParams(
                checkNotNull(pathId) { "`pathId` is required but was not set" },
                checkNotNull(name) { "`name` is required but was not set" },
                bodyId,
                agentId,
                createdBy,
                openAPIUrl,
                serverUrl,
                type,
                updatedBy,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CreatedBy.Builder::class)
    @NoAutoDetect
    class CreatedBy
    private constructor(
        private val id: String?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreatedBy &&
                this.id == other.id &&
                this.name == other.name &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        name,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CreatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createdBy: CreatedBy) = apply {
                this.id = createdBy.id
                this.name = createdBy.name
                additionalProperties(createdBy.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

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

            fun build(): CreatedBy =
                CreatedBy(
                    id,
                    name,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val OPENAPI = Type(JsonField.of("OPEN_API"))

            val MANUAL = Type(JsonField.of("MANUAL"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            OPENAPI,
            MANUAL,
        }

        enum class Value {
            OPENAPI,
            MANUAL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OPENAPI -> Value.OPENAPI
                MANUAL -> Value.MANUAL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OPENAPI -> Known.OPENAPI
                MANUAL -> Known.MANUAL
                else -> throw SamInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = UpdatedBy.Builder::class)
    @NoAutoDetect
    class UpdatedBy
    private constructor(
        private val id: String?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UpdatedBy &&
                this.id == other.id &&
                this.name == other.name &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        name,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "UpdatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(updatedBy: UpdatedBy) = apply {
                this.id = updatedBy.id
                this.name = updatedBy.name
                additionalProperties(updatedBy.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

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

            fun build(): UpdatedBy =
                UpdatedBy(
                    id,
                    name,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
