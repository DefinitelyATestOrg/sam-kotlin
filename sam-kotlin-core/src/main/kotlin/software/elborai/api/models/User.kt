// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable

@JsonDeserialize(builder = User.Builder::class)
@NoAutoDetect
class User
private constructor(
    private val id: JsonField<Long>,
    private val username: JsonField<String>,
    private val firstName: JsonField<String>,
    private val lastName: JsonField<String>,
    private val email: JsonField<String>,
    private val password: JsonField<String>,
    private val phone: JsonField<String>,
    private val userStatus: JsonField<Long>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is User &&
            this.id == other.id &&
            this.username == other.username &&
            this.firstName == other.firstName &&
            this.lastName == other.lastName &&
            this.email == other.email &&
            this.password == other.password &&
            this.phone == other.phone &&
            this.userStatus == other.userStatus &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    id,
                    username,
                    firstName,
                    lastName,
                    email,
                    password,
                    phone,
                    userStatus,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "User{id=$id, username=$username, firstName=$firstName, lastName=$lastName, email=$email, password=$password, phone=$phone, userStatus=$userStatus, additionalProperties=$additionalProperties}"

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
            this.id = user.id
            this.username = user.username
            this.firstName = user.firstName
            this.lastName = user.lastName
            this.email = user.email
            this.password = user.password
            this.phone = user.phone
            this.userStatus = user.userStatus
            additionalProperties(user.additionalProperties)
        }

        fun id(id: Long) = id(JsonField.of(id))

        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<Long>) = apply { this.id = id }

        fun username(username: String) = username(JsonField.of(username))

        @JsonProperty("username")
        @ExcludeMissing
        fun username(username: JsonField<String>) = apply { this.username = username }

        fun firstName(firstName: String) = firstName(JsonField.of(firstName))

        @JsonProperty("firstName")
        @ExcludeMissing
        fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

        fun lastName(lastName: String) = lastName(JsonField.of(lastName))

        @JsonProperty("lastName")
        @ExcludeMissing
        fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

        fun email(email: String) = email(JsonField.of(email))

        @JsonProperty("email")
        @ExcludeMissing
        fun email(email: JsonField<String>) = apply { this.email = email }

        fun password(password: String) = password(JsonField.of(password))

        @JsonProperty("password")
        @ExcludeMissing
        fun password(password: JsonField<String>) = apply { this.password = password }

        fun phone(phone: String) = phone(JsonField.of(phone))

        @JsonProperty("phone")
        @ExcludeMissing
        fun phone(phone: JsonField<String>) = apply { this.phone = phone }

        /** User Status */
        fun userStatus(userStatus: Long) = userStatus(JsonField.of(userStatus))

        /** User Status */
        @JsonProperty("userStatus")
        @ExcludeMissing
        fun userStatus(userStatus: JsonField<Long>) = apply { this.userStatus = userStatus }

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
                additionalProperties.toUnmodifiable(),
            )
    }
}
