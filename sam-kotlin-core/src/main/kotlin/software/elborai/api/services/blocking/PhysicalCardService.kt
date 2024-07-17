// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.PhysicalCard
import software.elborai.api.models.PhysicalCardCreateParams
import software.elborai.api.models.PhysicalCardListPage
import software.elborai.api.models.PhysicalCardListParams
import software.elborai.api.models.PhysicalCardRetrieveParams
import software.elborai.api.models.PhysicalCardUpdateParams

interface PhysicalCardService {

    /** Create a Physical Card */
    fun create(
        params: PhysicalCardCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCard

    /** Retrieve a Physical Card */
    fun retrieve(
        params: PhysicalCardRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCard

    /** Update a Physical Card */
    fun update(
        params: PhysicalCardUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCard

    /** List Physical Cards */
    fun list(
        params: PhysicalCardListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardListPage
}
