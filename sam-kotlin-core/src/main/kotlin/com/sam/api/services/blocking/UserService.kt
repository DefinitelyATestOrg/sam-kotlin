// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.blocking

import com.sam.api.core.RequestOptions
import com.sam.api.models.User
import com.sam.api.models.UserCreateParams
import com.sam.api.models.UserCreateWithListParams
import com.sam.api.models.UserDeleteParams
import com.sam.api.models.UserLoginParams
import com.sam.api.models.UserLogoutParams
import com.sam.api.models.UserRetrieveParams
import com.sam.api.models.UserUpdateParams

interface UserService {

    /** This can only be done by the logged in user. */
    fun create(
        params: UserCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /** Get user by user name */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /** This can only be done by the logged in user. */
    fun update(params: UserUpdateParams, requestOptions: RequestOptions = RequestOptions.none())

    /** This can only be done by the logged in user. */
    fun delete(params: UserDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Creates list of users with given input array */
    fun createWithList(
        params: UserCreateWithListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /** Logs user into the system */
    fun login(
        params: UserLoginParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): String

    /** Logs out current logged in user session */
    fun logout(params: UserLogoutParams, requestOptions: RequestOptions = RequestOptions.none())
}
