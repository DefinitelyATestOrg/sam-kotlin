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
import software.elborai.api.core.toImmutable
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*

class PetUpdateParams
constructor(
    private val name: String,
    private val photoUrls: List<String>,
    private val id: Long?,
    private val category: Category?,
    private val status: Status?,
    private val tags: List<Tag>?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun name(): String = name

    fun photoUrls(): List<String> = photoUrls

    fun id(): Long? = id

    fun category(): Category? = category

    fun status(): Status? = status

    fun tags(): List<Tag>? = tags

    internal fun getBody(): PetUpdateBody {
        return PetUpdateBody(
            name,
            photoUrls,
            id,
            category,
            status,
            tags,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = PetUpdateBody.Builder::class)
    @NoAutoDetect
    class PetUpdateBody
    internal constructor(
        private val name: String?,
        private val photoUrls: List<String>?,
        private val id: Long?,
        private val category: Category?,
        private val status: Status?,
        private val tags: List<Tag>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("photoUrls") fun photoUrls(): List<String>? = photoUrls

        @JsonProperty("id") fun id(): Long? = id

        @JsonProperty("category") fun category(): Category? = category

        /** pet status in the store */
        @JsonProperty("status") fun status(): Status? = status

        @JsonProperty("tags") fun tags(): List<Tag>? = tags

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var name: String? = null
            private var photoUrls: List<String>? = null
            private var id: Long? = null
            private var category: Category? = null
            private var status: Status? = null
            private var tags: List<Tag>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(petUpdateBody: PetUpdateBody) = apply {
                this.name = petUpdateBody.name
                this.photoUrls = petUpdateBody.photoUrls
                this.id = petUpdateBody.id
                this.category = petUpdateBody.category
                this.status = petUpdateBody.status
                this.tags = petUpdateBody.tags
                additionalProperties(petUpdateBody.additionalProperties)
            }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("photoUrls")
            fun photoUrls(photoUrls: List<String>) = apply { this.photoUrls = photoUrls }

            @JsonProperty("id") fun id(id: Long) = apply { this.id = id }

            @JsonProperty("category")
            fun category(category: Category) = apply { this.category = category }

            /** pet status in the store */
            @JsonProperty("status") fun status(status: Status) = apply { this.status = status }

            @JsonProperty("tags") fun tags(tags: List<Tag>) = apply { this.tags = tags }

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

            fun build(): PetUpdateBody =
                PetUpdateBody(
                    checkNotNull(name) { "`name` is required but was not set" },
                    checkNotNull(photoUrls) { "`photoUrls` is required but was not set" }
                        .toImmutable(),
                    id,
                    category,
                    status,
                    tags?.toImmutable(),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PetUpdateBody && this.name == other.name && this.photoUrls == other.photoUrls && this.id == other.id && this.category == other.category && this.status == other.status && this.tags == other.tags && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(name, photoUrls, id, category, status, tags, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "PetUpdateBody{name=$name, photoUrls=$photoUrls, id=$id, category=$category, status=$status, tags=$tags, additionalProperties=$additionalProperties}"
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PetUpdateParams && this.name == other.name && this.photoUrls == other.photoUrls && this.id == other.id && this.category == other.category && this.status == other.status && this.tags == other.tags && this.additionalQueryParams == other.additionalQueryParams && this.additionalHeaders == other.additionalHeaders && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(name, photoUrls, id, category, status, tags, additionalQueryParams, additionalHeaders, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "PetUpdateParams{name=$name, photoUrls=$photoUrls, id=$id, category=$category, status=$status, tags=$tags, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var name: String? = null
        private var photoUrls: MutableList<String> = mutableListOf()
        private var id: Long? = null
        private var category: Category? = null
        private var status: Status? = null
        private var tags: MutableList<Tag> = mutableListOf()
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(petUpdateParams: PetUpdateParams) = apply {
            this.name = petUpdateParams.name
            this.photoUrls(petUpdateParams.photoUrls)
            this.id = petUpdateParams.id
            this.category = petUpdateParams.category
            this.status = petUpdateParams.status
            this.tags(petUpdateParams.tags ?: listOf())
            additionalQueryParams(petUpdateParams.additionalQueryParams)
            additionalHeaders(petUpdateParams.additionalHeaders)
            additionalBodyProperties(petUpdateParams.additionalBodyProperties)
        }

        fun name(name: String) = apply { this.name = name }

        fun photoUrls(photoUrls: List<String>) = apply {
            this.photoUrls.clear()
            this.photoUrls.addAll(photoUrls)
        }

        fun addPhotoUrl(photoUrl: String) = apply { this.photoUrls.add(photoUrl) }

        fun id(id: Long) = apply { this.id = id }

        fun category(category: Category) = apply { this.category = category }

        /** pet status in the store */
        fun status(status: Status) = apply { this.status = status }

        fun tags(tags: List<Tag>) = apply {
            this.tags.clear()
            this.tags.addAll(tags)
        }

        fun addTag(tag: Tag) = apply { this.tags.add(tag) }

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

        fun build(): PetUpdateParams =
            PetUpdateParams(
                checkNotNull(name) { "`name` is required but was not set" },
                checkNotNull(photoUrls) { "`photoUrls` is required but was not set" }.toImmutable(),
                id,
                category,
                status,
                if (tags.size == 0) null else tags.toImmutable(),
                additionalQueryParams.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalHeaders.mapValues { it.value.toImmutable() }.toImmutable(),
                additionalBodyProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = Category.Builder::class)
    @NoAutoDetect
    class Category
    private constructor(
        private val id: Long?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonProperty("id") fun id(): Long? = id

        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: Long? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(category: Category) = apply {
                this.id = category.id
                this.name = category.name
                additionalProperties(category.additionalProperties)
            }

            @JsonProperty("id") fun id(id: Long) = apply { this.id = id }

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

            fun build(): Category =
                Category(
                    id,
                    name,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Category && this.id == other.id && this.name == other.name && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(id, name, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "Category{id=$id, name=$name, additionalProperties=$additionalProperties}"
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val AVAILABLE = Status(JsonField.of("available"))

            val PENDING = Status(JsonField.of("pending"))

            val SOLD = Status(JsonField.of("sold"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            AVAILABLE,
            PENDING,
            SOLD,
        }

        enum class Value {
            AVAILABLE,
            PENDING,
            SOLD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                AVAILABLE -> Value.AVAILABLE
                PENDING -> Value.PENDING
                SOLD -> Value.SOLD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                AVAILABLE -> Known.AVAILABLE
                PENDING -> Known.PENDING
                SOLD -> Known.SOLD
                else -> throw SamInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = Tag.Builder::class)
    @NoAutoDetect
    class Tag
    private constructor(
        private val id: Long?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        @JsonProperty("id") fun id(): Long? = id

        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: Long? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(tag: Tag) = apply {
                this.id = tag.id
                this.name = tag.name
                additionalProperties(tag.additionalProperties)
            }

            @JsonProperty("id") fun id(id: Long) = apply { this.id = id }

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

            fun build(): Tag =
                Tag(
                    id,
                    name,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Tag && this.id == other.id && this.name == other.name && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(id, name, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "Tag{id=$id, name=$name, additionalProperties=$additionalProperties}"
    }
}
