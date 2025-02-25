// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.core.RequestOptions
import me.elborai.api.models.User
import me.elborai.api.models.UserCreateListParams
import me.elborai.api.models.UserCreateParams
import me.elborai.api.models.UserDeleteParams
import me.elborai.api.models.UserLoginParams
import me.elborai.api.models.UserLogoutParams
import me.elborai.api.models.UserRetrieveParams
import me.elborai.api.models.UserUpdateParams

interface UserServiceAsync {

    /** This can only be done by the logged in user. */
    suspend fun create(
        params: UserCreateParams = UserCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** This can only be done by the logged in user. */
    suspend fun create(requestOptions: RequestOptions): User =
        create(UserCreateParams.none(), requestOptions)

    /** Get user by user name */
    suspend fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** This can only be done by the logged in user. */
    suspend fun update(
        params: UserUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** This can only be done by the logged in user. */
    suspend fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Creates list of users with given input array */
    suspend fun createList(
        params: UserCreateListParams = UserCreateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** Creates list of users with given input array */
    suspend fun createList(requestOptions: RequestOptions): User =
        createList(UserCreateListParams.none(), requestOptions)

    /** Logs user into the system */
    suspend fun login(
        params: UserLoginParams = UserLoginParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Logs user into the system */
    suspend fun login(requestOptions: RequestOptions): String =
        login(UserLoginParams.none(), requestOptions)

    /** Logs out current logged in user session */
    suspend fun logout(
        params: UserLogoutParams = UserLogoutParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Logs out current logged in user session */
    suspend fun logout(requestOptions: RequestOptions) =
        logout(UserLogoutParams.none(), requestOptions)
}
