// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import me.elborai.api.core.ExcludeMissing
import me.elborai.api.core.JsonField
import me.elborai.api.core.JsonMissing
import me.elborai.api.core.JsonValue
import me.elborai.api.core.NoAutoDetect
import me.elborai.api.core.Params
import me.elborai.api.core.checkRequired
import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.QueryParams
import me.elborai.api.core.immutableEmptyMap
import me.elborai.api.core.toImmutable

/** This can only be done by the logged in user. */
class UserUpdateParams
private constructor(
    private val username1: String,
    private val body: UserUpdateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun username1(): String = username1

    fun id(): Long? = body.id()

    fun email(): String? = body.email()

    fun firstName(): String? = body.firstName()

    fun lastName(): String? = body.lastName()

    fun password(): String? = body.password()

    fun phone(): String? = body.phone()

    fun username2(): String? = body.username2()

    /** User Status */
    fun userStatus(): Long? = body.userStatus()

    fun _id(): JsonField<Long> = body._id()

    fun _email(): JsonField<String> = body._email()

    fun _firstName(): JsonField<String> = body._firstName()

    fun _lastName(): JsonField<String> = body._lastName()

    fun _password(): JsonField<String> = body._password()

    fun _phone(): JsonField<String> = body._phone()

    fun _username2(): JsonField<String> = body._username2()

    /** User Status */
    fun _userStatus(): JsonField<Long> = body._userStatus()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    internal fun _body(): UserUpdateBody = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> username1
            else -> ""
        }
    }

    @NoAutoDetect
    class UserUpdateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("id") @ExcludeMissing private val id: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("email")
        @ExcludeMissing
        private val email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("firstName")
        @ExcludeMissing
        private val firstName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("lastName")
        @ExcludeMissing
        private val lastName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("password")
        @ExcludeMissing
        private val password: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone")
        @ExcludeMissing
        private val phone: JsonField<String> = JsonMissing.of(),
        @JsonProperty("username")
        @ExcludeMissing
        private val username2: JsonField<String> = JsonMissing.of(),
        @JsonProperty("userStatus")
        @ExcludeMissing
        private val userStatus: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun id(): Long? = id.getNullable("id")

        fun email(): String? = email.getNullable("email")

        fun firstName(): String? = firstName.getNullable("firstName")

        fun lastName(): String? = lastName.getNullable("lastName")

        fun password(): String? = password.getNullable("password")

        fun phone(): String? = phone.getNullable("phone")

        fun username2(): String? = username2.getNullable("username")

        /** User Status */
        fun userStatus(): Long? = userStatus.getNullable("userStatus")

        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Long> = id

        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        @JsonProperty("firstName") @ExcludeMissing fun _firstName(): JsonField<String> = firstName

        @JsonProperty("lastName") @ExcludeMissing fun _lastName(): JsonField<String> = lastName

        @JsonProperty("password") @ExcludeMissing fun _password(): JsonField<String> = password

        @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

        @JsonProperty("username") @ExcludeMissing fun _username2(): JsonField<String> = username2

        /** User Status */
        @JsonProperty("userStatus") @ExcludeMissing fun _userStatus(): JsonField<Long> = userStatus

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): UserUpdateBody = apply {
            if (validated) {
                return@apply
            }

            id()
            email()
            firstName()
            lastName()
            password()
            phone()
            username2()
            userStatus()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            fun builder() = Builder()
        }

        /** A builder for [UserUpdateBody]. */
        class Builder internal constructor() {

            private var id: JsonField<Long> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var firstName: JsonField<String> = JsonMissing.of()
            private var lastName: JsonField<String> = JsonMissing.of()
            private var password: JsonField<String> = JsonMissing.of()
            private var phone: JsonField<String> = JsonMissing.of()
            private var username2: JsonField<String> = JsonMissing.of()
            private var userStatus: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(userUpdateBody: UserUpdateBody) = apply {
                id = userUpdateBody.id
                email = userUpdateBody.email
                firstName = userUpdateBody.firstName
                lastName = userUpdateBody.lastName
                password = userUpdateBody.password
                phone = userUpdateBody.phone
                username2 = userUpdateBody.username2
                userStatus = userUpdateBody.userStatus
                additionalProperties = userUpdateBody.additionalProperties.toMutableMap()
            }

            fun id(id: Long) = id(JsonField.of(id))

            fun id(id: JsonField<Long>) = apply { this.id = id }

            fun email(email: String) = email(JsonField.of(email))

            fun email(email: JsonField<String>) = apply { this.email = email }

            fun firstName(firstName: String) = firstName(JsonField.of(firstName))

            fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

            fun lastName(lastName: String) = lastName(JsonField.of(lastName))

            fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

            fun password(password: String) = password(JsonField.of(password))

            fun password(password: JsonField<String>) = apply { this.password = password }

            fun phone(phone: String) = phone(JsonField.of(phone))

            fun phone(phone: JsonField<String>) = apply { this.phone = phone }

            fun username2(username2: String) = username2(JsonField.of(username2))

            fun username2(username2: JsonField<String>) = apply { this.username2 = username2 }

            /** User Status */
            fun userStatus(userStatus: Long) = userStatus(JsonField.of(userStatus))

            /** User Status */
            fun userStatus(userStatus: JsonField<Long>) = apply { this.userStatus = userStatus }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): UserUpdateBody =
                UserUpdateBody(
                    id,
                    email,
                    firstName,
                    lastName,
                    password,
                    phone,
                    username2,
                    userStatus,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UserUpdateBody && id == other.id && email == other.email && firstName == other.firstName && lastName == other.lastName && password == other.password && phone == other.phone && username2 == other.username2 && userStatus == other.userStatus && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, email, firstName, lastName, password, phone, username2, userStatus, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UserUpdateBody{id=$id, email=$email, firstName=$firstName, lastName=$lastName, password=$password, phone=$phone, username2=$username2, userStatus=$userStatus, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    /** A builder for [UserUpdateParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var username1: String? = null
        private var body: UserUpdateBody.Builder = UserUpdateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(userUpdateParams: UserUpdateParams) = apply {
            username1 = userUpdateParams.username1
            body = userUpdateParams.body.toBuilder()
            additionalHeaders = userUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = userUpdateParams.additionalQueryParams.toBuilder()
        }

        fun username1(username1: String) = apply { this.username1 = username1 }

        fun id(id: Long) = apply { body.id(id) }

        fun id(id: JsonField<Long>) = apply { body.id(id) }

        fun email(email: String) = apply { body.email(email) }

        fun email(email: JsonField<String>) = apply { body.email(email) }

        fun firstName(firstName: String) = apply { body.firstName(firstName) }

        fun firstName(firstName: JsonField<String>) = apply { body.firstName(firstName) }

        fun lastName(lastName: String) = apply { body.lastName(lastName) }

        fun lastName(lastName: JsonField<String>) = apply { body.lastName(lastName) }

        fun password(password: String) = apply { body.password(password) }

        fun password(password: JsonField<String>) = apply { body.password(password) }

        fun phone(phone: String) = apply { body.phone(phone) }

        fun phone(phone: JsonField<String>) = apply { body.phone(phone) }

        fun username2(username2: String) = apply { body.username2(username2) }

        fun username2(username2: JsonField<String>) = apply { body.username2(username2) }

        /** User Status */
        fun userStatus(userStatus: Long) = apply { body.userStatus(userStatus) }

        /** User Status */
        fun userStatus(userStatus: JsonField<Long>) = apply { body.userStatus(userStatus) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun build(): UserUpdateParams =
            UserUpdateParams(
                checkRequired("username1", username1),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserUpdateParams && username1 == other.username1 && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(username1, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserUpdateParams{username1=$username1, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
