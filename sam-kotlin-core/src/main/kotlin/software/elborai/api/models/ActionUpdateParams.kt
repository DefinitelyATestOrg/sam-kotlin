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

class ActionUpdateParams constructor(
  private val actionId: String,
  private val actionSetId: String?,
  private val agentId: String?,
  private val createdBy: CreatedBy?,
  private val description: String?,
  private val errorMessage: String?,
  private val method: Method?,
  private val name: String?,
  private val parameters: List<Parameter>?,
  private val path: String?,
  private val requestBodyType: RequestBodyType?,
  private val status: Status?,
  private val updatedBy: UpdatedBy?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun actionId(): String = actionId

    fun actionSetId(): String? = actionSetId

    fun agentId(): String? = agentId

    fun createdBy(): CreatedBy? = createdBy

    fun description(): String? = description

    fun errorMessage(): String? = errorMessage

    fun method(): Method? = method

    fun name(): String? = name

    fun parameters(): List<Parameter>? = parameters

    fun path(): String? = path

    fun requestBodyType(): RequestBodyType? = requestBodyType

    fun status(): Status? = status

    fun updatedBy(): UpdatedBy? = updatedBy

    internal fun getBody(): ActionUpdateBody {
      return ActionUpdateBody(
          actionSetId,
          agentId,
          createdBy,
          description,
          errorMessage,
          method,
          name,
          parameters,
          path,
          requestBodyType,
          status,
          updatedBy,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> actionId
          else -> ""
      }
    }

    @JsonDeserialize(builder = ActionUpdateBody.Builder::class)
    @NoAutoDetect
    class ActionUpdateBody internal constructor(
      private val actionSetId: String?,
      private val agentId: String?,
      private val createdBy: CreatedBy?,
      private val description: String?,
      private val errorMessage: String?,
      private val method: Method?,
      private val name: String?,
      private val parameters: List<Parameter>?,
      private val path: String?,
      private val requestBodyType: RequestBodyType?,
      private val status: Status?,
      private val updatedBy: UpdatedBy?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("actionSetId")
        fun actionSetId(): String? = actionSetId

        @JsonProperty("agentId")
        fun agentId(): String? = agentId

        @JsonProperty("createdBy")
        fun createdBy(): CreatedBy? = createdBy

        @JsonProperty("description")
        fun description(): String? = description

        @JsonProperty("errorMessage")
        fun errorMessage(): String? = errorMessage

        @JsonProperty("method")
        fun method(): Method? = method

        @JsonProperty("name")
        fun name(): String? = name

        @JsonProperty("parameters")
        fun parameters(): List<Parameter>? = parameters

        @JsonProperty("path")
        fun path(): String? = path

        @JsonProperty("requestBodyType")
        fun requestBodyType(): RequestBodyType? = requestBodyType

        @JsonProperty("status")
        fun status(): Status? = status

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

          return other is ActionUpdateBody &&
              this.actionSetId == other.actionSetId &&
              this.agentId == other.agentId &&
              this.createdBy == other.createdBy &&
              this.description == other.description &&
              this.errorMessage == other.errorMessage &&
              this.method == other.method &&
              this.name == other.name &&
              this.parameters == other.parameters &&
              this.path == other.path &&
              this.requestBodyType == other.requestBodyType &&
              this.status == other.status &&
              this.updatedBy == other.updatedBy &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                actionSetId,
                agentId,
                createdBy,
                description,
                errorMessage,
                method,
                name,
                parameters,
                path,
                requestBodyType,
                status,
                updatedBy,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "ActionUpdateBody{actionSetId=$actionSetId, agentId=$agentId, createdBy=$createdBy, description=$description, errorMessage=$errorMessage, method=$method, name=$name, parameters=$parameters, path=$path, requestBodyType=$requestBodyType, status=$status, updatedBy=$updatedBy, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var actionSetId: String? = null
            private var agentId: String? = null
            private var createdBy: CreatedBy? = null
            private var description: String? = null
            private var errorMessage: String? = null
            private var method: Method? = null
            private var name: String? = null
            private var parameters: List<Parameter>? = null
            private var path: String? = null
            private var requestBodyType: RequestBodyType? = null
            private var status: Status? = null
            private var updatedBy: UpdatedBy? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(actionUpdateBody: ActionUpdateBody) = apply {
                this.actionSetId = actionUpdateBody.actionSetId
                this.agentId = actionUpdateBody.agentId
                this.createdBy = actionUpdateBody.createdBy
                this.description = actionUpdateBody.description
                this.errorMessage = actionUpdateBody.errorMessage
                this.method = actionUpdateBody.method
                this.name = actionUpdateBody.name
                this.parameters = actionUpdateBody.parameters
                this.path = actionUpdateBody.path
                this.requestBodyType = actionUpdateBody.requestBodyType
                this.status = actionUpdateBody.status
                this.updatedBy = actionUpdateBody.updatedBy
                additionalProperties(actionUpdateBody.additionalProperties)
            }

            @JsonProperty("actionSetId")
            fun actionSetId(actionSetId: String) = apply {
                this.actionSetId = actionSetId
            }

            @JsonProperty("agentId")
            fun agentId(agentId: String) = apply {
                this.agentId = agentId
            }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply {
                this.createdBy = createdBy
            }

            @JsonProperty("description")
            fun description(description: String) = apply {
                this.description = description
            }

            @JsonProperty("errorMessage")
            fun errorMessage(errorMessage: String) = apply {
                this.errorMessage = errorMessage
            }

            @JsonProperty("method")
            fun method(method: Method) = apply {
                this.method = method
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
            }

            @JsonProperty("parameters")
            fun parameters(parameters: List<Parameter>) = apply {
                this.parameters = parameters
            }

            @JsonProperty("path")
            fun path(path: String) = apply {
                this.path = path
            }

            @JsonProperty("requestBodyType")
            fun requestBodyType(requestBodyType: RequestBodyType) = apply {
                this.requestBodyType = requestBodyType
            }

            @JsonProperty("status")
            fun status(status: Status) = apply {
                this.status = status
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

            fun build(): ActionUpdateBody = ActionUpdateBody(
                actionSetId,
                agentId,
                createdBy,
                description,
                errorMessage,
                method,
                name,
                parameters?.toUnmodifiable(),
                path,
                requestBodyType,
                status,
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

      return other is ActionUpdateParams &&
          this.actionId == other.actionId &&
          this.actionSetId == other.actionSetId &&
          this.agentId == other.agentId &&
          this.createdBy == other.createdBy &&
          this.description == other.description &&
          this.errorMessage == other.errorMessage &&
          this.method == other.method &&
          this.name == other.name &&
          this.parameters == other.parameters &&
          this.path == other.path &&
          this.requestBodyType == other.requestBodyType &&
          this.status == other.status &&
          this.updatedBy == other.updatedBy &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          actionId,
          actionSetId,
          agentId,
          createdBy,
          description,
          errorMessage,
          method,
          name,
          parameters,
          path,
          requestBodyType,
          status,
          updatedBy,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "ActionUpdateParams{actionId=$actionId, actionSetId=$actionSetId, agentId=$agentId, createdBy=$createdBy, description=$description, errorMessage=$errorMessage, method=$method, name=$name, parameters=$parameters, path=$path, requestBodyType=$requestBodyType, status=$status, updatedBy=$updatedBy, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var actionId: String? = null
        private var actionSetId: String? = null
        private var agentId: String? = null
        private var createdBy: CreatedBy? = null
        private var description: String? = null
        private var errorMessage: String? = null
        private var method: Method? = null
        private var name: String? = null
        private var parameters: MutableList<Parameter> = mutableListOf()
        private var path: String? = null
        private var requestBodyType: RequestBodyType? = null
        private var status: Status? = null
        private var updatedBy: UpdatedBy? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(actionUpdateParams: ActionUpdateParams) = apply {
            this.actionId = actionUpdateParams.actionId
            this.actionSetId = actionUpdateParams.actionSetId
            this.agentId = actionUpdateParams.agentId
            this.createdBy = actionUpdateParams.createdBy
            this.description = actionUpdateParams.description
            this.errorMessage = actionUpdateParams.errorMessage
            this.method = actionUpdateParams.method
            this.name = actionUpdateParams.name
            this.parameters(actionUpdateParams.parameters ?: listOf())
            this.path = actionUpdateParams.path
            this.requestBodyType = actionUpdateParams.requestBodyType
            this.status = actionUpdateParams.status
            this.updatedBy = actionUpdateParams.updatedBy
            additionalQueryParams(actionUpdateParams.additionalQueryParams)
            additionalHeaders(actionUpdateParams.additionalHeaders)
            additionalBodyProperties(actionUpdateParams.additionalBodyProperties)
        }

        fun actionId(actionId: String) = apply {
            this.actionId = actionId
        }

        fun actionSetId(actionSetId: String) = apply {
            this.actionSetId = actionSetId
        }

        fun agentId(agentId: String) = apply {
            this.agentId = agentId
        }

        fun createdBy(createdBy: CreatedBy) = apply {
            this.createdBy = createdBy
        }

        fun description(description: String) = apply {
            this.description = description
        }

        fun errorMessage(errorMessage: String) = apply {
            this.errorMessage = errorMessage
        }

        fun method(method: Method) = apply {
            this.method = method
        }

        fun name(name: String) = apply {
            this.name = name
        }

        fun parameters(parameters: List<Parameter>) = apply {
            this.parameters.clear()
            this.parameters.addAll(parameters)
        }

        fun addParameter(parameter: Parameter) = apply {
            this.parameters.add(parameter)
        }

        fun path(path: String) = apply {
            this.path = path
        }

        fun requestBodyType(requestBodyType: RequestBodyType) = apply {
            this.requestBodyType = requestBodyType
        }

        fun status(status: Status) = apply {
            this.status = status
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

        fun build(): ActionUpdateParams = ActionUpdateParams(
            checkNotNull(actionId) {
                "`actionId` is required but was not set"
            },
            actionSetId,
            agentId,
            createdBy,
            description,
            errorMessage,
            method,
            name,
            if(parameters.size == 0) null else parameters.toUnmodifiable(),
            path,
            requestBodyType,
            status,
            updatedBy,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
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

    class Method @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Method &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val GET = Method(JsonField.of("GET"))

            val POST = Method(JsonField.of("POST"))

            val PUT = Method(JsonField.of("PUT"))

            val DELETE = Method(JsonField.of("DELETE"))

            fun of(value: String) = Method(JsonField.of(value))
        }

        enum class Known {
            GET,
            POST,
            PUT,
            DELETE,
        }

        enum class Value {
            GET,
            POST,
            PUT,
            DELETE,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            GET -> Value.GET
            POST -> Value.POST
            PUT -> Value.PUT
            DELETE -> Value.DELETE
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            GET -> Known.GET
            POST -> Known.POST
            PUT -> Known.PUT
            DELETE -> Known.DELETE
            else -> throw SamInvalidDataException("Unknown Method: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(builder = Parameter.Builder::class)
    @NoAutoDetect
    class Parameter private constructor(
      private val type: Type?,
      private val name: String?,
      private val description: String?,
      private val validationType: ValidationType?,
      private val required: Boolean?,
      private val status: Status?,
      private val errorMessage: String?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("type")
        fun type(): Type? = type

        @JsonProperty("name")
        fun name(): String? = name

        @JsonProperty("description")
        fun description(): String? = description

        @JsonProperty("validationType")
        fun validationType(): ValidationType? = validationType

        @JsonProperty("required")
        fun required(): Boolean? = required

        @JsonProperty("status")
        fun status(): Status? = status

        @JsonProperty("errorMessage")
        fun errorMessage(): String? = errorMessage

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Parameter &&
              this.type == other.type &&
              this.name == other.name &&
              this.description == other.description &&
              this.validationType == other.validationType &&
              this.required == other.required &&
              this.status == other.status &&
              this.errorMessage == other.errorMessage &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                type,
                name,
                description,
                validationType,
                required,
                status,
                errorMessage,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "Parameter{type=$type, name=$name, description=$description, validationType=$validationType, required=$required, status=$status, errorMessage=$errorMessage, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var type: Type? = null
            private var name: String? = null
            private var description: String? = null
            private var validationType: ValidationType? = null
            private var required: Boolean? = null
            private var status: Status? = null
            private var errorMessage: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(parameter: Parameter) = apply {
                this.type = parameter.type
                this.name = parameter.name
                this.description = parameter.description
                this.validationType = parameter.validationType
                this.required = parameter.required
                this.status = parameter.status
                this.errorMessage = parameter.errorMessage
                additionalProperties(parameter.additionalProperties)
            }

            @JsonProperty("type")
            fun type(type: Type) = apply {
                this.type = type
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
            }

            @JsonProperty("description")
            fun description(description: String) = apply {
                this.description = description
            }

            @JsonProperty("validationType")
            fun validationType(validationType: ValidationType) = apply {
                this.validationType = validationType
            }

            @JsonProperty("required")
            fun required(required: Boolean) = apply {
                this.required = required
            }

            @JsonProperty("status")
            fun status(status: Status) = apply {
                this.status = status
            }

            @JsonProperty("errorMessage")
            fun errorMessage(errorMessage: String) = apply {
                this.errorMessage = errorMessage
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

            fun build(): Parameter = Parameter(
                type,
                name,
                description,
                validationType,
                required,
                status,
                errorMessage,
                additionalProperties.toUnmodifiable(),
            )
        }

        class Status @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is Status &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val USER_CONTEXT = Status(JsonField.of("USER_CONTEXT"))

                val EDITABLE = Status(JsonField.of("EDITABLE"))

                val UNSUPPORTED = Status(JsonField.of("UNSUPPORTED"))

                fun of(value: String) = Status(JsonField.of(value))
            }

            enum class Known {
                USER_CONTEXT,
                EDITABLE,
                UNSUPPORTED,
            }

            enum class Value {
                USER_CONTEXT,
                EDITABLE,
                UNSUPPORTED,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                USER_CONTEXT -> Value.USER_CONTEXT
                EDITABLE -> Value.EDITABLE
                UNSUPPORTED -> Value.UNSUPPORTED
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                USER_CONTEXT -> Known.USER_CONTEXT
                EDITABLE -> Known.EDITABLE
                UNSUPPORTED -> Known.UNSUPPORTED
                else -> throw SamInvalidDataException("Unknown Status: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
        }

        class Type @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is Type &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val PATH = Type(JsonField.of("PATH"))

                val QUERY = Type(JsonField.of("QUERY"))

                val BODY = Type(JsonField.of("BODY"))

                fun of(value: String) = Type(JsonField.of(value))
            }

            enum class Known {
                PATH,
                QUERY,
                BODY,
            }

            enum class Value {
                PATH,
                QUERY,
                BODY,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                PATH -> Value.PATH
                QUERY -> Value.QUERY
                BODY -> Value.BODY
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                PATH -> Known.PATH
                QUERY -> Known.QUERY
                BODY -> Known.BODY
                else -> throw SamInvalidDataException("Unknown Type: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
        }

        class ValidationType @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is ValidationType &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val STRING = ValidationType(JsonField.of("STRING"))

                val BOOLEAN = ValidationType(JsonField.of("BOOLEAN"))

                val NUMBER = ValidationType(JsonField.of("NUMBER"))

                fun of(value: String) = ValidationType(JsonField.of(value))
            }

            enum class Known {
                STRING,
                BOOLEAN,
                NUMBER,
            }

            enum class Value {
                STRING,
                BOOLEAN,
                NUMBER,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                STRING -> Value.STRING
                BOOLEAN -> Value.BOOLEAN
                NUMBER -> Value.NUMBER
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                STRING -> Known.STRING
                BOOLEAN -> Known.BOOLEAN
                NUMBER -> Known.NUMBER
                else -> throw SamInvalidDataException("Unknown ValidationType: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
        }
    }

    class RequestBodyType @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is RequestBodyType &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val JSON = RequestBodyType(JsonField.of("JSON"))

            fun of(value: String) = RequestBodyType(JsonField.of(value))
        }

        enum class Known {
            JSON,
        }

        enum class Value {
            JSON,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            JSON -> Value.JSON
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            JSON -> Known.JSON
            else -> throw SamInvalidDataException("Unknown RequestBodyType: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Status @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Status &&
              this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val ACTIVE = Status(JsonField.of("ACTIVE"))

            val INACTIVE = Status(JsonField.of("INACTIVE"))

            val UNSUPPORTED = Status(JsonField.of("UNSUPPORTED"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            ACTIVE,
            INACTIVE,
            UNSUPPORTED,
        }

        enum class Value {
            ACTIVE,
            INACTIVE,
            UNSUPPORTED,
            _UNKNOWN,
        }

        fun value(): Value = when (this) {
            ACTIVE -> Value.ACTIVE
            INACTIVE -> Value.INACTIVE
            UNSUPPORTED -> Value.UNSUPPORTED
            else -> Value._UNKNOWN
        }

        fun known(): Known = when (this) {
            ACTIVE -> Known.ACTIVE
            INACTIVE -> Known.INACTIVE
            UNSUPPORTED -> Known.UNSUPPORTED
            else -> throw SamInvalidDataException("Unknown Status: $value")
        }

        fun asString(): String = _value().asStringOrThrow()
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
