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

class UserUpdateParams constructor(
  private val pathUsername: String,
  private val id: Long?,
  private val email: String?,
  private val firstName: String?,
  private val lastName: String?,
  private val password: String?,
  private val phone: String?,
  private val bodyUsername: String?,
  private val userStatus: Long?,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun pathUsername(): String = pathUsername

    fun id(): Long? = id

    fun email(): String? = email

    fun firstName(): String? = firstName

    fun lastName(): String? = lastName

    fun password(): String? = password

    fun phone(): String? = phone

    fun bodyUsername(): String? = bodyUsername

    fun userStatus(): Long? = userStatus

    internal fun getBody(): UserUpdateBody {
      return UserUpdateBody(
          id,
          email,
          firstName,
          lastName,
          password,
          phone,
          bodyUsername,
          userStatus,
          additionalBodyProperties,
      )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> pathUsername
          else -> ""
      }
    }

    @JsonDeserialize(builder = UserUpdateBody.Builder::class)
    @NoAutoDetect
    class UserUpdateBody internal constructor(
      private val id: Long?,
      private val email: String?,
      private val firstName: String?,
      private val lastName: String?,
      private val password: String?,
      private val phone: String?,
      private val bodyUsername: String?,
      private val userStatus: Long?,
      private val additionalProperties: Map<String, JsonValue>,

    ) {

        private var hashCode: Int = 0

        @JsonProperty("id")
        fun id(): Long? = id

        @JsonProperty("email")
        fun email(): String? = email

        @JsonProperty("firstName")
        fun firstName(): String? = firstName

        @JsonProperty("lastName")
        fun lastName(): String? = lastName

        @JsonProperty("password")
        fun password(): String? = password

        @JsonProperty("phone")
        fun phone(): String? = phone

        @JsonProperty("username")
        fun bodyUsername(): String? = bodyUsername

        /** User Status */
        @JsonProperty("userStatus")
        fun userStatus(): Long? = userStatus

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is UserUpdateBody &&
              this.id == other.id &&
              this.email == other.email &&
              this.firstName == other.firstName &&
              this.lastName == other.lastName &&
              this.password == other.password &&
              this.phone == other.phone &&
              this.bodyUsername == other.bodyUsername &&
              this.userStatus == other.userStatus &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(
                id,
                email,
                firstName,
                lastName,
                password,
                phone,
                bodyUsername,
                userStatus,
                additionalProperties,
            )
          }
          return hashCode
        }

        override fun toString() = "UserUpdateBody{id=$id, email=$email, firstName=$firstName, lastName=$lastName, password=$password, phone=$phone, bodyUsername=$bodyUsername, userStatus=$userStatus, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: Long? = null
            private var email: String? = null
            private var firstName: String? = null
            private var lastName: String? = null
            private var password: String? = null
            private var phone: String? = null
            private var bodyUsername: String? = null
            private var userStatus: Long? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(userUpdateBody: UserUpdateBody) = apply {
                this.id = userUpdateBody.id
                this.email = userUpdateBody.email
                this.firstName = userUpdateBody.firstName
                this.lastName = userUpdateBody.lastName
                this.password = userUpdateBody.password
                this.phone = userUpdateBody.phone
                this.bodyUsername = userUpdateBody.bodyUsername
                this.userStatus = userUpdateBody.userStatus
                additionalProperties(userUpdateBody.additionalProperties)
            }

            @JsonProperty("id")
            fun id(id: Long) = apply {
                this.id = id
            }

            @JsonProperty("email")
            fun email(email: String) = apply {
                this.email = email
            }

            @JsonProperty("firstName")
            fun firstName(firstName: String) = apply {
                this.firstName = firstName
            }

            @JsonProperty("lastName")
            fun lastName(lastName: String) = apply {
                this.lastName = lastName
            }

            @JsonProperty("password")
            fun password(password: String) = apply {
                this.password = password
            }

            @JsonProperty("phone")
            fun phone(phone: String) = apply {
                this.phone = phone
            }

            @JsonProperty("username")
            fun bodyUsername(bodyUsername: String) = apply {
                this.bodyUsername = bodyUsername
            }

            /** User Status */
            @JsonProperty("userStatus")
            fun userStatus(userStatus: Long) = apply {
                this.userStatus = userStatus
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

            fun build(): UserUpdateBody = UserUpdateBody(
                id,
                email,
                firstName,
                lastName,
                password,
                phone,
                bodyUsername,
                userStatus,
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

      return other is UserUpdateParams &&
          this.pathUsername == other.pathUsername &&
          this.id == other.id &&
          this.email == other.email &&
          this.firstName == other.firstName &&
          this.lastName == other.lastName &&
          this.password == other.password &&
          this.phone == other.phone &&
          this.bodyUsername == other.bodyUsername &&
          this.userStatus == other.userStatus &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          pathUsername,
          id,
          email,
          firstName,
          lastName,
          password,
          phone,
          bodyUsername,
          userStatus,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "UserUpdateParams{pathUsername=$pathUsername, id=$id, email=$email, firstName=$firstName, lastName=$lastName, password=$password, phone=$phone, bodyUsername=$bodyUsername, userStatus=$userStatus, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var pathUsername: String? = null
        private var id: Long? = null
        private var email: String? = null
        private var firstName: String? = null
        private var lastName: String? = null
        private var password: String? = null
        private var phone: String? = null
        private var bodyUsername: String? = null
        private var userStatus: Long? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(userUpdateParams: UserUpdateParams) = apply {
            this.pathUsername = userUpdateParams.pathUsername
            this.id = userUpdateParams.id
            this.email = userUpdateParams.email
            this.firstName = userUpdateParams.firstName
            this.lastName = userUpdateParams.lastName
            this.password = userUpdateParams.password
            this.phone = userUpdateParams.phone
            this.bodyUsername = userUpdateParams.bodyUsername
            this.userStatus = userUpdateParams.userStatus
            additionalQueryParams(userUpdateParams.additionalQueryParams)
            additionalHeaders(userUpdateParams.additionalHeaders)
            additionalBodyProperties(userUpdateParams.additionalBodyProperties)
        }

        fun pathUsername(pathUsername: String) = apply {
            this.pathUsername = pathUsername
        }

        fun id(id: Long) = apply {
            this.id = id
        }

        fun email(email: String) = apply {
            this.email = email
        }

        fun firstName(firstName: String) = apply {
            this.firstName = firstName
        }

        fun lastName(lastName: String) = apply {
            this.lastName = lastName
        }

        fun password(password: String) = apply {
            this.password = password
        }

        fun phone(phone: String) = apply {
            this.phone = phone
        }

        fun bodyUsername(bodyUsername: String) = apply {
            this.bodyUsername = bodyUsername
        }

        /** User Status */
        fun userStatus(userStatus: Long) = apply {
            this.userStatus = userStatus
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

        fun build(): UserUpdateParams = UserUpdateParams(
            checkNotNull(pathUsername) {
                "`pathUsername` is required but was not set"
            },
            id,
            email,
            firstName,
            lastName,
            password,
            phone,
            bodyUsername,
            userStatus,
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }
}
