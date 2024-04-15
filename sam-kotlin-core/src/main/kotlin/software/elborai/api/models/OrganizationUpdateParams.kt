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

class OrganizationUpdateParams
constructor(
    private val id: String,
    private val friendlyId: String,
    private val name: String,
    private val defaultLanguage: DefaultLanguage?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun id(): String = id

    fun friendlyId(): String = friendlyId

    fun name(): String = name

    fun defaultLanguage(): DefaultLanguage? = defaultLanguage

    internal fun getBody(): OrganizationUpdateBody {
        return OrganizationUpdateBody(
            id,
            friendlyId,
            name,
            defaultLanguage,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = OrganizationUpdateBody.Builder::class)
    @NoAutoDetect
    class OrganizationUpdateBody
    internal constructor(
        private val id: String?,
        private val friendlyId: String?,
        private val name: String?,
        private val defaultLanguage: DefaultLanguage?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("friendlyId") fun friendlyId(): String? = friendlyId

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("defaultLanguage") fun defaultLanguage(): DefaultLanguage? = defaultLanguage

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OrganizationUpdateBody &&
                this.id == other.id &&
                this.friendlyId == other.friendlyId &&
                this.name == other.name &&
                this.defaultLanguage == other.defaultLanguage &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        friendlyId,
                        name,
                        defaultLanguage,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "OrganizationUpdateBody{id=$id, friendlyId=$friendlyId, name=$name, defaultLanguage=$defaultLanguage, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var friendlyId: String? = null
            private var name: String? = null
            private var defaultLanguage: DefaultLanguage? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(organizationUpdateBody: OrganizationUpdateBody) = apply {
                this.id = organizationUpdateBody.id
                this.friendlyId = organizationUpdateBody.friendlyId
                this.name = organizationUpdateBody.name
                this.defaultLanguage = organizationUpdateBody.defaultLanguage
                additionalProperties(organizationUpdateBody.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("friendlyId")
            fun friendlyId(friendlyId: String) = apply { this.friendlyId = friendlyId }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("defaultLanguage")
            fun defaultLanguage(defaultLanguage: DefaultLanguage) = apply {
                this.defaultLanguage = defaultLanguage
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

            fun build(): OrganizationUpdateBody =
                OrganizationUpdateBody(
                    checkNotNull(id) { "`id` is required but was not set" },
                    checkNotNull(friendlyId) { "`friendlyId` is required but was not set" },
                    checkNotNull(name) { "`name` is required but was not set" },
                    defaultLanguage,
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

        return other is OrganizationUpdateParams &&
            this.id == other.id &&
            this.friendlyId == other.friendlyId &&
            this.name == other.name &&
            this.defaultLanguage == other.defaultLanguage &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            friendlyId,
            name,
            defaultLanguage,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "OrganizationUpdateParams{id=$id, friendlyId=$friendlyId, name=$name, defaultLanguage=$defaultLanguage, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var friendlyId: String? = null
        private var name: String? = null
        private var defaultLanguage: DefaultLanguage? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(organizationUpdateParams: OrganizationUpdateParams) = apply {
            this.id = organizationUpdateParams.id
            this.friendlyId = organizationUpdateParams.friendlyId
            this.name = organizationUpdateParams.name
            this.defaultLanguage = organizationUpdateParams.defaultLanguage
            additionalQueryParams(organizationUpdateParams.additionalQueryParams)
            additionalHeaders(organizationUpdateParams.additionalHeaders)
            additionalBodyProperties(organizationUpdateParams.additionalBodyProperties)
        }

        fun id(id: String) = apply { this.id = id }

        fun friendlyId(friendlyId: String) = apply { this.friendlyId = friendlyId }

        fun name(name: String) = apply { this.name = name }

        fun defaultLanguage(defaultLanguage: DefaultLanguage) = apply {
            this.defaultLanguage = defaultLanguage
        }

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

        fun build(): OrganizationUpdateParams =
            OrganizationUpdateParams(
                checkNotNull(id) { "`id` is required but was not set" },
                checkNotNull(friendlyId) { "`friendlyId` is required but was not set" },
                checkNotNull(name) { "`name` is required but was not set" },
                defaultLanguage,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = DefaultLanguage.Builder::class)
    @NoAutoDetect
    class DefaultLanguage
    private constructor(
        private val code: String?,
        private val detected: Boolean?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("code") fun code(): String? = code

        @JsonProperty("detected") fun detected(): Boolean? = detected

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DefaultLanguage &&
                this.code == other.code &&
                this.detected == other.detected &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        code,
                        detected,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "DefaultLanguage{code=$code, detected=$detected, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var code: String? = null
            private var detected: Boolean? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(defaultLanguage: DefaultLanguage) = apply {
                this.code = defaultLanguage.code
                this.detected = defaultLanguage.detected
                additionalProperties(defaultLanguage.additionalProperties)
            }

            @JsonProperty("code") fun code(code: String) = apply { this.code = code }

            @JsonProperty("detected")
            fun detected(detected: Boolean) = apply { this.detected = detected }

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

            fun build(): DefaultLanguage =
                DefaultLanguage(
                    code,
                    detected,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
