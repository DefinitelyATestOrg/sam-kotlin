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
import me.elborai.api.core.immutableEmptyMap
import me.elborai.api.core.toImmutable

@NoAutoDetect
class User
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<Long> = JsonMissing.of(),
    @JsonProperty("username")
    @ExcludeMissing
    private val username: JsonField<String> = JsonMissing.of(),
    @JsonProperty("firstName")
    @ExcludeMissing
    private val firstName: JsonField<String> = JsonMissing.of(),
    @JsonProperty("lastName")
    @ExcludeMissing
    private val lastName: JsonField<String> = JsonMissing.of(),
    @JsonProperty("email") @ExcludeMissing private val email: JsonField<String> = JsonMissing.of(),
    @JsonProperty("password")
    @ExcludeMissing
    private val password: JsonField<String> = JsonMissing.of(),
    @JsonProperty("phone") @ExcludeMissing private val phone: JsonField<String> = JsonMissing.of(),
    @JsonProperty("userStatus")
    @ExcludeMissing
    private val userStatus: JsonField<Long> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): Long? = id.getNullable("id")

    fun username(): String? = username.getNullable("username")

    fun firstName(): String? = firstName.getNullable("firstName")

    fun lastName(): String? = lastName.getNullable("lastName")

    fun email(): String? = email.getNullable("email")

    fun password(): String? = password.getNullable("password")

    fun phone(): String? = phone.getNullable("phone")

    /** User Status */
    fun userStatus(): Long? = userStatus.getNullable("userStatus")

    @JsonProperty("id") @ExcludeMissing fun _id() = id

    @JsonProperty("username") @ExcludeMissing fun _username() = username

    @JsonProperty("firstName") @ExcludeMissing fun _firstName() = firstName

    @JsonProperty("lastName") @ExcludeMissing fun _lastName() = lastName

    @JsonProperty("email") @ExcludeMissing fun _email() = email

    @JsonProperty("password") @ExcludeMissing fun _password() = password

    @JsonProperty("phone") @ExcludeMissing fun _phone() = phone

    /** User Status */
    @JsonProperty("userStatus") @ExcludeMissing fun _userStatus() = userStatus

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): User = apply {
        if (!validated) {
            id()
            username()
            firstName()
            lastName()
            email()
            password()
            phone()
            userStatus()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<Long> = JsonMissing.of()
        private var username: JsonField<String> = JsonMissing.of()
        private var firstName: JsonField<String> = JsonMissing.of()
        private var lastName: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var password: JsonField<String> = JsonMissing.of()
        private var phone: JsonField<String> = JsonMissing.of()
        private var userStatus: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(user: User) = apply {
            id = user.id
            username = user.username
            firstName = user.firstName
            lastName = user.lastName
            email = user.email
            password = user.password
            phone = user.phone
            userStatus = user.userStatus
            additionalProperties = user.additionalProperties.toMutableMap()
        }

        fun id(id: Long) = id(JsonField.of(id))

        fun id(id: JsonField<Long>) = apply { this.id = id }

        fun username(username: String) = username(JsonField.of(username))

        fun username(username: JsonField<String>) = apply { this.username = username }

        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        fun email(email: String) = email(JsonField.of(email))

        fun email(email: JsonField<String>) = apply { this.email = email }

        fun password(password: String) = password(JsonField.of(password))

        fun password(password: JsonField<String>) = apply { this.password = password }

        fun phone(phone: String) = phone(JsonField.of(phone))

        fun phone(phone: JsonField<String>) = apply { this.phone = phone }

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

        fun build(): User =
            User(
                id,
                username,
                firstName,
                lastName,
                email,
                password,
                phone,
                userStatus,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is User && id == other.id && username == other.username && firstName == other.firstName && lastName == other.lastName && email == other.email && password == other.password && phone == other.phone && userStatus == other.userStatus && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, username, firstName, lastName, email, password, phone, userStatus, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "User{id=$id, username=$username, firstName=$firstName, lastName=$lastName, email=$email, password=$password, phone=$phone, userStatus=$userStatus, additionalProperties=$additionalProperties}"
}
