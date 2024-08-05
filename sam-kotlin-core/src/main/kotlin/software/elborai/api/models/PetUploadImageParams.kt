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

class PetUploadImageParams constructor(
  private val petId: Long,
  private val body: String,
  private val additionalMetadata: String?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,

) {

    fun petId(): Long = petId

    fun body(): String = body

    fun additionalMetadata(): String? = additionalMetadata

    internal fun getBody(): String {
      return body
    }

    internal fun getQueryParams(): Map<String, List<String>> {
      val params = mutableMapOf<String, List<String>>()
      this.additionalMetadata?.let {
          params.put("additionalMetadata", listOf(it.toString()))
      }
      params.putAll(additionalQueryParams)
      return params.toUnmodifiable()
    }

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> petId.toString()
          else -> ""
      }
    }

    @JsonDeserialize(builder = PetUploadImageBody.Builder::class)
    @NoAutoDetect
    class PetUploadImageBody internal constructor(private val body: String?, ) {

        private var hashCode: Int = 0

        @JsonProperty("body")
        fun body(): String? = body

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is PetUploadImageBody &&
              this.body == other.body
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(body)
          }
          return hashCode
        }

        override fun toString() = "PetUploadImageBody{body=$body}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var body: String? = null

            internal fun from(petUploadImageBody: PetUploadImageBody) = apply {
                this.body = petUploadImageBody.body
            }

            @JsonProperty("body")
            fun body(body: String) = apply {
                this.body = body
            }
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is PetUploadImageParams &&
          this.petId == other.petId &&
          this.body == other.body &&
          this.additionalMetadata == other.additionalMetadata &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
      return Objects.hash(
          petId,
          body,
          additionalMetadata,
          additionalQueryParams,
          additionalHeaders,
      )
    }

    override fun toString() = "PetUploadImageParams{petId=$petId, body=$body, additionalMetadata=$additionalMetadata, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var petId: Long? = null
        private var body: String? = null
        private var additionalMetadata: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(petUploadImageParams: PetUploadImageParams) = apply {
            this.petId = petUploadImageParams.petId
            this.body = petUploadImageParams.body
            this.additionalMetadata = petUploadImageParams.additionalMetadata
            additionalQueryParams(petUploadImageParams.additionalQueryParams)
            additionalHeaders(petUploadImageParams.additionalHeaders)
        }

        fun petId(petId: Long) = apply {
            this.petId = petId
        }

        fun body(body: String) = apply {
            this.body = body
        }

        /** Additional Metadata */
        fun additionalMetadata(additionalMetadata: String) = apply {
            this.additionalMetadata = additionalMetadata
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

        fun build(): PetUploadImageParams = PetUploadImageParams(
            checkNotNull(petId) {
                "`petId` is required but was not set"
            },
            checkNotNull(body) {
                "`body` is required but was not set"
            },
            additionalMetadata,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
        )
    }
}
