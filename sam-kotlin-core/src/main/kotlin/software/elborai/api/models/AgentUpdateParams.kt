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

class AgentUpdateParams constructor(
  private val id: String,
  private val agent: Agent,
  private val chatIcon: String?,
  private val chatIconDeleted: Boolean?,
  private val logo: String?,
  private val logoDeleted: Boolean?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun id(): String = id

    fun agent(): Agent = agent

    fun chatIcon(): String? = chatIcon

    fun chatIconDeleted(): Boolean? = chatIconDeleted

    fun logo(): String? = logo

    fun logoDeleted(): Boolean? = logoDeleted

    internal fun getBody(): AgentUpdateBody {
      return AgentUpdateBody(
          agent,
          chatIcon,
          chatIconDeleted,
          logo,
          logoDeleted,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> id
          else -> ""
      }
    }

    @JsonDeserialize(builder = AgentUpdateBody.Builder::class)
    @NoAutoDetect
    class AgentUpdateBody internal constructor(
      private val agent: Agent?,
      private val chatIcon: String?,
      private val chatIconDeleted: Boolean?,
      private val logo: String?,
      private val logoDeleted: Boolean?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("agent")
        fun agent(): Agent? = agent

        @JsonProperty("chatIcon")
        fun chatIcon(): String? = chatIcon

        @JsonProperty("chatIconDeleted")
        fun chatIconDeleted(): Boolean? = chatIconDeleted

        @JsonProperty("logo")
        fun logo(): String? = logo

        @JsonProperty("logoDeleted")
        fun logoDeleted(): Boolean? = logoDeleted

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is AgentUpdateBody &&
              this.agent == other.agent &&
              this.chatIcon == other.chatIcon &&
              this.chatIconDeleted == other.chatIconDeleted &&
              this.logo == other.logo &&
              this.logoDeleted == other.logoDeleted &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                agent,
                chatIcon,
                chatIconDeleted,
                logo,
                logoDeleted,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "AgentUpdateBody{agent=$agent, chatIcon=$chatIcon, chatIconDeleted=$chatIconDeleted, logo=$logo, logoDeleted=$logoDeleted, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var agent: Agent? = null
            private var chatIcon: String? = null
            private var chatIconDeleted: Boolean? = null
            private var logo: String? = null
            private var logoDeleted: Boolean? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(agentUpdateBody: AgentUpdateBody) = apply {
                this.agent = agentUpdateBody.agent
                this.chatIcon = agentUpdateBody.chatIcon
                this.chatIconDeleted = agentUpdateBody.chatIconDeleted
                this.logo = agentUpdateBody.logo
                this.logoDeleted = agentUpdateBody.logoDeleted
                additionalProperties(agentUpdateBody.additionalProperties)
            }

            @JsonProperty("agent")
            fun agent(agent: Agent) = apply {
                this.agent = agent
            }

            @JsonProperty("chatIcon")
            fun chatIcon(chatIcon: String) = apply {
                this.chatIcon = chatIcon
            }

            @JsonProperty("chatIconDeleted")
            fun chatIconDeleted(chatIconDeleted: Boolean) = apply {
                this.chatIconDeleted = chatIconDeleted
            }

            @JsonProperty("logo")
            fun logo(logo: String) = apply {
                this.logo = logo
            }

            @JsonProperty("logoDeleted")
            fun logoDeleted(logoDeleted: Boolean) = apply {
                this.logoDeleted = logoDeleted
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

            fun build(): AgentUpdateBody = AgentUpdateBody(
                checkNotNull(agent) {
                    "`agent` is required but was not set"
                },
                chatIcon,
                chatIconDeleted,
                logo,
                logoDeleted,
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

      return other is AgentUpdateParams &&
          this.id == other.id &&
          this.agent == other.agent &&
          this.chatIcon == other.chatIcon &&
          this.chatIconDeleted == other.chatIconDeleted &&
          this.logo == other.logo &&
          this.logoDeleted == other.logoDeleted &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          id,
          agent,
          chatIcon,
          chatIconDeleted,
          logo,
          logoDeleted,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "AgentUpdateParams{id=$id, agent=$agent, chatIcon=$chatIcon, chatIconDeleted=$chatIconDeleted, logo=$logo, logoDeleted=$logoDeleted, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var id: String? = null
        private var agent: Agent? = null
        private var chatIcon: String? = null
        private var chatIconDeleted: Boolean? = null
        private var logo: String? = null
        private var logoDeleted: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(agentUpdateParams: AgentUpdateParams) = apply {
            this.id = agentUpdateParams.id
            this.agent = agentUpdateParams.agent
            this.chatIcon = agentUpdateParams.chatIcon
            this.chatIconDeleted = agentUpdateParams.chatIconDeleted
            this.logo = agentUpdateParams.logo
            this.logoDeleted = agentUpdateParams.logoDeleted
            additionalQueryParams(agentUpdateParams.additionalQueryParams)
            additionalHeaders(agentUpdateParams.additionalHeaders)
            additionalBodyProperties(agentUpdateParams.additionalBodyProperties)
        }

        fun id(id: String) = apply {
            this.id = id
        }

        fun agent(agent: Agent) = apply {
            this.agent = agent
        }

        fun chatIcon(chatIcon: String) = apply {
            this.chatIcon = chatIcon
        }

        fun chatIconDeleted(chatIconDeleted: Boolean) = apply {
            this.chatIconDeleted = chatIconDeleted
        }

        fun logo(logo: String) = apply {
            this.logo = logo
        }

        fun logoDeleted(logoDeleted: Boolean) = apply {
            this.logoDeleted = logoDeleted
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

        fun build(): AgentUpdateParams = AgentUpdateParams(
            checkNotNull(id) {
                "`id` is required but was not set"
            },
            checkNotNull(agent) {
                "`agent` is required but was not set"
            },
            chatIcon,
            chatIconDeleted,
            logo,
            logoDeleted,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    @JsonDeserialize(builder = Agent.Builder::class)
    @NoAutoDetect
    class Agent private constructor(
      private val id: String?,
      private val name: String?,
      private val brandColor: String?,
      private val organizationId: String?,
      private val persona: Persona?,
      private val additionalPromptText: String?,
      private val popularQuestions: List<String>?,
      private val bailoutType: BailoutType?,
      private val bailoutText: String?,
      private val bailoutIntegration: BailoutIntegration?,
      private val hiddenTicketTags: List<String>?,
      private val internalSalesStatus: InternalSalesStatus?,
      private val createdAt: OffsetDateTime?,
      private val updatedAt: OffsetDateTime?,
      private val createdBy: CreatedBy?,
      private val updatedBy: UpdatedBy?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): String? = id

        @JsonProperty("name")
        fun name(): String? = name

        @JsonProperty("brandColor")
        fun brandColor(): String? = brandColor

        @JsonProperty("organizationId")
        fun organizationId(): String? = organizationId

        @JsonProperty("persona")
        fun persona(): Persona? = persona

        @JsonProperty("additionalPromptText")
        fun additionalPromptText(): String? = additionalPromptText

        @JsonProperty("popularQuestions")
        fun popularQuestions(): List<String>? = popularQuestions

        @JsonProperty("bailoutType")
        fun bailoutType(): BailoutType? = bailoutType

        @JsonProperty("bailoutText")
        fun bailoutText(): String? = bailoutText

        @JsonProperty("bailoutIntegration")
        fun bailoutIntegration(): BailoutIntegration? = bailoutIntegration

        @JsonProperty("hiddenTicketTags")
        fun hiddenTicketTags(): List<String>? = hiddenTicketTags

        @JsonProperty("internal__salesStatus")
        fun internalSalesStatus(): InternalSalesStatus? = internalSalesStatus

        @JsonProperty("createdAt")
        fun createdAt(): OffsetDateTime? = createdAt

        @JsonProperty("updatedAt")
        fun updatedAt(): OffsetDateTime? = updatedAt

        @JsonProperty("createdBy")
        fun createdBy(): CreatedBy? = createdBy

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

          return other is Agent &&
              this.id == other.id &&
              this.name == other.name &&
              this.brandColor == other.brandColor &&
              this.organizationId == other.organizationId &&
              this.persona == other.persona &&
              this.additionalPromptText == other.additionalPromptText &&
              this.popularQuestions == other.popularQuestions &&
              this.bailoutType == other.bailoutType &&
              this.bailoutText == other.bailoutText &&
              this.bailoutIntegration == other.bailoutIntegration &&
              this.hiddenTicketTags == other.hiddenTicketTags &&
              this.internalSalesStatus == other.internalSalesStatus &&
              this.createdAt == other.createdAt &&
              this.updatedAt == other.updatedAt &&
              this.createdBy == other.createdBy &&
              this.updatedBy == other.updatedBy &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                id,
                name,
                brandColor,
                organizationId,
                persona,
                additionalPromptText,
                popularQuestions,
                bailoutType,
                bailoutText,
                bailoutIntegration,
                hiddenTicketTags,
                internalSalesStatus,
                createdAt,
                updatedAt,
                createdBy,
                updatedBy,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "Agent{id=$id, name=$name, brandColor=$brandColor, organizationId=$organizationId, persona=$persona, additionalPromptText=$additionalPromptText, popularQuestions=$popularQuestions, bailoutType=$bailoutType, bailoutText=$bailoutText, bailoutIntegration=$bailoutIntegration, hiddenTicketTags=$hiddenTicketTags, internalSalesStatus=$internalSalesStatus, createdAt=$createdAt, updatedAt=$updatedAt, createdBy=$createdBy, updatedBy=$updatedBy, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var brandColor: String? = null
            private var organizationId: String? = null
            private var persona: Persona? = null
            private var additionalPromptText: String? = null
            private var popularQuestions: List<String>? = null
            private var bailoutType: BailoutType? = null
            private var bailoutText: String? = null
            private var bailoutIntegration: BailoutIntegration? = null
            private var hiddenTicketTags: List<String>? = null
            private var internalSalesStatus: InternalSalesStatus? = null
            private var createdAt: OffsetDateTime? = null
            private var updatedAt: OffsetDateTime? = null
            private var createdBy: CreatedBy? = null
            private var updatedBy: UpdatedBy? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(agent: Agent) = apply {
                this.id = agent.id
                this.name = agent.name
                this.brandColor = agent.brandColor
                this.organizationId = agent.organizationId
                this.persona = agent.persona
                this.additionalPromptText = agent.additionalPromptText
                this.popularQuestions = agent.popularQuestions
                this.bailoutType = agent.bailoutType
                this.bailoutText = agent.bailoutText
                this.bailoutIntegration = agent.bailoutIntegration
                this.hiddenTicketTags = agent.hiddenTicketTags
                this.internalSalesStatus = agent.internalSalesStatus
                this.createdAt = agent.createdAt
                this.updatedAt = agent.updatedAt
                this.createdBy = agent.createdBy
                this.updatedBy = agent.updatedBy
                additionalProperties(agent.additionalProperties)
            }

            @JsonProperty("id")
            fun id(id: String) = apply {
                this.id = id
            }

            @JsonProperty("name")
            fun name(name: String) = apply {
                this.name = name
            }

            @JsonProperty("brandColor")
            fun brandColor(brandColor: String) = apply {
                this.brandColor = brandColor
            }

            @JsonProperty("organizationId")
            fun organizationId(organizationId: String) = apply {
                this.organizationId = organizationId
            }

            @JsonProperty("persona")
            fun persona(persona: Persona) = apply {
                this.persona = persona
            }

            @JsonProperty("additionalPromptText")
            fun additionalPromptText(additionalPromptText: String) = apply {
                this.additionalPromptText = additionalPromptText
            }

            @JsonProperty("popularQuestions")
            fun popularQuestions(popularQuestions: List<String>) = apply {
                this.popularQuestions = popularQuestions
            }

            @JsonProperty("bailoutType")
            fun bailoutType(bailoutType: BailoutType) = apply {
                this.bailoutType = bailoutType
            }

            @JsonProperty("bailoutText")
            fun bailoutText(bailoutText: String) = apply {
                this.bailoutText = bailoutText
            }

            @JsonProperty("bailoutIntegration")
            fun bailoutIntegration(bailoutIntegration: BailoutIntegration) = apply {
                this.bailoutIntegration = bailoutIntegration
            }

            @JsonProperty("hiddenTicketTags")
            fun hiddenTicketTags(hiddenTicketTags: List<String>) = apply {
                this.hiddenTicketTags = hiddenTicketTags
            }

            @JsonProperty("internal__salesStatus")
            fun internalSalesStatus(internalSalesStatus: InternalSalesStatus) = apply {
                this.internalSalesStatus = internalSalesStatus
            }

            @JsonProperty("createdAt")
            fun createdAt(createdAt: OffsetDateTime) = apply {
                this.createdAt = createdAt
            }

            @JsonProperty("updatedAt")
            fun updatedAt(updatedAt: OffsetDateTime) = apply {
                this.updatedAt = updatedAt
            }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply {
                this.createdBy = createdBy
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

            fun build(): Agent = Agent(
                id,
                name,
                brandColor,
                organizationId,
                persona,
                additionalPromptText,
                popularQuestions?.toUnmodifiable(),
                bailoutType,
                bailoutText,
                bailoutIntegration,
                hiddenTicketTags?.toUnmodifiable(),
                internalSalesStatus,
                createdAt,
                updatedAt,
                createdBy,
                updatedBy,
                additionalProperties.toUnmodifiable(),
            )
        }

        class BailoutIntegration @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is BailoutIntegration &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val SALESFORCE = BailoutIntegration(JsonField.of("SALESFORCE"))

                val ZENDESK = BailoutIntegration(JsonField.of("ZENDESK"))

                val FRESHDESK = BailoutIntegration(JsonField.of("FRESHDESK"))

                val SLACK_QA_BOT = BailoutIntegration(JsonField.of("SLACK_QA_BOT"))

                val TWILIO = BailoutIntegration(JsonField.of("TWILIO"))

                fun of(value: String) = BailoutIntegration(JsonField.of(value))
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

            fun value(): Value = when (this) {
                SALESFORCE -> Value.SALESFORCE
                ZENDESK -> Value.ZENDESK
                FRESHDESK -> Value.FRESHDESK
                SLACK_QA_BOT -> Value.SLACK_QA_BOT
                TWILIO -> Value.TWILIO
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                SALESFORCE -> Known.SALESFORCE
                ZENDESK -> Known.ZENDESK
                FRESHDESK -> Known.FRESHDESK
                SLACK_QA_BOT -> Known.SLACK_QA_BOT
                TWILIO -> Known.TWILIO
                else -> throw SamInvalidDataException("Unknown BailoutIntegration: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
        }

        class BailoutType @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is BailoutType &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val INTEGRATION = BailoutType(JsonField.of("INTEGRATION"))

                val TEXT = BailoutType(JsonField.of("TEXT"))

                fun of(value: String) = BailoutType(JsonField.of(value))
            }

            enum class Known {
                INTEGRATION,
                TEXT,
            }

            enum class Value {
                INTEGRATION,
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                INTEGRATION -> Value.INTEGRATION
                TEXT -> Value.TEXT
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                INTEGRATION -> Known.INTEGRATION
                TEXT -> Known.TEXT
                else -> throw SamInvalidDataException("Unknown BailoutType: $value")
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

        class InternalSalesStatus @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is InternalSalesStatus &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val LIVE = InternalSalesStatus(JsonField.of("LIVE"))

                val ONBOARDING = InternalSalesStatus(JsonField.of("ONBOARDING"))

                val PROSPECT = InternalSalesStatus(JsonField.of("PROSPECT"))

                val TESTING = InternalSalesStatus(JsonField.of("TESTING"))

                val Z_INACTIVE = InternalSalesStatus(JsonField.of("Z_INACTIVE"))

                fun of(value: String) = InternalSalesStatus(JsonField.of(value))
            }

            enum class Known {
                LIVE,
                ONBOARDING,
                PROSPECT,
                TESTING,
                Z_INACTIVE,
            }

            enum class Value {
                LIVE,
                ONBOARDING,
                PROSPECT,
                TESTING,
                Z_INACTIVE,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                LIVE -> Value.LIVE
                ONBOARDING -> Value.ONBOARDING
                PROSPECT -> Value.PROSPECT
                TESTING -> Value.TESTING
                Z_INACTIVE -> Value.Z_INACTIVE
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                LIVE -> Known.LIVE
                ONBOARDING -> Known.ONBOARDING
                PROSPECT -> Known.PROSPECT
                TESTING -> Known.TESTING
                Z_INACTIVE -> Known.Z_INACTIVE
                else -> throw SamInvalidDataException("Unknown InternalSalesStatus: $value")
            }

            fun asString(): String = _value().asStringOrThrow()
        }

        class Persona @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue
            fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is Persona &&
                  this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val ANY = Persona(JsonField.of("ANY"))

                val CASUAL_BUDDY = Persona(JsonField.of("CASUAL_BUDDY"))

                val EMPATHETIC_SUPPORTER = Persona(JsonField.of("EMPATHETIC_SUPPORTER"))

                val FORMAL_PROFESSIONAL = Persona(JsonField.of("FORMAL_PROFESSIONAL"))

                val CONCISE_EXPERT = Persona(JsonField.of("CONCISE_EXPERT"))

                val ENTHUSIASTIC_HELPER = Persona(JsonField.of("ENTHUSIASTIC_HELPER"))

                val PATIENT_EDUCATOR = Persona(JsonField.of("PATIENT_EDUCATOR"))

                val PIRATE = Persona(JsonField.of("PIRATE"))

                fun of(value: String) = Persona(JsonField.of(value))
            }

            enum class Known {
                ANY,
                CASUAL_BUDDY,
                EMPATHETIC_SUPPORTER,
                FORMAL_PROFESSIONAL,
                CONCISE_EXPERT,
                ENTHUSIASTIC_HELPER,
                PATIENT_EDUCATOR,
                PIRATE,
            }

            enum class Value {
                ANY,
                CASUAL_BUDDY,
                EMPATHETIC_SUPPORTER,
                FORMAL_PROFESSIONAL,
                CONCISE_EXPERT,
                ENTHUSIASTIC_HELPER,
                PATIENT_EDUCATOR,
                PIRATE,
                _UNKNOWN,
            }

            fun value(): Value = when (this) {
                ANY -> Value.ANY
                CASUAL_BUDDY -> Value.CASUAL_BUDDY
                EMPATHETIC_SUPPORTER -> Value.EMPATHETIC_SUPPORTER
                FORMAL_PROFESSIONAL -> Value.FORMAL_PROFESSIONAL
                CONCISE_EXPERT -> Value.CONCISE_EXPERT
                ENTHUSIASTIC_HELPER -> Value.ENTHUSIASTIC_HELPER
                PATIENT_EDUCATOR -> Value.PATIENT_EDUCATOR
                PIRATE -> Value.PIRATE
                else -> Value._UNKNOWN
            }

            fun known(): Known = when (this) {
                ANY -> Known.ANY
                CASUAL_BUDDY -> Known.CASUAL_BUDDY
                EMPATHETIC_SUPPORTER -> Known.EMPATHETIC_SUPPORTER
                FORMAL_PROFESSIONAL -> Known.FORMAL_PROFESSIONAL
                CONCISE_EXPERT -> Known.CONCISE_EXPERT
                ENTHUSIASTIC_HELPER -> Known.ENTHUSIASTIC_HELPER
                PATIENT_EDUCATOR -> Known.PATIENT_EDUCATOR
                PIRATE -> Known.PIRATE
                else -> throw SamInvalidDataException("Unknown Persona: $value")
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
}
