// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.User
import software.elborai.api.models.UserCreateParams
import software.elborai.api.models.UserCreateWithListParams
import software.elborai.api.models.UserDeleteParams
import software.elborai.api.models.UserLoginParams
import software.elborai.api.models.UserLogoutParams
import software.elborai.api.models.UserRetrieveParams
import software.elborai.api.models.UserUpdateParams

interface UserServiceAsync {

    /** This can only be done by the logged in user. */
    suspend fun create(
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    /** Get user by user name */
    suspend fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /** This can only be done by the logged in user. */
    suspend fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    /** This can only be done by the logged in user. */
    suspend fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )

    /** Creates list of users with given input array */
    suspend fun createWithList(
        params: UserCreateWithListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /** Logs user into the system */
    suspend fun login(
        params: UserLoginParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): String

    /** Logs out current logged in user session */
    suspend fun logout(
        params: UserLogoutParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}
