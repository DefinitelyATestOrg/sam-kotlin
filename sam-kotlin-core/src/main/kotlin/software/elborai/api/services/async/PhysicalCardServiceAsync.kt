// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.PhysicalCard
import software.elborai.api.models.PhysicalCardCreateParams
import software.elborai.api.models.PhysicalCardListPageAsync
import software.elborai.api.models.PhysicalCardListParams
import software.elborai.api.models.PhysicalCardRetrieveParams
import software.elborai.api.models.PhysicalCardUpdateParams

interface PhysicalCardServiceAsync {

    /** Create a Physical Card */
    suspend fun create(
        params: PhysicalCardCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCard

    /** Retrieve a Physical Card */
    suspend fun retrieve(
        params: PhysicalCardRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCard

    /** Update a Physical Card */
    suspend fun update(
        params: PhysicalCardUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCard

    /** List Physical Cards */
    suspend fun list(
        params: PhysicalCardListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardListPageAsync
}
