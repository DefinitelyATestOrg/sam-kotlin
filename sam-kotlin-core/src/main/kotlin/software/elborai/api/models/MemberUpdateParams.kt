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

class MemberUpdateParams
constructor(
    private val memberId: String,
    private val id: String?,
    private val email: String?,
    private val name: String?,
    private val orgId: String?,
    private val pictureUrl: String?,
    private val role: Role?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun memberId(): String = memberId

    fun id(): String? = id

    fun email(): String? = email

    fun name(): String? = name

    fun orgId(): String? = orgId

    fun pictureUrl(): String? = pictureUrl

    fun role(): Role? = role

    internal fun getBody(): MemberUpdateBody {
        return MemberUpdateBody(
            id,
            email,
            name,
            orgId,
            pictureUrl,
            role,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> memberId
            else -> ""
        }
    }

    @JsonDeserialize(builder = MemberUpdateBody.Builder::class)
    @NoAutoDetect
    class MemberUpdateBody
    internal constructor(
        private val id: String?,
        private val email: String?,
        private val name: String?,
        private val orgId: String?,
        private val pictureUrl: String?,
        private val role: Role?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("email") fun email(): String? = email

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("orgId") fun orgId(): String? = orgId

        @JsonProperty("pictureUrl") fun pictureUrl(): String? = pictureUrl

        @JsonProperty("role") fun role(): Role? = role

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MemberUpdateBody &&
                this.id == other.id &&
                this.email == other.email &&
                this.name == other.name &&
                this.orgId == other.orgId &&
                this.pictureUrl == other.pictureUrl &&
                this.role == other.role &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        email,
                        name,
                        orgId,
                        pictureUrl,
                        role,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "MemberUpdateBody{id=$id, email=$email, name=$name, orgId=$orgId, pictureUrl=$pictureUrl, role=$role, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var email: String? = null
            private var name: String? = null
            private var orgId: String? = null
            private var pictureUrl: String? = null
            private var role: Role? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(memberUpdateBody: MemberUpdateBody) = apply {
                this.id = memberUpdateBody.id
                this.email = memberUpdateBody.email
                this.name = memberUpdateBody.name
                this.orgId = memberUpdateBody.orgId
                this.pictureUrl = memberUpdateBody.pictureUrl
                this.role = memberUpdateBody.role
                additionalProperties(memberUpdateBody.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("email") fun email(email: String) = apply { this.email = email }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("orgId") fun orgId(orgId: String) = apply { this.orgId = orgId }

            @JsonProperty("pictureUrl")
            fun pictureUrl(pictureUrl: String) = apply { this.pictureUrl = pictureUrl }

            @JsonProperty("role") fun role(role: Role) = apply { this.role = role }

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

            fun build(): MemberUpdateBody =
                MemberUpdateBody(
                    id,
                    email,
                    name,
                    orgId,
                    pictureUrl,
                    role,
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

        return other is MemberUpdateParams &&
            this.memberId == other.memberId &&
            this.id == other.id &&
            this.email == other.email &&
            this.name == other.name &&
            this.orgId == other.orgId &&
            this.pictureUrl == other.pictureUrl &&
            this.role == other.role &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            memberId,
            id,
            email,
            name,
            orgId,
            pictureUrl,
            role,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "MemberUpdateParams{memberId=$memberId, id=$id, email=$email, name=$name, orgId=$orgId, pictureUrl=$pictureUrl, role=$role, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var memberId: String? = null
        private var id: String? = null
        private var email: String? = null
        private var name: String? = null
        private var orgId: String? = null
        private var pictureUrl: String? = null
        private var role: Role? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(memberUpdateParams: MemberUpdateParams) = apply {
            this.memberId = memberUpdateParams.memberId
            this.id = memberUpdateParams.id
            this.email = memberUpdateParams.email
            this.name = memberUpdateParams.name
            this.orgId = memberUpdateParams.orgId
            this.pictureUrl = memberUpdateParams.pictureUrl
            this.role = memberUpdateParams.role
            additionalQueryParams(memberUpdateParams.additionalQueryParams)
            additionalHeaders(memberUpdateParams.additionalHeaders)
            additionalBodyProperties(memberUpdateParams.additionalBodyProperties)
        }

        fun memberId(memberId: String) = apply { this.memberId = memberId }

        fun id(id: String) = apply { this.id = id }

        fun email(email: String) = apply { this.email = email }

        fun name(name: String) = apply { this.name = name }

        fun orgId(orgId: String) = apply { this.orgId = orgId }

        fun pictureUrl(pictureUrl: String) = apply { this.pictureUrl = pictureUrl }

        fun role(role: Role) = apply { this.role = role }

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

        fun build(): MemberUpdateParams =
            MemberUpdateParams(
                checkNotNull(memberId) { "`memberId` is required but was not set" },
                id,
                email,
                name,
                orgId,
                pictureUrl,
                role,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Role && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val OWNER = Role(JsonField.of("OWNER"))

            val ADMIN = Role(JsonField.of("ADMIN"))

            val READER = Role(JsonField.of("READER"))

            fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            OWNER,
            ADMIN,
            READER,
        }

        enum class Value {
            OWNER,
            ADMIN,
            READER,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                OWNER -> Value.OWNER
                ADMIN -> Value.ADMIN
                READER -> Value.READER
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                OWNER -> Known.OWNER
                ADMIN -> Known.ADMIN
                READER -> Known.READER
                else -> throw SamInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
