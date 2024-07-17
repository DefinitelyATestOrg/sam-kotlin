// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Lockbox
import software.elborai.api.models.LockboxCreateParams
import software.elborai.api.models.LockboxListPage
import software.elborai.api.models.LockboxListParams
import software.elborai.api.models.LockboxRetrieveParams
import software.elborai.api.models.LockboxUpdateParams

interface LockboxService {

    /** Create a Lockbox */
    fun create(
        params: LockboxCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lockbox

    /** Retrieve a Lockbox */
    fun retrieve(
        params: LockboxRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lockbox

    /** Update a Lockbox */
    fun update(
        params: LockboxUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Lockbox

    /** List Lockboxes */
    fun list(
        params: LockboxListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LockboxListPage
}
