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
import software.elborai.api.core.JsonMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toImmutable
import software.elborai.api.errors.SamInvalidDataException

@JsonDeserialize(builder = Pet.Builder::class)
@NoAutoDetect
class Pet
private constructor(
    private val id: JsonField<Long>,
    private val name: JsonField<String>,
    private val category: JsonField<Category>,
    private val photoUrls: JsonField<List<String>>,
    private val tags: JsonField<List<Tag>>,
    private val status: JsonField<Status>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    fun id(): Long? = id.getNullable("id")

    fun name(): String = name.getRequired("name")

    fun category(): Category? = category.getNullable("category")

    fun photoUrls(): List<String> = photoUrls.getRequired("photoUrls")

    fun tags(): List<Tag>? = tags.getNullable("tags")

    /** pet status in the store */
    fun status(): Status? = status.getNullable("status")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonProperty("category") @ExcludeMissing fun _category() = category

    @JsonProperty("photoUrls") @ExcludeMissing fun _photoUrls() = photoUrls

    @JsonProperty("tags") @ExcludeMissing fun _tags() = tags

    /** pet status in the store */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Pet = apply {
        if (!validated) {
            id()
            name()
            category()?.validate()
            photoUrls()
            tags()?.forEach { it.validate() }
            status()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<Long> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var category: JsonField<Category> = JsonMissing.of()
        private var photoUrls: JsonField<List<String>> = JsonMissing.of()
        private var tags: JsonField<List<Tag>> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(pet: Pet) = apply {
            this.id = pet.id
            this.name = pet.name
            this.category = pet.category
            this.photoUrls = pet.photoUrls
            this.tags = pet.tags
            this.status = pet.status
            additionalProperties(pet.additionalProperties)
        }

        fun id(id: Long) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<Long>) = apply { this.id = id }

        fun name(name: String) = name(JsonField.of(name))

        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun category(category: Category) = category(JsonField.of(category))

        @JsonProperty("category")
        @ExcludeMissing
        fun category(category: JsonField<Category>) = apply { this.category = category }

        fun photoUrls(photoUrls: List<String>) = photoUrls(JsonField.of(photoUrls))

        @JsonProperty("photoUrls")
        @ExcludeMissing
        fun photoUrls(photoUrls: JsonField<List<String>>) = apply { this.photoUrls = photoUrls }

        fun tags(tags: List<Tag>) = tags(JsonField.of(tags))

        @JsonProperty("tags")
        @ExcludeMissing
        fun tags(tags: JsonField<List<Tag>>) = apply { this.tags = tags }

        /** pet status in the store */
        fun status(status: Status) = status(JsonField.of(status))

        /** pet status in the store */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

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

        fun build(): Pet =
            Pet(
                id,
                name,
                category,
                photoUrls.map { it.toImmutable() },
                tags.map { it.toImmutable() },
                status,
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = Category.Builder::class)
    @NoAutoDetect
    class Category
    private constructor(
        private val id: JsonField<Long>,
        private val name: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun id(): Long? = id.getNullable("id")

        fun name(): String? = name.getNullable("name")

        @JsonProperty("id") @ExcludeMissing fun _id() = id

        @JsonProperty("name") @ExcludeMissing fun _name() = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Category = apply {
            if (!validated) {
                id()
                name()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<Long> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(category: Category) = apply {
                this.id = category.id
                this.name = category.name
                additionalProperties(category.additionalProperties)
            }

            fun id(id: Long) = id(JsonField.of(id))

            @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<Long>) = apply { this.id = id }

            fun name(name: String) = name(JsonField.of(name))

            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

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
        private val id: JsonField<Long>,
        private val name: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun id(): Long? = id.getNullable("id")

        fun name(): String? = name.getNullable("name")

        @JsonProperty("id") @ExcludeMissing fun _id() = id

        @JsonProperty("name") @ExcludeMissing fun _name() = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Tag = apply {
            if (!validated) {
                id()
                name()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: JsonField<Long> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(tag: Tag) = apply {
                this.id = tag.id
                this.name = tag.name
                additionalProperties(tag.additionalProperties)
            }

            fun id(id: Long) = id(JsonField.of(id))

            @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<Long>) = apply { this.id = id }

            fun name(name: String) = name(JsonField.of(name))

            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Pet && this.id == other.id && this.name == other.name && this.category == other.category && this.photoUrls == other.photoUrls && this.tags == other.tags && this.status == other.status && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(id, name, category, photoUrls, tags, status, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "Pet{id=$id, name=$name, category=$category, photoUrls=$photoUrls, tags=$tags, status=$status, additionalProperties=$additionalProperties}"
}
