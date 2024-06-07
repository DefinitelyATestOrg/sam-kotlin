// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.apache.hc.core5.http.ContentType
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import java.util.UUID
import software.elborai.api.core.BaseDeserializer
import software.elborai.api.core.BaseSerializer
import software.elborai.api.core.getOrThrow
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.MultipartFormValue
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.Enum
import software.elborai.api.core.ContentTypes
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*

class DocumentUpdateParams constructor(
  private val docId: String,
  private val id: String?,
  private val corpusPolicy: CorpusPolicy?,
  private val createdBy: CreatedBy?,
  private val externalLookupKey: String?,
  private val languageCode: LanguageCode?,
  private val processingVersion: Long?,
  private val sourceAuthor: String?,
  private val sourceCreatedAt: OffsetDateTime?,
  private val sourceUpdatedAt: OffsetDateTime?,
  private val sourceUrl: String?,
  private val text: String?,
  private val title: String?,
  private val updatedBy: UpdatedBy?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun docId(): String = docId

    fun id(): String? = id

    fun corpusPolicy(): CorpusPolicy? = corpusPolicy

    fun createdBy(): CreatedBy? = createdBy

    fun externalLookupKey(): String? = externalLookupKey

    fun languageCode(): LanguageCode? = languageCode

    fun processingVersion(): Long? = processingVersion

    fun sourceAuthor(): String? = sourceAuthor

    fun sourceCreatedAt(): OffsetDateTime? = sourceCreatedAt

    fun sourceUpdatedAt(): OffsetDateTime? = sourceUpdatedAt

    fun sourceUrl(): String? = sourceUrl

    fun text(): String? = text

    fun title(): String? = title

    fun updatedBy(): UpdatedBy? = updatedBy

    internal fun getBody(): DocumentUpdateBody {
      return DocumentUpdateBody(
          id,
          corpusPolicy,
          createdBy,
          externalLookupKey,
          languageCode,
          processingVersion,
          sourceAuthor,
          sourceCreatedAt,
          sourceUpdatedAt,
          sourceUrl,
          text,
          title,
          updatedBy,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> docId
          else -> ""
      }
    }

    @JsonDeserialize(builder = DocumentUpdateBody.Builder::class)
    @NoAutoDetect
    class DocumentUpdateBody internal constructor(
      private val id: String?,
      private val corpusPolicy: CorpusPolicy?,
      private val createdBy: CreatedBy?,
      private val externalLookupKey: String?,
      private val languageCode: LanguageCode?,
      private val processingVersion: Long?,
      private val sourceAuthor: String?,
      private val sourceCreatedAt: OffsetDateTime?,
      private val sourceUpdatedAt: OffsetDateTime?,
      private val sourceUrl: String?,
      private val text: String?,
      private val title: String?,
      private val updatedBy: UpdatedBy?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("corpusPolicy")
        fun corpusPolicy(): CorpusPolicy? = corpusPolicy

        @JsonProperty("createdBy")
        fun createdBy(): CreatedBy? = createdBy

        @JsonProperty("externalLookupKey")
        fun externalLookupKey(): String? = externalLookupKey

        @JsonProperty("languageCode")
        fun languageCode(): LanguageCode? = languageCode

        @JsonProperty("processingVersion")
        fun processingVersion(): Long? = processingVersion

        @JsonProperty("sourceAuthor")
        fun sourceAuthor(): String? = sourceAuthor

        @JsonProperty("sourceCreatedAt")
        fun sourceCreatedAt(): OffsetDateTime? = sourceCreatedAt

        @JsonProperty("sourceUpdatedAt")
        fun sourceUpdatedAt(): OffsetDateTime? = sourceUpdatedAt

        @JsonProperty("sourceUrl")
        fun sourceUrl(): String? = sourceUrl

        @JsonProperty("text")
        fun text(): String? = text

        @JsonProperty("title")
        fun title(): String? = title

        @JsonProperty("updatedBy")
        fun updatedBy(): UpdatedBy? = updatedBy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is DocumentUpdateBody &&
              this.id == other.id &&
              this.corpusPolicy == other.corpusPolicy &&
              this.createdBy == other.createdBy &&
              this.externalLookupKey == other.externalLookupKey &&
              this.languageCode == other.languageCode &&
              this.processingVersion == other.processingVersion &&
              this.sourceAuthor == other.sourceAuthor &&
              this.sourceCreatedAt == other.sourceCreatedAt &&
              this.sourceUpdatedAt == other.sourceUpdatedAt &&
              this.sourceUrl == other.sourceUrl &&
              this.text == other.text &&
              this.title == other.title &&
              this.updatedBy == other.updatedBy &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                id,
                corpusPolicy,
                createdBy,
                externalLookupKey,
                languageCode,
                processingVersion,
                sourceAuthor,
                sourceCreatedAt,
                sourceUpdatedAt,
                sourceUrl,
                text,
                title,
                updatedBy,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "DocumentUpdateBody{id=$id, corpusPolicy=$corpusPolicy, createdBy=$createdBy, externalLookupKey=$externalLookupKey, languageCode=$languageCode, processingVersion=$processingVersion, sourceAuthor=$sourceAuthor, sourceCreatedAt=$sourceCreatedAt, sourceUpdatedAt=$sourceUpdatedAt, sourceUrl=$sourceUrl, text=$text, title=$title, updatedBy=$updatedBy, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var corpusPolicy: CorpusPolicy? = null
            private var createdBy: CreatedBy? = null
            private var externalLookupKey: String? = null
            private var languageCode: LanguageCode? = null
            private var processingVersion: Long? = null
            private var sourceAuthor: String? = null
            private var sourceCreatedAt: OffsetDateTime? = null
            private var sourceUpdatedAt: OffsetDateTime? = null
            private var sourceUrl: String? = null
            private var text: String? = null
            private var title: String? = null
            private var updatedBy: UpdatedBy? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(documentUpdateBody: DocumentUpdateBody) = apply {
                this.id = documentUpdateBody.id
                this.corpusPolicy = documentUpdateBody.corpusPolicy
                this.createdBy = documentUpdateBody.createdBy
                this.externalLookupKey = documentUpdateBody.externalLookupKey
                this.languageCode = documentUpdateBody.languageCode
                this.processingVersion = documentUpdateBody.processingVersion
                this.sourceAuthor = documentUpdateBody.sourceAuthor
                this.sourceCreatedAt = documentUpdateBody.sourceCreatedAt
                this.sourceUpdatedAt = documentUpdateBody.sourceUpdatedAt
                this.sourceUrl = documentUpdateBody.sourceUrl
                this.text = documentUpdateBody.text
                this.title = documentUpdateBody.title
                this.updatedBy = documentUpdateBody.updatedBy
                additionalProperties(documentUpdateBody.additionalProperties)
            }

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("corpusPolicy")
            fun corpusPolicy(corpusPolicy: CorpusPolicy) = apply {
                this.corpusPolicy = corpusPolicy
            }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply {
                this.createdBy = createdBy
            }

            @JsonProperty("externalLookupKey")
            fun externalLookupKey(externalLookupKey: String) = apply {
                this.externalLookupKey = externalLookupKey
            }

            @JsonProperty("languageCode")
            fun languageCode(languageCode: LanguageCode) = apply {
                this.languageCode = languageCode
            }

            @JsonProperty("processingVersion")
            fun processingVersion(processingVersion: Long) = apply {
                this.processingVersion = processingVersion
            }

            @JsonProperty("sourceAuthor")
            fun sourceAuthor(sourceAuthor: String) = apply {
                this.sourceAuthor = sourceAuthor
            }

            @JsonProperty("sourceCreatedAt")
            fun sourceCreatedAt(sourceCreatedAt: OffsetDateTime) = apply {
                this.sourceCreatedAt = sourceCreatedAt
            }

            @JsonProperty("sourceUpdatedAt")
            fun sourceUpdatedAt(sourceUpdatedAt: OffsetDateTime) = apply {
                this.sourceUpdatedAt = sourceUpdatedAt
            }

            @JsonProperty("sourceUrl")
            fun sourceUrl(sourceUrl: String) = apply {
                this.sourceUrl = sourceUrl
            }

            @JsonProperty("text")
            fun text(text: String) = apply {
                this.text = text
            }

            @JsonProperty("title")
            fun title(title: String) = apply {
                this.title = title
            }

            @JsonProperty("updatedBy")
            fun updatedBy(updatedBy: UpdatedBy) = apply {
                this.updatedBy = updatedBy
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

            fun build(): DocumentUpdateBody = DocumentUpdateBody(
                id,
                corpusPolicy,
                createdBy,
                externalLookupKey,
                languageCode,
                processingVersion,
                sourceAuthor,
                sourceCreatedAt,
                sourceUpdatedAt,
                sourceUrl,
                text,
                title,
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

      return other is DocumentUpdateParams &&
          this.docId == other.docId &&
          this.id == other.id &&
          this.corpusPolicy == other.corpusPolicy &&
          this.createdBy == other.createdBy &&
          this.externalLookupKey == other.externalLookupKey &&
          this.languageCode == other.languageCode &&
          this.processingVersion == other.processingVersion &&
          this.sourceAuthor == other.sourceAuthor &&
          this.sourceCreatedAt == other.sourceCreatedAt &&
          this.sourceUpdatedAt == other.sourceUpdatedAt &&
          this.sourceUrl == other.sourceUrl &&
          this.text == other.text &&
          this.title == other.title &&
          this.updatedBy == other.updatedBy &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          docId,
          id,
          corpusPolicy,
          createdBy,
          externalLookupKey,
          languageCode,
          processingVersion,
          sourceAuthor,
          sourceCreatedAt,
          sourceUpdatedAt,
          sourceUrl,
          text,
          title,
          updatedBy,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "DocumentUpdateParams{docId=$docId, id=$id, corpusPolicy=$corpusPolicy, createdBy=$createdBy, externalLookupKey=$externalLookupKey, languageCode=$languageCode, processingVersion=$processingVersion, sourceAuthor=$sourceAuthor, sourceCreatedAt=$sourceCreatedAt, sourceUpdatedAt=$sourceUpdatedAt, sourceUrl=$sourceUrl, text=$text, title=$title, updatedBy=$updatedBy, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var docId: String? = null
        private var id: String? = null
        private var corpusPolicy: CorpusPolicy? = null
        private var createdBy: CreatedBy? = null
        private var externalLookupKey: String? = null
        private var languageCode: LanguageCode? = null
        private var processingVersion: Long? = null
        private var sourceAuthor: String? = null
        private var sourceCreatedAt: OffsetDateTime? = null
        private var sourceUpdatedAt: OffsetDateTime? = null
        private var sourceUrl: String? = null
        private var text: String? = null
        private var title: String? = null
        private var updatedBy: UpdatedBy? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(documentUpdateParams: DocumentUpdateParams) = apply {
            this.docId = documentUpdateParams.docId
            this.id = documentUpdateParams.id
            this.corpusPolicy = documentUpdateParams.corpusPolicy
            this.createdBy = documentUpdateParams.createdBy
            this.externalLookupKey = documentUpdateParams.externalLookupKey
            this.languageCode = documentUpdateParams.languageCode
            this.processingVersion = documentUpdateParams.processingVersion
            this.sourceAuthor = documentUpdateParams.sourceAuthor
            this.sourceCreatedAt = documentUpdateParams.sourceCreatedAt
            this.sourceUpdatedAt = documentUpdateParams.sourceUpdatedAt
            this.sourceUrl = documentUpdateParams.sourceUrl
            this.text = documentUpdateParams.text
            this.title = documentUpdateParams.title
            this.updatedBy = documentUpdateParams.updatedBy
            additionalQueryParams(documentUpdateParams.additionalQueryParams)
            additionalHeaders(documentUpdateParams.additionalHeaders)
            additionalBodyProperties(documentUpdateParams.additionalBodyProperties)
        }

        fun docId(docId: String) = apply {
            this.docId = docId
        }

        fun id(id: String) = apply {
            this.id = id
        }

        fun corpusPolicy(corpusPolicy: CorpusPolicy) = apply {
            this.corpusPolicy = corpusPolicy
        }

        fun createdBy(createdBy: CreatedBy) = apply {
            this.createdBy = createdBy
        }

        fun externalLookupKey(externalLookupKey: String) = apply {
            this.externalLookupKey = externalLookupKey
        }

        fun languageCode(languageCode: LanguageCode) = apply {
            this.languageCode = languageCode
        }

        fun processingVersion(processingVersion: Long) = apply {
            this.processingVersion = processingVersion
        }

        fun sourceAuthor(sourceAuthor: String) = apply {
            this.sourceAuthor = sourceAuthor
        }

        fun sourceCreatedAt(sourceCreatedAt: OffsetDateTime) = apply {
            this.sourceCreatedAt = sourceCreatedAt
        }

        fun sourceUpdatedAt(sourceUpdatedAt: OffsetDateTime) = apply {
            this.sourceUpdatedAt = sourceUpdatedAt
        }

        fun sourceUrl(sourceUrl: String) = apply {
            this.sourceUrl = sourceUrl
        }

        fun text(text: String) = apply {
            this.text = text
        }

        fun title(title: String) = apply {
            this.title = title
        }

        fun updatedBy(updatedBy: UpdatedBy) = apply {
            this.updatedBy = updatedBy
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

        fun removeHeader(name: String) = apply {
            this.additionalHeaders.put(name, mutableListOf())
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun build(): DocumentUpdateParams = DocumentUpdateParams(
            checkNotNull(docId) {
                "`docId` is required but was not set"
            },
            id,
            corpusPolicy,
            createdBy,
            externalLookupKey,
            languageCode,
            processingVersion,
            sourceAuthor,
            sourceCreatedAt,
            sourceUpdatedAt,
            sourceUrl,
            text,
            title,
            updatedBy,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    class CorpusPolicy @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is CorpusPolicy &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val INCLUDE = CorpusPolicy(JsonField.of("INCLUDE"))

            val EXCLUDE_ALWAYS = CorpusPolicy(JsonField.of("EXCLUDE_ALWAYS"))

            fun of(value: String) = CorpusPolicy(JsonField.of(value))
        }

        enum class Known {
            INCLUDE,
            EXCLUDE_ALWAYS,
        }

        enum class Value {
            INCLUDE,
            EXCLUDE_ALWAYS,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            INCLUDE -> Value.INCLUDE
            EXCLUDE_ALWAYS -> Value.EXCLUDE_ALWAYS
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            INCLUDE -> Known.INCLUDE
            EXCLUDE_ALWAYS -> Known.EXCLUDE_ALWAYS
            else -> throw SamInvalidDataException("Unknown CorpusPolicy: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = CreatedBy.Builder::class)
    @NoAutoDetect
    class CreatedBy private constructor(private val id: String?, private val name: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("name")
        fun name(): String? = name

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
            hashCode = Objects.hash(
                id,
                name,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "CreatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

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

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
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

            fun build(): CreatedBy = CreatedBy(
                id,
                name,
                additionalProperties.toUnmodifiable(),
            )
        }
    }

    @JsonDeserialize(builder = LanguageCode.Builder::class)
    @NoAutoDetect
    class LanguageCode private constructor(private val code: String?, private val detected: Boolean?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        @JsonProperty("code")
        fun code(): String? = code

        @JsonProperty("detected")
        fun detected(): Boolean? = detected

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is LanguageCode &&
              this.code == other.code &&
              this.detected == other.detected &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                code,
                detected,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "LanguageCode{code=$code, detected=$detected, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var code: String? = null
            private var detected: Boolean? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(languageCode: LanguageCode) = apply {
                this.code = languageCode.code
                this.detected = languageCode.detected
                additionalProperties(languageCode.additionalProperties)
            }

            @JsonProperty("code")
            fun code(code: String) = apply {
                this.code = code
            }

            @JsonProperty("detected")
            fun detected(detected: Boolean) = apply {
                this.detected = detected
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

            fun build(): LanguageCode = LanguageCode(
                code,
                detected,
                additionalProperties.toUnmodifiable(),
            )
        }
    }

    @JsonDeserialize(builder = UpdatedBy.Builder::class)
    @NoAutoDetect
    class UpdatedBy private constructor(private val id: String?, private val name: String?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("name")
        fun name(): String? = name

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
            hashCode = Objects.hash(
                id,
                name,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "UpdatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

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

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
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

            fun build(): UpdatedBy = UpdatedBy(
                id,
                name,
                additionalProperties.toUnmodifiable(),
            )
        }
    }
}
