// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Lockbox
import software.elborai.api.models.LockboxCreateParams
import software.elborai.api.models.LockboxListPageAsync
import software.elborai.api.models.LockboxListParams
import software.elborai.api.models.LockboxRetrieveParams
import software.elborai.api.models.LockboxUpdateParams

interface LockboxServiceAsync {

    /** Create a Lockbox */
    suspend fun create(
        params: LockboxCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lockbox

    /** Retrieve a Lockbox */
    suspend fun retrieve(
        params: LockboxRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lockbox

    /** Update a Lockbox */
    suspend fun update(
        params: LockboxUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lockbox

    /** List Lockboxes */
    suspend fun list(
        params: LockboxListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LockboxListPageAsync
}
