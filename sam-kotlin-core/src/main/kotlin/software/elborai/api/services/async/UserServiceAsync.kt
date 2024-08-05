// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.LazyThreadSafetyMode.PUBLICATION
import java.time.LocalDate
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.stream.Stream
import software.elborai.api.core.Enum
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.User
import software.elborai.api.models.UserCreateParams
import software.elborai.api.models.UserCreateWithListParams
import software.elborai.api.models.UserDeleteParams
import software.elborai.api.models.UserLoginParams
import software.elborai.api.models.UserLogoutParams
import software.elborai.api.models.UserRetrieveParams
import software.elborai.api.models.UserUpdateParams
import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.RequestOptions
import software.elborai.api.errors.SamError
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.multipartFormData
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler

interface UserServiceAsync {

    /** This can only be done by the logged in user. */
    suspend fun create(params: UserCreateParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Get user by user name */
    suspend fun retrieve(params: UserRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** This can only be done by the logged in user. */
    suspend fun update(params: UserUpdateParams, requestOptions: RequestOptions = RequestOptions.none())

    /** This can only be done by the logged in user. */
    suspend fun delete(params: UserDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Creates list of users with given input array */
    suspend fun createWithList(params: UserCreateWithListParams, requestOptions: RequestOptions = RequestOptions.none()): User

    /** Logs user into the system */
    suspend fun login(params: UserLoginParams, requestOptions: RequestOptions = RequestOptions.none()): String

    /** Logs out current logged in user session */
    suspend fun logout(params: UserLogoutParams, requestOptions: RequestOptions = RequestOptions.none())
}
