// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.RequestOptions
import me.elborai.api.models.User
import me.elborai.api.models.UserCreateListParams
import me.elborai.api.models.UserCreateParams
import me.elborai.api.models.UserDeleteParams
import me.elborai.api.models.UserLoginParams
import me.elborai.api.models.UserLogoutParams
import me.elborai.api.models.UserRetrieveParams
import me.elborai.api.models.UserUpdateParams

interface UserService {

    /** This can only be done by the logged in user. */
    fun create(
        params: UserCreateParams = UserCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** This can only be done by the logged in user. */
    fun create(requestOptions: RequestOptions): User =
        create(UserCreateParams.none(), requestOptions)

    /** Get user by user name */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** This can only be done by the logged in user. */
    fun update(params: UserUpdateParams, requestOptions: RequestOptions = RequestOptions.none())

    /** This can only be done by the logged in user. */
    fun delete(params: UserDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Creates list of users with given input array */
    fun createList(
        params: UserCreateListParams = UserCreateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /** Creates list of users with given input array */
    fun createList(requestOptions: RequestOptions): User =
        createList(UserCreateListParams.none(), requestOptions)

    /** Logs user into the system */
    fun login(
        params: UserLoginParams = UserLoginParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): String

    /** Logs user into the system */
    fun login(requestOptions: RequestOptions): String =
        login(UserLoginParams.none(), requestOptions)

    /** Logs out current logged in user session */
    fun logout(
        params: UserLogoutParams = UserLogoutParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Logs out current logged in user session */
    fun logout(requestOptions: RequestOptions) = logout(UserLogoutParams.none(), requestOptions)
}
